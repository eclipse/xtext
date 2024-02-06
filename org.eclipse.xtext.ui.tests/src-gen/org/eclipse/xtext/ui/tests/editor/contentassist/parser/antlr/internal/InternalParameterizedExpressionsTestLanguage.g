/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
grammar InternalParameterizedExpressionsTestLanguage;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ParameterizedExpressionsTestLanguageGrammarAccess;

}

@parser::members {

 	private ParameterizedExpressionsTestLanguageGrammarAccess grammarAccess;

    public InternalParameterizedExpressionsTestLanguageParser(TokenStream input, ParameterizedExpressionsTestLanguageGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "RootStatement";
   	}

   	@Override
   	protected ParameterizedExpressionsTestLanguageGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleRootStatement
entryRuleRootStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRootStatementRule()); }
	iv_ruleRootStatement=ruleRootStatement
	{ $current=$iv_ruleRootStatement.current; }
	EOF;

// Rule RootStatement
ruleRootStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			((
				(
				)
				'{'
			)
			)=>
			{
				newCompositeNode(grammarAccess.getRootStatementAccess().getBlockParserRuleCall_0());
			}
			this_Block_0=ruleBlock
			{
				$current = $this_Block_0.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		(
			((
				(
				)
				'function'
			)
			)=>
			{
				newCompositeNode(grammarAccess.getRootStatementAccess().getFunctionDeclarationParserRuleCall_1());
			}
			this_FunctionDeclaration_1=ruleFunctionDeclaration
			{
				$current = $this_FunctionDeclaration_1.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		(
			((
				(
					(
						ruleIdentifier
					)
				)
				':'
			)
			)=>
			{
				newCompositeNode(grammarAccess.getRootStatementAccess().getLabelledStatementParserRuleCall_2());
			}
			this_LabelledStatement_2=ruleLabelledStatement
			{
				$current = $this_LabelledStatement_2.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		{
			newCompositeNode(grammarAccess.getRootStatementAccess().getExpressionStatementParserRuleCall_3());
		}
		this_ExpressionStatement_3=ruleExpressionStatement
		{
			$current = $this_ExpressionStatement_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;


// Rule RootStatement
norm1_RootStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			((
				(
				)
				'{'
			)
			)=>
			{
				newCompositeNode(grammarAccess.getRootStatementAccess().getBlockParserRuleCall_0());
			}
			this_Block_0=norm1_Block
			{
				$current = $this_Block_0.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		(
			((
				(
				)
				'function'
			)
			)=>
			{
				newCompositeNode(grammarAccess.getRootStatementAccess().getFunctionDeclarationParserRuleCall_1());
			}
			this_FunctionDeclaration_1=norm1_FunctionDeclaration
			{
				$current = $this_FunctionDeclaration_1.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		(
			((
				(
					(
						norm1_Identifier
					)
				)
				':'
			)
			)=>
			{
				newCompositeNode(grammarAccess.getRootStatementAccess().getLabelledStatementParserRuleCall_2());
			}
			this_LabelledStatement_2=norm1_LabelledStatement
			{
				$current = $this_LabelledStatement_2.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		{
			newCompositeNode(grammarAccess.getRootStatementAccess().getExpressionStatementParserRuleCall_3());
		}
		this_ExpressionStatement_3=norm1_ExpressionStatement
		{
			$current = $this_ExpressionStatement_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleFunctionDeclaration
entryRuleFunctionDeclaration returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFunctionDeclarationRule()); }
	iv_ruleFunctionDeclaration=ruleFunctionDeclaration
	{ $current=$iv_ruleFunctionDeclaration.current; }
	EOF;

// Rule FunctionDeclaration
ruleFunctionDeclaration returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			((
				(
				)
				'function'
			)
			)=>
			(
				(
					{
						$current = forceCreateModelElement(
							grammarAccess.getFunctionDeclarationAccess().getFunctionDeclarationAction_0_0_0(),
							$current);
					}
				)
				(
					('function')=>
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getFunctionDeclarationRule());
						}
						newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getFunctionImplParserRuleCall_0_0_1());
					}
					this_FunctionImpl_1=ruleFunctionImpl[$current]
					{
						$current = $this_FunctionImpl_1.current;
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		(
			(';')=>
			otherlv_2=';'
			{
				newLeafNode(otherlv_2, grammarAccess.getFunctionDeclarationAccess().getSemicolonKeyword_1());
			}
		)?
	)
;


// Rule FunctionDeclaration
norm1_FunctionDeclaration returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			((
				(
				)
				'function'
			)
			)=>
			(
				(
					{
						$current = forceCreateModelElement(
							grammarAccess.getFunctionDeclarationAccess().getFunctionDeclarationAction_0_0_0(),
							$current);
					}
				)
				(
					('function')=>
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getFunctionDeclarationRule());
						}
						newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getFunctionImplParserRuleCall_0_0_1());
					}
					this_FunctionImpl_1=norm3_FunctionImpl[$current]
					{
						$current = $this_FunctionImpl_1.current;
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		(
			(';')=>
			otherlv_2=';'
			{
				newLeafNode(otherlv_2, grammarAccess.getFunctionDeclarationAccess().getSemicolonKeyword_1());
			}
		)?
	)
;


// Rule FunctionImpl
ruleFunctionImpl[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='function'
		{
			newLeafNode(otherlv_0, grammarAccess.getFunctionImplAccess().getFunctionKeyword_0());
		}
		(
			(
				(
					(
						lv_generator_1_0='*'
						{
							newLeafNode(lv_generator_1_0, grammarAccess.getFunctionImplAccess().getGeneratorAsteriskKeyword_1_0_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getFunctionImplRule());
							}
							setWithLastConsumed($current, "generator", lv_generator_1_0 != null, "*");
						}
					)
				)
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFunctionImplRule());
					}
					newCompositeNode(grammarAccess.getFunctionImplAccess().getFunctionHeaderParserRuleCall_1_0_1());
				}
				this_FunctionHeader_2=norm2_FunctionHeader[$current]
				{
					$current = $this_FunctionHeader_2.current;
					afterParserOrEnumRuleCall();
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFunctionImplRule());
					}
					newCompositeNode(grammarAccess.getFunctionImplAccess().getFunctionBodyParserRuleCall_1_0_2());
				}
				this_FunctionBody_3=norm1_FunctionBody[$current]
				{
					$current = $this_FunctionBody_3.current;
					afterParserOrEnumRuleCall();
				}
			)
			    |
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFunctionImplRule());
					}
					newCompositeNode(grammarAccess.getFunctionImplAccess().getFunctionHeaderParserRuleCall_1_1_0());
				}
				this_FunctionHeader_4=ruleFunctionHeader[$current]
				{
					$current = $this_FunctionHeader_4.current;
					afterParserOrEnumRuleCall();
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFunctionImplRule());
					}
					newCompositeNode(grammarAccess.getFunctionImplAccess().getFunctionBodyParserRuleCall_1_1_1());
				}
				this_FunctionBody_5=ruleFunctionBody[$current]
				{
					$current = $this_FunctionBody_5.current;
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;


// Rule FunctionImpl
norm3_FunctionImpl[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='function'
		{
			newLeafNode(otherlv_0, grammarAccess.getFunctionImplAccess().getFunctionKeyword_0());
		}
		(
			(
				(
					(
						lv_generator_1_0='*'
						{
							newLeafNode(lv_generator_1_0, grammarAccess.getFunctionImplAccess().getGeneratorAsteriskKeyword_1_0_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getFunctionImplRule());
							}
							setWithLastConsumed($current, "generator", lv_generator_1_0 != null, "*");
						}
					)
				)
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFunctionImplRule());
					}
					newCompositeNode(grammarAccess.getFunctionImplAccess().getFunctionHeaderParserRuleCall_1_0_1());
				}
				this_FunctionHeader_2=norm3_FunctionHeader[$current]
				{
					$current = $this_FunctionHeader_2.current;
					afterParserOrEnumRuleCall();
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFunctionImplRule());
					}
					newCompositeNode(grammarAccess.getFunctionImplAccess().getFunctionBodyParserRuleCall_1_0_2());
				}
				this_FunctionBody_3=norm1_FunctionBody[$current]
				{
					$current = $this_FunctionBody_3.current;
					afterParserOrEnumRuleCall();
				}
			)
			    |
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFunctionImplRule());
					}
					newCompositeNode(grammarAccess.getFunctionImplAccess().getFunctionHeaderParserRuleCall_1_1_0());
				}
				this_FunctionHeader_4=norm1_FunctionHeader[$current]
				{
					$current = $this_FunctionHeader_4.current;
					afterParserOrEnumRuleCall();
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFunctionImplRule());
					}
					newCompositeNode(grammarAccess.getFunctionImplAccess().getFunctionBodyParserRuleCall_1_1_1());
				}
				this_FunctionBody_5=ruleFunctionBody[$current]
				{
					$current = $this_FunctionBody_5.current;
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;


// Rule FunctionHeader
ruleFunctionHeader[EObject in_current]  returns [EObject current=in_current]
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
					newCompositeNode(grammarAccess.getFunctionHeaderAccess().getNameIdentifierParserRuleCall_0_0());
				}
				lv_name_0_0=ruleIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFunctionHeaderRule());
					}
					set(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getFunctionHeaderAccess().getLeftParenthesisKeyword_1());
		}
		otherlv_2=')'
		{
			newLeafNode(otherlv_2, grammarAccess.getFunctionHeaderAccess().getRightParenthesisKeyword_2());
		}
	)
