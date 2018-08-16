package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ContentAssistNoTerminalExtensionTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalContentAssistNoTerminalExtensionTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "'octagon'", "'oval'", "'parallelogram'", "'pentagon'", "'plain'", "'plaintext'", "'point'", "'polygon'", "'primersite'", "'promoter'", "'proteasesite'", "'proteinstab'", "'rarrow'", "'record'", "'rect'", "'rectangle'", "'restrictionsite'", "'ribosite'", "'rnastab'", "'rpromoter'"
    };
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
    public static final int T__10=10;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int T__7=7;
    public static final int T__6=6;
    public static final int T__5=5;
    public static final int T__4=4;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalContentAssistNoTerminalExtensionTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContentAssistNoTerminalExtensionTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContentAssistNoTerminalExtensionTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalContentAssistNoTerminalExtensionTestLanguage.g"; }



     	private ContentAssistNoTerminalExtensionTestLanguageGrammarAccess grammarAccess;

        public InternalContentAssistNoTerminalExtensionTestLanguageParser(TokenStream input, ContentAssistNoTerminalExtensionTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "PolygonBasedShape";
       	}

       	@Override
       	protected ContentAssistNoTerminalExtensionTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRulePolygonBasedShape"
    // InternalContentAssistNoTerminalExtensionTestLanguage.g:65:1: entryRulePolygonBasedShape returns [EObject current=null] : iv_rulePolygonBasedShape= rulePolygonBasedShape EOF ;
    public final EObject entryRulePolygonBasedShape() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePolygonBasedShape = null;


        try {
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:65:58: (iv_rulePolygonBasedShape= rulePolygonBasedShape EOF )
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:66:2: iv_rulePolygonBasedShape= rulePolygonBasedShape EOF
            {
             newCompositeNode(grammarAccess.getPolygonBasedShapeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePolygonBasedShape=rulePolygonBasedShape();

            state._fsp--;

             current =iv_rulePolygonBasedShape; 
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
    // $ANTLR end "entryRulePolygonBasedShape"


    // $ANTLR start "rulePolygonBasedShape"
    // InternalContentAssistNoTerminalExtensionTestLanguage.g:72:1: rulePolygonBasedShape returns [EObject current=null] : ( (lv_shape_0_0= rulePolygonBasedNodeShape ) ) ;
    public final EObject rulePolygonBasedShape() throws RecognitionException {
        EObject current = null;

        Enumerator lv_shape_0_0 = null;



        	enterRule();

        try {
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:78:2: ( ( (lv_shape_0_0= rulePolygonBasedNodeShape ) ) )
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:79:2: ( (lv_shape_0_0= rulePolygonBasedNodeShape ) )
            {
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:79:2: ( (lv_shape_0_0= rulePolygonBasedNodeShape ) )
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:80:3: (lv_shape_0_0= rulePolygonBasedNodeShape )
            {
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:80:3: (lv_shape_0_0= rulePolygonBasedNodeShape )
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:81:4: lv_shape_0_0= rulePolygonBasedNodeShape
            {

            				newCompositeNode(grammarAccess.getPolygonBasedShapeAccess().getShapePolygonBasedNodeShapeEnumRuleCall_0());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            lv_shape_0_0=rulePolygonBasedNodeShape();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getPolygonBasedShapeRule());
            				}
            				set(
            					current,
            					"shape",
            					lv_shape_0_0,
            					"org.eclipse.xtext.ui.tests.editor.contentassist.ContentAssistNoTerminalExtensionTestLanguage.PolygonBasedNodeShape");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "rulePolygonBasedShape"


    // $ANTLR start "rulePolygonBasedNodeShape"
    // InternalContentAssistNoTerminalExtensionTestLanguage.g:101:1: rulePolygonBasedNodeShape returns [Enumerator current=null] : ( (enumLiteral_0= 'octagon' ) | (enumLiteral_1= 'oval' ) | (enumLiteral_2= 'parallelogram' ) | (enumLiteral_3= 'pentagon' ) | (enumLiteral_4= 'plain' ) | (enumLiteral_5= 'plaintext' ) | (enumLiteral_6= 'point' ) | (enumLiteral_7= 'polygon' ) | (enumLiteral_8= 'primersite' ) | (enumLiteral_9= 'promoter' ) | (enumLiteral_10= 'proteasesite' ) | (enumLiteral_11= 'proteinstab' ) | (enumLiteral_12= 'rarrow' ) | (enumLiteral_13= 'record' ) | (enumLiteral_14= 'rect' ) | (enumLiteral_15= 'rectangle' ) | (enumLiteral_16= 'restrictionsite' ) | (enumLiteral_17= 'ribosite' ) | (enumLiteral_18= 'rnastab' ) | (enumLiteral_19= 'rpromoter' ) ) ;
    public final Enumerator rulePolygonBasedNodeShape() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;
        Token enumLiteral_16=null;
        Token enumLiteral_17=null;
        Token enumLiteral_18=null;
        Token enumLiteral_19=null;


        	enterRule();

        try {
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:107:2: ( ( (enumLiteral_0= 'octagon' ) | (enumLiteral_1= 'oval' ) | (enumLiteral_2= 'parallelogram' ) | (enumLiteral_3= 'pentagon' ) | (enumLiteral_4= 'plain' ) | (enumLiteral_5= 'plaintext' ) | (enumLiteral_6= 'point' ) | (enumLiteral_7= 'polygon' ) | (enumLiteral_8= 'primersite' ) | (enumLiteral_9= 'promoter' ) | (enumLiteral_10= 'proteasesite' ) | (enumLiteral_11= 'proteinstab' ) | (enumLiteral_12= 'rarrow' ) | (enumLiteral_13= 'record' ) | (enumLiteral_14= 'rect' ) | (enumLiteral_15= 'rectangle' ) | (enumLiteral_16= 'restrictionsite' ) | (enumLiteral_17= 'ribosite' ) | (enumLiteral_18= 'rnastab' ) | (enumLiteral_19= 'rpromoter' ) ) )
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:108:2: ( (enumLiteral_0= 'octagon' ) | (enumLiteral_1= 'oval' ) | (enumLiteral_2= 'parallelogram' ) | (enumLiteral_3= 'pentagon' ) | (enumLiteral_4= 'plain' ) | (enumLiteral_5= 'plaintext' ) | (enumLiteral_6= 'point' ) | (enumLiteral_7= 'polygon' ) | (enumLiteral_8= 'primersite' ) | (enumLiteral_9= 'promoter' ) | (enumLiteral_10= 'proteasesite' ) | (enumLiteral_11= 'proteinstab' ) | (enumLiteral_12= 'rarrow' ) | (enumLiteral_13= 'record' ) | (enumLiteral_14= 'rect' ) | (enumLiteral_15= 'rectangle' ) | (enumLiteral_16= 'restrictionsite' ) | (enumLiteral_17= 'ribosite' ) | (enumLiteral_18= 'rnastab' ) | (enumLiteral_19= 'rpromoter' ) )
            {
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:108:2: ( (enumLiteral_0= 'octagon' ) | (enumLiteral_1= 'oval' ) | (enumLiteral_2= 'parallelogram' ) | (enumLiteral_3= 'pentagon' ) | (enumLiteral_4= 'plain' ) | (enumLiteral_5= 'plaintext' ) | (enumLiteral_6= 'point' ) | (enumLiteral_7= 'polygon' ) | (enumLiteral_8= 'primersite' ) | (enumLiteral_9= 'promoter' ) | (enumLiteral_10= 'proteasesite' ) | (enumLiteral_11= 'proteinstab' ) | (enumLiteral_12= 'rarrow' ) | (enumLiteral_13= 'record' ) | (enumLiteral_14= 'rect' ) | (enumLiteral_15= 'rectangle' ) | (enumLiteral_16= 'restrictionsite' ) | (enumLiteral_17= 'ribosite' ) | (enumLiteral_18= 'rnastab' ) | (enumLiteral_19= 'rpromoter' ) )
            int alt1=20;
            switch ( input.LA(1) ) {
            case 4:
                {
                alt1=1;
                }
                break;
            case 5:
                {
                alt1=2;
                }
                break;
            case 6:
                {
                alt1=3;
                }
                break;
            case 7:
                {
                alt1=4;
                }
                break;
            case 8:
                {
                alt1=5;
                }
                break;
            case 9:
                {
                alt1=6;
                }
                break;
            case 10:
                {
                alt1=7;
                }
                break;
            case 11:
                {
                alt1=8;
                }
                break;
            case 12:
                {
                alt1=9;
                }
                break;
            case 13:
                {
                alt1=10;
                }
                break;
            case 14:
                {
                alt1=11;
                }
                break;
            case 15:
                {
                alt1=12;
                }
                break;
            case 16:
                {
                alt1=13;
                }
                break;
            case 17:
                {
                alt1=14;
                }
                break;
            case 18:
                {
                alt1=15;
                }
                break;
            case 19:
                {
                alt1=16;
                }
                break;
            case 20:
                {
                alt1=17;
                }
                break;
            case 21:
                {
                alt1=18;
                }
                break;
            case 22:
                {
                alt1=19;
                }
                break;
            case 23:
                {
                alt1=20;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:109:3: (enumLiteral_0= 'octagon' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:109:3: (enumLiteral_0= 'octagon' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:110:4: enumLiteral_0= 'octagon'
                    {
                    enumLiteral_0=(Token)match(input,4,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getOctagonEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPolygonBasedNodeShapeAccess().getOctagonEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:117:3: (enumLiteral_1= 'oval' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:117:3: (enumLiteral_1= 'oval' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:118:4: enumLiteral_1= 'oval'
                    {
                    enumLiteral_1=(Token)match(input,5,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getOvalEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPolygonBasedNodeShapeAccess().getOvalEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:125:3: (enumLiteral_2= 'parallelogram' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:125:3: (enumLiteral_2= 'parallelogram' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:126:4: enumLiteral_2= 'parallelogram'
                    {
                    enumLiteral_2=(Token)match(input,6,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getParallelogramEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getPolygonBasedNodeShapeAccess().getParallelogramEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:133:3: (enumLiteral_3= 'pentagon' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:133:3: (enumLiteral_3= 'pentagon' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:134:4: enumLiteral_3= 'pentagon'
                    {
                    enumLiteral_3=(Token)match(input,7,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getPentagonEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getPolygonBasedNodeShapeAccess().getPentagonEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:141:3: (enumLiteral_4= 'plain' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:141:3: (enumLiteral_4= 'plain' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:142:4: enumLiteral_4= 'plain'
                    {
                    enumLiteral_4=(Token)match(input,8,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getPlainEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getPolygonBasedNodeShapeAccess().getPlainEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:149:3: (enumLiteral_5= 'plaintext' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:149:3: (enumLiteral_5= 'plaintext' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:150:4: enumLiteral_5= 'plaintext'
                    {
                    enumLiteral_5=(Token)match(input,9,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getPlaintextEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getPolygonBasedNodeShapeAccess().getPlaintextEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:157:3: (enumLiteral_6= 'point' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:157:3: (enumLiteral_6= 'point' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:158:4: enumLiteral_6= 'point'
                    {
                    enumLiteral_6=(Token)match(input,10,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getPointEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getPolygonBasedNodeShapeAccess().getPointEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:165:3: (enumLiteral_7= 'polygon' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:165:3: (enumLiteral_7= 'polygon' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:166:4: enumLiteral_7= 'polygon'
                    {
                    enumLiteral_7=(Token)match(input,11,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getPolygonEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getPolygonBasedNodeShapeAccess().getPolygonEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:173:3: (enumLiteral_8= 'primersite' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:173:3: (enumLiteral_8= 'primersite' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:174:4: enumLiteral_8= 'primersite'
                    {
                    enumLiteral_8=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getPrimersiteEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getPolygonBasedNodeShapeAccess().getPrimersiteEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:181:3: (enumLiteral_9= 'promoter' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:181:3: (enumLiteral_9= 'promoter' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:182:4: enumLiteral_9= 'promoter'
                    {
                    enumLiteral_9=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getPromoterEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getPolygonBasedNodeShapeAccess().getPromoterEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:189:3: (enumLiteral_10= 'proteasesite' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:189:3: (enumLiteral_10= 'proteasesite' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:190:4: enumLiteral_10= 'proteasesite'
                    {
                    enumLiteral_10=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getProteasesiteEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getPolygonBasedNodeShapeAccess().getProteasesiteEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:197:3: (enumLiteral_11= 'proteinstab' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:197:3: (enumLiteral_11= 'proteinstab' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:198:4: enumLiteral_11= 'proteinstab'
                    {
                    enumLiteral_11=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getProteinstabEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getPolygonBasedNodeShapeAccess().getProteinstabEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:205:3: (enumLiteral_12= 'rarrow' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:205:3: (enumLiteral_12= 'rarrow' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:206:4: enumLiteral_12= 'rarrow'
                    {
                    enumLiteral_12=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getRarrowEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getPolygonBasedNodeShapeAccess().getRarrowEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:213:3: (enumLiteral_13= 'record' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:213:3: (enumLiteral_13= 'record' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:214:4: enumLiteral_13= 'record'
                    {
                    enumLiteral_13=(Token)match(input,17,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getRecordEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getPolygonBasedNodeShapeAccess().getRecordEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:221:3: (enumLiteral_14= 'rect' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:221:3: (enumLiteral_14= 'rect' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:222:4: enumLiteral_14= 'rect'
                    {
                    enumLiteral_14=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getRectEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getPolygonBasedNodeShapeAccess().getRectEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:229:3: (enumLiteral_15= 'rectangle' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:229:3: (enumLiteral_15= 'rectangle' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:230:4: enumLiteral_15= 'rectangle'
                    {
                    enumLiteral_15=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getRectangleEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getPolygonBasedNodeShapeAccess().getRectangleEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:237:3: (enumLiteral_16= 'restrictionsite' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:237:3: (enumLiteral_16= 'restrictionsite' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:238:4: enumLiteral_16= 'restrictionsite'
                    {
                    enumLiteral_16=(Token)match(input,20,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getRestrictionsiteEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getPolygonBasedNodeShapeAccess().getRestrictionsiteEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:245:3: (enumLiteral_17= 'ribosite' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:245:3: (enumLiteral_17= 'ribosite' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:246:4: enumLiteral_17= 'ribosite'
                    {
                    enumLiteral_17=(Token)match(input,21,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getRibositeEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getPolygonBasedNodeShapeAccess().getRibositeEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:253:3: (enumLiteral_18= 'rnastab' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:253:3: (enumLiteral_18= 'rnastab' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:254:4: enumLiteral_18= 'rnastab'
                    {
                    enumLiteral_18=(Token)match(input,22,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getRnastabEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getPolygonBasedNodeShapeAccess().getRnastabEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:261:3: (enumLiteral_19= 'rpromoter' )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:261:3: (enumLiteral_19= 'rpromoter' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:262:4: enumLiteral_19= 'rpromoter'
                    {
                    enumLiteral_19=(Token)match(input,23,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getPolygonBasedNodeShapeAccess().getRpromoterEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getPolygonBasedNodeShapeAccess().getRpromoterEnumLiteralDeclaration_19());
                    			

                    }


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
    // $ANTLR end "rulePolygonBasedNodeShape"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    }


}