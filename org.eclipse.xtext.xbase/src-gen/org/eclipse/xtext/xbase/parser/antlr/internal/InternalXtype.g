/*******************************************************************************
 * Copyright (c) 2010, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
grammar InternalXtype;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.xbase.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.xbase.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;

}

@parser::members {

 	private XtypeGrammarAccess grammarAccess;

    public InternalXtypeParser(TokenStream input, XtypeGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "JvmTypeReference";
   	}

   	@Override
   	protected XtypeGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleJvmTypeReference
entryRuleJvmTypeReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); }
	iv_ruleJvmTypeReference=ruleJvmTypeReference
	{ $current=$iv_ruleJvmTypeReference.current; }
	EOF;

// Rule JvmTypeReference
ruleJvmTypeReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0());
			}
			this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference
			{
				$current = $this_JvmParameterizedTypeReference_0.current;
				afterParserOrEnumRuleCall();
			}
			(
				((
					(
					)
					ruleArrayBrackets
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(),
								$current);
						}
					)
					{
						newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_0_1_0_1());
					}
					ruleArrayBrackets
					{
						afterParserOrEnumRuleCall();
					}
				)
			)*
		)
		    |
		{
			newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1());
		}
		this_XFunctionTypeRef_3=ruleXFunctionTypeRef
		{
			$current = $this_XFunctionTypeRef_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleArrayBrackets
entryRuleArrayBrackets returns [String current=null]:
	{ newCompositeNode(grammarAccess.getArrayBracketsRule()); }
	iv_ruleArrayBrackets=ruleArrayBrackets
	{ $current=$iv_ruleArrayBrackets.current.getText(); }
	EOF;

// Rule ArrayBrackets
ruleArrayBrackets returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='['
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0());
		}
		kw=']'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1());
		}
	)
;

// Entry rule entryRuleXFunctionTypeRef
entryRuleXFunctionTypeRef returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); }
	iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef
	{ $current=$iv_ruleXFunctionTypeRef.current; }
	EOF;

// Rule XFunctionTypeRef
ruleXFunctionTypeRef returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='('
			{
				newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0());
						}
						lv_paramTypes_1_0=ruleJvmTypeReference
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
							}
							add(
								$current,
								"paramTypes",
								lv_paramTypes_1_0,
								"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_2=','
					{
						newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0());
							}
							lv_paramTypes_3_0=ruleJvmTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
								}
								add(
									$current,
									"paramTypes",
									lv_paramTypes_3_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)?
			otherlv_4=')'
			{
				newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2());
			}
		)?
		otherlv_5='=>'
		{
			newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0());
				}
				lv_returnType_6_0=ruleJvmTypeReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
					}
					set(
						$current,
						"returnType",
						lv_returnType_6_0,
						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleJvmParameterizedTypeReference
entryRuleJvmParameterizedTypeReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); }
	iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference
	{ $current=$iv_ruleJvmParameterizedTypeReference.current; }
	EOF;

// Rule JvmParameterizedTypeReference
ruleJvmParameterizedTypeReference returns [EObject current=null]
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
					if ($current==null) {
						$current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0());
				}
				ruleQualifiedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				('<')=>
				otherlv_1='<'
				{
					newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0());
					}
					lv_arguments_2_0=ruleJvmArgumentTypeReference
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
						}
						add(
							$current,
							"arguments",
							lv_arguments_2_0,
							"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_3=','
				{
					newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0());
						}
						lv_arguments_4_0=ruleJvmArgumentTypeReference
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
							}
							add(
								$current,
								"arguments",
								lv_arguments_4_0,
								"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_5='>'
			{
				newLeafNode(otherlv_5, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3());
			}
			(
				(
					((
						(
						)
						'.'
					)
					)=>
					(
						(
							{
								$current = forceCreateModelElementAndSet(
									grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0(),
									$current);
							}
						)
						otherlv_7='.'
						{
							newLeafNode(otherlv_7, grammarAccess.getJvmParameterizedTypeReferenceAccess().getFullStopKeyword_1_4_0_0_1());
						}
					)
				)
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_1_4_1_0());
						}
						ruleValidID
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						('<')=>
						otherlv_9='<'
						{
							newLeafNode(otherlv_9, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_4_2_0());
						}
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0());
							}
							lv_arguments_10_0=ruleJvmArgumentTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
								}
								add(
									$current,
									"arguments",
									lv_arguments_10_0,
									"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_11=','
						{
							newLeafNode(otherlv_11, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_4_2_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0());
								}
								lv_arguments_12_0=ruleJvmArgumentTypeReference
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
									}
									add(
										$current,
										"arguments",
										lv_arguments_12_0,
										"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
					otherlv_13='>'
					{
						newLeafNode(otherlv_13, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_4_2_3());
					}
				)?
			)*
		)?
	)
;

// Entry rule entryRuleJvmArgumentTypeReference
entryRuleJvmArgumentTypeReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); }
	iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference
	{ $current=$iv_ruleJvmArgumentTypeReference.current; }
	EOF;

// Rule JvmArgumentTypeReference
ruleJvmArgumentTypeReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0());
		}
		this_JvmTypeReference_0=ruleJvmTypeReference
		{
			$current = $this_JvmTypeReference_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1());
		}
		this_JvmWildcardTypeReference_1=ruleJvmWildcardTypeReference
		{
			$current = $this_JvmWildcardTypeReference_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleJvmWildcardTypeReference
entryRuleJvmWildcardTypeReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); }
	iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference
	{ $current=$iv_ruleJvmWildcardTypeReference.current; }
	EOF;

// Rule JvmWildcardTypeReference
ruleJvmWildcardTypeReference returns [EObject current=null]
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
					grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
					$current);
			}
		)
		otherlv_1='?'
		{
			newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
		}
		(
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0_0());
						}
						lv_constraints_2_0=ruleJvmUpperBound
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
							}
							add(
								$current,
								"constraints",
								lv_constraints_2_0,
								"org.eclipse.xtext.xbase.Xtype.JvmUpperBound");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0());
						}
						lv_constraints_3_0=ruleJvmUpperBoundAnded
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
							}
							add(
								$current,
								"constraints",
								lv_constraints_3_0,
								"org.eclipse.xtext.xbase.Xtype.JvmUpperBoundAnded");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
			    |
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0_0());
						}
						lv_constraints_4_0=ruleJvmLowerBound
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
							}
							add(
								$current,
								"constraints",
								lv_constraints_4_0,
								"org.eclipse.xtext.xbase.Xtype.JvmLowerBound");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0());
						}
						lv_constraints_5_0=ruleJvmLowerBoundAnded
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
							}
							add(
								$current,
								"constraints",
								lv_constraints_5_0,
								"org.eclipse.xtext.xbase.Xtype.JvmLowerBoundAnded");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
		)?
	)
;

// Entry rule entryRuleJvmUpperBound
entryRuleJvmUpperBound returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJvmUpperBoundRule()); }
	iv_ruleJvmUpperBound=ruleJvmUpperBound
	{ $current=$iv_ruleJvmUpperBound.current; }
	EOF;

// Rule JvmUpperBound
ruleJvmUpperBound returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='extends'
		{
			newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
				}
				lv_typeReference_1_0=ruleJvmTypeReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJvmUpperBoundRule());
					}
					set(
						$current,
						"typeReference",
						lv_typeReference_1_0,
						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleJvmUpperBoundAnded
entryRuleJvmUpperBoundAnded returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); }
	iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded
	{ $current=$iv_ruleJvmUpperBoundAnded.current; }
	EOF;

// Rule JvmUpperBoundAnded
ruleJvmUpperBoundAnded returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='&'
		{
			newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
				}
				lv_typeReference_1_0=ruleJvmTypeReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJvmUpperBoundAndedRule());
					}
					set(
						$current,
						"typeReference",
						lv_typeReference_1_0,
						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleJvmLowerBound
entryRuleJvmLowerBound returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJvmLowerBoundRule()); }
	iv_ruleJvmLowerBound=ruleJvmLowerBound
	{ $current=$iv_ruleJvmLowerBound.current; }
	EOF;

// Rule JvmLowerBound
ruleJvmLowerBound returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='super'
		{
			newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
				}
				lv_typeReference_1_0=ruleJvmTypeReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJvmLowerBoundRule());
					}
					set(
						$current,
						"typeReference",
						lv_typeReference_1_0,
						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleJvmLowerBoundAnded
entryRuleJvmLowerBoundAnded returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJvmLowerBoundAndedRule()); }
	iv_ruleJvmLowerBoundAnded=ruleJvmLowerBoundAnded
	{ $current=$iv_ruleJvmLowerBoundAnded.current; }
	EOF;

// Rule JvmLowerBoundAnded
ruleJvmLowerBoundAnded returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='&'
		{
			newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAndedAccess().getAmpersandKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
				}
				lv_typeReference_1_0=ruleJvmTypeReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJvmLowerBoundAndedRule());
					}
					set(
						$current,
						"typeReference",
						lv_typeReference_1_0,
						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); }
	iv_ruleQualifiedName=ruleQualifiedName
	{ $current=$iv_ruleQualifiedName.current.getText(); }
	EOF;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0());
		}
		this_ValidID_0=ruleValidID
		{
			$current.merge(this_ValidID_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		(
			kw='.'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
			}
			{
				newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1());
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

// Entry rule entryRuleQualifiedNameWithWildcard
entryRuleQualifiedNameWithWildcard returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); }
	iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard
	{ $current=$iv_ruleQualifiedNameWithWildcard.current.getText(); }
	EOF;

// Rule QualifiedNameWithWildcard
ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0());
		}
		this_QualifiedName_0=ruleQualifiedName
		{
			$current.merge(this_QualifiedName_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		kw='.'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopKeyword_1());
		}
		kw='*'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getAsteriskKeyword_2());
		}
	)
;

// Entry rule entryRuleValidID
entryRuleValidID returns [String current=null]:
	{ newCompositeNode(grammarAccess.getValidIDRule()); }
	iv_ruleValidID=ruleValidID
	{ $current=$iv_ruleValidID.current.getText(); }
	EOF;

// Rule ValidID
ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
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
		newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall());
	}
;

// Entry rule entryRuleXImportDeclaration
entryRuleXImportDeclaration returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXImportDeclarationRule()); }
	iv_ruleXImportDeclaration=ruleXImportDeclaration
	{ $current=$iv_ruleXImportDeclaration.current; }
	EOF;

// Rule XImportDeclaration
ruleXImportDeclaration returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='import'
		{
			newLeafNode(otherlv_0, grammarAccess.getXImportDeclarationAccess().getImportKeyword_0());
		}
		(
			(
				(
					(
						lv_static_1_0='static'
						{
							newLeafNode(lv_static_1_0, grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getXImportDeclarationRule());
							}
							setWithLastConsumed($current, "static", lv_static_1_0 != null, "static");
						}
					)
				)
				(
					(
						lv_extension_2_0='extension'
						{
							newLeafNode(lv_extension_2_0, grammarAccess.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getXImportDeclarationRule());
							}
							setWithLastConsumed($current, "extension", lv_extension_2_0 != null, "extension");
						}
					)
				)?
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getXImportDeclarationRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0());
						}
						ruleQualifiedNameInStaticImport
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						(
							lv_wildcard_4_0='*'
							{
								newLeafNode(lv_wildcard_4_0, grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getXImportDeclarationRule());
								}
								setWithLastConsumed($current, "wildcard", lv_wildcard_4_0 != null, "*");
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getXImportDeclarationAccess().getMemberNameValidIDParserRuleCall_1_0_3_1_0());
							}
							lv_memberName_5_0=ruleValidID
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXImportDeclarationRule());
								}
								set(
									$current,
									"memberName",
									lv_memberName_5_0,
									"org.eclipse.xtext.xbase.Xtype.ValidID");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)
			)
			    |
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getXImportDeclarationRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_1_0());
					}
					ruleQualifiedName
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0());
					}
					lv_importedNamespace_7_0=ruleQualifiedNameWithWildcard
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXImportDeclarationRule());
						}
						set(
							$current,
							"importedNamespace",
							lv_importedNamespace_7_0,
							"org.eclipse.xtext.xbase.Xtype.QualifiedNameWithWildcard");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		(
			otherlv_8=';'
			{
				newLeafNode(otherlv_8, grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2());
			}
		)?
	)
;

// Entry rule entryRuleQualifiedNameInStaticImport
entryRuleQualifiedNameInStaticImport returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQualifiedNameInStaticImportRule()); }
	iv_ruleQualifiedNameInStaticImport=ruleQualifiedNameInStaticImport
	{ $current=$iv_ruleQualifiedNameInStaticImport.current.getText(); }
	EOF;

// Rule QualifiedNameInStaticImport
ruleQualifiedNameInStaticImport returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getQualifiedNameInStaticImportAccess().getValidIDParserRuleCall_0());
		}
		this_ValidID_0=ruleValidID
		{
			$current.merge(this_ValidID_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		kw='.'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQualifiedNameInStaticImportAccess().getFullStopKeyword_1());
		}
	)+
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'$'|'_') ('a'..'z'|'A'..'Z'|'$'|'_'|'0'..'9')*;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'?|'\'' ('\\' .|~(('\\'|'\'')))* '\''?);

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