;


// Rule FunctionHeader
norm1_FunctionHeader[EObject in_current]  returns [EObject current=in_current]
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
					newCompositeNode(grammarAccess.getFunctionHeaderAccess().getNameIdentifierParserRuleCall_0_0());
				}
				lv_name_0_0=norm1_Identifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFunctionHeaderRule());
					}
					set(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getFunctionHeaderAccess().getLeftParenthesisKeyword_1());
		}
		otherlv_2=')'
		{
			newLeafNode(otherlv_2, grammarAccess.getFunctionHeaderAccess().getRightParenthesisKeyword_2());
		}
	)
;


// Rule FunctionHeader
norm2_FunctionHeader[EObject in_current]  returns [EObject current=in_current]
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
					newCompositeNode(grammarAccess.getFunctionHeaderAccess().getNameIdentifierParserRuleCall_0_0());
				}
				lv_name_0_0=ruleIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFunctionHeaderRule());
					}
					set(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getFunctionHeaderAccess().getLeftParenthesisKeyword_1());
		}
		otherlv_2=')'
		{
			newLeafNode(otherlv_2, grammarAccess.getFunctionHeaderAccess().getRightParenthesisKeyword_2());
		}
	)
;


// Rule FunctionHeader
norm3_FunctionHeader[EObject in_current]  returns [EObject current=in_current]
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
					newCompositeNode(grammarAccess.getFunctionHeaderAccess().getNameIdentifierParserRuleCall_0_0());
				}
				lv_name_0_0=norm1_Identifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFunctionHeaderRule());
					}
					set(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getFunctionHeaderAccess().getLeftParenthesisKeyword_1());
		}
		otherlv_2=')'
		{
			newLeafNode(otherlv_2, grammarAccess.getFunctionHeaderAccess().getRightParenthesisKeyword_2());
		}
	)
