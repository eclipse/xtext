package org.eclipse.xtext.valueconverter.parser.antlr.internal; 

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
import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug250313Parser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#'", "'mykeyword1'", "'!'", "'$'", "'content'", "'ref'", "'>>'", "'-'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug250313Parser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g"; }


     
     	private Bug250313GrammarAccess grammarAccess;
     	
        public InternalBug250313Parser(TokenStream input, IAstFactory factory, Bug250313GrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalBug250313Parser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:70:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:70:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:71:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.prModel().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel72);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel82); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:78:1: ruleModel returns [EObject current=null] : ( ( ( ( ( '#' )? (lv_value_1= ( ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype ) | RULE_ID ) ) ) | ( '!' (lv_value_3= RULE_STRING ) ) ) | ( '$' (lv_value_5= ruleDatatype ) ) ) | ( ( 'content' (lv_children_7= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_value_1=null;
        Token lv_value_3=null;
        AntlrDatatypeRuleToken lv_value_5 = null;

        EObject lv_children_7 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:83:6: ( ( ( ( ( ( '#' )? (lv_value_1= ( ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype ) | RULE_ID ) ) ) | ( '!' (lv_value_3= RULE_STRING ) ) ) | ( '$' (lv_value_5= ruleDatatype ) ) ) | ( ( 'content' (lv_children_7= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:1: ( ( ( ( ( '#' )? (lv_value_1= ( ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype ) | RULE_ID ) ) ) | ( '!' (lv_value_3= RULE_STRING ) ) ) | ( '$' (lv_value_5= ruleDatatype ) ) ) | ( ( 'content' (lv_children_7= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:1: ( ( ( ( ( '#' )? (lv_value_1= ( ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype ) | RULE_ID ) ) ) | ( '!' (lv_value_3= RULE_STRING ) ) ) | ( '$' (lv_value_5= ruleDatatype ) ) ) | ( ( 'content' (lv_children_7= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=RULE_STRING && LA9_0<=RULE_ID)||(LA9_0>=11 && LA9_0<=14)||LA9_0==17) ) {
                alt9=1;
            }
            else if ( (LA9_0==15) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("84:1: ( ( ( ( ( '#' )? (lv_value_1= ( ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype ) | RULE_ID ) ) ) | ( '!' (lv_value_3= RULE_STRING ) ) ) | ( '$' (lv_value_5= ruleDatatype ) ) ) | ( ( 'content' (lv_children_7= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:2: ( ( ( ( '#' )? (lv_value_1= ( ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype ) | RULE_ID ) ) ) | ( '!' (lv_value_3= RULE_STRING ) ) ) | ( '$' (lv_value_5= ruleDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:2: ( ( ( ( '#' )? (lv_value_1= ( ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype ) | RULE_ID ) ) ) | ( '!' (lv_value_3= RULE_STRING ) ) ) | ( '$' (lv_value_5= ruleDatatype ) ) )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=RULE_STRING && LA6_0<=RULE_ID)||(LA6_0>=11 && LA6_0<=13)||LA6_0==17) ) {
                        alt6=1;
                    }
                    else if ( (LA6_0==14) ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("84:2: ( ( ( ( '#' )? (lv_value_1= ( ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype ) | RULE_ID ) ) ) | ( '!' (lv_value_3= RULE_STRING ) ) ) | ( '$' (lv_value_5= ruleDatatype ) ) )", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:3: ( ( ( '#' )? (lv_value_1= ( ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype ) | RULE_ID ) ) ) | ( '!' (lv_value_3= RULE_STRING ) ) )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:3: ( ( ( '#' )? (lv_value_1= ( ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype ) | RULE_ID ) ) ) | ( '!' (lv_value_3= RULE_STRING ) ) )
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( ((LA5_0>=RULE_STRING && LA5_0<=RULE_ID)||(LA5_0>=11 && LA5_0<=12)||LA5_0==17) ) {
                                alt5=1;
                            }
                            else if ( (LA5_0==13) ) {
                                alt5=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("84:3: ( ( ( '#' )? (lv_value_1= ( ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype ) | RULE_ID ) ) ) | ( '!' (lv_value_3= RULE_STRING ) ) )", 5, 0, input);

                                throw nvae;
                            }
                            switch (alt5) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:4: ( ( '#' )? (lv_value_1= ( ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype ) | RULE_ID ) ) )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:4: ( ( '#' )? (lv_value_1= ( ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype ) | RULE_ID ) ) )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:5: ( '#' )? (lv_value_1= ( ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype ) | RULE_ID ) )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:5: ( '#' )?
                                    int alt1=2;
                                    int LA1_0 = input.LA(1);

                                    if ( (LA1_0==11) ) {
                                        alt1=1;
                                    }
                                    switch (alt1) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:6: '#'
                                            {
                                            match(input,11,FOLLOW_11_in_ruleModel120); 

                                                    createLeafNode(grammarAccess.prModel().ele0000KeywordNumberSign(), null); 
                                                

                                            }
                                            break;

                                    }

                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:88:3: (lv_value_1= ( ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype ) | RULE_ID ) )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:90:6: lv_value_1= ( ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype ) | RULE_ID )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:90:17: ( ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype ) | RULE_ID )
                                    int alt4=2;
                                    int LA4_0 = input.LA(1);

                                    if ( (LA4_0==RULE_STRING||LA4_0==12||LA4_0==17) ) {
                                        alt4=1;
                                    }
                                    else if ( (LA4_0==RULE_ID) ) {
                                        alt4=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("90:17: ( ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype ) | RULE_ID )", 4, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt4) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:90:18: ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype )
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:90:18: ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype )
                                            int alt3=2;
                                            int LA3_0 = input.LA(1);

                                            if ( (LA3_0==RULE_STRING||LA3_0==12) ) {
                                                alt3=1;
                                            }
                                            else if ( (LA3_0==17) ) {
                                                alt3=2;
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("90:18: ( ( 'mykeyword1' | RULE_STRING ) | ruleDatatype )", 3, 0, input);

                                                throw nvae;
                                            }
                                            switch (alt3) {
                                                case 1 :
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:90:19: ( 'mykeyword1' | RULE_STRING )
                                                    {
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:90:19: ( 'mykeyword1' | RULE_STRING )
                                                    int alt2=2;
                                                    int LA2_0 = input.LA(1);

                                                    if ( (LA2_0==12) ) {
                                                        alt2=1;
                                                    }
                                                    else if ( (LA2_0==RULE_STRING) ) {
                                                        alt2=2;
                                                    }
                                                    else {
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("90:19: ( 'mykeyword1' | RULE_STRING )", 2, 0, input);

                                                        throw nvae;
                                                    }
                                                    switch (alt2) {
                                                        case 1 :
                                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:90:20: 'mykeyword1'
                                                            {
                                                            match(input,12,FOLLOW_12_in_ruleModel146); 

                                                                    createLeafNode(grammarAccess.prModel().ele00010000KeywordMykeyword1(), "value"); 
                                                                

                                                            }
                                                            break;
                                                        case 2 :
                                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:96:7: RULE_STRING
                                                            {
                                                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel163); 

                                                            		createLeafNode(grammarAccess.prModel().ele00010001LexerRuleCallSTRING(), "value"); 
                                                            	

                                                            }
                                                            break;

                                                    }


                                                    }
                                                    break;
                                                case 2 :
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:102:8: ruleDatatype
                                                    {
                                                     
                                                    	        currentNode=createCompositeNode(grammarAccess.prModel().ele0001001ParserRuleCallDatatype(), currentNode); 
                                                    	    
                                                    pushFollow(FOLLOW_ruleDatatype_in_ruleModel182);
                                                    ruleDatatype();
                                                    _fsp--;

                                                     
                                                    	        currentNode = currentNode.getParent();
                                                    	    

                                                    }
                                                    break;

                                            }


                                            }
                                            break;
                                        case 2 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:110:7: RULE_ID
                                            {
                                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel196); 

                                            		createLeafNode(grammarAccess.prModel().ele000101LexerRuleCallID(), "value"); 
                                            	

                                            }
                                            break;

                                    }


                                    	        if (current==null) {
                                    	            current = factory.create("Model");
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        
                                    	        try {
                                    	       		set(current, "value", /* lv_value_1 */ input.LT(-1), null, lastConsumedNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	    

                                    }


                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:130:6: ( '!' (lv_value_3= RULE_STRING ) )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:130:6: ( '!' (lv_value_3= RULE_STRING ) )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:130:7: '!' (lv_value_3= RULE_STRING )
                                    {
                                    match(input,13,FOLLOW_13_in_ruleModel223); 

                                            createLeafNode(grammarAccess.prModel().ele0010KeywordExclamationMark(), null); 
                                        
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:134:1: (lv_value_3= RULE_STRING )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:136:6: lv_value_3= RULE_STRING
                                    {
                                    lv_value_3=(Token)input.LT(1);
                                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel245); 

                                    		createLeafNode(grammarAccess.prModel().ele00110LexerRuleCallSTRING(), "value"); 
                                    	

                                    	        if (current==null) {
                                    	            current = factory.create("Model");
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        
                                    	        try {
                                    	       		set(current, "value", lv_value_3, "STRING", lastConsumedNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	    

                                    }


                                    }


                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:155:6: ( '$' (lv_value_5= ruleDatatype ) )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:155:6: ( '$' (lv_value_5= ruleDatatype ) )
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:155:7: '$' (lv_value_5= ruleDatatype )
                            {
                            match(input,14,FOLLOW_14_in_ruleModel271); 

                                    createLeafNode(grammarAccess.prModel().ele010Keyword$(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:159:1: (lv_value_5= ruleDatatype )
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:162:6: lv_value_5= ruleDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prModel().ele0110ParserRuleCallDatatype(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleDatatype_in_ruleModel305);
                            lv_value_5=ruleDatatype();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create("Model");
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "value", lv_value_5, "Datatype", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:181:6: ( ( 'content' (lv_children_7= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:181:6: ( ( 'content' (lv_children_7= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:181:7: ( 'content' (lv_children_7= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )?
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:181:7: ( 'content' (lv_children_7= ruleChild ) )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:181:8: 'content' (lv_children_7= ruleChild )
                    {
                    match(input,15,FOLLOW_15_in_ruleModel328); 

                            createLeafNode(grammarAccess.prModel().ele100KeywordContent(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:185:1: (lv_children_7= ruleChild )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:188:6: lv_children_7= ruleChild
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prModel().ele1010ParserRuleCallChild(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleChild_in_ruleModel362);
                    lv_children_7=ruleChild();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("Model");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "children", lv_children_7, "Child", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:206:3: ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==16) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:206:4: 'ref' ( ( RULE_STRING | RULE_ID ) )
                            {
                            match(input,16,FOLLOW_16_in_ruleModel377); 

                                    createLeafNode(grammarAccess.prModel().ele110KeywordRef(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:210:1: ( ( RULE_STRING | RULE_ID ) )
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:213:3: ( RULE_STRING | RULE_ID )
                            {

                            			if (current==null) {
                            	            current = factory.create("Model");
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:219:1: ( RULE_STRING | RULE_ID )
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==RULE_STRING) ) {
                                alt7=1;
                            }
                            else if ( (LA7_0==RULE_ID) ) {
                                alt7=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("219:1: ( RULE_STRING | RULE_ID )", 7, 0, input);

                                throw nvae;
                            }
                            switch (alt7) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:219:3: RULE_STRING
                                    {
                                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel400); 

                                    		createLeafNode(grammarAccess.prModel().ele11100CrossReferenceEStringChild1(), "ref"); 
                                    	

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:224:7: RULE_ID
                                    {
                                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel412); 

                                    		createLeafNode(grammarAccess.prModel().ele11101CrossReferenceEStringChild2(), "ref"); 
                                    	

                                    }
                                    break;

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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleDatatype
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:241:1: entryRuleDatatype returns [String current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final String entryRuleDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatype = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:241:49: (iv_ruleDatatype= ruleDatatype EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:242:2: iv_ruleDatatype= ruleDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.prDatatype().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleDatatype_in_entryRuleDatatype456);
            iv_ruleDatatype=ruleDatatype();
            _fsp--;

             current =iv_ruleDatatype.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDatatype467); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDatatype


    // $ANTLR start ruleDatatype
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:249:1: ruleDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '>>' this_ID_1= RULE_ID ) kw= '-' ) this_ID_3= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;
        Token this_ID_3=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:255:6: ( ( ( (kw= '>>' this_ID_1= RULE_ID ) kw= '-' ) this_ID_3= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:256:1: ( ( (kw= '>>' this_ID_1= RULE_ID ) kw= '-' ) this_ID_3= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:256:1: ( ( (kw= '>>' this_ID_1= RULE_ID ) kw= '-' ) this_ID_3= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:256:2: ( (kw= '>>' this_ID_1= RULE_ID ) kw= '-' ) this_ID_3= RULE_ID
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:256:2: ( (kw= '>>' this_ID_1= RULE_ID ) kw= '-' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:256:3: (kw= '>>' this_ID_1= RULE_ID ) kw= '-'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:256:3: (kw= '>>' this_ID_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:257:2: kw= '>>' this_ID_1= RULE_ID
            {
            kw=(Token)input.LT(1);
            match(input,17,FOLLOW_17_in_ruleDatatype507); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.prDatatype().ele000KeywordGreaterThanSignGreaterThanSign(), null); 
                
            this_ID_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDatatype522); 

            		current.merge(this_ID_1);
                
             
                createLeafNode(grammarAccess.prDatatype().ele001LexerRuleCallID(), null); 
                

            }

            kw=(Token)input.LT(1);
            match(input,18,FOLLOW_18_in_ruleDatatype541); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.prDatatype().ele01KeywordHyphenMinus(), null); 
                

            }

            this_ID_3=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDatatype557); 

            		current.merge(this_ID_3);
                
             
                createLeafNode(grammarAccess.prDatatype().ele1LexerRuleCallID(), null); 
                

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
            	    lastConsumedDatatypeToken = current;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleDatatype


    // $ANTLR start entryRuleChild
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:292:1: entryRuleChild returns [EObject current=null] : iv_ruleChild= ruleChild EOF ;
    public final EObject entryRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:292:47: (iv_ruleChild= ruleChild EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:293:2: iv_ruleChild= ruleChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.prChild().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleChild_in_entryRuleChild602);
            iv_ruleChild=ruleChild();
            _fsp--;

             current =iv_ruleChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChild612); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleChild


    // $ANTLR start ruleChild
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:300:1: ruleChild returns [EObject current=null] : (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 ) ;
    public final EObject ruleChild() throws RecognitionException {
        EObject current = null;

        EObject this_Child1_0 = null;

        EObject this_Child2_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:305:6: ( (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:306:1: (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:306:1: (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_STRING) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("306:1: (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:307:5: this_Child1_0= ruleChild1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prChild().ele0ParserRuleCallChild1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleChild1_in_ruleChild659);
                    this_Child1_0=ruleChild1();
                    _fsp--;

                     
                            current = this_Child1_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:317:5: this_Child2_1= ruleChild2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prChild().ele1ParserRuleCallChild2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleChild2_in_ruleChild686);
                    this_Child2_1=ruleChild2();
                    _fsp--;

                     
                            current = this_Child2_1; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleChild


    // $ANTLR start entryRuleChild1
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:334:1: entryRuleChild1 returns [EObject current=null] : iv_ruleChild1= ruleChild1 EOF ;
    public final EObject entryRuleChild1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild1 = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:334:48: (iv_ruleChild1= ruleChild1 EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:335:2: iv_ruleChild1= ruleChild1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prChild1().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleChild1_in_entryRuleChild1720);
            iv_ruleChild1=ruleChild1();
            _fsp--;

             current =iv_ruleChild1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChild1730); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleChild1


    // $ANTLR start ruleChild1
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:342:1: ruleChild1 returns [EObject current=null] : (lv_name_0= RULE_ID ) ;
    public final EObject ruleChild1() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:347:6: ( (lv_name_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:348:1: (lv_name_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:348:1: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:350:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChild1776); 

            		createLeafNode(grammarAccess.prChild1().ele0LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create("Child1");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // $ANTLR end ruleChild1


    // $ANTLR start entryRuleChild2
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:377:1: entryRuleChild2 returns [EObject current=null] : iv_ruleChild2= ruleChild2 EOF ;
    public final EObject entryRuleChild2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:377:48: (iv_ruleChild2= ruleChild2 EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:378:2: iv_ruleChild2= ruleChild2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prChild2().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleChild2_in_entryRuleChild2818);
            iv_ruleChild2=ruleChild2();
            _fsp--;

             current =iv_ruleChild2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChild2828); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleChild2


    // $ANTLR start ruleChild2
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:385:1: ruleChild2 returns [EObject current=null] : (lv_name_0= RULE_STRING ) ;
    public final EObject ruleChild2() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:390:6: ( (lv_name_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:391:1: (lv_name_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:391:1: (lv_name_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:393:6: lv_name_0= RULE_STRING
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleChild2874); 

            		createLeafNode(grammarAccess.prChild2().ele0LexerRuleCallSTRING(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create("Child2");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // $ANTLR end ruleChild2


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleModel120 = new BitSet(new long[]{0x0000000000021030L});
    public static final BitSet FOLLOW_12_in_ruleModel146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleModel182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleModel223 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleModel271 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleModel305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleModel328 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleChild_in_ruleModel362 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleModel377 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_entryRuleDatatype456 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDatatype467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleDatatype507 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype522 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleDatatype541 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild_in_entryRuleChild602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChild612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild1_in_ruleChild659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild2_in_ruleChild686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild1_in_entryRuleChild1720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChild1730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChild1776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild2_in_entryRuleChild2818 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChild2828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleChild2874 = new BitSet(new long[]{0x0000000000000002L});

}