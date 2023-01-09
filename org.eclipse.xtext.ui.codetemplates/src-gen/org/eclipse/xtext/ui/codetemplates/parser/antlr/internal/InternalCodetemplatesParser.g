/*******************************************************************************
 * Copyright (c) 2015, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
parser grammar InternalCodetemplatesParser;

options {
	tokenVocab=InternalCodetemplatesLexer;
	superClass=AbstractInternalAntlrParser;
}

@header {
package org.eclipse.xtext.ui.codetemplates.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.codetemplates.services.CodetemplatesGrammarAccess;

}

@members {

 	private CodetemplatesGrammarAccess grammarAccess;

    public InternalCodetemplatesParser(TokenStream input, CodetemplatesGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Codetemplates";
   	}

   	@Override
   	protected CodetemplatesGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleCodetemplates
entryRuleCodetemplates returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCodetemplatesRule()); }
	iv_ruleCodetemplates=ruleCodetemplates
	{ $current=$iv_ruleCodetemplates.current; }
	EOF;

// Rule Codetemplates
ruleCodetemplates returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0=Templates
		{
			newLeafNode(otherlv_0, grammarAccess.getCodetemplatesAccess().getTemplatesKeyword_0());
		}
		otherlv_1=For
		{
			newLeafNode(otherlv_1, grammarAccess.getCodetemplatesAccess().getForKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getCodetemplatesRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getCodetemplatesAccess().getLanguageGrammarCrossReference_2_0());
				}
				ruleFQN
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=Colon
		{
			newLeafNode(otherlv_3, grammarAccess.getCodetemplatesAccess().getColonKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCodetemplatesAccess().getTemplatesCodetemplateParserRuleCall_4_0());
				}
				lv_templates_4_0=ruleCodetemplate
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCodetemplatesRule());
					}
					add(
						$current,
						"templates",
						lv_templates_4_0,
						"org.eclipse.xtext.ui.codetemplates.Codetemplates.Codetemplate");
					afterParserOrEnumRuleCall();
				}
			)
		)*
	)
;

// Entry rule entryRuleCodetemplate
entryRuleCodetemplate returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCodetemplateRule()); }
	iv_ruleCodetemplate=ruleCodetemplate
	{ $current=$iv_ruleCodetemplate.current; }
	EOF;

// Rule Codetemplate
ruleCodetemplate returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getCodetemplateAccess().getNameValidIDParserRuleCall_0_0());
				}
				lv_name_0_0=ruleValidID
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCodetemplateRule());
					}
					set(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtext.ui.codetemplates.Codetemplates.ValidID");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1=LeftParenthesis
		{
			newLeafNode(otherlv_1, grammarAccess.getCodetemplateAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				lv_id_2_0=RULE_ID
				{
					newLeafNode(lv_id_2_0, grammarAccess.getCodetemplateAccess().getIdIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getCodetemplateRule());
					}
					setWithLastConsumed(
						$current,
						"id",
						lv_id_2_0,
						"org.eclipse.xtext.ui.codetemplates.Codetemplates.ID");
				}
			)
		)
		otherlv_3=Comma
		{
			newLeafNode(otherlv_3, grammarAccess.getCodetemplateAccess().getCommaKeyword_3());
		}
		(
			(
				lv_description_4_0=RULE_STRING
				{
					newLeafNode(lv_description_4_0, grammarAccess.getCodetemplateAccess().getDescriptionSTRINGTerminalRuleCall_4_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getCodetemplateRule());
					}
					setWithLastConsumed(
						$current,
						"description",
						lv_description_4_0,
						"org.eclipse.xtext.ui.codetemplates.Codetemplates.STRING");
				}
			)
		)
		otherlv_5=RightParenthesis
		{
			newLeafNode(otherlv_5, grammarAccess.getCodetemplateAccess().getRightParenthesisKeyword_5());
		}
		otherlv_6=For
		{
			newLeafNode(otherlv_6, grammarAccess.getCodetemplateAccess().getForKeyword_6());
		}
		(
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getCodetemplateRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getCodetemplateAccess().getContextAbstractRuleCrossReference_7_0_0());
					}
					ruleValidID
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					lv_keywordContext_8_0=RULE_STRING
					{
						newLeafNode(lv_keywordContext_8_0, grammarAccess.getCodetemplateAccess().getKeywordContextSTRINGTerminalRuleCall_7_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getCodetemplateRule());
						}
						setWithLastConsumed(
							$current,
							"keywordContext",
							lv_keywordContext_8_0,
							"org.eclipse.xtext.ui.codetemplates.Codetemplates.STRING");
					}
				)
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getCodetemplateAccess().getBodyTemplateBodyWithQuotesParserRuleCall_8_0());
				}
				lv_body_9_0=ruleTemplateBodyWithQuotes
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCodetemplateRule());
					}
					set(
						$current,
						"body",
						lv_body_9_0,
						"org.eclipse.xtext.ui.codetemplates.Codetemplates.TemplateBodyWithQuotes");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleTemplateBodyWithQuotes
entryRuleTemplateBodyWithQuotes returns [EObject current=null]@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	{ newCompositeNode(grammarAccess.getTemplateBodyWithQuotesRule()); }
	iv_ruleTemplateBodyWithQuotes=ruleTemplateBodyWithQuotes
	{ $current=$iv_ruleTemplateBodyWithQuotes.current; }
	EOF;
finally {
	myHiddenTokenState.restore();
}

// Rule TemplateBodyWithQuotes
ruleTemplateBodyWithQuotes returns [EObject current=null]
@init {
	enterRule();
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
@after {
	leaveRule();
}:
	(
		(
			this_WS_0=RULE_WS
			{
				newLeafNode(this_WS_0, grammarAccess.getTemplateBodyWithQuotesAccess().getWSTerminalRuleCall_0());
			}
		)?
		otherlv_1=GreaterThanSignGreaterThanSign
		{
			newLeafNode(otherlv_1, grammarAccess.getTemplateBodyWithQuotesAccess().getGreaterThanSignGreaterThanSignKeyword_1());
		}
		{
			newCompositeNode(grammarAccess.getTemplateBodyWithQuotesAccess().getTemplateBodyParserRuleCall_2());
		}
		this_TemplateBody_2=ruleTemplateBody
		{
			$current = $this_TemplateBody_2.current;
			afterParserOrEnumRuleCall();
		}
		otherlv_3=LessThanSignLessThanSign
		{
			newLeafNode(otherlv_3, grammarAccess.getTemplateBodyWithQuotesAccess().getLessThanSignLessThanSignKeyword_3());
		}
	)
;
finally {
	myHiddenTokenState.restore();
}

// Entry rule entryRuleTemplateBody
entryRuleTemplateBody returns [EObject current=null]@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	{ newCompositeNode(grammarAccess.getTemplateBodyRule()); }
	iv_ruleTemplateBody=ruleTemplateBody
	{ $current=$iv_ruleTemplateBody.current; }
	EOF;
finally {
	myHiddenTokenState.restore();
}

// Rule TemplateBody
ruleTemplateBody returns [EObject current=null]
@init {
	enterRule();
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getTemplateBodyAccess().getTemplateBodyAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_1_0());
				}
				lv_parts_1_0=ruleLiteral
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTemplateBodyRule());
					}
					add(
						$current,
						"parts",
						lv_parts_1_0,
						"org.eclipse.xtext.ui.codetemplates.Codetemplates.Literal");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getTemplateBodyAccess().getPartsVariableOrDollarParserRuleCall_2_0_0());
					}
					lv_parts_2_0=ruleVariableOrDollar
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTemplateBodyRule());
						}
						add(
							$current,
							"parts",
							lv_parts_2_0,
							"org.eclipse.xtext.ui.codetemplates.Codetemplates.VariableOrDollar");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_2_1_0());
					}
					lv_parts_3_0=ruleLiteral
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTemplateBodyRule());
						}
						add(
							$current,
							"parts",
							lv_parts_3_0,
							"org.eclipse.xtext.ui.codetemplates.Codetemplates.Literal");
						afterParserOrEnumRuleCall();
					}
				)
			)?
		)*
	)
;
finally {
	myHiddenTokenState.restore();
}

// Entry rule entryRuleVariableOrDollar
entryRuleVariableOrDollar returns [EObject current=null]@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	{ newCompositeNode(grammarAccess.getVariableOrDollarRule()); }
	iv_ruleVariableOrDollar=ruleVariableOrDollar
	{ $current=$iv_ruleVariableOrDollar.current; }
	EOF;
finally {
	myHiddenTokenState.restore();
}

// Rule VariableOrDollar
ruleVariableOrDollar returns [EObject current=null]
@init {
	enterRule();
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getVariableOrDollarAccess().getVariableParserRuleCall_0());
		}
		this_Variable_0=ruleVariable
		{
			$current = $this_Variable_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getVariableOrDollarAccess().getDollarParserRuleCall_1());
		}
		this_Dollar_1=ruleDollar
		{
			$current = $this_Dollar_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;
finally {
	myHiddenTokenState.restore();
}

// Entry rule entryRuleVariable
entryRuleVariable returns [EObject current=null]@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	{ newCompositeNode(grammarAccess.getVariableRule()); }
	iv_ruleVariable=ruleVariable
	{ $current=$iv_ruleVariable.current; }
	EOF;
finally {
	myHiddenTokenState.restore();
}

// Rule Variable
ruleVariable returns [EObject current=null]
@init {
	enterRule();
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
@after {
	leaveRule();
}:
	(
		otherlv_0=DollarSignLeftCurlyBracket
		{
			newLeafNode(otherlv_0, grammarAccess.getVariableAccess().getDollarSignLeftCurlyBracketKeyword_0());
		}
		(
			this_WS_1=RULE_WS
			{
				newLeafNode(this_WS_1, grammarAccess.getVariableAccess().getWSTerminalRuleCall_1());
			}
		)*
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_0_0());
					}
					lv_name_2_0=ruleValidID
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getVariableRule());
						}
						set(
							$current,
							"name",
							lv_name_2_0,
							"org.eclipse.xtext.ui.codetemplates.Codetemplates.ValidID");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_1_0_0_0());
							}
							lv_name_3_0=ruleValidID
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getVariableRule());
								}
								set(
									$current,
									"name",
									lv_name_3_0,
									"org.eclipse.xtext.ui.codetemplates.Codetemplates.ValidID");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						this_WS_4=RULE_WS
						{
							newLeafNode(this_WS_4, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_0_1());
						}
					)*
				)?
				otherlv_5=Colon
				{
					newLeafNode(otherlv_5, grammarAccess.getVariableAccess().getColonKeyword_2_1_1());
				}
				(
					this_WS_6=RULE_WS
					{
						newLeafNode(this_WS_6, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_2());
					}
				)*
				(
					(
						{
							newCompositeNode(grammarAccess.getVariableAccess().getTypeValidIDParserRuleCall_2_1_3_0());
						}
						lv_type_7_0=ruleValidID
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getVariableRule());
							}
							set(
								$current,
								"type",
								lv_type_7_0,
								"org.eclipse.xtext.ui.codetemplates.Codetemplates.ValidID");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						this_WS_8=RULE_WS
						{
							newLeafNode(this_WS_8, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_0());
						}
					)*
					(
						(
							lv_expectingParameters_9_0=LeftParenthesis
							{
								newLeafNode(lv_expectingParameters_9_0, grammarAccess.getVariableAccess().getExpectingParametersLeftParenthesisKeyword_2_1_4_1_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getVariableRule());
								}
								setWithLastConsumed($current, "expectingParameters", lv_expectingParameters_9_0 != null, "(");
							}
						)
					)
					(
						this_WS_10=RULE_WS
						{
							newLeafNode(this_WS_10, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_2());
						}
					)*
					(
						(
							(
								(
									lv_parameters_11_1=RULE_STRING
									{
										newLeafNode(lv_parameters_11_1, grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_0_0_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getVariableRule());
										}
										addWithLastConsumed(
											$current,
											"parameters",
											lv_parameters_11_1,
											"org.eclipse.xtext.ui.codetemplates.Codetemplates.STRING");
									}
									    |
									{
										newCompositeNode(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_3_0_0_1());
									}
									lv_parameters_11_2=ruleFQN
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getVariableRule());
										}
										add(
											$current,
											"parameters",
											lv_parameters_11_2,
											"org.eclipse.xtext.ui.codetemplates.Codetemplates.FQN");
										afterParserOrEnumRuleCall();
									}
								)
							)
						)
						(
							(
								this_WS_12=RULE_WS
								{
									newLeafNode(this_WS_12, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_0());
								}
							)*
							otherlv_13=Comma
							{
								newLeafNode(otherlv_13, grammarAccess.getVariableAccess().getCommaKeyword_2_1_4_3_1_1());
							}
							(
								this_WS_14=RULE_WS
								{
									newLeafNode(this_WS_14, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_2());
								}
							)*
							(
								(
									(
										lv_parameters_15_1=RULE_STRING
										{
											newLeafNode(lv_parameters_15_1, grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_1_3_0_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getVariableRule());
											}
											addWithLastConsumed(
												$current,
												"parameters",
												lv_parameters_15_1,
												"org.eclipse.xtext.ui.codetemplates.Codetemplates.STRING");
										}
										    |
										{
											newCompositeNode(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_3_1_3_0_1());
										}
										lv_parameters_15_2=ruleFQN
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getVariableRule());
											}
											add(
												$current,
												"parameters",
												lv_parameters_15_2,
												"org.eclipse.xtext.ui.codetemplates.Codetemplates.FQN");
											afterParserOrEnumRuleCall();
										}
									)
								)
							)
						)*
						(
							this_WS_16=RULE_WS
							{
								newLeafNode(this_WS_16, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_2());
							}
						)*
					)?
					otherlv_17=RightParenthesis
					{
						newLeafNode(otherlv_17, grammarAccess.getVariableAccess().getRightParenthesisKeyword_2_1_4_4());
					}
				)?
			)
		)
		(
			this_WS_18=RULE_WS
			{
				newLeafNode(this_WS_18, grammarAccess.getVariableAccess().getWSTerminalRuleCall_3());
			}
		)*
		otherlv_19=RightCurlyBracket
		{
			newLeafNode(otherlv_19, grammarAccess.getVariableAccess().getRightCurlyBracketKeyword_4());
		}
	)
;
finally {
	myHiddenTokenState.restore();
}

// Entry rule entryRuleValidID
entryRuleValidID returns [String current=null]@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	{ newCompositeNode(grammarAccess.getValidIDRule()); }
	iv_ruleValidID=ruleValidID
	{ $current=$iv_ruleValidID.current.getText(); }
	EOF;
finally {
	myHiddenTokenState.restore();
}

// Rule ValidID
ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
@after {
	leaveRule();
}:
	(
		this_ID_0=RULE_ID
		{
			$current.merge(this_ID_0);
		}
		{
			newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0());
		}
		    |
		kw=For
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getValidIDAccess().getForKeyword_1());
		}
		    |
		kw=Templates
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getValidIDAccess().getTemplatesKeyword_2());
		}
	)
;
finally {
	myHiddenTokenState.restore();
}

// Entry rule entryRuleFQN
entryRuleFQN returns [String current=null]@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	{ newCompositeNode(grammarAccess.getFQNRule()); }
	iv_ruleFQN=ruleFQN
	{ $current=$iv_ruleFQN.current.getText(); }
	EOF;
finally {
	myHiddenTokenState.restore();
}

// Rule FQN
ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getFQNAccess().getValidIDParserRuleCall_0());
		}
		this_ValidID_0=ruleValidID
		{
			$current.merge(this_ValidID_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		(
			kw=FullStop
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
			}
			{
				newCompositeNode(grammarAccess.getFQNAccess().getValidIDParserRuleCall_1_1());
			}
			this_ValidID_2=ruleValidID
			{
				$current.merge(this_ValidID_2);
			}
			{
				afterParserOrEnumRuleCall();
			}
		)*
	)
;
finally {
	myHiddenTokenState.restore();
}

// Entry rule entryRuleLiteral
entryRuleLiteral returns [EObject current=null]@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	{ newCompositeNode(grammarAccess.getLiteralRule()); }
	iv_ruleLiteral=ruleLiteral
	{ $current=$iv_ruleLiteral.current; }
	EOF;
finally {
	myHiddenTokenState.restore();
}

// Rule Literal
ruleLiteral returns [EObject current=null]
@init {
	enterRule();
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getLiteralAccess().getValueLiteralValueParserRuleCall_0());
			}
			lv_value_0_0=ruleLiteralValue
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getLiteralRule());
				}
				set(
					$current,
					"value",
					lv_value_0_0,
					"org.eclipse.xtext.ui.codetemplates.Codetemplates.LiteralValue");
				afterParserOrEnumRuleCall();
			}
		)
	)
;
finally {
	myHiddenTokenState.restore();
}

// Entry rule entryRuleLiteralValue
entryRuleLiteralValue returns [String current=null]@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	{ newCompositeNode(grammarAccess.getLiteralValueRule()); }
	iv_ruleLiteralValue=ruleLiteralValue
	{ $current=$iv_ruleLiteralValue.current.getText(); }
	EOF;
finally {
	myHiddenTokenState.restore();
}

// Rule LiteralValue
ruleLiteralValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
@after {
	leaveRule();
}:
	(
		this_WS_0=RULE_WS
		{
			$current.merge(this_WS_0);
		}
		{
			newLeafNode(this_WS_0, grammarAccess.getLiteralValueAccess().getWSTerminalRuleCall_0());
		}
		    |
		this_ANY_OTHER_1=RULE_ANY_OTHER
		{
			$current.merge(this_ANY_OTHER_1);
		}
		{
			newLeafNode(this_ANY_OTHER_1, grammarAccess.getLiteralValueAccess().getANY_OTHERTerminalRuleCall_1());
		}
		    |
		this_ID_2=RULE_ID
		{
			$current.merge(this_ID_2);
		}
		{
			newLeafNode(this_ID_2, grammarAccess.getLiteralValueAccess().getIDTerminalRuleCall_2());
		}
		    |
		kw=ReverseSolidusLessThanSignLessThanSign
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getLiteralValueAccess().getReverseSolidusLessThanSignLessThanSignKeyword_3());
		}
	)+
;
finally {
	myHiddenTokenState.restore();
}

// Entry rule entryRuleDollar
entryRuleDollar returns [EObject current=null]@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	{ newCompositeNode(grammarAccess.getDollarRule()); }
	iv_ruleDollar=ruleDollar
	{ $current=$iv_ruleDollar.current; }
	EOF;
finally {
	myHiddenTokenState.restore();
}

// Rule Dollar
ruleDollar returns [EObject current=null]
@init {
	enterRule();
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getDollarAccess().getDollarAction_0(),
					$current);
			}
		)
		(
			(
				(
					lv_escaped_1_0=DollarSignDollarSign
					{
						newLeafNode(lv_escaped_1_0, grammarAccess.getDollarAccess().getEscapedDollarSignDollarSignKeyword_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getDollarRule());
						}
						setWithLastConsumed($current, "escaped", lv_escaped_1_0 != null, "\$\$");
					}
				)
			)
			    |
			otherlv_2=DollarSign
			{
				newLeafNode(otherlv_2, grammarAccess.getDollarAccess().getDollarSignKeyword_1_1());
			}
		)
	)
;
finally {
	myHiddenTokenState.restore();
}