;


// Rule FunctionBody
ruleFunctionBody[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		((
			(
			)
			'{'
		)
		)=>
		(
			{
				newCompositeNode(grammarAccess.getFunctionBodyAccess().getBodyBlockParserRuleCall_1_0_0());
			}
			lv_body_0_0=ruleBlock
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getFunctionBodyRule());
				}
				set(
					$current,
					"body",
					lv_body_0_0,
					"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Block");
				afterParserOrEnumRuleCall();
			}
		)
	)?
;


// Rule FunctionBody
norm1_FunctionBody[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		((
			(
			)
			'{'
		)
		)=>
		(
			{
				newCompositeNode(grammarAccess.getFunctionBodyAccess().getBodyBlockParserRuleCall_1_0_0());
			}
			lv_body_0_0=norm1_Block
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getFunctionBodyRule());
				}
				set(
					$current,
					"body",
					lv_body_0_0,
					"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Block");
				afterParserOrEnumRuleCall();
			}
		)
	)?
;


// Rule FunctionBody
norm2_FunctionBody[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		((
			(
			)
			'{'
		)
		)=>
		(
			{
				newCompositeNode(grammarAccess.getFunctionBodyAccess().getBodyBlockParserRuleCall_0_0_0());
			}
			lv_body_0_0=ruleBlock
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getFunctionBodyRule());
				}
				set(
					$current,
					"body",
					lv_body_0_0,
					"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Block");
				afterParserOrEnumRuleCall();
			}
		)
	)
;


// Rule FunctionBody
norm3_FunctionBody[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		((
			(
			)
			'{'
		)
		)=>
		(
			{
				newCompositeNode(grammarAccess.getFunctionBodyAccess().getBodyBlockParserRuleCall_0_0_0());
			}
			lv_body_0_0=norm1_Block
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getFunctionBodyRule());
				}
				set(
					$current,
					"body",
					lv_body_0_0,
					"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Block");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleBlock
entryRuleBlock returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBlockRule()); }
	iv_ruleBlock=ruleBlock
	{ $current=$iv_ruleBlock.current; }
	EOF;

// Rule Block
ruleBlock returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			((
				(
				)
				'{'
			)
			)=>
			(
				(
					{
						$current = forceCreateModelElement(
							grammarAccess.getBlockAccess().getBlockAction_0_0_0(),
							$current);
					}
				)
				otherlv_1='{'
				{
					newLeafNode(otherlv_1, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_0_0_1());
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_1_0());
				}
				lv_statements_2_0=ruleStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBlockRule());
					}
					add(
						$current,
						"statements",
						lv_statements_2_0,
						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Statement");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_3='}'
		{
			newLeafNode(otherlv_3, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_2());
		}
	)
;


// Rule Block
norm1_Block returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			((
				(
				)
				'{'
			)
			)=>
			(
				(
					{
						$current = forceCreateModelElement(
							grammarAccess.getBlockAccess().getBlockAction_0_0_0(),
							$current);
					}
				)
				otherlv_1='{'
				{
					newLeafNode(otherlv_1, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_0_0_1());
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_1_0());
				}
				lv_statements_2_0=norm1_Statement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBlockRule());
					}
					add(
						$current,
						"statements",
						lv_statements_2_0,
						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Statement");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_3='}'
		{
			newLeafNode(otherlv_3, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_2());
		}
	)
;

// Entry rule entryRuleStatement
entryRuleStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStatementRule()); }
	iv_ruleStatement=ruleStatement
	{ $current=$iv_ruleStatement.current; }
	EOF;

// Rule Statement
ruleStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			((
				(
				)
				'function'
			)
			)=>
			{
				newCompositeNode(grammarAccess.getStatementAccess().getFunctionDeclarationParserRuleCall_0());
			}
			this_FunctionDeclaration_0=ruleFunctionDeclaration
			{
				$current = $this_FunctionDeclaration_0.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		{
			newCompositeNode(grammarAccess.getStatementAccess().getRootStatementParserRuleCall_1());
		}
		this_RootStatement_1=ruleRootStatement
		{
			$current = $this_RootStatement_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;


// Rule Statement
norm1_Statement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			((
				(
				)
				'function'
			)
			)=>
			{
				newCompositeNode(grammarAccess.getStatementAccess().getFunctionDeclarationParserRuleCall_0());
			}
			this_FunctionDeclaration_0=norm1_FunctionDeclaration
			{
				$current = $this_FunctionDeclaration_0.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		{
			newCompositeNode(grammarAccess.getStatementAccess().getRootStatementParserRuleCall_1());
		}
		this_RootStatement_1=norm1_RootStatement
		{
			$current = $this_RootStatement_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleExpressionStatement
entryRuleExpressionStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getExpressionStatementRule()); }
	iv_ruleExpressionStatement=ruleExpressionStatement
	{ $current=$iv_ruleExpressionStatement.current; }
	EOF;

// Rule ExpressionStatement
ruleExpressionStatement returns [EObject current=null]
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
					newCompositeNode(grammarAccess.getExpressionStatementAccess().getExpressionExpressionParserRuleCall_0_0());
				}
				lv_expression_0_0=norm1_Expression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getExpressionStatementRule());
					}
					set(
						$current,
						"expression",
						lv_expression_0_0,
						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1=';'
		{
			newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_1());
		}
	)
