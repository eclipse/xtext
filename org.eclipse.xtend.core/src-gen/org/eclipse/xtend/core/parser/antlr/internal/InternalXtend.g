/*******************************************************************************
 * Copyright (c) 2010, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
grammar InternalXtend;

options {
	superClass=AbstractInternalAntlrParser;
}

tokens {
	KW_Package = 'package' ;
	KW_Semicolon = ';' ;
	KW_Class = 'class' ;
	KW_LessThanSign = '<' ;
	KW_Comma = ',' ;
	KW_GreaterThanSign = '>' ;
	KW_Extends = 'extends' ;
	KW_Implements = 'implements' ;
	KW_LeftCurlyBracket = '{' ;
	KW_RightCurlyBracket = '}' ;
	KW_Interface = 'interface' ;
	KW_Enum = 'enum' ;
	KW_Annotation = 'annotation' ;
	KW_LeftParenthesis = '(' ;
	KW_RightParenthesis = ')' ;
	KW_EqualsSignGreaterThanSign = '=>' ;
	KW_EqualsSign = '=' ;
	KW_Extension = 'extension' ;
	KW_Throws = 'throws' ;
	KW_New = 'new' ;
	KW_FullStop = '.' ;
	KW_Public = 'public' ;
	KW_Private = 'private' ;
	KW_Protected = 'protected' ;
	KW_Abstract = 'abstract' ;
	KW_Static = 'static' ;
	KW_Dispatch = 'dispatch' ;
	KW_Final = 'final' ;
	KW_Strictfp = 'strictfp' ;
	KW_Native = 'native' ;
	KW_Volatile = 'volatile' ;
	KW_Synchronized = 'synchronized' ;
	KW_Transient = 'transient' ;
	KW_Val = 'val' ;
	KW_Var = 'var' ;
	KW_Def = 'def' ;
	KW_Override = 'override' ;
	KW_Create = 'create' ;
	KW_Colon = ':' ;
	KW_AFTER = 'AFTER' ;
	KW_BEFORE = 'BEFORE' ;
	KW_SEPARATOR = 'SEPARATOR' ;
	KW_Import = 'import' ;
	KW_FullStopFullStopFullStop = '...' ;
	KW_QuestionMark = '?' ;
	KW_Try = 'try' ;
	KW_Finally = 'finally' ;
	KW_VerticalLine = '|' ;
	KW_Switch = 'switch' ;
	KW_Default = 'default' ;
	KW_Case = 'case' ;
	KW_FOR = 'FOR' ;
	KW_ENDFOR = 'ENDFOR' ;
	KW_IF = 'IF' ;
	KW_ELSE = 'ELSE' ;
	KW_ENDIF = 'ENDIF' ;
	KW_ELSEIF = 'ELSEIF' ;
	KW_CommercialAt = '@' ;
	KW_NumberSign = '#' ;
	KW_LeftSquareBracket = '[' ;
	KW_RightSquareBracket = ']' ;
	KW_PlusSignEqualsSign = '+=' ;
	KW_HyphenMinusEqualsSign = '-=' ;
	KW_AsteriskEqualsSign = '*=' ;
	KW_SolidusEqualsSign = '/=' ;
	KW_PercentSignEqualsSign = '%=' ;
	KW_GreaterThanSignEqualsSign = '>=' ;
	KW_VerticalLineVerticalLine = '||' ;
	KW_AmpersandAmpersand = '&&' ;
	KW_EqualsSignEqualsSign = '==' ;
	KW_ExclamationMarkEqualsSign = '!=' ;
	KW_EqualsSignEqualsSignEqualsSign = '===' ;
	KW_ExclamationMarkEqualsSignEqualsSign = '!==' ;
	KW_Instanceof = 'instanceof' ;
	KW_HyphenMinusGreaterThanSign = '->' ;
	KW_FullStopFullStopLessThanSign = '..<' ;
	KW_FullStopFullStop = '..' ;
	KW_LessThanSignGreaterThanSign = '<>' ;
	KW_QuestionMarkColon = '?:' ;
	KW_PlusSign = '+' ;
	KW_HyphenMinus = '-' ;
	KW_Asterisk = '*' ;
	KW_AsteriskAsterisk = '**' ;
	KW_Solidus = '/' ;
	KW_PercentSign = '%' ;
	KW_ExclamationMark = '!' ;
	KW_As = 'as' ;
	KW_PlusSignPlusSign = '++' ;
	KW_HyphenMinusHyphenMinus = '--' ;
	KW_ColonColon = '::' ;
	KW_QuestionMarkFullStop = '?.' ;
	KW_If = 'if' ;
	KW_Else = 'else' ;
	KW_For = 'for' ;
	KW_While = 'while' ;
	KW_Do = 'do' ;
	KW_Super = 'super' ;
	KW_False = 'false' ;
	KW_True = 'true' ;
	KW_Null = 'null' ;
	KW_Typeof = 'typeof' ;
	KW_Throw = 'throw' ;
	KW_Return = 'return' ;
	KW_Catch = 'catch' ;
	KW_Ampersand = '&' ;
}

@lexer::header {
package org.eclipse.xtend.core.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtend.core.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtend.core.services.XtendGrammarAccess;

}

@parser::members {

 	private XtendGrammarAccess grammarAccess;

    public InternalXtendParser(TokenStream input, XtendGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "File";
   	}

   	@Override
   	protected XtendGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleFile
entryRuleFile returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFileRule()); }
	iv_ruleFile=ruleFile
	{ $current=$iv_ruleFile.current; }
	EOF;

// Rule File
ruleFile returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='package'
			{
				newLeafNode(otherlv_0, grammarAccess.getFileAccess().getPackageKeyword_0_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getFileAccess().getPackageQualifiedNameParserRuleCall_0_1_0());
					}
					lv_package_1_0=ruleQualifiedName
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getFileRule());
						}
						set(
							$current,
							"package",
							lv_package_1_0,
							"org.eclipse.xtext.xbase.Xbase.QualifiedName");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_2=';'
				{
					newLeafNode(otherlv_2, grammarAccess.getFileAccess().getSemicolonKeyword_0_2());
				}
			)?
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getFileAccess().getImportSectionXImportSectionParserRuleCall_1_0());
				}
				lv_importSection_3_0=ruleXImportSection
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFileRule());
					}
					set(
						$current,
						"importSection",
						lv_importSection_3_0,
						"org.eclipse.xtext.xbase.Xtype.XImportSection");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getFileAccess().getXtendTypesTypeParserRuleCall_2_0());
				}
				lv_xtendTypes_4_0=ruleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFileRule());
					}
					add(
						$current,
						"xtendTypes",
						lv_xtendTypes_4_0,
						"org.eclipse.xtend.core.Xtend.Type");
					afterParserOrEnumRuleCall();
				}
			)
		)*
	)
;

// Entry rule entryRuleType
entryRuleType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeRule()); }
	iv_ruleType=ruleType
	{ $current=$iv_ruleType.current; }
	EOF;

// Rule Type
ruleType returns [EObject current=null]
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
					grammarAccess.getTypeAccess().getXtendTypeDeclarationAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getTypeAccess().getAnnotationsXAnnotationParserRuleCall_1_0());
				}
				lv_annotations_1_0=ruleXAnnotation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTypeRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_1_0,
						"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotation");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getTypeAccess().getXtendClassAnnotationInfoAction_2_0_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getTypeAccess().getModifiersCommonModifierParserRuleCall_2_0_1_0());
						}
						lv_modifiers_3_0=ruleCommonModifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTypeRule());
							}
							add(
								$current,
								"modifiers",
								lv_modifiers_3_0,
								"org.eclipse.xtend.core.Xtend.CommonModifier");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_4='class'
				{
					newLeafNode(otherlv_4, grammarAccess.getTypeAccess().getClassKeyword_2_0_2());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getTypeAccess().getNameValidIDParserRuleCall_2_0_3_0());
						}
						lv_name_5_0=ruleValidID
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTypeRule());
							}
							set(
								$current,
								"name",
								lv_name_5_0,
								"org.eclipse.xtend.core.Xtend.ValidID");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_6='<'
					{
						newLeafNode(otherlv_6, grammarAccess.getTypeAccess().getLessThanSignKeyword_2_0_4_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getTypeAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_0_4_1_0());
							}
							lv_typeParameters_7_0=ruleJvmTypeParameter
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getTypeRule());
								}
								add(
									$current,
									"typeParameters",
									lv_typeParameters_7_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_8=','
						{
							newLeafNode(otherlv_8, grammarAccess.getTypeAccess().getCommaKeyword_2_0_4_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getTypeAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_0_4_2_1_0());
								}
								lv_typeParameters_9_0=ruleJvmTypeParameter
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getTypeRule());
									}
									add(
										$current,
										"typeParameters",
										lv_typeParameters_9_0,
										"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
					otherlv_10='>'
					{
						newLeafNode(otherlv_10, grammarAccess.getTypeAccess().getGreaterThanSignKeyword_2_0_4_3());
					}
				)?
				(
					otherlv_11='extends'
					{
						newLeafNode(otherlv_11, grammarAccess.getTypeAccess().getExtendsKeyword_2_0_5_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getTypeAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_0_5_1_0());
							}
							lv_extends_12_0=ruleJvmParameterizedTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getTypeRule());
								}
								set(
									$current,
									"extends",
									lv_extends_12_0,
									"org.eclipse.xtext.xbase.Xtype.JvmParameterizedTypeReference");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)?
				(
					otherlv_13='implements'
					{
						newLeafNode(otherlv_13, grammarAccess.getTypeAccess().getImplementsKeyword_2_0_6_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getTypeAccess().getImplementsJvmSuperTypeReferenceParserRuleCall_2_0_6_1_0());
							}
							lv_implements_14_0=ruleJvmSuperTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getTypeRule());
								}
								add(
									$current,
									"implements",
									lv_implements_14_0,
									"org.eclipse.xtend.core.Xtend.JvmSuperTypeReference");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_15=','
						{
							newLeafNode(otherlv_15, grammarAccess.getTypeAccess().getCommaKeyword_2_0_6_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getTypeAccess().getImplementsJvmSuperTypeReferenceParserRuleCall_2_0_6_2_1_0());
								}
								lv_implements_16_0=ruleJvmSuperTypeReference
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getTypeRule());
									}
									add(
										$current,
										"implements",
										lv_implements_16_0,
										"org.eclipse.xtend.core.Xtend.JvmSuperTypeReference");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)?
				otherlv_17='{'
				{
					newLeafNode(otherlv_17, grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_2_0_7());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getTypeAccess().getMembersMemberParserRuleCall_2_0_8_0());
						}
						lv_members_18_0=ruleMember
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTypeRule());
							}
							add(
								$current,
								"members",
								lv_members_18_0,
								"org.eclipse.xtend.core.Xtend.Member");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_19='}'
				{
					newLeafNode(otherlv_19, grammarAccess.getTypeAccess().getRightCurlyBracketKeyword_2_0_9());
				}
			)
			    |
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getTypeAccess().getXtendInterfaceAnnotationInfoAction_2_1_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getTypeAccess().getModifiersCommonModifierParserRuleCall_2_1_1_0());
						}
						lv_modifiers_21_0=ruleCommonModifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTypeRule());
							}
							add(
								$current,
								"modifiers",
								lv_modifiers_21_0,
								"org.eclipse.xtend.core.Xtend.CommonModifier");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_22='interface'
				{
					newLeafNode(otherlv_22, grammarAccess.getTypeAccess().getInterfaceKeyword_2_1_2());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getTypeAccess().getNameValidIDParserRuleCall_2_1_3_0());
						}
						lv_name_23_0=ruleValidID
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTypeRule());
							}
							set(
								$current,
								"name",
								lv_name_23_0,
								"org.eclipse.xtend.core.Xtend.ValidID");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_24='<'
					{
						newLeafNode(otherlv_24, grammarAccess.getTypeAccess().getLessThanSignKeyword_2_1_4_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getTypeAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0());
							}
							lv_typeParameters_25_0=ruleJvmTypeParameter
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getTypeRule());
								}
								add(
									$current,
									"typeParameters",
									lv_typeParameters_25_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_26=','
						{
							newLeafNode(otherlv_26, grammarAccess.getTypeAccess().getCommaKeyword_2_1_4_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getTypeAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0());
								}
								lv_typeParameters_27_0=ruleJvmTypeParameter
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getTypeRule());
									}
									add(
										$current,
										"typeParameters",
										lv_typeParameters_27_0,
										"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
					otherlv_28='>'
					{
						newLeafNode(otherlv_28, grammarAccess.getTypeAccess().getGreaterThanSignKeyword_2_1_4_3());
					}
				)?
				(
					otherlv_29='extends'
					{
						newLeafNode(otherlv_29, grammarAccess.getTypeAccess().getExtendsKeyword_2_1_5_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getTypeAccess().getExtendsJvmSuperTypeReferenceParserRuleCall_2_1_5_1_0());
							}
							lv_extends_30_0=ruleJvmSuperTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getTypeRule());
								}
								add(
									$current,
									"extends",
									lv_extends_30_0,
									"org.eclipse.xtend.core.Xtend.JvmSuperTypeReference");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_31=','
						{
							newLeafNode(otherlv_31, grammarAccess.getTypeAccess().getCommaKeyword_2_1_5_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getTypeAccess().getExtendsJvmSuperTypeReferenceParserRuleCall_2_1_5_2_1_0());
								}
								lv_extends_32_0=ruleJvmSuperTypeReference
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getTypeRule());
									}
									add(
										$current,
										"extends",
										lv_extends_32_0,
										"org.eclipse.xtend.core.Xtend.JvmSuperTypeReference");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)?
				otherlv_33='{'
				{
					newLeafNode(otherlv_33, grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_2_1_6());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getTypeAccess().getMembersMemberParserRuleCall_2_1_7_0());
						}
						lv_members_34_0=ruleMember
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTypeRule());
							}
							add(
								$current,
								"members",
								lv_members_34_0,
								"org.eclipse.xtend.core.Xtend.Member");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_35='}'
				{
					newLeafNode(otherlv_35, grammarAccess.getTypeAccess().getRightCurlyBracketKeyword_2_1_8());
				}
			)
			    |
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getTypeAccess().getXtendEnumAnnotationInfoAction_2_2_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getTypeAccess().getModifiersCommonModifierParserRuleCall_2_2_1_0());
						}
						lv_modifiers_37_0=ruleCommonModifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTypeRule());
							}
							add(
								$current,
								"modifiers",
								lv_modifiers_37_0,
								"org.eclipse.xtend.core.Xtend.CommonModifier");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_38='enum'
				{
					newLeafNode(otherlv_38, grammarAccess.getTypeAccess().getEnumKeyword_2_2_2());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getTypeAccess().getNameValidIDParserRuleCall_2_2_3_0());
						}
						lv_name_39_0=ruleValidID
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTypeRule());
							}
							set(
								$current,
								"name",
								lv_name_39_0,
								"org.eclipse.xtend.core.Xtend.ValidID");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_40='{'
				{
					newLeafNode(otherlv_40, grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_2_2_4());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getTypeAccess().getMembersXtendEnumLiteralParserRuleCall_2_2_5_0_0());
							}
							lv_members_41_0=ruleXtendEnumLiteral
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getTypeRule());
								}
								add(
									$current,
									"members",
									lv_members_41_0,
									"org.eclipse.xtend.core.Xtend.XtendEnumLiteral");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_42=','
						{
							newLeafNode(otherlv_42, grammarAccess.getTypeAccess().getCommaKeyword_2_2_5_1_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getTypeAccess().getMembersXtendEnumLiteralParserRuleCall_2_2_5_1_1_0());
								}
								lv_members_43_0=ruleXtendEnumLiteral
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getTypeRule());
									}
									add(
										$current,
										"members",
										lv_members_43_0,
										"org.eclipse.xtend.core.Xtend.XtendEnumLiteral");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)?
				(
					otherlv_44=';'
					{
						newLeafNode(otherlv_44, grammarAccess.getTypeAccess().getSemicolonKeyword_2_2_6());
					}
				)?
				otherlv_45='}'
				{
					newLeafNode(otherlv_45, grammarAccess.getTypeAccess().getRightCurlyBracketKeyword_2_2_7());
				}
			)
			    |
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getTypeAccess().getXtendAnnotationTypeAnnotationInfoAction_2_3_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getTypeAccess().getModifiersCommonModifierParserRuleCall_2_3_1_0());
						}
						lv_modifiers_47_0=ruleCommonModifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTypeRule());
							}
							add(
								$current,
								"modifiers",
								lv_modifiers_47_0,
								"org.eclipse.xtend.core.Xtend.CommonModifier");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_48='annotation'
				{
					newLeafNode(otherlv_48, grammarAccess.getTypeAccess().getAnnotationKeyword_2_3_2());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getTypeAccess().getNameValidIDParserRuleCall_2_3_3_0());
						}
						lv_name_49_0=ruleValidID
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTypeRule());
							}
							set(
								$current,
								"name",
								lv_name_49_0,
								"org.eclipse.xtend.core.Xtend.ValidID");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_50='{'
				{
					newLeafNode(otherlv_50, grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_2_3_4());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getTypeAccess().getMembersAnnotationFieldParserRuleCall_2_3_5_0());
						}
						lv_members_51_0=ruleAnnotationField
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTypeRule());
							}
							add(
								$current,
								"members",
								lv_members_51_0,
								"org.eclipse.xtend.core.Xtend.AnnotationField");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_52='}'
				{
					newLeafNode(otherlv_52, grammarAccess.getTypeAccess().getRightCurlyBracketKeyword_2_3_6());
				}
			)
		)
	)
;

// Entry rule entryRuleJvmSuperTypeReference
entryRuleJvmSuperTypeReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJvmSuperTypeReferenceRule()); }
	iv_ruleJvmSuperTypeReference=ruleJvmSuperTypeReference
	{ $current=$iv_ruleJvmSuperTypeReference.current; }
	EOF;

// Rule JvmSuperTypeReference
ruleJvmSuperTypeReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getJvmSuperTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0());
		}
		this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference
		{
			$current = $this_JvmParameterizedTypeReference_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getJvmSuperTypeReferenceAccess().getXFunctionSuperTypeRefParserRuleCall_1());
		}
		this_XFunctionSuperTypeRef_1=ruleXFunctionSuperTypeRef
		{
			$current = $this_XFunctionSuperTypeRef_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleXFunctionSuperTypeRef
entryRuleXFunctionSuperTypeRef returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXFunctionSuperTypeRefRule()); }
	iv_ruleXFunctionSuperTypeRef=ruleXFunctionSuperTypeRef
	{ $current=$iv_ruleXFunctionSuperTypeRef.current; }
	EOF;

// Rule XFunctionSuperTypeRef
ruleXFunctionSuperTypeRef returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				(
					lv_instanceContext_0_0='('
					{
						newLeafNode(lv_instanceContext_0_0, grammarAccess.getXFunctionSuperTypeRefAccess().getInstanceContextLeftParenthesisKeyword_0_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getXFunctionSuperTypeRefRule());
						}
						setWithLastConsumed($current, "instanceContext", lv_instanceContext_0_0 != null, "(");
					}
				)
			)
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getXFunctionSuperTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0());
						}
						lv_paramTypes_1_0=ruleJvmTypeReference
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXFunctionSuperTypeRefRule());
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
						newLeafNode(otherlv_2, grammarAccess.getXFunctionSuperTypeRefAccess().getCommaKeyword_0_1_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getXFunctionSuperTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0());
							}
							lv_paramTypes_3_0=ruleJvmTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXFunctionSuperTypeRefRule());
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
				newLeafNode(otherlv_4, grammarAccess.getXFunctionSuperTypeRefAccess().getRightParenthesisKeyword_0_2());
			}
		)?
		otherlv_5='=>'
		{
			newLeafNode(otherlv_5, grammarAccess.getXFunctionSuperTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXFunctionSuperTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0());
				}
				lv_returnType_6_0=ruleJvmTypeReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXFunctionSuperTypeRefRule());
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

// Entry rule entryRuleAnnotationField
entryRuleAnnotationField returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAnnotationFieldRule()); }
	iv_ruleAnnotationField=ruleAnnotationField
	{ $current=$iv_ruleAnnotationField.current; }
	EOF;

// Rule AnnotationField
ruleAnnotationField returns [EObject current=null]
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
					grammarAccess.getAnnotationFieldAccess().getXtendMemberAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getAnnotationFieldAccess().getAnnotationsXAnnotationParserRuleCall_1_0());
				}
				lv_annotations_1_0=ruleXAnnotation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_1_0,
						"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotation");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				(
					(
						(
							{
								$current = forceCreateModelElementAndSet(
									grammarAccess.getAnnotationFieldAccess().getXtendFieldAnnotationInfoAction_2_0_0_0_0(),
									$current);
							}
						)
						(
							(
								{
									newCompositeNode(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_0_0_0_1_0());
								}
								lv_modifiers_3_0=ruleCommonModifier
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
									}
									add(
										$current,
										"modifiers",
										lv_modifiers_3_0,
										"org.eclipse.xtend.core.Xtend.CommonModifier");
									afterParserOrEnumRuleCall();
								}
							)
						)*
						(
							(
								{
									newCompositeNode(grammarAccess.getAnnotationFieldAccess().getModifiersFieldModifierParserRuleCall_2_0_0_0_2_0());
								}
								lv_modifiers_4_0=ruleFieldModifier
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
									}
									add(
										$current,
										"modifiers",
										lv_modifiers_4_0,
										"org.eclipse.xtend.core.Xtend.FieldModifier");
									afterParserOrEnumRuleCall();
								}
							)
						)
						(
							(
								{
									newCompositeNode(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_0_0_0_3_0());
								}
								lv_modifiers_5_0=ruleCommonModifier
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
									}
									add(
										$current,
										"modifiers",
										lv_modifiers_5_0,
										"org.eclipse.xtend.core.Xtend.CommonModifier");
									afterParserOrEnumRuleCall();
								}
							)
						)*
						(
							(
								{
									newCompositeNode(grammarAccess.getAnnotationFieldAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_4_0());
								}
								lv_type_6_0=ruleJvmTypeReference
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
									}
									set(
										$current,
										"type",
										lv_type_6_0,
										"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
									afterParserOrEnumRuleCall();
								}
							)
						)?
						(
							(
								{
									newCompositeNode(grammarAccess.getAnnotationFieldAccess().getNameValidIDParserRuleCall_2_0_0_0_5_0());
								}
								lv_name_7_0=ruleValidID
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
									}
									set(
										$current,
										"name",
										lv_name_7_0,
										"org.eclipse.xtend.core.Xtend.ValidID");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)
					    |
					(
						(
							{
								$current = forceCreateModelElementAndSet(
									grammarAccess.getAnnotationFieldAccess().getXtendFieldAnnotationInfoAction_2_0_0_1_0(),
									$current);
							}
						)
						(
							(
								{
									newCompositeNode(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_0_0_1_1_0());
								}
								lv_modifiers_9_0=ruleCommonModifier
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
									}
									add(
										$current,
										"modifiers",
										lv_modifiers_9_0,
										"org.eclipse.xtend.core.Xtend.CommonModifier");
									afterParserOrEnumRuleCall();
								}
							)
						)*
						(
							(
								{
									newCompositeNode(grammarAccess.getAnnotationFieldAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_1_2_0());
								}
								lv_type_10_0=ruleJvmTypeReference
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
									}
									set(
										$current,
										"type",
										lv_type_10_0,
										"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
									afterParserOrEnumRuleCall();
								}
							)
						)
						(
							(
								{
									newCompositeNode(grammarAccess.getAnnotationFieldAccess().getNameValidIDParserRuleCall_2_0_0_1_3_0());
								}
								lv_name_11_0=ruleValidID
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
									}
									set(
										$current,
										"name",
										lv_name_11_0,
										"org.eclipse.xtend.core.Xtend.ValidID");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)
				)
				(
					otherlv_12='='
					{
						newLeafNode(otherlv_12, grammarAccess.getAnnotationFieldAccess().getEqualsSignKeyword_2_0_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getAnnotationFieldAccess().getInitialValueXAnnotationElementValueParserRuleCall_2_0_1_1_0());
							}
							lv_initialValue_13_0=ruleXAnnotationElementValue
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
								}
								set(
									$current,
									"initialValue",
									lv_initialValue_13_0,
									"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotationElementValue");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)?
				(
					otherlv_14=';'
					{
						newLeafNode(otherlv_14, grammarAccess.getAnnotationFieldAccess().getSemicolonKeyword_2_0_2());
					}
				)?
			)
			    |
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getAnnotationFieldAccess().getXtendClassAnnotationInfoAction_2_1_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_1_1_0());
						}
						lv_modifiers_16_0=ruleCommonModifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
							}
							add(
								$current,
								"modifiers",
								lv_modifiers_16_0,
								"org.eclipse.xtend.core.Xtend.CommonModifier");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_17='class'
				{
					newLeafNode(otherlv_17, grammarAccess.getAnnotationFieldAccess().getClassKeyword_2_1_2());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getAnnotationFieldAccess().getNameValidIDParserRuleCall_2_1_3_0());
						}
						lv_name_18_0=ruleValidID
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
							}
							set(
								$current,
								"name",
								lv_name_18_0,
								"org.eclipse.xtend.core.Xtend.ValidID");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_19='<'
					{
						newLeafNode(otherlv_19, grammarAccess.getAnnotationFieldAccess().getLessThanSignKeyword_2_1_4_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getAnnotationFieldAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0());
							}
							lv_typeParameters_20_0=ruleJvmTypeParameter
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
								}
								add(
									$current,
									"typeParameters",
									lv_typeParameters_20_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_21=','
						{
							newLeafNode(otherlv_21, grammarAccess.getAnnotationFieldAccess().getCommaKeyword_2_1_4_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getAnnotationFieldAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0());
								}
								lv_typeParameters_22_0=ruleJvmTypeParameter
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
									}
									add(
										$current,
										"typeParameters",
										lv_typeParameters_22_0,
										"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
					otherlv_23='>'
					{
						newLeafNode(otherlv_23, grammarAccess.getAnnotationFieldAccess().getGreaterThanSignKeyword_2_1_4_3());
					}
				)?
				(
					otherlv_24='extends'
					{
						newLeafNode(otherlv_24, grammarAccess.getAnnotationFieldAccess().getExtendsKeyword_2_1_5_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getAnnotationFieldAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_1_5_1_0());
							}
							lv_extends_25_0=ruleJvmParameterizedTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
								}
								set(
									$current,
									"extends",
									lv_extends_25_0,
									"org.eclipse.xtext.xbase.Xtype.JvmParameterizedTypeReference");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)?
				(
					otherlv_26='implements'
					{
						newLeafNode(otherlv_26, grammarAccess.getAnnotationFieldAccess().getImplementsKeyword_2_1_6_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getAnnotationFieldAccess().getImplementsJvmParameterizedTypeReferenceParserRuleCall_2_1_6_1_0());
							}
							lv_implements_27_0=ruleJvmParameterizedTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
								}
								add(
									$current,
									"implements",
									lv_implements_27_0,
									"org.eclipse.xtext.xbase.Xtype.JvmParameterizedTypeReference");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_28=','
						{
							newLeafNode(otherlv_28, grammarAccess.getAnnotationFieldAccess().getCommaKeyword_2_1_6_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getAnnotationFieldAccess().getImplementsJvmParameterizedTypeReferenceParserRuleCall_2_1_6_2_1_0());
								}
								lv_implements_29_0=ruleJvmParameterizedTypeReference
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
									}
									add(
										$current,
										"implements",
										lv_implements_29_0,
										"org.eclipse.xtext.xbase.Xtype.JvmParameterizedTypeReference");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)?
				otherlv_30='{'
				{
					newLeafNode(otherlv_30, grammarAccess.getAnnotationFieldAccess().getLeftCurlyBracketKeyword_2_1_7());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getAnnotationFieldAccess().getMembersMemberParserRuleCall_2_1_8_0());
						}
						lv_members_31_0=ruleMember
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
							}
							add(
								$current,
								"members",
								lv_members_31_0,
								"org.eclipse.xtend.core.Xtend.Member");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_32='}'
				{
					newLeafNode(otherlv_32, grammarAccess.getAnnotationFieldAccess().getRightCurlyBracketKeyword_2_1_9());
				}
			)
			    |
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getAnnotationFieldAccess().getXtendInterfaceAnnotationInfoAction_2_2_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_2_1_0());
						}
						lv_modifiers_34_0=ruleCommonModifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
							}
							add(
								$current,
								"modifiers",
								lv_modifiers_34_0,
								"org.eclipse.xtend.core.Xtend.CommonModifier");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_35='interface'
				{
					newLeafNode(otherlv_35, grammarAccess.getAnnotationFieldAccess().getInterfaceKeyword_2_2_2());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getAnnotationFieldAccess().getNameValidIDParserRuleCall_2_2_3_0());
						}
						lv_name_36_0=ruleValidID
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
							}
							set(
								$current,
								"name",
								lv_name_36_0,
								"org.eclipse.xtend.core.Xtend.ValidID");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_37='<'
					{
						newLeafNode(otherlv_37, grammarAccess.getAnnotationFieldAccess().getLessThanSignKeyword_2_2_4_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getAnnotationFieldAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_2_4_1_0());
							}
							lv_typeParameters_38_0=ruleJvmTypeParameter
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
								}
								add(
									$current,
									"typeParameters",
									lv_typeParameters_38_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_39=','
						{
							newLeafNode(otherlv_39, grammarAccess.getAnnotationFieldAccess().getCommaKeyword_2_2_4_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getAnnotationFieldAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_2_4_2_1_0());
								}
								lv_typeParameters_40_0=ruleJvmTypeParameter
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
									}
									add(
										$current,
										"typeParameters",
										lv_typeParameters_40_0,
										"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
					otherlv_41='>'
					{
						newLeafNode(otherlv_41, grammarAccess.getAnnotationFieldAccess().getGreaterThanSignKeyword_2_2_4_3());
					}
				)?
				(
					otherlv_42='extends'
					{
						newLeafNode(otherlv_42, grammarAccess.getAnnotationFieldAccess().getExtendsKeyword_2_2_5_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getAnnotationFieldAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_2_5_1_0());
							}
							lv_extends_43_0=ruleJvmParameterizedTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
								}
								add(
									$current,
									"extends",
									lv_extends_43_0,
									"org.eclipse.xtext.xbase.Xtype.JvmParameterizedTypeReference");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_44=','
						{
							newLeafNode(otherlv_44, grammarAccess.getAnnotationFieldAccess().getCommaKeyword_2_2_5_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getAnnotationFieldAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_2_5_2_1_0());
								}
								lv_extends_45_0=ruleJvmParameterizedTypeReference
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
									}
									add(
										$current,
										"extends",
										lv_extends_45_0,
										"org.eclipse.xtext.xbase.Xtype.JvmParameterizedTypeReference");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)?
				otherlv_46='{'
				{
					newLeafNode(otherlv_46, grammarAccess.getAnnotationFieldAccess().getLeftCurlyBracketKeyword_2_2_6());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getAnnotationFieldAccess().getMembersMemberParserRuleCall_2_2_7_0());
						}
						lv_members_47_0=ruleMember
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
							}
							add(
								$current,
								"members",
								lv_members_47_0,
								"org.eclipse.xtend.core.Xtend.Member");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_48='}'
				{
					newLeafNode(otherlv_48, grammarAccess.getAnnotationFieldAccess().getRightCurlyBracketKeyword_2_2_8());
				}
			)
			    |
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getAnnotationFieldAccess().getXtendEnumAnnotationInfoAction_2_3_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_3_1_0());
						}
						lv_modifiers_50_0=ruleCommonModifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
							}
							add(
								$current,
								"modifiers",
								lv_modifiers_50_0,
								"org.eclipse.xtend.core.Xtend.CommonModifier");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_51='enum'
				{
					newLeafNode(otherlv_51, grammarAccess.getAnnotationFieldAccess().getEnumKeyword_2_3_2());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getAnnotationFieldAccess().getNameValidIDParserRuleCall_2_3_3_0());
						}
						lv_name_52_0=ruleValidID
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
							}
							set(
								$current,
								"name",
								lv_name_52_0,
								"org.eclipse.xtend.core.Xtend.ValidID");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_53='{'
				{
					newLeafNode(otherlv_53, grammarAccess.getAnnotationFieldAccess().getLeftCurlyBracketKeyword_2_3_4());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getAnnotationFieldAccess().getMembersXtendEnumLiteralParserRuleCall_2_3_5_0_0());
							}
							lv_members_54_0=ruleXtendEnumLiteral
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
								}
								add(
									$current,
									"members",
									lv_members_54_0,
									"org.eclipse.xtend.core.Xtend.XtendEnumLiteral");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_55=','
						{
							newLeafNode(otherlv_55, grammarAccess.getAnnotationFieldAccess().getCommaKeyword_2_3_5_1_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getAnnotationFieldAccess().getMembersXtendEnumLiteralParserRuleCall_2_3_5_1_1_0());
								}
								lv_members_56_0=ruleXtendEnumLiteral
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
									}
									add(
										$current,
										"members",
										lv_members_56_0,
										"org.eclipse.xtend.core.Xtend.XtendEnumLiteral");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)?
				(
					otherlv_57=';'
					{
						newLeafNode(otherlv_57, grammarAccess.getAnnotationFieldAccess().getSemicolonKeyword_2_3_6());
					}
				)?
				otherlv_58='}'
				{
					newLeafNode(otherlv_58, grammarAccess.getAnnotationFieldAccess().getRightCurlyBracketKeyword_2_3_7());
				}
			)
			    |
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getAnnotationFieldAccess().getXtendAnnotationTypeAnnotationInfoAction_2_4_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_4_1_0());
						}
						lv_modifiers_60_0=ruleCommonModifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
							}
							add(
								$current,
								"modifiers",
								lv_modifiers_60_0,
								"org.eclipse.xtend.core.Xtend.CommonModifier");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_61='annotation'
				{
					newLeafNode(otherlv_61, grammarAccess.getAnnotationFieldAccess().getAnnotationKeyword_2_4_2());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getAnnotationFieldAccess().getNameValidIDParserRuleCall_2_4_3_0());
						}
						lv_name_62_0=ruleValidID
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
							}
							set(
								$current,
								"name",
								lv_name_62_0,
								"org.eclipse.xtend.core.Xtend.ValidID");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_63='{'
				{
					newLeafNode(otherlv_63, grammarAccess.getAnnotationFieldAccess().getLeftCurlyBracketKeyword_2_4_4());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getAnnotationFieldAccess().getMembersAnnotationFieldParserRuleCall_2_4_5_0());
						}
						lv_members_64_0=ruleAnnotationField
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAnnotationFieldRule());
							}
							add(
								$current,
								"members",
								lv_members_64_0,
								"org.eclipse.xtend.core.Xtend.AnnotationField");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_65='}'
				{
					newLeafNode(otherlv_65, grammarAccess.getAnnotationFieldAccess().getRightCurlyBracketKeyword_2_4_6());
				}
			)
		)
	)
;

// Entry rule entryRuleMember
entryRuleMember returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMemberRule()); }
	iv_ruleMember=ruleMember
	{ $current=$iv_ruleMember.current; }
	EOF;

// Rule Member
ruleMember returns [EObject current=null]
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
					grammarAccess.getMemberAccess().getXtendMemberAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getMemberAccess().getAnnotationsXAnnotationParserRuleCall_1_0());
				}
				lv_annotations_1_0=ruleXAnnotation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMemberRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_1_0,
						"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotation");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getMemberAccess().getXtendFieldAnnotationInfoAction_2_0_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_0_1_0());
						}
						lv_modifiers_3_0=ruleCommonModifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMemberRule());
							}
							add(
								$current,
								"modifiers",
								lv_modifiers_3_0,
								"org.eclipse.xtend.core.Xtend.CommonModifier");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				(
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getModifiersFieldModifierParserRuleCall_2_0_2_0_0_0());
								}
								lv_modifiers_4_0=ruleFieldModifier
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									add(
										$current,
										"modifiers",
										lv_modifiers_4_0,
										"org.eclipse.xtend.core.Xtend.FieldModifier");
									afterParserOrEnumRuleCall();
								}
							)
						)
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_0_2_0_1_0());
								}
								lv_modifiers_5_0=ruleCommonModifier
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									add(
										$current,
										"modifiers",
										lv_modifiers_5_0,
										"org.eclipse.xtend.core.Xtend.CommonModifier");
									afterParserOrEnumRuleCall();
								}
							)
						)*
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_2_0_2_0());
								}
								lv_type_6_0=ruleJvmTypeReference
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									set(
										$current,
										"type",
										lv_type_6_0,
										"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
									afterParserOrEnumRuleCall();
								}
							)
						)?
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_0_2_0_3_0());
								}
								lv_name_7_0=ruleValidID
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									set(
										$current,
										"name",
										lv_name_7_0,
										"org.eclipse.xtend.core.Xtend.ValidID");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)
					    |
					(
						(
							(
								lv_modifiers_8_0='extension'
								{
									newLeafNode(lv_modifiers_8_0, grammarAccess.getMemberAccess().getModifiersExtensionKeyword_2_0_2_1_0_0());
								}
								{
									if ($current==null) {
										$current = createModelElement(grammarAccess.getMemberRule());
									}
									addWithLastConsumed($current, "modifiers", lv_modifiers_8_0, "extension");
								}
							)
						)
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getMemberAccess().getModifiersFieldModifierParserRuleCall_2_0_2_1_1_0_0());
									}
									lv_modifiers_9_0=ruleFieldModifier
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getMemberRule());
										}
										add(
											$current,
											"modifiers",
											lv_modifiers_9_0,
											"org.eclipse.xtend.core.Xtend.FieldModifier");
										afterParserOrEnumRuleCall();
									}
								)
							)
							    |
							(
								(
									{
										newCompositeNode(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_0_2_1_1_1_0());
									}
									lv_modifiers_10_0=ruleCommonModifier
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getMemberRule());
										}
										add(
											$current,
											"modifiers",
											lv_modifiers_10_0,
											"org.eclipse.xtend.core.Xtend.CommonModifier");
										afterParserOrEnumRuleCall();
									}
								)
							)
						)*
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_2_1_2_0());
								}
								lv_type_11_0=ruleJvmTypeReference
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									set(
										$current,
										"type",
										lv_type_11_0,
										"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
									afterParserOrEnumRuleCall();
								}
							)
						)
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_0_2_1_3_0());
								}
								lv_name_12_0=ruleValidID
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									set(
										$current,
										"name",
										lv_name_12_0,
										"org.eclipse.xtend.core.Xtend.ValidID");
									afterParserOrEnumRuleCall();
								}
							)
						)?
					)
					    |
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getModifiersFieldModifierParserRuleCall_2_0_2_2_0_0());
								}
								lv_modifiers_13_0=ruleFieldModifier
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									add(
										$current,
										"modifiers",
										lv_modifiers_13_0,
										"org.eclipse.xtend.core.Xtend.FieldModifier");
									afterParserOrEnumRuleCall();
								}
							)
						)
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_0_2_2_1_0());
								}
								lv_modifiers_14_0=ruleCommonModifier
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									add(
										$current,
										"modifiers",
										lv_modifiers_14_0,
										"org.eclipse.xtend.core.Xtend.CommonModifier");
									afterParserOrEnumRuleCall();
								}
							)
						)*
						(
							(
								lv_modifiers_15_0='extension'
								{
									newLeafNode(lv_modifiers_15_0, grammarAccess.getMemberAccess().getModifiersExtensionKeyword_2_0_2_2_2_0());
								}
								{
									if ($current==null) {
										$current = createModelElement(grammarAccess.getMemberRule());
									}
									addWithLastConsumed($current, "modifiers", lv_modifiers_15_0, "extension");
								}
							)
						)
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_0_2_2_3_0());
								}
								lv_modifiers_16_0=ruleCommonModifier
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									add(
										$current,
										"modifiers",
										lv_modifiers_16_0,
										"org.eclipse.xtend.core.Xtend.CommonModifier");
									afterParserOrEnumRuleCall();
								}
							)
						)*
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_2_2_4_0());
								}
								lv_type_17_0=ruleJvmTypeReference
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									set(
										$current,
										"type",
										lv_type_17_0,
										"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
									afterParserOrEnumRuleCall();
								}
							)
						)
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_0_2_2_5_0());
								}
								lv_name_18_0=ruleValidID
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									set(
										$current,
										"name",
										lv_name_18_0,
										"org.eclipse.xtend.core.Xtend.ValidID");
									afterParserOrEnumRuleCall();
								}
							)
						)?
					)
					    |
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_2_3_0_0());
								}
								lv_type_19_0=ruleJvmTypeReference
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									set(
										$current,
										"type",
										lv_type_19_0,
										"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
									afterParserOrEnumRuleCall();
								}
							)
						)
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_0_2_3_1_0());
								}
								lv_name_20_0=ruleValidID
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									set(
										$current,
										"name",
										lv_name_20_0,
										"org.eclipse.xtend.core.Xtend.ValidID");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)
				)
				(
					otherlv_21='='
					{
						newLeafNode(otherlv_21, grammarAccess.getMemberAccess().getEqualsSignKeyword_2_0_3_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getMemberAccess().getInitialValueXExpressionParserRuleCall_2_0_3_1_0());
							}
							lv_initialValue_22_0=ruleXExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMemberRule());
								}
								set(
									$current,
									"initialValue",
									lv_initialValue_22_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)?
				(
					otherlv_23=';'
					{
						newLeafNode(otherlv_23, grammarAccess.getMemberAccess().getSemicolonKeyword_2_0_4());
					}
				)?
			)
			    |
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getMemberAccess().getXtendFunctionAnnotationInfoAction_2_1_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_1_1_0());
						}
						lv_modifiers_25_0=ruleCommonModifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMemberRule());
							}
							add(
								$current,
								"modifiers",
								lv_modifiers_25_0,
								"org.eclipse.xtend.core.Xtend.CommonModifier");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				(
					(
						{
							newCompositeNode(grammarAccess.getMemberAccess().getModifiersMethodModifierParserRuleCall_2_1_2_0());
						}
						lv_modifiers_26_0=ruleMethodModifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMemberRule());
							}
							add(
								$current,
								"modifiers",
								lv_modifiers_26_0,
								"org.eclipse.xtend.core.Xtend.MethodModifier");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_1_3_0_0());
							}
							lv_modifiers_27_0=ruleCommonModifier
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMemberRule());
								}
								add(
									$current,
									"modifiers",
									lv_modifiers_27_0,
									"org.eclipse.xtend.core.Xtend.CommonModifier");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMemberAccess().getModifiersMethodModifierParserRuleCall_2_1_3_1_0());
							}
							lv_modifiers_28_0=ruleMethodModifier
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMemberRule());
								}
								add(
									$current,
									"modifiers",
									lv_modifiers_28_0,
									"org.eclipse.xtend.core.Xtend.MethodModifier");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
				(
					otherlv_29='<'
					{
						newLeafNode(otherlv_29, grammarAccess.getMemberAccess().getLessThanSignKeyword_2_1_4_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0());
							}
							lv_typeParameters_30_0=ruleJvmTypeParameter
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMemberRule());
								}
								add(
									$current,
									"typeParameters",
									lv_typeParameters_30_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_31=','
						{
							newLeafNode(otherlv_31, grammarAccess.getMemberAccess().getCommaKeyword_2_1_4_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0());
								}
								lv_typeParameters_32_0=ruleJvmTypeParameter
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									add(
										$current,
										"typeParameters",
										lv_typeParameters_32_0,
										"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
					otherlv_33='>'
					{
						newLeafNode(otherlv_33, grammarAccess.getMemberAccess().getGreaterThanSignKeyword_2_1_4_3());
					}
				)?
				(
					(
						((
							(
								(
									ruleJvmTypeReference
								)
							)
							(
								(
									ruleCreateExtensionInfo
								)
							)
							(
								(
									ruleValidID
								)
							)
							'('
						)
						)=>
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getMemberAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_1_5_0_0_0_0());
									}
									lv_returnType_34_0=ruleJvmTypeReference
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getMemberRule());
										}
										set(
											$current,
											"returnType",
											lv_returnType_34_0,
											"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
										afterParserOrEnumRuleCall();
									}
								)
							)
							(
								(
									{
										newCompositeNode(grammarAccess.getMemberAccess().getCreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_0_0_1_0());
									}
									lv_createExtensionInfo_35_0=ruleCreateExtensionInfo
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getMemberRule());
										}
										set(
											$current,
											"createExtensionInfo",
											lv_createExtensionInfo_35_0,
											"org.eclipse.xtend.core.Xtend.CreateExtensionInfo");
										afterParserOrEnumRuleCall();
									}
								)
							)
							(
								(
									{
										newCompositeNode(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_1_5_0_0_2_0());
									}
									lv_name_36_0=ruleValidID
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getMemberRule());
										}
										set(
											$current,
											"name",
											lv_name_36_0,
											"org.eclipse.xtend.core.Xtend.ValidID");
										afterParserOrEnumRuleCall();
									}
								)
							)
							otherlv_37='('
							{
								newLeafNode(otherlv_37, grammarAccess.getMemberAccess().getLeftParenthesisKeyword_2_1_5_0_0_3());
							}
						)
					)
					    |
					(
						((
							(
								(
									ruleTypeReferenceWithTypeArgs
								)
							)
							(
								(
									ruleFunctionID
								)
							)
							'('
						)
						)=>
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getMemberAccess().getReturnTypeTypeReferenceWithTypeArgsParserRuleCall_2_1_5_1_0_0_0());
									}
									lv_returnType_38_0=ruleTypeReferenceWithTypeArgs
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getMemberRule());
										}
										set(
											$current,
											"returnType",
											lv_returnType_38_0,
											"org.eclipse.xtend.core.Xtend.TypeReferenceWithTypeArgs");
										afterParserOrEnumRuleCall();
									}
								)
							)
							(
								(
									{
										newCompositeNode(grammarAccess.getMemberAccess().getNameFunctionIDParserRuleCall_2_1_5_1_0_1_0());
									}
									lv_name_39_0=ruleFunctionID
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getMemberRule());
										}
										set(
											$current,
											"name",
											lv_name_39_0,
											"org.eclipse.xtend.core.Xtend.FunctionID");
										afterParserOrEnumRuleCall();
									}
								)
							)
							otherlv_40='('
							{
								newLeafNode(otherlv_40, grammarAccess.getMemberAccess().getLeftParenthesisKeyword_2_1_5_1_0_2());
							}
						)
					)
					    |
					(
						((
							(
								(
									ruleTypeReferenceNoTypeArgs
								)
							)
							(
								(
									ruleFunctionID
								)
							)
							'('
						)
						)=>
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getMemberAccess().getReturnTypeTypeReferenceNoTypeArgsParserRuleCall_2_1_5_2_0_0_0());
									}
									lv_returnType_41_0=ruleTypeReferenceNoTypeArgs
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getMemberRule());
										}
										set(
											$current,
											"returnType",
											lv_returnType_41_0,
											"org.eclipse.xtend.core.Xtend.TypeReferenceNoTypeArgs");
										afterParserOrEnumRuleCall();
									}
								)
							)
							(
								(
									{
										newCompositeNode(grammarAccess.getMemberAccess().getNameFunctionIDParserRuleCall_2_1_5_2_0_1_0());
									}
									lv_name_42_0=ruleFunctionID
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getMemberRule());
										}
										set(
											$current,
											"name",
											lv_name_42_0,
											"org.eclipse.xtend.core.Xtend.FunctionID");
										afterParserOrEnumRuleCall();
									}
								)
							)
							otherlv_43='('
							{
								newLeafNode(otherlv_43, grammarAccess.getMemberAccess().getLeftParenthesisKeyword_2_1_5_2_0_2());
							}
						)
					)
					    |
					(
						((
							(
								(
									ruleCreateExtensionInfo
								)
							)
							(
								(
									ruleValidID
								)
							)
							'('
						)
						)=>
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getMemberAccess().getCreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_3_0_0_0());
									}
									lv_createExtensionInfo_44_0=ruleCreateExtensionInfo
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getMemberRule());
										}
										set(
											$current,
											"createExtensionInfo",
											lv_createExtensionInfo_44_0,
											"org.eclipse.xtend.core.Xtend.CreateExtensionInfo");
										afterParserOrEnumRuleCall();
									}
								)
							)
							(
								(
									{
										newCompositeNode(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_1_5_3_0_1_0());
									}
									lv_name_45_0=ruleValidID
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getMemberRule());
										}
										set(
											$current,
											"name",
											lv_name_45_0,
											"org.eclipse.xtend.core.Xtend.ValidID");
										afterParserOrEnumRuleCall();
									}
								)
							)
							otherlv_46='('
							{
								newLeafNode(otherlv_46, grammarAccess.getMemberAccess().getLeftParenthesisKeyword_2_1_5_3_0_2());
							}
						)
					)
					    |
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getNameFunctionIDParserRuleCall_2_1_5_4_0_0());
								}
								lv_name_47_0=ruleFunctionID
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									set(
										$current,
										"name",
										lv_name_47_0,
										"org.eclipse.xtend.core.Xtend.FunctionID");
									afterParserOrEnumRuleCall();
								}
							)
						)
						otherlv_48='('
						{
							newLeafNode(otherlv_48, grammarAccess.getMemberAccess().getLeftParenthesisKeyword_2_1_5_4_1());
						}
					)
				)
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getMemberAccess().getParametersParameterParserRuleCall_2_1_6_0_0());
							}
							lv_parameters_49_0=ruleParameter
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMemberRule());
								}
								add(
									$current,
									"parameters",
									lv_parameters_49_0,
									"org.eclipse.xtend.core.Xtend.Parameter");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_50=','
						{
							newLeafNode(otherlv_50, grammarAccess.getMemberAccess().getCommaKeyword_2_1_6_1_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getParametersParameterParserRuleCall_2_1_6_1_1_0());
								}
								lv_parameters_51_0=ruleParameter
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									add(
										$current,
										"parameters",
										lv_parameters_51_0,
										"org.eclipse.xtend.core.Xtend.Parameter");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)?
				otherlv_52=')'
				{
					newLeafNode(otherlv_52, grammarAccess.getMemberAccess().getRightParenthesisKeyword_2_1_7());
				}
				(
					otherlv_53='throws'
					{
						newLeafNode(otherlv_53, grammarAccess.getMemberAccess().getThrowsKeyword_2_1_8_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getMemberAccess().getExceptionsJvmTypeReferenceParserRuleCall_2_1_8_1_0());
							}
							lv_exceptions_54_0=ruleJvmTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMemberRule());
								}
								add(
									$current,
									"exceptions",
									lv_exceptions_54_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_55=','
						{
							newLeafNode(otherlv_55, grammarAccess.getMemberAccess().getCommaKeyword_2_1_8_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getExceptionsJvmTypeReferenceParserRuleCall_2_1_8_2_1_0());
								}
								lv_exceptions_56_0=ruleJvmTypeReference
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									add(
										$current,
										"exceptions",
										lv_exceptions_56_0,
										"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)?
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getMemberAccess().getExpressionXBlockExpressionParserRuleCall_2_1_9_0_0());
							}
							lv_expression_57_0=ruleXBlockExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMemberRule());
								}
								set(
									$current,
									"expression",
									lv_expression_57_0,
									"org.eclipse.xtext.xbase.Xbase.XBlockExpression");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMemberAccess().getExpressionRichStringParserRuleCall_2_1_9_1_0());
							}
							lv_expression_58_0=ruleRichString
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMemberRule());
								}
								set(
									$current,
									"expression",
									lv_expression_58_0,
									"org.eclipse.xtend.core.Xtend.RichString");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					otherlv_59=';'
					{
						newLeafNode(otherlv_59, grammarAccess.getMemberAccess().getSemicolonKeyword_2_1_9_2());
					}
				)?
			)
			    |
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getMemberAccess().getXtendConstructorAnnotationInfoAction_2_2_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_2_1_0());
						}
						lv_modifiers_61_0=ruleCommonModifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMemberRule());
							}
							add(
								$current,
								"modifiers",
								lv_modifiers_61_0,
								"org.eclipse.xtend.core.Xtend.CommonModifier");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_62='new'
				{
					newLeafNode(otherlv_62, grammarAccess.getMemberAccess().getNewKeyword_2_2_2());
				}
				(
					otherlv_63='<'
					{
						newLeafNode(otherlv_63, grammarAccess.getMemberAccess().getLessThanSignKeyword_2_2_3_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_2_3_1_0());
							}
							lv_typeParameters_64_0=ruleJvmTypeParameter
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMemberRule());
								}
								add(
									$current,
									"typeParameters",
									lv_typeParameters_64_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_65=','
						{
							newLeafNode(otherlv_65, grammarAccess.getMemberAccess().getCommaKeyword_2_2_3_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_2_3_2_1_0());
								}
								lv_typeParameters_66_0=ruleJvmTypeParameter
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									add(
										$current,
										"typeParameters",
										lv_typeParameters_66_0,
										"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
					otherlv_67='>'
					{
						newLeafNode(otherlv_67, grammarAccess.getMemberAccess().getGreaterThanSignKeyword_2_2_3_3());
					}
				)?
				otherlv_68='('
				{
					newLeafNode(otherlv_68, grammarAccess.getMemberAccess().getLeftParenthesisKeyword_2_2_4());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getMemberAccess().getParametersParameterParserRuleCall_2_2_5_0_0());
							}
							lv_parameters_69_0=ruleParameter
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMemberRule());
								}
								add(
									$current,
									"parameters",
									lv_parameters_69_0,
									"org.eclipse.xtend.core.Xtend.Parameter");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_70=','
						{
							newLeafNode(otherlv_70, grammarAccess.getMemberAccess().getCommaKeyword_2_2_5_1_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getParametersParameterParserRuleCall_2_2_5_1_1_0());
								}
								lv_parameters_71_0=ruleParameter
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									add(
										$current,
										"parameters",
										lv_parameters_71_0,
										"org.eclipse.xtend.core.Xtend.Parameter");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)?
				otherlv_72=')'
				{
					newLeafNode(otherlv_72, grammarAccess.getMemberAccess().getRightParenthesisKeyword_2_2_6());
				}
				(
					otherlv_73='throws'
					{
						newLeafNode(otherlv_73, grammarAccess.getMemberAccess().getThrowsKeyword_2_2_7_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getMemberAccess().getExceptionsJvmTypeReferenceParserRuleCall_2_2_7_1_0());
							}
							lv_exceptions_74_0=ruleJvmTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMemberRule());
								}
								add(
									$current,
									"exceptions",
									lv_exceptions_74_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_75=','
						{
							newLeafNode(otherlv_75, grammarAccess.getMemberAccess().getCommaKeyword_2_2_7_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getExceptionsJvmTypeReferenceParserRuleCall_2_2_7_2_1_0());
								}
								lv_exceptions_76_0=ruleJvmTypeReference
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									add(
										$current,
										"exceptions",
										lv_exceptions_76_0,
										"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)?
				(
					(
						{
							newCompositeNode(grammarAccess.getMemberAccess().getExpressionXBlockExpressionParserRuleCall_2_2_8_0());
						}
						lv_expression_77_0=ruleXBlockExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMemberRule());
							}
							set(
								$current,
								"expression",
								lv_expression_77_0,
								"org.eclipse.xtext.xbase.Xbase.XBlockExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getMemberAccess().getXtendClassAnnotationInfoAction_2_3_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_3_1_0());
						}
						lv_modifiers_79_0=ruleCommonModifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMemberRule());
							}
							add(
								$current,
								"modifiers",
								lv_modifiers_79_0,
								"org.eclipse.xtend.core.Xtend.CommonModifier");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_80='class'
				{
					newLeafNode(otherlv_80, grammarAccess.getMemberAccess().getClassKeyword_2_3_2());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_3_3_0());
						}
						lv_name_81_0=ruleValidID
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMemberRule());
							}
							set(
								$current,
								"name",
								lv_name_81_0,
								"org.eclipse.xtend.core.Xtend.ValidID");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_82='<'
					{
						newLeafNode(otherlv_82, grammarAccess.getMemberAccess().getLessThanSignKeyword_2_3_4_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_3_4_1_0());
							}
							lv_typeParameters_83_0=ruleJvmTypeParameter
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMemberRule());
								}
								add(
									$current,
									"typeParameters",
									lv_typeParameters_83_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_84=','
						{
							newLeafNode(otherlv_84, grammarAccess.getMemberAccess().getCommaKeyword_2_3_4_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_3_4_2_1_0());
								}
								lv_typeParameters_85_0=ruleJvmTypeParameter
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									add(
										$current,
										"typeParameters",
										lv_typeParameters_85_0,
										"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
					otherlv_86='>'
					{
						newLeafNode(otherlv_86, grammarAccess.getMemberAccess().getGreaterThanSignKeyword_2_3_4_3());
					}
				)?
				(
					otherlv_87='extends'
					{
						newLeafNode(otherlv_87, grammarAccess.getMemberAccess().getExtendsKeyword_2_3_5_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getMemberAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_3_5_1_0());
							}
							lv_extends_88_0=ruleJvmParameterizedTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMemberRule());
								}
								set(
									$current,
									"extends",
									lv_extends_88_0,
									"org.eclipse.xtext.xbase.Xtype.JvmParameterizedTypeReference");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)?
				(
					otherlv_89='implements'
					{
						newLeafNode(otherlv_89, grammarAccess.getMemberAccess().getImplementsKeyword_2_3_6_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getMemberAccess().getImplementsJvmParameterizedTypeReferenceParserRuleCall_2_3_6_1_0());
							}
							lv_implements_90_0=ruleJvmParameterizedTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMemberRule());
								}
								add(
									$current,
									"implements",
									lv_implements_90_0,
									"org.eclipse.xtext.xbase.Xtype.JvmParameterizedTypeReference");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_91=','
						{
							newLeafNode(otherlv_91, grammarAccess.getMemberAccess().getCommaKeyword_2_3_6_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getImplementsJvmParameterizedTypeReferenceParserRuleCall_2_3_6_2_1_0());
								}
								lv_implements_92_0=ruleJvmParameterizedTypeReference
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									add(
										$current,
										"implements",
										lv_implements_92_0,
										"org.eclipse.xtext.xbase.Xtype.JvmParameterizedTypeReference");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)?
				otherlv_93='{'
				{
					newLeafNode(otherlv_93, grammarAccess.getMemberAccess().getLeftCurlyBracketKeyword_2_3_7());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMemberAccess().getMembersMemberParserRuleCall_2_3_8_0());
						}
						lv_members_94_0=ruleMember
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMemberRule());
							}
							add(
								$current,
								"members",
								lv_members_94_0,
								"org.eclipse.xtend.core.Xtend.Member");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_95='}'
				{
					newLeafNode(otherlv_95, grammarAccess.getMemberAccess().getRightCurlyBracketKeyword_2_3_9());
				}
			)
			    |
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getMemberAccess().getXtendInterfaceAnnotationInfoAction_2_4_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_4_1_0());
						}
						lv_modifiers_97_0=ruleCommonModifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMemberRule());
							}
							add(
								$current,
								"modifiers",
								lv_modifiers_97_0,
								"org.eclipse.xtend.core.Xtend.CommonModifier");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_98='interface'
				{
					newLeafNode(otherlv_98, grammarAccess.getMemberAccess().getInterfaceKeyword_2_4_2());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_4_3_0());
						}
						lv_name_99_0=ruleValidID
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMemberRule());
							}
							set(
								$current,
								"name",
								lv_name_99_0,
								"org.eclipse.xtend.core.Xtend.ValidID");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_100='<'
					{
						newLeafNode(otherlv_100, grammarAccess.getMemberAccess().getLessThanSignKeyword_2_4_4_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_4_4_1_0());
							}
							lv_typeParameters_101_0=ruleJvmTypeParameter
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMemberRule());
								}
								add(
									$current,
									"typeParameters",
									lv_typeParameters_101_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_102=','
						{
							newLeafNode(otherlv_102, grammarAccess.getMemberAccess().getCommaKeyword_2_4_4_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_4_4_2_1_0());
								}
								lv_typeParameters_103_0=ruleJvmTypeParameter
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									add(
										$current,
										"typeParameters",
										lv_typeParameters_103_0,
										"org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
					otherlv_104='>'
					{
						newLeafNode(otherlv_104, grammarAccess.getMemberAccess().getGreaterThanSignKeyword_2_4_4_3());
					}
				)?
				(
					otherlv_105='extends'
					{
						newLeafNode(otherlv_105, grammarAccess.getMemberAccess().getExtendsKeyword_2_4_5_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getMemberAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_4_5_1_0());
							}
							lv_extends_106_0=ruleJvmParameterizedTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMemberRule());
								}
								add(
									$current,
									"extends",
									lv_extends_106_0,
									"org.eclipse.xtext.xbase.Xtype.JvmParameterizedTypeReference");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_107=','
						{
							newLeafNode(otherlv_107, grammarAccess.getMemberAccess().getCommaKeyword_2_4_5_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_4_5_2_1_0());
								}
								lv_extends_108_0=ruleJvmParameterizedTypeReference
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									add(
										$current,
										"extends",
										lv_extends_108_0,
										"org.eclipse.xtext.xbase.Xtype.JvmParameterizedTypeReference");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)?
				otherlv_109='{'
				{
					newLeafNode(otherlv_109, grammarAccess.getMemberAccess().getLeftCurlyBracketKeyword_2_4_6());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMemberAccess().getMembersMemberParserRuleCall_2_4_7_0());
						}
						lv_members_110_0=ruleMember
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMemberRule());
							}
							add(
								$current,
								"members",
								lv_members_110_0,
								"org.eclipse.xtend.core.Xtend.Member");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_111='}'
				{
					newLeafNode(otherlv_111, grammarAccess.getMemberAccess().getRightCurlyBracketKeyword_2_4_8());
				}
			)
			    |
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getMemberAccess().getXtendEnumAnnotationInfoAction_2_5_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_5_1_0());
						}
						lv_modifiers_113_0=ruleCommonModifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMemberRule());
							}
							add(
								$current,
								"modifiers",
								lv_modifiers_113_0,
								"org.eclipse.xtend.core.Xtend.CommonModifier");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_114='enum'
				{
					newLeafNode(otherlv_114, grammarAccess.getMemberAccess().getEnumKeyword_2_5_2());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_5_3_0());
						}
						lv_name_115_0=ruleValidID
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMemberRule());
							}
							set(
								$current,
								"name",
								lv_name_115_0,
								"org.eclipse.xtend.core.Xtend.ValidID");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_116='{'
				{
					newLeafNode(otherlv_116, grammarAccess.getMemberAccess().getLeftCurlyBracketKeyword_2_5_4());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getMemberAccess().getMembersXtendEnumLiteralParserRuleCall_2_5_5_0_0());
							}
							lv_members_117_0=ruleXtendEnumLiteral
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMemberRule());
								}
								add(
									$current,
									"members",
									lv_members_117_0,
									"org.eclipse.xtend.core.Xtend.XtendEnumLiteral");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_118=','
						{
							newLeafNode(otherlv_118, grammarAccess.getMemberAccess().getCommaKeyword_2_5_5_1_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getMemberAccess().getMembersXtendEnumLiteralParserRuleCall_2_5_5_1_1_0());
								}
								lv_members_119_0=ruleXtendEnumLiteral
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getMemberRule());
									}
									add(
										$current,
										"members",
										lv_members_119_0,
										"org.eclipse.xtend.core.Xtend.XtendEnumLiteral");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)?
				(
					otherlv_120=';'
					{
						newLeafNode(otherlv_120, grammarAccess.getMemberAccess().getSemicolonKeyword_2_5_6());
					}
				)?
				otherlv_121='}'
				{
					newLeafNode(otherlv_121, grammarAccess.getMemberAccess().getRightCurlyBracketKeyword_2_5_7());
				}
			)
			    |
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getMemberAccess().getXtendAnnotationTypeAnnotationInfoAction_2_6_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_6_1_0());
						}
						lv_modifiers_123_0=ruleCommonModifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMemberRule());
							}
							add(
								$current,
								"modifiers",
								lv_modifiers_123_0,
								"org.eclipse.xtend.core.Xtend.CommonModifier");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_124='annotation'
				{
					newLeafNode(otherlv_124, grammarAccess.getMemberAccess().getAnnotationKeyword_2_6_2());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_6_3_0());
						}
						lv_name_125_0=ruleValidID
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMemberRule());
							}
							set(
								$current,
								"name",
								lv_name_125_0,
								"org.eclipse.xtend.core.Xtend.ValidID");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_126='{'
				{
					newLeafNode(otherlv_126, grammarAccess.getMemberAccess().getLeftCurlyBracketKeyword_2_6_4());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMemberAccess().getMembersAnnotationFieldParserRuleCall_2_6_5_0());
						}
						lv_members_127_0=ruleAnnotationField
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMemberRule());
							}
							add(
								$current,
								"members",
								lv_members_127_0,
								"org.eclipse.xtend.core.Xtend.AnnotationField");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_128='}'
				{
					newLeafNode(otherlv_128, grammarAccess.getMemberAccess().getRightCurlyBracketKeyword_2_6_6());
				}
			)
		)
	)
;

// Entry rule entryRuleTypeReferenceNoTypeArgs
entryRuleTypeReferenceNoTypeArgs returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeReferenceNoTypeArgsRule()); }
	iv_ruleTypeReferenceNoTypeArgs=ruleTypeReferenceNoTypeArgs
	{ $current=$iv_ruleTypeReferenceNoTypeArgs.current; }
	EOF;

// Rule TypeReferenceNoTypeArgs
ruleTypeReferenceNoTypeArgs returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getTypeReferenceNoTypeArgsRule());
				}
			}
			{
				newCompositeNode(grammarAccess.getTypeReferenceNoTypeArgsAccess().getTypeJvmTypeCrossReference_0());
			}
			ruleQualifiedName
			{
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleTypeReferenceWithTypeArgs
entryRuleTypeReferenceWithTypeArgs returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeReferenceWithTypeArgsRule()); }
	iv_ruleTypeReferenceWithTypeArgs=ruleTypeReferenceWithTypeArgs
	{ $current=$iv_ruleTypeReferenceWithTypeArgs.current; }
	EOF;

// Rule TypeReferenceWithTypeArgs
ruleTypeReferenceWithTypeArgs returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getTypeReferenceWithTypeArgsAccess().getParameterizedTypeReferenceWithTypeArgsParserRuleCall_0_0());
			}
			this_ParameterizedTypeReferenceWithTypeArgs_0=ruleParameterizedTypeReferenceWithTypeArgs
			{
				$current = $this_ParameterizedTypeReferenceWithTypeArgs_0.current;
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
								grammarAccess.getTypeReferenceWithTypeArgsAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(),
								$current);
						}
					)
					{
						newCompositeNode(grammarAccess.getTypeReferenceWithTypeArgsAccess().getArrayBracketsParserRuleCall_0_1_0_1());
					}
					ruleArrayBrackets
					{
						afterParserOrEnumRuleCall();
					}
				)
			)*
		)
		    |
		(
			{
				newCompositeNode(grammarAccess.getTypeReferenceWithTypeArgsAccess().getTypeReferenceNoTypeArgsParserRuleCall_1_0());
			}
			this_TypeReferenceNoTypeArgs_3=ruleTypeReferenceNoTypeArgs
			{
				$current = $this_TypeReferenceNoTypeArgs_3.current;
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
								grammarAccess.getTypeReferenceWithTypeArgsAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_1_1_0_0(),
								$current);
						}
					)
					{
						newCompositeNode(grammarAccess.getTypeReferenceWithTypeArgsAccess().getArrayBracketsParserRuleCall_1_1_0_1());
					}
					ruleArrayBrackets
					{
						afterParserOrEnumRuleCall();
					}
				)
			)+
		)
		    |
		{
			newCompositeNode(grammarAccess.getTypeReferenceWithTypeArgsAccess().getXFunctionTypeRefParserRuleCall_2());
		}
		this_XFunctionTypeRef_6=ruleXFunctionTypeRef
		{
			$current = $this_XFunctionTypeRef_6.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleParameterizedTypeReferenceWithTypeArgs
entryRuleParameterizedTypeReferenceWithTypeArgs returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getParameterizedTypeReferenceWithTypeArgsRule()); }
	iv_ruleParameterizedTypeReferenceWithTypeArgs=ruleParameterizedTypeReferenceWithTypeArgs
	{ $current=$iv_ruleParameterizedTypeReferenceWithTypeArgs.current; }
	EOF;

// Rule ParameterizedTypeReferenceWithTypeArgs
ruleParameterizedTypeReferenceWithTypeArgs returns [EObject current=null]
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
						$current = createModelElement(grammarAccess.getParameterizedTypeReferenceWithTypeArgsRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getTypeJvmTypeCrossReference_0_0());
				}
				ruleQualifiedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1='<'
			{
				newLeafNode(otherlv_1, grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getLessThanSignKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0());
					}
					lv_arguments_2_0=ruleJvmArgumentTypeReference
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getParameterizedTypeReferenceWithTypeArgsRule());
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
					newLeafNode(otherlv_3, grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getCommaKeyword_1_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0());
						}
						lv_arguments_4_0=ruleJvmArgumentTypeReference
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getParameterizedTypeReferenceWithTypeArgsRule());
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
				newLeafNode(otherlv_5, grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGreaterThanSignKeyword_1_3());
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
									grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0(),
									$current);
							}
						)
						otherlv_7='.'
						{
							newLeafNode(otherlv_7, grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getFullStopKeyword_1_4_0_0_1());
						}
					)
				)
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getParameterizedTypeReferenceWithTypeArgsRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getTypeJvmTypeCrossReference_1_4_1_0());
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
							newLeafNode(otherlv_9, grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getLessThanSignKeyword_1_4_2_0());
						}
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0());
							}
							lv_arguments_10_0=ruleJvmArgumentTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getParameterizedTypeReferenceWithTypeArgsRule());
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
							newLeafNode(otherlv_11, grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getCommaKeyword_1_4_2_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0());
								}
								lv_arguments_12_0=ruleJvmArgumentTypeReference
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getParameterizedTypeReferenceWithTypeArgsRule());
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
						newLeafNode(otherlv_13, grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGreaterThanSignKeyword_1_4_2_3());
					}
				)?
			)*
		)
	)
;

// Entry rule entryRuleFunctionID
entryRuleFunctionID returns [String current=null]:
	{ newCompositeNode(grammarAccess.getFunctionIDRule()); }
	iv_ruleFunctionID=ruleFunctionID
	{ $current=$iv_ruleFunctionID.current.getText(); }
	EOF;

// Rule FunctionID
ruleFunctionID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getFunctionIDAccess().getValidIDParserRuleCall_0());
		}
		this_ValidID_0=ruleValidID
		{
			$current.merge(this_ValidID_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getFunctionIDAccess().getOperatorsParserRuleCall_1());
		}
		this_Operators_1=ruleOperators
		{
			$current.merge(this_Operators_1);
		}
		{
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleOperators
entryRuleOperators returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOperatorsRule()); }
	iv_ruleOperators=ruleOperators
	{ $current=$iv_ruleOperators.current.getText(); }
	EOF;

// Rule Operators
ruleOperators returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getOperatorsAccess().getOpMultiAssignParserRuleCall_0());
		}
		this_OpMultiAssign_0=ruleOpMultiAssign
		{
			$current.merge(this_OpMultiAssign_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getOperatorsAccess().getOpOrParserRuleCall_1());
		}
		this_OpOr_1=ruleOpOr
		{
			$current.merge(this_OpOr_1);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getOperatorsAccess().getOpAndParserRuleCall_2());
		}
		this_OpAnd_2=ruleOpAnd
		{
			$current.merge(this_OpAnd_2);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getOperatorsAccess().getOpEqualityParserRuleCall_3());
		}
		this_OpEquality_3=ruleOpEquality
		{
			$current.merge(this_OpEquality_3);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getOperatorsAccess().getOpCompareParserRuleCall_4());
		}
		this_OpCompare_4=ruleOpCompare
		{
			$current.merge(this_OpCompare_4);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getOperatorsAccess().getOpOtherParserRuleCall_5());
		}
		this_OpOther_5=ruleOpOther
		{
			$current.merge(this_OpOther_5);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getOperatorsAccess().getOpMultiParserRuleCall_6());
		}
		this_OpMulti_6=ruleOpMulti
		{
			$current.merge(this_OpMulti_6);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getOperatorsAccess().getOpUnaryParserRuleCall_7());
		}
		this_OpUnary_7=ruleOpUnary
		{
			$current.merge(this_OpUnary_7);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getOperatorsAccess().getOpPostfixParserRuleCall_8());
		}
		this_OpPostfix_8=ruleOpPostfix
		{
			$current.merge(this_OpPostfix_8);
		}
		{
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleXtendEnumLiteral
entryRuleXtendEnumLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXtendEnumLiteralRule()); }
	iv_ruleXtendEnumLiteral=ruleXtendEnumLiteral
	{ $current=$iv_ruleXtendEnumLiteral.current; }
	EOF;

// Rule XtendEnumLiteral
ruleXtendEnumLiteral returns [EObject current=null]
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
					newCompositeNode(grammarAccess.getXtendEnumLiteralAccess().getAnnotationsXAnnotationParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleXAnnotation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXtendEnumLiteralRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotation");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getXtendEnumLiteralAccess().getNameValidIDParserRuleCall_1_0());
				}
				lv_name_1_0=ruleValidID
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXtendEnumLiteralRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtend.core.Xtend.ValidID");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleCommonModifier
entryRuleCommonModifier returns [String current=null]:
	{ newCompositeNode(grammarAccess.getCommonModifierRule()); }
	iv_ruleCommonModifier=ruleCommonModifier
	{ $current=$iv_ruleCommonModifier.current.getText(); }
	EOF;

// Rule CommonModifier
ruleCommonModifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='public'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getCommonModifierAccess().getPublicKeyword_0());
		}
		    |
		kw='private'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getCommonModifierAccess().getPrivateKeyword_1());
		}
		    |
		kw='protected'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getCommonModifierAccess().getProtectedKeyword_2());
		}
		    |
		kw='package'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getCommonModifierAccess().getPackageKeyword_3());
		}
		    |
		kw='abstract'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getCommonModifierAccess().getAbstractKeyword_4());
		}
		    |
		kw='static'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getCommonModifierAccess().getStaticKeyword_5());
		}
		    |
		kw='dispatch'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getCommonModifierAccess().getDispatchKeyword_6());
		}
		    |
		kw='final'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getCommonModifierAccess().getFinalKeyword_7());
		}
		    |
		kw='strictfp'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getCommonModifierAccess().getStrictfpKeyword_8());
		}
		    |
		kw='native'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getCommonModifierAccess().getNativeKeyword_9());
		}
		    |
		kw='volatile'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getCommonModifierAccess().getVolatileKeyword_10());
		}
		    |
		kw='synchronized'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getCommonModifierAccess().getSynchronizedKeyword_11());
		}
		    |
		kw='transient'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getCommonModifierAccess().getTransientKeyword_12());
		}
	)
;

// Entry rule entryRuleFieldModifier
entryRuleFieldModifier returns [String current=null]:
	{ newCompositeNode(grammarAccess.getFieldModifierRule()); }
	iv_ruleFieldModifier=ruleFieldModifier
	{ $current=$iv_ruleFieldModifier.current.getText(); }
	EOF;

// Rule FieldModifier
ruleFieldModifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='val'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getFieldModifierAccess().getValKeyword_0());
		}
		    |
		kw='var'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getFieldModifierAccess().getVarKeyword_1());
		}
	)
;

// Entry rule entryRuleMethodModifier
entryRuleMethodModifier returns [String current=null]:
	{ newCompositeNode(grammarAccess.getMethodModifierRule()); }
	iv_ruleMethodModifier=ruleMethodModifier
	{ $current=$iv_ruleMethodModifier.current.getText(); }
	EOF;

// Rule MethodModifier
ruleMethodModifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='def'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getMethodModifierAccess().getDefKeyword_0());
		}
		    |
		kw='override'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getMethodModifierAccess().getOverrideKeyword_1());
		}
	)
;

// Entry rule entryRuleCreateExtensionInfo
entryRuleCreateExtensionInfo returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCreateExtensionInfoRule()); }
	iv_ruleCreateExtensionInfo=ruleCreateExtensionInfo
	{ $current=$iv_ruleCreateExtensionInfo.current; }
	EOF;

// Rule CreateExtensionInfo
ruleCreateExtensionInfo returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='create'
		{
			newLeafNode(otherlv_0, grammarAccess.getCreateExtensionInfoAccess().getCreateKeyword_0());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getCreateExtensionInfoAccess().getNameValidIDParserRuleCall_1_0_0());
					}
					lv_name_1_0=ruleValidID
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getCreateExtensionInfoRule());
						}
						set(
							$current,
							"name",
							lv_name_1_0,
							"org.eclipse.xtend.core.Xtend.ValidID");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_2=':'
			{
				newLeafNode(otherlv_2, grammarAccess.getCreateExtensionInfoAccess().getColonKeyword_1_1());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getCreateExtensionInfoAccess().getCreateExpressionXExpressionParserRuleCall_2_0());
				}
				lv_createExpression_3_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCreateExtensionInfoRule());
					}
					set(
						$current,
						"createExpression",
						lv_createExpression_3_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
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
	(
		this_ID_0=RULE_ID
		{
			$current.merge(this_ID_0);
		}
		{
			newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0());
		}
		    |
		kw='create'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getValidIDAccess().getCreateKeyword_1());
		}
		    |
		kw='annotation'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getValidIDAccess().getAnnotationKeyword_2());
		}
		    |
		kw='AFTER'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getValidIDAccess().getAFTERKeyword_3());
		}
		    |
		kw='BEFORE'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getValidIDAccess().getBEFOREKeyword_4());
		}
		    |
		kw='SEPARATOR'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getValidIDAccess().getSEPARATORKeyword_5());
		}
	)
;

// Entry rule entryRuleFeatureCallID
entryRuleFeatureCallID returns [String current=null]:
	{ newCompositeNode(grammarAccess.getFeatureCallIDRule()); }
	iv_ruleFeatureCallID=ruleFeatureCallID
	{ $current=$iv_ruleFeatureCallID.current.getText(); }
	EOF;

// Rule FeatureCallID
ruleFeatureCallID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getFeatureCallIDAccess().getInnerVarIDParserRuleCall_0());
		}
		this_InnerVarID_0=ruleInnerVarID
		{
			$current.merge(this_InnerVarID_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		kw='extension'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getExtensionKeyword_1());
		}
	)
;

// Entry rule entryRuleInnerVarID
entryRuleInnerVarID returns [String current=null]:
	{ newCompositeNode(grammarAccess.getInnerVarIDRule()); }
	iv_ruleInnerVarID=ruleInnerVarID
	{ $current=$iv_ruleInnerVarID.current.getText(); }
	EOF;

// Rule InnerVarID
ruleInnerVarID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
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
			newLeafNode(this_ID_0, grammarAccess.getInnerVarIDAccess().getIDTerminalRuleCall_0());
		}
		    |
		kw='abstract'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getAbstractKeyword_1());
		}
		    |
		kw='annotation'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getAnnotationKeyword_2());
		}
		    |
		kw='class'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getClassKeyword_3());
		}
		    |
		kw='create'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getCreateKeyword_4());
		}
		    |
		kw='def'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getDefKeyword_5());
		}
		    |
		kw='dispatch'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getDispatchKeyword_6());
		}
		    |
		kw='enum'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getEnumKeyword_7());
		}
		    |
		kw='extends'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getExtendsKeyword_8());
		}
		    |
		kw='final'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getFinalKeyword_9());
		}
		    |
		kw='implements'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getImplementsKeyword_10());
		}
		    |
		kw='import'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getImportKeyword_11());
		}
		    |
		kw='interface'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getInterfaceKeyword_12());
		}
		    |
		kw='override'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getOverrideKeyword_13());
		}
		    |
		kw='package'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getPackageKeyword_14());
		}
		    |
		kw='public'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getPublicKeyword_15());
		}
		    |
		kw='private'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getPrivateKeyword_16());
		}
		    |
		kw='protected'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getProtectedKeyword_17());
		}
		    |
		kw='static'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getStaticKeyword_18());
		}
		    |
		kw='throws'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getThrowsKeyword_19());
		}
		    |
		kw='strictfp'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getStrictfpKeyword_20());
		}
		    |
		kw='native'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getNativeKeyword_21());
		}
		    |
		kw='volatile'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getVolatileKeyword_22());
		}
		    |
		kw='synchronized'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getSynchronizedKeyword_23());
		}
		    |
		kw='transient'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getTransientKeyword_24());
		}
		    |
		kw='AFTER'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getAFTERKeyword_25());
		}
		    |
		kw='BEFORE'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getBEFOREKeyword_26());
		}
		    |
		kw='SEPARATOR'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInnerVarIDAccess().getSEPARATORKeyword_27());
		}
	)
;

// Entry rule entryRuleParameter
entryRuleParameter returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getParameterRule()); }
	iv_ruleParameter=ruleParameter
	{ $current=$iv_ruleParameter.current; }
	EOF;

// Rule Parameter
ruleParameter returns [EObject current=null]
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
					newCompositeNode(grammarAccess.getParameterAccess().getAnnotationsXAnnotationParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleXAnnotation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getParameterRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotation");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				(
					lv_extension_1_0='extension'
					{
						newLeafNode(lv_extension_1_0, grammarAccess.getParameterAccess().getExtensionExtensionKeyword_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getParameterRule());
						}
						setWithLastConsumed($current, "extension", lv_extension_1_0 != null, "extension");
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getParameterAccess().getAnnotationsXAnnotationParserRuleCall_1_1_0());
					}
					lv_annotations_2_0=ruleXAnnotation
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getParameterRule());
						}
						add(
							$current,
							"annotations",
							lv_annotations_2_0,
							"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotation");
						afterParserOrEnumRuleCall();
					}
				)
			)*
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_2_0());
				}
				lv_parameterType_3_0=ruleJvmTypeReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getParameterRule());
					}
					set(
						$current,
						"parameterType",
						lv_parameterType_3_0,
						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				lv_varArg_4_0='...'
				{
					newLeafNode(lv_varArg_4_0, grammarAccess.getParameterAccess().getVarArgFullStopFullStopFullStopKeyword_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getParameterRule());
					}
					setWithLastConsumed($current, "varArg", lv_varArg_4_0 != null, "...");
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getParameterAccess().getNameValidIDParserRuleCall_4_0());
				}
				lv_name_5_0=ruleValidID
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getParameterRule());
					}
					set(
						$current,
						"name",
						lv_name_5_0,
						"org.eclipse.xtend.core.Xtend.ValidID");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleXAssignment
entryRuleXAssignment returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXAssignmentRule()); }
	iv_ruleXAssignment=ruleXAssignment
	{ $current=$iv_ruleXAssignment.current; }
	EOF;

// Rule XAssignment
ruleXAssignment returns [EObject current=null]
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
					$current = forceCreateModelElement(
						grammarAccess.getXAssignmentAccess().getXAssignmentAction_0_0(),
						$current);
				}
			)
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getXAssignmentRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0());
					}
					ruleFeatureCallID
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			{
				newCompositeNode(grammarAccess.getXAssignmentAccess().getOpSingleAssignParserRuleCall_0_2());
			}
			ruleOpSingleAssign
			{
				afterParserOrEnumRuleCall();
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_3_0());
					}
					lv_value_3_0=ruleXAssignment
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXAssignmentRule());
						}
						set(
							$current,
							"value",
							lv_value_3_0,
							"org.eclipse.xtend.core.Xtend.XAssignment");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		    |
		(
			{
				newCompositeNode(grammarAccess.getXAssignmentAccess().getXConditionalExpressionParserRuleCall_1_0());
			}
			this_XConditionalExpression_4=ruleXConditionalExpression
			{
				$current = $this_XConditionalExpression_4.current;
				afterParserOrEnumRuleCall();
			}
			(
				(
					((
						(
						)
						(
							(
								ruleOpMultiAssign
							)
						)
					)
					)=>
					(
						(
							{
								$current = forceCreateModelElementAndSet(
									grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
									$current);
							}
						)
						(
							(
								{
									if ($current==null) {
										$current = createModelElement(grammarAccess.getXAssignmentRule());
									}
								}
								{
									newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0());
								}
								ruleOpMultiAssign
								{
									afterParserOrEnumRuleCall();
								}
							)
						)
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_1_1_0());
						}
						lv_rightOperand_7_0=ruleXAssignment
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXAssignmentRule());
							}
							set(
								$current,
								"rightOperand",
								lv_rightOperand_7_0,
								"org.eclipse.xtend.core.Xtend.XAssignment");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)?
		)
	)
;

// Entry rule entryRuleXConditionalExpression
entryRuleXConditionalExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXConditionalExpressionRule()); }
	iv_ruleXConditionalExpression=ruleXConditionalExpression
	{ $current=$iv_ruleXConditionalExpression.current; }
	EOF;

// Rule XConditionalExpression
ruleXConditionalExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getXConditionalExpressionAccess().getXOrExpressionParserRuleCall_0());
		}
		this_XOrExpression_0=ruleXOrExpression
		{
			$current = $this_XOrExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				('?')=>
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getXConditionalExpressionAccess().getXIfExpressionIfAction_1_0_0_0(),
								$current);
						}
					)
					(
						(
							lv_conditionalExpression_2_0='?'
							{
								newLeafNode(lv_conditionalExpression_2_0, grammarAccess.getXConditionalExpressionAccess().getConditionalExpressionQuestionMarkKeyword_1_0_0_1_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getXConditionalExpressionRule());
								}
								setWithLastConsumed($current, "conditionalExpression", lv_conditionalExpression_2_0 != null, "?");
							}
						)
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getXConditionalExpressionAccess().getThenXExpressionParserRuleCall_1_1_0());
					}
					lv_then_3_0=ruleXExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXConditionalExpressionRule());
						}
						set(
							$current,
							"then",
							lv_then_3_0,
							"org.eclipse.xtext.xbase.Xbase.XExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					(':')=>
					otherlv_4=':'
					{
						newLeafNode(otherlv_4, grammarAccess.getXConditionalExpressionAccess().getColonKeyword_1_2_0());
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getXConditionalExpressionAccess().getElseXExpressionParserRuleCall_1_2_1_0());
						}
						lv_else_5_0=ruleXExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXConditionalExpressionRule());
							}
							set(
								$current,
								"else",
								lv_else_5_0,
								"org.eclipse.xtext.xbase.Xbase.XExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)?
		)?
	)
;

// Entry rule entryRuleXTryCatchFinallyExpression
entryRuleXTryCatchFinallyExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule()); }
	iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression
	{ $current=$iv_ruleXTryCatchFinallyExpression.current; }
	EOF;

// Rule XTryCatchFinallyExpression
ruleXTryCatchFinallyExpression returns [EObject current=null]
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
					grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='try'
		{
			newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
		}
		(
			(
				otherlv_2='('
				{
					newLeafNode(otherlv_2, grammarAccess.getXTryCatchFinallyExpressionAccess().getLeftParenthesisKeyword_2_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getResourcesInitializedVariableDeclarationParserRuleCall_2_0_1_0());
						}
						lv_resources_3_0=ruleInitializedVariableDeclaration
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
							}
							add(
								$current,
								"resources",
								lv_resources_3_0,
								"org.eclipse.xtend.core.Xtend.InitializedVariableDeclaration");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_4=';'
					{
						newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getSemicolonKeyword_2_0_2_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getResourcesInitializedVariableDeclarationParserRuleCall_2_0_2_1_0());
							}
							lv_resources_5_0=ruleInitializedVariableDeclaration
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
								}
								add(
									$current,
									"resources",
									lv_resources_5_0,
									"org.eclipse.xtend.core.Xtend.InitializedVariableDeclaration");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
				(
					otherlv_6=';'
					{
						newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getSemicolonKeyword_2_0_3());
					}
				)?
				otherlv_7=')'
				{
					newLeafNode(otherlv_7, grammarAccess.getXTryCatchFinallyExpressionAccess().getRightParenthesisKeyword_2_0_4());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0_5_0());
						}
						lv_expression_8_0=ruleXExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
							}
							set(
								$current,
								"expression",
								lv_expression_8_0,
								"org.eclipse.xtext.xbase.Xbase.XExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					('catch' | 'finally')=>
					(
						(
							(
								('catch')=>
								(
									{
										newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_2_0_6_0_0_0_0());
									}
									lv_catchClauses_9_0=ruleXCatchClause
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
										}
										add(
											$current,
											"catchClauses",
											lv_catchClauses_9_0,
											"org.eclipse.xtext.xbase.Xbase.XCatchClause");
										afterParserOrEnumRuleCall();
									}
								)
							)+
							(
								(
									('finally')=>
									otherlv_10='finally'
									{
										newLeafNode(otherlv_10, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_0_6_0_0_1_0());
									}
								)
								(
									(
										{
											newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_0_6_0_0_1_1_0());
										}
										lv_finallyExpression_11_0=ruleXExpression
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
											}
											set(
												$current,
												"finallyExpression",
												lv_finallyExpression_11_0,
												"org.eclipse.xtext.xbase.Xbase.XExpression");
											afterParserOrEnumRuleCall();
										}
									)
								)
							)?
						)
						    |
						(
							otherlv_12='finally'
							{
								newLeafNode(otherlv_12, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_0_6_0_1_0());
							}
							(
								(
									{
										newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_0_6_0_1_1_0());
									}
									lv_finallyExpression_13_0=ruleXExpression
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
										}
										set(
											$current,
											"finallyExpression",
											lv_finallyExpression_13_0,
											"org.eclipse.xtext.xbase.Xbase.XExpression");
										afterParserOrEnumRuleCall();
									}
								)
							)
						)
					)
				)?
			)
			    |
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_1_0_0());
						}
						lv_expression_14_0=ruleXExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
							}
							set(
								$current,
								"expression",
								lv_expression_14_0,
								"org.eclipse.xtext.xbase.Xbase.XExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						(
							('catch')=>
							(
								{
									newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_2_1_1_0_0_0());
								}
								lv_catchClauses_15_0=ruleXCatchClause
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
									}
									add(
										$current,
										"catchClauses",
										lv_catchClauses_15_0,
										"org.eclipse.xtext.xbase.Xbase.XCatchClause");
									afterParserOrEnumRuleCall();
								}
							)
						)+
						(
							(
								('finally')=>
								otherlv_16='finally'
								{
									newLeafNode(otherlv_16, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_1_1_0_1_0());
								}
							)
							(
								(
									{
										newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_1_1_0_1_1_0());
									}
									lv_finallyExpression_17_0=ruleXExpression
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
										}
										set(
											$current,
											"finallyExpression",
											lv_finallyExpression_17_0,
											"org.eclipse.xtext.xbase.Xbase.XExpression");
										afterParserOrEnumRuleCall();
									}
								)
							)
						)?
					)
					    |
					(
						otherlv_18='finally'
						{
							newLeafNode(otherlv_18, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_1_1_1_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_1_1_1_1_0());
								}
								lv_finallyExpression_19_0=ruleXExpression
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
									}
									set(
										$current,
										"finallyExpression",
										lv_finallyExpression_19_0,
										"org.eclipse.xtext.xbase.Xbase.XExpression");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)
				)
			)
		)
	)
;

// Entry rule entryRuleXVariableDeclaration
entryRuleXVariableDeclaration returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXVariableDeclarationRule()); }
	iv_ruleXVariableDeclaration=ruleXVariableDeclaration
	{ $current=$iv_ruleXVariableDeclaration.current; }
	EOF;

// Rule XVariableDeclaration
ruleXVariableDeclaration returns [EObject current=null]
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
				ruleVariableModifier[null]
			)
			)=>
			(
				(
					{
						$current = forceCreateModelElement(
							grammarAccess.getXVariableDeclarationAccess().getXtendVariableDeclarationAction_0_0_0(),
							$current);
					}
				)
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getXVariableDeclarationRule());
					}
					newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getVariableModifierParserRuleCall_0_0_1());
				}
				this_VariableModifier_1=ruleVariableModifier[$current]
				{
					$current = $this_VariableModifier_1.current;
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				((
					(
						(
							ruleJvmTypeReference
						)
					)
					(
						(
							ruleInnerVarID
						)
					)
				)
				)=>
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_1_0_0_0_0());
							}
							lv_type_2_0=ruleJvmTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
								}
								set(
									$current,
									"type",
									lv_type_2_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameInnerVarIDParserRuleCall_1_0_0_1_0());
							}
							lv_name_3_0=ruleInnerVarID
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
								}
								set(
									$current,
									"name",
									lv_name_3_0,
									"org.eclipse.xtend.core.Xtend.InnerVarID");
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
						newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameInnerVarIDParserRuleCall_1_1_0());
					}
					lv_name_4_0=ruleInnerVarID
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
						}
						set(
							$current,
							"name",
							lv_name_4_0,
							"org.eclipse.xtend.core.Xtend.InnerVarID");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		(
			otherlv_5='='
			{
				newLeafNode(otherlv_5, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_2_1_0());
					}
					lv_right_6_0=ruleXExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
						}
						set(
							$current,
							"right",
							lv_right_6_0,
							"org.eclipse.xtext.xbase.Xbase.XExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleInitializedVariableDeclaration
entryRuleInitializedVariableDeclaration returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getInitializedVariableDeclarationRule()); }
	iv_ruleInitializedVariableDeclaration=ruleInitializedVariableDeclaration
	{ $current=$iv_ruleInitializedVariableDeclaration.current; }
	EOF;

// Rule InitializedVariableDeclaration
ruleInitializedVariableDeclaration returns [EObject current=null]
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
					grammarAccess.getInitializedVariableDeclarationAccess().getXtendVariableDeclarationAction_0(),
					$current);
			}
		)
		{
			if ($current==null) {
				$current = createModelElement(grammarAccess.getInitializedVariableDeclarationRule());
			}
			newCompositeNode(grammarAccess.getInitializedVariableDeclarationAccess().getVariableModifierParserRuleCall_1());
		}
		this_VariableModifier_1=ruleVariableModifier[$current]
		{
			$current = $this_VariableModifier_1.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				((
					(
						(
							ruleJvmTypeReference
						)
					)
					(
						(
							ruleInnerVarID
						)
					)
				)
				)=>
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getInitializedVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0());
							}
							lv_type_2_0=ruleJvmTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getInitializedVariableDeclarationRule());
								}
								set(
									$current,
									"type",
									lv_type_2_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getInitializedVariableDeclarationAccess().getNameInnerVarIDParserRuleCall_2_0_0_1_0());
							}
							lv_name_3_0=ruleInnerVarID
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getInitializedVariableDeclarationRule());
								}
								set(
									$current,
									"name",
									lv_name_3_0,
									"org.eclipse.xtend.core.Xtend.InnerVarID");
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
						newCompositeNode(grammarAccess.getInitializedVariableDeclarationAccess().getNameInnerVarIDParserRuleCall_2_1_0());
					}
					lv_name_4_0=ruleInnerVarID
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getInitializedVariableDeclarationRule());
						}
						set(
							$current,
							"name",
							lv_name_4_0,
							"org.eclipse.xtend.core.Xtend.InnerVarID");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		otherlv_5='='
		{
			newLeafNode(otherlv_5, grammarAccess.getInitializedVariableDeclarationAccess().getEqualsSignKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getInitializedVariableDeclarationAccess().getRightXExpressionParserRuleCall_4_0());
				}
				lv_right_6_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getInitializedVariableDeclarationRule());
					}
					set(
						$current,
						"right",
						lv_right_6_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;


// Rule VariableModifier
ruleVariableModifier[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				(
					(
						lv_writeable_0_0='var'
						{
							newLeafNode(lv_writeable_0_0, grammarAccess.getVariableModifierAccess().getWriteableVarKeyword_0_0_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getVariableModifierRule());
							}
							setWithLastConsumed($current, "writeable", lv_writeable_0_0 != null, "var");
						}
					)
				)
				    |
				otherlv_1='val'
				{
					newLeafNode(otherlv_1, grammarAccess.getVariableModifierAccess().getValKeyword_0_0_1());
				}
			)
			(
				(
					lv_extension_2_0='extension'
					{
						newLeafNode(lv_extension_2_0, grammarAccess.getVariableModifierAccess().getExtensionExtensionKeyword_0_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getVariableModifierRule());
						}
						setWithLastConsumed($current, "extension", lv_extension_2_0 != null, "extension");
					}
				)
			)?
		)
		    |
		(
			(
				(
					lv_extension_3_0='extension'
					{
						newLeafNode(lv_extension_3_0, grammarAccess.getVariableModifierAccess().getExtensionExtensionKeyword_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getVariableModifierRule());
						}
						setWithLastConsumed($current, "extension", lv_extension_3_0 != null, "extension");
					}
				)
			)
			(
				(
					(
						lv_writeable_4_0='var'
						{
							newLeafNode(lv_writeable_4_0, grammarAccess.getVariableModifierAccess().getWriteableVarKeyword_1_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getVariableModifierRule());
							}
							setWithLastConsumed($current, "writeable", lv_writeable_4_0 != null, "var");
						}
					)
				)
				    |
				otherlv_5='val'
				{
					newLeafNode(otherlv_5, grammarAccess.getVariableModifierAccess().getValKeyword_1_1_1());
				}
			)
		)
	)
;

// Entry rule entryRuleXConstructorCall
entryRuleXConstructorCall returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXConstructorCallRule()); }
	iv_ruleXConstructorCall=ruleXConstructorCall
	{ $current=$iv_ruleXConstructorCall.current; }
	EOF;

// Rule XConstructorCall
ruleXConstructorCall returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getXConstructorCallAccess().getXbaseConstructorCallParserRuleCall_0());
		}
		this_XbaseConstructorCall_0=ruleXbaseConstructorCall
		{
			$current = $this_XbaseConstructorCall_0.current;
			afterParserOrEnumRuleCall();
		}
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
							$current = forceCreateModelElementAndSet(
								grammarAccess.getXConstructorCallAccess().getAnonymousClassConstructorCallAction_1_0_0_0(),
								$current);
						}
					)
					otherlv_2='{'
					{
						newLeafNode(otherlv_2, grammarAccess.getXConstructorCallAccess().getLeftCurlyBracketKeyword_1_0_0_1());
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getXConstructorCallAccess().getMembersMemberParserRuleCall_1_1_0());
					}
					lv_members_3_0=ruleMember
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
						}
						add(
							$current,
							"members",
							lv_members_3_0,
							"org.eclipse.xtend.core.Xtend.Member");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_4='}'
			{
				newLeafNode(otherlv_4, grammarAccess.getXConstructorCallAccess().getRightCurlyBracketKeyword_1_2());
			}
		)?
	)
;

// Entry rule entryRuleXbaseConstructorCall
entryRuleXbaseConstructorCall returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXbaseConstructorCallRule()); }
	iv_ruleXbaseConstructorCall=ruleXbaseConstructorCall
	{ $current=$iv_ruleXbaseConstructorCall.current; }
	EOF;

// Rule XbaseConstructorCall
ruleXbaseConstructorCall returns [EObject current=null]
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
					grammarAccess.getXbaseConstructorCallAccess().getXConstructorCallAction_0(),
					$current);
			}
		)
		otherlv_1='new'
		{
			newLeafNode(otherlv_1, grammarAccess.getXbaseConstructorCallAccess().getNewKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getXbaseConstructorCallRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getXbaseConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0());
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
				otherlv_3='<'
				{
					newLeafNode(otherlv_3, grammarAccess.getXbaseConstructorCallAccess().getLessThanSignKeyword_3_0());
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getXbaseConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0());
					}
					lv_typeArguments_4_0=ruleJvmArgumentTypeReference
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXbaseConstructorCallRule());
						}
						add(
							$current,
							"typeArguments",
							lv_typeArguments_4_0,
							"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_5=','
				{
					newLeafNode(otherlv_5, grammarAccess.getXbaseConstructorCallAccess().getCommaKeyword_3_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getXbaseConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0());
						}
						lv_typeArguments_6_0=ruleJvmArgumentTypeReference
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXbaseConstructorCallRule());
							}
							add(
								$current,
								"typeArguments",
								lv_typeArguments_6_0,
								"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_7='>'
			{
				newLeafNode(otherlv_7, grammarAccess.getXbaseConstructorCallAccess().getGreaterThanSignKeyword_3_3());
			}
		)?
		(
			(
				((
					'('
				)
				)=>
				(
					lv_explicitConstructorCall_8_0='('
					{
						newLeafNode(lv_explicitConstructorCall_8_0, grammarAccess.getXbaseConstructorCallAccess().getExplicitConstructorCallLeftParenthesisKeyword_4_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getXbaseConstructorCallRule());
						}
						setWithLastConsumed($current, "explicitConstructorCall", lv_explicitConstructorCall_8_0 != null, "(");
					}
				)
			)
			(
				(
					((
						(
						)
						(
							(
								(
									ruleJvmFormalParameter
								)
							)
							(
								','
								(
									(
										ruleJvmFormalParameter
									)
								)
							)*
						)?
						(
							(
								'|'
							)
						)
					)
					)=>
					(
						{
							newCompositeNode(grammarAccess.getXbaseConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_4_1_0_0());
						}
						lv_arguments_9_0=ruleXShortClosure
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXbaseConstructorCallRule());
							}
							add(
								$current,
								"arguments",
								lv_arguments_9_0,
								"org.eclipse.xtext.xbase.Xbase.XShortClosure");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getXbaseConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_0_0());
							}
							lv_arguments_10_0=ruleXExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXbaseConstructorCallRule());
								}
								add(
									$current,
									"arguments",
									lv_arguments_10_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_11=','
						{
							newLeafNode(otherlv_11, grammarAccess.getXbaseConstructorCallAccess().getCommaKeyword_4_1_1_1_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getXbaseConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_1_1_0());
								}
								lv_arguments_12_0=ruleXExpression
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getXbaseConstructorCallRule());
									}
									add(
										$current,
										"arguments",
										lv_arguments_12_0,
										"org.eclipse.xtext.xbase.Xbase.XExpression");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)
			)?
			otherlv_13=')'
			{
				newLeafNode(otherlv_13, grammarAccess.getXbaseConstructorCallAccess().getRightParenthesisKeyword_4_2());
			}
		)?
		(
			((
				(
				)
				'['
			)
			)=>
			(
				{
					newCompositeNode(grammarAccess.getXbaseConstructorCallAccess().getArgumentsXClosureParserRuleCall_5_0());
				}
				lv_arguments_14_0=ruleXClosure
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXbaseConstructorCallRule());
					}
					add(
						$current,
						"arguments",
						lv_arguments_14_0,
						"org.eclipse.xtext.xbase.Xbase.XClosure");
					afterParserOrEnumRuleCall();
				}
			)
		)?
	)
;

// Entry rule entryRuleJvmFormalParameter
entryRuleJvmFormalParameter returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJvmFormalParameterRule()); }
	iv_ruleJvmFormalParameter=ruleJvmFormalParameter
	{ $current=$iv_ruleJvmFormalParameter.current; }
	EOF;

// Rule JvmFormalParameter
ruleJvmFormalParameter returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_extension_0_0='extension'
				{
					newLeafNode(lv_extension_0_0, grammarAccess.getJvmFormalParameterAccess().getExtensionExtensionKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getJvmFormalParameterRule());
					}
					setWithLastConsumed($current, "extension", lv_extension_0_0 != null, "extension");
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_1_0());
				}
				lv_parameterType_1_0=ruleJvmTypeReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
					}
					set(
						$current,
						"parameterType",
						lv_parameterType_1_0,
						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getNameInnerVarIDParserRuleCall_2_0());
				}
				lv_name_2_0=ruleInnerVarID
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
					}
					set(
						$current,
						"name",
						lv_name_2_0,
						"org.eclipse.xtend.core.Xtend.InnerVarID");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleFullJvmFormalParameter
entryRuleFullJvmFormalParameter returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFullJvmFormalParameterRule()); }
	iv_ruleFullJvmFormalParameter=ruleFullJvmFormalParameter
	{ $current=$iv_ruleFullJvmFormalParameter.current; }
	EOF;

// Rule FullJvmFormalParameter
ruleFullJvmFormalParameter returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_extension_0_0='extension'
				{
					newLeafNode(lv_extension_0_0, grammarAccess.getFullJvmFormalParameterAccess().getExtensionExtensionKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFullJvmFormalParameterRule());
					}
					setWithLastConsumed($current, "extension", lv_extension_0_0 != null, "extension");
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeMultiTypeReferenceParserRuleCall_1_0());
				}
				lv_parameterType_1_0=ruleMultiTypeReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
					}
					set(
						$current,
						"parameterType",
						lv_parameterType_1_0,
						"org.eclipse.xtend.core.Xtend.MultiTypeReference");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getNameInnerVarIDParserRuleCall_2_0());
				}
				lv_name_2_0=ruleInnerVarID
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
					}
					set(
						$current,
						"name",
						lv_name_2_0,
						"org.eclipse.xtend.core.Xtend.InnerVarID");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleMultiTypeReference
entryRuleMultiTypeReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMultiTypeReferenceRule()); }
	iv_ruleMultiTypeReference=ruleMultiTypeReference
	{ $current=$iv_ruleMultiTypeReference.current; }
	EOF;

// Rule MultiTypeReference
ruleMultiTypeReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getMultiTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0());
		}
		this_JvmTypeReference_0=ruleJvmTypeReference
		{
			$current = $this_JvmTypeReference_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndAdd(
						grammarAccess.getMultiTypeReferenceAccess().getJvmSynonymTypeReferenceReferencesAction_1_0(),
						$current);
				}
			)
			(
				otherlv_2='|'
				{
					newLeafNode(otherlv_2, grammarAccess.getMultiTypeReferenceAccess().getVerticalLineKeyword_1_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMultiTypeReferenceAccess().getReferencesJvmTypeReferenceParserRuleCall_1_1_1_0());
						}
						lv_references_3_0=ruleJvmTypeReference
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMultiTypeReferenceRule());
							}
							add(
								$current,
								"references",
								lv_references_3_0,
								"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)+
		)?
	)
;

// Entry rule entryRuleXStringLiteral
entryRuleXStringLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXStringLiteralRule()); }
	iv_ruleXStringLiteral=ruleXStringLiteral
	{ $current=$iv_ruleXStringLiteral.current; }
	EOF;

// Rule XStringLiteral
ruleXStringLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getXStringLiteralAccess().getSimpleStringLiteralParserRuleCall_0());
		}
		this_SimpleStringLiteral_0=ruleSimpleStringLiteral
		{
			$current = $this_SimpleStringLiteral_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getXStringLiteralAccess().getRichStringParserRuleCall_1());
		}
		this_RichString_1=ruleRichString
		{
			$current = $this_RichString_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleXSwitchExpression
entryRuleXSwitchExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXSwitchExpressionRule()); }
	iv_ruleXSwitchExpression=ruleXSwitchExpression
	{ $current=$iv_ruleXSwitchExpression.current; }
	EOF;

// Rule XSwitchExpression
ruleXSwitchExpression returns [EObject current=null]
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
					grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='switch'
		{
			newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
		}
		(
			(
				(
					((
						'('
						(
							(
								ruleJvmFormalParameter
							)
						)
						':'
					)
					)=>
					(
						otherlv_2='('
						{
							newLeafNode(otherlv_2, grammarAccess.getXSwitchExpressionAccess().getLeftParenthesisKeyword_2_0_0_0_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0());
								}
								lv_declaredParam_3_0=ruleJvmFormalParameter
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
									}
									set(
										$current,
										"declaredParam",
										lv_declaredParam_3_0,
										"org.eclipse.xtend.core.Xtend.JvmFormalParameter");
									afterParserOrEnumRuleCall();
								}
							)
						)
						otherlv_4=':'
						{
							newLeafNode(otherlv_4, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_0_0_0_2());
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_0_1_0());
						}
						lv_switch_5_0=ruleXExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
							}
							set(
								$current,
								"switch",
								lv_switch_5_0,
								"org.eclipse.xtext.xbase.Xbase.XExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_6=')'
				{
					newLeafNode(otherlv_6, grammarAccess.getXSwitchExpressionAccess().getRightParenthesisKeyword_2_0_2());
				}
			)
			    |
			(
				(
					((
						(
							(
								ruleJvmFormalParameter
							)
						)
						':'
					)
					)=>
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0());
								}
								lv_declaredParam_7_0=ruleJvmFormalParameter
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
									}
									set(
										$current,
										"declaredParam",
										lv_declaredParam_7_0,
										"org.eclipse.xtend.core.Xtend.JvmFormalParameter");
									afterParserOrEnumRuleCall();
								}
							)
						)
						otherlv_8=':'
						{
							newLeafNode(otherlv_8, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_1_0_0_1());
						}
					)
				)?
				(
					(
						{
							newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionOrSimpleConstructorCallParserRuleCall_2_1_1_0());
						}
						lv_switch_9_0=ruleXExpressionOrSimpleConstructorCall
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
							}
							set(
								$current,
								"switch",
								lv_switch_9_0,
								"org.eclipse.xtend.core.Xtend.XExpressionOrSimpleConstructorCall");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)
		otherlv_10='{'
		{
			newLeafNode(otherlv_10, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_4_0());
				}
				lv_cases_11_0=ruleXCasePart
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
					}
					add(
						$current,
						"cases",
						lv_cases_11_0,
						"org.eclipse.xtend.core.Xtend.XCasePart");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			otherlv_12='default'
			{
				newLeafNode(otherlv_12, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_5_0());
			}
			otherlv_13=':'
			{
				newLeafNode(otherlv_13, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_5_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_5_2_0());
					}
					lv_default_14_0=ruleXExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
						}
						set(
							$current,
							"default",
							lv_default_14_0,
							"org.eclipse.xtext.xbase.Xbase.XExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_15='}'
		{
			newLeafNode(otherlv_15, grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_6());
		}
	)
;

// Entry rule entryRuleXCasePart
entryRuleXCasePart returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXCasePartRule()); }
	iv_ruleXCasePart=ruleXCasePart
	{ $current=$iv_ruleXCasePart.current; }
	EOF;

// Rule XCasePart
ruleXCasePart returns [EObject current=null]
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
					grammarAccess.getXCasePartAccess().getXCasePartAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardMultiTypeReferenceParserRuleCall_1_0());
				}
				lv_typeGuard_1_0=ruleMultiTypeReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXCasePartRule());
					}
					set(
						$current,
						"typeGuard",
						lv_typeGuard_1_0,
						"org.eclipse.xtend.core.Xtend.MultiTypeReference");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_2='case'
			{
				newLeafNode(otherlv_2, grammarAccess.getXCasePartAccess().getCaseKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_2_1_0());
					}
					lv_case_3_0=ruleXExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXCasePartRule());
						}
						set(
							$current,
							"case",
							lv_case_3_0,
							"org.eclipse.xtext.xbase.Xbase.XExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			(
				otherlv_4=':'
				{
					newLeafNode(otherlv_4, grammarAccess.getXCasePartAccess().getColonKeyword_3_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0_1_0());
						}
						lv_then_5_0=ruleXExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXCasePartRule());
							}
							set(
								$current,
								"then",
								lv_then_5_0,
								"org.eclipse.xtext.xbase.Xbase.XExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				(
					lv_fallThrough_6_0=','
					{
						newLeafNode(lv_fallThrough_6_0, grammarAccess.getXCasePartAccess().getFallThroughCommaKeyword_3_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getXCasePartRule());
						}
						setWithLastConsumed($current, "fallThrough", lv_fallThrough_6_0 != null, ",");
					}
				)
			)
		)
	)
;

// Entry rule entryRuleXExpressionOrSimpleConstructorCall
entryRuleXExpressionOrSimpleConstructorCall returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXExpressionOrSimpleConstructorCallRule()); }
	iv_ruleXExpressionOrSimpleConstructorCall=ruleXExpressionOrSimpleConstructorCall
	{ $current=$iv_ruleXExpressionOrSimpleConstructorCall.current; }
	EOF;

// Rule XExpressionOrSimpleConstructorCall
ruleXExpressionOrSimpleConstructorCall returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			('new')=>
			{
				newCompositeNode(grammarAccess.getXExpressionOrSimpleConstructorCallAccess().getXbaseConstructorCallParserRuleCall_0());
			}
			this_XbaseConstructorCall_0=ruleXbaseConstructorCall
			{
				$current = $this_XbaseConstructorCall_0.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		{
			newCompositeNode(grammarAccess.getXExpressionOrSimpleConstructorCallAccess().getXExpressionParserRuleCall_1());
		}
		this_XExpression_1=ruleXExpression
		{
			$current = $this_XExpression_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleSimpleStringLiteral
entryRuleSimpleStringLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSimpleStringLiteralRule()); }
	iv_ruleSimpleStringLiteral=ruleSimpleStringLiteral
	{ $current=$iv_ruleSimpleStringLiteral.current; }
	EOF;

// Rule SimpleStringLiteral
ruleSimpleStringLiteral returns [EObject current=null]
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
					grammarAccess.getSimpleStringLiteralAccess().getXStringLiteralAction_0(),
					$current);
			}
		)
		(
			(
				lv_value_1_0=RULE_STRING
				{
					newLeafNode(lv_value_1_0, grammarAccess.getSimpleStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSimpleStringLiteralRule());
					}
					setWithLastConsumed(
						$current,
						"value",
						lv_value_1_0,
						"org.eclipse.xtext.xbase.Xtype.STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleRichString
entryRuleRichString returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRichStringRule()); }
	iv_ruleRichString=ruleRichString
	{ $current=$iv_ruleRichString.current; }
	EOF;

// Rule RichString
ruleRichString returns [EObject current=null]
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
					grammarAccess.getRichStringAccess().getRichStringAction_0(),
					$current);
			}
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralParserRuleCall_1_0_0());
					}
					lv_expressions_1_0=ruleRichStringLiteral
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRichStringRule());
						}
						add(
							$current,
							"expressions",
							lv_expressions_1_0,
							"org.eclipse.xtend.core.Xtend.RichStringLiteral");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralStartParserRuleCall_1_1_0_0());
						}
						lv_expressions_2_0=ruleRichStringLiteralStart
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRichStringRule());
							}
							add(
								$current,
								"expressions",
								lv_expressions_2_0,
								"org.eclipse.xtend.core.Xtend.RichStringLiteralStart");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getRichStringAccess().getExpressionsRichStringPartParserRuleCall_1_1_1_0());
						}
						lv_expressions_3_0=ruleRichStringPart
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRichStringRule());
							}
							add(
								$current,
								"expressions",
								lv_expressions_3_0,
								"org.eclipse.xtend.core.Xtend.RichStringPart");
							afterParserOrEnumRuleCall();
						}
					)
				)?
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_2_0_0());
							}
							lv_expressions_4_0=ruleRichStringLiteralInbetween
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getRichStringRule());
								}
								add(
									$current,
									"expressions",
									lv_expressions_4_0,
									"org.eclipse.xtend.core.Xtend.RichStringLiteralInbetween");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getRichStringAccess().getExpressionsRichStringPartParserRuleCall_1_1_2_1_0());
							}
							lv_expressions_5_0=ruleRichStringPart
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getRichStringRule());
								}
								add(
									$current,
									"expressions",
									lv_expressions_5_0,
									"org.eclipse.xtend.core.Xtend.RichStringPart");
								afterParserOrEnumRuleCall();
							}
						)
					)?
				)*
				(
					(
						{
							newCompositeNode(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralEndParserRuleCall_1_1_3_0());
						}
						lv_expressions_6_0=ruleRichStringLiteralEnd
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRichStringRule());
							}
							add(
								$current,
								"expressions",
								lv_expressions_6_0,
								"org.eclipse.xtend.core.Xtend.RichStringLiteralEnd");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)
	)
;

// Entry rule entryRuleRichStringLiteral
entryRuleRichStringLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRichStringLiteralRule()); }
	iv_ruleRichStringLiteral=ruleRichStringLiteral
	{ $current=$iv_ruleRichStringLiteral.current; }
	EOF;

// Rule RichStringLiteral
ruleRichStringLiteral returns [EObject current=null]
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
					grammarAccess.getRichStringLiteralAccess().getRichStringLiteralAction_0(),
					$current);
			}
		)
		(
			(
				lv_value_1_0=RULE_RICH_TEXT
				{
					newLeafNode(lv_value_1_0, grammarAccess.getRichStringLiteralAccess().getValueRICH_TEXTTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRichStringLiteralRule());
					}
					setWithLastConsumed(
						$current,
						"value",
						lv_value_1_0,
						"org.eclipse.xtend.core.Xtend.RICH_TEXT");
				}
			)
		)
	)
;

// Entry rule entryRuleRichStringLiteralStart
entryRuleRichStringLiteralStart returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRichStringLiteralStartRule()); }
	iv_ruleRichStringLiteralStart=ruleRichStringLiteralStart
	{ $current=$iv_ruleRichStringLiteralStart.current; }
	EOF;

// Rule RichStringLiteralStart
ruleRichStringLiteralStart returns [EObject current=null]
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
					grammarAccess.getRichStringLiteralStartAccess().getRichStringLiteralAction_0(),
					$current);
			}
		)
		(
			(
				lv_value_1_0=RULE_RICH_TEXT_START
				{
					newLeafNode(lv_value_1_0, grammarAccess.getRichStringLiteralStartAccess().getValueRICH_TEXT_STARTTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRichStringLiteralStartRule());
					}
					setWithLastConsumed(
						$current,
						"value",
						lv_value_1_0,
						"org.eclipse.xtend.core.Xtend.RICH_TEXT_START");
				}
			)
		)
	)
;

// Entry rule entryRuleRichStringLiteralInbetween
entryRuleRichStringLiteralInbetween returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRichStringLiteralInbetweenRule()); }
	iv_ruleRichStringLiteralInbetween=ruleRichStringLiteralInbetween
	{ $current=$iv_ruleRichStringLiteralInbetween.current; }
	EOF;

// Rule RichStringLiteralInbetween
ruleRichStringLiteralInbetween returns [EObject current=null]
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
					grammarAccess.getRichStringLiteralInbetweenAccess().getRichStringLiteralAction_0(),
					$current);
			}
		)
		(
			(
				(
					lv_value_1_0=RULE_RICH_TEXT_INBETWEEN
					{
						newLeafNode(lv_value_1_0, grammarAccess.getRichStringLiteralInbetweenAccess().getValueRICH_TEXT_INBETWEENTerminalRuleCall_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getRichStringLiteralInbetweenRule());
						}
						setWithLastConsumed(
							$current,
							"value",
							lv_value_1_0,
							"org.eclipse.xtend.core.Xtend.RICH_TEXT_INBETWEEN");
					}
				)
			)
			    |
			(
				(
					lv_value_2_0=RULE_COMMENT_RICH_TEXT_INBETWEEN
					{
						newLeafNode(lv_value_2_0, grammarAccess.getRichStringLiteralInbetweenAccess().getValueCOMMENT_RICH_TEXT_INBETWEENTerminalRuleCall_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getRichStringLiteralInbetweenRule());
						}
						setWithLastConsumed(
							$current,
							"value",
							lv_value_2_0,
							"org.eclipse.xtend.core.Xtend.COMMENT_RICH_TEXT_INBETWEEN");
					}
				)
			)
		)
	)
;

// Entry rule entryRuleRichStringLiteralEnd
entryRuleRichStringLiteralEnd returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRichStringLiteralEndRule()); }
	iv_ruleRichStringLiteralEnd=ruleRichStringLiteralEnd
	{ $current=$iv_ruleRichStringLiteralEnd.current; }
	EOF;

// Rule RichStringLiteralEnd
ruleRichStringLiteralEnd returns [EObject current=null]
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
					grammarAccess.getRichStringLiteralEndAccess().getRichStringLiteralAction_0(),
					$current);
			}
		)
		(
			(
				(
					lv_value_1_0=RULE_RICH_TEXT_END
					{
						newLeafNode(lv_value_1_0, grammarAccess.getRichStringLiteralEndAccess().getValueRICH_TEXT_ENDTerminalRuleCall_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getRichStringLiteralEndRule());
						}
						setWithLastConsumed(
							$current,
							"value",
							lv_value_1_0,
							"org.eclipse.xtend.core.Xtend.RICH_TEXT_END");
					}
				)
			)
			    |
			(
				(
					lv_value_2_0=RULE_COMMENT_RICH_TEXT_END
					{
						newLeafNode(lv_value_2_0, grammarAccess.getRichStringLiteralEndAccess().getValueCOMMENT_RICH_TEXT_ENDTerminalRuleCall_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getRichStringLiteralEndRule());
						}
						setWithLastConsumed(
							$current,
							"value",
							lv_value_2_0,
							"org.eclipse.xtend.core.Xtend.COMMENT_RICH_TEXT_END");
					}
				)
			)
		)
	)
;

// Entry rule entryRuleInternalRichString
entryRuleInternalRichString returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getInternalRichStringRule()); }
	iv_ruleInternalRichString=ruleInternalRichString
	{ $current=$iv_ruleInternalRichString.current; }
	EOF;

// Rule InternalRichString
ruleInternalRichString returns [EObject current=null]
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
					grammarAccess.getInternalRichStringAccess().getRichStringAction_0(),
					$current);
			}
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getInternalRichStringAccess().getExpressionsRichStringLiteralInbetweenParserRuleCall_1_0_0());
					}
					lv_expressions_1_0=ruleRichStringLiteralInbetween
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getInternalRichStringRule());
						}
						add(
							$current,
							"expressions",
							lv_expressions_1_0,
							"org.eclipse.xtend.core.Xtend.RichStringLiteralInbetween");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getInternalRichStringAccess().getExpressionsRichStringPartParserRuleCall_1_1_0_0());
						}
						lv_expressions_2_0=ruleRichStringPart
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getInternalRichStringRule());
							}
							add(
								$current,
								"expressions",
								lv_expressions_2_0,
								"org.eclipse.xtend.core.Xtend.RichStringPart");
							afterParserOrEnumRuleCall();
						}
					)
				)?
				(
					(
						{
							newCompositeNode(grammarAccess.getInternalRichStringAccess().getExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_1_0());
						}
						lv_expressions_3_0=ruleRichStringLiteralInbetween
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getInternalRichStringRule());
							}
							add(
								$current,
								"expressions",
								lv_expressions_3_0,
								"org.eclipse.xtend.core.Xtend.RichStringLiteralInbetween");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)
	)
;

// Entry rule entryRuleRichStringPart
entryRuleRichStringPart returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRichStringPartRule()); }
	iv_ruleRichStringPart=ruleRichStringPart
	{ $current=$iv_ruleRichStringPart.current; }
	EOF;

// Rule RichStringPart
ruleRichStringPart returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getRichStringPartAccess().getXExpressionOrVarDeclarationParserRuleCall_0());
		}
		this_XExpressionOrVarDeclaration_0=ruleXExpressionOrVarDeclaration
		{
			$current = $this_XExpressionOrVarDeclaration_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getRichStringPartAccess().getRichStringForLoopParserRuleCall_1());
		}
		this_RichStringForLoop_1=ruleRichStringForLoop
		{
			$current = $this_RichStringForLoop_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getRichStringPartAccess().getRichStringIfParserRuleCall_2());
		}
		this_RichStringIf_2=ruleRichStringIf
		{
			$current = $this_RichStringIf_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleRichStringForLoop
entryRuleRichStringForLoop returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRichStringForLoopRule()); }
	iv_ruleRichStringForLoop=ruleRichStringForLoop
	{ $current=$iv_ruleRichStringForLoop.current; }
	EOF;

// Rule RichStringForLoop
ruleRichStringForLoop returns [EObject current=null]
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
					grammarAccess.getRichStringForLoopAccess().getRichStringForLoopAction_0(),
					$current);
			}
		)
		otherlv_1='FOR'
		{
			newLeafNode(otherlv_1, grammarAccess.getRichStringForLoopAccess().getFORKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRichStringForLoopAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0());
				}
				lv_declaredParam_2_0=ruleJvmFormalParameter
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRichStringForLoopRule());
					}
					set(
						$current,
						"declaredParam",
						lv_declaredParam_2_0,
						"org.eclipse.xtend.core.Xtend.JvmFormalParameter");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=':'
		{
			newLeafNode(otherlv_3, grammarAccess.getRichStringForLoopAccess().getColonKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRichStringForLoopAccess().getForExpressionXExpressionParserRuleCall_4_0());
				}
				lv_forExpression_4_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRichStringForLoopRule());
					}
					set(
						$current,
						"forExpression",
						lv_forExpression_4_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_5='BEFORE'
			{
				newLeafNode(otherlv_5, grammarAccess.getRichStringForLoopAccess().getBEFOREKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getRichStringForLoopAccess().getBeforeXExpressionParserRuleCall_5_1_0());
					}
					lv_before_6_0=ruleXExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRichStringForLoopRule());
						}
						set(
							$current,
							"before",
							lv_before_6_0,
							"org.eclipse.xtext.xbase.Xbase.XExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_7='SEPARATOR'
			{
				newLeafNode(otherlv_7, grammarAccess.getRichStringForLoopAccess().getSEPARATORKeyword_6_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getRichStringForLoopAccess().getSeparatorXExpressionParserRuleCall_6_1_0());
					}
					lv_separator_8_0=ruleXExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRichStringForLoopRule());
						}
						set(
							$current,
							"separator",
							lv_separator_8_0,
							"org.eclipse.xtext.xbase.Xbase.XExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_9='AFTER'
			{
				newLeafNode(otherlv_9, grammarAccess.getRichStringForLoopAccess().getAFTERKeyword_7_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getRichStringForLoopAccess().getAfterXExpressionParserRuleCall_7_1_0());
					}
					lv_after_10_0=ruleXExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRichStringForLoopRule());
						}
						set(
							$current,
							"after",
							lv_after_10_0,
							"org.eclipse.xtext.xbase.Xbase.XExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getRichStringForLoopAccess().getEachExpressionInternalRichStringParserRuleCall_8_0());
				}
				lv_eachExpression_11_0=ruleInternalRichString
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRichStringForLoopRule());
					}
					set(
						$current,
						"eachExpression",
						lv_eachExpression_11_0,
						"org.eclipse.xtend.core.Xtend.InternalRichString");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_12='ENDFOR'
		{
			newLeafNode(otherlv_12, grammarAccess.getRichStringForLoopAccess().getENDFORKeyword_9());
		}
	)
;

// Entry rule entryRuleRichStringIf
entryRuleRichStringIf returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRichStringIfRule()); }
	iv_ruleRichStringIf=ruleRichStringIf
	{ $current=$iv_ruleRichStringIf.current; }
	EOF;

// Rule RichStringIf
ruleRichStringIf returns [EObject current=null]
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
					grammarAccess.getRichStringIfAccess().getRichStringIfAction_0(),
					$current);
			}
		)
		otherlv_1='IF'
		{
			newLeafNode(otherlv_1, grammarAccess.getRichStringIfAccess().getIFKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRichStringIfAccess().getIfXExpressionParserRuleCall_2_0());
				}
				lv_if_2_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRichStringIfRule());
					}
					set(
						$current,
						"if",
						lv_if_2_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getRichStringIfAccess().getThenInternalRichStringParserRuleCall_3_0());
				}
				lv_then_3_0=ruleInternalRichString
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRichStringIfRule());
					}
					set(
						$current,
						"then",
						lv_then_3_0,
						"org.eclipse.xtend.core.Xtend.InternalRichString");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getRichStringIfAccess().getElseIfsRichStringElseIfParserRuleCall_4_0());
				}
				lv_elseIfs_4_0=ruleRichStringElseIf
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRichStringIfRule());
					}
					add(
						$current,
						"elseIfs",
						lv_elseIfs_4_0,
						"org.eclipse.xtend.core.Xtend.RichStringElseIf");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			otherlv_5='ELSE'
			{
				newLeafNode(otherlv_5, grammarAccess.getRichStringIfAccess().getELSEKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getRichStringIfAccess().getElseInternalRichStringParserRuleCall_5_1_0());
					}
					lv_else_6_0=ruleInternalRichString
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRichStringIfRule());
						}
						set(
							$current,
							"else",
							lv_else_6_0,
							"org.eclipse.xtend.core.Xtend.InternalRichString");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_7='ENDIF'
		{
			newLeafNode(otherlv_7, grammarAccess.getRichStringIfAccess().getENDIFKeyword_6());
		}
	)
;

// Entry rule entryRuleRichStringElseIf
entryRuleRichStringElseIf returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRichStringElseIfRule()); }
	iv_ruleRichStringElseIf=ruleRichStringElseIf
	{ $current=$iv_ruleRichStringElseIf.current; }
	EOF;

// Rule RichStringElseIf
ruleRichStringElseIf returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='ELSEIF'
		{
			newLeafNode(otherlv_0, grammarAccess.getRichStringElseIfAccess().getELSEIFKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRichStringElseIfAccess().getIfXExpressionParserRuleCall_1_0());
				}
				lv_if_1_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRichStringElseIfRule());
					}
					set(
						$current,
						"if",
						lv_if_1_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getRichStringElseIfAccess().getThenInternalRichStringParserRuleCall_2_0());
				}
				lv_then_2_0=ruleInternalRichString
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRichStringElseIfRule());
					}
					set(
						$current,
						"then",
						lv_then_2_0,
						"org.eclipse.xtend.core.Xtend.InternalRichString");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleXAnnotation
entryRuleXAnnotation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXAnnotationRule()); }
	iv_ruleXAnnotation=ruleXAnnotation
	{ $current=$iv_ruleXAnnotation.current; }
	EOF;

// Rule XAnnotation
ruleXAnnotation returns [EObject current=null]
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
					grammarAccess.getXAnnotationAccess().getXAnnotationAction_0(),
					$current);
			}
		)
		otherlv_1='@'
		{
			newLeafNode(otherlv_1, grammarAccess.getXAnnotationAccess().getCommercialAtKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getXAnnotationRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getXAnnotationAccess().getAnnotationTypeJvmAnnotationTypeCrossReference_2_0());
				}
				ruleQualifiedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				('(')=>
				otherlv_3='('
				{
					newLeafNode(otherlv_3, grammarAccess.getXAnnotationAccess().getLeftParenthesisKeyword_3_0());
				}
			)
			(
				(
					(
						((
							(
								(
									ruleValidID
								)
							)
							'='
						)
						)=>
						(
							{
								newCompositeNode(grammarAccess.getXAnnotationAccess().getElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_0_0());
							}
							lv_elementValuePairs_4_0=ruleXAnnotationElementValuePair
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXAnnotationRule());
								}
								add(
									$current,
									"elementValuePairs",
									lv_elementValuePairs_4_0,
									"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotationElementValuePair");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_5=','
						{
							newLeafNode(otherlv_5, grammarAccess.getXAnnotationAccess().getCommaKeyword_3_1_0_1_0());
						}
						(
							((
								(
									(
										ruleValidID
									)
								)
								'='
							)
							)=>
							(
								{
									newCompositeNode(grammarAccess.getXAnnotationAccess().getElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_1_1_0());
								}
								lv_elementValuePairs_6_0=ruleXAnnotationElementValuePair
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getXAnnotationRule());
									}
									add(
										$current,
										"elementValuePairs",
										lv_elementValuePairs_6_0,
										"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotationElementValuePair");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getXAnnotationAccess().getValueXAnnotationElementValueOrCommaListParserRuleCall_3_1_1_0());
						}
						lv_value_7_0=ruleXAnnotationElementValueOrCommaList
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXAnnotationRule());
							}
							set(
								$current,
								"value",
								lv_value_7_0,
								"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotationElementValueOrCommaList");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)?
			otherlv_8=')'
			{
				newLeafNode(otherlv_8, grammarAccess.getXAnnotationAccess().getRightParenthesisKeyword_3_2());
			}
		)?
	)
;

// Entry rule entryRuleXAnnotationElementValuePair
entryRuleXAnnotationElementValuePair returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXAnnotationElementValuePairRule()); }
	iv_ruleXAnnotationElementValuePair=ruleXAnnotationElementValuePair
	{ $current=$iv_ruleXAnnotationElementValuePair.current; }
	EOF;

// Rule XAnnotationElementValuePair
ruleXAnnotationElementValuePair returns [EObject current=null]
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
						ruleValidID
					)
				)
				'='
			)
			)=>
			(
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getXAnnotationElementValuePairRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getXAnnotationElementValuePairAccess().getElementJvmOperationCrossReference_0_0_0_0());
						}
						ruleValidID
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_1='='
				{
					newLeafNode(otherlv_1, grammarAccess.getXAnnotationElementValuePairAccess().getEqualsSignKeyword_0_0_1());
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getXAnnotationElementValuePairAccess().getValueXAnnotationElementValueParserRuleCall_1_0());
				}
				lv_value_2_0=ruleXAnnotationElementValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXAnnotationElementValuePairRule());
					}
					set(
						$current,
						"value",
						lv_value_2_0,
						"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotationElementValue");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleXAnnotationElementValueOrCommaList
entryRuleXAnnotationElementValueOrCommaList returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXAnnotationElementValueOrCommaListRule()); }
	iv_ruleXAnnotationElementValueOrCommaList=ruleXAnnotationElementValueOrCommaList
	{ $current=$iv_ruleXAnnotationElementValueOrCommaList.current; }
	EOF;

// Rule XAnnotationElementValueOrCommaList
ruleXAnnotationElementValueOrCommaList returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				((
					(
					)
					'#'
					'['
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElement(
								grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralAction_0_0_0_0(),
								$current);
						}
					)
					otherlv_1='#'
					{
						newLeafNode(otherlv_1, grammarAccess.getXAnnotationElementValueOrCommaListAccess().getNumberSignKeyword_0_0_0_1());
					}
					otherlv_2='['
					{
						newLeafNode(otherlv_2, grammarAccess.getXAnnotationElementValueOrCommaListAccess().getLeftSquareBracketKeyword_0_0_0_2());
					}
				)
			)
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsXAnnotationOrExpressionParserRuleCall_0_1_0_0());
						}
						lv_elements_3_0=ruleXAnnotationOrExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXAnnotationElementValueOrCommaListRule());
							}
							add(
								$current,
								"elements",
								lv_elements_3_0,
								"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotationOrExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_4=','
					{
						newLeafNode(otherlv_4, grammarAccess.getXAnnotationElementValueOrCommaListAccess().getCommaKeyword_0_1_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsXAnnotationOrExpressionParserRuleCall_0_1_1_1_0());
							}
							lv_elements_5_0=ruleXAnnotationOrExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXAnnotationElementValueOrCommaListRule());
								}
								add(
									$current,
									"elements",
									lv_elements_5_0,
									"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotationOrExpression");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)?
			otherlv_6=']'
			{
				newLeafNode(otherlv_6, grammarAccess.getXAnnotationElementValueOrCommaListAccess().getRightSquareBracketKeyword_0_2());
			}
		)
		    |
		(
			{
				newCompositeNode(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXAnnotationOrExpressionParserRuleCall_1_0());
			}
			this_XAnnotationOrExpression_7=ruleXAnnotationOrExpression
			{
				$current = $this_XAnnotationOrExpression_7.current;
				afterParserOrEnumRuleCall();
			}
			(
				(
					{
						$current = forceCreateModelElementAndAdd(
							grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0(),
							$current);
					}
				)
				(
					otherlv_9=','
					{
						newLeafNode(otherlv_9, grammarAccess.getXAnnotationElementValueOrCommaListAccess().getCommaKeyword_1_1_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsXAnnotationOrExpressionParserRuleCall_1_1_1_1_0());
							}
							lv_elements_10_0=ruleXAnnotationOrExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXAnnotationElementValueOrCommaListRule());
								}
								add(
									$current,
									"elements",
									lv_elements_10_0,
									"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotationOrExpression");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)+
			)?
		)
	)
;

// Entry rule entryRuleXAnnotationElementValue
entryRuleXAnnotationElementValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXAnnotationElementValueRule()); }
	iv_ruleXAnnotationElementValue=ruleXAnnotationElementValue
	{ $current=$iv_ruleXAnnotationElementValue.current; }
	EOF;

// Rule XAnnotationElementValue
ruleXAnnotationElementValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				((
					(
					)
					'#'
					'['
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElement(
								grammarAccess.getXAnnotationElementValueAccess().getXListLiteralAction_0_0_0_0(),
								$current);
						}
					)
					otherlv_1='#'
					{
						newLeafNode(otherlv_1, grammarAccess.getXAnnotationElementValueAccess().getNumberSignKeyword_0_0_0_1());
					}
					otherlv_2='['
					{
						newLeafNode(otherlv_2, grammarAccess.getXAnnotationElementValueAccess().getLeftSquareBracketKeyword_0_0_0_2());
					}
				)
			)
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getXAnnotationElementValueAccess().getElementsXAnnotationOrExpressionParserRuleCall_0_1_0_0());
						}
						lv_elements_3_0=ruleXAnnotationOrExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXAnnotationElementValueRule());
							}
							add(
								$current,
								"elements",
								lv_elements_3_0,
								"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotationOrExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_4=','
					{
						newLeafNode(otherlv_4, grammarAccess.getXAnnotationElementValueAccess().getCommaKeyword_0_1_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getXAnnotationElementValueAccess().getElementsXAnnotationOrExpressionParserRuleCall_0_1_1_1_0());
							}
							lv_elements_5_0=ruleXAnnotationOrExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXAnnotationElementValueRule());
								}
								add(
									$current,
									"elements",
									lv_elements_5_0,
									"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotationOrExpression");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)?
			otherlv_6=']'
			{
				newLeafNode(otherlv_6, grammarAccess.getXAnnotationElementValueAccess().getRightSquareBracketKeyword_0_2());
			}
		)
		    |
		{
			newCompositeNode(grammarAccess.getXAnnotationElementValueAccess().getXAnnotationOrExpressionParserRuleCall_1());
		}
		this_XAnnotationOrExpression_7=ruleXAnnotationOrExpression
		{
			$current = $this_XAnnotationOrExpression_7.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleXAnnotationOrExpression
entryRuleXAnnotationOrExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXAnnotationOrExpressionRule()); }
	iv_ruleXAnnotationOrExpression=ruleXAnnotationOrExpression
	{ $current=$iv_ruleXAnnotationOrExpression.current; }
	EOF;

// Rule XAnnotationOrExpression
ruleXAnnotationOrExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getXAnnotationOrExpressionAccess().getXAnnotationParserRuleCall_0());
		}
		this_XAnnotation_0=ruleXAnnotation
		{
			$current = $this_XAnnotation_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getXAnnotationOrExpressionAccess().getXExpressionParserRuleCall_1());
		}
		this_XExpression_1=ruleXExpression
		{
			$current = $this_XExpression_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleXExpression
entryRuleXExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXExpressionRule()); }
	iv_ruleXExpression=ruleXExpression
	{ $current=$iv_ruleXExpression.current; }
	EOF;

// Rule XExpression
ruleXExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall());
	}
	this_XAssignment_0=ruleXAssignment
	{
		$current = $this_XAssignment_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleOpSingleAssign
entryRuleOpSingleAssign returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpSingleAssignRule()); }
	iv_ruleOpSingleAssign=ruleOpSingleAssign
	{ $current=$iv_ruleOpSingleAssign.current.getText(); }
	EOF;

// Rule OpSingleAssign
ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	kw='='
	{
		$current.merge(kw);
		newLeafNode(kw, grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword());
	}
;

// Entry rule entryRuleOpMultiAssign
entryRuleOpMultiAssign returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpMultiAssignRule()); }
	iv_ruleOpMultiAssign=ruleOpMultiAssign
	{ $current=$iv_ruleOpMultiAssign.current.getText(); }
	EOF;

// Rule OpMultiAssign
ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='+='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0());
		}
		    |
		kw='-='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1());
		}
		    |
		kw='*='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2());
		}
		    |
		kw='/='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3());
		}
		    |
		kw='%='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4());
		}
		    |
		(
			kw='<'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_5_0());
			}
			kw='<'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_5_1());
			}
			kw='='
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getEqualsSignKeyword_5_2());
			}
		)
		    |
		(
			kw='>'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_6_0());
			}
			(
				kw='>'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_6_1());
				}
			)?
			kw='>='
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignEqualsSignKeyword_6_2());
			}
		)
	)
;

// Entry rule entryRuleXOrExpression
entryRuleXOrExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXOrExpressionRule()); }
	iv_ruleXOrExpression=ruleXOrExpression
	{ $current=$iv_ruleXOrExpression.current; }
	EOF;

// Rule XOrExpression
ruleXOrExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0());
		}
		this_XAndExpression_0=ruleXAndExpression
		{
			$current = $this_XAndExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				((
					(
					)
					(
						(
							ruleOpOr
						)
					)
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
								$current);
						}
					)
					(
						(
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getXOrExpressionRule());
								}
							}
							{
								newCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
							}
							ruleOpOr
							{
								afterParserOrEnumRuleCall();
							}
						)
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0());
					}
					lv_rightOperand_3_0=ruleXAndExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXOrExpressionRule());
						}
						set(
							$current,
							"rightOperand",
							lv_rightOperand_3_0,
							"org.eclipse.xtext.xbase.Xbase.XAndExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleOpOr
entryRuleOpOr returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpOrRule()); }
	iv_ruleOpOr=ruleOpOr
	{ $current=$iv_ruleOpOr.current.getText(); }
	EOF;

// Rule OpOr
ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	kw='||'
	{
		$current.merge(kw);
		newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword());
	}
;

// Entry rule entryRuleXAndExpression
entryRuleXAndExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXAndExpressionRule()); }
	iv_ruleXAndExpression=ruleXAndExpression
	{ $current=$iv_ruleXAndExpression.current; }
	EOF;

// Rule XAndExpression
ruleXAndExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0());
		}
		this_XEqualityExpression_0=ruleXEqualityExpression
		{
			$current = $this_XEqualityExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				((
					(
					)
					(
						(
							ruleOpAnd
						)
					)
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
								$current);
						}
					)
					(
						(
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getXAndExpressionRule());
								}
							}
							{
								newCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
							}
							ruleOpAnd
							{
								afterParserOrEnumRuleCall();
							}
						)
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0());
					}
					lv_rightOperand_3_0=ruleXEqualityExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXAndExpressionRule());
						}
						set(
							$current,
							"rightOperand",
							lv_rightOperand_3_0,
							"org.eclipse.xtext.xbase.Xbase.XEqualityExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleOpAnd
entryRuleOpAnd returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpAndRule()); }
	iv_ruleOpAnd=ruleOpAnd
	{ $current=$iv_ruleOpAnd.current.getText(); }
	EOF;

// Rule OpAnd
ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	kw='&&'
	{
		$current.merge(kw);
		newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword());
	}
;

// Entry rule entryRuleXEqualityExpression
entryRuleXEqualityExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXEqualityExpressionRule()); }
	iv_ruleXEqualityExpression=ruleXEqualityExpression
	{ $current=$iv_ruleXEqualityExpression.current; }
	EOF;

// Rule XEqualityExpression
ruleXEqualityExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0());
		}
		this_XRelationalExpression_0=ruleXRelationalExpression
		{
			$current = $this_XRelationalExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				((
					(
					)
					(
						(
							ruleOpEquality
						)
					)
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
								$current);
						}
					)
					(
						(
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getXEqualityExpressionRule());
								}
							}
							{
								newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
							}
							ruleOpEquality
							{
								afterParserOrEnumRuleCall();
							}
						)
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0());
					}
					lv_rightOperand_3_0=ruleXRelationalExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXEqualityExpressionRule());
						}
						set(
							$current,
							"rightOperand",
							lv_rightOperand_3_0,
							"org.eclipse.xtext.xbase.Xbase.XRelationalExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleOpEquality
entryRuleOpEquality returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpEqualityRule()); }
	iv_ruleOpEquality=ruleOpEquality
	{ $current=$iv_ruleOpEquality.current.getText(); }
	EOF;

// Rule OpEquality
ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='=='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0());
		}
		    |
		kw='!='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1());
		}
		    |
		kw='==='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignEqualsSignKeyword_2());
		}
		    |
		kw='!=='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignEqualsSignKeyword_3());
		}
	)
;

// Entry rule entryRuleXRelationalExpression
entryRuleXRelationalExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXRelationalExpressionRule()); }
	iv_ruleXRelationalExpression=ruleXRelationalExpression
	{ $current=$iv_ruleXRelationalExpression.current; }
	EOF;

// Rule XRelationalExpression
ruleXRelationalExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0());
		}
		this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression
		{
			$current = $this_XOtherOperatorExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				(
					((
						(
						)
						'instanceof'
					)
					)=>
					(
						(
							{
								$current = forceCreateModelElementAndSet(
									grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
									$current);
							}
						)
						otherlv_2='instanceof'
						{
							newLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0_1_0());
						}
						lv_type_3_0=ruleJvmTypeReference
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
							}
							set(
								$current,
								"type",
								lv_type_3_0,
								"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				(
					((
						(
						)
						(
							(
								ruleOpCompare
							)
						)
					)
					)=>
					(
						(
							{
								$current = forceCreateModelElementAndSet(
									grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
									$current);
							}
						)
						(
							(
								{
									if ($current==null) {
										$current = createModelElement(grammarAccess.getXRelationalExpressionRule());
									}
								}
								{
									newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0());
								}
								ruleOpCompare
								{
									afterParserOrEnumRuleCall();
								}
							)
						)
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0());
						}
						lv_rightOperand_6_0=ruleXOtherOperatorExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
							}
							set(
								$current,
								"rightOperand",
								lv_rightOperand_6_0,
								"org.eclipse.xtext.xbase.Xbase.XOtherOperatorExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)*
	)
;

// Entry rule entryRuleOpCompare
entryRuleOpCompare returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpCompareRule()); }
	iv_ruleOpCompare=ruleOpCompare
	{ $current=$iv_ruleOpCompare.current.getText(); }
	EOF;

// Rule OpCompare
ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='>='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0());
		}
		    |
		(
			kw='<'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_1_0());
			}
			kw='='
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getOpCompareAccess().getEqualsSignKeyword_1_1());
			}
		)
		    |
		kw='>'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2());
		}
		    |
		kw='<'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3());
		}
	)
;

// Entry rule entryRuleXOtherOperatorExpression
entryRuleXOtherOperatorExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXOtherOperatorExpressionRule()); }
	iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression
	{ $current=$iv_ruleXOtherOperatorExpression.current; }
	EOF;

// Rule XOtherOperatorExpression
ruleXOtherOperatorExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0());
		}
		this_XAdditiveExpression_0=ruleXAdditiveExpression
		{
			$current = $this_XAdditiveExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				((
					(
					)
					(
						(
							ruleOpOther
						)
					)
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
								$current);
						}
					)
					(
						(
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getXOtherOperatorExpressionRule());
								}
							}
							{
								newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
							}
							ruleOpOther
							{
								afterParserOrEnumRuleCall();
							}
						)
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0());
					}
					lv_rightOperand_3_0=ruleXAdditiveExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXOtherOperatorExpressionRule());
						}
						set(
							$current,
							"rightOperand",
							lv_rightOperand_3_0,
							"org.eclipse.xtext.xbase.Xbase.XAdditiveExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleOpOther
entryRuleOpOther returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpOtherRule()); }
	iv_ruleOpOther=ruleOpOther
	{ $current=$iv_ruleOpOther.current.getText(); }
	EOF;

// Rule OpOther
ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='->'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0());
		}
		    |
		kw='..<'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopLessThanSignKeyword_1());
		}
		    |
		(
			kw='>'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_2_0());
			}
			kw='..'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_2_1());
			}
		)
		    |
		kw='..'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_3());
		}
		    |
		kw='=>'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_4());
		}
		    |
		(
			kw='>'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_0());
			}
			(
				(
					((
						'>'
						'>'
					)
					)=>
					(
						kw='>'
						{
							$current.merge(kw);
							newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_0());
						}
						kw='>'
						{
							$current.merge(kw);
							newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_1());
						}
					)
				)
				    |
				kw='>'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_1());
				}
			)
		)
		    |
		(
			kw='<'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_0());
			}
			(
				(
					((
						'<'
						'<'
					)
					)=>
					(
						kw='<'
						{
							$current.merge(kw);
							newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_0());
						}
						kw='<'
						{
							$current.merge(kw);
							newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_1());
						}
					)
				)
				    |
				kw='<'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_1());
				}
				    |
				kw='=>'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_6_1_2());
				}
			)
		)
		    |
		kw='<>'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_7());
		}
		    |
		kw='?:'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpOtherAccess().getQuestionMarkColonKeyword_8());
		}
	)
;

// Entry rule entryRuleXAdditiveExpression
entryRuleXAdditiveExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXAdditiveExpressionRule()); }
	iv_ruleXAdditiveExpression=ruleXAdditiveExpression
	{ $current=$iv_ruleXAdditiveExpression.current; }
	EOF;

// Rule XAdditiveExpression
ruleXAdditiveExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0());
		}
		this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression
		{
			$current = $this_XMultiplicativeExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				((
					(
					)
					(
						(
							ruleOpAdd
						)
					)
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
								$current);
						}
					)
					(
						(
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
								}
							}
							{
								newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
							}
							ruleOpAdd
							{
								afterParserOrEnumRuleCall();
							}
						)
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0());
					}
					lv_rightOperand_3_0=ruleXMultiplicativeExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXAdditiveExpressionRule());
						}
						set(
							$current,
							"rightOperand",
							lv_rightOperand_3_0,
							"org.eclipse.xtext.xbase.Xbase.XMultiplicativeExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleOpAdd
entryRuleOpAdd returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpAddRule()); }
	iv_ruleOpAdd=ruleOpAdd
	{ $current=$iv_ruleOpAdd.current.getText(); }
	EOF;

// Rule OpAdd
ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='+'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0());
		}
		    |
		kw='-'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1());
		}
	)
;

// Entry rule entryRuleXMultiplicativeExpression
entryRuleXMultiplicativeExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXMultiplicativeExpressionRule()); }
	iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression
	{ $current=$iv_ruleXMultiplicativeExpression.current; }
	EOF;

// Rule XMultiplicativeExpression
ruleXMultiplicativeExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0());
		}
		this_XUnaryOperation_0=ruleXUnaryOperation
		{
			$current = $this_XUnaryOperation_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				((
					(
					)
					(
						(
							ruleOpMulti
						)
					)
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
								$current);
						}
					)
					(
						(
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
								}
							}
							{
								newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
							}
							ruleOpMulti
							{
								afterParserOrEnumRuleCall();
							}
						)
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0());
					}
					lv_rightOperand_3_0=ruleXUnaryOperation
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXMultiplicativeExpressionRule());
						}
						set(
							$current,
							"rightOperand",
							lv_rightOperand_3_0,
							"org.eclipse.xtext.xbase.Xbase.XUnaryOperation");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleOpMulti
entryRuleOpMulti returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpMultiRule()); }
	iv_ruleOpMulti=ruleOpMulti
	{ $current=$iv_ruleOpMulti.current.getText(); }
	EOF;

// Rule OpMulti
ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='*'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0());
		}
		    |
		kw='**'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1());
		}
		    |
		kw='/'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2());
		}
		    |
		kw='%'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMultiAccess().getPercentSignKeyword_3());
		}
	)
;

// Entry rule entryRuleXUnaryOperation
entryRuleXUnaryOperation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXUnaryOperationRule()); }
	iv_ruleXUnaryOperation=ruleXUnaryOperation
	{ $current=$iv_ruleXUnaryOperation.current; }
	EOF;

// Rule XUnaryOperation
ruleXUnaryOperation returns [EObject current=null]
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
					$current = forceCreateModelElement(
						grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
						$current);
				}
			)
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getXUnaryOperationRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0());
					}
					ruleOpUnary
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXUnaryOperationParserRuleCall_0_2_0());
					}
					lv_operand_2_0=ruleXUnaryOperation
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXUnaryOperationRule());
						}
						set(
							$current,
							"operand",
							lv_operand_2_0,
							"org.eclipse.xtext.xbase.Xbase.XUnaryOperation");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		    |
		{
			newCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1());
		}
		this_XCastedExpression_3=ruleXCastedExpression
		{
			$current = $this_XCastedExpression_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleOpUnary
entryRuleOpUnary returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpUnaryRule()); }
	iv_ruleOpUnary=ruleOpUnary
	{ $current=$iv_ruleOpUnary.current.getText(); }
	EOF;

// Rule OpUnary
ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='!'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0());
		}
		    |
		kw='-'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1());
		}
		    |
		kw='+'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2());
		}
	)
;

// Entry rule entryRuleXCastedExpression
entryRuleXCastedExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXCastedExpressionRule()); }
	iv_ruleXCastedExpression=ruleXCastedExpression
	{ $current=$iv_ruleXCastedExpression.current; }
	EOF;

// Rule XCastedExpression
ruleXCastedExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXPostfixOperationParserRuleCall_0());
		}
		this_XPostfixOperation_0=ruleXPostfixOperation
		{
			$current = $this_XPostfixOperation_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				((
					(
					)
					'as'
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(),
								$current);
						}
					)
					otherlv_2='as'
					{
						newLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0());
					}
					lv_type_3_0=ruleJvmTypeReference
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXCastedExpressionRule());
						}
						set(
							$current,
							"type",
							lv_type_3_0,
							"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleXPostfixOperation
entryRuleXPostfixOperation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXPostfixOperationRule()); }
	iv_ruleXPostfixOperation=ruleXPostfixOperation
	{ $current=$iv_ruleXPostfixOperation.current; }
	EOF;

// Rule XPostfixOperation
ruleXPostfixOperation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getXPostfixOperationAccess().getXMemberFeatureCallParserRuleCall_0());
		}
		this_XMemberFeatureCall_0=ruleXMemberFeatureCall
		{
			$current = $this_XMemberFeatureCall_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			((
				(
				)
				(
					(
						ruleOpPostfix
					)
				)
			)
			)=>
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0(),
							$current);
					}
				)
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getXPostfixOperationRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getXPostfixOperationAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_1_0());
						}
						ruleOpPostfix
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)?
	)
;

// Entry rule entryRuleOpPostfix
entryRuleOpPostfix returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpPostfixRule()); }
	iv_ruleOpPostfix=ruleOpPostfix
	{ $current=$iv_ruleOpPostfix.current.getText(); }
	EOF;

// Rule OpPostfix
ruleOpPostfix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='++'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpPostfixAccess().getPlusSignPlusSignKeyword_0());
		}
		    |
		kw='--'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpPostfixAccess().getHyphenMinusHyphenMinusKeyword_1());
		}
	)
;

// Entry rule entryRuleXMemberFeatureCall
entryRuleXMemberFeatureCall returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXMemberFeatureCallRule()); }
	iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall
	{ $current=$iv_ruleXMemberFeatureCall.current; }
	EOF;

// Rule XMemberFeatureCall
ruleXMemberFeatureCall returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0());
		}
		this_XPrimaryExpression_0=ruleXPrimaryExpression
		{
			$current = $this_XPrimaryExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				(
					((
						(
						)
						(
							'.'
							    |
							(
								(
									'::'
								)
							)
						)
						(
							(
								ruleFeatureCallID
							)
						)
						ruleOpSingleAssign
					)
					)=>
					(
						(
							{
								$current = forceCreateModelElementAndSet(
									grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0(),
									$current);
							}
						)
						(
							otherlv_2='.'
							{
								newLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1_0());
							}
							    |
							(
								(
									lv_explicitStatic_3_0='::'
									{
										newLeafNode(lv_explicitStatic_3_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_0_0_0_1_1_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
										}
										setWithLastConsumed($current, "explicitStatic", lv_explicitStatic_3_0 != null, "::");
									}
								)
							)
						)
						(
							(
								{
									if ($current==null) {
										$current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
									}
								}
								{
									newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0());
								}
								ruleFeatureCallID
								{
									afterParserOrEnumRuleCall();
								}
							)
						)
						{
							newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getOpSingleAssignParserRuleCall_1_0_0_0_3());
						}
						ruleOpSingleAssign
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0());
						}
						lv_value_6_0=ruleXAssignment
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
							}
							set(
								$current,
								"value",
								lv_value_6_0,
								"org.eclipse.xtend.core.Xtend.XAssignment");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				(
					((
						(
						)
						(
							'.'
							    |
							(
								(
									'?.'
								)
							)
							    |
							(
								(
									'::'
								)
							)
						)
					)
					)=>
					(
						(
							{
								$current = forceCreateModelElementAndSet(
									grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
									$current);
							}
						)
						(
							otherlv_8='.'
							{
								newLeafNode(otherlv_8, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
							}
							    |
							(
								(
									lv_nullSafe_9_0='?.'
									{
										newLeafNode(lv_nullSafe_9_0, grammarAccess.getXMemberFeatureCallAccess().getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
										}
										setWithLastConsumed($current, "nullSafe", lv_nullSafe_9_0 != null, "?.");
									}
								)
							)
							    |
							(
								(
									lv_explicitStatic_10_0='::'
									{
										newLeafNode(lv_explicitStatic_10_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_1_0_0_1_2_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
										}
										setWithLastConsumed($current, "explicitStatic", lv_explicitStatic_10_0 != null, "::");
									}
								)
							)
						)
					)
				)
				(
					otherlv_11='<'
					{
						newLeafNode(otherlv_11, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0());
							}
							lv_typeArguments_12_0=ruleJvmArgumentTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
								}
								add(
									$current,
									"typeArguments",
									lv_typeArguments_12_0,
									"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_13=','
						{
							newLeafNode(otherlv_13, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0());
								}
								lv_typeArguments_14_0=ruleJvmArgumentTypeReference
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
									}
									add(
										$current,
										"typeArguments",
										lv_typeArguments_14_0,
										"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
					otherlv_15='>'
					{
						newLeafNode(otherlv_15, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
					}
				)?
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0());
						}
						ruleIdOrSuper
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						((
							'('
						)
						)=>
						(
							lv_explicitOperationCall_17_0='('
							{
								newLeafNode(lv_explicitOperationCall_17_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
								}
								setWithLastConsumed($current, "explicitOperationCall", lv_explicitOperationCall_17_0 != null, "(");
							}
						)
					)
					(
						(
							((
								(
								)
								(
									(
										(
											ruleJvmFormalParameter
										)
									)
									(
										','
										(
											(
												ruleJvmFormalParameter
											)
										)
									)*
								)?
								(
									(
										'|'
									)
								)
							)
							)=>
							(
								{
									newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0());
								}
								lv_memberCallArguments_18_0=ruleXShortClosure
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
									}
									add(
										$current,
										"memberCallArguments",
										lv_memberCallArguments_18_0,
										"org.eclipse.xtext.xbase.Xbase.XShortClosure");
									afterParserOrEnumRuleCall();
								}
							)
						)
						    |
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0());
									}
									lv_memberCallArguments_19_0=ruleXExpression
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
										}
										add(
											$current,
											"memberCallArguments",
											lv_memberCallArguments_19_0,
											"org.eclipse.xtext.xbase.Xbase.XExpression");
										afterParserOrEnumRuleCall();
									}
								)
							)
							(
								otherlv_20=','
								{
									newLeafNode(otherlv_20, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0());
										}
										lv_memberCallArguments_21_0=ruleXExpression
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
											}
											add(
												$current,
												"memberCallArguments",
												lv_memberCallArguments_21_0,
												"org.eclipse.xtext.xbase.Xbase.XExpression");
											afterParserOrEnumRuleCall();
										}
									)
								)
							)*
						)
					)?
					otherlv_22=')'
					{
						newLeafNode(otherlv_22, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2());
					}
				)?
				(
					((
						(
						)
						'['
					)
					)=>
					(
						{
							newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0());
						}
						lv_memberCallArguments_23_0=ruleXClosure
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
							}
							add(
								$current,
								"memberCallArguments",
								lv_memberCallArguments_23_0,
								"org.eclipse.xtext.xbase.Xbase.XClosure");
							afterParserOrEnumRuleCall();
						}
					)
				)?
			)
		)*
	)
;

// Entry rule entryRuleXPrimaryExpression
entryRuleXPrimaryExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); }
	iv_ruleXPrimaryExpression=ruleXPrimaryExpression
	{ $current=$iv_ruleXPrimaryExpression.current; }
	EOF;

// Rule XPrimaryExpression
ruleXPrimaryExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0());
		}
		this_XConstructorCall_0=ruleXConstructorCall
		{
			$current = $this_XConstructorCall_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1());
		}
		this_XBlockExpression_1=ruleXBlockExpression
		{
			$current = $this_XBlockExpression_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2());
		}
		this_XSwitchExpression_2=ruleXSwitchExpression
		{
			$current = $this_XSwitchExpression_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		(
			((
				(
				)
				'synchronized'
				'('
			)
			)=>
			{
				newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSynchronizedExpressionParserRuleCall_3());
			}
			this_XSynchronizedExpression_3=ruleXSynchronizedExpression
			{
				$current = $this_XSynchronizedExpression_3.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		{
			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_4());
		}
		this_XFeatureCall_4=ruleXFeatureCall
		{
			$current = $this_XFeatureCall_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_5());
		}
		this_XLiteral_5=ruleXLiteral
		{
			$current = $this_XLiteral_5.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_6());
		}
		this_XIfExpression_6=ruleXIfExpression
		{
			$current = $this_XIfExpression_6.current;
			afterParserOrEnumRuleCall();
		}
		    |
		(
			((
				(
				)
				'for'
				'('
				(
					(
						ruleJvmFormalParameter
					)
				)
				':'
			)
			)=>
			{
				newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_7());
			}
			this_XForLoopExpression_7=ruleXForLoopExpression
			{
				$current = $this_XForLoopExpression_7.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		{
			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBasicForLoopExpressionParserRuleCall_8());
		}
		this_XBasicForLoopExpression_8=ruleXBasicForLoopExpression
		{
			$current = $this_XBasicForLoopExpression_8.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_9());
		}
		this_XWhileExpression_9=ruleXWhileExpression
		{
			$current = $this_XWhileExpression_9.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_10());
		}
		this_XDoWhileExpression_10=ruleXDoWhileExpression
		{
			$current = $this_XDoWhileExpression_10.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_11());
		}
		this_XThrowExpression_11=ruleXThrowExpression
		{
			$current = $this_XThrowExpression_11.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXReturnExpressionParserRuleCall_12());
		}
		this_XReturnExpression_12=ruleXReturnExpression
		{
			$current = $this_XReturnExpression_12.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_13());
		}
		this_XTryCatchFinallyExpression_13=ruleXTryCatchFinallyExpression
		{
			$current = $this_XTryCatchFinallyExpression_13.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_14());
		}
		this_XParenthesizedExpression_14=ruleXParenthesizedExpression
		{
			$current = $this_XParenthesizedExpression_14.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleXLiteral
entryRuleXLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXLiteralRule()); }
	iv_ruleXLiteral=ruleXLiteral
	{ $current=$iv_ruleXLiteral.current; }
	EOF;

// Rule XLiteral
ruleXLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getXLiteralAccess().getXCollectionLiteralParserRuleCall_0());
		}
		this_XCollectionLiteral_0=ruleXCollectionLiteral
		{
			$current = $this_XCollectionLiteral_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		(
			((
				(
				)
				'['
			)
			)=>
			{
				newCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_1());
			}
			this_XClosure_1=ruleXClosure
			{
				$current = $this_XClosure_1.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		{
			newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_2());
		}
		this_XBooleanLiteral_2=ruleXBooleanLiteral
		{
			$current = $this_XBooleanLiteral_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getXLiteralAccess().getXNumberLiteralParserRuleCall_3());
		}
		this_XNumberLiteral_3=ruleXNumberLiteral
		{
			$current = $this_XNumberLiteral_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_4());
		}
		this_XNullLiteral_4=ruleXNullLiteral
		{
			$current = $this_XNullLiteral_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_5());
		}
		this_XStringLiteral_5=ruleXStringLiteral
		{
			$current = $this_XStringLiteral_5.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_6());
		}
		this_XTypeLiteral_6=ruleXTypeLiteral
		{
			$current = $this_XTypeLiteral_6.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleXCollectionLiteral
entryRuleXCollectionLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXCollectionLiteralRule()); }
	iv_ruleXCollectionLiteral=ruleXCollectionLiteral
	{ $current=$iv_ruleXCollectionLiteral.current; }
	EOF;

// Rule XCollectionLiteral
ruleXCollectionLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getXCollectionLiteralAccess().getXSetLiteralParserRuleCall_0());
		}
		this_XSetLiteral_0=ruleXSetLiteral
		{
			$current = $this_XSetLiteral_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getXCollectionLiteralAccess().getXListLiteralParserRuleCall_1());
		}
		this_XListLiteral_1=ruleXListLiteral
		{
			$current = $this_XListLiteral_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleXSetLiteral
entryRuleXSetLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXSetLiteralRule()); }
	iv_ruleXSetLiteral=ruleXSetLiteral
	{ $current=$iv_ruleXSetLiteral.current; }
	EOF;

// Rule XSetLiteral
ruleXSetLiteral returns [EObject current=null]
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
					grammarAccess.getXSetLiteralAccess().getXSetLiteralAction_0(),
					$current);
			}
		)
		otherlv_1='#'
		{
			newLeafNode(otherlv_1, grammarAccess.getXSetLiteralAccess().getNumberSignKeyword_1());
		}
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getXSetLiteralAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0());
					}
					lv_elements_3_0=ruleXExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXSetLiteralRule());
						}
						add(
							$current,
							"elements",
							lv_elements_3_0,
							"org.eclipse.xtext.xbase.Xbase.XExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4=','
				{
					newLeafNode(otherlv_4, grammarAccess.getXSetLiteralAccess().getCommaKeyword_3_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0());
						}
						lv_elements_5_0=ruleXExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXSetLiteralRule());
							}
							add(
								$current,
								"elements",
								lv_elements_5_0,
								"org.eclipse.xtext.xbase.Xbase.XExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getXSetLiteralAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleXListLiteral
entryRuleXListLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXListLiteralRule()); }
	iv_ruleXListLiteral=ruleXListLiteral
	{ $current=$iv_ruleXListLiteral.current; }
	EOF;

// Rule XListLiteral
ruleXListLiteral returns [EObject current=null]
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
					grammarAccess.getXListLiteralAccess().getXListLiteralAction_0(),
					$current);
			}
		)
		otherlv_1='#'
		{
			newLeafNode(otherlv_1, grammarAccess.getXListLiteralAccess().getNumberSignKeyword_1());
		}
		otherlv_2='['
		{
			newLeafNode(otherlv_2, grammarAccess.getXListLiteralAccess().getLeftSquareBracketKeyword_2());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0());
					}
					lv_elements_3_0=ruleXExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXListLiteralRule());
						}
						add(
							$current,
							"elements",
							lv_elements_3_0,
							"org.eclipse.xtext.xbase.Xbase.XExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4=','
				{
					newLeafNode(otherlv_4, grammarAccess.getXListLiteralAccess().getCommaKeyword_3_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0());
						}
						lv_elements_5_0=ruleXExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXListLiteralRule());
							}
							add(
								$current,
								"elements",
								lv_elements_5_0,
								"org.eclipse.xtext.xbase.Xbase.XExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_6=']'
		{
			newLeafNode(otherlv_6, grammarAccess.getXListLiteralAccess().getRightSquareBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleXClosure
entryRuleXClosure returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXClosureRule()); }
	iv_ruleXClosure=ruleXClosure
	{ $current=$iv_ruleXClosure.current; }
	EOF;

// Rule XClosure
ruleXClosure returns [EObject current=null]
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
				'['
			)
			)=>
			(
				(
					{
						$current = forceCreateModelElement(
							grammarAccess.getXClosureAccess().getXClosureAction_0_0_0(),
							$current);
					}
				)
				otherlv_1='['
				{
					newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_0_0_1());
				}
			)
		)
		(
			((
				(
					(
						(
							ruleJvmFormalParameter
						)
					)
					(
						','
						(
							(
								ruleJvmFormalParameter
							)
						)
					)*
				)?
				(
					(
						'|'
					)
				)
			)
			)=>
			(
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0());
							}
							lv_declaredFormalParameters_2_0=ruleJvmFormalParameter
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXClosureRule());
								}
								add(
									$current,
									"declaredFormalParameters",
									lv_declaredFormalParameters_2_0,
									"org.eclipse.xtend.core.Xtend.JvmFormalParameter");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_3=','
						{
							newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_1_0_0_1_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0());
								}
								lv_declaredFormalParameters_4_0=ruleJvmFormalParameter
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getXClosureRule());
									}
									add(
										$current,
										"declaredFormalParameters",
										lv_declaredFormalParameters_4_0,
										"org.eclipse.xtend.core.Xtend.JvmFormalParameter");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)?
				(
					(
						lv_explicitSyntax_5_0='|'
						{
							newLeafNode(lv_explicitSyntax_5_0, grammarAccess.getXClosureAccess().getExplicitSyntaxVerticalLineKeyword_1_0_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getXClosureRule());
							}
							setWithLastConsumed($current, "explicitSyntax", lv_explicitSyntax_5_0 != null, "|");
						}
					)
				)
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionInClosureParserRuleCall_2_0());
				}
				lv_expression_6_0=ruleXExpressionInClosure
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXClosureRule());
					}
					set(
						$current,
						"expression",
						lv_expression_6_0,
						"org.eclipse.xtext.xbase.Xbase.XExpressionInClosure");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_7=']'
		{
			newLeafNode(otherlv_7, grammarAccess.getXClosureAccess().getRightSquareBracketKeyword_3());
		}
	)
;

// Entry rule entryRuleXExpressionInClosure
entryRuleXExpressionInClosure returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXExpressionInClosureRule()); }
	iv_ruleXExpressionInClosure=ruleXExpressionInClosure
	{ $current=$iv_ruleXExpressionInClosure.current; }
	EOF;

// Rule XExpressionInClosure
ruleXExpressionInClosure returns [EObject current=null]
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
					grammarAccess.getXExpressionInClosureAccess().getXBlockExpressionAction_0(),
					$current);
			}
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getXExpressionInClosureAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0());
					}
					lv_expressions_1_0=ruleXExpressionOrVarDeclaration
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXExpressionInClosureRule());
						}
						add(
							$current,
							"expressions",
							lv_expressions_1_0,
							"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_2=';'
				{
					newLeafNode(otherlv_2, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
				}
			)?
		)*
	)
;

// Entry rule entryRuleXShortClosure
entryRuleXShortClosure returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXShortClosureRule()); }
	iv_ruleXShortClosure=ruleXShortClosure
	{ $current=$iv_ruleXShortClosure.current; }
	EOF;

// Rule XShortClosure
ruleXShortClosure returns [EObject current=null]
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
				(
					(
						(
							ruleJvmFormalParameter
						)
					)
					(
						','
						(
							(
								ruleJvmFormalParameter
							)
						)
					)*
				)?
				(
					(
						'|'
					)
				)
			)
			)=>
			(
				(
					{
						$current = forceCreateModelElement(
							grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0(),
							$current);
					}
				)
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0());
							}
							lv_declaredFormalParameters_1_0=ruleJvmFormalParameter
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXShortClosureRule());
								}
								add(
									$current,
									"declaredFormalParameters",
									lv_declaredFormalParameters_1_0,
									"org.eclipse.xtend.core.Xtend.JvmFormalParameter");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_2=','
						{
							newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0());
								}
								lv_declaredFormalParameters_3_0=ruleJvmFormalParameter
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getXShortClosureRule());
									}
									add(
										$current,
										"declaredFormalParameters",
										lv_declaredFormalParameters_3_0,
										"org.eclipse.xtend.core.Xtend.JvmFormalParameter");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)?
				(
					(
						lv_explicitSyntax_4_0='|'
						{
							newLeafNode(lv_explicitSyntax_4_0, grammarAccess.getXShortClosureAccess().getExplicitSyntaxVerticalLineKeyword_0_0_2_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getXShortClosureRule());
							}
							setWithLastConsumed($current, "explicitSyntax", lv_explicitSyntax_4_0 != null, "|");
						}
					)
				)
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0());
				}
				lv_expression_5_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXShortClosureRule());
					}
					set(
						$current,
						"expression",
						lv_expression_5_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleXParenthesizedExpression
entryRuleXParenthesizedExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); }
	iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression
	{ $current=$iv_ruleXParenthesizedExpression.current; }
	EOF;

// Rule XParenthesizedExpression
ruleXParenthesizedExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='('
		{
			newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		}
		{
			newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1());
		}
		this_XExpression_1=ruleXExpression
		{
			$current = $this_XExpression_1.current;
			afterParserOrEnumRuleCall();
		}
		otherlv_2=')'
		{
			newLeafNode(otherlv_2, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
		}
	)
;

// Entry rule entryRuleXIfExpression
entryRuleXIfExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXIfExpressionRule()); }
	iv_ruleXIfExpression=ruleXIfExpression
	{ $current=$iv_ruleXIfExpression.current; }
	EOF;

// Rule XIfExpression
ruleXIfExpression returns [EObject current=null]
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
					grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='if'
		{
			newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
		}
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0());
				}
				lv_if_3_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
					}
					set(
						$current,
						"if",
						lv_if_3_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0());
				}
				lv_then_5_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
					}
					set(
						$current,
						"then",
						lv_then_5_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				('else')=>
				otherlv_6='else'
				{
					newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0());
					}
					lv_else_7_0=ruleXExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
						}
						set(
							$current,
							"else",
							lv_else_7_0,
							"org.eclipse.xtext.xbase.Xbase.XExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleXForLoopExpression
entryRuleXForLoopExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXForLoopExpressionRule()); }
	iv_ruleXForLoopExpression=ruleXForLoopExpression
	{ $current=$iv_ruleXForLoopExpression.current; }
	EOF;

// Rule XForLoopExpression
ruleXForLoopExpression returns [EObject current=null]
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
				'for'
				'('
				(
					(
						ruleJvmFormalParameter
					)
				)
				':'
			)
			)=>
			(
				(
					{
						$current = forceCreateModelElement(
							grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0_0_0(),
							$current);
					}
				)
				otherlv_1='for'
				{
					newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_0_0_1());
				}
				otherlv_2='('
				{
					newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_0_0_2());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0());
						}
						lv_declaredParam_3_0=ruleJvmFormalParameter
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
							}
							set(
								$current,
								"declaredParam",
								lv_declaredParam_3_0,
								"org.eclipse.xtend.core.Xtend.JvmFormalParameter");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_4=':'
				{
					newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_0_0_4());
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_1_0());
				}
				lv_forExpression_5_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
					}
					set(
						$current,
						"forExpression",
						lv_forExpression_5_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6=')'
		{
			newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_3_0());
				}
				lv_eachExpression_7_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
					}
					set(
						$current,
						"eachExpression",
						lv_eachExpression_7_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleXBasicForLoopExpression
entryRuleXBasicForLoopExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXBasicForLoopExpressionRule()); }
	iv_ruleXBasicForLoopExpression=ruleXBasicForLoopExpression
	{ $current=$iv_ruleXBasicForLoopExpression.current; }
	EOF;

// Rule XBasicForLoopExpression
ruleXBasicForLoopExpression returns [EObject current=null]
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
					grammarAccess.getXBasicForLoopExpressionAccess().getXBasicForLoopExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='for'
		{
			newLeafNode(otherlv_1, grammarAccess.getXBasicForLoopExpressionAccess().getForKeyword_1());
		}
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getXBasicForLoopExpressionAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0());
					}
					lv_initExpressions_3_0=ruleXExpressionOrVarDeclaration
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
						}
						add(
							$current,
							"initExpressions",
							lv_initExpressions_3_0,
							"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4=','
				{
					newLeafNode(otherlv_4, grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_3_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0());
						}
						lv_initExpressions_5_0=ruleXExpressionOrVarDeclaration
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
							}
							add(
								$current,
								"initExpressions",
								lv_initExpressions_5_0,
								"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_6=';'
		{
			newLeafNode(otherlv_6, grammarAccess.getXBasicForLoopExpressionAccess().getSemicolonKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getExpressionXExpressionParserRuleCall_5_0());
				}
				lv_expression_7_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
					}
					set(
						$current,
						"expression",
						lv_expression_7_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_8=';'
		{
			newLeafNode(otherlv_8, grammarAccess.getXBasicForLoopExpressionAccess().getSemicolonKeyword_6());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_0_0());
					}
					lv_updateExpressions_9_0=ruleXExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
						}
						add(
							$current,
							"updateExpressions",
							lv_updateExpressions_9_0,
							"org.eclipse.xtext.xbase.Xbase.XExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_10=','
				{
					newLeafNode(otherlv_10, grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_7_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_1_1_0());
						}
						lv_updateExpressions_11_0=ruleXExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
							}
							add(
								$current,
								"updateExpressions",
								lv_updateExpressions_11_0,
								"org.eclipse.xtext.xbase.Xbase.XExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_12=')'
		{
			newLeafNode(otherlv_12, grammarAccess.getXBasicForLoopExpressionAccess().getRightParenthesisKeyword_8());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_9_0());
				}
				lv_eachExpression_13_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
					}
					set(
						$current,
						"eachExpression",
						lv_eachExpression_13_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleXWhileExpression
entryRuleXWhileExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXWhileExpressionRule()); }
	iv_ruleXWhileExpression=ruleXWhileExpression
	{ $current=$iv_ruleXWhileExpression.current; }
	EOF;

// Rule XWhileExpression
ruleXWhileExpression returns [EObject current=null]
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
					grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='while'
		{
			newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
		}
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0());
				}
				lv_predicate_3_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
					}
					set(
						$current,
						"predicate",
						lv_predicate_3_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0());
				}
				lv_body_5_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
					}
					set(
						$current,
						"body",
						lv_body_5_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleXDoWhileExpression
entryRuleXDoWhileExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXDoWhileExpressionRule()); }
	iv_ruleXDoWhileExpression=ruleXDoWhileExpression
	{ $current=$iv_ruleXDoWhileExpression.current; }
	EOF;

// Rule XDoWhileExpression
ruleXDoWhileExpression returns [EObject current=null]
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
					grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='do'
		{
			newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0());
				}
				lv_body_2_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
					}
					set(
						$current,
						"body",
						lv_body_2_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='while'
		{
			newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
		}
		otherlv_4='('
		{
			newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0());
				}
				lv_predicate_5_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
					}
					set(
						$current,
						"predicate",
						lv_predicate_5_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6=')'
		{
			newLeafNode(otherlv_6, grammarAccess.getXDoWhileExpressionAccess().getRightParenthesisKeyword_6());
		}
	)
;

// Entry rule entryRuleXBlockExpression
entryRuleXBlockExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXBlockExpressionRule()); }
	iv_ruleXBlockExpression=ruleXBlockExpression
	{ $current=$iv_ruleXBlockExpression.current; }
	EOF;

// Rule XBlockExpression
ruleXBlockExpression returns [EObject current=null]
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
					grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='{'
		{
			newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0());
					}
					lv_expressions_2_0=ruleXExpressionOrVarDeclaration
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXBlockExpressionRule());
						}
						add(
							$current,
							"expressions",
							lv_expressions_2_0,
							"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_3=';'
				{
					newLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
				}
			)?
		)*
		otherlv_4='}'
		{
			newLeafNode(otherlv_4, grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3());
		}
	)
;

// Entry rule entryRuleXExpressionOrVarDeclaration
entryRuleXExpressionOrVarDeclaration returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXExpressionOrVarDeclarationRule()); }
	iv_ruleXExpressionOrVarDeclaration=ruleXExpressionOrVarDeclaration
	{ $current=$iv_ruleXExpressionOrVarDeclaration.current; }
	EOF;

// Rule XExpressionOrVarDeclaration
ruleXExpressionOrVarDeclaration returns [EObject current=null]
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
				ruleVariableModifier[null]
			)
			)=>
			{
				newCompositeNode(grammarAccess.getXExpressionOrVarDeclarationAccess().getXVariableDeclarationParserRuleCall_0());
			}
			this_XVariableDeclaration_0=ruleXVariableDeclaration
			{
				$current = $this_XVariableDeclaration_0.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		{
			newCompositeNode(grammarAccess.getXExpressionOrVarDeclarationAccess().getXExpressionParserRuleCall_1());
		}
		this_XExpression_1=ruleXExpression
		{
			$current = $this_XExpression_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleXFeatureCall
entryRuleXFeatureCall returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXFeatureCallRule()); }
	iv_ruleXFeatureCall=ruleXFeatureCall
	{ $current=$iv_ruleXFeatureCall.current; }
	EOF;

// Rule XFeatureCall
ruleXFeatureCall returns [EObject current=null]
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
					grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
					$current);
			}
		)
		(
			otherlv_1='<'
			{
				newLeafNode(otherlv_1, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0());
					}
					lv_typeArguments_2_0=ruleJvmArgumentTypeReference
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
						}
						add(
							$current,
							"typeArguments",
							lv_typeArguments_2_0,
							"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_3=','
				{
					newLeafNode(otherlv_3, grammarAccess.getXFeatureCallAccess().getCommaKeyword_1_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0());
						}
						lv_typeArguments_4_0=ruleJvmArgumentTypeReference
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
							}
							add(
								$current,
								"typeArguments",
								lv_typeArguments_4_0,
								"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_5='>'
			{
				newLeafNode(otherlv_5, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_1_3());
			}
		)?
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getXFeatureCallRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_2_0());
				}
				ruleIdOrSuper
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				((
					'('
				)
				)=>
				(
					lv_explicitOperationCall_7_0='('
					{
						newLeafNode(lv_explicitOperationCall_7_0, grammarAccess.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_3_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getXFeatureCallRule());
						}
						setWithLastConsumed($current, "explicitOperationCall", lv_explicitOperationCall_7_0 != null, "(");
					}
				)
			)
			(
				(
					((
						(
						)
						(
							(
								(
									ruleJvmFormalParameter
								)
							)
							(
								','
								(
									(
										ruleJvmFormalParameter
									)
								)
							)*
						)?
						(
							(
								'|'
							)
						)
					)
					)=>
					(
						{
							newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0());
						}
						lv_featureCallArguments_8_0=ruleXShortClosure
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
							}
							add(
								$current,
								"featureCallArguments",
								lv_featureCallArguments_8_0,
								"org.eclipse.xtext.xbase.Xbase.XShortClosure");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0());
							}
							lv_featureCallArguments_9_0=ruleXExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
								}
								add(
									$current,
									"featureCallArguments",
									lv_featureCallArguments_9_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_10=','
						{
							newLeafNode(otherlv_10, grammarAccess.getXFeatureCallAccess().getCommaKeyword_3_1_1_1_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0());
								}
								lv_featureCallArguments_11_0=ruleXExpression
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
									}
									add(
										$current,
										"featureCallArguments",
										lv_featureCallArguments_11_0,
										"org.eclipse.xtext.xbase.Xbase.XExpression");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)
			)?
			otherlv_12=')'
			{
				newLeafNode(otherlv_12, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_3_2());
			}
		)?
		(
			((
				(
				)
				'['
			)
			)=>
			(
				{
					newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXClosureParserRuleCall_4_0());
				}
				lv_featureCallArguments_13_0=ruleXClosure
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
					}
					add(
						$current,
						"featureCallArguments",
						lv_featureCallArguments_13_0,
						"org.eclipse.xtext.xbase.Xbase.XClosure");
					afterParserOrEnumRuleCall();
				}
			)
		)?
	)
;

// Entry rule entryRuleIdOrSuper
entryRuleIdOrSuper returns [String current=null]:
	{ newCompositeNode(grammarAccess.getIdOrSuperRule()); }
	iv_ruleIdOrSuper=ruleIdOrSuper
	{ $current=$iv_ruleIdOrSuper.current.getText(); }
	EOF;

// Rule IdOrSuper
ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getIdOrSuperAccess().getFeatureCallIDParserRuleCall_0());
		}
		this_FeatureCallID_0=ruleFeatureCallID
		{
			$current.merge(this_FeatureCallID_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		kw='super'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getIdOrSuperAccess().getSuperKeyword_1());
		}
	)
;

// Entry rule entryRuleXBooleanLiteral
entryRuleXBooleanLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXBooleanLiteralRule()); }
	iv_ruleXBooleanLiteral=ruleXBooleanLiteral
	{ $current=$iv_ruleXBooleanLiteral.current; }
	EOF;

// Rule XBooleanLiteral
ruleXBooleanLiteral returns [EObject current=null]
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
					grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
					$current);
			}
		)
		(
			otherlv_1='false'
			{
				newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
			}
			    |
			(
				(
					lv_isTrue_2_0='true'
					{
						newLeafNode(lv_isTrue_2_0, grammarAccess.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getXBooleanLiteralRule());
						}
						setWithLastConsumed($current, "isTrue", lv_isTrue_2_0 != null, "true");
					}
				)
			)
		)
	)
;

// Entry rule entryRuleXNullLiteral
entryRuleXNullLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXNullLiteralRule()); }
	iv_ruleXNullLiteral=ruleXNullLiteral
	{ $current=$iv_ruleXNullLiteral.current; }
	EOF;

// Rule XNullLiteral
ruleXNullLiteral returns [EObject current=null]
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
					grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
					$current);
			}
		)
		otherlv_1='null'
		{
			newLeafNode(otherlv_1, grammarAccess.getXNullLiteralAccess().getNullKeyword_1());
		}
	)
;

// Entry rule entryRuleXNumberLiteral
entryRuleXNumberLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXNumberLiteralRule()); }
	iv_ruleXNumberLiteral=ruleXNumberLiteral
	{ $current=$iv_ruleXNumberLiteral.current; }
	EOF;

// Rule XNumberLiteral
ruleXNumberLiteral returns [EObject current=null]
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
					grammarAccess.getXNumberLiteralAccess().getXNumberLiteralAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getXNumberLiteralAccess().getValueNumberParserRuleCall_1_0());
				}
				lv_value_1_0=ruleNumber
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXNumberLiteralRule());
					}
					set(
						$current,
						"value",
						lv_value_1_0,
						"org.eclipse.xtext.xbase.Xbase.Number");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleXTypeLiteral
entryRuleXTypeLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXTypeLiteralRule()); }
	iv_ruleXTypeLiteral=ruleXTypeLiteral
	{ $current=$iv_ruleXTypeLiteral.current; }
	EOF;

// Rule XTypeLiteral
ruleXTypeLiteral returns [EObject current=null]
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
					grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
					$current);
			}
		)
		otherlv_1='typeof'
		{
			newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
		}
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getXTypeLiteralRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0());
				}
				ruleQualifiedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getXTypeLiteralAccess().getArrayDimensionsArrayBracketsParserRuleCall_4_0());
				}
				lv_arrayDimensions_4_0=ruleArrayBrackets
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXTypeLiteralRule());
					}
					add(
						$current,
						"arrayDimensions",
						lv_arrayDimensions_4_0,
						"org.eclipse.xtext.xbase.Xtype.ArrayBrackets");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_5=')'
		{
			newLeafNode(otherlv_5, grammarAccess.getXTypeLiteralAccess().getRightParenthesisKeyword_5());
		}
	)
;

// Entry rule entryRuleXThrowExpression
entryRuleXThrowExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXThrowExpressionRule()); }
	iv_ruleXThrowExpression=ruleXThrowExpression
	{ $current=$iv_ruleXThrowExpression.current; }
	EOF;

// Rule XThrowExpression
ruleXThrowExpression returns [EObject current=null]
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
					grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='throw'
		{
			newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0());
				}
				lv_expression_2_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXThrowExpressionRule());
					}
					set(
						$current,
						"expression",
						lv_expression_2_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleXReturnExpression
entryRuleXReturnExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXReturnExpressionRule()); }
	iv_ruleXReturnExpression=ruleXReturnExpression
	{ $current=$iv_ruleXReturnExpression.current; }
	EOF;

// Rule XReturnExpression
ruleXReturnExpression returns [EObject current=null]
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
					grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='return'
		{
			newLeafNode(otherlv_1, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1());
		}
		(
			('abstract' | 'annotation' | 'class' | 'create' | 'def' | 'dispatch' | 'enum' | 'extends' | 'final' | 'implements' | 'import' | 'interface' | 'override' | 'package' | 'public' | 'private' | 'protected' | 'static' | 'throws' | 'strictfp' | 'native' | 'volatile' | 'synchronized' | 'transient' | 'AFTER' | 'BEFORE' | 'SEPARATOR' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING | RULE_RICH_TEXT | RULE_RICH_TEXT_START)=>
			(
				{
					newCompositeNode(grammarAccess.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0());
				}
				lv_expression_2_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXReturnExpressionRule());
					}
					set(
						$current,
						"expression",
						lv_expression_2_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)?
	)
;

// Entry rule entryRuleXSynchronizedExpression
entryRuleXSynchronizedExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXSynchronizedExpressionRule()); }
	iv_ruleXSynchronizedExpression=ruleXSynchronizedExpression
	{ $current=$iv_ruleXSynchronizedExpression.current; }
	EOF;

// Rule XSynchronizedExpression
ruleXSynchronizedExpression returns [EObject current=null]
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
				'synchronized'
				'('
			)
			)=>
			(
				(
					{
						$current = forceCreateModelElement(
							grammarAccess.getXSynchronizedExpressionAccess().getXSynchronizedExpressionAction_0_0_0(),
							$current);
					}
				)
				otherlv_1='synchronized'
				{
					newLeafNode(otherlv_1, grammarAccess.getXSynchronizedExpressionAccess().getSynchronizedKeyword_0_0_1());
				}
				otherlv_2='('
				{
					newLeafNode(otherlv_2, grammarAccess.getXSynchronizedExpressionAccess().getLeftParenthesisKeyword_0_0_2());
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getXSynchronizedExpressionAccess().getParamXExpressionParserRuleCall_1_0());
				}
				lv_param_3_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXSynchronizedExpressionRule());
					}
					set(
						$current,
						"param",
						lv_param_3_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getXSynchronizedExpressionAccess().getRightParenthesisKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXSynchronizedExpressionAccess().getExpressionXExpressionParserRuleCall_3_0());
				}
				lv_expression_5_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXSynchronizedExpressionRule());
					}
					set(
						$current,
						"expression",
						lv_expression_5_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleXCatchClause
entryRuleXCatchClause returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXCatchClauseRule()); }
	iv_ruleXCatchClause=ruleXCatchClause
	{ $current=$iv_ruleXCatchClause.current; }
	EOF;

// Rule XCatchClause
ruleXCatchClause returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			('catch')=>
			otherlv_0='catch'
			{
				newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
			}
		)
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0());
				}
				lv_declaredParam_2_0=ruleFullJvmFormalParameter
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
					}
					set(
						$current,
						"declaredParam",
						lv_declaredParam_2_0,
						"org.eclipse.xtend.core.Xtend.FullJvmFormalParameter");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=')'
		{
			newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0());
				}
				lv_expression_4_0=ruleXExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
					}
					set(
						$current,
						"expression",
						lv_expression_4_0,
						"org.eclipse.xtext.xbase.Xbase.XExpression");
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
			(
				('.')=>
				kw='.'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
				}
			)
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

// Entry rule entryRuleNumber
entryRuleNumber returns [String current=null]@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	{ newCompositeNode(grammarAccess.getNumberRule()); }
	iv_ruleNumber=ruleNumber
	{ $current=$iv_ruleNumber.current.getText(); }
	EOF;
finally {
	myHiddenTokenState.restore();
}

// Rule Number
ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
@after {
	leaveRule();
}:
	(
		this_HEX_0=RULE_HEX
		{
			$current.merge(this_HEX_0);
		}
		{
			newLeafNode(this_HEX_0, grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0());
		}
		    |
		(
			(
				this_INT_1=RULE_INT
				{
					$current.merge(this_INT_1);
				}
				{
					newLeafNode(this_INT_1, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_0_0());
				}
				    |
				this_DECIMAL_2=RULE_DECIMAL
				{
					$current.merge(this_DECIMAL_2);
				}
				{
					newLeafNode(this_DECIMAL_2, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_0_1());
				}
			)
			(
				kw='.'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_1_1_0());
				}
				(
					this_INT_4=RULE_INT
					{
						$current.merge(this_INT_4);
					}
					{
						newLeafNode(this_INT_4, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1_1_0());
					}
					    |
					this_DECIMAL_5=RULE_DECIMAL
					{
						$current.merge(this_DECIMAL_5);
					}
					{
						newLeafNode(this_DECIMAL_5, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_1_1_1());
					}
				)
			)?
		)
	)
;
finally {
	myHiddenTokenState.restore();
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

// Entry rule entryRuleJvmTypeParameter
entryRuleJvmTypeParameter returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJvmTypeParameterRule()); }
	iv_ruleJvmTypeParameter=ruleJvmTypeParameter
	{ $current=$iv_ruleJvmTypeParameter.current; }
	EOF;

// Rule JvmTypeParameter
ruleJvmTypeParameter returns [EObject current=null]
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
					newCompositeNode(grammarAccess.getJvmTypeParameterAccess().getNameValidIDParserRuleCall_0_0());
				}
				lv_name_0_0=ruleValidID
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJvmTypeParameterRule());
					}
					set(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtend.core.Xtend.ValidID");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getJvmTypeParameterAccess().getConstraintsJvmUpperBoundParserRuleCall_1_0_0());
					}
					lv_constraints_1_0=ruleJvmUpperBound
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getJvmTypeParameterRule());
						}
						add(
							$current,
							"constraints",
							lv_constraints_1_0,
							"org.eclipse.xtext.xbase.Xtype.JvmUpperBound");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getJvmTypeParameterAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0());
					}
					lv_constraints_2_0=ruleJvmUpperBoundAnded
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getJvmTypeParameterRule());
						}
						add(
							$current,
							"constraints",
							lv_constraints_2_0,
							"org.eclipse.xtext.xbase.Xtype.JvmUpperBoundAnded");
						afterParserOrEnumRuleCall();
					}
				)
			)*
		)?
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

// Entry rule entryRuleXImportSection
entryRuleXImportSection returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXImportSectionRule()); }
	iv_ruleXImportSection=ruleXImportSection
	{ $current=$iv_ruleXImportSection.current; }
	EOF;

// Rule XImportSection
ruleXImportSection returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getXImportSectionAccess().getImportDeclarationsXImportDeclarationParserRuleCall_0());
			}
			lv_importDeclarations_0_0=ruleXImportDeclaration
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getXImportSectionRule());
				}
				add(
					$current,
					"importDeclarations",
					lv_importDeclarations_0_0,
					"org.eclipse.xtext.xbase.Xtype.XImportDeclaration");
				afterParserOrEnumRuleCall();
			}
		)
	)+
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
									"org.eclipse.xtend.core.Xtend.ValidID");
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

RULE_ID : '^'? (RULE_IDENTIFIER_START|RULE_UNICODE_ESCAPE) (RULE_IDENTIFIER_PART|RULE_UNICODE_ESCAPE)*;

fragment RULE_HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F');

fragment RULE_UNICODE_ESCAPE : '\\' 'u' (RULE_HEX_DIGIT (RULE_HEX_DIGIT (RULE_HEX_DIGIT RULE_HEX_DIGIT?)?)?)?;

RULE_RICH_TEXT : '\'\'\'' RULE_IN_RICH_STRING* ('\'\'\''|('\'' '\''?)? EOF);

RULE_RICH_TEXT_START : '\'\'\'' RULE_IN_RICH_STRING* ('\'' '\''?)? '\u00AB';

RULE_RICH_TEXT_END : '\u00BB' RULE_IN_RICH_STRING* ('\'\'\''|('\'' '\''?)? EOF);

RULE_RICH_TEXT_INBETWEEN : '\u00BB' RULE_IN_RICH_STRING* ('\'' '\''?)? '\u00AB';

RULE_COMMENT_RICH_TEXT_INBETWEEN : '\u00AB\u00AB' ~(('\n'|'\r'))* ('\r'? '\n' RULE_IN_RICH_STRING* ('\'' '\''?)? '\u00AB')?;

RULE_COMMENT_RICH_TEXT_END : '\u00AB\u00AB' ~(('\n'|'\r'))* ('\r'? '\n' RULE_IN_RICH_STRING* ('\'\'\''|('\'' '\''?)? EOF)|EOF);

fragment RULE_IN_RICH_STRING : ('\'\'' ~(('\u00AB'|'\''))|'\'' ~(('\u00AB'|'\''))|~(('\u00AB'|'\'')));

fragment RULE_IDENTIFIER_START : ('$'|'A'..'Z'|'_'|'a'..'z'|'\u00A2'..'\u00A5'|'\u00AA'|'\u00B5'|'\u00BA'|'\u00C0'..'\u00D6'|'\u00D8'..'\u00F6'|'\u00F8'..'\u0236'|'\u0250'..'\u02C1'|'\u02C6'..'\u02D1'|'\u02E0'..'\u02E4'|'\u02EE'|'\u037A'|'\u0386'|'\u0388'..'\u038A'|'\u038C'|'\u038E'..'\u03A1'|'\u03A3'..'\u03CE'|'\u03D0'..'\u03F5'|'\u03F7'..'\u03FB'|'\u0400'..'\u0481'|'\u048A'..'\u04CE'|'\u04D0'..'\u04F5'|'\u04F8'..'\u04F9'|'\u0500'..'\u050F'|'\u0531'..'\u0556'|'\u0559'|'\u0561'..'\u0587'|'\u05D0'..'\u05EA'|'\u05F0'..'\u05F2'|'\u0621'..'\u063A'|'\u0640'..'\u064A'|'\u066E'..'\u066F'|'\u0671'..'\u06D3'|'\u06D5'|'\u06E5'..'\u06E6'|'\u06EE'..'\u06EF'|'\u06FA'..'\u06FC'|'\u06FF'|'\u0710'|'\u0712'..'\u072F'|'\u074D'..'\u074F'|'\u0780'..'\u07A5'|'\u07B1'|'\u0904'..'\u0939'|'\u093D'|'\u0950'|'\u0958'..'\u0961'|'\u0985'..'\u098C'|'\u098F'..'\u0990'|'\u0993'..'\u09A8'|'\u09AA'..'\u09B0'|'\u09B2'|'\u09B6'..'\u09B9'|'\u09BD'|'\u09DC'..'\u09DD'|'\u09DF'..'\u09E1'|'\u09F0'..'\u09F3'|'\u0A05'..'\u0A0A'|'\u0A0F'..'\u0A10'|'\u0A13'..'\u0A28'|'\u0A2A'..'\u0A30'|'\u0A32'..'\u0A33'|'\u0A35'..'\u0A36'|'\u0A38'..'\u0A39'|'\u0A59'..'\u0A5C'|'\u0A5E'|'\u0A72'..'\u0A74'|'\u0A85'..'\u0A8D'|'\u0A8F'..'\u0A91'|'\u0A93'..'\u0AA8'|'\u0AAA'..'\u0AB0'|'\u0AB2'..'\u0AB3'|'\u0AB5'..'\u0AB9'|'\u0ABD'|'\u0AD0'|'\u0AE0'..'\u0AE1'|'\u0AF1'|'\u0B05'..'\u0B0C'|'\u0B0F'..'\u0B10'|'\u0B13'..'\u0B28'|'\u0B2A'..'\u0B30'|'\u0B32'..'\u0B33'|'\u0B35'..'\u0B39'|'\u0B3D'|'\u0B5C'..'\u0B5D'|'\u0B5F'..'\u0B61'|'\u0B71'|'\u0B83'|'\u0B85'..'\u0B8A'|'\u0B8E'..'\u0B90'|'\u0B92'..'\u0B95'|'\u0B99'..'\u0B9A'|'\u0B9C'|'\u0B9E'..'\u0B9F'|'\u0BA3'..'\u0BA4'|'\u0BA8'..'\u0BAA'|'\u0BAE'..'\u0BB5'|'\u0BB7'..'\u0BB9'|'\u0BF9'|'\u0C05'..'\u0C0C'|'\u0C0E'..'\u0C10'|'\u0C12'..'\u0C28'|'\u0C2A'..'\u0C33'|'\u0C35'..'\u0C39'|'\u0C60'..'\u0C61'|'\u0C85'..'\u0C8C'|'\u0C8E'..'\u0C90'|'\u0C92'..'\u0CA8'|'\u0CAA'..'\u0CB3'|'\u0CB5'..'\u0CB9'|'\u0CBD'|'\u0CDE'|'\u0CE0'..'\u0CE1'|'\u0D05'..'\u0D0C'|'\u0D0E'..'\u0D10'|'\u0D12'..'\u0D28'|'\u0D2A'..'\u0D39'|'\u0D60'..'\u0D61'|'\u0D85'..'\u0D96'|'\u0D9A'..'\u0DB1'|'\u0DB3'..'\u0DBB'|'\u0DBD'|'\u0DC0'..'\u0DC6'|'\u0E01'..'\u0E30'|'\u0E32'..'\u0E33'|'\u0E3F'..'\u0E46'|'\u0E81'..'\u0E82'|'\u0E84'|'\u0E87'..'\u0E88'|'\u0E8A'|'\u0E8D'|'\u0E94'..'\u0E97'|'\u0E99'..'\u0E9F'|'\u0EA1'..'\u0EA3'|'\u0EA5'|'\u0EA7'|'\u0EAA'..'\u0EAB'|'\u0EAD'..'\u0EB0'|'\u0EB2'..'\u0EB3'|'\u0EBD'|'\u0EC0'..'\u0EC4'|'\u0EC6'|'\u0EDC'..'\u0EDD'|'\u0F00'|'\u0F40'..'\u0F47'|'\u0F49'..'\u0F6A'|'\u0F88'..'\u0F8B'|'\u1000'..'\u1021'|'\u1023'..'\u1027'|'\u1029'..'\u102A'|'\u1050'..'\u1055'|'\u10A0'..'\u10C5'|'\u10D0'..'\u10F8'|'\u1100'..'\u1159'|'\u115F'..'\u11A2'|'\u11A8'..'\u11F9'|'\u1200'..'\u1206'|'\u1208'..'\u1246'|'\u1248'|'\u124A'..'\u124D'|'\u1250'..'\u1256'|'\u1258'|'\u125A'..'\u125D'|'\u1260'..'\u1286'|'\u1288'|'\u128A'..'\u128D'|'\u1290'..'\u12AE'|'\u12B0'|'\u12B2'..'\u12B5'|'\u12B8'..'\u12BE'|'\u12C0'|'\u12C2'..'\u12C5'|'\u12C8'..'\u12CE'|'\u12D0'..'\u12D6'|'\u12D8'..'\u12EE'|'\u12F0'..'\u130E'|'\u1310'|'\u1312'..'\u1315'|'\u1318'..'\u131E'|'\u1320'..'\u1346'|'\u1348'..'\u135A'|'\u13A0'..'\u13F4'|'\u1401'..'\u166C'|'\u166F'..'\u1676'|'\u1681'..'\u169A'|'\u16A0'..'\u16EA'|'\u16EE'..'\u16F0'|'\u1700'..'\u170C'|'\u170E'..'\u1711'|'\u1720'..'\u1731'|'\u1740'..'\u1751'|'\u1760'..'\u176C'|'\u176E'..'\u1770'|'\u1780'..'\u17B3'|'\u17D7'|'\u17DB'..'\u17DC'|'\u1820'..'\u1877'|'\u1880'..'\u18A8'|'\u1900'..'\u191C'|'\u1950'..'\u196D'|'\u1970'..'\u1974'|'\u1D00'..'\u1D6B'|'\u1E00'..'\u1E9B'|'\u1EA0'..'\u1EF9'|'\u1F00'..'\u1F15'|'\u1F18'..'\u1F1D'|'\u1F20'..'\u1F45'|'\u1F48'..'\u1F4D'|'\u1F50'..'\u1F57'|'\u1F59'|'\u1F5B'|'\u1F5D'|'\u1F5F'..'\u1F7D'|'\u1F80'..'\u1FB4'|'\u1FB6'..'\u1FBC'|'\u1FBE'|'\u1FC2'..'\u1FC4'|'\u1FC6'..'\u1FCC'|'\u1FD0'..'\u1FD3'|'\u1FD6'..'\u1FDB'|'\u1FE0'..'\u1FEC'|'\u1FF2'..'\u1FF4'|'\u1FF6'..'\u1FFC'|'\u203F'..'\u2040'|'\u2054'|'\u2071'|'\u207F'|'\u20A0'..'\u20B1'|'\u2102'|'\u2107'|'\u210A'..'\u2113'|'\u2115'|'\u2119'..'\u211D'|'\u2124'|'\u2126'|'\u2128'|'\u212A'..'\u212D'|'\u212F'..'\u2131'|'\u2133'..'\u2139'|'\u213D'..'\u213F'|'\u2145'..'\u2149'|'\u2160'..'\u2183'|'\u3005'..'\u3007'|'\u3021'..'\u3029'|'\u3031'..'\u3035'|'\u3038'..'\u303C'|'\u3041'..'\u3096'|'\u309D'..'\u309F'|'\u30A1'..'\u30FF'|'\u3105'..'\u312C'|'\u3131'..'\u318E'|'\u31A0'..'\u31B7'|'\u31F0'..'\u31FF'|'\u3400'..'\u4DB5'|'\u4E00'..'\u9FA5'|'\uA000'..'\uA48C'|'\uAC00'..'\uD7A3'|'\uF900'..'\uFA2D'|'\uFA30'..'\uFA6A'|'\uFB00'..'\uFB06'|'\uFB13'..'\uFB17'|'\uFB1D'|'\uFB1F'..'\uFB28'|'\uFB2A'..'\uFB36'|'\uFB38'..'\uFB3C'|'\uFB3E'|'\uFB40'..'\uFB41'|'\uFB43'..'\uFB44'|'\uFB46'..'\uFBB1'|'\uFBD3'..'\uFD3D'|'\uFD50'..'\uFD8F'|'\uFD92'..'\uFDC7'|'\uFDF0'..'\uFDFC'|'\uFE33'..'\uFE34'|'\uFE4D'..'\uFE4F'|'\uFE69'|'\uFE70'..'\uFE74'|'\uFE76'..'\uFEFC'|'\uFF04'|'\uFF21'..'\uFF3A'|'\uFF3F'|'\uFF41'..'\uFF5A'|'\uFF65'..'\uFFBE'|'\uFFC2'..'\uFFC7'|'\uFFCA'..'\uFFCF'|'\uFFD2'..'\uFFD7'|'\uFFDA'..'\uFFDC'|'\uFFE0'..'\uFFE1'|'\uFFE5'..'\uFFE6');

fragment RULE_IDENTIFIER_PART : (RULE_IDENTIFIER_START|RULE_IDENTIFIER_PART_IMPL);

fragment RULE_IDENTIFIER_PART_IMPL : ('\u0000'..'\b'|'\u000E'..'\u001B'|'0'..'9'|'\u007F'..'\u009F'|'\u00AD'|'\u0300'..'\u0357'|'\u035D'..'\u036F'|'\u0483'..'\u0486'|'\u0591'..'\u05A1'|'\u05A3'..'\u05B9'|'\u05BB'..'\u05BD'|'\u05BF'|'\u05C1'..'\u05C2'|'\u05C4'|'\u0600'..'\u0603'|'\u0610'..'\u0615'|'\u064B'..'\u0658'|'\u0660'..'\u0669'|'\u0670'|'\u06D6'..'\u06DD'|'\u06DF'..'\u06E4'|'\u06E7'..'\u06E8'|'\u06EA'..'\u06ED'|'\u06F0'..'\u06F9'|'\u070F'|'\u0711'|'\u0730'..'\u074A'|'\u07A6'..'\u07B0'|'\u0901'..'\u0903'|'\u093C'|'\u093E'..'\u094D'|'\u0951'..'\u0954'|'\u0962'..'\u0963'|'\u0966'..'\u096F'|'\u0981'..'\u0983'|'\u09BC'|'\u09BE'..'\u09C4'|'\u09C7'..'\u09C8'|'\u09CB'..'\u09CD'|'\u09D7'|'\u09E2'..'\u09E3'|'\u09E6'..'\u09EF'|'\u0A01'..'\u0A03'|'\u0A3C'|'\u0A3E'..'\u0A42'|'\u0A47'..'\u0A48'|'\u0A4B'..'\u0A4D'|'\u0A66'..'\u0A71'|'\u0A81'..'\u0A83'|'\u0ABC'|'\u0ABE'..'\u0AC5'|'\u0AC7'..'\u0AC9'|'\u0ACB'..'\u0ACD'|'\u0AE2'..'\u0AE3'|'\u0AE6'..'\u0AEF'|'\u0B01'..'\u0B03'|'\u0B3C'|'\u0B3E'..'\u0B43'|'\u0B47'..'\u0B48'|'\u0B4B'..'\u0B4D'|'\u0B56'..'\u0B57'|'\u0B66'..'\u0B6F'|'\u0B82'|'\u0BBE'..'\u0BC2'|'\u0BC6'..'\u0BC8'|'\u0BCA'..'\u0BCD'|'\u0BD7'|'\u0BE7'..'\u0BEF'|'\u0C01'..'\u0C03'|'\u0C3E'..'\u0C44'|'\u0C46'..'\u0C48'|'\u0C4A'..'\u0C4D'|'\u0C55'..'\u0C56'|'\u0C66'..'\u0C6F'|'\u0C82'..'\u0C83'|'\u0CBC'|'\u0CBE'..'\u0CC4'|'\u0CC6'..'\u0CC8'|'\u0CCA'..'\u0CCD'|'\u0CD5'..'\u0CD6'|'\u0CE6'..'\u0CEF'|'\u0D02'..'\u0D03'|'\u0D3E'..'\u0D43'|'\u0D46'..'\u0D48'|'\u0D4A'..'\u0D4D'|'\u0D57'|'\u0D66'..'\u0D6F'|'\u0D82'..'\u0D83'|'\u0DCA'|'\u0DCF'..'\u0DD4'|'\u0DD6'|'\u0DD8'..'\u0DDF'|'\u0DF2'..'\u0DF3'|'\u0E31'|'\u0E34'..'\u0E3A'|'\u0E47'..'\u0E4E'|'\u0E50'..'\u0E59'|'\u0EB1'|'\u0EB4'..'\u0EB9'|'\u0EBB'..'\u0EBC'|'\u0EC8'..'\u0ECD'|'\u0ED0'..'\u0ED9'|'\u0F18'..'\u0F19'|'\u0F20'..'\u0F29'|'\u0F35'|'\u0F37'|'\u0F39'|'\u0F3E'..'\u0F3F'|'\u0F71'..'\u0F84'|'\u0F86'..'\u0F87'|'\u0F90'..'\u0F97'|'\u0F99'..'\u0FBC'|'\u0FC6'|'\u102C'..'\u1032'|'\u1036'..'\u1039'|'\u1040'..'\u1049'|'\u1056'..'\u1059'|'\u1369'..'\u1371'|'\u1712'..'\u1714'|'\u1732'..'\u1734'|'\u1752'..'\u1753'|'\u1772'..'\u1773'|'\u17B4'..'\u17D3'|'\u17DD'|'\u17E0'..'\u17E9'|'\u180B'..'\u180D'|'\u1810'..'\u1819'|'\u18A9'|'\u1920'..'\u192B'|'\u1930'..'\u193B'|'\u1946'..'\u194F'|'\u200C'..'\u200F'|'\u202A'..'\u202E'|'\u2060'..'\u2063'|'\u206A'..'\u206F'|'\u20D0'..'\u20DC'|'\u20E1'|'\u20E5'..'\u20EA'|'\u302A'..'\u302F'|'\u3099'..'\u309A'|'\uFB1E'|'\uFE00'..'\uFE0F'|'\uFE20'..'\uFE23'|'\uFEFF'|'\uFF10'..'\uFF19'|'\uFFF9'..'\uFFFB');

RULE_HEX : ('0x'|'0X') ('0'..'9'|'a'..'f'|'A'..'F'|'_')+ ('#' (('b'|'B') ('i'|'I')|('l'|'L')))?;

RULE_INT : '0'..'9' ('0'..'9'|'_')*;

RULE_DECIMAL : RULE_INT (('e'|'E') ('+'|'-')? RULE_INT)? (('b'|'B') ('i'|'I'|'d'|'D')|('l'|'L'|'d'|'D'|'f'|'F'))?;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'?|'\'' ('\\' .|~(('\\'|'\'')))* '\''?);

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
