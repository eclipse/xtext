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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@'", "'('", "','", "')'", "'='", "'+'", "'{'", "'}'", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'>'", "'<'", "'->'", "'..'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'as'", "'.'", "'?.'", "'*.'", "'['", "'|'", "']'", "';'", "'if'", "'else'", "'switch'", "':'", "'default'", "'case'", "'for'", "'while'", "'do'", "'var'", "'val'", "'super'", "'::'", "'new'", "'false'", "'true'", "'null'", "'typeof'", "'throw'", "'return'", "'try'", "'finally'", "'catch'", "'=>'", "'?'", "'extends'", "'&'"
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

                        if ( (LA2_1==14||LA2_1==57) ) {
                            alt2=2;
                        }
                        else if ( (LA2_1==15) ) {
                            alt2=1;
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

                if ( (LA9_1==EOF||(LA9_1>=RULE_INT && LA9_1<=RULE_ID)||(LA9_1>=12 && LA9_1<=14)||(LA9_1>=16 && LA9_1<=41)||(LA9_1>=43 && LA9_1<=68)) ) {
                    alt9=2;
                }
                else if ( (LA9_1==15) ) {
                    alt9=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA9_0>=RULE_INT && LA9_0<=RULE_STRING)||LA9_0==12||(LA9_0>=16 && LA9_0<=17)||LA9_0==28||LA9_0==31||LA9_0==36||LA9_0==41||LA9_0==45||LA9_0==47||(LA9_0>=51 && LA9_0<=53)||LA9_0==56||(LA9_0>=58 && LA9_0<=65)) ) {
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
            else if ( ((LA22_0>=RULE_INT && LA22_0<=RULE_ID)||LA22_0==12||LA22_0==17||LA22_0==28||LA22_0==41||LA22_0==45||LA22_0==47||(LA22_0>=51 && LA22_0<=53)||LA22_0==56||(LA22_0>=58 && LA22_0<=65)) ) {
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1732:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* ) ;
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1735:28: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1736:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1736:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1737:5: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )*
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1745:1: ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )*
            loop32:
            do {
                int alt32=3;
                switch ( input.LA(1) ) {
                case 38:
                    {
                    int LA32_2 = input.LA(2);

                    if ( (synpred12_InternalXbaseWithAnnotations()) ) {
                        alt32=1;
                    }
                    else if ( (synpred13_InternalXbaseWithAnnotations()) ) {
                        alt32=2;
                    }


                    }
                    break;
                case 39:
                    {
                    int LA32_3 = input.LA(2);

                    if ( (synpred13_InternalXbaseWithAnnotations()) ) {
                        alt32=2;
                    }


                    }
                    break;
                case 40:
                    {
                    int LA32_4 = input.LA(2);

                    if ( (synpred13_InternalXbaseWithAnnotations()) ) {
                        alt32=2;
                    }


                    }
                    break;

                }

                switch (alt32) {
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
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1803:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1803:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1803:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1924:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    int alt30=2;
            	    alt30 = dfa30.predict(input);
            	    switch (alt30) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1924:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')'
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

            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1945:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?
            	            int alt29=3;
            	            alt29 = dfa29.predict(input);
            	            switch (alt29) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1945:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1945:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1945:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1962:1: (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1963:3: lv_memberCallArguments_17_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4762);
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
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1980:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1980:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1980:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1980:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1981:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1981:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1982:3: lv_memberCallArguments_18_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4790);
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

            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1998:2: (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    loop28:
            	                    do {
            	                        int alt28=2;
            	                        int LA28_0 = input.LA(1);

            	                        if ( (LA28_0==13) ) {
            	                            alt28=1;
            	                        }


            	                        switch (alt28) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1998:4: otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_19=(Token)match(input,13,FOLLOW_13_in_ruleXMemberFeatureCall4803); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	newLeafNode(otherlv_19, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2002:1: ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2003:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2003:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2004:3: lv_memberCallArguments_20_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0()); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4824);
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

            	            otherlv_21=(Token)match(input,14,FOLLOW_14_in_ruleXMemberFeatureCall4841); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_21, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2024:3: ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?
            	    int alt31=2;
            	    alt31 = dfa31.predict(input);
            	    switch (alt31) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2024:4: ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure )
            	            {
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2029:1: (lv_memberCallArguments_22_0= ruleXClosure )
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2030:3: lv_memberCallArguments_22_0= ruleXClosure
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall4874);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2054:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2055:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2056:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4914);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression4924); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2063:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) ;
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2066:28: ( (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2067:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2067:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            int alt33=13;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt33=1;
                }
                break;
            case 17:
                {
                alt33=2;
                }
                break;
            case 47:
                {
                alt33=3;
                }
                break;
            case RULE_ID:
            case 28:
            case 56:
                {
                alt33=4;
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
                alt33=5;
                }
                break;
            case 45:
                {
                alt33=6;
                }
                break;
            case 51:
                {
                alt33=7;
                }
                break;
            case 52:
                {
                alt33=8;
                }
                break;
            case 53:
                {
                alt33=9;
                }
                break;
            case 63:
                {
                alt33=10;
                }
                break;
            case 64:
                {
                alt33=11;
                }
                break;
            case 65:
                {
                alt33=12;
                }
                break;
            case 12:
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2068:5: this_XConstructorCall_0= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression4971);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2078:5: this_XBlockExpression_1= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression4998);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2088:5: this_XSwitchExpression_2= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression5025);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2098:5: this_XFeatureCall_3= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression5052);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2108:5: this_XLiteral_4= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression5079);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2118:5: this_XIfExpression_5= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression5106);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2128:5: this_XForLoopExpression_6= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression5133);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2138:5: this_XWhileExpression_7= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression5160);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2148:5: this_XDoWhileExpression_8= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression5187);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2158:5: this_XThrowExpression_9= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression5214);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2168:5: this_XReturnExpression_10= ruleXReturnExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXReturnExpressionParserRuleCall_10()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression5241);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2178:5: this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_11()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression5268);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2188:5: this_XParenthesizedExpression_12= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_12()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression5295);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2204:1: entryRuleXLiteral returns [EObject current=null] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final EObject entryRuleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2205:2: (iv_ruleXLiteral= ruleXLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2206:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXLiteral_in_entryRuleXLiteral5330);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXLiteral5340); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2213:1: ruleXLiteral returns [EObject current=null] : (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) ;
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2216:28: ( (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2217:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2217:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            int alt34=6;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt34=1;
                }
                break;
            case 59:
            case 60:
                {
                alt34=2;
                }
                break;
            case RULE_INT:
                {
                alt34=3;
                }
                break;
            case 61:
                {
                alt34=4;
                }
                break;
            case RULE_STRING:
                {
                alt34=5;
                }
                break;
            case 62:
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2218:5: this_XClosure_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXLiteral5387);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2228:5: this_XBooleanLiteral_1= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral5414);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2238:5: this_XIntLiteral_2= ruleXIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXIntLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIntLiteral_in_ruleXLiteral5441);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2248:5: this_XNullLiteral_3= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXLiteral5468);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2258:5: this_XStringLiteral_4= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXLiteral5495);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2268:5: this_XTypeLiteral_5= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXLiteral5522);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2284:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2285:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2286:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure5557);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure5567); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2293:1: ruleXClosure returns [EObject current=null] : ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) ;
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2296:28: ( ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2297:1: ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2297:1: ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2297:2: () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2297:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2298:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXClosureAccess().getXClosureAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleXClosure5613); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2307:1: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?
            int alt37=2;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2307:2: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2322:6: ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2322:7: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2322:7: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==RULE_ID||LA36_0==12||LA36_0==68) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2322:8: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2322:8: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2323:1: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2323:1: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2324:3: lv_declaredFormalParameters_2_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_2_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5684);
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

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2340:2: (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            loop35:
                            do {
                                int alt35=2;
                                int LA35_0 = input.LA(1);

                                if ( (LA35_0==13) ) {
                                    alt35=1;
                                }


                                switch (alt35) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2340:4: otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    {
                            	    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleXClosure5697); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_2_0_0_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2344:1: ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2345:1: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    {
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2345:1: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2346:3: lv_declaredFormalParameters_4_0= ruleJvmFormalParameter
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_2_0_0_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5718);
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2362:6: ( (lv_explicitSyntax_5_0= '|' ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2363:1: (lv_explicitSyntax_5_0= '|' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2363:1: (lv_explicitSyntax_5_0= '|' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2364:3: lv_explicitSyntax_5_0= '|'
                    {
                    lv_explicitSyntax_5_0=(Token)match(input,42,FOLLOW_42_in_ruleXClosure5740); if (state.failed) return current;
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2377:5: ( (lv_expression_6_0= ruleXExpressionInClosure ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2378:1: (lv_expression_6_0= ruleXExpressionInClosure )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2378:1: (lv_expression_6_0= ruleXExpressionInClosure )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2379:3: lv_expression_6_0= ruleXExpressionInClosure
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionInClosureParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpressionInClosure_in_ruleXClosure5777);
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

            otherlv_7=(Token)match(input,43,FOLLOW_43_in_ruleXClosure5789); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2407:1: entryRuleXExpressionInClosure returns [EObject current=null] : iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF ;
    public final EObject entryRuleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInClosure = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2408:2: (iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2409:2: iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure5825);
            iv_ruleXExpressionInClosure=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInClosure5835); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2416:1: ruleXExpressionInClosure returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* ) ;
    public final EObject ruleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2419:28: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2420:1: ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2420:1: ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2420:2: () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )*
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2420:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2421:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXExpressionInClosureAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2426:2: ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=RULE_INT && LA39_0<=RULE_ID)||LA39_0==12||(LA39_0>=16 && LA39_0<=17)||LA39_0==28||LA39_0==31||LA39_0==36||LA39_0==41||LA39_0==45||LA39_0==47||(LA39_0>=51 && LA39_0<=56)||(LA39_0>=58 && LA39_0<=65)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2426:3: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )?
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2426:3: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2427:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2427:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2428:3: lv_expressions_1_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXExpressionInClosureAccess().getExpressionsXExpressionInsideBlockParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure5891);
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2444:2: (otherlv_2= ';' )?
            	    int alt38=2;
            	    int LA38_0 = input.LA(1);

            	    if ( (LA38_0==44) ) {
            	        alt38=1;
            	    }
            	    switch (alt38) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2444:4: otherlv_2= ';'
            	            {
            	            otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleXExpressionInClosure5904); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2456:1: entryRuleXShortClosure returns [EObject current=null] : iv_ruleXShortClosure= ruleXShortClosure EOF ;
    public final EObject entryRuleXShortClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXShortClosure = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2457:2: (iv_ruleXShortClosure= ruleXShortClosure EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2458:2: iv_ruleXShortClosure= ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXShortClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5944);
            iv_ruleXShortClosure=ruleXShortClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXShortClosure5954); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2465:1: ruleXShortClosure returns [EObject current=null] : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXShortClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_explicitSyntax_4_0=null;
        EObject lv_declaredFormalParameters_1_0 = null;

        EObject lv_declaredFormalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2468:28: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2469:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2469:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2469:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2469:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2469:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2485:6: ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2485:7: () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2485:7: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2486:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2491:2: ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID||LA41_0==12||LA41_0==68) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2491:3: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2491:3: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2492:1: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2492:1: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2493:3: lv_declaredFormalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure6062);
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2509:2: (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==13) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2509:4: otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleXShortClosure6075); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2513:1: ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2514:1: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2514:1: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2515:3: lv_declaredFormalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure6096);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2531:6: ( (lv_explicitSyntax_4_0= '|' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2532:1: (lv_explicitSyntax_4_0= '|' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2532:1: (lv_explicitSyntax_4_0= '|' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2533:3: lv_explicitSyntax_4_0= '|'
            {
            lv_explicitSyntax_4_0=(Token)match(input,42,FOLLOW_42_in_ruleXShortClosure6118); if (state.failed) return current;
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2546:4: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2547:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2547:1: (lv_expression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2548:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXShortClosure6154);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2572:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2573:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2574:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression6190);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression6200); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2581:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2584:28: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2585:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2585:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2585:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleXParenthesizedExpression6237); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression6259);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleXParenthesizedExpression6270); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2610:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2611:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2612:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIfExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression6306);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression6316); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2619:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2622:28: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2623:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2623:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2623:2: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2623:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2624:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,45,FOLLOW_45_in_ruleXIfExpression6362); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleXIfExpression6374); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2637:1: ( (lv_if_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2638:1: (lv_if_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2638:1: (lv_if_3_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2639:3: lv_if_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6395);
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

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleXIfExpression6407); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2659:1: ( (lv_then_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2660:1: (lv_then_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2660:1: (lv_then_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2661:3: lv_then_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6428);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2677:2: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==46) ) {
                int LA42_1 = input.LA(2);

                if ( (synpred19_InternalXbaseWithAnnotations()) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2677:3: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2677:3: ( ( 'else' )=>otherlv_6= 'else' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2677:4: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,46,FOLLOW_46_in_ruleXIfExpression6449); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2682:2: ( (lv_else_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2683:1: (lv_else_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2683:1: (lv_else_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2684:3: lv_else_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6471);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2708:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2709:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2710:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSwitchExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6509);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression6519); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2717:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' ) ;
    public final EObject ruleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_localVarName_2_0 = null;

        EObject lv_switch_4_0 = null;

        EObject lv_cases_6_0 = null;

        EObject lv_default_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2720:28: ( ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2721:1: ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2721:1: ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2721:2: () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2721:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2722:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,47,FOLLOW_47_in_ruleXSwitchExpression6565); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2731:1: ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID) ) {
                int LA43_1 = input.LA(2);

                if ( (LA43_1==48) && (synpred20_InternalXbaseWithAnnotations())) {
                    alt43=1;
                }
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2731:2: ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2736:5: ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2736:6: ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':'
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2736:6: ( (lv_localVarName_2_0= ruleValidID ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2737:1: (lv_localVarName_2_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2737:1: (lv_localVarName_2_0= ruleValidID )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2738:3: lv_localVarName_2_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getLocalVarNameValidIDParserRuleCall_2_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXSwitchExpression6606);
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

                    otherlv_3=(Token)match(input,48,FOLLOW_48_in_ruleXSwitchExpression6618); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_0_1());
                          
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2758:4: ( (lv_switch_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2759:1: (lv_switch_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2759:1: (lv_switch_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2760:3: lv_switch_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6642);
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

            otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleXSwitchExpression6654); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2780:1: ( (lv_cases_6_0= ruleXCasePart ) )+
            int cnt44=0;
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_ID||LA44_0==12||LA44_0==48||LA44_0==50||LA44_0==68) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2781:1: (lv_cases_6_0= ruleXCasePart )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2781:1: (lv_cases_6_0= ruleXCasePart )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2782:3: lv_cases_6_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6675);
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
            	    if ( cnt44 >= 1 ) break loop44;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(44, input);
                        throw eee;
                }
                cnt44++;
            } while (true);

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2798:3: (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==49) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2798:5: otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) )
                    {
                    otherlv_7=(Token)match(input,49,FOLLOW_49_in_ruleXSwitchExpression6689); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_6_0());
                          
                    }
                    otherlv_8=(Token)match(input,48,FOLLOW_48_in_ruleXSwitchExpression6701); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_6_1());
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2806:1: ( (lv_default_9_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2807:1: (lv_default_9_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2807:1: (lv_default_9_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2808:3: lv_default_9_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_6_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6722);
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
                    break;

            }

            otherlv_10=(Token)match(input,18,FOLLOW_18_in_ruleXSwitchExpression6736); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_7());
                  
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2836:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2837:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2838:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCasePartRule()); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart6772);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart6782); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2845:1: ruleXCasePart returns [EObject current=null] : ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_typeGuard_0_0 = null;

        EObject lv_case_2_0 = null;

        EObject lv_then_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2848:28: ( ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2849:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2849:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2849:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2849:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID||LA46_0==12||LA46_0==68) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2850:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2850:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2851:3: lv_typeGuard_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6828);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2867:3: (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==50) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2867:5: otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) )
                    {
                    otherlv_1=(Token)match(input,50,FOLLOW_50_in_ruleXCasePart6842); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1_0());
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2871:1: ( (lv_case_2_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2872:1: (lv_case_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2872:1: (lv_case_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2873:3: lv_case_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6863);
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

            otherlv_3=(Token)match(input,48,FOLLOW_48_in_ruleXCasePart6877); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2893:1: ( (lv_then_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2894:1: (lv_then_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2894:1: (lv_then_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2895:3: lv_then_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6898);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2919:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXForLoopExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2920:2: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2921:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6934);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression6944); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2928:1: ruleXForLoopExpression returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2931:28: ( ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2932:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2932:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2932:2: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2932:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2933:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,51,FOLLOW_51_in_ruleXForLoopExpression6990); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleXForLoopExpression7002); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2946:1: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2947:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2947:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2948:3: lv_declaredParam_3_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression7023);
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

            otherlv_4=(Token)match(input,48,FOLLOW_48_in_ruleXForLoopExpression7035); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2968:1: ( (lv_forExpression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2969:1: (lv_forExpression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2969:1: (lv_forExpression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2970:3: lv_forExpression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression7056);
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

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleXForLoopExpression7068); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2990:1: ( (lv_eachExpression_7_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2991:1: (lv_eachExpression_7_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2991:1: (lv_eachExpression_7_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2992:3: lv_eachExpression_7_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression7089);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3016:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3017:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3018:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression7125);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression7135); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3025:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3028:28: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3029:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3029:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3029:2: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3029:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3030:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,52,FOLLOW_52_in_ruleXWhileExpression7181); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleXWhileExpression7193); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3043:1: ( (lv_predicate_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3044:1: (lv_predicate_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3044:1: (lv_predicate_3_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3045:3: lv_predicate_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression7214);
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

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleXWhileExpression7226); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3065:1: ( (lv_body_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3066:1: (lv_body_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3066:1: (lv_body_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3067:3: lv_body_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression7247);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3091:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3092:2: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3093:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXDoWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7283);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression7293); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3100:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3103:28: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3104:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3104:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3104:2: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3104:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3105:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleXDoWhileExpression7339); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3114:1: ( (lv_body_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3115:1: (lv_body_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3115:1: (lv_body_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3116:3: lv_body_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7360);
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

            otherlv_3=(Token)match(input,52,FOLLOW_52_in_ruleXDoWhileExpression7372); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,12,FOLLOW_12_in_ruleXDoWhileExpression7384); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3140:1: ( (lv_predicate_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3141:1: (lv_predicate_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3141:1: (lv_predicate_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3142:3: lv_predicate_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7405);
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

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleXDoWhileExpression7417); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3170:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3171:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3172:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7453);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression7463); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3179:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3182:28: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3183:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3183:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3183:2: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3183:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3184:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleXBlockExpression7509); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3193:1: ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( ((LA49_0>=RULE_INT && LA49_0<=RULE_ID)||LA49_0==12||(LA49_0>=16 && LA49_0<=17)||LA49_0==28||LA49_0==31||LA49_0==36||LA49_0==41||LA49_0==45||LA49_0==47||(LA49_0>=51 && LA49_0<=56)||(LA49_0>=58 && LA49_0<=65)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3193:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )?
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3193:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3194:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3194:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3195:3: lv_expressions_2_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7531);
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3211:2: (otherlv_3= ';' )?
            	    int alt48=2;
            	    int LA48_0 = input.LA(1);

            	    if ( (LA48_0==44) ) {
            	        alt48=1;
            	    }
            	    switch (alt48) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3211:4: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,44,FOLLOW_44_in_ruleXBlockExpression7544); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleXBlockExpression7560); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3227:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3228:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3229:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInsideBlockRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7596);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7606); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3236:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3239:28: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3240:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3240:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=54 && LA50_0<=55)) ) {
                alt50=1;
            }
            else if ( ((LA50_0>=RULE_INT && LA50_0<=RULE_ID)||LA50_0==12||(LA50_0>=16 && LA50_0<=17)||LA50_0==28||LA50_0==31||LA50_0==36||LA50_0==41||LA50_0==45||LA50_0==47||(LA50_0>=51 && LA50_0<=53)||LA50_0==56||(LA50_0>=58 && LA50_0<=65)) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3241:5: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7653);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3251:5: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7680);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3267:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3268:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3269:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7715);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration7725); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3276:1: ruleXVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3279:28: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3280:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3280:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3280:2: () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3280:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3281:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXVariableDeclarationAccess().getXVariableDeclarationAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3286:2: ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==54) ) {
                alt51=1;
            }
            else if ( (LA51_0==55) ) {
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3286:3: ( (lv_writeable_1_0= 'var' ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3286:3: ( (lv_writeable_1_0= 'var' ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3287:1: (lv_writeable_1_0= 'var' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3287:1: (lv_writeable_1_0= 'var' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3288:3: lv_writeable_1_0= 'var'
                    {
                    lv_writeable_1_0=(Token)match(input,54,FOLLOW_54_in_ruleXVariableDeclaration7778); if (state.failed) return current;
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3302:7: otherlv_2= 'val'
                    {
                    otherlv_2=(Token)match(input,55,FOLLOW_55_in_ruleXVariableDeclaration7809); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXVariableDeclarationAccess().getValKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3306:2: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_ID) ) {
                int LA52_1 = input.LA(2);

                if ( (synpred21_InternalXbaseWithAnnotations()) ) {
                    alt52=1;
                }
                else if ( (true) ) {
                    alt52=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA52_0==12) && (synpred21_InternalXbaseWithAnnotations())) {
                alt52=1;
            }
            else if ( (LA52_0==68) && (synpred21_InternalXbaseWithAnnotations())) {
                alt52=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3306:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3306:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3306:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3314:6: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3314:7: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3314:7: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3315:1: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3315:1: (lv_type_3_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3316:3: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7857);
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3332:2: ( (lv_name_4_0= ruleValidID ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3333:1: (lv_name_4_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3333:1: (lv_name_4_0= ruleValidID )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3334:3: lv_name_4_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration7878);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3351:6: ( (lv_name_5_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3351:6: ( (lv_name_5_0= ruleValidID ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3352:1: (lv_name_5_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3352:1: (lv_name_5_0= ruleValidID )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3353:3: lv_name_5_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration7907);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3369:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==15) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3369:5: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleXVariableDeclaration7921); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3373:1: ( (lv_right_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3374:1: (lv_right_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3374:1: (lv_right_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3375:3: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7942);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3399:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3400:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3401:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7980);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter7990); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3408:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3411:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3412:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3412:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3412:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3412:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==RULE_ID||LA54_1==28||LA54_1==38||LA54_1==41) ) {
                    alt54=1;
                }
            }
            else if ( (LA54_0==12||LA54_0==68) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3413:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3413:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3414:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter8036);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3430:3: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3431:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3431:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3432:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleJvmFormalParameter8058);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3456:1: entryRuleFullJvmFormalParameter returns [EObject current=null] : iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF ;
    public final EObject entryRuleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFullJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3457:2: (iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3458:2: iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFullJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleFullJvmFormalParameter_in_entryRuleFullJvmFormalParameter8094);
            iv_ruleFullJvmFormalParameter=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFullJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFullJvmFormalParameter8104); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3465:1: ruleFullJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3468:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3469:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3469:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3469:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3469:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3470:1: (lv_parameterType_0_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3470:1: (lv_parameterType_0_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3471:3: lv_parameterType_0_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleFullJvmFormalParameter8150);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3487:2: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3488:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3488:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3489:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleFullJvmFormalParameter8171);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3513:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3514:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3515:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall8207);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall8217); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3522:1: ruleXFeatureCall returns [EObject current=null] : ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? ) ;
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3525:28: ( ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3526:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3526:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3526:2: () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3526:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3527:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3532:2: ( ( ruleStaticQualifier ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_ID) ) {
                int LA55_1 = input.LA(2);

                if ( (LA55_1==57) ) {
                    alt55=1;
                }
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3533:1: ( ruleStaticQualifier )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3533:1: ( ruleStaticQualifier )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3534:3: ruleStaticQualifier
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXFeatureCallRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getDeclaringTypeJvmDeclaredTypeCrossReference_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall8274);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3547:3: (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==28) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3547:5: otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleXFeatureCall8288); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_2_0());
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3551:1: ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3552:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3552:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3553:3: lv_typeArguments_3_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8309);
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3569:2: (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==13) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3569:4: otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleXFeatureCall8322); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getXFeatureCallAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3573:1: ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3574:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3574:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3575:3: lv_typeArguments_5_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8343);
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
                    	    break loop56;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,27,FOLLOW_27_in_ruleXFeatureCall8357); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_2_3());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3595:3: ( ( ruleIdOrSuper ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3596:1: ( ruleIdOrSuper )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3596:1: ( ruleIdOrSuper )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3597:3: ruleIdOrSuper
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXFeatureCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall8382);
            ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3610:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt60=2;
            alt60 = dfa60.predict(input);
            switch (alt60) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3610:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3610:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3610:4: ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3617:1: (lv_explicitOperationCall_8_0= '(' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3618:3: lv_explicitOperationCall_8_0= '('
                    {
                    lv_explicitOperationCall_8_0=(Token)match(input,12,FOLLOW_12_in_ruleXFeatureCall8416); if (state.failed) return current;
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3631:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt59=3;
                    alt59 = dfa59.predict(input);
                    switch (alt59) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3631:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3631:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3631:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3648:1: (lv_featureCallArguments_9_0= ruleXShortClosure )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3649:3: lv_featureCallArguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_4_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXShortClosure_in_ruleXFeatureCall8501);
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
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3666:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3666:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3666:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3666:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3667:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3667:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3668:3: lv_featureCallArguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8529);
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

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3684:2: (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            loop58:
                            do {
                                int alt58=2;
                                int LA58_0 = input.LA(1);

                                if ( (LA58_0==13) ) {
                                    alt58=1;
                                }


                                switch (alt58) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3684:4: otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,13,FOLLOW_13_in_ruleXFeatureCall8542); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getXFeatureCallAccess().getCommaKeyword_4_1_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3688:1: ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3689:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3689:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3690:3: lv_featureCallArguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8563);
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
                            	    break loop58;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,14,FOLLOW_14_in_ruleXFeatureCall8580); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_4_2());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3710:3: ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?
            int alt61=2;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3710:4: ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3715:1: (lv_featureCallArguments_14_0= ruleXClosure )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3716:3: lv_featureCallArguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXClosureParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXFeatureCall8613);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3740:1: entryRuleIdOrSuper returns [String current=null] : iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
    public final String entryRuleIdOrSuper() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrSuper = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3741:2: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3742:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrSuperRule()); 
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper8651);
            iv_ruleIdOrSuper=ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdOrSuper8662); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3749:1: ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID | kw= 'super' ) ;
    public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3752:28: ( (this_ValidID_0= ruleValidID | kw= 'super' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3753:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3753:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==RULE_ID) ) {
                alt62=1;
            }
            else if ( (LA62_0==56) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3754:5: this_ValidID_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIdOrSuperAccess().getValidIDParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleIdOrSuper8709);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3766:2: kw= 'super'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleIdOrSuper8733); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3779:1: entryRuleStaticQualifier returns [String current=null] : iv_ruleStaticQualifier= ruleStaticQualifier EOF ;
    public final String entryRuleStaticQualifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStaticQualifier = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3780:2: (iv_ruleStaticQualifier= ruleStaticQualifier EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3781:2: iv_ruleStaticQualifier= ruleStaticQualifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStaticQualifierRule()); 
            }
            pushFollow(FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8774);
            iv_ruleStaticQualifier=ruleStaticQualifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStaticQualifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStaticQualifier8785); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3788:1: ruleStaticQualifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= '::' )+ ;
    public final AntlrDatatypeRuleToken ruleStaticQualifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3791:28: ( (this_ValidID_0= ruleValidID kw= '::' )+ )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3792:1: (this_ValidID_0= ruleValidID kw= '::' )+
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3792:1: (this_ValidID_0= ruleValidID kw= '::' )+
            int cnt63=0;
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==RULE_ID) ) {
                    int LA63_1 = input.LA(2);

                    if ( (LA63_1==57) ) {
                        alt63=1;
                    }


                }


                switch (alt63) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3793:5: this_ValidID_0= ruleValidID kw= '::'
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getStaticQualifierAccess().getValidIDParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleStaticQualifier8832);
            	    this_ValidID_0=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }
            	    kw=(Token)match(input,57,FOLLOW_57_in_ruleStaticQualifier8850); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getStaticQualifierAccess().getColonColonKeyword_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt63 >= 1 ) break loop63;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(63, input);
                        throw eee;
                }
                cnt63++;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3817:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3818:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3819:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXConstructorCallRule()); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8891);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall8901); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3826:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) ;
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3829:28: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3830:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3830:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3830:2: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3830:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3831:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXConstructorCallAccess().getXConstructorCallAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleXConstructorCall8947); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3840:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3841:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3841:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3842:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXConstructorCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8970);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3855:2: (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==28) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3855:4: otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                    {
                    otherlv_3=(Token)match(input,28,FOLLOW_28_in_ruleXConstructorCall8983); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3859:1: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3860:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3860:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3861:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9004);
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3877:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==13) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3877:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleXConstructorCall9017); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3881:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3882:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3882:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3883:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9038);
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
                    	    break loop64;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,27,FOLLOW_27_in_ruleXConstructorCall9052); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_3_3());
                          
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,12,FOLLOW_12_in_ruleXConstructorCall9066); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3907:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
            int alt67=3;
            alt67 = dfa67.predict(input);
            switch (alt67) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3907:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3907:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3907:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3924:1: (lv_arguments_9_0= ruleXShortClosure )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3925:3: lv_arguments_9_0= ruleXShortClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_5_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXConstructorCall9138);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3942:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3942:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3942:7: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3942:7: ( (lv_arguments_10_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3943:1: (lv_arguments_10_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3943:1: (lv_arguments_10_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3944:3: lv_arguments_10_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_5_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall9166);
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3960:2: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==13) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3960:4: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
                    	    {
                    	    otherlv_11=(Token)match(input,13,FOLLOW_13_in_ruleXConstructorCall9179); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_11, grammarAccess.getXConstructorCallAccess().getCommaKeyword_5_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3964:1: ( (lv_arguments_12_0= ruleXExpression ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3965:1: (lv_arguments_12_0= ruleXExpression )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3965:1: (lv_arguments_12_0= ruleXExpression )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3966:3: lv_arguments_12_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_5_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall9200);
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
                    	    break loop66;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,14,FOLLOW_14_in_ruleXConstructorCall9217); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3986:1: ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            int alt68=2;
            alt68 = dfa68.predict(input);
            switch (alt68) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3986:2: ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3991:1: (lv_arguments_14_0= ruleXClosure )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3992:3: lv_arguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXClosureParserRuleCall_7_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXConstructorCall9248);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4016:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4017:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4018:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral9285);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral9295); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4025:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4028:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4029:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4029:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4029:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4029:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4030:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4035:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==59) ) {
                alt69=1;
            }
            else if ( (LA69_0==60) ) {
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4035:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,59,FOLLOW_59_in_ruleXBooleanLiteral9342); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4040:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4040:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4041:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4041:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4042:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,60,FOLLOW_60_in_ruleXBooleanLiteral9366); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4063:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4064:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4065:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNullLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral9416);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral9426); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4072:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4075:28: ( ( () otherlv_1= 'null' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4076:1: ( () otherlv_1= 'null' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4076:1: ( () otherlv_1= 'null' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4076:2: () otherlv_1= 'null'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4076:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4077:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,61,FOLLOW_61_in_ruleXNullLiteral9472); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4094:1: entryRuleXIntLiteral returns [EObject current=null] : iv_ruleXIntLiteral= ruleXIntLiteral EOF ;
    public final EObject entryRuleXIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIntLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4095:2: (iv_ruleXIntLiteral= ruleXIntLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4096:2: iv_ruleXIntLiteral= ruleXIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIntLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral9508);
            iv_ruleXIntLiteral=ruleXIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIntLiteral9518); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4103:1: ruleXIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleXIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4106:28: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4107:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4107:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4107:2: () ( (lv_value_1_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4107:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4108:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIntLiteralAccess().getXIntLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4113:2: ( (lv_value_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4114:1: (lv_value_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4114:1: (lv_value_1_0= RULE_INT )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4115:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleXIntLiteral9569); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4139:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4140:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4141:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral9610);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral9620); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4148:1: ruleXStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4151:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4152:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4152:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4152:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4152:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4153:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4158:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4159:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4159:1: (lv_value_1_0= RULE_STRING )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4160:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral9671); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4184:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4185:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4186:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9712);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral9722); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4193:1: ruleXTypeLiteral returns [EObject current=null] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4196:28: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4197:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4197:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4197:2: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4197:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4198:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,62,FOLLOW_62_in_ruleXTypeLiteral9768); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleXTypeLiteral9780); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4211:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4212:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4212:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4213:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXTypeLiteralRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9803);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleXTypeLiteral9815); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4238:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4239:2: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4240:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXThrowExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9851);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression9861); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4247:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4250:28: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4251:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4251:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4251:2: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4251:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4252:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,63,FOLLOW_63_in_ruleXThrowExpression9907); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4261:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4262:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4262:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4263:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXThrowExpression9928);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4287:1: entryRuleXReturnExpression returns [EObject current=null] : iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
    public final EObject entryRuleXReturnExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXReturnExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4288:2: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4289:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXReturnExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression9964);
            iv_ruleXReturnExpression=ruleXReturnExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXReturnExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXReturnExpression9974); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4296:1: ruleXReturnExpression returns [EObject current=null] : ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
    public final EObject ruleXReturnExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4299:28: ( ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4300:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4300:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4300:2: () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4300:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4301:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,64,FOLLOW_64_in_ruleXReturnExpression10020); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4310:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            int alt70=2;
            alt70 = dfa70.predict(input);
            switch (alt70) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4310:2: ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4315:1: (lv_expression_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4316:3: lv_expression_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXReturnExpression10051);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4340:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4341:2: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4342:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression10088);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression10098); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4349:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4352:28: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4353:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4353:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4353:2: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4353:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4354:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,65,FOLLOW_65_in_ruleXTryCatchFinallyExpression10144); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4363:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4364:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4364:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4365:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10165);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4381:2: ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==67) ) {
                alt73=1;
            }
            else if ( (LA73_0==66) ) {
                alt73=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4381:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4381:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4381:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4381:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
                    int cnt71=0;
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==67) ) {
                            int LA71_2 = input.LA(2);

                            if ( (synpred28_InternalXbaseWithAnnotations()) ) {
                                alt71=1;
                            }


                        }


                        switch (alt71) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4381:5: ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4383:1: (lv_catchClauses_3_0= ruleXCatchClause )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4384:3: lv_catchClauses_3_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression10195);
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
                    	    if ( cnt71 >= 1 ) break loop71;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(71, input);
                                throw eee;
                        }
                        cnt71++;
                    } while (true);

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4400:3: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==66) ) {
                        int LA72_1 = input.LA(2);

                        if ( (synpred29_InternalXbaseWithAnnotations()) ) {
                            alt72=1;
                        }
                    }
                    switch (alt72) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4400:4: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4400:4: ( ( 'finally' )=>otherlv_4= 'finally' )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4400:5: ( 'finally' )=>otherlv_4= 'finally'
                            {
                            otherlv_4=(Token)match(input,66,FOLLOW_66_in_ruleXTryCatchFinallyExpression10217); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
                                  
                            }

                            }

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4405:2: ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4406:1: (lv_finallyExpression_5_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4406:1: (lv_finallyExpression_5_0= ruleXExpression )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4407:3: lv_finallyExpression_5_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10239);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4424:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4424:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4424:8: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,66,FOLLOW_66_in_ruleXTryCatchFinallyExpression10261); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4428:1: ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4429:1: (lv_finallyExpression_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4429:1: (lv_finallyExpression_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4430:3: lv_finallyExpression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10282);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4454:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4455:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4456:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCatchClauseRule()); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause10320);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause10330); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4463:1: ruleXCatchClause returns [EObject current=null] : ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4466:28: ( ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4467:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4467:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4467:2: ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4467:2: ( ( 'catch' )=>otherlv_0= 'catch' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4467:3: ( 'catch' )=>otherlv_0= 'catch'
            {
            otherlv_0=(Token)match(input,67,FOLLOW_67_in_ruleXCatchClause10375); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
                  
            }

            }

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleXCatchClause10388); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4476:1: ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4477:1: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4477:1: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4478:3: lv_declaredParam_2_0= ruleFullJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause10409);
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

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleXCatchClause10421); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4498:1: ( (lv_expression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4499:1: (lv_expression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4499:1: (lv_expression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4500:3: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCatchClause10442);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4524:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4525:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4526:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10479);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName10490); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4533:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4536:28: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4537:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4537:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4538:5: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName10537);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ValidID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4548:1: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==38) ) {
                    int LA74_2 = input.LA(2);

                    if ( (LA74_2==RULE_ID) ) {
                        int LA74_3 = input.LA(3);

                        if ( (synpred31_InternalXbaseWithAnnotations()) ) {
                            alt74=1;
                        }


                    }


                }


                switch (alt74) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4548:2: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4548:2: ( ( '.' )=>kw= '.' )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4548:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,38,FOLLOW_38_in_ruleQualifiedName10565); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName10588);
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
            	    break loop74;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4575:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4576:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4577:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference10635);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference10645); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4584:1: ruleJvmTypeReference returns [EObject current=null] : ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4587:28: ( ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4588:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4588:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_ID) ) {
                alt76=1;
            }
            else if ( (LA76_0==12||LA76_0==68) ) {
                alt76=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4588:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4588:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4589:5: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )*
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10693);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmParameterizedTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4597:1: ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==41) ) {
                            int LA75_2 = input.LA(2);

                            if ( (LA75_2==43) ) {
                                int LA75_3 = input.LA(3);

                                if ( (synpred32_InternalXbaseWithAnnotations()) ) {
                                    alt75=1;
                                }


                            }


                        }


                        switch (alt75) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4597:2: ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4600:5: ( () otherlv_2= '[' otherlv_3= ']' )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4600:6: () otherlv_2= '[' otherlv_3= ']'
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4600:6: ()
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4601:5: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	              current = forceCreateModelElementAndSet(
                    	                  grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(),
                    	                  current);
                    	          
                    	    }

                    	    }

                    	    otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleJvmTypeReference10731); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getJvmTypeReferenceAccess().getLeftSquareBracketKeyword_0_1_0_1());
                    	          
                    	    }
                    	    otherlv_3=(Token)match(input,43,FOLLOW_43_in_ruleJvmTypeReference10743); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmTypeReferenceAccess().getRightSquareBracketKeyword_0_1_0_2());
                    	          
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop75;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4616:5: this_XFunctionTypeRef_4= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference10775);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4632:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4633:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4634:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef10810);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef10820); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4641:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4644:28: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4645:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4645:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4645:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4645:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==12) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4645:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleXFunctionTypeRef10858); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4649:1: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==RULE_ID||LA78_0==12||LA78_0==68) ) {
                        alt78=1;
                    }
                    switch (alt78) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4649:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4649:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4650:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4650:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4651:3: lv_paramTypes_1_0= ruleJvmTypeReference
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10880);
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

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4667:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            loop77:
                            do {
                                int alt77=2;
                                int LA77_0 = input.LA(1);

                                if ( (LA77_0==13) ) {
                                    alt77=1;
                                }


                                switch (alt77) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4667:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    {
                            	    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleXFunctionTypeRef10893); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4671:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4672:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    {
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4672:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4673:3: lv_paramTypes_3_0= ruleJvmTypeReference
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10914);
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
                            	    break loop77;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleXFunctionTypeRef10930); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,68,FOLLOW_68_in_ruleXFunctionTypeRef10944); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4697:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4698:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4698:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4699:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10965);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4723:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4724:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4725:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference11001);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference11011); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4732:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4735:28: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4736:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4736:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4736:2: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4736:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4737:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4737:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4738:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference11059);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4751:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt81=2;
            alt81 = dfa81.predict(input);
            switch (alt81) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4751:3: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4751:3: ( ( '<' )=>otherlv_1= '<' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4751:4: ( '<' )=>otherlv_1= '<'
                    {
                    otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleJvmParameterizedTypeReference11080); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4756:2: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4757:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4757:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4758:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11102);
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4774:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop80:
                    do {
                        int alt80=2;
                        int LA80_0 = input.LA(1);

                        if ( (LA80_0==13) ) {
                            alt80=1;
                        }


                        switch (alt80) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4774:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleJvmParameterizedTypeReference11115); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4778:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4779:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4779:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4780:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11136);
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
                    	    break loop80;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleJvmParameterizedTypeReference11150); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4808:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4809:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4810:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11188);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11198); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4817:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4820:28: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4821:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4821:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==RULE_ID||LA82_0==12||LA82_0==68) ) {
                alt82=1;
            }
            else if ( (LA82_0==69) ) {
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4822:5: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11245);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4832:5: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11272);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4848:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4849:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4850:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11307);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11317); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4857:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4860:28: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4861:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4861:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4861:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4861:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4862:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,69,FOLLOW_69_in_ruleJvmWildcardTypeReference11363); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4871:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt83=3;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==70) ) {
                alt83=1;
            }
            else if ( (LA83_0==56) ) {
                alt83=2;
            }
            switch (alt83) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4871:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4871:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4872:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4872:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4873:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11385);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4890:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4890:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4891:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4891:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4892:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11412);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4916:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4917:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4918:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11450);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound11460); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4925:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4928:28: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4929:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4929:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4929:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,70,FOLLOW_70_in_ruleJvmUpperBound11497); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4933:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4934:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4934:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4935:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound11518);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4959:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4960:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4961:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded11554);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded11564); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4968:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4971:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4972:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4972:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4972:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,71,FOLLOW_71_in_ruleJvmUpperBoundAnded11601); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4976:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4977:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4977:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4978:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded11622);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5002:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5003:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5004:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11658);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound11668); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5011:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5014:28: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5015:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5015:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5015:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,56,FOLLOW_56_in_ruleJvmLowerBound11705); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5019:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5020:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5020:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5021:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11726);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5047:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5048:2: (iv_ruleValidID= ruleValidID EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5049:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID11765);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID11776); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5056:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5059:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5060:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID11815); if (state.failed) return current;
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
        int alt84=3;
        switch ( input.LA(1) ) {
        case 38:
            {
            alt84=1;
            }
            break;
        case 39:
            {
            alt84=2;
            }
            break;
        case 40:
            {
            alt84=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 84, 0, input);

            throw nvae;
        }

        switch (alt84) {
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
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1945:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1945:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1945:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1945:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1945:6: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1946:1: 
        {
        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1946:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt86=2;
        int LA86_0 = input.LA(1);

        if ( (LA86_0==RULE_ID||LA86_0==12||LA86_0==68) ) {
            alt86=1;
        }
        switch (alt86) {
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
                loop85:
                do {
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==13) ) {
                        alt85=1;
                    }


                    switch (alt85) {
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
                	    break loop85;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1955:6: ( ( '|' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1956:1: ( '|' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1956:1: ( '|' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1957:2: '|'
        {
        match(input,42,FOLLOW_42_in_synpred15_InternalXbaseWithAnnotations4739); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred15_InternalXbaseWithAnnotations

    // $ANTLR start synpred16_InternalXbaseWithAnnotations
    public final void synpred16_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2024:4: ( ( ruleXClosure ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2025:1: ( ruleXClosure )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2025:1: ( ruleXClosure )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2026:1: ruleXClosure
        {
        pushFollow(FOLLOW_ruleXClosure_in_synpred16_InternalXbaseWithAnnotations4857);
        ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred16_InternalXbaseWithAnnotations

    // $ANTLR start synpred17_InternalXbaseWithAnnotations
    public final void synpred17_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2307:2: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2307:3: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2307:3: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2307:4: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2307:4: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt88=2;
        int LA88_0 = input.LA(1);

        if ( (LA88_0==RULE_ID||LA88_0==12||LA88_0==68) ) {
            alt88=1;
        }
        switch (alt88) {
            case 1 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2307:5: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2307:5: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2308:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2308:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2309:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred17_InternalXbaseWithAnnotations5630);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2311:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop87:
                do {
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==13) ) {
                        alt87=1;
                    }


                    switch (alt87) {
                	case 1 :
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2311:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,13,FOLLOW_13_in_synpred17_InternalXbaseWithAnnotations5637); if (state.failed) return ;
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2312:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2313:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2313:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2314:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred17_InternalXbaseWithAnnotations5644);
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

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2316:6: ( ( '|' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2317:1: ( '|' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2317:1: ( '|' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2318:2: '|'
        {
        match(input,42,FOLLOW_42_in_synpred17_InternalXbaseWithAnnotations5658); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred17_InternalXbaseWithAnnotations

    // $ANTLR start synpred19_InternalXbaseWithAnnotations
    public final void synpred19_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2677:4: ( 'else' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2677:6: 'else'
        {
        match(input,46,FOLLOW_46_in_synpred19_InternalXbaseWithAnnotations6441); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_InternalXbaseWithAnnotations

    // $ANTLR start synpred20_InternalXbaseWithAnnotations
    public final void synpred20_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2731:2: ( ( ( ( ruleValidID ) ) ':' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2731:3: ( ( ( ruleValidID ) ) ':' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2731:3: ( ( ( ruleValidID ) ) ':' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2731:4: ( ( ruleValidID ) ) ':'
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2731:4: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2732:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2732:1: ( ruleValidID )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2733:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred20_InternalXbaseWithAnnotations6581);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,48,FOLLOW_48_in_synpred20_InternalXbaseWithAnnotations6587); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred20_InternalXbaseWithAnnotations

    // $ANTLR start synpred21_InternalXbaseWithAnnotations
    public final void synpred21_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3306:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3306:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3306:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3306:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3306:6: ( ( ruleJvmTypeReference ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3307:1: ( ruleJvmTypeReference )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3307:1: ( ruleJvmTypeReference )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3308:1: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_ruleJvmTypeReference_in_synpred21_InternalXbaseWithAnnotations7827);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3310:2: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3311:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3311:1: ( ruleValidID )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3312:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred21_InternalXbaseWithAnnotations7836);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred21_InternalXbaseWithAnnotations

    // $ANTLR start synpred22_InternalXbaseWithAnnotations
    public final void synpred22_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3610:4: ( ( '(' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3611:1: ( '(' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3611:1: ( '(' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3612:2: '('
        {
        match(input,12,FOLLOW_12_in_synpred22_InternalXbaseWithAnnotations8398); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred22_InternalXbaseWithAnnotations

    // $ANTLR start synpred23_InternalXbaseWithAnnotations
    public final void synpred23_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3631:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3631:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3631:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3631:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3631:6: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3632:1: 
        {
        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3632:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt92=2;
        int LA92_0 = input.LA(1);

        if ( (LA92_0==RULE_ID||LA92_0==12||LA92_0==68) ) {
            alt92=1;
        }
        switch (alt92) {
            case 1 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3632:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3632:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3633:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3633:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3634:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred23_InternalXbaseWithAnnotations8450);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3636:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop91:
                do {
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==13) ) {
                        alt91=1;
                    }


                    switch (alt91) {
                	case 1 :
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3636:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,13,FOLLOW_13_in_synpred23_InternalXbaseWithAnnotations8457); if (state.failed) return ;
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3637:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3638:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3638:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3639:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred23_InternalXbaseWithAnnotations8464);
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

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3641:6: ( ( '|' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3642:1: ( '|' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3642:1: ( '|' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3643:2: '|'
        {
        match(input,42,FOLLOW_42_in_synpred23_InternalXbaseWithAnnotations8478); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred23_InternalXbaseWithAnnotations

    // $ANTLR start synpred24_InternalXbaseWithAnnotations
    public final void synpred24_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3710:4: ( ( ruleXClosure ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3711:1: ( ruleXClosure )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3711:1: ( ruleXClosure )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3712:1: ruleXClosure
        {
        pushFollow(FOLLOW_ruleXClosure_in_synpred24_InternalXbaseWithAnnotations8596);
        ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred24_InternalXbaseWithAnnotations

    // $ANTLR start synpred25_InternalXbaseWithAnnotations
    public final void synpred25_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3907:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3907:4: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3907:4: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3907:5: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3907:5: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3908:1: 
        {
        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3908:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt94=2;
        int LA94_0 = input.LA(1);

        if ( (LA94_0==RULE_ID||LA94_0==12||LA94_0==68) ) {
            alt94=1;
        }
        switch (alt94) {
            case 1 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3908:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3908:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3909:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3909:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3910:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred25_InternalXbaseWithAnnotations9087);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3912:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop93:
                do {
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==13) ) {
                        alt93=1;
                    }


                    switch (alt93) {
                	case 1 :
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3912:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,13,FOLLOW_13_in_synpred25_InternalXbaseWithAnnotations9094); if (state.failed) return ;
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3913:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3914:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3914:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3915:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred25_InternalXbaseWithAnnotations9101);
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

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3917:6: ( ( '|' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3918:1: ( '|' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3918:1: ( '|' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3919:2: '|'
        {
        match(input,42,FOLLOW_42_in_synpred25_InternalXbaseWithAnnotations9115); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred25_InternalXbaseWithAnnotations

    // $ANTLR start synpred26_InternalXbaseWithAnnotations
    public final void synpred26_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3986:2: ( ( ruleXClosure ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3987:1: ( ruleXClosure )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3987:1: ( ruleXClosure )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3988:1: ruleXClosure
        {
        pushFollow(FOLLOW_ruleXClosure_in_synpred26_InternalXbaseWithAnnotations9231);
        ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred26_InternalXbaseWithAnnotations

    // $ANTLR start synpred27_InternalXbaseWithAnnotations
    public final void synpred27_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4310:2: ( ( ruleXExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4311:1: ( ruleXExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4311:1: ( ruleXExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4312:1: ruleXExpression
        {
        pushFollow(FOLLOW_ruleXExpression_in_synpred27_InternalXbaseWithAnnotations10034);
        ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred27_InternalXbaseWithAnnotations

    // $ANTLR start synpred28_InternalXbaseWithAnnotations
    public final void synpred28_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4381:5: ( 'catch' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4381:7: 'catch'
        {
        match(input,67,FOLLOW_67_in_synpred28_InternalXbaseWithAnnotations10179); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_InternalXbaseWithAnnotations

    // $ANTLR start synpred29_InternalXbaseWithAnnotations
    public final void synpred29_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4400:5: ( 'finally' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4400:7: 'finally'
        {
        match(input,66,FOLLOW_66_in_synpred29_InternalXbaseWithAnnotations10209); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_InternalXbaseWithAnnotations

    // $ANTLR start synpred31_InternalXbaseWithAnnotations
    public final void synpred31_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4548:3: ( '.' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4549:2: '.'
        {
        match(input,38,FOLLOW_38_in_synpred31_InternalXbaseWithAnnotations10556); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_InternalXbaseWithAnnotations

    // $ANTLR start synpred32_InternalXbaseWithAnnotations
    public final void synpred32_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4597:2: ( ( () '[' ']' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4597:3: ( () '[' ']' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4597:3: ( () '[' ']' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4597:4: () '[' ']'
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4597:4: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4598:1: 
        {
        }

        match(input,41,FOLLOW_41_in_synpred32_InternalXbaseWithAnnotations10708); if (state.failed) return ;
        match(input,43,FOLLOW_43_in_synpred32_InternalXbaseWithAnnotations10712); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred32_InternalXbaseWithAnnotations

    // $ANTLR start synpred33_InternalXbaseWithAnnotations
    public final void synpred33_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4751:4: ( '<' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4751:6: '<'
        {
        match(input,28,FOLLOW_28_in_synpred33_InternalXbaseWithAnnotations11072); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_InternalXbaseWithAnnotations

    // Delegated rules

    public final boolean synpred31_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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
    public final boolean synpred26_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalXbaseWithAnnotations_fragment(); // can never throw exception
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
    public final boolean synpred33_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalXbaseWithAnnotations_fragment(); // can never throw exception
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
    public final boolean synpred29_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalXbaseWithAnnotations_fragment(); // can never throw exception
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
    public final boolean synpred16_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalXbaseWithAnnotations_fragment(); // can never throw exception
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
    public final boolean synpred32_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalXbaseWithAnnotations_fragment(); // can never throw exception
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
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA59 dfa59 = new DFA59(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA68 dfa68 = new DFA68(this);
    protected DFA70 dfa70 = new DFA70(this);
    protected DFA81 dfa81 = new DFA81(this);
    static final String DFA30_eotS =
        "\74\uffff";
    static final String DFA30_eofS =
        "\1\2\73\uffff";
    static final String DFA30_minS =
        "\1\4\1\0\72\uffff";
    static final String DFA30_maxS =
        "\1\104\1\0\72\uffff";
    static final String DFA30_acceptS =
        "\2\uffff\1\2\70\uffff\1\1";
    static final String DFA30_specialS =
        "\1\uffff\1\0\72\uffff}>";
    static final String[] DFA30_transitionS = {
            "\3\2\5\uffff\1\1\2\2\1\uffff\32\2\1\uffff\16\2\1\uffff\13\2",
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
            return "1924:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?";
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
                        if ( (synpred14_InternalXbaseWithAnnotations()) ) {s = 59;}

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
        "\34\uffff";
    static final String DFA29_eofS =
        "\34\uffff";
    static final String DFA29_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA29_maxS =
        "\1\104\2\0\31\uffff";
    static final String DFA29_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA29_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA29_transitionS = {
            "\2\5\1\1\5\uffff\1\2\1\uffff\1\33\1\uffff\2\5\12\uffff\1\5\2"+
            "\uffff\1\5\4\uffff\1\5\4\uffff\1\5\1\4\2\uffff\1\5\1\uffff\1"+
            "\5\3\uffff\3\5\2\uffff\1\5\1\uffff\10\5\2\uffff\1\3",
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
            return "1945:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?";
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

                        else if ( (LA29_0==68) && (synpred15_InternalXbaseWithAnnotations())) {s = 3;}

                        else if ( (LA29_0==42) && (synpred15_InternalXbaseWithAnnotations())) {s = 4;}

                        else if ( ((LA29_0>=RULE_INT && LA29_0<=RULE_STRING)||(LA29_0>=16 && LA29_0<=17)||LA29_0==28||LA29_0==31||LA29_0==36||LA29_0==41||LA29_0==45||LA29_0==47||(LA29_0>=51 && LA29_0<=53)||LA29_0==56||(LA29_0>=58 && LA29_0<=65)) ) {s = 5;}

                        else if ( (LA29_0==14) ) {s = 27;}

                         
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
    static final String DFA31_eotS =
        "\74\uffff";
    static final String DFA31_eofS =
        "\1\2\73\uffff";
    static final String DFA31_minS =
        "\1\4\1\0\72\uffff";
    static final String DFA31_maxS =
        "\1\104\1\0\72\uffff";
    static final String DFA31_acceptS =
        "\2\uffff\1\2\70\uffff\1\1";
    static final String DFA31_specialS =
        "\1\uffff\1\0\72\uffff}>";
    static final String[] DFA31_transitionS = {
            "\3\2\5\uffff\3\2\1\uffff\31\2\1\1\1\uffff\16\2\1\uffff\13\2",
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
            return "2024:3: ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?";
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
                        if ( (synpred16_InternalXbaseWithAnnotations()) ) {s = 59;}

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
        "\36\uffff";
    static final String DFA37_eofS =
        "\36\uffff";
    static final String DFA37_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA37_maxS =
        "\1\104\2\0\33\uffff";
    static final String DFA37_acceptS =
        "\3\uffff\2\1\1\2\30\uffff";
    static final String DFA37_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA37_transitionS = {
            "\2\5\1\1\5\uffff\1\2\3\uffff\2\5\12\uffff\1\5\2\uffff\1\5\4"+
            "\uffff\1\5\4\uffff\1\5\1\4\1\5\1\uffff\1\5\1\uffff\1\5\3\uffff"+
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
            return "2307:1: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?";
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

                        else if ( (LA37_0==12) ) {s = 2;}

                        else if ( (LA37_0==68) && (synpred17_InternalXbaseWithAnnotations())) {s = 3;}

                        else if ( (LA37_0==42) && (synpred17_InternalXbaseWithAnnotations())) {s = 4;}

                        else if ( ((LA37_0>=RULE_INT && LA37_0<=RULE_STRING)||(LA37_0>=16 && LA37_0<=17)||LA37_0==28||LA37_0==31||LA37_0==36||LA37_0==41||LA37_0==43||LA37_0==45||LA37_0==47||(LA37_0>=51 && LA37_0<=56)||(LA37_0>=58 && LA37_0<=65)) ) {s = 5;}

                         
                        input.seek(index37_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA37_1 = input.LA(1);

                         
                        int index37_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXbaseWithAnnotations()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index37_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA37_2 = input.LA(1);

                         
                        int index37_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXbaseWithAnnotations()) ) {s = 4;}

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
    static final String DFA60_eotS =
        "\74\uffff";
    static final String DFA60_eofS =
        "\1\2\73\uffff";
    static final String DFA60_minS =
        "\1\4\1\0\72\uffff";
    static final String DFA60_maxS =
        "\1\104\1\0\72\uffff";
    static final String DFA60_acceptS =
        "\2\uffff\1\2\70\uffff\1\1";
    static final String DFA60_specialS =
        "\1\uffff\1\0\72\uffff}>";
    static final String[] DFA60_transitionS = {
            "\3\2\5\uffff\1\1\2\2\1\uffff\32\2\1\uffff\16\2\1\uffff\13\2",
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
            return "3610:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA60_1 = input.LA(1);

                         
                        int index60_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index60_1);
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
    static final String DFA59_eotS =
        "\34\uffff";
    static final String DFA59_eofS =
        "\34\uffff";
    static final String DFA59_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA59_maxS =
        "\1\104\2\0\31\uffff";
    static final String DFA59_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA59_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA59_transitionS = {
            "\2\5\1\1\5\uffff\1\2\1\uffff\1\33\1\uffff\2\5\12\uffff\1\5\2"+
            "\uffff\1\5\4\uffff\1\5\4\uffff\1\5\1\4\2\uffff\1\5\1\uffff\1"+
            "\5\3\uffff\3\5\2\uffff\1\5\1\uffff\10\5\2\uffff\1\3",
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
            ""
    };

    static final short[] DFA59_eot = DFA.unpackEncodedString(DFA59_eotS);
    static final short[] DFA59_eof = DFA.unpackEncodedString(DFA59_eofS);
    static final char[] DFA59_min = DFA.unpackEncodedStringToUnsignedChars(DFA59_minS);
    static final char[] DFA59_max = DFA.unpackEncodedStringToUnsignedChars(DFA59_maxS);
    static final short[] DFA59_accept = DFA.unpackEncodedString(DFA59_acceptS);
    static final short[] DFA59_special = DFA.unpackEncodedString(DFA59_specialS);
    static final short[][] DFA59_transition;

    static {
        int numStates = DFA59_transitionS.length;
        DFA59_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA59_transition[i] = DFA.unpackEncodedString(DFA59_transitionS[i]);
        }
    }

    class DFA59 extends DFA {

        public DFA59(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 59;
            this.eot = DFA59_eot;
            this.eof = DFA59_eof;
            this.min = DFA59_min;
            this.max = DFA59_max;
            this.accept = DFA59_accept;
            this.special = DFA59_special;
            this.transition = DFA59_transition;
        }
        public String getDescription() {
            return "3631:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA59_0 = input.LA(1);

                         
                        int index59_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA59_0==RULE_ID) ) {s = 1;}

                        else if ( (LA59_0==12) ) {s = 2;}

                        else if ( (LA59_0==68) && (synpred23_InternalXbaseWithAnnotations())) {s = 3;}

                        else if ( (LA59_0==42) && (synpred23_InternalXbaseWithAnnotations())) {s = 4;}

                        else if ( ((LA59_0>=RULE_INT && LA59_0<=RULE_STRING)||(LA59_0>=16 && LA59_0<=17)||LA59_0==28||LA59_0==31||LA59_0==36||LA59_0==41||LA59_0==45||LA59_0==47||(LA59_0>=51 && LA59_0<=53)||LA59_0==56||(LA59_0>=58 && LA59_0<=65)) ) {s = 5;}

                        else if ( (LA59_0==14) ) {s = 27;}

                         
                        input.seek(index59_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA59_1 = input.LA(1);

                         
                        int index59_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index59_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA59_2 = input.LA(1);

                         
                        int index59_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index59_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 59, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA61_eotS =
        "\74\uffff";
    static final String DFA61_eofS =
        "\1\2\73\uffff";
    static final String DFA61_minS =
        "\1\4\1\0\72\uffff";
    static final String DFA61_maxS =
        "\1\104\1\0\72\uffff";
    static final String DFA61_acceptS =
        "\2\uffff\1\2\70\uffff\1\1";
    static final String DFA61_specialS =
        "\1\uffff\1\0\72\uffff}>";
    static final String[] DFA61_transitionS = {
            "\3\2\5\uffff\3\2\1\uffff\31\2\1\1\1\uffff\16\2\1\uffff\13\2",
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
            return "3710:3: ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?";
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
                        if ( (synpred24_InternalXbaseWithAnnotations()) ) {s = 59;}

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
    static final String DFA67_eotS =
        "\34\uffff";
    static final String DFA67_eofS =
        "\34\uffff";
    static final String DFA67_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA67_maxS =
        "\1\104\2\0\31\uffff";
    static final String DFA67_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA67_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA67_transitionS = {
            "\2\5\1\1\5\uffff\1\2\1\uffff\1\33\1\uffff\2\5\12\uffff\1\5\2"+
            "\uffff\1\5\4\uffff\1\5\4\uffff\1\5\1\4\2\uffff\1\5\1\uffff\1"+
            "\5\3\uffff\3\5\2\uffff\1\5\1\uffff\10\5\2\uffff\1\3",
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
            ""
    };

    static final short[] DFA67_eot = DFA.unpackEncodedString(DFA67_eotS);
    static final short[] DFA67_eof = DFA.unpackEncodedString(DFA67_eofS);
    static final char[] DFA67_min = DFA.unpackEncodedStringToUnsignedChars(DFA67_minS);
    static final char[] DFA67_max = DFA.unpackEncodedStringToUnsignedChars(DFA67_maxS);
    static final short[] DFA67_accept = DFA.unpackEncodedString(DFA67_acceptS);
    static final short[] DFA67_special = DFA.unpackEncodedString(DFA67_specialS);
    static final short[][] DFA67_transition;

    static {
        int numStates = DFA67_transitionS.length;
        DFA67_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA67_transition[i] = DFA.unpackEncodedString(DFA67_transitionS[i]);
        }
    }

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = DFA67_eot;
            this.eof = DFA67_eof;
            this.min = DFA67_min;
            this.max = DFA67_max;
            this.accept = DFA67_accept;
            this.special = DFA67_special;
            this.transition = DFA67_transition;
        }
        public String getDescription() {
            return "3907:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA67_0 = input.LA(1);

                         
                        int index67_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA67_0==RULE_ID) ) {s = 1;}

                        else if ( (LA67_0==12) ) {s = 2;}

                        else if ( (LA67_0==68) && (synpred25_InternalXbaseWithAnnotations())) {s = 3;}

                        else if ( (LA67_0==42) && (synpred25_InternalXbaseWithAnnotations())) {s = 4;}

                        else if ( ((LA67_0>=RULE_INT && LA67_0<=RULE_STRING)||(LA67_0>=16 && LA67_0<=17)||LA67_0==28||LA67_0==31||LA67_0==36||LA67_0==41||LA67_0==45||LA67_0==47||(LA67_0>=51 && LA67_0<=53)||LA67_0==56||(LA67_0>=58 && LA67_0<=65)) ) {s = 5;}

                        else if ( (LA67_0==14) ) {s = 27;}

                         
                        input.seek(index67_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA67_1 = input.LA(1);

                         
                        int index67_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_InternalXbaseWithAnnotations()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index67_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA67_2 = input.LA(1);

                         
                        int index67_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_InternalXbaseWithAnnotations()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index67_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 67, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA68_eotS =
        "\74\uffff";
    static final String DFA68_eofS =
        "\1\2\73\uffff";
    static final String DFA68_minS =
        "\1\4\1\0\72\uffff";
    static final String DFA68_maxS =
        "\1\104\1\0\72\uffff";
    static final String DFA68_acceptS =
        "\2\uffff\1\2\70\uffff\1\1";
    static final String DFA68_specialS =
        "\1\uffff\1\0\72\uffff}>";
    static final String[] DFA68_transitionS = {
            "\3\2\5\uffff\3\2\1\uffff\31\2\1\1\1\uffff\16\2\1\uffff\13\2",
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
            return "3986:1: ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA68_1 = input.LA(1);

                         
                        int index68_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index68_1);
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
        "\74\uffff";
    static final String DFA70_eofS =
        "\1\31\73\uffff";
    static final String DFA70_minS =
        "\1\4\30\0\43\uffff";
    static final String DFA70_maxS =
        "\1\104\30\0\43\uffff";
    static final String DFA70_acceptS =
        "\31\uffff\1\2\41\uffff\1\1";
    static final String DFA70_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\43\uffff}>";
    static final String[] DFA70_transitionS = {
            "\1\15\1\17\1\1\5\uffff\1\30\2\31\1\uffff\1\4\1\6\12\31\1\10"+
            "\2\31\1\3\4\31\1\2\4\31\1\12\1\uffff\2\31\1\21\1\31\1\7\3\31"+
            "\1\22\1\23\1\24\2\31\1\11\1\uffff\1\5\1\13\1\14\1\16\1\20\1"+
            "\25\1\26\1\27\3\31",
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
            return "4310:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?";
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
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA70_2 = input.LA(1);

                         
                        int index70_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA70_3 = input.LA(1);

                         
                        int index70_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA70_4 = input.LA(1);

                         
                        int index70_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA70_5 = input.LA(1);

                         
                        int index70_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA70_6 = input.LA(1);

                         
                        int index70_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA70_7 = input.LA(1);

                         
                        int index70_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA70_8 = input.LA(1);

                         
                        int index70_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA70_9 = input.LA(1);

                         
                        int index70_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA70_10 = input.LA(1);

                         
                        int index70_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA70_11 = input.LA(1);

                         
                        int index70_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA70_12 = input.LA(1);

                         
                        int index70_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA70_13 = input.LA(1);

                         
                        int index70_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA70_14 = input.LA(1);

                         
                        int index70_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA70_15 = input.LA(1);

                         
                        int index70_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA70_16 = input.LA(1);

                         
                        int index70_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA70_17 = input.LA(1);

                         
                        int index70_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA70_18 = input.LA(1);

                         
                        int index70_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA70_19 = input.LA(1);

                         
                        int index70_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA70_20 = input.LA(1);

                         
                        int index70_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA70_21 = input.LA(1);

                         
                        int index70_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA70_22 = input.LA(1);

                         
                        int index70_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA70_23 = input.LA(1);

                         
                        int index70_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA70_24 = input.LA(1);

                         
                        int index70_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index70_24);
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
    static final String DFA81_eotS =
        "\74\uffff";
    static final String DFA81_eofS =
        "\1\2\73\uffff";
    static final String DFA81_minS =
        "\1\4\1\0\72\uffff";
    static final String DFA81_maxS =
        "\1\104\1\0\72\uffff";
    static final String DFA81_acceptS =
        "\2\uffff\1\2\70\uffff\1\1";
    static final String DFA81_specialS =
        "\1\uffff\1\0\72\uffff}>";
    static final String[] DFA81_transitionS = {
            "\3\2\5\uffff\3\2\1\uffff\14\2\1\1\15\2\1\uffff\16\2\1\uffff"+
            "\13\2",
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
            ""
    };

    static final short[] DFA81_eot = DFA.unpackEncodedString(DFA81_eotS);
    static final short[] DFA81_eof = DFA.unpackEncodedString(DFA81_eofS);
    static final char[] DFA81_min = DFA.unpackEncodedStringToUnsignedChars(DFA81_minS);
    static final char[] DFA81_max = DFA.unpackEncodedStringToUnsignedChars(DFA81_maxS);
    static final short[] DFA81_accept = DFA.unpackEncodedString(DFA81_acceptS);
    static final short[] DFA81_special = DFA.unpackEncodedString(DFA81_specialS);
    static final short[][] DFA81_transition;

    static {
        int numStates = DFA81_transitionS.length;
        DFA81_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA81_transition[i] = DFA.unpackEncodedString(DFA81_transitionS[i]);
        }
    }

    class DFA81 extends DFA {

        public DFA81(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 81;
            this.eot = DFA81_eot;
            this.eof = DFA81_eof;
            this.min = DFA81_min;
            this.max = DFA81_max;
            this.accept = DFA81_accept;
            this.special = DFA81_special;
            this.transition = DFA81_transition;
        }
        public String getDescription() {
            return "4751:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA81_1 = input.LA(1);

                         
                        int index81_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalXbaseWithAnnotations()) ) {s = 59;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index81_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 81, _s, input);
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
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXAssignment1367 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment1417 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_ruleXAssignment1470 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
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
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression1818 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1841 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr1880 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr1891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleOpOr1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression1967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression1977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression2024 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression2077 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression2100 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd2139 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd2150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleOpAnd2187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression2226 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression2236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2283 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression2336 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
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
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2685 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
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
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression3004 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression3027 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther3066 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther3077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpOther3115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpOther3134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression3174 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression3184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3231 = new BitSet(new long[]{0x0000000080010002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression3284 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3307 = new BitSet(new long[]{0x0000000080010002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd3346 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd3357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleOpAdd3395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOpAdd3414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression3454 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression3464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3511 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3564 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3587 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti3626 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti3637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOpMulti3675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpMulti3694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOpMulti3713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOpMulti3732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3772 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation3782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3840 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
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
    public static final BitSet FOLLOW_37_in_ruleXCastedExpression4145 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression4168 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall4206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall4216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall4263 = new BitSet(new long[]{0x000001C000000002L});
    public static final BitSet FOLLOW_38_in_ruleXMemberFeatureCall4312 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4335 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall4351 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall4373 = new BitSet(new long[]{0x000001C000000002L});
    public static final BitSet FOLLOW_38_in_ruleXMemberFeatureCall4459 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_39_in_ruleXMemberFeatureCall4483 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_40_in_ruleXMemberFeatureCall4520 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_28_in_ruleXMemberFeatureCall4549 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000030L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4570 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_13_in_ruleXMemberFeatureCall4583 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000030L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4604 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_27_in_ruleXMemberFeatureCall4618 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4643 = new BitSet(new long[]{0x000003C000001002L});
    public static final BitSet FOLLOW_12_in_ruleXMemberFeatureCall4677 = new BitSet(new long[]{0xFD38A61090035070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4762 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4790 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleXMemberFeatureCall4803 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4824 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleXMemberFeatureCall4841 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall4874 = new BitSet(new long[]{0x000001C000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4914 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression4924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression4971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression4998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression5025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression5052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression5079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression5106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression5133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression5160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression5187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression5214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression5241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression5268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression5295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_entryRuleXLiteral5330 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXLiteral5340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXLiteral5387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral5414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_ruleXLiteral5441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXLiteral5468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXLiteral5495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXLiteral5522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure5557 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure5567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleXClosure5613 = new BitSet(new long[]{0xFDF8AE1090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5684 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_13_in_ruleXClosure5697 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5718 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_42_in_ruleXClosure5740 = new BitSet(new long[]{0xFDF8AA1090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_ruleXClosure5777 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXClosure5789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure5825 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInClosure5835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure5891 = new BitSet(new long[]{0xFDF8B21090031072L,0x0000000000000003L});
    public static final BitSet FOLLOW_44_in_ruleXExpressionInClosure5904 = new BitSet(new long[]{0xFDF8A21090031072L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5944 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXShortClosure5954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure6062 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_13_in_ruleXShortClosure6075 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure6096 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_42_in_ruleXShortClosure6118 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXShortClosure6154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression6190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression6200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleXParenthesizedExpression6237 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression6259 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXParenthesizedExpression6270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression6306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression6316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleXIfExpression6362 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleXIfExpression6374 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6395 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXIfExpression6407 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6428 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_ruleXIfExpression6449 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6509 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression6519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleXSwitchExpression6565 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression6606 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXSwitchExpression6618 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6642 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXSwitchExpression6654 = new BitSet(new long[]{0x0005000000001040L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6675 = new BitSet(new long[]{0x0007000000041040L,0x0000000000000010L});
    public static final BitSet FOLLOW_49_in_ruleXSwitchExpression6689 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXSwitchExpression6701 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6722 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleXSwitchExpression6736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart6772 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart6782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6828 = new BitSet(new long[]{0x0005000000000000L});
    public static final BitSet FOLLOW_50_in_ruleXCasePart6842 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6863 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXCasePart6877 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6934 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression6944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleXForLoopExpression6990 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleXForLoopExpression7002 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression7023 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXForLoopExpression7035 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression7056 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXForLoopExpression7068 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression7089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression7125 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression7135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleXWhileExpression7181 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleXWhileExpression7193 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression7214 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXWhileExpression7226 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression7247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7283 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression7293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleXDoWhileExpression7339 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7360 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleXDoWhileExpression7372 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleXDoWhileExpression7384 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7405 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXDoWhileExpression7417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7453 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression7463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleXBlockExpression7509 = new BitSet(new long[]{0xFDF8A21090071070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7531 = new BitSet(new long[]{0xFDF8B21090071070L,0x0000000000000003L});
    public static final BitSet FOLLOW_44_in_ruleXBlockExpression7544 = new BitSet(new long[]{0xFDF8A21090071070L,0x0000000000000003L});
    public static final BitSet FOLLOW_18_in_ruleXBlockExpression7560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7596 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7715 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration7725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleXVariableDeclaration7778 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000010L});
    public static final BitSet FOLLOW_55_in_ruleXVariableDeclaration7809 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7857 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration7878 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration7907 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleXVariableDeclaration7921 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7980 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter7990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter8036 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmFormalParameter8058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_entryRuleFullJvmFormalParameter8094 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFullJvmFormalParameter8104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleFullJvmFormalParameter8150 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleFullJvmFormalParameter8171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall8207 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall8217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall8274 = new BitSet(new long[]{0x0100000010000040L});
    public static final BitSet FOLLOW_28_in_ruleXFeatureCall8288 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000030L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8309 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_13_in_ruleXFeatureCall8322 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000030L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8343 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_27_in_ruleXFeatureCall8357 = new BitSet(new long[]{0x0100000000000040L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall8382 = new BitSet(new long[]{0x0000020000001002L});
    public static final BitSet FOLLOW_12_in_ruleXFeatureCall8416 = new BitSet(new long[]{0xFD38A61090035070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXFeatureCall8501 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8529 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleXFeatureCall8542 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8563 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleXFeatureCall8580 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXFeatureCall8613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper8651 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdOrSuper8662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleIdOrSuper8709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleIdOrSuper8733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8774 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStaticQualifier8785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleStaticQualifier8832 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleStaticQualifier8850 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8891 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall8901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleXConstructorCall8947 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8970 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_28_in_ruleXConstructorCall8983 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000030L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9004 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_13_in_ruleXConstructorCall9017 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000030L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9038 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_27_in_ruleXConstructorCall9052 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleXConstructorCall9066 = new BitSet(new long[]{0xFD38A61090035070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXConstructorCall9138 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall9166 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleXConstructorCall9179 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall9200 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleXConstructorCall9217 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXConstructorCall9248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral9285 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral9295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleXBooleanLiteral9342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleXBooleanLiteral9366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral9416 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral9426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleXNullLiteral9472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral9508 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIntLiteral9518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleXIntLiteral9569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral9610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral9620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral9671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9712 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral9722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleXTypeLiteral9768 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleXTypeLiteral9780 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9803 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXTypeLiteral9815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9851 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression9861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleXThrowExpression9907 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression9928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression9964 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXReturnExpression9974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleXReturnExpression10020 = new BitSet(new long[]{0xFD38A21090031072L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXReturnExpression10051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression10088 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression10098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleXTryCatchFinallyExpression10144 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10165 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression10195 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_66_in_ruleXTryCatchFinallyExpression10217 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleXTryCatchFinallyExpression10261 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause10320 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause10330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleXCatchClause10375 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleXCatchClause10388 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause10409 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXCatchClause10421 = new BitSet(new long[]{0xFD38A21090031070L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause10442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10479 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName10490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName10537 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleQualifiedName10565 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName10588 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference10635 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference10645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10693 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleJvmTypeReference10731 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleJvmTypeReference10743 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference10775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef10810 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef10820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleXFunctionTypeRef10858 = new BitSet(new long[]{0x0000000000005040L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10880 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleXFunctionTypeRef10893 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10914 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleXFunctionTypeRef10930 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleXFunctionTypeRef10944 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference11001 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference11011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference11059 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleJvmParameterizedTypeReference11080 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000030L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11102 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_13_in_ruleJvmParameterizedTypeReference11115 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000030L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11136 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_27_in_ruleJvmParameterizedTypeReference11150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11188 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11307 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleJvmWildcardTypeReference11363 = new BitSet(new long[]{0x0100000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11450 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound11460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleJvmUpperBound11497 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound11518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded11554 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded11564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleJvmUpperBoundAnded11601 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded11622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11658 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound11668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleJvmLowerBound11705 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID11765 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID11776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID11815 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_13_in_synpred15_InternalXbaseWithAnnotations4718 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred15_InternalXbaseWithAnnotations4725 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_42_in_synpred15_InternalXbaseWithAnnotations4739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred16_InternalXbaseWithAnnotations4857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred17_InternalXbaseWithAnnotations5630 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_13_in_synpred17_InternalXbaseWithAnnotations5637 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred17_InternalXbaseWithAnnotations5644 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_42_in_synpred17_InternalXbaseWithAnnotations5658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_synpred19_InternalXbaseWithAnnotations6441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred20_InternalXbaseWithAnnotations6581 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_synpred20_InternalXbaseWithAnnotations6587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred21_InternalXbaseWithAnnotations7827 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred21_InternalXbaseWithAnnotations7836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_synpred22_InternalXbaseWithAnnotations8398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred23_InternalXbaseWithAnnotations8450 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_13_in_synpred23_InternalXbaseWithAnnotations8457 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred23_InternalXbaseWithAnnotations8464 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_42_in_synpred23_InternalXbaseWithAnnotations8478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred24_InternalXbaseWithAnnotations8596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred25_InternalXbaseWithAnnotations9087 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_13_in_synpred25_InternalXbaseWithAnnotations9094 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred25_InternalXbaseWithAnnotations9101 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_42_in_synpred25_InternalXbaseWithAnnotations9115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred26_InternalXbaseWithAnnotations9231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred27_InternalXbaseWithAnnotations10034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_synpred28_InternalXbaseWithAnnotations10179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_synpred29_InternalXbaseWithAnnotations10209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_synpred31_InternalXbaseWithAnnotations10556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred32_InternalXbaseWithAnnotations10708 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_synpred32_InternalXbaseWithAnnotations10712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred33_InternalXbaseWithAnnotations11072 = new BitSet(new long[]{0x0000000000000002L});

}