;


// Rule ExpressionStatement
norm1_ExpressionStatement returns [EObject current=null]
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
					newCompositeNode(grammarAccess.getExpressionStatementAccess().getExpressionExpressionParserRuleCall_0_0());
				}
				lv_expression_0_0=norm3_Expression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getExpressionStatementRule());
					}
					set(
						$current,
						"expression",
						lv_expression_0_0,
						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1=';'
		{
			newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_1());
		}
	)
;

// Entry rule entryRuleLabelledStatement
entryRuleLabelledStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLabelledStatementRule()); }
	iv_ruleLabelledStatement=ruleLabelledStatement
	{ $current=$iv_ruleLabelledStatement.current; }
	EOF;

// Rule LabelledStatement
ruleLabelledStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			((
				(
					(
						ruleIdentifier
					)
				)
				':'
			)
			)=>
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getLabelledStatementAccess().getNameIdentifierParserRuleCall_0_0_0_0());
						}
						lv_name_0_0=ruleIdentifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getLabelledStatementRule());
							}
							set(
								$current,
								"name",
								lv_name_0_0,
								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_1=':'
				{
					newLeafNode(otherlv_1, grammarAccess.getLabelledStatementAccess().getColonKeyword_0_0_1());
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getLabelledStatementAccess().getStatementStatementParserRuleCall_1_0());
				}
				lv_statement_2_0=ruleStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLabelledStatementRule());
					}
					set(
						$current,
						"statement",
						lv_statement_2_0,
						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Statement");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;


// Rule LabelledStatement
norm1_LabelledStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			((
				(
					(
						norm1_Identifier
					)
				)
				':'
			)
			)=>
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getLabelledStatementAccess().getNameIdentifierParserRuleCall_0_0_0_0());
						}
						lv_name_0_0=norm1_Identifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getLabelledStatementRule());
							}
							set(
								$current,
								"name",
								lv_name_0_0,
								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_1=':'
				{
					newLeafNode(otherlv_1, grammarAccess.getLabelledStatementAccess().getColonKeyword_0_0_1());
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getLabelledStatementAccess().getStatementStatementParserRuleCall_1_0());
				}
				lv_statement_2_0=norm1_Statement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLabelledStatementRule());
					}
					set(
						$current,
						"statement",
						lv_statement_2_0,
						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Statement");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRulePrimaryExpression
entryRulePrimaryExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimaryExpressionRule()); }
	iv_rulePrimaryExpression=rulePrimaryExpression
	{ $current=$iv_rulePrimaryExpression.current; }
	EOF;

// Rule PrimaryExpression
rulePrimaryExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIdentifierRefParserRuleCall());
	}
	this_IdentifierRef_0=ruleIdentifierRef
	{
		$current = $this_IdentifierRef_0.current;
		afterParserOrEnumRuleCall();
	}
;


// Rule PrimaryExpression
norm1_PrimaryExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIdentifierRefParserRuleCall());
	}
	this_IdentifierRef_0=norm1_IdentifierRef
	{
		$current = $this_IdentifierRef_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleIdentifierRef
entryRuleIdentifierRef returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIdentifierRefRule()); }
	iv_ruleIdentifierRef=ruleIdentifierRef
	{ $current=$iv_ruleIdentifierRef.current; }
	EOF;

// Rule IdentifierRef
ruleIdentifierRef returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getIdentifierRefAccess().getIdIdentifierParserRuleCall_0());
			}
			lv_id_0_0=ruleIdentifier
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getIdentifierRefRule());
				}
				set(
					$current,
					"id",
					lv_id_0_0,
					"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
				afterParserOrEnumRuleCall();
			}
		)
	)
;


// Rule IdentifierRef
norm1_IdentifierRef returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getIdentifierRefAccess().getIdIdentifierParserRuleCall_0());
			}
			lv_id_0_0=norm1_Identifier
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getIdentifierRefRule());
				}
				set(
					$current,
					"id",
					lv_id_0_0,
					"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleMemberExpression
entryRuleMemberExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMemberExpressionRule()); }
	iv_ruleMemberExpression=ruleMemberExpression
	{ $current=$iv_ruleMemberExpression.current; }
	EOF;

// Rule MemberExpression
ruleMemberExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getMemberExpressionAccess().getPrimaryExpressionParserRuleCall_0());
		}
		this_PrimaryExpression_0=rulePrimaryExpression
		{
			$current = $this_PrimaryExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getMemberExpressionAccess().getIndexedAccessExpressionTargetAction_1_0_0(),
							$current);
					}
				)
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getMemberExpressionRule());
					}
					newCompositeNode(grammarAccess.getMemberExpressionAccess().getIndexedAccessExpressionTailParserRuleCall_1_0_1());
				}
				this_IndexedAccessExpressionTail_2=ruleIndexedAccessExpressionTail[$current]
				{
					$current = $this_IndexedAccessExpressionTail_2.current;
					afterParserOrEnumRuleCall();
				}
			)
			    |
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getMemberExpressionAccess().getParameterizedPropertyAccessExpressionTargetAction_1_1_0(),
							$current);
					}
				)
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getMemberExpressionRule());
					}
					newCompositeNode(grammarAccess.getMemberExpressionAccess().getParameterizedPropertyAccessExpressionTailParserRuleCall_1_1_1());
				}
				this_ParameterizedPropertyAccessExpressionTail_4=ruleParameterizedPropertyAccessExpressionTail[$current]
				{
					$current = $this_ParameterizedPropertyAccessExpressionTail_4.current;
					afterParserOrEnumRuleCall();
				}
			)
		)*
	)
;


// Rule MemberExpression
norm1_MemberExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getMemberExpressionAccess().getPrimaryExpressionParserRuleCall_0());
		}
		this_PrimaryExpression_0=norm1_PrimaryExpression
		{
			$current = $this_PrimaryExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getMemberExpressionAccess().getIndexedAccessExpressionTargetAction_1_0_0(),
							$current);
					}
				)
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getMemberExpressionRule());
					}
					newCompositeNode(grammarAccess.getMemberExpressionAccess().getIndexedAccessExpressionTailParserRuleCall_1_0_1());
				}
				this_IndexedAccessExpressionTail_2=norm1_IndexedAccessExpressionTail[$current]
				{
					$current = $this_IndexedAccessExpressionTail_2.current;
					afterParserOrEnumRuleCall();
				}
			)
			    |
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getMemberExpressionAccess().getParameterizedPropertyAccessExpressionTargetAction_1_1_0(),
							$current);
					}
				)
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getMemberExpressionRule());
					}
					newCompositeNode(grammarAccess.getMemberExpressionAccess().getParameterizedPropertyAccessExpressionTailParserRuleCall_1_1_1());
				}
				this_ParameterizedPropertyAccessExpressionTail_4=norm1_ParameterizedPropertyAccessExpressionTail[$current]
				{
					$current = $this_ParameterizedPropertyAccessExpressionTail_4.current;
					afterParserOrEnumRuleCall();
				}
			)
		)*
	)
;


// Rule IndexedAccessExpressionTail
ruleIndexedAccessExpressionTail[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='['
		{
			newLeafNode(otherlv_0, grammarAccess.getIndexedAccessExpressionTailAccess().getLeftSquareBracketKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getIndexedAccessExpressionTailAccess().getIndexExpressionParserRuleCall_1_0());
				}
				lv_index_1_0=norm1_Expression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIndexedAccessExpressionTailRule());
					}
					set(
						$current,
						"index",
						lv_index_1_0,
						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2=']'
		{
			newLeafNode(otherlv_2, grammarAccess.getIndexedAccessExpressionTailAccess().getRightSquareBracketKeyword_2());
		}
	)
;


// Rule IndexedAccessExpressionTail
norm1_IndexedAccessExpressionTail[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='['
		{
			newLeafNode(otherlv_0, grammarAccess.getIndexedAccessExpressionTailAccess().getLeftSquareBracketKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getIndexedAccessExpressionTailAccess().getIndexExpressionParserRuleCall_1_0());
				}
				lv_index_1_0=norm3_Expression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIndexedAccessExpressionTailRule());
					}
					set(
						$current,
						"index",
						lv_index_1_0,
						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2=']'
		{
			newLeafNode(otherlv_2, grammarAccess.getIndexedAccessExpressionTailAccess().getRightSquareBracketKeyword_2());
		}
	)
;


// Rule ParameterizedPropertyAccessExpressionTail
ruleParameterizedPropertyAccessExpressionTail[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='.'
		{
			newLeafNode(otherlv_0, grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getFullStopKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getPropertyIdentifierParserRuleCall_1_0());
				}
				lv_property_1_0=ruleIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getParameterizedPropertyAccessExpressionTailRule());
					}
					set(
						$current,
						"property",
						lv_property_1_0,
						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;


// Rule ParameterizedPropertyAccessExpressionTail
norm1_ParameterizedPropertyAccessExpressionTail[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='.'
		{
			newLeafNode(otherlv_0, grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getFullStopKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getPropertyIdentifierParserRuleCall_1_0());
				}
				lv_property_1_0=norm1_Identifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getParameterizedPropertyAccessExpressionTailRule());
					}
					set(
						$current,
						"property",
						lv_property_1_0,
						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleShiftExpression
entryRuleShiftExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getShiftExpressionRule()); }
	iv_ruleShiftExpression=ruleShiftExpression
	{ $current=$iv_ruleShiftExpression.current; }
	EOF;

// Rule ShiftExpression
ruleShiftExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getShiftExpressionAccess().getMemberExpressionParserRuleCall_0());
		}
		this_MemberExpression_0=ruleMemberExpression
		{
			$current = $this_MemberExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			((
				(
				)
				(
					(
						(
							'>>'
							    |
							'<<'
						)
					)
				)
				(
					(
						ruleMemberExpression
					)
				)
			)
			)=>
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getShiftExpressionAccess().getShiftExpressionLhsAction_1_0_0(),
							$current);
					}
				)
				(
					(
						(
							lv_op_2_1='>>'
							{
								newLeafNode(lv_op_2_1, grammarAccess.getShiftExpressionAccess().getOpGreaterThanSignGreaterThanSignKeyword_1_0_1_0_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getShiftExpressionRule());
								}
								setWithLastConsumed($current, "op", lv_op_2_1, null);
							}
							    |
							lv_op_2_2='<<'
							{
								newLeafNode(lv_op_2_2, grammarAccess.getShiftExpressionAccess().getOpLessThanSignLessThanSignKeyword_1_0_1_0_1());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getShiftExpressionRule());
								}
								setWithLastConsumed($current, "op", lv_op_2_2, null);
							}
						)
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getShiftExpressionAccess().getRhsMemberExpressionParserRuleCall_1_0_2_0());
						}
						lv_rhs_3_0=ruleMemberExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
							}
							set(
								$current,
								"rhs",
								lv_rhs_3_0,
								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.MemberExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)*
	)
;


// Rule ShiftExpression
norm1_ShiftExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getShiftExpressionAccess().getMemberExpressionParserRuleCall_0());
		}
		this_MemberExpression_0=norm1_MemberExpression
		{
			$current = $this_MemberExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			((
				(
				)
				(
					(
						(
							'>>'
							    |
							'<<'
						)
					)
				)
				(
					(
						norm1_MemberExpression
					)
				)
			)
			)=>
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getShiftExpressionAccess().getShiftExpressionLhsAction_1_0_0(),
							$current);
					}
				)
				(
					(
						(
							lv_op_2_1='>>'
							{
								newLeafNode(lv_op_2_1, grammarAccess.getShiftExpressionAccess().getOpGreaterThanSignGreaterThanSignKeyword_1_0_1_0_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getShiftExpressionRule());
								}
								setWithLastConsumed($current, "op", lv_op_2_1, null);
							}
							    |
							lv_op_2_2='<<'
							{
								newLeafNode(lv_op_2_2, grammarAccess.getShiftExpressionAccess().getOpLessThanSignLessThanSignKeyword_1_0_1_0_1());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getShiftExpressionRule());
								}
								setWithLastConsumed($current, "op", lv_op_2_2, null);
							}
						)
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getShiftExpressionAccess().getRhsMemberExpressionParserRuleCall_1_0_2_0());
						}
						lv_rhs_3_0=norm1_MemberExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
							}
							set(
								$current,
								"rhs",
								lv_rhs_3_0,
								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.MemberExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)*
	)
;

// Entry rule entryRuleRelationalExpression
entryRuleRelationalExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRelationalExpressionRule()); }
	iv_ruleRelationalExpression=ruleRelationalExpression
	{ $current=$iv_ruleRelationalExpression.current; }
	EOF;

// Rule RelationalExpression
ruleRelationalExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0());
		}
		this_ShiftExpression_0=ruleShiftExpression
		{
			$current = $this_ShiftExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			((
				(
				)
				(
					(
						ruleRelationalOperator
					)
				)
				(
					'yield'
					    |
					RULE_ID
				)
			)
			)=>
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLhsAction_1_0_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_1_0());
						}
						lv_op_2_0=ruleRelationalOperator
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
							}
							set(
								$current,
								"op",
								lv_op_2_0,
								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.RelationalOperator");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					('yield' | RULE_ID)=>
					(
						{
							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRhsShiftExpressionParserRuleCall_1_0_2_0());
						}
						lv_rhs_3_0=ruleShiftExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
							}
							set(
								$current,
								"rhs",
								lv_rhs_3_0,
								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.ShiftExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)*
	)
;


// Rule RelationalExpression
norm1_RelationalExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0());
		}
		this_ShiftExpression_0=ruleShiftExpression
		{
			$current = $this_ShiftExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			((
				(
				)
				(
					(
						norm1_RelationalOperator
					)
				)
				(
					'yield'
					    |
					RULE_ID
				)
			)
			)=>
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLhsAction_1_0_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_1_0());
						}
						lv_op_2_0=norm1_RelationalOperator
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
							}
							set(
								$current,
								"op",
								lv_op_2_0,
								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.RelationalOperator");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					('yield' | RULE_ID)=>
					(
						{
							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRhsShiftExpressionParserRuleCall_1_0_2_0());
						}
						lv_rhs_3_0=ruleShiftExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
							}
							set(
								$current,
								"rhs",
								lv_rhs_3_0,
								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.ShiftExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)*
	)
;


// Rule RelationalExpression
norm2_RelationalExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0());
		}
		this_ShiftExpression_0=norm1_ShiftExpression
		{
			$current = $this_ShiftExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			((
				(
				)
				(
					(
						ruleRelationalOperator
					)
				)
				RULE_ID
			)
			)=>
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLhsAction_1_0_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_1_0());
						}
						lv_op_2_0=ruleRelationalOperator
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
							}
							set(
								$current,
								"op",
								lv_op_2_0,
								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.RelationalOperator");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(RULE_ID)=>
					(
						{
							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRhsShiftExpressionParserRuleCall_1_0_2_0());
						}
						lv_rhs_3_0=norm1_ShiftExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
							}
							set(
								$current,
								"rhs",
								lv_rhs_3_0,
								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.ShiftExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)*
	)
;


// Rule RelationalExpression
norm3_RelationalExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0());
		}
		this_ShiftExpression_0=norm1_ShiftExpression
		{
			$current = $this_ShiftExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			((
				(
				)
				(
					(
						norm1_RelationalOperator
					)
				)
				RULE_ID
			)
			)=>
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLhsAction_1_0_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_1_0());
						}
						lv_op_2_0=norm1_RelationalOperator
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
							}
							set(
								$current,
								"op",
								lv_op_2_0,
								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.RelationalOperator");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(RULE_ID)=>
					(
						{
							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRhsShiftExpressionParserRuleCall_1_0_2_0());
						}
						lv_rhs_3_0=norm1_ShiftExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
							}
							set(
								$current,
								"rhs",
								lv_rhs_3_0,
								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.ShiftExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)*
	)
;

// Entry rule entryRuleRelationalOperator
entryRuleRelationalOperator returns [String current=null]:
	{ newCompositeNode(grammarAccess.getRelationalOperatorRule()); }
	iv_ruleRelationalOperator=ruleRelationalOperator
	{ $current=$iv_ruleRelationalOperator.current.getText(); }
	EOF;

// Rule RelationalOperator
ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='<'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_0());
		}
		    |
		kw='>'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_1());
		}
		    |
		kw='<='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignEqualsSignKeyword_2());
		}
		    |
		kw='>='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_3());
		}
		    |
		kw='instanceof'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getInstanceofKeyword_4());
		}
	)
;


// Rule RelationalOperator
norm1_RelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='<'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_0());
		}
		    |
		kw='>'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_1());
		}
		    |
		kw='<='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignEqualsSignKeyword_2());
		}
		    |
		kw='>='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_3());
		}
		    |
		kw='instanceof'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getInstanceofKeyword_4());
		}
		    |
		kw='in'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getInKeyword_5_0());
		}
	)
;

// Entry rule entryRuleAssignmentExpression
entryRuleAssignmentExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAssignmentExpressionRule()); }
	iv_ruleAssignmentExpression=ruleAssignmentExpression
	{ $current=$iv_ruleAssignmentExpression.current; }
	EOF;

// Rule AssignmentExpression
ruleAssignmentExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRelationalExpressionParserRuleCall_1_0());
		}
		this_RelationalExpression_0=ruleRelationalExpression
		{
			$current = $this_RelationalExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				((
					(
					)
					(
						(
							'='
						)
					)
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLhsAction_1_1_0_0_0(),
								$current);
						}
					)
					(
						(
							lv_op_2_0='='
							{
								newLeafNode(lv_op_2_0, grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getAssignmentExpressionRule());
								}
								setWithLastConsumed($current, "op", lv_op_2_0, "=");
							}
						)
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRhsAssignmentExpressionParserRuleCall_1_1_1_0());
					}
					lv_rhs_3_0=ruleAssignmentExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
						}
						set(
							$current,
							"rhs",
							lv_rhs_3_0,
							"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;


// Rule AssignmentExpression
norm1_AssignmentExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRelationalExpressionParserRuleCall_1_0());
		}
		this_RelationalExpression_0=norm1_RelationalExpression
		{
			$current = $this_RelationalExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				((
					(
					)
					(
						(
							'='
						)
					)
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLhsAction_1_1_0_0_0(),
								$current);
						}
					)
					(
						(
							lv_op_2_0='='
							{
								newLeafNode(lv_op_2_0, grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getAssignmentExpressionRule());
								}
								setWithLastConsumed($current, "op", lv_op_2_0, "=");
							}
						)
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRhsAssignmentExpressionParserRuleCall_1_1_1_0());
					}
					lv_rhs_3_0=norm1_AssignmentExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
						}
						set(
							$current,
							"rhs",
							lv_rhs_3_0,
							"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;


// Rule AssignmentExpression
norm2_AssignmentExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getYieldExpressionParserRuleCall_0_0());
		}
		this_YieldExpression_0=ruleYieldExpression
		{
			$current = $this_YieldExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		(
			{
				newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRelationalExpressionParserRuleCall_1_0());
			}
			this_RelationalExpression_1=norm2_RelationalExpression
			{
				$current = $this_RelationalExpression_1.current;
				afterParserOrEnumRuleCall();
			}
			(
				(
					((
						(
						)
						(
							(
								'='
							)
						)
					)
					)=>
					(
						(
							{
								$current = forceCreateModelElementAndSet(
									grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLhsAction_1_1_0_0_0(),
									$current);
							}
						)
						(
							(
								lv_op_3_0='='
								{
									newLeafNode(lv_op_3_0, grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0());
								}
								{
									if ($current==null) {
										$current = createModelElement(grammarAccess.getAssignmentExpressionRule());
									}
									setWithLastConsumed($current, "op", lv_op_3_0, "=");
								}
							)
						)
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRhsAssignmentExpressionParserRuleCall_1_1_1_0());
						}
						lv_rhs_4_0=norm2_AssignmentExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
							}
							set(
								$current,
								"rhs",
								lv_rhs_4_0,
								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)?
		)
	)
;


// Rule AssignmentExpression
norm3_AssignmentExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getYieldExpressionParserRuleCall_0_0());
		}
		this_YieldExpression_0=norm1_YieldExpression
		{
			$current = $this_YieldExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		(
			{
				newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRelationalExpressionParserRuleCall_1_0());
			}
			this_RelationalExpression_1=norm3_RelationalExpression
			{
				$current = $this_RelationalExpression_1.current;
				afterParserOrEnumRuleCall();
			}
			(
				(
					((
						(
						)
						(
							(
								'='
							)
						)
					)
					)=>
					(
						(
							{
								$current = forceCreateModelElementAndSet(
									grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLhsAction_1_1_0_0_0(),
									$current);
							}
						)
						(
							(
								lv_op_3_0='='
								{
									newLeafNode(lv_op_3_0, grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0());
								}
								{
									if ($current==null) {
										$current = createModelElement(grammarAccess.getAssignmentExpressionRule());
									}
									setWithLastConsumed($current, "op", lv_op_3_0, "=");
								}
							)
						)
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRhsAssignmentExpressionParserRuleCall_1_1_1_0());
						}
						lv_rhs_4_0=norm3_AssignmentExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
							}
							set(
								$current,
								"rhs",
								lv_rhs_4_0,
								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)?
		)
	)
;

// Entry rule entryRuleYieldExpression
entryRuleYieldExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getYieldExpressionRule()); }
	iv_ruleYieldExpression=ruleYieldExpression
	{ $current=$iv_ruleYieldExpression.current; }
	EOF;

// Rule YieldExpression
ruleYieldExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getYieldExpressionAccess().getYieldExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='yield'
		{
			newLeafNode(otherlv_1, grammarAccess.getYieldExpressionAccess().getYieldKeyword_1());
		}
		(
			((
				'*'
			)
			)=>
			(
				lv_many_2_0='*'
				{
					newLeafNode(lv_many_2_0, grammarAccess.getYieldExpressionAccess().getManyAsteriskKeyword_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getYieldExpressionRule());
					}
					setWithLastConsumed($current, "many", lv_many_2_0 != null, "*");
				}
			)
		)?
		(
			('yield' | RULE_ID)=>
			(
				{
					newCompositeNode(grammarAccess.getYieldExpressionAccess().getExpressionAssignmentExpressionParserRuleCall_3_0());
				}
				lv_expression_3_0=norm2_AssignmentExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getYieldExpressionRule());
					}
					set(
						$current,
						"expression",
						lv_expression_3_0,
						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)?
	)
;


// Rule YieldExpression
norm1_YieldExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getYieldExpressionAccess().getYieldExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='yield'
		{
			newLeafNode(otherlv_1, grammarAccess.getYieldExpressionAccess().getYieldKeyword_1());
		}
		(
			((
				'*'
			)
			)=>
			(
				lv_many_2_0='*'
				{
					newLeafNode(lv_many_2_0, grammarAccess.getYieldExpressionAccess().getManyAsteriskKeyword_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getYieldExpressionRule());
					}
					setWithLastConsumed($current, "many", lv_many_2_0 != null, "*");
				}
			)
		)?
		(
			('yield' | RULE_ID)=>
			(
				{
					newCompositeNode(grammarAccess.getYieldExpressionAccess().getExpressionAssignmentExpressionParserRuleCall_3_0());
				}
				lv_expression_3_0=norm3_AssignmentExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getYieldExpressionRule());
					}
					set(
						$current,
						"expression",
						lv_expression_3_0,
						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)?
	)
;


// Rule Expression
norm1_Expression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall_0());
		}
		this_AssignmentExpression_0=norm1_AssignmentExpression
		{
			$current = $this_AssignmentExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndAdd(
						grammarAccess.getExpressionAccess().getCommaExpressionExprsAction_1_0(),
						$current);
				}
			)
			otherlv_2=','
			{
				newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getCommaKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getExpressionAccess().getExprsAssignmentExpressionParserRuleCall_1_2_0());
					}
					lv_exprs_3_0=norm1_AssignmentExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getExpressionRule());
						}
						add(
							$current,
							"exprs",
							lv_exprs_3_0,
							"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4=','
				{
					newLeafNode(otherlv_4, grammarAccess.getExpressionAccess().getCommaKeyword_1_3_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getExpressionAccess().getExprsAssignmentExpressionParserRuleCall_1_3_1_0());
						}
						lv_exprs_5_0=norm1_AssignmentExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getExpressionRule());
							}
							add(
								$current,
								"exprs",
								lv_exprs_5_0,
								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
	)
;


// Rule Expression
norm3_Expression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall_0());
		}
		this_AssignmentExpression_0=norm3_AssignmentExpression
		{
			$current = $this_AssignmentExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndAdd(
						grammarAccess.getExpressionAccess().getCommaExpressionExprsAction_1_0(),
						$current);
				}
			)
			otherlv_2=','
			{
				newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getCommaKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getExpressionAccess().getExprsAssignmentExpressionParserRuleCall_1_2_0());
					}
					lv_exprs_3_0=norm3_AssignmentExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getExpressionRule());
						}
						add(
							$current,
							"exprs",
							lv_exprs_3_0,
							"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4=','
				{
					newLeafNode(otherlv_4, grammarAccess.getExpressionAccess().getCommaKeyword_1_3_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getExpressionAccess().getExprsAssignmentExpressionParserRuleCall_1_3_1_0());
						}
						lv_exprs_5_0=norm3_AssignmentExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getExpressionRule());
							}
							add(
								$current,
								"exprs",
								lv_exprs_5_0,
								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
	)
;

// Entry rule entryRuleIdentifier
entryRuleIdentifier returns [String current=null]:
	{ newCompositeNode(grammarAccess.getIdentifierRule()); }
	iv_ruleIdentifier=ruleIdentifier
	{ $current=$iv_ruleIdentifier.current.getText(); }
	EOF;

// Rule Identifier
ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
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
			newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0());
		}
		    |
		kw='yield'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getIdentifierAccess().getYieldKeyword_1_0());
		}
	)
;


// Rule Identifier
norm1_Identifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_ID_0=RULE_ID
	{
		$current.merge(this_ID_0);
	}
	{
		newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0());
	}
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
