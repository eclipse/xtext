/*******************************************************************************
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
grammar PsiInternalXtend;
options {
	superClass=AbstractPsiAntlrParser;
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
	KW_Switch = 'switch' ;
	KW_Default = 'default' ;
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
	KW_VerticalLine = '|' ;
	KW_If = 'if' ;
	KW_Else = 'else' ;
	KW_Case = 'case' ;
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
	KW_Try = 'try' ;
	KW_Finally = 'finally' ;
	KW_Catch = 'catch' ;
	KW_QuestionMark = '?' ;
	KW_Ampersand = '&' ;
}

@lexer::header {
package org.eclipse.xtend.core.idea.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtend.core.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtend.core.idea.lang.XtendElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtend.core.services.XtendGrammarAccess;

import com.intellij.lang.PsiBuilder;
}

@parser::members {

	protected XtendGrammarAccess grammarAccess;

	protected XtendElementTypeProvider elementTypeProvider;

	public PsiInternalXtendParser(PsiBuilder builder, TokenStream input, XtendElementTypeProvider elementTypeProvider, XtendGrammarAccess grammarAccess) {
		this(input);
		setPsiBuilder(builder);
    	this.grammarAccess = grammarAccess;
		this.elementTypeProvider = elementTypeProvider;
	}

	@Override
	protected String getFirstRuleName() {
		return "File";
	}

}

//Entry rule entryRuleFile
entryRuleFile returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getFileElementType()); }
	iv_ruleFile=ruleFile
	{ $current=$iv_ruleFile.current; }
	EOF;

// Rule File
ruleFile returns [Boolean current=false]
:
	(
		(
			{
				markLeaf(elementTypeProvider.getFile_PackageKeyword_0_0ElementType());
			}
			otherlv_0='package'
			{
				doneLeaf(otherlv_0);
			}
			(
				(
					{
						markComposite(elementTypeProvider.getFile_PackageQualifiedNameParserRuleCall_0_1_0ElementType());
					}
					lv_package_1_0=ruleQualifiedName
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
			(
				{
					markLeaf(elementTypeProvider.getFile_SemicolonKeyword_0_2ElementType());
				}
				otherlv_2=';'
				{
					doneLeaf(otherlv_2);
				}
			)?
		)?
		(
			(
				{
					markComposite(elementTypeProvider.getFile_ImportSectionXImportSectionParserRuleCall_1_0ElementType());
				}
				lv_importSection_3_0=ruleXImportSection
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)?
		(
			(
				{
					markComposite(elementTypeProvider.getFile_XtendTypesTypeParserRuleCall_2_0ElementType());
				}
				lv_xtendTypes_4_0=ruleType
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)*
	)
;

//Entry rule entryRuleType
entryRuleType returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getTypeElementType()); }
	iv_ruleType=ruleType
	{ $current=$iv_ruleType.current; }
	EOF;

// Rule Type
ruleType returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getType_XtendTypeDeclarationAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		(
			(
				{
					markComposite(elementTypeProvider.getType_AnnotationsXAnnotationParserRuleCall_1_0ElementType());
				}
				lv_annotations_1_0=ruleXAnnotation
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)*
		(
			(
				(
					{
						precedeComposite(elementTypeProvider.getType_XtendClassAnnotationInfoAction_2_0_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				(
					(
						{
							markComposite(elementTypeProvider.getType_ModifiersCommonModifierParserRuleCall_2_0_1_0ElementType());
						}
						lv_modifiers_3_0=ruleCommonModifier
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getType_ClassKeyword_2_0_2ElementType());
				}
				otherlv_4='class'
				{
					doneLeaf(otherlv_4);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getType_NameValidIDParserRuleCall_2_0_3_0ElementType());
						}
						lv_name_5_0=ruleValidID
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				(
					{
						markLeaf(elementTypeProvider.getType_LessThanSignKeyword_2_0_4_0ElementType());
					}
					otherlv_6='<'
					{
						doneLeaf(otherlv_6);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getType_TypeParametersJvmTypeParameterParserRuleCall_2_0_4_1_0ElementType());
							}
							lv_typeParameters_7_0=ruleJvmTypeParameter
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getType_CommaKeyword_2_0_4_2_0ElementType());
						}
						otherlv_8=','
						{
							doneLeaf(otherlv_8);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getType_TypeParametersJvmTypeParameterParserRuleCall_2_0_4_2_1_0ElementType());
								}
								lv_typeParameters_9_0=ruleJvmTypeParameter
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
					{
						markLeaf(elementTypeProvider.getType_GreaterThanSignKeyword_2_0_4_3ElementType());
					}
					otherlv_10='>'
					{
						doneLeaf(otherlv_10);
					}
				)?
				(
					{
						markLeaf(elementTypeProvider.getType_ExtendsKeyword_2_0_5_0ElementType());
					}
					otherlv_11='extends'
					{
						doneLeaf(otherlv_11);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getType_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_0_5_1_0ElementType());
							}
							lv_extends_12_0=ruleJvmParameterizedTypeReference
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
				)?
				(
					{
						markLeaf(elementTypeProvider.getType_ImplementsKeyword_2_0_6_0ElementType());
					}
					otherlv_13='implements'
					{
						doneLeaf(otherlv_13);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getType_ImplementsJvmSuperTypeReferenceParserRuleCall_2_0_6_1_0ElementType());
							}
							lv_implements_14_0=ruleJvmSuperTypeReference
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getType_CommaKeyword_2_0_6_2_0ElementType());
						}
						otherlv_15=','
						{
							doneLeaf(otherlv_15);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getType_ImplementsJvmSuperTypeReferenceParserRuleCall_2_0_6_2_1_0ElementType());
								}
								lv_implements_16_0=ruleJvmSuperTypeReference
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
				)?
				{
					markLeaf(elementTypeProvider.getType_LeftCurlyBracketKeyword_2_0_7ElementType());
				}
				otherlv_17='{'
				{
					doneLeaf(otherlv_17);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getType_MembersMemberParserRuleCall_2_0_8_0ElementType());
						}
						lv_members_18_0=ruleMember
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getType_RightCurlyBracketKeyword_2_0_9ElementType());
				}
				otherlv_19='}'
				{
					doneLeaf(otherlv_19);
				}
			)
			    |
			(
				(
					{
						precedeComposite(elementTypeProvider.getType_XtendInterfaceAnnotationInfoAction_2_1_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				(
					(
						{
							markComposite(elementTypeProvider.getType_ModifiersCommonModifierParserRuleCall_2_1_1_0ElementType());
						}
						lv_modifiers_21_0=ruleCommonModifier
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getType_InterfaceKeyword_2_1_2ElementType());
				}
				otherlv_22='interface'
				{
					doneLeaf(otherlv_22);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getType_NameValidIDParserRuleCall_2_1_3_0ElementType());
						}
						lv_name_23_0=ruleValidID
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				(
					{
						markLeaf(elementTypeProvider.getType_LessThanSignKeyword_2_1_4_0ElementType());
					}
					otherlv_24='<'
					{
						doneLeaf(otherlv_24);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getType_TypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0ElementType());
							}
							lv_typeParameters_25_0=ruleJvmTypeParameter
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getType_CommaKeyword_2_1_4_2_0ElementType());
						}
						otherlv_26=','
						{
							doneLeaf(otherlv_26);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getType_TypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0ElementType());
								}
								lv_typeParameters_27_0=ruleJvmTypeParameter
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
					{
						markLeaf(elementTypeProvider.getType_GreaterThanSignKeyword_2_1_4_3ElementType());
					}
					otherlv_28='>'
					{
						doneLeaf(otherlv_28);
					}
				)?
				(
					{
						markLeaf(elementTypeProvider.getType_ExtendsKeyword_2_1_5_0ElementType());
					}
					otherlv_29='extends'
					{
						doneLeaf(otherlv_29);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getType_ExtendsJvmSuperTypeReferenceParserRuleCall_2_1_5_1_0ElementType());
							}
							lv_extends_30_0=ruleJvmSuperTypeReference
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getType_CommaKeyword_2_1_5_2_0ElementType());
						}
						otherlv_31=','
						{
							doneLeaf(otherlv_31);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getType_ExtendsJvmSuperTypeReferenceParserRuleCall_2_1_5_2_1_0ElementType());
								}
								lv_extends_32_0=ruleJvmSuperTypeReference
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
				)?
				{
					markLeaf(elementTypeProvider.getType_LeftCurlyBracketKeyword_2_1_6ElementType());
				}
				otherlv_33='{'
				{
					doneLeaf(otherlv_33);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getType_MembersMemberParserRuleCall_2_1_7_0ElementType());
						}
						lv_members_34_0=ruleMember
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getType_RightCurlyBracketKeyword_2_1_8ElementType());
				}
				otherlv_35='}'
				{
					doneLeaf(otherlv_35);
				}
			)
			    |
			(
				(
					{
						precedeComposite(elementTypeProvider.getType_XtendEnumAnnotationInfoAction_2_2_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				(
					(
						{
							markComposite(elementTypeProvider.getType_ModifiersCommonModifierParserRuleCall_2_2_1_0ElementType());
						}
						lv_modifiers_37_0=ruleCommonModifier
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getType_EnumKeyword_2_2_2ElementType());
				}
				otherlv_38='enum'
				{
					doneLeaf(otherlv_38);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getType_NameValidIDParserRuleCall_2_2_3_0ElementType());
						}
						lv_name_39_0=ruleValidID
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				{
					markLeaf(elementTypeProvider.getType_LeftCurlyBracketKeyword_2_2_4ElementType());
				}
				otherlv_40='{'
				{
					doneLeaf(otherlv_40);
				}
				(
					(
						(
							{
								markComposite(elementTypeProvider.getType_MembersXtendEnumLiteralParserRuleCall_2_2_5_0_0ElementType());
							}
							lv_members_41_0=ruleXtendEnumLiteral
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getType_CommaKeyword_2_2_5_1_0ElementType());
						}
						otherlv_42=','
						{
							doneLeaf(otherlv_42);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getType_MembersXtendEnumLiteralParserRuleCall_2_2_5_1_1_0ElementType());
								}
								lv_members_43_0=ruleXtendEnumLiteral
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
				)?
				(
					{
						markLeaf(elementTypeProvider.getType_SemicolonKeyword_2_2_6ElementType());
					}
					otherlv_44=';'
					{
						doneLeaf(otherlv_44);
					}
				)?
				{
					markLeaf(elementTypeProvider.getType_RightCurlyBracketKeyword_2_2_7ElementType());
				}
				otherlv_45='}'
				{
					doneLeaf(otherlv_45);
				}
			)
			    |
			(
				(
					{
						precedeComposite(elementTypeProvider.getType_XtendAnnotationTypeAnnotationInfoAction_2_3_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				(
					(
						{
							markComposite(elementTypeProvider.getType_ModifiersCommonModifierParserRuleCall_2_3_1_0ElementType());
						}
						lv_modifiers_47_0=ruleCommonModifier
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getType_AnnotationKeyword_2_3_2ElementType());
				}
				otherlv_48='annotation'
				{
					doneLeaf(otherlv_48);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getType_NameValidIDParserRuleCall_2_3_3_0ElementType());
						}
						lv_name_49_0=ruleValidID
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				{
					markLeaf(elementTypeProvider.getType_LeftCurlyBracketKeyword_2_3_4ElementType());
				}
				otherlv_50='{'
				{
					doneLeaf(otherlv_50);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getType_MembersAnnotationFieldParserRuleCall_2_3_5_0ElementType());
						}
						lv_members_51_0=ruleAnnotationField
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getType_RightCurlyBracketKeyword_2_3_6ElementType());
				}
				otherlv_52='}'
				{
					doneLeaf(otherlv_52);
				}
			)
		)
	)
;

//Entry rule entryRuleJvmSuperTypeReference
entryRuleJvmSuperTypeReference returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getJvmSuperTypeReferenceElementType()); }
	iv_ruleJvmSuperTypeReference=ruleJvmSuperTypeReference
	{ $current=$iv_ruleJvmSuperTypeReference.current; }
	EOF;

// Rule JvmSuperTypeReference
ruleJvmSuperTypeReference returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getJvmSuperTypeReference_JvmParameterizedTypeReferenceParserRuleCall_0ElementType());
		}
		this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference
		{
			$current = $this_JvmParameterizedTypeReference_0.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getJvmSuperTypeReference_XFunctionSuperTypeRefParserRuleCall_1ElementType());
		}
		this_XFunctionSuperTypeRef_1=ruleXFunctionSuperTypeRef
		{
			$current = $this_XFunctionSuperTypeRef_1.current;
			doneComposite();
		}
	)
;

//Entry rule entryRuleXFunctionSuperTypeRef
entryRuleXFunctionSuperTypeRef returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXFunctionSuperTypeRefElementType()); }
	iv_ruleXFunctionSuperTypeRef=ruleXFunctionSuperTypeRef
	{ $current=$iv_ruleXFunctionSuperTypeRef.current; }
	EOF;

// Rule XFunctionSuperTypeRef
ruleXFunctionSuperTypeRef returns [Boolean current=false]
:
	(
		(
			(
				(
					{
						markLeaf(elementTypeProvider.getXFunctionSuperTypeRef_InstanceContextLeftParenthesisKeyword_0_0_0ElementType());
					}
					lv_instanceContext_0_0='('
					{
						doneLeaf(lv_instanceContext_0_0);
					}
					{
						if (!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
			(
				(
					(
						{
							markComposite(elementTypeProvider.getXFunctionSuperTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0ElementType());
						}
						lv_paramTypes_1_0=ruleJvmTypeReference
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				(
					{
						markLeaf(elementTypeProvider.getXFunctionSuperTypeRef_CommaKeyword_0_1_1_0ElementType());
					}
					otherlv_2=','
					{
						doneLeaf(otherlv_2);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getXFunctionSuperTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0ElementType());
							}
							lv_paramTypes_3_0=ruleJvmTypeReference
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
				)*
			)?
			{
				markLeaf(elementTypeProvider.getXFunctionSuperTypeRef_RightParenthesisKeyword_0_2ElementType());
			}
			otherlv_4=')'
			{
				doneLeaf(otherlv_4);
			}
		)?
		{
			markLeaf(elementTypeProvider.getXFunctionSuperTypeRef_EqualsSignGreaterThanSignKeyword_1ElementType());
		}
		otherlv_5='=>'
		{
			doneLeaf(otherlv_5);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getXFunctionSuperTypeRef_ReturnTypeJvmTypeReferenceParserRuleCall_2_0ElementType());
				}
				lv_returnType_6_0=ruleJvmTypeReference
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleAnnotationField
entryRuleAnnotationField returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getAnnotationFieldElementType()); }
	iv_ruleAnnotationField=ruleAnnotationField
	{ $current=$iv_ruleAnnotationField.current; }
	EOF;

// Rule AnnotationField
ruleAnnotationField returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getAnnotationField_XtendMemberAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		(
			(
				{
					markComposite(elementTypeProvider.getAnnotationField_AnnotationsXAnnotationParserRuleCall_1_0ElementType());
				}
				lv_annotations_1_0=ruleXAnnotation
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)*
		(
			(
				(
					(
						(
							{
								precedeComposite(elementTypeProvider.getAnnotationField_XtendFieldAnnotationInfoAction_2_0_0_0_0ElementType());
								doneComposite();
								associateWithSemanticElement();
							}
						)
						(
							(
								{
									markComposite(elementTypeProvider.getAnnotationField_ModifiersCommonModifierParserRuleCall_2_0_0_0_1_0ElementType());
								}
								lv_modifiers_3_0=ruleCommonModifier
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)*
						(
							(
								{
									markComposite(elementTypeProvider.getAnnotationField_ModifiersFieldModifierParserRuleCall_2_0_0_0_2_0ElementType());
								}
								lv_modifiers_4_0=ruleFieldModifier
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
						(
							(
								{
									markComposite(elementTypeProvider.getAnnotationField_ModifiersCommonModifierParserRuleCall_2_0_0_0_3_0ElementType());
								}
								lv_modifiers_5_0=ruleCommonModifier
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)*
						(
							(
								{
									markComposite(elementTypeProvider.getAnnotationField_TypeJvmTypeReferenceParserRuleCall_2_0_0_0_4_0ElementType());
								}
								lv_type_6_0=ruleJvmTypeReference
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)?
						(
							(
								{
									markComposite(elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType());
								}
								lv_name_7_0=ruleValidID
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)
					    |
					(
						(
							{
								precedeComposite(elementTypeProvider.getAnnotationField_XtendFieldAnnotationInfoAction_2_0_0_1_0ElementType());
								doneComposite();
								associateWithSemanticElement();
							}
						)
						(
							(
								{
									markComposite(elementTypeProvider.getAnnotationField_ModifiersCommonModifierParserRuleCall_2_0_0_1_1_0ElementType());
								}
								lv_modifiers_9_0=ruleCommonModifier
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)*
						(
							(
								{
									markComposite(elementTypeProvider.getAnnotationField_TypeJvmTypeReferenceParserRuleCall_2_0_0_1_2_0ElementType());
								}
								lv_type_10_0=ruleJvmTypeReference
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
						(
							(
								{
									markComposite(elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType());
								}
								lv_name_11_0=ruleValidID
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)
				)
				(
					{
						markLeaf(elementTypeProvider.getAnnotationField_EqualsSignKeyword_2_0_1_0ElementType());
					}
					otherlv_12='='
					{
						doneLeaf(otherlv_12);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getAnnotationField_InitialValueXAnnotationElementValueParserRuleCall_2_0_1_1_0ElementType());
							}
							lv_initialValue_13_0=ruleXAnnotationElementValue
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
				)?
				(
					{
						markLeaf(elementTypeProvider.getAnnotationField_SemicolonKeyword_2_0_2ElementType());
					}
					otherlv_14=';'
					{
						doneLeaf(otherlv_14);
					}
				)?
			)
			    |
			(
				(
					{
						precedeComposite(elementTypeProvider.getAnnotationField_XtendClassAnnotationInfoAction_2_1_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				(
					(
						{
							markComposite(elementTypeProvider.getAnnotationField_ModifiersCommonModifierParserRuleCall_2_1_1_0ElementType());
						}
						lv_modifiers_16_0=ruleCommonModifier
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getAnnotationField_ClassKeyword_2_1_2ElementType());
				}
				otherlv_17='class'
				{
					doneLeaf(otherlv_17);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType());
						}
						lv_name_18_0=ruleValidID
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				(
					{
						markLeaf(elementTypeProvider.getAnnotationField_LessThanSignKeyword_2_1_4_0ElementType());
					}
					otherlv_19='<'
					{
						doneLeaf(otherlv_19);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getAnnotationField_TypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0ElementType());
							}
							lv_typeParameters_20_0=ruleJvmTypeParameter
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getAnnotationField_CommaKeyword_2_1_4_2_0ElementType());
						}
						otherlv_21=','
						{
							doneLeaf(otherlv_21);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getAnnotationField_TypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0ElementType());
								}
								lv_typeParameters_22_0=ruleJvmTypeParameter
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
					{
						markLeaf(elementTypeProvider.getAnnotationField_GreaterThanSignKeyword_2_1_4_3ElementType());
					}
					otherlv_23='>'
					{
						doneLeaf(otherlv_23);
					}
				)?
				(
					{
						markLeaf(elementTypeProvider.getAnnotationField_ExtendsKeyword_2_1_5_0ElementType());
					}
					otherlv_24='extends'
					{
						doneLeaf(otherlv_24);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getAnnotationField_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_1_5_1_0ElementType());
							}
							lv_extends_25_0=ruleJvmParameterizedTypeReference
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
				)?
				(
					{
						markLeaf(elementTypeProvider.getAnnotationField_ImplementsKeyword_2_1_6_0ElementType());
					}
					otherlv_26='implements'
					{
						doneLeaf(otherlv_26);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getAnnotationField_ImplementsJvmParameterizedTypeReferenceParserRuleCall_2_1_6_1_0ElementType());
							}
							lv_implements_27_0=ruleJvmParameterizedTypeReference
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getAnnotationField_CommaKeyword_2_1_6_2_0ElementType());
						}
						otherlv_28=','
						{
							doneLeaf(otherlv_28);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getAnnotationField_ImplementsJvmParameterizedTypeReferenceParserRuleCall_2_1_6_2_1_0ElementType());
								}
								lv_implements_29_0=ruleJvmParameterizedTypeReference
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
				)?
				{
					markLeaf(elementTypeProvider.getAnnotationField_LeftCurlyBracketKeyword_2_1_7ElementType());
				}
				otherlv_30='{'
				{
					doneLeaf(otherlv_30);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getAnnotationField_MembersMemberParserRuleCall_2_1_8_0ElementType());
						}
						lv_members_31_0=ruleMember
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getAnnotationField_RightCurlyBracketKeyword_2_1_9ElementType());
				}
				otherlv_32='}'
				{
					doneLeaf(otherlv_32);
				}
			)
			    |
			(
				(
					{
						precedeComposite(elementTypeProvider.getAnnotationField_XtendInterfaceAnnotationInfoAction_2_2_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				(
					(
						{
							markComposite(elementTypeProvider.getAnnotationField_ModifiersCommonModifierParserRuleCall_2_2_1_0ElementType());
						}
						lv_modifiers_34_0=ruleCommonModifier
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getAnnotationField_InterfaceKeyword_2_2_2ElementType());
				}
				otherlv_35='interface'
				{
					doneLeaf(otherlv_35);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType());
						}
						lv_name_36_0=ruleValidID
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				(
					{
						markLeaf(elementTypeProvider.getAnnotationField_LessThanSignKeyword_2_2_4_0ElementType());
					}
					otherlv_37='<'
					{
						doneLeaf(otherlv_37);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getAnnotationField_TypeParametersJvmTypeParameterParserRuleCall_2_2_4_1_0ElementType());
							}
							lv_typeParameters_38_0=ruleJvmTypeParameter
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getAnnotationField_CommaKeyword_2_2_4_2_0ElementType());
						}
						otherlv_39=','
						{
							doneLeaf(otherlv_39);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getAnnotationField_TypeParametersJvmTypeParameterParserRuleCall_2_2_4_2_1_0ElementType());
								}
								lv_typeParameters_40_0=ruleJvmTypeParameter
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
					{
						markLeaf(elementTypeProvider.getAnnotationField_GreaterThanSignKeyword_2_2_4_3ElementType());
					}
					otherlv_41='>'
					{
						doneLeaf(otherlv_41);
					}
				)?
				(
					{
						markLeaf(elementTypeProvider.getAnnotationField_ExtendsKeyword_2_2_5_0ElementType());
					}
					otherlv_42='extends'
					{
						doneLeaf(otherlv_42);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getAnnotationField_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_2_5_1_0ElementType());
							}
							lv_extends_43_0=ruleJvmParameterizedTypeReference
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getAnnotationField_CommaKeyword_2_2_5_2_0ElementType());
						}
						otherlv_44=','
						{
							doneLeaf(otherlv_44);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getAnnotationField_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_2_5_2_1_0ElementType());
								}
								lv_extends_45_0=ruleJvmParameterizedTypeReference
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
				)?
				{
					markLeaf(elementTypeProvider.getAnnotationField_LeftCurlyBracketKeyword_2_2_6ElementType());
				}
				otherlv_46='{'
				{
					doneLeaf(otherlv_46);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getAnnotationField_MembersMemberParserRuleCall_2_2_7_0ElementType());
						}
						lv_members_47_0=ruleMember
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getAnnotationField_RightCurlyBracketKeyword_2_2_8ElementType());
				}
				otherlv_48='}'
				{
					doneLeaf(otherlv_48);
				}
			)
			    |
			(
				(
					{
						precedeComposite(elementTypeProvider.getAnnotationField_XtendEnumAnnotationInfoAction_2_3_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				(
					(
						{
							markComposite(elementTypeProvider.getAnnotationField_ModifiersCommonModifierParserRuleCall_2_3_1_0ElementType());
						}
						lv_modifiers_50_0=ruleCommonModifier
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getAnnotationField_EnumKeyword_2_3_2ElementType());
				}
				otherlv_51='enum'
				{
					doneLeaf(otherlv_51);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType());
						}
						lv_name_52_0=ruleValidID
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				{
					markLeaf(elementTypeProvider.getAnnotationField_LeftCurlyBracketKeyword_2_3_4ElementType());
				}
				otherlv_53='{'
				{
					doneLeaf(otherlv_53);
				}
				(
					(
						(
							{
								markComposite(elementTypeProvider.getAnnotationField_MembersXtendEnumLiteralParserRuleCall_2_3_5_0_0ElementType());
							}
							lv_members_54_0=ruleXtendEnumLiteral
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getAnnotationField_CommaKeyword_2_3_5_1_0ElementType());
						}
						otherlv_55=','
						{
							doneLeaf(otherlv_55);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getAnnotationField_MembersXtendEnumLiteralParserRuleCall_2_3_5_1_1_0ElementType());
								}
								lv_members_56_0=ruleXtendEnumLiteral
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
				)?
				(
					{
						markLeaf(elementTypeProvider.getAnnotationField_SemicolonKeyword_2_3_6ElementType());
					}
					otherlv_57=';'
					{
						doneLeaf(otherlv_57);
					}
				)?
				{
					markLeaf(elementTypeProvider.getAnnotationField_RightCurlyBracketKeyword_2_3_7ElementType());
				}
				otherlv_58='}'
				{
					doneLeaf(otherlv_58);
				}
			)
			    |
			(
				(
					{
						precedeComposite(elementTypeProvider.getAnnotationField_XtendAnnotationTypeAnnotationInfoAction_2_4_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				(
					(
						{
							markComposite(elementTypeProvider.getAnnotationField_ModifiersCommonModifierParserRuleCall_2_4_1_0ElementType());
						}
						lv_modifiers_60_0=ruleCommonModifier
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getAnnotationField_AnnotationKeyword_2_4_2ElementType());
				}
				otherlv_61='annotation'
				{
					doneLeaf(otherlv_61);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType());
						}
						lv_name_62_0=ruleValidID
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				{
					markLeaf(elementTypeProvider.getAnnotationField_LeftCurlyBracketKeyword_2_4_4ElementType());
				}
				otherlv_63='{'
				{
					doneLeaf(otherlv_63);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getAnnotationField_MembersAnnotationFieldParserRuleCall_2_4_5_0ElementType());
						}
						lv_members_64_0=ruleAnnotationField
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getAnnotationField_RightCurlyBracketKeyword_2_4_6ElementType());
				}
				otherlv_65='}'
				{
					doneLeaf(otherlv_65);
				}
			)
		)
	)
;

//Entry rule entryRuleMember
entryRuleMember returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getMemberElementType()); }
	iv_ruleMember=ruleMember
	{ $current=$iv_ruleMember.current; }
	EOF;

// Rule Member
ruleMember returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getMember_XtendMemberAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		(
			(
				{
					markComposite(elementTypeProvider.getMember_AnnotationsXAnnotationParserRuleCall_1_0ElementType());
				}
				lv_annotations_1_0=ruleXAnnotation
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)*
		(
			(
				(
					{
						precedeComposite(elementTypeProvider.getMember_XtendFieldAnnotationInfoAction_2_0_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				(
					(
						{
							markComposite(elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_0_1_0ElementType());
						}
						lv_modifiers_3_0=ruleCommonModifier
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				(
					(
						(
							(
								{
									markComposite(elementTypeProvider.getMember_ModifiersFieldModifierParserRuleCall_2_0_2_0_0_0ElementType());
								}
								lv_modifiers_4_0=ruleFieldModifier
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
						(
							(
								{
									markComposite(elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_0_2_0_1_0ElementType());
								}
								lv_modifiers_5_0=ruleCommonModifier
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)*
						(
							(
								{
									markComposite(elementTypeProvider.getMember_TypeJvmTypeReferenceParserRuleCall_2_0_2_0_2_0ElementType());
								}
								lv_type_6_0=ruleJvmTypeReference
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)?
						(
							(
								{
									markComposite(elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType());
								}
								lv_name_7_0=ruleValidID
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)
					    |
					(
						(
							(
								{
									markLeaf(elementTypeProvider.getMember_ModifiersExtensionKeyword_2_0_2_1_0_0ElementType());
								}
								lv_modifiers_8_0='extension'
								{
									doneLeaf(lv_modifiers_8_0);
								}
								{
									if (!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
						(
							(
								(
									{
										markComposite(elementTypeProvider.getMember_ModifiersFieldModifierParserRuleCall_2_0_2_1_1_0_0ElementType());
									}
									lv_modifiers_9_0=ruleFieldModifier
									{
										doneComposite();
										if(!$current) {
											associateWithSemanticElement();
											$current = true;
										}
									}
								)
							)
							    |
							(
								(
									{
										markComposite(elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_0_2_1_1_1_0ElementType());
									}
									lv_modifiers_10_0=ruleCommonModifier
									{
										doneComposite();
										if(!$current) {
											associateWithSemanticElement();
											$current = true;
										}
									}
								)
							)
						)*
						(
							(
								{
									markComposite(elementTypeProvider.getMember_TypeJvmTypeReferenceParserRuleCall_2_0_2_1_2_0ElementType());
								}
								lv_type_11_0=ruleJvmTypeReference
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
						(
							(
								{
									markComposite(elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType());
								}
								lv_name_12_0=ruleValidID
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)?
					)
					    |
					(
						(
							(
								{
									markComposite(elementTypeProvider.getMember_ModifiersFieldModifierParserRuleCall_2_0_2_2_0_0ElementType());
								}
								lv_modifiers_13_0=ruleFieldModifier
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
						(
							(
								{
									markComposite(elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_0_2_2_1_0ElementType());
								}
								lv_modifiers_14_0=ruleCommonModifier
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)*
						(
							(
								{
									markLeaf(elementTypeProvider.getMember_ModifiersExtensionKeyword_2_0_2_2_2_0ElementType());
								}
								lv_modifiers_15_0='extension'
								{
									doneLeaf(lv_modifiers_15_0);
								}
								{
									if (!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
						(
							(
								{
									markComposite(elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_0_2_2_3_0ElementType());
								}
								lv_modifiers_16_0=ruleCommonModifier
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)*
						(
							(
								{
									markComposite(elementTypeProvider.getMember_TypeJvmTypeReferenceParserRuleCall_2_0_2_2_4_0ElementType());
								}
								lv_type_17_0=ruleJvmTypeReference
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
						(
							(
								{
									markComposite(elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType());
								}
								lv_name_18_0=ruleValidID
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)?
					)
					    |
					(
						(
							(
								{
									markComposite(elementTypeProvider.getMember_TypeJvmTypeReferenceParserRuleCall_2_0_2_3_0_0ElementType());
								}
								lv_type_19_0=ruleJvmTypeReference
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
						(
							(
								{
									markComposite(elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType());
								}
								lv_name_20_0=ruleValidID
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)
				)
				(
					{
						markLeaf(elementTypeProvider.getMember_EqualsSignKeyword_2_0_3_0ElementType());
					}
					otherlv_21='='
					{
						doneLeaf(otherlv_21);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getMember_InitialValueXExpressionParserRuleCall_2_0_3_1_0ElementType());
							}
							lv_initialValue_22_0=ruleXExpression
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
				)?
				(
					{
						markLeaf(elementTypeProvider.getMember_SemicolonKeyword_2_0_4ElementType());
					}
					otherlv_23=';'
					{
						doneLeaf(otherlv_23);
					}
				)?
			)
			    |
			(
				(
					{
						precedeComposite(elementTypeProvider.getMember_XtendFunctionAnnotationInfoAction_2_1_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				(
					(
						{
							markComposite(elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_1_1_0ElementType());
						}
						lv_modifiers_25_0=ruleCommonModifier
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				(
					(
						{
							markComposite(elementTypeProvider.getMember_ModifiersMethodModifierParserRuleCall_2_1_2_0ElementType());
						}
						lv_modifiers_26_0=ruleMethodModifier
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				(
					(
						(
							{
								markComposite(elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_1_3_0_0ElementType());
							}
							lv_modifiers_27_0=ruleCommonModifier
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					    |
					(
						(
							{
								markComposite(elementTypeProvider.getMember_ModifiersMethodModifierParserRuleCall_2_1_3_1_0ElementType());
							}
							lv_modifiers_28_0=ruleMethodModifier
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
				)*
				(
					{
						markLeaf(elementTypeProvider.getMember_LessThanSignKeyword_2_1_4_0ElementType());
					}
					otherlv_29='<'
					{
						doneLeaf(otherlv_29);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0ElementType());
							}
							lv_typeParameters_30_0=ruleJvmTypeParameter
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getMember_CommaKeyword_2_1_4_2_0ElementType());
						}
						otherlv_31=','
						{
							doneLeaf(otherlv_31);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0ElementType());
								}
								lv_typeParameters_32_0=ruleJvmTypeParameter
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
					{
						markLeaf(elementTypeProvider.getMember_GreaterThanSignKeyword_2_1_4_3ElementType());
					}
					otherlv_33='>'
					{
						doneLeaf(otherlv_33);
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
										markComposite(elementTypeProvider.getMember_ReturnTypeJvmTypeReferenceParserRuleCall_2_1_5_0_0_0_0ElementType());
									}
									lv_returnType_34_0=ruleJvmTypeReference
									{
										doneComposite();
										if(!$current) {
											associateWithSemanticElement();
											$current = true;
										}
									}
								)
							)
							(
								(
									{
										markComposite(elementTypeProvider.getMember_CreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_0_0_1_0ElementType());
									}
									lv_createExtensionInfo_35_0=ruleCreateExtensionInfo
									{
										doneComposite();
										if(!$current) {
											associateWithSemanticElement();
											$current = true;
										}
									}
								)
							)
							(
								(
									{
										markComposite(elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType());
									}
									lv_name_36_0=ruleValidID
									{
										doneComposite();
										if(!$current) {
											associateWithSemanticElement();
											$current = true;
										}
									}
								)
							)
							{
								markLeaf(elementTypeProvider.getMember_LeftParenthesisKeyword_2_1_5_0_0_3ElementType());
							}
							otherlv_37='('
							{
								doneLeaf(otherlv_37);
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
										markComposite(elementTypeProvider.getMember_ReturnTypeTypeReferenceWithTypeArgsParserRuleCall_2_1_5_1_0_0_0ElementType());
									}
									lv_returnType_38_0=ruleTypeReferenceWithTypeArgs
									{
										doneComposite();
										if(!$current) {
											associateWithSemanticElement();
											$current = true;
										}
									}
								)
							)
							(
								(
									{
										markComposite(elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType());
									}
									lv_name_39_0=ruleFunctionID
									{
										doneComposite();
										if(!$current) {
											associateWithSemanticElement();
											$current = true;
										}
									}
								)
							)
							{
								markLeaf(elementTypeProvider.getMember_LeftParenthesisKeyword_2_1_5_1_0_2ElementType());
							}
							otherlv_40='('
							{
								doneLeaf(otherlv_40);
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
										markComposite(elementTypeProvider.getMember_ReturnTypeTypeReferenceNoTypeArgsParserRuleCall_2_1_5_2_0_0_0ElementType());
									}
									lv_returnType_41_0=ruleTypeReferenceNoTypeArgs
									{
										doneComposite();
										if(!$current) {
											associateWithSemanticElement();
											$current = true;
										}
									}
								)
							)
							(
								(
									{
										markComposite(elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType());
									}
									lv_name_42_0=ruleFunctionID
									{
										doneComposite();
										if(!$current) {
											associateWithSemanticElement();
											$current = true;
										}
									}
								)
							)
							{
								markLeaf(elementTypeProvider.getMember_LeftParenthesisKeyword_2_1_5_2_0_2ElementType());
							}
							otherlv_43='('
							{
								doneLeaf(otherlv_43);
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
										markComposite(elementTypeProvider.getMember_CreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_3_0_0_0ElementType());
									}
									lv_createExtensionInfo_44_0=ruleCreateExtensionInfo
									{
										doneComposite();
										if(!$current) {
											associateWithSemanticElement();
											$current = true;
										}
									}
								)
							)
							(
								(
									{
										markComposite(elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType());
									}
									lv_name_45_0=ruleValidID
									{
										doneComposite();
										if(!$current) {
											associateWithSemanticElement();
											$current = true;
										}
									}
								)
							)
							{
								markLeaf(elementTypeProvider.getMember_LeftParenthesisKeyword_2_1_5_3_0_2ElementType());
							}
							otherlv_46='('
							{
								doneLeaf(otherlv_46);
							}
						)
					)
					    |
					(
						(
							(
								{
									markComposite(elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType());
								}
								lv_name_47_0=ruleFunctionID
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
						{
							markLeaf(elementTypeProvider.getMember_LeftParenthesisKeyword_2_1_5_4_1ElementType());
						}
						otherlv_48='('
						{
							doneLeaf(otherlv_48);
						}
					)
				)
				(
					(
						(
							{
								markComposite(elementTypeProvider.getMember_ParametersParameterParserRuleCall_2_1_6_0_0ElementType());
							}
							lv_parameters_49_0=ruleParameter
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getMember_CommaKeyword_2_1_6_1_0ElementType());
						}
						otherlv_50=','
						{
							doneLeaf(otherlv_50);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getMember_ParametersParameterParserRuleCall_2_1_6_1_1_0ElementType());
								}
								lv_parameters_51_0=ruleParameter
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
				)?
				{
					markLeaf(elementTypeProvider.getMember_RightParenthesisKeyword_2_1_7ElementType());
				}
				otherlv_52=')'
				{
					doneLeaf(otherlv_52);
				}
				(
					{
						markLeaf(elementTypeProvider.getMember_ThrowsKeyword_2_1_8_0ElementType());
					}
					otherlv_53='throws'
					{
						doneLeaf(otherlv_53);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getMember_ExceptionsJvmTypeReferenceParserRuleCall_2_1_8_1_0ElementType());
							}
							lv_exceptions_54_0=ruleJvmTypeReference
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getMember_CommaKeyword_2_1_8_2_0ElementType());
						}
						otherlv_55=','
						{
							doneLeaf(otherlv_55);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getMember_ExceptionsJvmTypeReferenceParserRuleCall_2_1_8_2_1_0ElementType());
								}
								lv_exceptions_56_0=ruleJvmTypeReference
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
				)?
				(
					(
						(
							{
								markComposite(elementTypeProvider.getMember_ExpressionXBlockExpressionParserRuleCall_2_1_9_0_0ElementType());
							}
							lv_expression_57_0=ruleXBlockExpression
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					    |
					(
						(
							{
								markComposite(elementTypeProvider.getMember_ExpressionRichStringParserRuleCall_2_1_9_1_0ElementType());
							}
							lv_expression_58_0=ruleRichString
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					    |
					{
						markLeaf(elementTypeProvider.getMember_SemicolonKeyword_2_1_9_2ElementType());
					}
					otherlv_59=';'
					{
						doneLeaf(otherlv_59);
					}
				)?
			)
			    |
			(
				(
					{
						precedeComposite(elementTypeProvider.getMember_XtendConstructorAnnotationInfoAction_2_2_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				(
					(
						{
							markComposite(elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_2_1_0ElementType());
						}
						lv_modifiers_61_0=ruleCommonModifier
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getMember_NewKeyword_2_2_2ElementType());
				}
				otherlv_62='new'
				{
					doneLeaf(otherlv_62);
				}
				(
					{
						markLeaf(elementTypeProvider.getMember_LessThanSignKeyword_2_2_3_0ElementType());
					}
					otherlv_63='<'
					{
						doneLeaf(otherlv_63);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_2_3_1_0ElementType());
							}
							lv_typeParameters_64_0=ruleJvmTypeParameter
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getMember_CommaKeyword_2_2_3_2_0ElementType());
						}
						otherlv_65=','
						{
							doneLeaf(otherlv_65);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_2_3_2_1_0ElementType());
								}
								lv_typeParameters_66_0=ruleJvmTypeParameter
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
					{
						markLeaf(elementTypeProvider.getMember_GreaterThanSignKeyword_2_2_3_3ElementType());
					}
					otherlv_67='>'
					{
						doneLeaf(otherlv_67);
					}
				)?
				{
					markLeaf(elementTypeProvider.getMember_LeftParenthesisKeyword_2_2_4ElementType());
				}
				otherlv_68='('
				{
					doneLeaf(otherlv_68);
				}
				(
					(
						(
							{
								markComposite(elementTypeProvider.getMember_ParametersParameterParserRuleCall_2_2_5_0_0ElementType());
							}
							lv_parameters_69_0=ruleParameter
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getMember_CommaKeyword_2_2_5_1_0ElementType());
						}
						otherlv_70=','
						{
							doneLeaf(otherlv_70);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getMember_ParametersParameterParserRuleCall_2_2_5_1_1_0ElementType());
								}
								lv_parameters_71_0=ruleParameter
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
				)?
				{
					markLeaf(elementTypeProvider.getMember_RightParenthesisKeyword_2_2_6ElementType());
				}
				otherlv_72=')'
				{
					doneLeaf(otherlv_72);
				}
				(
					{
						markLeaf(elementTypeProvider.getMember_ThrowsKeyword_2_2_7_0ElementType());
					}
					otherlv_73='throws'
					{
						doneLeaf(otherlv_73);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getMember_ExceptionsJvmTypeReferenceParserRuleCall_2_2_7_1_0ElementType());
							}
							lv_exceptions_74_0=ruleJvmTypeReference
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getMember_CommaKeyword_2_2_7_2_0ElementType());
						}
						otherlv_75=','
						{
							doneLeaf(otherlv_75);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getMember_ExceptionsJvmTypeReferenceParserRuleCall_2_2_7_2_1_0ElementType());
								}
								lv_exceptions_76_0=ruleJvmTypeReference
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
				)?
				(
					(
						{
							markComposite(elementTypeProvider.getMember_ExpressionXBlockExpressionParserRuleCall_2_2_8_0ElementType());
						}
						lv_expression_77_0=ruleXBlockExpression
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
			)
			    |
			(
				(
					{
						precedeComposite(elementTypeProvider.getMember_XtendClassAnnotationInfoAction_2_3_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				(
					(
						{
							markComposite(elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_3_1_0ElementType());
						}
						lv_modifiers_79_0=ruleCommonModifier
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getMember_ClassKeyword_2_3_2ElementType());
				}
				otherlv_80='class'
				{
					doneLeaf(otherlv_80);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType());
						}
						lv_name_81_0=ruleValidID
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				(
					{
						markLeaf(elementTypeProvider.getMember_LessThanSignKeyword_2_3_4_0ElementType());
					}
					otherlv_82='<'
					{
						doneLeaf(otherlv_82);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_3_4_1_0ElementType());
							}
							lv_typeParameters_83_0=ruleJvmTypeParameter
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getMember_CommaKeyword_2_3_4_2_0ElementType());
						}
						otherlv_84=','
						{
							doneLeaf(otherlv_84);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_3_4_2_1_0ElementType());
								}
								lv_typeParameters_85_0=ruleJvmTypeParameter
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
					{
						markLeaf(elementTypeProvider.getMember_GreaterThanSignKeyword_2_3_4_3ElementType());
					}
					otherlv_86='>'
					{
						doneLeaf(otherlv_86);
					}
				)?
				(
					{
						markLeaf(elementTypeProvider.getMember_ExtendsKeyword_2_3_5_0ElementType());
					}
					otherlv_87='extends'
					{
						doneLeaf(otherlv_87);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getMember_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_3_5_1_0ElementType());
							}
							lv_extends_88_0=ruleJvmParameterizedTypeReference
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
				)?
				(
					{
						markLeaf(elementTypeProvider.getMember_ImplementsKeyword_2_3_6_0ElementType());
					}
					otherlv_89='implements'
					{
						doneLeaf(otherlv_89);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getMember_ImplementsJvmParameterizedTypeReferenceParserRuleCall_2_3_6_1_0ElementType());
							}
							lv_implements_90_0=ruleJvmParameterizedTypeReference
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getMember_CommaKeyword_2_3_6_2_0ElementType());
						}
						otherlv_91=','
						{
							doneLeaf(otherlv_91);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getMember_ImplementsJvmParameterizedTypeReferenceParserRuleCall_2_3_6_2_1_0ElementType());
								}
								lv_implements_92_0=ruleJvmParameterizedTypeReference
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
				)?
				{
					markLeaf(elementTypeProvider.getMember_LeftCurlyBracketKeyword_2_3_7ElementType());
				}
				otherlv_93='{'
				{
					doneLeaf(otherlv_93);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getMember_MembersMemberParserRuleCall_2_3_8_0ElementType());
						}
						lv_members_94_0=ruleMember
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getMember_RightCurlyBracketKeyword_2_3_9ElementType());
				}
				otherlv_95='}'
				{
					doneLeaf(otherlv_95);
				}
			)
			    |
			(
				(
					{
						precedeComposite(elementTypeProvider.getMember_XtendInterfaceAnnotationInfoAction_2_4_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				(
					(
						{
							markComposite(elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_4_1_0ElementType());
						}
						lv_modifiers_97_0=ruleCommonModifier
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getMember_InterfaceKeyword_2_4_2ElementType());
				}
				otherlv_98='interface'
				{
					doneLeaf(otherlv_98);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType());
						}
						lv_name_99_0=ruleValidID
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				(
					{
						markLeaf(elementTypeProvider.getMember_LessThanSignKeyword_2_4_4_0ElementType());
					}
					otherlv_100='<'
					{
						doneLeaf(otherlv_100);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_4_4_1_0ElementType());
							}
							lv_typeParameters_101_0=ruleJvmTypeParameter
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getMember_CommaKeyword_2_4_4_2_0ElementType());
						}
						otherlv_102=','
						{
							doneLeaf(otherlv_102);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_4_4_2_1_0ElementType());
								}
								lv_typeParameters_103_0=ruleJvmTypeParameter
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
					{
						markLeaf(elementTypeProvider.getMember_GreaterThanSignKeyword_2_4_4_3ElementType());
					}
					otherlv_104='>'
					{
						doneLeaf(otherlv_104);
					}
				)?
				(
					{
						markLeaf(elementTypeProvider.getMember_ExtendsKeyword_2_4_5_0ElementType());
					}
					otherlv_105='extends'
					{
						doneLeaf(otherlv_105);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getMember_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_4_5_1_0ElementType());
							}
							lv_extends_106_0=ruleJvmParameterizedTypeReference
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getMember_CommaKeyword_2_4_5_2_0ElementType());
						}
						otherlv_107=','
						{
							doneLeaf(otherlv_107);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getMember_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_4_5_2_1_0ElementType());
								}
								lv_extends_108_0=ruleJvmParameterizedTypeReference
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
				)?
				{
					markLeaf(elementTypeProvider.getMember_LeftCurlyBracketKeyword_2_4_6ElementType());
				}
				otherlv_109='{'
				{
					doneLeaf(otherlv_109);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getMember_MembersMemberParserRuleCall_2_4_7_0ElementType());
						}
						lv_members_110_0=ruleMember
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getMember_RightCurlyBracketKeyword_2_4_8ElementType());
				}
				otherlv_111='}'
				{
					doneLeaf(otherlv_111);
				}
			)
			    |
			(
				(
					{
						precedeComposite(elementTypeProvider.getMember_XtendEnumAnnotationInfoAction_2_5_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				(
					(
						{
							markComposite(elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_5_1_0ElementType());
						}
						lv_modifiers_113_0=ruleCommonModifier
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getMember_EnumKeyword_2_5_2ElementType());
				}
				otherlv_114='enum'
				{
					doneLeaf(otherlv_114);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType());
						}
						lv_name_115_0=ruleValidID
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				{
					markLeaf(elementTypeProvider.getMember_LeftCurlyBracketKeyword_2_5_4ElementType());
				}
				otherlv_116='{'
				{
					doneLeaf(otherlv_116);
				}
				(
					(
						(
							{
								markComposite(elementTypeProvider.getMember_MembersXtendEnumLiteralParserRuleCall_2_5_5_0_0ElementType());
							}
							lv_members_117_0=ruleXtendEnumLiteral
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getMember_CommaKeyword_2_5_5_1_0ElementType());
						}
						otherlv_118=','
						{
							doneLeaf(otherlv_118);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getMember_MembersXtendEnumLiteralParserRuleCall_2_5_5_1_1_0ElementType());
								}
								lv_members_119_0=ruleXtendEnumLiteral
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
				)?
				(
					{
						markLeaf(elementTypeProvider.getMember_SemicolonKeyword_2_5_6ElementType());
					}
					otherlv_120=';'
					{
						doneLeaf(otherlv_120);
					}
				)?
				{
					markLeaf(elementTypeProvider.getMember_RightCurlyBracketKeyword_2_5_7ElementType());
				}
				otherlv_121='}'
				{
					doneLeaf(otherlv_121);
				}
			)
			    |
			(
				(
					{
						precedeComposite(elementTypeProvider.getMember_XtendAnnotationTypeAnnotationInfoAction_2_6_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				(
					(
						{
							markComposite(elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_6_1_0ElementType());
						}
						lv_modifiers_123_0=ruleCommonModifier
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getMember_AnnotationKeyword_2_6_2ElementType());
				}
				otherlv_124='annotation'
				{
					doneLeaf(otherlv_124);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType());
						}
						lv_name_125_0=ruleValidID
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				{
					markLeaf(elementTypeProvider.getMember_LeftCurlyBracketKeyword_2_6_4ElementType());
				}
				otherlv_126='{'
				{
					doneLeaf(otherlv_126);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getMember_MembersAnnotationFieldParserRuleCall_2_6_5_0ElementType());
						}
						lv_members_127_0=ruleAnnotationField
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
				{
					markLeaf(elementTypeProvider.getMember_RightCurlyBracketKeyword_2_6_6ElementType());
				}
				otherlv_128='}'
				{
					doneLeaf(otherlv_128);
				}
			)
		)
	)
;

//Entry rule entryRuleTypeReferenceNoTypeArgs
entryRuleTypeReferenceNoTypeArgs returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getTypeReferenceNoTypeArgsElementType()); }
	iv_ruleTypeReferenceNoTypeArgs=ruleTypeReferenceNoTypeArgs
	{ $current=$iv_ruleTypeReferenceNoTypeArgs.current; }
	EOF;

// Rule TypeReferenceNoTypeArgs
ruleTypeReferenceNoTypeArgs returns [Boolean current=false]
:
	(
		(
			{
				if (!$current) {
					associateWithSemanticElement();
					$current = true;
				}
			}
			{
				markComposite(elementTypeProvider.getTypeReferenceNoTypeArgs_TypeJvmTypeCrossReference_0ElementType());
			}
			ruleQualifiedName
			{
				doneComposite();
			}
		)
	)
;

//Entry rule entryRuleTypeReferenceWithTypeArgs
entryRuleTypeReferenceWithTypeArgs returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getTypeReferenceWithTypeArgsElementType()); }
	iv_ruleTypeReferenceWithTypeArgs=ruleTypeReferenceWithTypeArgs
	{ $current=$iv_ruleTypeReferenceWithTypeArgs.current; }
	EOF;

// Rule TypeReferenceWithTypeArgs
ruleTypeReferenceWithTypeArgs returns [Boolean current=false]
:
	(
		(
			{
				markComposite(elementTypeProvider.getTypeReferenceWithTypeArgs_ParameterizedTypeReferenceWithTypeArgsParserRuleCall_0_0ElementType());
			}
			this_ParameterizedTypeReferenceWithTypeArgs_0=ruleParameterizedTypeReferenceWithTypeArgs
			{
				$current = $this_ParameterizedTypeReferenceWithTypeArgs_0.current;
				doneComposite();
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
							precedeComposite(elementTypeProvider.getTypeReferenceWithTypeArgs_JvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0ElementType());
							doneComposite();
							associateWithSemanticElement();
						}
					)
					{
						markComposite(elementTypeProvider.getTypeReferenceWithTypeArgs_ArrayBracketsParserRuleCall_0_1_0_1ElementType());
					}
					ruleArrayBrackets
					{
						doneComposite();
					}
				)
			)*
		)
		    |
		(
			{
				markComposite(elementTypeProvider.getTypeReferenceWithTypeArgs_TypeReferenceNoTypeArgsParserRuleCall_1_0ElementType());
			}
			this_TypeReferenceNoTypeArgs_3=ruleTypeReferenceNoTypeArgs
			{
				$current = $this_TypeReferenceNoTypeArgs_3.current;
				doneComposite();
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
							precedeComposite(elementTypeProvider.getTypeReferenceWithTypeArgs_JvmGenericArrayTypeReferenceComponentTypeAction_1_1_0_0ElementType());
							doneComposite();
							associateWithSemanticElement();
						}
					)
					{
						markComposite(elementTypeProvider.getTypeReferenceWithTypeArgs_ArrayBracketsParserRuleCall_1_1_0_1ElementType());
					}
					ruleArrayBrackets
					{
						doneComposite();
					}
				)
			)+
		)
		    |
		{
			markComposite(elementTypeProvider.getTypeReferenceWithTypeArgs_XFunctionTypeRefParserRuleCall_2ElementType());
		}
		this_XFunctionTypeRef_6=ruleXFunctionTypeRef
		{
			$current = $this_XFunctionTypeRef_6.current;
			doneComposite();
		}
	)
;

//Entry rule entryRuleParameterizedTypeReferenceWithTypeArgs
entryRuleParameterizedTypeReferenceWithTypeArgs returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getParameterizedTypeReferenceWithTypeArgsElementType()); }
	iv_ruleParameterizedTypeReferenceWithTypeArgs=ruleParameterizedTypeReferenceWithTypeArgs
	{ $current=$iv_ruleParameterizedTypeReferenceWithTypeArgs.current; }
	EOF;

// Rule ParameterizedTypeReferenceWithTypeArgs
ruleParameterizedTypeReferenceWithTypeArgs returns [Boolean current=false]
:
	(
		(
			(
				{
					if (!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
				{
					markComposite(elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_TypeJvmTypeCrossReference_0_0ElementType());
				}
				ruleQualifiedName
				{
					doneComposite();
				}
			)
		)
		(
			{
				markLeaf(elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_LessThanSignKeyword_1_0ElementType());
			}
			otherlv_1='<'
			{
				doneLeaf(otherlv_1);
			}
			(
				(
					{
						markComposite(elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType());
					}
					lv_arguments_2_0=ruleJvmArgumentTypeReference
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
			(
				{
					markLeaf(elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_CommaKeyword_1_2_0ElementType());
				}
				otherlv_3=','
				{
					doneLeaf(otherlv_3);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType());
						}
						lv_arguments_4_0=ruleJvmArgumentTypeReference
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
			)*
			{
				markLeaf(elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_GreaterThanSignKeyword_1_3ElementType());
			}
			otherlv_5='>'
			{
				doneLeaf(otherlv_5);
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
								precedeComposite(elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_JvmInnerTypeReferenceOuterAction_1_4_0_0_0ElementType());
								doneComposite();
								associateWithSemanticElement();
							}
						)
						{
							markLeaf(elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_FullStopKeyword_1_4_0_0_1ElementType());
						}
						otherlv_7='.'
						{
							doneLeaf(otherlv_7);
						}
					)
				)
				(
					(
						{
							if (!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
						{
							markComposite(elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_TypeJvmTypeCrossReference_1_4_1_0ElementType());
						}
						ruleValidID
						{
							doneComposite();
						}
					)
				)
				(
					(
						('<')=>
						{
							markLeaf(elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_LessThanSignKeyword_1_4_2_0ElementType());
						}
						otherlv_9='<'
						{
							doneLeaf(otherlv_9);
						}
					)
					(
						(
							{
								markComposite(elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0ElementType());
							}
							lv_arguments_10_0=ruleJvmArgumentTypeReference
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_CommaKeyword_1_4_2_2_0ElementType());
						}
						otherlv_11=','
						{
							doneLeaf(otherlv_11);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0ElementType());
								}
								lv_arguments_12_0=ruleJvmArgumentTypeReference
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
					{
						markLeaf(elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_GreaterThanSignKeyword_1_4_2_3ElementType());
					}
					otherlv_13='>'
					{
						doneLeaf(otherlv_13);
					}
				)?
			)*
		)
	)
;

//Entry rule entryRuleFunctionID
entryRuleFunctionID returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getFunctionIDElementType()); }
	iv_ruleFunctionID=ruleFunctionID
	{ $current=$iv_ruleFunctionID.current; }
	EOF;

// Rule FunctionID
ruleFunctionID returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getFunctionID_ValidIDParserRuleCall_0ElementType());
		}
		ruleValidID
		{
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getFunctionID_OperatorsParserRuleCall_1ElementType());
		}
		ruleOperators
		{
			doneComposite();
		}
	)
;

//Entry rule entryRuleOperators
entryRuleOperators returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getOperatorsElementType()); }
	iv_ruleOperators=ruleOperators
	{ $current=$iv_ruleOperators.current; }
	EOF;

// Rule Operators
ruleOperators returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getOperators_OpMultiAssignParserRuleCall_0ElementType());
		}
		ruleOpMultiAssign
		{
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getOperators_OpOrParserRuleCall_1ElementType());
		}
		ruleOpOr
		{
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getOperators_OpAndParserRuleCall_2ElementType());
		}
		ruleOpAnd
		{
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getOperators_OpEqualityParserRuleCall_3ElementType());
		}
		ruleOpEquality
		{
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getOperators_OpCompareParserRuleCall_4ElementType());
		}
		ruleOpCompare
		{
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getOperators_OpOtherParserRuleCall_5ElementType());
		}
		ruleOpOther
		{
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getOperators_OpMultiParserRuleCall_6ElementType());
		}
		ruleOpMulti
		{
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getOperators_OpUnaryParserRuleCall_7ElementType());
		}
		ruleOpUnary
		{
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getOperators_OpPostfixParserRuleCall_8ElementType());
		}
		ruleOpPostfix
		{
			doneComposite();
		}
	)
;

//Entry rule entryRuleXtendEnumLiteral
entryRuleXtendEnumLiteral returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXtendEnumLiteralElementType()); }
	iv_ruleXtendEnumLiteral=ruleXtendEnumLiteral
	{ $current=$iv_ruleXtendEnumLiteral.current; }
	EOF;

// Rule XtendEnumLiteral
ruleXtendEnumLiteral returns [Boolean current=false]
:
	(
		(
			{
				markComposite(elementTypeProvider.getXtendEnumLiteral_NameValidIDParserRuleCall_0ElementType());
			}
			lv_name_0_0=ruleValidID
			{
				doneComposite();
				if(!$current) {
					associateWithSemanticElement();
					$current = true;
				}
			}
		)
	)
;

//Entry rule entryRuleCommonModifier
entryRuleCommonModifier returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getCommonModifierElementType()); }
	iv_ruleCommonModifier=ruleCommonModifier
	{ $current=$iv_ruleCommonModifier.current; }
	EOF;

// Rule CommonModifier
ruleCommonModifier returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getCommonModifier_PublicKeyword_0ElementType());
		}
		kw='public'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getCommonModifier_PrivateKeyword_1ElementType());
		}
		kw='private'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getCommonModifier_ProtectedKeyword_2ElementType());
		}
		kw='protected'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getCommonModifier_PackageKeyword_3ElementType());
		}
		kw='package'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getCommonModifier_AbstractKeyword_4ElementType());
		}
		kw='abstract'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getCommonModifier_StaticKeyword_5ElementType());
		}
		kw='static'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getCommonModifier_DispatchKeyword_6ElementType());
		}
		kw='dispatch'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getCommonModifier_FinalKeyword_7ElementType());
		}
		kw='final'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getCommonModifier_StrictfpKeyword_8ElementType());
		}
		kw='strictfp'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getCommonModifier_NativeKeyword_9ElementType());
		}
		kw='native'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getCommonModifier_VolatileKeyword_10ElementType());
		}
		kw='volatile'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getCommonModifier_SynchronizedKeyword_11ElementType());
		}
		kw='synchronized'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getCommonModifier_TransientKeyword_12ElementType());
		}
		kw='transient'
		{
			doneLeaf(kw);
		}
	)
;

//Entry rule entryRuleFieldModifier
entryRuleFieldModifier returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getFieldModifierElementType()); }
	iv_ruleFieldModifier=ruleFieldModifier
	{ $current=$iv_ruleFieldModifier.current; }
	EOF;

// Rule FieldModifier
ruleFieldModifier returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getFieldModifier_ValKeyword_0ElementType());
		}
		kw='val'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getFieldModifier_VarKeyword_1ElementType());
		}
		kw='var'
		{
			doneLeaf(kw);
		}
	)
;

//Entry rule entryRuleMethodModifier
entryRuleMethodModifier returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getMethodModifierElementType()); }
	iv_ruleMethodModifier=ruleMethodModifier
	{ $current=$iv_ruleMethodModifier.current; }
	EOF;

// Rule MethodModifier
ruleMethodModifier returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getMethodModifier_DefKeyword_0ElementType());
		}
		kw='def'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getMethodModifier_OverrideKeyword_1ElementType());
		}
		kw='override'
		{
			doneLeaf(kw);
		}
	)
;

//Entry rule entryRuleCreateExtensionInfo
entryRuleCreateExtensionInfo returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getCreateExtensionInfoElementType()); }
	iv_ruleCreateExtensionInfo=ruleCreateExtensionInfo
	{ $current=$iv_ruleCreateExtensionInfo.current; }
	EOF;

// Rule CreateExtensionInfo
ruleCreateExtensionInfo returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getCreateExtensionInfo_CreateKeyword_0ElementType());
		}
		otherlv_0='create'
		{
			doneLeaf(otherlv_0);
		}
		(
			(
				(
					{
						markComposite(elementTypeProvider.getCreateExtensionInfo_NameValidIDParserRuleCall_1_0_0ElementType());
					}
					lv_name_1_0=ruleValidID
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
			{
				markLeaf(elementTypeProvider.getCreateExtensionInfo_ColonKeyword_1_1ElementType());
			}
			otherlv_2=':'
			{
				doneLeaf(otherlv_2);
			}
		)?
		(
			(
				{
					markComposite(elementTypeProvider.getCreateExtensionInfo_CreateExpressionXExpressionParserRuleCall_2_0ElementType());
				}
				lv_createExpression_3_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleValidID
entryRuleValidID returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getValidIDElementType()); }
	iv_ruleValidID=ruleValidID
	{ $current=$iv_ruleValidID.current; }
	EOF;

// Rule ValidID
ruleValidID returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getValidID_IDTerminalRuleCall_0ElementType());
		}
		this_ID_0=RULE_ID
		{
			doneLeaf(this_ID_0);
		}
		    |
		{
			markLeaf(elementTypeProvider.getValidID_CreateKeyword_1ElementType());
		}
		kw='create'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getValidID_AnnotationKeyword_2ElementType());
		}
		kw='annotation'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getValidID_AFTERKeyword_3ElementType());
		}
		kw='AFTER'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getValidID_BEFOREKeyword_4ElementType());
		}
		kw='BEFORE'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getValidID_SEPARATORKeyword_5ElementType());
		}
		kw='SEPARATOR'
		{
			doneLeaf(kw);
		}
	)
;

//Entry rule entryRuleFeatureCallID
entryRuleFeatureCallID returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getFeatureCallIDElementType()); }
	iv_ruleFeatureCallID=ruleFeatureCallID
	{ $current=$iv_ruleFeatureCallID.current; }
	EOF;

// Rule FeatureCallID
ruleFeatureCallID returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getFeatureCallID_InnerVarIDParserRuleCall_0ElementType());
		}
		ruleInnerVarID
		{
			doneComposite();
		}
		    |
		{
			markLeaf(elementTypeProvider.getFeatureCallID_ExtensionKeyword_1ElementType());
		}
		kw='extension'
		{
			doneLeaf(kw);
		}
	)
;

//Entry rule entryRuleInnerVarID
entryRuleInnerVarID returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getInnerVarIDElementType()); }
	iv_ruleInnerVarID=ruleInnerVarID
	{ $current=$iv_ruleInnerVarID.current; }
	EOF;

// Rule InnerVarID
ruleInnerVarID returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getInnerVarID_IDTerminalRuleCall_0ElementType());
		}
		this_ID_0=RULE_ID
		{
			doneLeaf(this_ID_0);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_AbstractKeyword_1ElementType());
		}
		kw='abstract'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_AnnotationKeyword_2ElementType());
		}
		kw='annotation'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_ClassKeyword_3ElementType());
		}
		kw='class'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_CreateKeyword_4ElementType());
		}
		kw='create'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_DefKeyword_5ElementType());
		}
		kw='def'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_DispatchKeyword_6ElementType());
		}
		kw='dispatch'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_EnumKeyword_7ElementType());
		}
		kw='enum'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_ExtendsKeyword_8ElementType());
		}
		kw='extends'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_FinalKeyword_9ElementType());
		}
		kw='final'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_ImplementsKeyword_10ElementType());
		}
		kw='implements'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_ImportKeyword_11ElementType());
		}
		kw='import'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_InterfaceKeyword_12ElementType());
		}
		kw='interface'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_OverrideKeyword_13ElementType());
		}
		kw='override'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_PackageKeyword_14ElementType());
		}
		kw='package'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_PublicKeyword_15ElementType());
		}
		kw='public'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_PrivateKeyword_16ElementType());
		}
		kw='private'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_ProtectedKeyword_17ElementType());
		}
		kw='protected'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_StaticKeyword_18ElementType());
		}
		kw='static'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_ThrowsKeyword_19ElementType());
		}
		kw='throws'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_StrictfpKeyword_20ElementType());
		}
		kw='strictfp'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_NativeKeyword_21ElementType());
		}
		kw='native'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_VolatileKeyword_22ElementType());
		}
		kw='volatile'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_SynchronizedKeyword_23ElementType());
		}
		kw='synchronized'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_TransientKeyword_24ElementType());
		}
		kw='transient'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_AFTERKeyword_25ElementType());
		}
		kw='AFTER'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_BEFOREKeyword_26ElementType());
		}
		kw='BEFORE'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getInnerVarID_SEPARATORKeyword_27ElementType());
		}
		kw='SEPARATOR'
		{
			doneLeaf(kw);
		}
	)
;

//Entry rule entryRuleParameter
entryRuleParameter returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getParameterElementType()); }
	iv_ruleParameter=ruleParameter
	{ $current=$iv_ruleParameter.current; }
	EOF;

// Rule Parameter
ruleParameter returns [Boolean current=false]
:
	(
		(
			(
				{
					markComposite(elementTypeProvider.getParameter_AnnotationsXAnnotationParserRuleCall_0_0ElementType());
				}
				lv_annotations_0_0=ruleXAnnotation
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)*
		(
			(
				(
					{
						markLeaf(elementTypeProvider.getParameter_ExtensionExtensionKeyword_1_0_0ElementType());
					}
					lv_extension_1_0='extension'
					{
						doneLeaf(lv_extension_1_0);
					}
					{
						if (!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
			(
				(
					{
						markComposite(elementTypeProvider.getParameter_AnnotationsXAnnotationParserRuleCall_1_1_0ElementType());
					}
					lv_annotations_2_0=ruleXAnnotation
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)*
		)?
		(
			(
				{
					markComposite(elementTypeProvider.getParameter_ParameterTypeJvmTypeReferenceParserRuleCall_2_0ElementType());
				}
				lv_parameterType_3_0=ruleJvmTypeReference
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		(
			(
				{
					markLeaf(elementTypeProvider.getParameter_VarArgFullStopFullStopFullStopKeyword_3_0ElementType());
				}
				lv_varArg_4_0='...'
				{
					doneLeaf(lv_varArg_4_0);
				}
				{
					if (!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)?
		(
			(
				{
					markComposite(elementTypeProvider.getParameter_NameValidIDParserRuleCall_4_0ElementType());
				}
				lv_name_5_0=ruleValidID
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleXVariableDeclaration
entryRuleXVariableDeclaration returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXVariableDeclarationElementType()); }
	iv_ruleXVariableDeclaration=ruleXVariableDeclaration
	{ $current=$iv_ruleXVariableDeclaration.current; }
	EOF;

// Rule XVariableDeclaration
ruleXVariableDeclaration returns [Boolean current=false]
:
	(
		(
			((
				(
				)
				(
					(
						(
							(
								(
									'var'
								)
							)
							    |
							'val'
						)
						(
							(
								'extension'
							)
						)?
					)
					    |
					(
						(
							(
								'extension'
							)
						)
						(
							(
								(
									'var'
								)
							)
							    |
							'val'
						)
					)
				)
			)
			)=>
			(
				(
					{
						precedeComposite(elementTypeProvider.getXVariableDeclaration_XtendVariableDeclarationAction_0_0_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				(
					(
						(
							(
								(
									{
										markLeaf(elementTypeProvider.getXVariableDeclaration_WriteableVarKeyword_0_0_1_0_0_0_0ElementType());
									}
									lv_writeable_1_0='var'
									{
										doneLeaf(lv_writeable_1_0);
									}
									{
										if (!$current) {
											associateWithSemanticElement();
											$current = true;
										}
									}
								)
							)
							    |
							{
								markLeaf(elementTypeProvider.getXVariableDeclaration_ValKeyword_0_0_1_0_0_1ElementType());
							}
							otherlv_2='val'
							{
								doneLeaf(otherlv_2);
							}
						)
						(
							(
								{
									markLeaf(elementTypeProvider.getXVariableDeclaration_ExtensionExtensionKeyword_0_0_1_0_1_0ElementType());
								}
								lv_extension_3_0='extension'
								{
									doneLeaf(lv_extension_3_0);
								}
								{
									if (!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)?
					)
					    |
					(
						(
							(
								{
									markLeaf(elementTypeProvider.getXVariableDeclaration_ExtensionExtensionKeyword_0_0_1_1_0_0ElementType());
								}
								lv_extension_4_0='extension'
								{
									doneLeaf(lv_extension_4_0);
								}
								{
									if (!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
						(
							(
								(
									{
										markLeaf(elementTypeProvider.getXVariableDeclaration_WriteableVarKeyword_0_0_1_1_1_0_0ElementType());
									}
									lv_writeable_5_0='var'
									{
										doneLeaf(lv_writeable_5_0);
									}
									{
										if (!$current) {
											associateWithSemanticElement();
											$current = true;
										}
									}
								)
							)
							    |
							{
								markLeaf(elementTypeProvider.getXVariableDeclaration_ValKeyword_0_0_1_1_1_1ElementType());
							}
							otherlv_6='val'
							{
								doneLeaf(otherlv_6);
							}
						)
					)
				)
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
								markComposite(elementTypeProvider.getXVariableDeclaration_TypeJvmTypeReferenceParserRuleCall_1_0_0_0_0ElementType());
							}
							lv_type_7_0=ruleJvmTypeReference
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						(
							{
								markComposite(elementTypeProvider.getXVariableDeclaration_NameInnerVarIDParserRuleCall_1_0_0_1_0ElementType());
							}
							lv_name_8_0=ruleInnerVarID
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
				)
			)
			    |
			(
				(
					{
						markComposite(elementTypeProvider.getXVariableDeclaration_NameInnerVarIDParserRuleCall_1_1_0ElementType());
					}
					lv_name_9_0=ruleInnerVarID
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)
		(
			{
				markLeaf(elementTypeProvider.getXVariableDeclaration_EqualsSignKeyword_2_0ElementType());
			}
			otherlv_10='='
			{
				doneLeaf(otherlv_10);
			}
			(
				(
					{
						markComposite(elementTypeProvider.getXVariableDeclaration_RightXExpressionParserRuleCall_2_1_0ElementType());
					}
					lv_right_11_0=ruleXExpression
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)?
	)
;

//Entry rule entryRuleXConstructorCall
entryRuleXConstructorCall returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXConstructorCallElementType()); }
	iv_ruleXConstructorCall=ruleXConstructorCall
	{ $current=$iv_ruleXConstructorCall.current; }
	EOF;

// Rule XConstructorCall
ruleXConstructorCall returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getXConstructorCall_XbaseConstructorCallParserRuleCall_0ElementType());
		}
		this_XbaseConstructorCall_0=ruleXbaseConstructorCall
		{
			$current = $this_XbaseConstructorCall_0.current;
			doneComposite();
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
							precedeComposite(elementTypeProvider.getXConstructorCall_AnonymousClassConstructorCallAction_1_0_0_0ElementType());
							doneComposite();
							associateWithSemanticElement();
						}
					)
					{
						markLeaf(elementTypeProvider.getXConstructorCall_LeftCurlyBracketKeyword_1_0_0_1ElementType());
					}
					otherlv_2='{'
					{
						doneLeaf(otherlv_2);
					}
				)
			)
			(
				(
					{
						markComposite(elementTypeProvider.getXConstructorCall_MembersMemberParserRuleCall_1_1_0ElementType());
					}
					lv_members_3_0=ruleMember
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)*
			{
				markLeaf(elementTypeProvider.getXConstructorCall_RightCurlyBracketKeyword_1_2ElementType());
			}
			otherlv_4='}'
			{
				doneLeaf(otherlv_4);
			}
		)?
	)
;

//Entry rule entryRuleXbaseConstructorCall
entryRuleXbaseConstructorCall returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXbaseConstructorCallElementType()); }
	iv_ruleXbaseConstructorCall=ruleXbaseConstructorCall
	{ $current=$iv_ruleXbaseConstructorCall.current; }
	EOF;

// Rule XbaseConstructorCall
ruleXbaseConstructorCall returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXbaseConstructorCall_XConstructorCallAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		{
			markLeaf(elementTypeProvider.getXbaseConstructorCall_NewKeyword_1ElementType());
		}
		otherlv_1='new'
		{
			doneLeaf(otherlv_1);
		}
		(
			(
				{
					if (!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
				{
					markComposite(elementTypeProvider.getXbaseConstructorCall_ConstructorJvmConstructorCrossReference_2_0ElementType());
				}
				ruleQualifiedName
				{
					doneComposite();
				}
			)
		)
		(
			(
				('<')=>
				{
					markLeaf(elementTypeProvider.getXbaseConstructorCall_LessThanSignKeyword_3_0ElementType());
				}
				otherlv_3='<'
				{
					doneLeaf(otherlv_3);
				}
			)
			(
				(
					{
						markComposite(elementTypeProvider.getXbaseConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0ElementType());
					}
					lv_typeArguments_4_0=ruleJvmArgumentTypeReference
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
			(
				{
					markLeaf(elementTypeProvider.getXbaseConstructorCall_CommaKeyword_3_2_0ElementType());
				}
				otherlv_5=','
				{
					doneLeaf(otherlv_5);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getXbaseConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0ElementType());
						}
						lv_typeArguments_6_0=ruleJvmArgumentTypeReference
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
			)*
			{
				markLeaf(elementTypeProvider.getXbaseConstructorCall_GreaterThanSignKeyword_3_3ElementType());
			}
			otherlv_7='>'
			{
				doneLeaf(otherlv_7);
			}
		)?
		(
			(
				((
					'('
				)
				)=>
				(
					{
						markLeaf(elementTypeProvider.getXbaseConstructorCall_ExplicitConstructorCallLeftParenthesisKeyword_4_0_0ElementType());
					}
					lv_explicitConstructorCall_8_0='('
					{
						doneLeaf(lv_explicitConstructorCall_8_0);
					}
					{
						if (!$current) {
							associateWithSemanticElement();
							$current = true;
						}
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
							markComposite(elementTypeProvider.getXbaseConstructorCall_ArgumentsXShortClosureParserRuleCall_4_1_0_0ElementType());
						}
						lv_arguments_9_0=ruleXShortClosure
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				    |
				(
					(
						(
							{
								markComposite(elementTypeProvider.getXbaseConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_0_0ElementType());
							}
							lv_arguments_10_0=ruleXExpression
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getXbaseConstructorCall_CommaKeyword_4_1_1_1_0ElementType());
						}
						otherlv_11=','
						{
							doneLeaf(otherlv_11);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getXbaseConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_1_1_0ElementType());
								}
								lv_arguments_12_0=ruleXExpression
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
				)
			)?
			{
				markLeaf(elementTypeProvider.getXbaseConstructorCall_RightParenthesisKeyword_4_2ElementType());
			}
			otherlv_13=')'
			{
				doneLeaf(otherlv_13);
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
					markComposite(elementTypeProvider.getXbaseConstructorCall_ArgumentsXClosureParserRuleCall_5_0ElementType());
				}
				lv_arguments_14_0=ruleXClosure
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)?
	)
;

//Entry rule entryRuleJvmFormalParameter
entryRuleJvmFormalParameter returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getJvmFormalParameterElementType()); }
	iv_ruleJvmFormalParameter=ruleJvmFormalParameter
	{ $current=$iv_ruleJvmFormalParameter.current; }
	EOF;

// Rule JvmFormalParameter
ruleJvmFormalParameter returns [Boolean current=false]
:
	(
		(
			(
				{
					markLeaf(elementTypeProvider.getJvmFormalParameter_ExtensionExtensionKeyword_0_0ElementType());
				}
				lv_extension_0_0='extension'
				{
					doneLeaf(lv_extension_0_0);
				}
				{
					if (!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)?
		(
			(
				{
					markComposite(elementTypeProvider.getJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_1_0ElementType());
				}
				lv_parameterType_1_0=ruleJvmTypeReference
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)?
		(
			(
				{
					markComposite(elementTypeProvider.getJvmFormalParameter_NameInnerVarIDParserRuleCall_2_0ElementType());
				}
				lv_name_2_0=ruleInnerVarID
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleFullJvmFormalParameter
entryRuleFullJvmFormalParameter returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getFullJvmFormalParameterElementType()); }
	iv_ruleFullJvmFormalParameter=ruleFullJvmFormalParameter
	{ $current=$iv_ruleFullJvmFormalParameter.current; }
	EOF;

// Rule FullJvmFormalParameter
ruleFullJvmFormalParameter returns [Boolean current=false]
:
	(
		(
			(
				{
					markLeaf(elementTypeProvider.getFullJvmFormalParameter_ExtensionExtensionKeyword_0_0ElementType());
				}
				lv_extension_0_0='extension'
				{
					doneLeaf(lv_extension_0_0);
				}
				{
					if (!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)?
		(
			(
				{
					markComposite(elementTypeProvider.getFullJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_1_0ElementType());
				}
				lv_parameterType_1_0=ruleJvmTypeReference
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		(
			(
				{
					markComposite(elementTypeProvider.getFullJvmFormalParameter_NameInnerVarIDParserRuleCall_2_0ElementType());
				}
				lv_name_2_0=ruleInnerVarID
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleXStringLiteral
entryRuleXStringLiteral returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXStringLiteralElementType()); }
	iv_ruleXStringLiteral=ruleXStringLiteral
	{ $current=$iv_ruleXStringLiteral.current; }
	EOF;

// Rule XStringLiteral
ruleXStringLiteral returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getXStringLiteral_SimpleStringLiteralParserRuleCall_0ElementType());
		}
		this_SimpleStringLiteral_0=ruleSimpleStringLiteral
		{
			$current = $this_SimpleStringLiteral_0.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getXStringLiteral_RichStringParserRuleCall_1ElementType());
		}
		this_RichString_1=ruleRichString
		{
			$current = $this_RichString_1.current;
			doneComposite();
		}
	)
;

//Entry rule entryRuleXSwitchExpression
entryRuleXSwitchExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXSwitchExpressionElementType()); }
	iv_ruleXSwitchExpression=ruleXSwitchExpression
	{ $current=$iv_ruleXSwitchExpression.current; }
	EOF;

// Rule XSwitchExpression
ruleXSwitchExpression returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXSwitchExpression_XSwitchExpressionAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		{
			markLeaf(elementTypeProvider.getXSwitchExpression_SwitchKeyword_1ElementType());
		}
		otherlv_1='switch'
		{
			doneLeaf(otherlv_1);
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
						{
							markLeaf(elementTypeProvider.getXSwitchExpression_LeftParenthesisKeyword_2_0_0_0_0ElementType());
						}
						otherlv_2='('
						{
							doneLeaf(otherlv_2);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0ElementType());
								}
								lv_declaredParam_3_0=ruleJvmFormalParameter
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
						{
							markLeaf(elementTypeProvider.getXSwitchExpression_ColonKeyword_2_0_0_0_2ElementType());
						}
						otherlv_4=':'
						{
							doneLeaf(otherlv_4);
						}
					)
				)
				(
					(
						{
							markComposite(elementTypeProvider.getXSwitchExpression_SwitchXExpressionParserRuleCall_2_0_1_0ElementType());
						}
						lv_switch_5_0=ruleXExpression
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				{
					markLeaf(elementTypeProvider.getXSwitchExpression_RightParenthesisKeyword_2_0_2ElementType());
				}
				otherlv_6=')'
				{
					doneLeaf(otherlv_6);
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
									markComposite(elementTypeProvider.getXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0ElementType());
								}
								lv_declaredParam_7_0=ruleJvmFormalParameter
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
						{
							markLeaf(elementTypeProvider.getXSwitchExpression_ColonKeyword_2_1_0_0_1ElementType());
						}
						otherlv_8=':'
						{
							doneLeaf(otherlv_8);
						}
					)
				)?
				(
					(
						{
							markComposite(elementTypeProvider.getXSwitchExpression_SwitchXExpressionOrSimpleConstructorCallParserRuleCall_2_1_1_0ElementType());
						}
						lv_switch_9_0=ruleXExpressionOrSimpleConstructorCall
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
			)
		)
		{
			markLeaf(elementTypeProvider.getXSwitchExpression_LeftCurlyBracketKeyword_3ElementType());
		}
		otherlv_10='{'
		{
			doneLeaf(otherlv_10);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getXSwitchExpression_CasesXCasePartParserRuleCall_4_0ElementType());
				}
				lv_cases_11_0=ruleXCasePart
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)*
		(
			{
				markLeaf(elementTypeProvider.getXSwitchExpression_DefaultKeyword_5_0ElementType());
			}
			otherlv_12='default'
			{
				doneLeaf(otherlv_12);
			}
			{
				markLeaf(elementTypeProvider.getXSwitchExpression_ColonKeyword_5_1ElementType());
			}
			otherlv_13=':'
			{
				doneLeaf(otherlv_13);
			}
			(
				(
					{
						markComposite(elementTypeProvider.getXSwitchExpression_DefaultXExpressionParserRuleCall_5_2_0ElementType());
					}
					lv_default_14_0=ruleXExpression
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)?
		{
			markLeaf(elementTypeProvider.getXSwitchExpression_RightCurlyBracketKeyword_6ElementType());
		}
		otherlv_15='}'
		{
			doneLeaf(otherlv_15);
		}
	)
;

//Entry rule entryRuleXExpressionOrSimpleConstructorCall
entryRuleXExpressionOrSimpleConstructorCall returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXExpressionOrSimpleConstructorCallElementType()); }
	iv_ruleXExpressionOrSimpleConstructorCall=ruleXExpressionOrSimpleConstructorCall
	{ $current=$iv_ruleXExpressionOrSimpleConstructorCall.current; }
	EOF;

// Rule XExpressionOrSimpleConstructorCall
ruleXExpressionOrSimpleConstructorCall returns [Boolean current=false]
:
	(
		(
			('new')=>
			{
				markComposite(elementTypeProvider.getXExpressionOrSimpleConstructorCall_XbaseConstructorCallParserRuleCall_0ElementType());
			}
			this_XbaseConstructorCall_0=ruleXbaseConstructorCall
			{
				$current = $this_XbaseConstructorCall_0.current;
				doneComposite();
			}
		)
		    |
		{
			markComposite(elementTypeProvider.getXExpressionOrSimpleConstructorCall_XExpressionParserRuleCall_1ElementType());
		}
		this_XExpression_1=ruleXExpression
		{
			$current = $this_XExpression_1.current;
			doneComposite();
		}
	)
;

//Entry rule entryRuleSimpleStringLiteral
entryRuleSimpleStringLiteral returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getSimpleStringLiteralElementType()); }
	iv_ruleSimpleStringLiteral=ruleSimpleStringLiteral
	{ $current=$iv_ruleSimpleStringLiteral.current; }
	EOF;

// Rule SimpleStringLiteral
ruleSimpleStringLiteral returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getSimpleStringLiteral_XStringLiteralAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		(
			(
				{
					markLeaf(elementTypeProvider.getSimpleStringLiteral_ValueSTRINGTerminalRuleCall_1_0ElementType());
				}
				{
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
				lv_value_1_0=RULE_STRING
				{
					doneLeaf(lv_value_1_0);
				}
			)
		)
	)
;

//Entry rule entryRuleRichString
entryRuleRichString returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getRichStringElementType()); }
	iv_ruleRichString=ruleRichString
	{ $current=$iv_ruleRichString.current; }
	EOF;

// Rule RichString
ruleRichString returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getRichString_RichStringAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		(
			(
				(
					{
						markComposite(elementTypeProvider.getRichString_ExpressionsRichStringLiteralParserRuleCall_1_0_0ElementType());
					}
					lv_expressions_1_0=ruleRichStringLiteral
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
			    |
			(
				(
					(
						{
							markComposite(elementTypeProvider.getRichString_ExpressionsRichStringLiteralStartParserRuleCall_1_1_0_0ElementType());
						}
						lv_expressions_2_0=ruleRichStringLiteralStart
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				(
					(
						{
							markComposite(elementTypeProvider.getRichString_ExpressionsRichStringPartParserRuleCall_1_1_1_0ElementType());
						}
						lv_expressions_3_0=ruleRichStringPart
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)?
				(
					(
						(
							{
								markComposite(elementTypeProvider.getRichString_ExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_2_0_0ElementType());
							}
							lv_expressions_4_0=ruleRichStringLiteralInbetween
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						(
							{
								markComposite(elementTypeProvider.getRichString_ExpressionsRichStringPartParserRuleCall_1_1_2_1_0ElementType());
							}
							lv_expressions_5_0=ruleRichStringPart
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)?
				)*
				(
					(
						{
							markComposite(elementTypeProvider.getRichString_ExpressionsRichStringLiteralEndParserRuleCall_1_1_3_0ElementType());
						}
						lv_expressions_6_0=ruleRichStringLiteralEnd
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
			)
		)
	)
;

//Entry rule entryRuleRichStringLiteral
entryRuleRichStringLiteral returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getRichStringLiteralElementType()); }
	iv_ruleRichStringLiteral=ruleRichStringLiteral
	{ $current=$iv_ruleRichStringLiteral.current; }
	EOF;

// Rule RichStringLiteral
ruleRichStringLiteral returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getRichStringLiteral_RichStringLiteralAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		(
			(
				{
					markLeaf(elementTypeProvider.getRichStringLiteral_ValueRICH_TEXTTerminalRuleCall_1_0ElementType());
				}
				{
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
				lv_value_1_0=RULE_RICH_TEXT
				{
					doneLeaf(lv_value_1_0);
				}
			)
		)
	)
;

//Entry rule entryRuleRichStringLiteralStart
entryRuleRichStringLiteralStart returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getRichStringLiteralStartElementType()); }
	iv_ruleRichStringLiteralStart=ruleRichStringLiteralStart
	{ $current=$iv_ruleRichStringLiteralStart.current; }
	EOF;

// Rule RichStringLiteralStart
ruleRichStringLiteralStart returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getRichStringLiteralStart_RichStringLiteralAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		(
			(
				{
					markLeaf(elementTypeProvider.getRichStringLiteralStart_ValueRICH_TEXT_STARTTerminalRuleCall_1_0ElementType());
				}
				{
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
				lv_value_1_0=RULE_RICH_TEXT_START
				{
					doneLeaf(lv_value_1_0);
				}
			)
		)
	)
;

//Entry rule entryRuleRichStringLiteralInbetween
entryRuleRichStringLiteralInbetween returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getRichStringLiteralInbetweenElementType()); }
	iv_ruleRichStringLiteralInbetween=ruleRichStringLiteralInbetween
	{ $current=$iv_ruleRichStringLiteralInbetween.current; }
	EOF;

// Rule RichStringLiteralInbetween
ruleRichStringLiteralInbetween returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getRichStringLiteralInbetween_RichStringLiteralAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		(
			(
				(
					{
						markLeaf(elementTypeProvider.getRichStringLiteralInbetween_ValueRICH_TEXT_INBETWEENTerminalRuleCall_1_0_0ElementType());
					}
					{
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
					lv_value_1_0=RULE_RICH_TEXT_INBETWEEN
					{
						doneLeaf(lv_value_1_0);
					}
				)
			)
			    |
			(
				(
					{
						markLeaf(elementTypeProvider.getRichStringLiteralInbetween_ValueCOMMENT_RICH_TEXT_INBETWEENTerminalRuleCall_1_1_0ElementType());
					}
					{
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
					lv_value_2_0=RULE_COMMENT_RICH_TEXT_INBETWEEN
					{
						doneLeaf(lv_value_2_0);
					}
				)
			)
		)
	)
;

//Entry rule entryRuleRichStringLiteralEnd
entryRuleRichStringLiteralEnd returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getRichStringLiteralEndElementType()); }
	iv_ruleRichStringLiteralEnd=ruleRichStringLiteralEnd
	{ $current=$iv_ruleRichStringLiteralEnd.current; }
	EOF;

// Rule RichStringLiteralEnd
ruleRichStringLiteralEnd returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getRichStringLiteralEnd_RichStringLiteralAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		(
			(
				(
					{
						markLeaf(elementTypeProvider.getRichStringLiteralEnd_ValueRICH_TEXT_ENDTerminalRuleCall_1_0_0ElementType());
					}
					{
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
					lv_value_1_0=RULE_RICH_TEXT_END
					{
						doneLeaf(lv_value_1_0);
					}
				)
			)
			    |
			(
				(
					{
						markLeaf(elementTypeProvider.getRichStringLiteralEnd_ValueCOMMENT_RICH_TEXT_ENDTerminalRuleCall_1_1_0ElementType());
					}
					{
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
					lv_value_2_0=RULE_COMMENT_RICH_TEXT_END
					{
						doneLeaf(lv_value_2_0);
					}
				)
			)
		)
	)
;

//Entry rule entryRuleInternalRichString
entryRuleInternalRichString returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getInternalRichStringElementType()); }
	iv_ruleInternalRichString=ruleInternalRichString
	{ $current=$iv_ruleInternalRichString.current; }
	EOF;

// Rule InternalRichString
ruleInternalRichString returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getInternalRichString_RichStringAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		(
			(
				(
					{
						markComposite(elementTypeProvider.getInternalRichString_ExpressionsRichStringLiteralInbetweenParserRuleCall_1_0_0ElementType());
					}
					lv_expressions_1_0=ruleRichStringLiteralInbetween
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
			(
				(
					(
						{
							markComposite(elementTypeProvider.getInternalRichString_ExpressionsRichStringPartParserRuleCall_1_1_0_0ElementType());
						}
						lv_expressions_2_0=ruleRichStringPart
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)?
				(
					(
						{
							markComposite(elementTypeProvider.getInternalRichString_ExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_1_0ElementType());
						}
						lv_expressions_3_0=ruleRichStringLiteralInbetween
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
			)*
		)
	)
;

//Entry rule entryRuleRichStringPart
entryRuleRichStringPart returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getRichStringPartElementType()); }
	iv_ruleRichStringPart=ruleRichStringPart
	{ $current=$iv_ruleRichStringPart.current; }
	EOF;

// Rule RichStringPart
ruleRichStringPart returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getRichStringPart_XExpressionOrVarDeclarationParserRuleCall_0ElementType());
		}
		this_XExpressionOrVarDeclaration_0=ruleXExpressionOrVarDeclaration
		{
			$current = $this_XExpressionOrVarDeclaration_0.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getRichStringPart_RichStringForLoopParserRuleCall_1ElementType());
		}
		this_RichStringForLoop_1=ruleRichStringForLoop
		{
			$current = $this_RichStringForLoop_1.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getRichStringPart_RichStringIfParserRuleCall_2ElementType());
		}
		this_RichStringIf_2=ruleRichStringIf
		{
			$current = $this_RichStringIf_2.current;
			doneComposite();
		}
	)
;

//Entry rule entryRuleRichStringForLoop
entryRuleRichStringForLoop returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getRichStringForLoopElementType()); }
	iv_ruleRichStringForLoop=ruleRichStringForLoop
	{ $current=$iv_ruleRichStringForLoop.current; }
	EOF;

// Rule RichStringForLoop
ruleRichStringForLoop returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getRichStringForLoop_RichStringForLoopAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		{
			markLeaf(elementTypeProvider.getRichStringForLoop_FORKeyword_1ElementType());
		}
		otherlv_1='FOR'
		{
			doneLeaf(otherlv_1);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getRichStringForLoop_DeclaredParamJvmFormalParameterParserRuleCall_2_0ElementType());
				}
				lv_declaredParam_2_0=ruleJvmFormalParameter
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		{
			markLeaf(elementTypeProvider.getRichStringForLoop_ColonKeyword_3ElementType());
		}
		otherlv_3=':'
		{
			doneLeaf(otherlv_3);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getRichStringForLoop_ForExpressionXExpressionParserRuleCall_4_0ElementType());
				}
				lv_forExpression_4_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		(
			{
				markLeaf(elementTypeProvider.getRichStringForLoop_BEFOREKeyword_5_0ElementType());
			}
			otherlv_5='BEFORE'
			{
				doneLeaf(otherlv_5);
			}
			(
				(
					{
						markComposite(elementTypeProvider.getRichStringForLoop_BeforeXExpressionParserRuleCall_5_1_0ElementType());
					}
					lv_before_6_0=ruleXExpression
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)?
		(
			{
				markLeaf(elementTypeProvider.getRichStringForLoop_SEPARATORKeyword_6_0ElementType());
			}
			otherlv_7='SEPARATOR'
			{
				doneLeaf(otherlv_7);
			}
			(
				(
					{
						markComposite(elementTypeProvider.getRichStringForLoop_SeparatorXExpressionParserRuleCall_6_1_0ElementType());
					}
					lv_separator_8_0=ruleXExpression
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)?
		(
			{
				markLeaf(elementTypeProvider.getRichStringForLoop_AFTERKeyword_7_0ElementType());
			}
			otherlv_9='AFTER'
			{
				doneLeaf(otherlv_9);
			}
			(
				(
					{
						markComposite(elementTypeProvider.getRichStringForLoop_AfterXExpressionParserRuleCall_7_1_0ElementType());
					}
					lv_after_10_0=ruleXExpression
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)?
		(
			(
				{
					markComposite(elementTypeProvider.getRichStringForLoop_EachExpressionInternalRichStringParserRuleCall_8_0ElementType());
				}
				lv_eachExpression_11_0=ruleInternalRichString
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		{
			markLeaf(elementTypeProvider.getRichStringForLoop_ENDFORKeyword_9ElementType());
		}
		otherlv_12='ENDFOR'
		{
			doneLeaf(otherlv_12);
		}
	)
;

//Entry rule entryRuleRichStringIf
entryRuleRichStringIf returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getRichStringIfElementType()); }
	iv_ruleRichStringIf=ruleRichStringIf
	{ $current=$iv_ruleRichStringIf.current; }
	EOF;

// Rule RichStringIf
ruleRichStringIf returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getRichStringIf_RichStringIfAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		{
			markLeaf(elementTypeProvider.getRichStringIf_IFKeyword_1ElementType());
		}
		otherlv_1='IF'
		{
			doneLeaf(otherlv_1);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getRichStringIf_IfXExpressionParserRuleCall_2_0ElementType());
				}
				lv_if_2_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		(
			(
				{
					markComposite(elementTypeProvider.getRichStringIf_ThenInternalRichStringParserRuleCall_3_0ElementType());
				}
				lv_then_3_0=ruleInternalRichString
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		(
			(
				{
					markComposite(elementTypeProvider.getRichStringIf_ElseIfsRichStringElseIfParserRuleCall_4_0ElementType());
				}
				lv_elseIfs_4_0=ruleRichStringElseIf
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)*
		(
			{
				markLeaf(elementTypeProvider.getRichStringIf_ELSEKeyword_5_0ElementType());
			}
			otherlv_5='ELSE'
			{
				doneLeaf(otherlv_5);
			}
			(
				(
					{
						markComposite(elementTypeProvider.getRichStringIf_ElseInternalRichStringParserRuleCall_5_1_0ElementType());
					}
					lv_else_6_0=ruleInternalRichString
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)?
		{
			markLeaf(elementTypeProvider.getRichStringIf_ENDIFKeyword_6ElementType());
		}
		otherlv_7='ENDIF'
		{
			doneLeaf(otherlv_7);
		}
	)
;

//Entry rule entryRuleRichStringElseIf
entryRuleRichStringElseIf returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getRichStringElseIfElementType()); }
	iv_ruleRichStringElseIf=ruleRichStringElseIf
	{ $current=$iv_ruleRichStringElseIf.current; }
	EOF;

// Rule RichStringElseIf
ruleRichStringElseIf returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getRichStringElseIf_ELSEIFKeyword_0ElementType());
		}
		otherlv_0='ELSEIF'
		{
			doneLeaf(otherlv_0);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getRichStringElseIf_IfXExpressionParserRuleCall_1_0ElementType());
				}
				lv_if_1_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		(
			(
				{
					markComposite(elementTypeProvider.getRichStringElseIf_ThenInternalRichStringParserRuleCall_2_0ElementType());
				}
				lv_then_2_0=ruleInternalRichString
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleXAnnotation
entryRuleXAnnotation returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXAnnotationElementType()); }
	iv_ruleXAnnotation=ruleXAnnotation
	{ $current=$iv_ruleXAnnotation.current; }
	EOF;

// Rule XAnnotation
ruleXAnnotation returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXAnnotation_XAnnotationAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		{
			markLeaf(elementTypeProvider.getXAnnotation_CommercialAtKeyword_1ElementType());
		}
		otherlv_1='@'
		{
			doneLeaf(otherlv_1);
		}
		(
			(
				{
					if (!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
				{
					markComposite(elementTypeProvider.getXAnnotation_AnnotationTypeJvmAnnotationTypeCrossReference_2_0ElementType());
				}
				ruleQualifiedName
				{
					doneComposite();
				}
			)
		)
		(
			(
				('(')=>
				{
					markLeaf(elementTypeProvider.getXAnnotation_LeftParenthesisKeyword_3_0ElementType());
				}
				otherlv_3='('
				{
					doneLeaf(otherlv_3);
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
								markComposite(elementTypeProvider.getXAnnotation_ElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_0_0ElementType());
							}
							lv_elementValuePairs_4_0=ruleXAnnotationElementValuePair
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getXAnnotation_CommaKeyword_3_1_0_1_0ElementType());
						}
						otherlv_5=','
						{
							doneLeaf(otherlv_5);
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
									markComposite(elementTypeProvider.getXAnnotation_ElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_1_1_0ElementType());
								}
								lv_elementValuePairs_6_0=ruleXAnnotationElementValuePair
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
				)
				    |
				(
					(
						{
							markComposite(elementTypeProvider.getXAnnotation_ValueXAnnotationElementValueOrCommaListParserRuleCall_3_1_1_0ElementType());
						}
						lv_value_7_0=ruleXAnnotationElementValueOrCommaList
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
			)?
			{
				markLeaf(elementTypeProvider.getXAnnotation_RightParenthesisKeyword_3_2ElementType());
			}
			otherlv_8=')'
			{
				doneLeaf(otherlv_8);
			}
		)?
	)
;

//Entry rule entryRuleXAnnotationElementValuePair
entryRuleXAnnotationElementValuePair returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXAnnotationElementValuePairElementType()); }
	iv_ruleXAnnotationElementValuePair=ruleXAnnotationElementValuePair
	{ $current=$iv_ruleXAnnotationElementValuePair.current; }
	EOF;

// Rule XAnnotationElementValuePair
ruleXAnnotationElementValuePair returns [Boolean current=false]
:
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
							if (!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
						{
							markComposite(elementTypeProvider.getXAnnotationElementValuePair_ElementJvmOperationCrossReference_0_0_0_0ElementType());
						}
						ruleValidID
						{
							doneComposite();
						}
					)
				)
				{
					markLeaf(elementTypeProvider.getXAnnotationElementValuePair_EqualsSignKeyword_0_0_1ElementType());
				}
				otherlv_1='='
				{
					doneLeaf(otherlv_1);
				}
			)
		)
		(
			(
				{
					markComposite(elementTypeProvider.getXAnnotationElementValuePair_ValueXAnnotationElementValueParserRuleCall_1_0ElementType());
				}
				lv_value_2_0=ruleXAnnotationElementValue
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleXAnnotationElementValueOrCommaList
entryRuleXAnnotationElementValueOrCommaList returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXAnnotationElementValueOrCommaListElementType()); }
	iv_ruleXAnnotationElementValueOrCommaList=ruleXAnnotationElementValueOrCommaList
	{ $current=$iv_ruleXAnnotationElementValueOrCommaList.current; }
	EOF;

// Rule XAnnotationElementValueOrCommaList
ruleXAnnotationElementValueOrCommaList returns [Boolean current=false]
:
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
							precedeComposite(elementTypeProvider.getXAnnotationElementValueOrCommaList_XListLiteralAction_0_0_0_0ElementType());
							doneComposite();
							associateWithSemanticElement();
						}
					)
					{
						markLeaf(elementTypeProvider.getXAnnotationElementValueOrCommaList_NumberSignKeyword_0_0_0_1ElementType());
					}
					otherlv_1='#'
					{
						doneLeaf(otherlv_1);
					}
					{
						markLeaf(elementTypeProvider.getXAnnotationElementValueOrCommaList_LeftSquareBracketKeyword_0_0_0_2ElementType());
					}
					otherlv_2='['
					{
						doneLeaf(otherlv_2);
					}
				)
			)
			(
				(
					(
						{
							markComposite(elementTypeProvider.getXAnnotationElementValueOrCommaList_ElementsXAnnotationOrExpressionParserRuleCall_0_1_0_0ElementType());
						}
						lv_elements_3_0=ruleXAnnotationOrExpression
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				(
					{
						markLeaf(elementTypeProvider.getXAnnotationElementValueOrCommaList_CommaKeyword_0_1_1_0ElementType());
					}
					otherlv_4=','
					{
						doneLeaf(otherlv_4);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getXAnnotationElementValueOrCommaList_ElementsXAnnotationOrExpressionParserRuleCall_0_1_1_1_0ElementType());
							}
							lv_elements_5_0=ruleXAnnotationOrExpression
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
				)*
			)?
			{
				markLeaf(elementTypeProvider.getXAnnotationElementValueOrCommaList_RightSquareBracketKeyword_0_2ElementType());
			}
			otherlv_6=']'
			{
				doneLeaf(otherlv_6);
			}
		)
		    |
		(
			{
				markComposite(elementTypeProvider.getXAnnotationElementValueOrCommaList_XAnnotationOrExpressionParserRuleCall_1_0ElementType());
			}
			this_XAnnotationOrExpression_7=ruleXAnnotationOrExpression
			{
				$current = $this_XAnnotationOrExpression_7.current;
				doneComposite();
			}
			(
				(
					{
						precedeComposite(elementTypeProvider.getXAnnotationElementValueOrCommaList_XListLiteralElementsAction_1_1_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				(
					{
						markLeaf(elementTypeProvider.getXAnnotationElementValueOrCommaList_CommaKeyword_1_1_1_0ElementType());
					}
					otherlv_9=','
					{
						doneLeaf(otherlv_9);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getXAnnotationElementValueOrCommaList_ElementsXAnnotationOrExpressionParserRuleCall_1_1_1_1_0ElementType());
							}
							lv_elements_10_0=ruleXAnnotationOrExpression
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
				)+
			)?
		)
	)
;

//Entry rule entryRuleXAnnotationElementValue
entryRuleXAnnotationElementValue returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXAnnotationElementValueElementType()); }
	iv_ruleXAnnotationElementValue=ruleXAnnotationElementValue
	{ $current=$iv_ruleXAnnotationElementValue.current; }
	EOF;

// Rule XAnnotationElementValue
ruleXAnnotationElementValue returns [Boolean current=false]
:
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
							precedeComposite(elementTypeProvider.getXAnnotationElementValue_XListLiteralAction_0_0_0_0ElementType());
							doneComposite();
							associateWithSemanticElement();
						}
					)
					{
						markLeaf(elementTypeProvider.getXAnnotationElementValue_NumberSignKeyword_0_0_0_1ElementType());
					}
					otherlv_1='#'
					{
						doneLeaf(otherlv_1);
					}
					{
						markLeaf(elementTypeProvider.getXAnnotationElementValue_LeftSquareBracketKeyword_0_0_0_2ElementType());
					}
					otherlv_2='['
					{
						doneLeaf(otherlv_2);
					}
				)
			)
			(
				(
					(
						{
							markComposite(elementTypeProvider.getXAnnotationElementValue_ElementsXAnnotationOrExpressionParserRuleCall_0_1_0_0ElementType());
						}
						lv_elements_3_0=ruleXAnnotationOrExpression
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				(
					{
						markLeaf(elementTypeProvider.getXAnnotationElementValue_CommaKeyword_0_1_1_0ElementType());
					}
					otherlv_4=','
					{
						doneLeaf(otherlv_4);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getXAnnotationElementValue_ElementsXAnnotationOrExpressionParserRuleCall_0_1_1_1_0ElementType());
							}
							lv_elements_5_0=ruleXAnnotationOrExpression
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
				)*
			)?
			{
				markLeaf(elementTypeProvider.getXAnnotationElementValue_RightSquareBracketKeyword_0_2ElementType());
			}
			otherlv_6=']'
			{
				doneLeaf(otherlv_6);
			}
		)
		    |
		{
			markComposite(elementTypeProvider.getXAnnotationElementValue_XAnnotationOrExpressionParserRuleCall_1ElementType());
		}
		this_XAnnotationOrExpression_7=ruleXAnnotationOrExpression
		{
			$current = $this_XAnnotationOrExpression_7.current;
			doneComposite();
		}
	)
;

//Entry rule entryRuleXAnnotationOrExpression
entryRuleXAnnotationOrExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXAnnotationOrExpressionElementType()); }
	iv_ruleXAnnotationOrExpression=ruleXAnnotationOrExpression
	{ $current=$iv_ruleXAnnotationOrExpression.current; }
	EOF;

// Rule XAnnotationOrExpression
ruleXAnnotationOrExpression returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getXAnnotationOrExpression_XAnnotationParserRuleCall_0ElementType());
		}
		this_XAnnotation_0=ruleXAnnotation
		{
			$current = $this_XAnnotation_0.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getXAnnotationOrExpression_XExpressionParserRuleCall_1ElementType());
		}
		this_XExpression_1=ruleXExpression
		{
			$current = $this_XExpression_1.current;
			doneComposite();
		}
	)
;

//Entry rule entryRuleXExpression
entryRuleXExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXExpressionElementType()); }
	iv_ruleXExpression=ruleXExpression
	{ $current=$iv_ruleXExpression.current; }
	EOF;

// Rule XExpression
ruleXExpression returns [Boolean current=false]
:
	{
		markComposite(elementTypeProvider.getXExpression_XAssignmentParserRuleCallElementType());
	}
	this_XAssignment_0=ruleXAssignment
	{
		$current = $this_XAssignment_0.current;
		doneComposite();
	}
;

//Entry rule entryRuleXAssignment
entryRuleXAssignment returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXAssignmentElementType()); }
	iv_ruleXAssignment=ruleXAssignment
	{ $current=$iv_ruleXAssignment.current; }
	EOF;

// Rule XAssignment
ruleXAssignment returns [Boolean current=false]
:
	(
		(
			(
				{
					precedeComposite(elementTypeProvider.getXAssignment_XAssignmentAction_0_0ElementType());
					doneComposite();
					associateWithSemanticElement();
				}
			)
			(
				(
					{
						if (!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
					{
						markComposite(elementTypeProvider.getXAssignment_FeatureJvmIdentifiableElementCrossReference_0_1_0ElementType());
					}
					ruleFeatureCallID
					{
						doneComposite();
					}
				)
			)
			{
				markComposite(elementTypeProvider.getXAssignment_OpSingleAssignParserRuleCall_0_2ElementType());
			}
			ruleOpSingleAssign
			{
				doneComposite();
			}
			(
				(
					{
						markComposite(elementTypeProvider.getXAssignment_ValueXAssignmentParserRuleCall_0_3_0ElementType());
					}
					lv_value_3_0=ruleXAssignment
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)
		    |
		(
			{
				markComposite(elementTypeProvider.getXAssignment_XOrExpressionParserRuleCall_1_0ElementType());
			}
			this_XOrExpression_4=ruleXOrExpression
			{
				$current = $this_XOrExpression_4.current;
				doneComposite();
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
								precedeComposite(elementTypeProvider.getXAssignment_XBinaryOperationLeftOperandAction_1_1_0_0_0ElementType());
								doneComposite();
								associateWithSemanticElement();
							}
						)
						(
							(
								{
									if (!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
								{
									markComposite(elementTypeProvider.getXAssignment_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0ElementType());
								}
								ruleOpMultiAssign
								{
									doneComposite();
								}
							)
						)
					)
				)
				(
					(
						{
							markComposite(elementTypeProvider.getXAssignment_RightOperandXAssignmentParserRuleCall_1_1_1_0ElementType());
						}
						lv_rightOperand_7_0=ruleXAssignment
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
			)?
		)
	)
;

//Entry rule entryRuleOpSingleAssign
entryRuleOpSingleAssign returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getOpSingleAssignElementType()); }
	iv_ruleOpSingleAssign=ruleOpSingleAssign
	{ $current=$iv_ruleOpSingleAssign.current; }
	EOF;

// Rule OpSingleAssign
ruleOpSingleAssign returns [Boolean current=false]
:
	{
		markLeaf(elementTypeProvider.getOpSingleAssign_EqualsSignKeywordElementType());
	}
	kw='='
	{
		doneLeaf(kw);
	}
;

//Entry rule entryRuleOpMultiAssign
entryRuleOpMultiAssign returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getOpMultiAssignElementType()); }
	iv_ruleOpMultiAssign=ruleOpMultiAssign
	{ $current=$iv_ruleOpMultiAssign.current; }
	EOF;

// Rule OpMultiAssign
ruleOpMultiAssign returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getOpMultiAssign_PlusSignEqualsSignKeyword_0ElementType());
		}
		kw='+='
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getOpMultiAssign_HyphenMinusEqualsSignKeyword_1ElementType());
		}
		kw='-='
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getOpMultiAssign_AsteriskEqualsSignKeyword_2ElementType());
		}
		kw='*='
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getOpMultiAssign_SolidusEqualsSignKeyword_3ElementType());
		}
		kw='/='
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getOpMultiAssign_PercentSignEqualsSignKeyword_4ElementType());
		}
		kw='%='
		{
			doneLeaf(kw);
		}
		    |
		(
			{
				markLeaf(elementTypeProvider.getOpMultiAssign_LessThanSignKeyword_5_0ElementType());
			}
			kw='<'
			{
				doneLeaf(kw);
			}
			{
				markLeaf(elementTypeProvider.getOpMultiAssign_LessThanSignKeyword_5_1ElementType());
			}
			kw='<'
			{
				doneLeaf(kw);
			}
			{
				markLeaf(elementTypeProvider.getOpMultiAssign_EqualsSignKeyword_5_2ElementType());
			}
			kw='='
			{
				doneLeaf(kw);
			}
		)
		    |
		(
			{
				markLeaf(elementTypeProvider.getOpMultiAssign_GreaterThanSignKeyword_6_0ElementType());
			}
			kw='>'
			{
				doneLeaf(kw);
			}
			(
				{
					markLeaf(elementTypeProvider.getOpMultiAssign_GreaterThanSignKeyword_6_1ElementType());
				}
				kw='>'
				{
					doneLeaf(kw);
				}
			)?
			{
				markLeaf(elementTypeProvider.getOpMultiAssign_GreaterThanSignEqualsSignKeyword_6_2ElementType());
			}
			kw='>='
			{
				doneLeaf(kw);
			}
		)
	)
;

//Entry rule entryRuleXOrExpression
entryRuleXOrExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXOrExpressionElementType()); }
	iv_ruleXOrExpression=ruleXOrExpression
	{ $current=$iv_ruleXOrExpression.current; }
	EOF;

// Rule XOrExpression
ruleXOrExpression returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getXOrExpression_XAndExpressionParserRuleCall_0ElementType());
		}
		this_XAndExpression_0=ruleXAndExpression
		{
			$current = $this_XAndExpression_0.current;
			doneComposite();
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
							precedeComposite(elementTypeProvider.getXOrExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
							doneComposite();
							associateWithSemanticElement();
						}
					)
					(
						(
							{
								if (!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
							{
								markComposite(elementTypeProvider.getXOrExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
							}
							ruleOpOr
							{
								doneComposite();
							}
						)
					)
				)
			)
			(
				(
					{
						markComposite(elementTypeProvider.getXOrExpression_RightOperandXAndExpressionParserRuleCall_1_1_0ElementType());
					}
					lv_rightOperand_3_0=ruleXAndExpression
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)*
	)
;

//Entry rule entryRuleOpOr
entryRuleOpOr returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getOpOrElementType()); }
	iv_ruleOpOr=ruleOpOr
	{ $current=$iv_ruleOpOr.current; }
	EOF;

// Rule OpOr
ruleOpOr returns [Boolean current=false]
:
	{
		markLeaf(elementTypeProvider.getOpOr_VerticalLineVerticalLineKeywordElementType());
	}
	kw='||'
	{
		doneLeaf(kw);
	}
;

//Entry rule entryRuleXAndExpression
entryRuleXAndExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXAndExpressionElementType()); }
	iv_ruleXAndExpression=ruleXAndExpression
	{ $current=$iv_ruleXAndExpression.current; }
	EOF;

// Rule XAndExpression
ruleXAndExpression returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getXAndExpression_XEqualityExpressionParserRuleCall_0ElementType());
		}
		this_XEqualityExpression_0=ruleXEqualityExpression
		{
			$current = $this_XEqualityExpression_0.current;
			doneComposite();
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
							precedeComposite(elementTypeProvider.getXAndExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
							doneComposite();
							associateWithSemanticElement();
						}
					)
					(
						(
							{
								if (!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
							{
								markComposite(elementTypeProvider.getXAndExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
							}
							ruleOpAnd
							{
								doneComposite();
							}
						)
					)
				)
			)
			(
				(
					{
						markComposite(elementTypeProvider.getXAndExpression_RightOperandXEqualityExpressionParserRuleCall_1_1_0ElementType());
					}
					lv_rightOperand_3_0=ruleXEqualityExpression
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)*
	)
;

//Entry rule entryRuleOpAnd
entryRuleOpAnd returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getOpAndElementType()); }
	iv_ruleOpAnd=ruleOpAnd
	{ $current=$iv_ruleOpAnd.current; }
	EOF;

// Rule OpAnd
ruleOpAnd returns [Boolean current=false]
:
	{
		markLeaf(elementTypeProvider.getOpAnd_AmpersandAmpersandKeywordElementType());
	}
	kw='&&'
	{
		doneLeaf(kw);
	}
;

//Entry rule entryRuleXEqualityExpression
entryRuleXEqualityExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXEqualityExpressionElementType()); }
	iv_ruleXEqualityExpression=ruleXEqualityExpression
	{ $current=$iv_ruleXEqualityExpression.current; }
	EOF;

// Rule XEqualityExpression
ruleXEqualityExpression returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getXEqualityExpression_XRelationalExpressionParserRuleCall_0ElementType());
		}
		this_XRelationalExpression_0=ruleXRelationalExpression
		{
			$current = $this_XRelationalExpression_0.current;
			doneComposite();
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
							precedeComposite(elementTypeProvider.getXEqualityExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
							doneComposite();
							associateWithSemanticElement();
						}
					)
					(
						(
							{
								if (!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
							{
								markComposite(elementTypeProvider.getXEqualityExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
							}
							ruleOpEquality
							{
								doneComposite();
							}
						)
					)
				)
			)
			(
				(
					{
						markComposite(elementTypeProvider.getXEqualityExpression_RightOperandXRelationalExpressionParserRuleCall_1_1_0ElementType());
					}
					lv_rightOperand_3_0=ruleXRelationalExpression
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)*
	)
;

//Entry rule entryRuleOpEquality
entryRuleOpEquality returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getOpEqualityElementType()); }
	iv_ruleOpEquality=ruleOpEquality
	{ $current=$iv_ruleOpEquality.current; }
	EOF;

// Rule OpEquality
ruleOpEquality returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getOpEquality_EqualsSignEqualsSignKeyword_0ElementType());
		}
		kw='=='
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getOpEquality_ExclamationMarkEqualsSignKeyword_1ElementType());
		}
		kw='!='
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getOpEquality_EqualsSignEqualsSignEqualsSignKeyword_2ElementType());
		}
		kw='==='
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getOpEquality_ExclamationMarkEqualsSignEqualsSignKeyword_3ElementType());
		}
		kw='!=='
		{
			doneLeaf(kw);
		}
	)
;

//Entry rule entryRuleXRelationalExpression
entryRuleXRelationalExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXRelationalExpressionElementType()); }
	iv_ruleXRelationalExpression=ruleXRelationalExpression
	{ $current=$iv_ruleXRelationalExpression.current; }
	EOF;

// Rule XRelationalExpression
ruleXRelationalExpression returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getXRelationalExpression_XOtherOperatorExpressionParserRuleCall_0ElementType());
		}
		this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression
		{
			$current = $this_XOtherOperatorExpression_0.current;
			doneComposite();
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
								precedeComposite(elementTypeProvider.getXRelationalExpression_XInstanceOfExpressionExpressionAction_1_0_0_0_0ElementType());
								doneComposite();
								associateWithSemanticElement();
							}
						)
						{
							markLeaf(elementTypeProvider.getXRelationalExpression_InstanceofKeyword_1_0_0_0_1ElementType());
						}
						otherlv_2='instanceof'
						{
							doneLeaf(otherlv_2);
						}
					)
				)
				(
					(
						{
							markComposite(elementTypeProvider.getXRelationalExpression_TypeJvmTypeReferenceParserRuleCall_1_0_1_0ElementType());
						}
						lv_type_3_0=ruleJvmTypeReference
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
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
								precedeComposite(elementTypeProvider.getXRelationalExpression_XBinaryOperationLeftOperandAction_1_1_0_0_0ElementType());
								doneComposite();
								associateWithSemanticElement();
							}
						)
						(
							(
								{
									if (!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
								{
									markComposite(elementTypeProvider.getXRelationalExpression_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0ElementType());
								}
								ruleOpCompare
								{
									doneComposite();
								}
							)
						)
					)
				)
				(
					(
						{
							markComposite(elementTypeProvider.getXRelationalExpression_RightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0ElementType());
						}
						lv_rightOperand_6_0=ruleXOtherOperatorExpression
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
			)
		)*
	)
;

//Entry rule entryRuleOpCompare
entryRuleOpCompare returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getOpCompareElementType()); }
	iv_ruleOpCompare=ruleOpCompare
	{ $current=$iv_ruleOpCompare.current; }
	EOF;

// Rule OpCompare
ruleOpCompare returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getOpCompare_GreaterThanSignEqualsSignKeyword_0ElementType());
		}
		kw='>='
		{
			doneLeaf(kw);
		}
		    |
		(
			{
				markLeaf(elementTypeProvider.getOpCompare_LessThanSignKeyword_1_0ElementType());
			}
			kw='<'
			{
				doneLeaf(kw);
			}
			{
				markLeaf(elementTypeProvider.getOpCompare_EqualsSignKeyword_1_1ElementType());
			}
			kw='='
			{
				doneLeaf(kw);
			}
		)
		    |
		{
			markLeaf(elementTypeProvider.getOpCompare_GreaterThanSignKeyword_2ElementType());
		}
		kw='>'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getOpCompare_LessThanSignKeyword_3ElementType());
		}
		kw='<'
		{
			doneLeaf(kw);
		}
	)
;

//Entry rule entryRuleXOtherOperatorExpression
entryRuleXOtherOperatorExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXOtherOperatorExpressionElementType()); }
	iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression
	{ $current=$iv_ruleXOtherOperatorExpression.current; }
	EOF;

// Rule XOtherOperatorExpression
ruleXOtherOperatorExpression returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getXOtherOperatorExpression_XAdditiveExpressionParserRuleCall_0ElementType());
		}
		this_XAdditiveExpression_0=ruleXAdditiveExpression
		{
			$current = $this_XAdditiveExpression_0.current;
			doneComposite();
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
							precedeComposite(elementTypeProvider.getXOtherOperatorExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
							doneComposite();
							associateWithSemanticElement();
						}
					)
					(
						(
							{
								if (!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
							{
								markComposite(elementTypeProvider.getXOtherOperatorExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
							}
							ruleOpOther
							{
								doneComposite();
							}
						)
					)
				)
			)
			(
				(
					{
						markComposite(elementTypeProvider.getXOtherOperatorExpression_RightOperandXAdditiveExpressionParserRuleCall_1_1_0ElementType());
					}
					lv_rightOperand_3_0=ruleXAdditiveExpression
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)*
	)
;

//Entry rule entryRuleOpOther
entryRuleOpOther returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getOpOtherElementType()); }
	iv_ruleOpOther=ruleOpOther
	{ $current=$iv_ruleOpOther.current; }
	EOF;

// Rule OpOther
ruleOpOther returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getOpOther_HyphenMinusGreaterThanSignKeyword_0ElementType());
		}
		kw='->'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getOpOther_FullStopFullStopLessThanSignKeyword_1ElementType());
		}
		kw='..<'
		{
			doneLeaf(kw);
		}
		    |
		(
			{
				markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_2_0ElementType());
			}
			kw='>'
			{
				doneLeaf(kw);
			}
			{
				markLeaf(elementTypeProvider.getOpOther_FullStopFullStopKeyword_2_1ElementType());
			}
			kw='..'
			{
				doneLeaf(kw);
			}
		)
		    |
		{
			markLeaf(elementTypeProvider.getOpOther_FullStopFullStopKeyword_3ElementType());
		}
		kw='..'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getOpOther_EqualsSignGreaterThanSignKeyword_4ElementType());
		}
		kw='=>'
		{
			doneLeaf(kw);
		}
		    |
		(
			{
				markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_0ElementType());
			}
			kw='>'
			{
				doneLeaf(kw);
			}
			(
				(
					((
						'>'
						'>'
					)
					)=>
					(
						{
							markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_1_0_0_0ElementType());
						}
						kw='>'
						{
							doneLeaf(kw);
						}
						{
							markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_1_0_0_1ElementType());
						}
						kw='>'
						{
							doneLeaf(kw);
						}
					)
				)
				    |
				{
					markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_1_1ElementType());
				}
				kw='>'
				{
					doneLeaf(kw);
				}
			)
		)
		    |
		(
			{
				markLeaf(elementTypeProvider.getOpOther_LessThanSignKeyword_6_0ElementType());
			}
			kw='<'
			{
				doneLeaf(kw);
			}
			(
				(
					((
						'<'
						'<'
					)
					)=>
					(
						{
							markLeaf(elementTypeProvider.getOpOther_LessThanSignKeyword_6_1_0_0_0ElementType());
						}
						kw='<'
						{
							doneLeaf(kw);
						}
						{
							markLeaf(elementTypeProvider.getOpOther_LessThanSignKeyword_6_1_0_0_1ElementType());
						}
						kw='<'
						{
							doneLeaf(kw);
						}
					)
				)
				    |
				{
					markLeaf(elementTypeProvider.getOpOther_LessThanSignKeyword_6_1_1ElementType());
				}
				kw='<'
				{
					doneLeaf(kw);
				}
				    |
				{
					markLeaf(elementTypeProvider.getOpOther_EqualsSignGreaterThanSignKeyword_6_1_2ElementType());
				}
				kw='=>'
				{
					doneLeaf(kw);
				}
			)
		)
		    |
		{
			markLeaf(elementTypeProvider.getOpOther_LessThanSignGreaterThanSignKeyword_7ElementType());
		}
		kw='<>'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getOpOther_QuestionMarkColonKeyword_8ElementType());
		}
		kw='?:'
		{
			doneLeaf(kw);
		}
	)
;

//Entry rule entryRuleXAdditiveExpression
entryRuleXAdditiveExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXAdditiveExpressionElementType()); }
	iv_ruleXAdditiveExpression=ruleXAdditiveExpression
	{ $current=$iv_ruleXAdditiveExpression.current; }
	EOF;

// Rule XAdditiveExpression
ruleXAdditiveExpression returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getXAdditiveExpression_XMultiplicativeExpressionParserRuleCall_0ElementType());
		}
		this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression
		{
			$current = $this_XMultiplicativeExpression_0.current;
			doneComposite();
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
							precedeComposite(elementTypeProvider.getXAdditiveExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
							doneComposite();
							associateWithSemanticElement();
						}
					)
					(
						(
							{
								if (!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
							{
								markComposite(elementTypeProvider.getXAdditiveExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
							}
							ruleOpAdd
							{
								doneComposite();
							}
						)
					)
				)
			)
			(
				(
					{
						markComposite(elementTypeProvider.getXAdditiveExpression_RightOperandXMultiplicativeExpressionParserRuleCall_1_1_0ElementType());
					}
					lv_rightOperand_3_0=ruleXMultiplicativeExpression
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)*
	)
;

//Entry rule entryRuleOpAdd
entryRuleOpAdd returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getOpAddElementType()); }
	iv_ruleOpAdd=ruleOpAdd
	{ $current=$iv_ruleOpAdd.current; }
	EOF;

// Rule OpAdd
ruleOpAdd returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getOpAdd_PlusSignKeyword_0ElementType());
		}
		kw='+'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getOpAdd_HyphenMinusKeyword_1ElementType());
		}
		kw='-'
		{
			doneLeaf(kw);
		}
	)
;

//Entry rule entryRuleXMultiplicativeExpression
entryRuleXMultiplicativeExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXMultiplicativeExpressionElementType()); }
	iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression
	{ $current=$iv_ruleXMultiplicativeExpression.current; }
	EOF;

// Rule XMultiplicativeExpression
ruleXMultiplicativeExpression returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getXMultiplicativeExpression_XUnaryOperationParserRuleCall_0ElementType());
		}
		this_XUnaryOperation_0=ruleXUnaryOperation
		{
			$current = $this_XUnaryOperation_0.current;
			doneComposite();
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
							precedeComposite(elementTypeProvider.getXMultiplicativeExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
							doneComposite();
							associateWithSemanticElement();
						}
					)
					(
						(
							{
								if (!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
							{
								markComposite(elementTypeProvider.getXMultiplicativeExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
							}
							ruleOpMulti
							{
								doneComposite();
							}
						)
					)
				)
			)
			(
				(
					{
						markComposite(elementTypeProvider.getXMultiplicativeExpression_RightOperandXUnaryOperationParserRuleCall_1_1_0ElementType());
					}
					lv_rightOperand_3_0=ruleXUnaryOperation
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)*
	)
;

//Entry rule entryRuleOpMulti
entryRuleOpMulti returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getOpMultiElementType()); }
	iv_ruleOpMulti=ruleOpMulti
	{ $current=$iv_ruleOpMulti.current; }
	EOF;

// Rule OpMulti
ruleOpMulti returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getOpMulti_AsteriskKeyword_0ElementType());
		}
		kw='*'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getOpMulti_AsteriskAsteriskKeyword_1ElementType());
		}
		kw='**'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getOpMulti_SolidusKeyword_2ElementType());
		}
		kw='/'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getOpMulti_PercentSignKeyword_3ElementType());
		}
		kw='%'
		{
			doneLeaf(kw);
		}
	)
;

//Entry rule entryRuleXUnaryOperation
entryRuleXUnaryOperation returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXUnaryOperationElementType()); }
	iv_ruleXUnaryOperation=ruleXUnaryOperation
	{ $current=$iv_ruleXUnaryOperation.current; }
	EOF;

// Rule XUnaryOperation
ruleXUnaryOperation returns [Boolean current=false]
:
	(
		(
			(
				{
					precedeComposite(elementTypeProvider.getXUnaryOperation_XUnaryOperationAction_0_0ElementType());
					doneComposite();
					associateWithSemanticElement();
				}
			)
			(
				(
					{
						if (!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
					{
						markComposite(elementTypeProvider.getXUnaryOperation_FeatureJvmIdentifiableElementCrossReference_0_1_0ElementType());
					}
					ruleOpUnary
					{
						doneComposite();
					}
				)
			)
			(
				(
					{
						markComposite(elementTypeProvider.getXUnaryOperation_OperandXUnaryOperationParserRuleCall_0_2_0ElementType());
					}
					lv_operand_2_0=ruleXUnaryOperation
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)
		    |
		{
			markComposite(elementTypeProvider.getXUnaryOperation_XCastedExpressionParserRuleCall_1ElementType());
		}
		this_XCastedExpression_3=ruleXCastedExpression
		{
			$current = $this_XCastedExpression_3.current;
			doneComposite();
		}
	)
;

//Entry rule entryRuleOpUnary
entryRuleOpUnary returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getOpUnaryElementType()); }
	iv_ruleOpUnary=ruleOpUnary
	{ $current=$iv_ruleOpUnary.current; }
	EOF;

// Rule OpUnary
ruleOpUnary returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getOpUnary_ExclamationMarkKeyword_0ElementType());
		}
		kw='!'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getOpUnary_HyphenMinusKeyword_1ElementType());
		}
		kw='-'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getOpUnary_PlusSignKeyword_2ElementType());
		}
		kw='+'
		{
			doneLeaf(kw);
		}
	)
;

//Entry rule entryRuleXCastedExpression
entryRuleXCastedExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXCastedExpressionElementType()); }
	iv_ruleXCastedExpression=ruleXCastedExpression
	{ $current=$iv_ruleXCastedExpression.current; }
	EOF;

// Rule XCastedExpression
ruleXCastedExpression returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getXCastedExpression_XPostfixOperationParserRuleCall_0ElementType());
		}
		this_XPostfixOperation_0=ruleXPostfixOperation
		{
			$current = $this_XPostfixOperation_0.current;
			doneComposite();
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
							precedeComposite(elementTypeProvider.getXCastedExpression_XCastedExpressionTargetAction_1_0_0_0ElementType());
							doneComposite();
							associateWithSemanticElement();
						}
					)
					{
						markLeaf(elementTypeProvider.getXCastedExpression_AsKeyword_1_0_0_1ElementType());
					}
					otherlv_2='as'
					{
						doneLeaf(otherlv_2);
					}
				)
			)
			(
				(
					{
						markComposite(elementTypeProvider.getXCastedExpression_TypeJvmTypeReferenceParserRuleCall_1_1_0ElementType());
					}
					lv_type_3_0=ruleJvmTypeReference
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)*
	)
;

//Entry rule entryRuleXPostfixOperation
entryRuleXPostfixOperation returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXPostfixOperationElementType()); }
	iv_ruleXPostfixOperation=ruleXPostfixOperation
	{ $current=$iv_ruleXPostfixOperation.current; }
	EOF;

// Rule XPostfixOperation
ruleXPostfixOperation returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getXPostfixOperation_XMemberFeatureCallParserRuleCall_0ElementType());
		}
		this_XMemberFeatureCall_0=ruleXMemberFeatureCall
		{
			$current = $this_XMemberFeatureCall_0.current;
			doneComposite();
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
						precedeComposite(elementTypeProvider.getXPostfixOperation_XPostfixOperationOperandAction_1_0_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				(
					(
						{
							if (!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
						{
							markComposite(elementTypeProvider.getXPostfixOperation_FeatureJvmIdentifiableElementCrossReference_1_0_1_0ElementType());
						}
						ruleOpPostfix
						{
							doneComposite();
						}
					)
				)
			)
		)?
	)
;

//Entry rule entryRuleOpPostfix
entryRuleOpPostfix returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getOpPostfixElementType()); }
	iv_ruleOpPostfix=ruleOpPostfix
	{ $current=$iv_ruleOpPostfix.current; }
	EOF;

// Rule OpPostfix
ruleOpPostfix returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getOpPostfix_PlusSignPlusSignKeyword_0ElementType());
		}
		kw='++'
		{
			doneLeaf(kw);
		}
		    |
		{
			markLeaf(elementTypeProvider.getOpPostfix_HyphenMinusHyphenMinusKeyword_1ElementType());
		}
		kw='--'
		{
			doneLeaf(kw);
		}
	)
;

//Entry rule entryRuleXMemberFeatureCall
entryRuleXMemberFeatureCall returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXMemberFeatureCallElementType()); }
	iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall
	{ $current=$iv_ruleXMemberFeatureCall.current; }
	EOF;

// Rule XMemberFeatureCall
ruleXMemberFeatureCall returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getXMemberFeatureCall_XPrimaryExpressionParserRuleCall_0ElementType());
		}
		this_XPrimaryExpression_0=ruleXPrimaryExpression
		{
			$current = $this_XPrimaryExpression_0.current;
			doneComposite();
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
								precedeComposite(elementTypeProvider.getXMemberFeatureCall_XAssignmentAssignableAction_1_0_0_0_0ElementType());
								doneComposite();
								associateWithSemanticElement();
							}
						)
						(
							{
								markLeaf(elementTypeProvider.getXMemberFeatureCall_FullStopKeyword_1_0_0_0_1_0ElementType());
							}
							otherlv_2='.'
							{
								doneLeaf(otherlv_2);
							}
							    |
							(
								(
									{
										markLeaf(elementTypeProvider.getXMemberFeatureCall_ExplicitStaticColonColonKeyword_1_0_0_0_1_1_0ElementType());
									}
									lv_explicitStatic_3_0='::'
									{
										doneLeaf(lv_explicitStatic_3_0);
									}
									{
										if (!$current) {
											associateWithSemanticElement();
											$current = true;
										}
									}
								)
							)
						)
						(
							(
								{
									if (!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
								{
									markComposite(elementTypeProvider.getXMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0ElementType());
								}
								ruleFeatureCallID
								{
									doneComposite();
								}
							)
						)
						{
							markComposite(elementTypeProvider.getXMemberFeatureCall_OpSingleAssignParserRuleCall_1_0_0_0_3ElementType());
						}
						ruleOpSingleAssign
						{
							doneComposite();
						}
					)
				)
				(
					(
						{
							markComposite(elementTypeProvider.getXMemberFeatureCall_ValueXAssignmentParserRuleCall_1_0_1_0ElementType());
						}
						lv_value_6_0=ruleXAssignment
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
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
								precedeComposite(elementTypeProvider.getXMemberFeatureCall_XMemberFeatureCallMemberCallTargetAction_1_1_0_0_0ElementType());
								doneComposite();
								associateWithSemanticElement();
							}
						)
						(
							{
								markLeaf(elementTypeProvider.getXMemberFeatureCall_FullStopKeyword_1_1_0_0_1_0ElementType());
							}
							otherlv_8='.'
							{
								doneLeaf(otherlv_8);
							}
							    |
							(
								(
									{
										markLeaf(elementTypeProvider.getXMemberFeatureCall_NullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0ElementType());
									}
									lv_nullSafe_9_0='?.'
									{
										doneLeaf(lv_nullSafe_9_0);
									}
									{
										if (!$current) {
											associateWithSemanticElement();
											$current = true;
										}
									}
								)
							)
							    |
							(
								(
									{
										markLeaf(elementTypeProvider.getXMemberFeatureCall_ExplicitStaticColonColonKeyword_1_1_0_0_1_2_0ElementType());
									}
									lv_explicitStatic_10_0='::'
									{
										doneLeaf(lv_explicitStatic_10_0);
									}
									{
										if (!$current) {
											associateWithSemanticElement();
											$current = true;
										}
									}
								)
							)
						)
					)
				)
				(
					{
						markLeaf(elementTypeProvider.getXMemberFeatureCall_LessThanSignKeyword_1_1_1_0ElementType());
					}
					otherlv_11='<'
					{
						doneLeaf(otherlv_11);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getXMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0ElementType());
							}
							lv_typeArguments_12_0=ruleJvmArgumentTypeReference
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getXMemberFeatureCall_CommaKeyword_1_1_1_2_0ElementType());
						}
						otherlv_13=','
						{
							doneLeaf(otherlv_13);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getXMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0ElementType());
								}
								lv_typeArguments_14_0=ruleJvmArgumentTypeReference
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
					{
						markLeaf(elementTypeProvider.getXMemberFeatureCall_GreaterThanSignKeyword_1_1_1_3ElementType());
					}
					otherlv_15='>'
					{
						doneLeaf(otherlv_15);
					}
				)?
				(
					(
						{
							if (!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
						{
							markComposite(elementTypeProvider.getXMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_1_2_0ElementType());
						}
						ruleIdOrSuper
						{
							doneComposite();
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
							{
								markLeaf(elementTypeProvider.getXMemberFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0ElementType());
							}
							lv_explicitOperationCall_17_0='('
							{
								doneLeaf(lv_explicitOperationCall_17_0);
							}
							{
								if (!$current) {
									associateWithSemanticElement();
									$current = true;
								}
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
									markComposite(elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0ElementType());
								}
								lv_memberCallArguments_18_0=ruleXShortClosure
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
						    |
						(
							(
								(
									{
										markComposite(elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0ElementType());
									}
									lv_memberCallArguments_19_0=ruleXExpression
									{
										doneComposite();
										if(!$current) {
											associateWithSemanticElement();
											$current = true;
										}
									}
								)
							)
							(
								{
									markLeaf(elementTypeProvider.getXMemberFeatureCall_CommaKeyword_1_1_3_1_1_1_0ElementType());
								}
								otherlv_20=','
								{
									doneLeaf(otherlv_20);
								}
								(
									(
										{
											markComposite(elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0ElementType());
										}
										lv_memberCallArguments_21_0=ruleXExpression
										{
											doneComposite();
											if(!$current) {
												associateWithSemanticElement();
												$current = true;
											}
										}
									)
								)
							)*
						)
					)?
					{
						markLeaf(elementTypeProvider.getXMemberFeatureCall_RightParenthesisKeyword_1_1_3_2ElementType());
					}
					otherlv_22=')'
					{
						doneLeaf(otherlv_22);
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
							markComposite(elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXClosureParserRuleCall_1_1_4_0ElementType());
						}
						lv_memberCallArguments_23_0=ruleXClosure
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)?
			)
		)*
	)
;

//Entry rule entryRuleXPrimaryExpression
entryRuleXPrimaryExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXPrimaryExpressionElementType()); }
	iv_ruleXPrimaryExpression=ruleXPrimaryExpression
	{ $current=$iv_ruleXPrimaryExpression.current; }
	EOF;

// Rule XPrimaryExpression
ruleXPrimaryExpression returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getXPrimaryExpression_XConstructorCallParserRuleCall_0ElementType());
		}
		this_XConstructorCall_0=ruleXConstructorCall
		{
			$current = $this_XConstructorCall_0.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getXPrimaryExpression_XBlockExpressionParserRuleCall_1ElementType());
		}
		this_XBlockExpression_1=ruleXBlockExpression
		{
			$current = $this_XBlockExpression_1.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getXPrimaryExpression_XSwitchExpressionParserRuleCall_2ElementType());
		}
		this_XSwitchExpression_2=ruleXSwitchExpression
		{
			$current = $this_XSwitchExpression_2.current;
			doneComposite();
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
				markComposite(elementTypeProvider.getXPrimaryExpression_XSynchronizedExpressionParserRuleCall_3ElementType());
			}
			this_XSynchronizedExpression_3=ruleXSynchronizedExpression
			{
				$current = $this_XSynchronizedExpression_3.current;
				doneComposite();
			}
		)
		    |
		{
			markComposite(elementTypeProvider.getXPrimaryExpression_XFeatureCallParserRuleCall_4ElementType());
		}
		this_XFeatureCall_4=ruleXFeatureCall
		{
			$current = $this_XFeatureCall_4.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getXPrimaryExpression_XLiteralParserRuleCall_5ElementType());
		}
		this_XLiteral_5=ruleXLiteral
		{
			$current = $this_XLiteral_5.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getXPrimaryExpression_XIfExpressionParserRuleCall_6ElementType());
		}
		this_XIfExpression_6=ruleXIfExpression
		{
			$current = $this_XIfExpression_6.current;
			doneComposite();
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
				markComposite(elementTypeProvider.getXPrimaryExpression_XForLoopExpressionParserRuleCall_7ElementType());
			}
			this_XForLoopExpression_7=ruleXForLoopExpression
			{
				$current = $this_XForLoopExpression_7.current;
				doneComposite();
			}
		)
		    |
		{
			markComposite(elementTypeProvider.getXPrimaryExpression_XBasicForLoopExpressionParserRuleCall_8ElementType());
		}
		this_XBasicForLoopExpression_8=ruleXBasicForLoopExpression
		{
			$current = $this_XBasicForLoopExpression_8.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getXPrimaryExpression_XWhileExpressionParserRuleCall_9ElementType());
		}
		this_XWhileExpression_9=ruleXWhileExpression
		{
			$current = $this_XWhileExpression_9.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getXPrimaryExpression_XDoWhileExpressionParserRuleCall_10ElementType());
		}
		this_XDoWhileExpression_10=ruleXDoWhileExpression
		{
			$current = $this_XDoWhileExpression_10.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getXPrimaryExpression_XThrowExpressionParserRuleCall_11ElementType());
		}
		this_XThrowExpression_11=ruleXThrowExpression
		{
			$current = $this_XThrowExpression_11.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getXPrimaryExpression_XReturnExpressionParserRuleCall_12ElementType());
		}
		this_XReturnExpression_12=ruleXReturnExpression
		{
			$current = $this_XReturnExpression_12.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getXPrimaryExpression_XTryCatchFinallyExpressionParserRuleCall_13ElementType());
		}
		this_XTryCatchFinallyExpression_13=ruleXTryCatchFinallyExpression
		{
			$current = $this_XTryCatchFinallyExpression_13.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getXPrimaryExpression_XParenthesizedExpressionParserRuleCall_14ElementType());
		}
		this_XParenthesizedExpression_14=ruleXParenthesizedExpression
		{
			$current = $this_XParenthesizedExpression_14.current;
			doneComposite();
		}
	)
;

//Entry rule entryRuleXLiteral
entryRuleXLiteral returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXLiteralElementType()); }
	iv_ruleXLiteral=ruleXLiteral
	{ $current=$iv_ruleXLiteral.current; }
	EOF;

// Rule XLiteral
ruleXLiteral returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getXLiteral_XCollectionLiteralParserRuleCall_0ElementType());
		}
		this_XCollectionLiteral_0=ruleXCollectionLiteral
		{
			$current = $this_XCollectionLiteral_0.current;
			doneComposite();
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
				markComposite(elementTypeProvider.getXLiteral_XClosureParserRuleCall_1ElementType());
			}
			this_XClosure_1=ruleXClosure
			{
				$current = $this_XClosure_1.current;
				doneComposite();
			}
		)
		    |
		{
			markComposite(elementTypeProvider.getXLiteral_XBooleanLiteralParserRuleCall_2ElementType());
		}
		this_XBooleanLiteral_2=ruleXBooleanLiteral
		{
			$current = $this_XBooleanLiteral_2.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getXLiteral_XNumberLiteralParserRuleCall_3ElementType());
		}
		this_XNumberLiteral_3=ruleXNumberLiteral
		{
			$current = $this_XNumberLiteral_3.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getXLiteral_XNullLiteralParserRuleCall_4ElementType());
		}
		this_XNullLiteral_4=ruleXNullLiteral
		{
			$current = $this_XNullLiteral_4.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getXLiteral_XStringLiteralParserRuleCall_5ElementType());
		}
		this_XStringLiteral_5=ruleXStringLiteral
		{
			$current = $this_XStringLiteral_5.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getXLiteral_XTypeLiteralParserRuleCall_6ElementType());
		}
		this_XTypeLiteral_6=ruleXTypeLiteral
		{
			$current = $this_XTypeLiteral_6.current;
			doneComposite();
		}
	)
;

//Entry rule entryRuleXCollectionLiteral
entryRuleXCollectionLiteral returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXCollectionLiteralElementType()); }
	iv_ruleXCollectionLiteral=ruleXCollectionLiteral
	{ $current=$iv_ruleXCollectionLiteral.current; }
	EOF;

// Rule XCollectionLiteral
ruleXCollectionLiteral returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getXCollectionLiteral_XSetLiteralParserRuleCall_0ElementType());
		}
		this_XSetLiteral_0=ruleXSetLiteral
		{
			$current = $this_XSetLiteral_0.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getXCollectionLiteral_XListLiteralParserRuleCall_1ElementType());
		}
		this_XListLiteral_1=ruleXListLiteral
		{
			$current = $this_XListLiteral_1.current;
			doneComposite();
		}
	)
;

//Entry rule entryRuleXSetLiteral
entryRuleXSetLiteral returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXSetLiteralElementType()); }
	iv_ruleXSetLiteral=ruleXSetLiteral
	{ $current=$iv_ruleXSetLiteral.current; }
	EOF;

// Rule XSetLiteral
ruleXSetLiteral returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXSetLiteral_XSetLiteralAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		{
			markLeaf(elementTypeProvider.getXSetLiteral_NumberSignKeyword_1ElementType());
		}
		otherlv_1='#'
		{
			doneLeaf(otherlv_1);
		}
		{
			markLeaf(elementTypeProvider.getXSetLiteral_LeftCurlyBracketKeyword_2ElementType());
		}
		otherlv_2='{'
		{
			doneLeaf(otherlv_2);
		}
		(
			(
				(
					{
						markComposite(elementTypeProvider.getXSetLiteral_ElementsXExpressionParserRuleCall_3_0_0ElementType());
					}
					lv_elements_3_0=ruleXExpression
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
			(
				{
					markLeaf(elementTypeProvider.getXSetLiteral_CommaKeyword_3_1_0ElementType());
				}
				otherlv_4=','
				{
					doneLeaf(otherlv_4);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getXSetLiteral_ElementsXExpressionParserRuleCall_3_1_1_0ElementType());
						}
						lv_elements_5_0=ruleXExpression
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
			)*
		)?
		{
			markLeaf(elementTypeProvider.getXSetLiteral_RightCurlyBracketKeyword_4ElementType());
		}
		otherlv_6='}'
		{
			doneLeaf(otherlv_6);
		}
	)
;

//Entry rule entryRuleXListLiteral
entryRuleXListLiteral returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXListLiteralElementType()); }
	iv_ruleXListLiteral=ruleXListLiteral
	{ $current=$iv_ruleXListLiteral.current; }
	EOF;

// Rule XListLiteral
ruleXListLiteral returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXListLiteral_XListLiteralAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		{
			markLeaf(elementTypeProvider.getXListLiteral_NumberSignKeyword_1ElementType());
		}
		otherlv_1='#'
		{
			doneLeaf(otherlv_1);
		}
		{
			markLeaf(elementTypeProvider.getXListLiteral_LeftSquareBracketKeyword_2ElementType());
		}
		otherlv_2='['
		{
			doneLeaf(otherlv_2);
		}
		(
			(
				(
					{
						markComposite(elementTypeProvider.getXListLiteral_ElementsXExpressionParserRuleCall_3_0_0ElementType());
					}
					lv_elements_3_0=ruleXExpression
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
			(
				{
					markLeaf(elementTypeProvider.getXListLiteral_CommaKeyword_3_1_0ElementType());
				}
				otherlv_4=','
				{
					doneLeaf(otherlv_4);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getXListLiteral_ElementsXExpressionParserRuleCall_3_1_1_0ElementType());
						}
						lv_elements_5_0=ruleXExpression
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
			)*
		)?
		{
			markLeaf(elementTypeProvider.getXListLiteral_RightSquareBracketKeyword_4ElementType());
		}
		otherlv_6=']'
		{
			doneLeaf(otherlv_6);
		}
	)
;

//Entry rule entryRuleXClosure
entryRuleXClosure returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXClosureElementType()); }
	iv_ruleXClosure=ruleXClosure
	{ $current=$iv_ruleXClosure.current; }
	EOF;

// Rule XClosure
ruleXClosure returns [Boolean current=false]
:
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
						precedeComposite(elementTypeProvider.getXClosure_XClosureAction_0_0_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				{
					markLeaf(elementTypeProvider.getXClosure_LeftSquareBracketKeyword_0_0_1ElementType());
				}
				otherlv_1='['
				{
					doneLeaf(otherlv_1);
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
								markComposite(elementTypeProvider.getXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0ElementType());
							}
							lv_declaredFormalParameters_2_0=ruleJvmFormalParameter
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getXClosure_CommaKeyword_1_0_0_1_0ElementType());
						}
						otherlv_3=','
						{
							doneLeaf(otherlv_3);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0ElementType());
								}
								lv_declaredFormalParameters_4_0=ruleJvmFormalParameter
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
				)?
				(
					(
						{
							markLeaf(elementTypeProvider.getXClosure_ExplicitSyntaxVerticalLineKeyword_1_0_1_0ElementType());
						}
						lv_explicitSyntax_5_0='|'
						{
							doneLeaf(lv_explicitSyntax_5_0);
						}
						{
							if (!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
			)
		)?
		(
			(
				{
					markComposite(elementTypeProvider.getXClosure_ExpressionXExpressionInClosureParserRuleCall_2_0ElementType());
				}
				lv_expression_6_0=ruleXExpressionInClosure
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		{
			markLeaf(elementTypeProvider.getXClosure_RightSquareBracketKeyword_3ElementType());
		}
		otherlv_7=']'
		{
			doneLeaf(otherlv_7);
		}
	)
;

//Entry rule entryRuleXExpressionInClosure
entryRuleXExpressionInClosure returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXExpressionInClosureElementType()); }
	iv_ruleXExpressionInClosure=ruleXExpressionInClosure
	{ $current=$iv_ruleXExpressionInClosure.current; }
	EOF;

// Rule XExpressionInClosure
ruleXExpressionInClosure returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXExpressionInClosure_XBlockExpressionAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		(
			(
				(
					{
						markComposite(elementTypeProvider.getXExpressionInClosure_ExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0ElementType());
					}
					lv_expressions_1_0=ruleXExpressionOrVarDeclaration
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
			(
				{
					markLeaf(elementTypeProvider.getXExpressionInClosure_SemicolonKeyword_1_1ElementType());
				}
				otherlv_2=';'
				{
					doneLeaf(otherlv_2);
				}
			)?
		)*
	)
;

//Entry rule entryRuleXShortClosure
entryRuleXShortClosure returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXShortClosureElementType()); }
	iv_ruleXShortClosure=ruleXShortClosure
	{ $current=$iv_ruleXShortClosure.current; }
	EOF;

// Rule XShortClosure
ruleXShortClosure returns [Boolean current=false]
:
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
						precedeComposite(elementTypeProvider.getXShortClosure_XClosureAction_0_0_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				(
					(
						(
							{
								markComposite(elementTypeProvider.getXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0ElementType());
							}
							lv_declaredFormalParameters_1_0=ruleJvmFormalParameter
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getXShortClosure_CommaKeyword_0_0_1_1_0ElementType());
						}
						otherlv_2=','
						{
							doneLeaf(otherlv_2);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0ElementType());
								}
								lv_declaredFormalParameters_3_0=ruleJvmFormalParameter
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
				)?
				(
					(
						{
							markLeaf(elementTypeProvider.getXShortClosure_ExplicitSyntaxVerticalLineKeyword_0_0_2_0ElementType());
						}
						lv_explicitSyntax_4_0='|'
						{
							doneLeaf(lv_explicitSyntax_4_0);
						}
						{
							if (!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
			)
		)
		(
			(
				{
					markComposite(elementTypeProvider.getXShortClosure_ExpressionXExpressionParserRuleCall_1_0ElementType());
				}
				lv_expression_5_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleXParenthesizedExpression
entryRuleXParenthesizedExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXParenthesizedExpressionElementType()); }
	iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression
	{ $current=$iv_ruleXParenthesizedExpression.current; }
	EOF;

// Rule XParenthesizedExpression
ruleXParenthesizedExpression returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getXParenthesizedExpression_LeftParenthesisKeyword_0ElementType());
		}
		otherlv_0='('
		{
			doneLeaf(otherlv_0);
		}
		{
			markComposite(elementTypeProvider.getXParenthesizedExpression_XExpressionParserRuleCall_1ElementType());
		}
		this_XExpression_1=ruleXExpression
		{
			$current = $this_XExpression_1.current;
			doneComposite();
		}
		{
			markLeaf(elementTypeProvider.getXParenthesizedExpression_RightParenthesisKeyword_2ElementType());
		}
		otherlv_2=')'
		{
			doneLeaf(otherlv_2);
		}
	)
;

//Entry rule entryRuleXIfExpression
entryRuleXIfExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXIfExpressionElementType()); }
	iv_ruleXIfExpression=ruleXIfExpression
	{ $current=$iv_ruleXIfExpression.current; }
	EOF;

// Rule XIfExpression
ruleXIfExpression returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXIfExpression_XIfExpressionAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		{
			markLeaf(elementTypeProvider.getXIfExpression_IfKeyword_1ElementType());
		}
		otherlv_1='if'
		{
			doneLeaf(otherlv_1);
		}
		{
			markLeaf(elementTypeProvider.getXIfExpression_LeftParenthesisKeyword_2ElementType());
		}
		otherlv_2='('
		{
			doneLeaf(otherlv_2);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getXIfExpression_IfXExpressionParserRuleCall_3_0ElementType());
				}
				lv_if_3_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		{
			markLeaf(elementTypeProvider.getXIfExpression_RightParenthesisKeyword_4ElementType());
		}
		otherlv_4=')'
		{
			doneLeaf(otherlv_4);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getXIfExpression_ThenXExpressionParserRuleCall_5_0ElementType());
				}
				lv_then_5_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		(
			(
				('else')=>
				{
					markLeaf(elementTypeProvider.getXIfExpression_ElseKeyword_6_0ElementType());
				}
				otherlv_6='else'
				{
					doneLeaf(otherlv_6);
				}
			)
			(
				(
					{
						markComposite(elementTypeProvider.getXIfExpression_ElseXExpressionParserRuleCall_6_1_0ElementType());
					}
					lv_else_7_0=ruleXExpression
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)?
	)
;

//Entry rule entryRuleXCasePart
entryRuleXCasePart returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXCasePartElementType()); }
	iv_ruleXCasePart=ruleXCasePart
	{ $current=$iv_ruleXCasePart.current; }
	EOF;

// Rule XCasePart
ruleXCasePart returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXCasePart_XCasePartAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		(
			(
				{
					markComposite(elementTypeProvider.getXCasePart_TypeGuardJvmTypeReferenceParserRuleCall_1_0ElementType());
				}
				lv_typeGuard_1_0=ruleJvmTypeReference
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)?
		(
			{
				markLeaf(elementTypeProvider.getXCasePart_CaseKeyword_2_0ElementType());
			}
			otherlv_2='case'
			{
				doneLeaf(otherlv_2);
			}
			(
				(
					{
						markComposite(elementTypeProvider.getXCasePart_CaseXExpressionParserRuleCall_2_1_0ElementType());
					}
					lv_case_3_0=ruleXExpression
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)?
		(
			(
				{
					markLeaf(elementTypeProvider.getXCasePart_ColonKeyword_3_0_0ElementType());
				}
				otherlv_4=':'
				{
					doneLeaf(otherlv_4);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getXCasePart_ThenXExpressionParserRuleCall_3_0_1_0ElementType());
						}
						lv_then_5_0=ruleXExpression
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
			)
			    |
			(
				(
					{
						markLeaf(elementTypeProvider.getXCasePart_FallThroughCommaKeyword_3_1_0ElementType());
					}
					lv_fallThrough_6_0=','
					{
						doneLeaf(lv_fallThrough_6_0);
					}
					{
						if (!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)
	)
;

//Entry rule entryRuleXForLoopExpression
entryRuleXForLoopExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXForLoopExpressionElementType()); }
	iv_ruleXForLoopExpression=ruleXForLoopExpression
	{ $current=$iv_ruleXForLoopExpression.current; }
	EOF;

// Rule XForLoopExpression
ruleXForLoopExpression returns [Boolean current=false]
:
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
						precedeComposite(elementTypeProvider.getXForLoopExpression_XForLoopExpressionAction_0_0_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				{
					markLeaf(elementTypeProvider.getXForLoopExpression_ForKeyword_0_0_1ElementType());
				}
				otherlv_1='for'
				{
					doneLeaf(otherlv_1);
				}
				{
					markLeaf(elementTypeProvider.getXForLoopExpression_LeftParenthesisKeyword_0_0_2ElementType());
				}
				otherlv_2='('
				{
					doneLeaf(otherlv_2);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getXForLoopExpression_DeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0ElementType());
						}
						lv_declaredParam_3_0=ruleJvmFormalParameter
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				{
					markLeaf(elementTypeProvider.getXForLoopExpression_ColonKeyword_0_0_4ElementType());
				}
				otherlv_4=':'
				{
					doneLeaf(otherlv_4);
				}
			)
		)
		(
			(
				{
					markComposite(elementTypeProvider.getXForLoopExpression_ForExpressionXExpressionParserRuleCall_1_0ElementType());
				}
				lv_forExpression_5_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		{
			markLeaf(elementTypeProvider.getXForLoopExpression_RightParenthesisKeyword_2ElementType());
		}
		otherlv_6=')'
		{
			doneLeaf(otherlv_6);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getXForLoopExpression_EachExpressionXExpressionParserRuleCall_3_0ElementType());
				}
				lv_eachExpression_7_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleXBasicForLoopExpression
entryRuleXBasicForLoopExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXBasicForLoopExpressionElementType()); }
	iv_ruleXBasicForLoopExpression=ruleXBasicForLoopExpression
	{ $current=$iv_ruleXBasicForLoopExpression.current; }
	EOF;

// Rule XBasicForLoopExpression
ruleXBasicForLoopExpression returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXBasicForLoopExpression_XBasicForLoopExpressionAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		{
			markLeaf(elementTypeProvider.getXBasicForLoopExpression_ForKeyword_1ElementType());
		}
		otherlv_1='for'
		{
			doneLeaf(otherlv_1);
		}
		{
			markLeaf(elementTypeProvider.getXBasicForLoopExpression_LeftParenthesisKeyword_2ElementType());
		}
		otherlv_2='('
		{
			doneLeaf(otherlv_2);
		}
		(
			(
				(
					{
						markComposite(elementTypeProvider.getXBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0ElementType());
					}
					lv_initExpressions_3_0=ruleXExpressionOrVarDeclaration
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
			(
				{
					markLeaf(elementTypeProvider.getXBasicForLoopExpression_CommaKeyword_3_1_0ElementType());
				}
				otherlv_4=','
				{
					doneLeaf(otherlv_4);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getXBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0ElementType());
						}
						lv_initExpressions_5_0=ruleXExpressionOrVarDeclaration
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
			)*
		)?
		{
			markLeaf(elementTypeProvider.getXBasicForLoopExpression_SemicolonKeyword_4ElementType());
		}
		otherlv_6=';'
		{
			doneLeaf(otherlv_6);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getXBasicForLoopExpression_ExpressionXExpressionParserRuleCall_5_0ElementType());
				}
				lv_expression_7_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)?
		{
			markLeaf(elementTypeProvider.getXBasicForLoopExpression_SemicolonKeyword_6ElementType());
		}
		otherlv_8=';'
		{
			doneLeaf(otherlv_8);
		}
		(
			(
				(
					{
						markComposite(elementTypeProvider.getXBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_0_0ElementType());
					}
					lv_updateExpressions_9_0=ruleXExpression
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
			(
				{
					markLeaf(elementTypeProvider.getXBasicForLoopExpression_CommaKeyword_7_1_0ElementType());
				}
				otherlv_10=','
				{
					doneLeaf(otherlv_10);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getXBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_1_1_0ElementType());
						}
						lv_updateExpressions_11_0=ruleXExpression
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
			)*
		)?
		{
			markLeaf(elementTypeProvider.getXBasicForLoopExpression_RightParenthesisKeyword_8ElementType());
		}
		otherlv_12=')'
		{
			doneLeaf(otherlv_12);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getXBasicForLoopExpression_EachExpressionXExpressionParserRuleCall_9_0ElementType());
				}
				lv_eachExpression_13_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleXWhileExpression
entryRuleXWhileExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXWhileExpressionElementType()); }
	iv_ruleXWhileExpression=ruleXWhileExpression
	{ $current=$iv_ruleXWhileExpression.current; }
	EOF;

// Rule XWhileExpression
ruleXWhileExpression returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXWhileExpression_XWhileExpressionAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		{
			markLeaf(elementTypeProvider.getXWhileExpression_WhileKeyword_1ElementType());
		}
		otherlv_1='while'
		{
			doneLeaf(otherlv_1);
		}
		{
			markLeaf(elementTypeProvider.getXWhileExpression_LeftParenthesisKeyword_2ElementType());
		}
		otherlv_2='('
		{
			doneLeaf(otherlv_2);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getXWhileExpression_PredicateXExpressionParserRuleCall_3_0ElementType());
				}
				lv_predicate_3_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		{
			markLeaf(elementTypeProvider.getXWhileExpression_RightParenthesisKeyword_4ElementType());
		}
		otherlv_4=')'
		{
			doneLeaf(otherlv_4);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getXWhileExpression_BodyXExpressionParserRuleCall_5_0ElementType());
				}
				lv_body_5_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleXDoWhileExpression
entryRuleXDoWhileExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXDoWhileExpressionElementType()); }
	iv_ruleXDoWhileExpression=ruleXDoWhileExpression
	{ $current=$iv_ruleXDoWhileExpression.current; }
	EOF;

// Rule XDoWhileExpression
ruleXDoWhileExpression returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXDoWhileExpression_XDoWhileExpressionAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		{
			markLeaf(elementTypeProvider.getXDoWhileExpression_DoKeyword_1ElementType());
		}
		otherlv_1='do'
		{
			doneLeaf(otherlv_1);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getXDoWhileExpression_BodyXExpressionParserRuleCall_2_0ElementType());
				}
				lv_body_2_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		{
			markLeaf(elementTypeProvider.getXDoWhileExpression_WhileKeyword_3ElementType());
		}
		otherlv_3='while'
		{
			doneLeaf(otherlv_3);
		}
		{
			markLeaf(elementTypeProvider.getXDoWhileExpression_LeftParenthesisKeyword_4ElementType());
		}
		otherlv_4='('
		{
			doneLeaf(otherlv_4);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getXDoWhileExpression_PredicateXExpressionParserRuleCall_5_0ElementType());
				}
				lv_predicate_5_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		{
			markLeaf(elementTypeProvider.getXDoWhileExpression_RightParenthesisKeyword_6ElementType());
		}
		otherlv_6=')'
		{
			doneLeaf(otherlv_6);
		}
	)
;

//Entry rule entryRuleXBlockExpression
entryRuleXBlockExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXBlockExpressionElementType()); }
	iv_ruleXBlockExpression=ruleXBlockExpression
	{ $current=$iv_ruleXBlockExpression.current; }
	EOF;

// Rule XBlockExpression
ruleXBlockExpression returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXBlockExpression_XBlockExpressionAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		{
			markLeaf(elementTypeProvider.getXBlockExpression_LeftCurlyBracketKeyword_1ElementType());
		}
		otherlv_1='{'
		{
			doneLeaf(otherlv_1);
		}
		(
			(
				(
					{
						markComposite(elementTypeProvider.getXBlockExpression_ExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0ElementType());
					}
					lv_expressions_2_0=ruleXExpressionOrVarDeclaration
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
			(
				{
					markLeaf(elementTypeProvider.getXBlockExpression_SemicolonKeyword_2_1ElementType());
				}
				otherlv_3=';'
				{
					doneLeaf(otherlv_3);
				}
			)?
		)*
		{
			markLeaf(elementTypeProvider.getXBlockExpression_RightCurlyBracketKeyword_3ElementType());
		}
		otherlv_4='}'
		{
			doneLeaf(otherlv_4);
		}
	)
;

//Entry rule entryRuleXExpressionOrVarDeclaration
entryRuleXExpressionOrVarDeclaration returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXExpressionOrVarDeclarationElementType()); }
	iv_ruleXExpressionOrVarDeclaration=ruleXExpressionOrVarDeclaration
	{ $current=$iv_ruleXExpressionOrVarDeclaration.current; }
	EOF;

// Rule XExpressionOrVarDeclaration
ruleXExpressionOrVarDeclaration returns [Boolean current=false]
:
	(
		(
			((
				(
				)
				(
					(
						(
							(
								(
									'var'
								)
							)
							    |
							'val'
						)
						(
							(
								'extension'
							)
						)?
					)
					    |
					(
						(
							(
								'extension'
							)
						)
						(
							(
								(
									'var'
								)
							)
							    |
							'val'
						)
					)
				)
			)
			)=>
			{
				markComposite(elementTypeProvider.getXExpressionOrVarDeclaration_XVariableDeclarationParserRuleCall_0ElementType());
			}
			this_XVariableDeclaration_0=ruleXVariableDeclaration
			{
				$current = $this_XVariableDeclaration_0.current;
				doneComposite();
			}
		)
		    |
		{
			markComposite(elementTypeProvider.getXExpressionOrVarDeclaration_XExpressionParserRuleCall_1ElementType());
		}
		this_XExpression_1=ruleXExpression
		{
			$current = $this_XExpression_1.current;
			doneComposite();
		}
	)
;

//Entry rule entryRuleXFeatureCall
entryRuleXFeatureCall returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXFeatureCallElementType()); }
	iv_ruleXFeatureCall=ruleXFeatureCall
	{ $current=$iv_ruleXFeatureCall.current; }
	EOF;

// Rule XFeatureCall
ruleXFeatureCall returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXFeatureCall_XFeatureCallAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		(
			{
				markLeaf(elementTypeProvider.getXFeatureCall_LessThanSignKeyword_1_0ElementType());
			}
			otherlv_1='<'
			{
				doneLeaf(otherlv_1);
			}
			(
				(
					{
						markComposite(elementTypeProvider.getXFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType());
					}
					lv_typeArguments_2_0=ruleJvmArgumentTypeReference
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
			(
				{
					markLeaf(elementTypeProvider.getXFeatureCall_CommaKeyword_1_2_0ElementType());
				}
				otherlv_3=','
				{
					doneLeaf(otherlv_3);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getXFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType());
						}
						lv_typeArguments_4_0=ruleJvmArgumentTypeReference
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
			)*
			{
				markLeaf(elementTypeProvider.getXFeatureCall_GreaterThanSignKeyword_1_3ElementType());
			}
			otherlv_5='>'
			{
				doneLeaf(otherlv_5);
			}
		)?
		(
			(
				{
					if (!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
				{
					markComposite(elementTypeProvider.getXFeatureCall_FeatureJvmIdentifiableElementCrossReference_2_0ElementType());
				}
				ruleIdOrSuper
				{
					doneComposite();
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
					{
						markLeaf(elementTypeProvider.getXFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_3_0_0ElementType());
					}
					lv_explicitOperationCall_7_0='('
					{
						doneLeaf(lv_explicitOperationCall_7_0);
					}
					{
						if (!$current) {
							associateWithSemanticElement();
							$current = true;
						}
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
							markComposite(elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0ElementType());
						}
						lv_featureCallArguments_8_0=ruleXShortClosure
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				    |
				(
					(
						(
							{
								markComposite(elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0ElementType());
							}
							lv_featureCallArguments_9_0=ruleXExpression
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getXFeatureCall_CommaKeyword_3_1_1_1_0ElementType());
						}
						otherlv_10=','
						{
							doneLeaf(otherlv_10);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0ElementType());
								}
								lv_featureCallArguments_11_0=ruleXExpression
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
				)
			)?
			{
				markLeaf(elementTypeProvider.getXFeatureCall_RightParenthesisKeyword_3_2ElementType());
			}
			otherlv_12=')'
			{
				doneLeaf(otherlv_12);
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
					markComposite(elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXClosureParserRuleCall_4_0ElementType());
				}
				lv_featureCallArguments_13_0=ruleXClosure
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)?
	)
;

//Entry rule entryRuleIdOrSuper
entryRuleIdOrSuper returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getIdOrSuperElementType()); }
	iv_ruleIdOrSuper=ruleIdOrSuper
	{ $current=$iv_ruleIdOrSuper.current; }
	EOF;

// Rule IdOrSuper
ruleIdOrSuper returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getIdOrSuper_FeatureCallIDParserRuleCall_0ElementType());
		}
		ruleFeatureCallID
		{
			doneComposite();
		}
		    |
		{
			markLeaf(elementTypeProvider.getIdOrSuper_SuperKeyword_1ElementType());
		}
		kw='super'
		{
			doneLeaf(kw);
		}
	)
;

//Entry rule entryRuleXBooleanLiteral
entryRuleXBooleanLiteral returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXBooleanLiteralElementType()); }
	iv_ruleXBooleanLiteral=ruleXBooleanLiteral
	{ $current=$iv_ruleXBooleanLiteral.current; }
	EOF;

// Rule XBooleanLiteral
ruleXBooleanLiteral returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXBooleanLiteral_XBooleanLiteralAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		(
			{
				markLeaf(elementTypeProvider.getXBooleanLiteral_FalseKeyword_1_0ElementType());
			}
			otherlv_1='false'
			{
				doneLeaf(otherlv_1);
			}
			    |
			(
				(
					{
						markLeaf(elementTypeProvider.getXBooleanLiteral_IsTrueTrueKeyword_1_1_0ElementType());
					}
					lv_isTrue_2_0='true'
					{
						doneLeaf(lv_isTrue_2_0);
					}
					{
						if (!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)
	)
;

//Entry rule entryRuleXNullLiteral
entryRuleXNullLiteral returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXNullLiteralElementType()); }
	iv_ruleXNullLiteral=ruleXNullLiteral
	{ $current=$iv_ruleXNullLiteral.current; }
	EOF;

// Rule XNullLiteral
ruleXNullLiteral returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXNullLiteral_XNullLiteralAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		{
			markLeaf(elementTypeProvider.getXNullLiteral_NullKeyword_1ElementType());
		}
		otherlv_1='null'
		{
			doneLeaf(otherlv_1);
		}
	)
;

//Entry rule entryRuleXNumberLiteral
entryRuleXNumberLiteral returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXNumberLiteralElementType()); }
	iv_ruleXNumberLiteral=ruleXNumberLiteral
	{ $current=$iv_ruleXNumberLiteral.current; }
	EOF;

// Rule XNumberLiteral
ruleXNumberLiteral returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXNumberLiteral_XNumberLiteralAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		(
			(
				{
					markComposite(elementTypeProvider.getXNumberLiteral_ValueNumberParserRuleCall_1_0ElementType());
				}
				lv_value_1_0=ruleNumber
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleXTypeLiteral
entryRuleXTypeLiteral returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXTypeLiteralElementType()); }
	iv_ruleXTypeLiteral=ruleXTypeLiteral
	{ $current=$iv_ruleXTypeLiteral.current; }
	EOF;

// Rule XTypeLiteral
ruleXTypeLiteral returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXTypeLiteral_XTypeLiteralAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		{
			markLeaf(elementTypeProvider.getXTypeLiteral_TypeofKeyword_1ElementType());
		}
		otherlv_1='typeof'
		{
			doneLeaf(otherlv_1);
		}
		{
			markLeaf(elementTypeProvider.getXTypeLiteral_LeftParenthesisKeyword_2ElementType());
		}
		otherlv_2='('
		{
			doneLeaf(otherlv_2);
		}
		(
			(
				{
					if (!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
				{
					markComposite(elementTypeProvider.getXTypeLiteral_TypeJvmTypeCrossReference_3_0ElementType());
				}
				ruleQualifiedName
				{
					doneComposite();
				}
			)
		)
		(
			(
				{
					markComposite(elementTypeProvider.getXTypeLiteral_ArrayDimensionsArrayBracketsParserRuleCall_4_0ElementType());
				}
				lv_arrayDimensions_4_0=ruleArrayBrackets
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)*
		{
			markLeaf(elementTypeProvider.getXTypeLiteral_RightParenthesisKeyword_5ElementType());
		}
		otherlv_5=')'
		{
			doneLeaf(otherlv_5);
		}
	)
;

//Entry rule entryRuleXThrowExpression
entryRuleXThrowExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXThrowExpressionElementType()); }
	iv_ruleXThrowExpression=ruleXThrowExpression
	{ $current=$iv_ruleXThrowExpression.current; }
	EOF;

// Rule XThrowExpression
ruleXThrowExpression returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXThrowExpression_XThrowExpressionAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		{
			markLeaf(elementTypeProvider.getXThrowExpression_ThrowKeyword_1ElementType());
		}
		otherlv_1='throw'
		{
			doneLeaf(otherlv_1);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getXThrowExpression_ExpressionXExpressionParserRuleCall_2_0ElementType());
				}
				lv_expression_2_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleXReturnExpression
entryRuleXReturnExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXReturnExpressionElementType()); }
	iv_ruleXReturnExpression=ruleXReturnExpression
	{ $current=$iv_ruleXReturnExpression.current; }
	EOF;

// Rule XReturnExpression
ruleXReturnExpression returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXReturnExpression_XReturnExpressionAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		{
			markLeaf(elementTypeProvider.getXReturnExpression_ReturnKeyword_1ElementType());
		}
		otherlv_1='return'
		{
			doneLeaf(otherlv_1);
		}
		(
			('abstract' | 'annotation' | 'class' | 'create' | 'def' | 'dispatch' | 'enum' | 'extends' | 'final' | 'implements' | 'import' | 'interface' | 'override' | 'package' | 'public' | 'private' | 'protected' | 'static' | 'throws' | 'strictfp' | 'native' | 'volatile' | 'synchronized' | 'transient' | 'AFTER' | 'BEFORE' | 'SEPARATOR' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING | RULE_RICH_TEXT | RULE_RICH_TEXT_START)=>
			(
				{
					markComposite(elementTypeProvider.getXReturnExpression_ExpressionXExpressionParserRuleCall_2_0ElementType());
				}
				lv_expression_2_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)?
	)
;

//Entry rule entryRuleXTryCatchFinallyExpression
entryRuleXTryCatchFinallyExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXTryCatchFinallyExpressionElementType()); }
	iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression
	{ $current=$iv_ruleXTryCatchFinallyExpression.current; }
	EOF;

// Rule XTryCatchFinallyExpression
ruleXTryCatchFinallyExpression returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getXTryCatchFinallyExpression_XTryCatchFinallyExpressionAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		{
			markLeaf(elementTypeProvider.getXTryCatchFinallyExpression_TryKeyword_1ElementType());
		}
		otherlv_1='try'
		{
			doneLeaf(otherlv_1);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getXTryCatchFinallyExpression_ExpressionXExpressionParserRuleCall_2_0ElementType());
				}
				lv_expression_2_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		(
			(
				(
					('catch')=>
					(
						{
							markComposite(elementTypeProvider.getXTryCatchFinallyExpression_CatchClausesXCatchClauseParserRuleCall_3_0_0_0ElementType());
						}
						lv_catchClauses_3_0=ruleXCatchClause
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)+
				(
					(
						('finally')=>
						{
							markLeaf(elementTypeProvider.getXTryCatchFinallyExpression_FinallyKeyword_3_0_1_0ElementType());
						}
						otherlv_4='finally'
						{
							doneLeaf(otherlv_4);
						}
					)
					(
						(
							{
								markComposite(elementTypeProvider.getXTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_0_1_1_0ElementType());
							}
							lv_finallyExpression_5_0=ruleXExpression
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
				)?
			)
			    |
			(
				{
					markLeaf(elementTypeProvider.getXTryCatchFinallyExpression_FinallyKeyword_3_1_0ElementType());
				}
				otherlv_6='finally'
				{
					doneLeaf(otherlv_6);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getXTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_1_1_0ElementType());
						}
						lv_finallyExpression_7_0=ruleXExpression
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
			)
		)
	)
;

//Entry rule entryRuleXSynchronizedExpression
entryRuleXSynchronizedExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXSynchronizedExpressionElementType()); }
	iv_ruleXSynchronizedExpression=ruleXSynchronizedExpression
	{ $current=$iv_ruleXSynchronizedExpression.current; }
	EOF;

// Rule XSynchronizedExpression
ruleXSynchronizedExpression returns [Boolean current=false]
:
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
						precedeComposite(elementTypeProvider.getXSynchronizedExpression_XSynchronizedExpressionAction_0_0_0ElementType());
						doneComposite();
						associateWithSemanticElement();
					}
				)
				{
					markLeaf(elementTypeProvider.getXSynchronizedExpression_SynchronizedKeyword_0_0_1ElementType());
				}
				otherlv_1='synchronized'
				{
					doneLeaf(otherlv_1);
				}
				{
					markLeaf(elementTypeProvider.getXSynchronizedExpression_LeftParenthesisKeyword_0_0_2ElementType());
				}
				otherlv_2='('
				{
					doneLeaf(otherlv_2);
				}
			)
		)
		(
			(
				{
					markComposite(elementTypeProvider.getXSynchronizedExpression_ParamXExpressionParserRuleCall_1_0ElementType());
				}
				lv_param_3_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		{
			markLeaf(elementTypeProvider.getXSynchronizedExpression_RightParenthesisKeyword_2ElementType());
		}
		otherlv_4=')'
		{
			doneLeaf(otherlv_4);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getXSynchronizedExpression_ExpressionXExpressionParserRuleCall_3_0ElementType());
				}
				lv_expression_5_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleXCatchClause
entryRuleXCatchClause returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXCatchClauseElementType()); }
	iv_ruleXCatchClause=ruleXCatchClause
	{ $current=$iv_ruleXCatchClause.current; }
	EOF;

// Rule XCatchClause
ruleXCatchClause returns [Boolean current=false]
:
	(
		(
			('catch')=>
			{
				markLeaf(elementTypeProvider.getXCatchClause_CatchKeyword_0ElementType());
			}
			otherlv_0='catch'
			{
				doneLeaf(otherlv_0);
			}
		)
		{
			markLeaf(elementTypeProvider.getXCatchClause_LeftParenthesisKeyword_1ElementType());
		}
		otherlv_1='('
		{
			doneLeaf(otherlv_1);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getXCatchClause_DeclaredParamFullJvmFormalParameterParserRuleCall_2_0ElementType());
				}
				lv_declaredParam_2_0=ruleFullJvmFormalParameter
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		{
			markLeaf(elementTypeProvider.getXCatchClause_RightParenthesisKeyword_3ElementType());
		}
		otherlv_3=')'
		{
			doneLeaf(otherlv_3);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getXCatchClause_ExpressionXExpressionParserRuleCall_4_0ElementType());
				}
				lv_expression_4_0=ruleXExpression
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getQualifiedNameElementType()); }
	iv_ruleQualifiedName=ruleQualifiedName
	{ $current=$iv_ruleQualifiedName.current; }
	EOF;

// Rule QualifiedName
ruleQualifiedName returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getQualifiedName_ValidIDParserRuleCall_0ElementType());
		}
		ruleValidID
		{
			doneComposite();
		}
		(
			(
				('.')=>
				{
					markLeaf(elementTypeProvider.getQualifiedName_FullStopKeyword_1_0ElementType());
				}
				kw='.'
				{
					doneLeaf(kw);
				}
			)
			{
				markComposite(elementTypeProvider.getQualifiedName_ValidIDParserRuleCall_1_1ElementType());
			}
			ruleValidID
			{
				doneComposite();
			}
		)*
	)
;

//Entry rule entryRuleNumber
entryRuleNumber returns [Boolean current=false]@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	{ markComposite(elementTypeProvider.getNumberElementType()); }
	iv_ruleNumber=ruleNumber
	{ $current=$iv_ruleNumber.current; }
	EOF;
finally {
	myHiddenTokenState.restore();
}

// Rule Number
ruleNumber returns [Boolean current=false]
@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	(
		{
			markLeaf(elementTypeProvider.getNumber_HEXTerminalRuleCall_0ElementType());
		}
		this_HEX_0=RULE_HEX
		{
			doneLeaf(this_HEX_0);
		}
		    |
		(
			(
				{
					markLeaf(elementTypeProvider.getNumber_INTTerminalRuleCall_1_0_0ElementType());
				}
				this_INT_1=RULE_INT
				{
					doneLeaf(this_INT_1);
				}
				    |
				{
					markLeaf(elementTypeProvider.getNumber_DECIMALTerminalRuleCall_1_0_1ElementType());
				}
				this_DECIMAL_2=RULE_DECIMAL
				{
					doneLeaf(this_DECIMAL_2);
				}
			)
			(
				{
					markLeaf(elementTypeProvider.getNumber_FullStopKeyword_1_1_0ElementType());
				}
				kw='.'
				{
					doneLeaf(kw);
				}
				(
					{
						markLeaf(elementTypeProvider.getNumber_INTTerminalRuleCall_1_1_1_0ElementType());
					}
					this_INT_4=RULE_INT
					{
						doneLeaf(this_INT_4);
					}
					    |
					{
						markLeaf(elementTypeProvider.getNumber_DECIMALTerminalRuleCall_1_1_1_1ElementType());
					}
					this_DECIMAL_5=RULE_DECIMAL
					{
						doneLeaf(this_DECIMAL_5);
					}
				)
			)?
		)
	)
;
finally {
	myHiddenTokenState.restore();
}

//Entry rule entryRuleJvmTypeReference
entryRuleJvmTypeReference returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getJvmTypeReferenceElementType()); }
	iv_ruleJvmTypeReference=ruleJvmTypeReference
	{ $current=$iv_ruleJvmTypeReference.current; }
	EOF;

// Rule JvmTypeReference
ruleJvmTypeReference returns [Boolean current=false]
:
	(
		(
			{
				markComposite(elementTypeProvider.getJvmTypeReference_JvmParameterizedTypeReferenceParserRuleCall_0_0ElementType());
			}
			this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference
			{
				$current = $this_JvmParameterizedTypeReference_0.current;
				doneComposite();
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
							precedeComposite(elementTypeProvider.getJvmTypeReference_JvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0ElementType());
							doneComposite();
							associateWithSemanticElement();
						}
					)
					{
						markComposite(elementTypeProvider.getJvmTypeReference_ArrayBracketsParserRuleCall_0_1_0_1ElementType());
					}
					ruleArrayBrackets
					{
						doneComposite();
					}
				)
			)*
		)
		    |
		{
			markComposite(elementTypeProvider.getJvmTypeReference_XFunctionTypeRefParserRuleCall_1ElementType());
		}
		this_XFunctionTypeRef_3=ruleXFunctionTypeRef
		{
			$current = $this_XFunctionTypeRef_3.current;
			doneComposite();
		}
	)
;

//Entry rule entryRuleArrayBrackets
entryRuleArrayBrackets returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getArrayBracketsElementType()); }
	iv_ruleArrayBrackets=ruleArrayBrackets
	{ $current=$iv_ruleArrayBrackets.current; }
	EOF;

// Rule ArrayBrackets
ruleArrayBrackets returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getArrayBrackets_LeftSquareBracketKeyword_0ElementType());
		}
		kw='['
		{
			doneLeaf(kw);
		}
		{
			markLeaf(elementTypeProvider.getArrayBrackets_RightSquareBracketKeyword_1ElementType());
		}
		kw=']'
		{
			doneLeaf(kw);
		}
	)
;

//Entry rule entryRuleXFunctionTypeRef
entryRuleXFunctionTypeRef returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXFunctionTypeRefElementType()); }
	iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef
	{ $current=$iv_ruleXFunctionTypeRef.current; }
	EOF;

// Rule XFunctionTypeRef
ruleXFunctionTypeRef returns [Boolean current=false]
:
	(
		(
			{
				markLeaf(elementTypeProvider.getXFunctionTypeRef_LeftParenthesisKeyword_0_0ElementType());
			}
			otherlv_0='('
			{
				doneLeaf(otherlv_0);
			}
			(
				(
					(
						{
							markComposite(elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0ElementType());
						}
						lv_paramTypes_1_0=ruleJvmTypeReference
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				(
					{
						markLeaf(elementTypeProvider.getXFunctionTypeRef_CommaKeyword_0_1_1_0ElementType());
					}
					otherlv_2=','
					{
						doneLeaf(otherlv_2);
					}
					(
						(
							{
								markComposite(elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0ElementType());
							}
							lv_paramTypes_3_0=ruleJvmTypeReference
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
				)*
			)?
			{
				markLeaf(elementTypeProvider.getXFunctionTypeRef_RightParenthesisKeyword_0_2ElementType());
			}
			otherlv_4=')'
			{
				doneLeaf(otherlv_4);
			}
		)?
		{
			markLeaf(elementTypeProvider.getXFunctionTypeRef_EqualsSignGreaterThanSignKeyword_1ElementType());
		}
		otherlv_5='=>'
		{
			doneLeaf(otherlv_5);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getXFunctionTypeRef_ReturnTypeJvmTypeReferenceParserRuleCall_2_0ElementType());
				}
				lv_returnType_6_0=ruleJvmTypeReference
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleJvmParameterizedTypeReference
entryRuleJvmParameterizedTypeReference returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getJvmParameterizedTypeReferenceElementType()); }
	iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference
	{ $current=$iv_ruleJvmParameterizedTypeReference.current; }
	EOF;

// Rule JvmParameterizedTypeReference
ruleJvmParameterizedTypeReference returns [Boolean current=false]
:
	(
		(
			(
				{
					if (!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
				{
					markComposite(elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_0_0ElementType());
				}
				ruleQualifiedName
				{
					doneComposite();
				}
			)
		)
		(
			(
				('<')=>
				{
					markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_LessThanSignKeyword_1_0ElementType());
				}
				otherlv_1='<'
				{
					doneLeaf(otherlv_1);
				}
			)
			(
				(
					{
						markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType());
					}
					lv_arguments_2_0=ruleJvmArgumentTypeReference
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
			(
				{
					markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_CommaKeyword_1_2_0ElementType());
				}
				otherlv_3=','
				{
					doneLeaf(otherlv_3);
				}
				(
					(
						{
							markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType());
						}
						lv_arguments_4_0=ruleJvmArgumentTypeReference
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
			)*
			{
				markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_GreaterThanSignKeyword_1_3ElementType());
			}
			otherlv_5='>'
			{
				doneLeaf(otherlv_5);
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
								precedeComposite(elementTypeProvider.getJvmParameterizedTypeReference_JvmInnerTypeReferenceOuterAction_1_4_0_0_0ElementType());
								doneComposite();
								associateWithSemanticElement();
							}
						)
						{
							markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_FullStopKeyword_1_4_0_0_1ElementType());
						}
						otherlv_7='.'
						{
							doneLeaf(otherlv_7);
						}
					)
				)
				(
					(
						{
							if (!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
						{
							markComposite(elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_1_4_1_0ElementType());
						}
						ruleValidID
						{
							doneComposite();
						}
					)
				)
				(
					(
						('<')=>
						{
							markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_LessThanSignKeyword_1_4_2_0ElementType());
						}
						otherlv_9='<'
						{
							doneLeaf(otherlv_9);
						}
					)
					(
						(
							{
								markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0ElementType());
							}
							lv_arguments_10_0=ruleJvmArgumentTypeReference
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					(
						{
							markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_CommaKeyword_1_4_2_2_0ElementType());
						}
						otherlv_11=','
						{
							doneLeaf(otherlv_11);
						}
						(
							(
								{
									markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0ElementType());
								}
								lv_arguments_12_0=ruleJvmArgumentTypeReference
								{
									doneComposite();
									if(!$current) {
										associateWithSemanticElement();
										$current = true;
									}
								}
							)
						)
					)*
					{
						markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_GreaterThanSignKeyword_1_4_2_3ElementType());
					}
					otherlv_13='>'
					{
						doneLeaf(otherlv_13);
					}
				)?
			)*
		)?
	)
;

//Entry rule entryRuleJvmArgumentTypeReference
entryRuleJvmArgumentTypeReference returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getJvmArgumentTypeReferenceElementType()); }
	iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference
	{ $current=$iv_ruleJvmArgumentTypeReference.current; }
	EOF;

// Rule JvmArgumentTypeReference
ruleJvmArgumentTypeReference returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getJvmArgumentTypeReference_JvmTypeReferenceParserRuleCall_0ElementType());
		}
		this_JvmTypeReference_0=ruleJvmTypeReference
		{
			$current = $this_JvmTypeReference_0.current;
			doneComposite();
		}
		    |
		{
			markComposite(elementTypeProvider.getJvmArgumentTypeReference_JvmWildcardTypeReferenceParserRuleCall_1ElementType());
		}
		this_JvmWildcardTypeReference_1=ruleJvmWildcardTypeReference
		{
			$current = $this_JvmWildcardTypeReference_1.current;
			doneComposite();
		}
	)
;

//Entry rule entryRuleJvmWildcardTypeReference
entryRuleJvmWildcardTypeReference returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getJvmWildcardTypeReferenceElementType()); }
	iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference
	{ $current=$iv_ruleJvmWildcardTypeReference.current; }
	EOF;

// Rule JvmWildcardTypeReference
ruleJvmWildcardTypeReference returns [Boolean current=false]
:
	(
		(
			{
				precedeComposite(elementTypeProvider.getJvmWildcardTypeReference_JvmWildcardTypeReferenceAction_0ElementType());
				doneComposite();
				associateWithSemanticElement();
			}
		)
		{
			markLeaf(elementTypeProvider.getJvmWildcardTypeReference_QuestionMarkKeyword_1ElementType());
		}
		otherlv_1='?'
		{
			doneLeaf(otherlv_1);
		}
		(
			(
				(
					(
						{
							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundParserRuleCall_2_0_0_0ElementType());
						}
						lv_constraints_2_0=ruleJvmUpperBound
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				(
					(
						{
							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0ElementType());
						}
						lv_constraints_3_0=ruleJvmUpperBoundAnded
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
			)
			    |
			(
				(
					(
						{
							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundParserRuleCall_2_1_0_0ElementType());
						}
						lv_constraints_4_0=ruleJvmLowerBound
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				(
					(
						{
							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0ElementType());
						}
						lv_constraints_5_0=ruleJvmLowerBoundAnded
						{
							doneComposite();
							if(!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)*
			)
		)?
	)
;

//Entry rule entryRuleJvmUpperBound
entryRuleJvmUpperBound returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getJvmUpperBoundElementType()); }
	iv_ruleJvmUpperBound=ruleJvmUpperBound
	{ $current=$iv_ruleJvmUpperBound.current; }
	EOF;

// Rule JvmUpperBound
ruleJvmUpperBound returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getJvmUpperBound_ExtendsKeyword_0ElementType());
		}
		otherlv_0='extends'
		{
			doneLeaf(otherlv_0);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getJvmUpperBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
				}
				lv_typeReference_1_0=ruleJvmTypeReference
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleJvmUpperBoundAnded
entryRuleJvmUpperBoundAnded returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getJvmUpperBoundAndedElementType()); }
	iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded
	{ $current=$iv_ruleJvmUpperBoundAnded.current; }
	EOF;

// Rule JvmUpperBoundAnded
ruleJvmUpperBoundAnded returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getJvmUpperBoundAnded_AmpersandKeyword_0ElementType());
		}
		otherlv_0='&'
		{
			doneLeaf(otherlv_0);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getJvmUpperBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
				}
				lv_typeReference_1_0=ruleJvmTypeReference
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleJvmLowerBound
entryRuleJvmLowerBound returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getJvmLowerBoundElementType()); }
	iv_ruleJvmLowerBound=ruleJvmLowerBound
	{ $current=$iv_ruleJvmLowerBound.current; }
	EOF;

// Rule JvmLowerBound
ruleJvmLowerBound returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getJvmLowerBound_SuperKeyword_0ElementType());
		}
		otherlv_0='super'
		{
			doneLeaf(otherlv_0);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getJvmLowerBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
				}
				lv_typeReference_1_0=ruleJvmTypeReference
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleJvmLowerBoundAnded
entryRuleJvmLowerBoundAnded returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getJvmLowerBoundAndedElementType()); }
	iv_ruleJvmLowerBoundAnded=ruleJvmLowerBoundAnded
	{ $current=$iv_ruleJvmLowerBoundAnded.current; }
	EOF;

// Rule JvmLowerBoundAnded
ruleJvmLowerBoundAnded returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getJvmLowerBoundAnded_AmpersandKeyword_0ElementType());
		}
		otherlv_0='&'
		{
			doneLeaf(otherlv_0);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getJvmLowerBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
				}
				lv_typeReference_1_0=ruleJvmTypeReference
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleJvmTypeParameter
entryRuleJvmTypeParameter returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getJvmTypeParameterElementType()); }
	iv_ruleJvmTypeParameter=ruleJvmTypeParameter
	{ $current=$iv_ruleJvmTypeParameter.current; }
	EOF;

// Rule JvmTypeParameter
ruleJvmTypeParameter returns [Boolean current=false]
:
	(
		(
			(
				{
					markComposite(elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType());
				}
				lv_name_0_0=ruleValidID
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		(
			(
				(
					{
						markComposite(elementTypeProvider.getJvmTypeParameter_ConstraintsJvmUpperBoundParserRuleCall_1_0_0ElementType());
					}
					lv_constraints_1_0=ruleJvmUpperBound
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
			(
				(
					{
						markComposite(elementTypeProvider.getJvmTypeParameter_ConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0ElementType());
					}
					lv_constraints_2_0=ruleJvmUpperBoundAnded
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)*
		)?
	)
;

//Entry rule entryRuleQualifiedNameWithWildcard
entryRuleQualifiedNameWithWildcard returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getQualifiedNameWithWildcardElementType()); }
	iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard
	{ $current=$iv_ruleQualifiedNameWithWildcard.current; }
	EOF;

// Rule QualifiedNameWithWildcard
ruleQualifiedNameWithWildcard returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getQualifiedNameWithWildcard_QualifiedNameParserRuleCall_0ElementType());
		}
		ruleQualifiedName
		{
			doneComposite();
		}
		{
			markLeaf(elementTypeProvider.getQualifiedNameWithWildcard_FullStopKeyword_1ElementType());
		}
		kw='.'
		{
			doneLeaf(kw);
		}
		{
			markLeaf(elementTypeProvider.getQualifiedNameWithWildcard_AsteriskKeyword_2ElementType());
		}
		kw='*'
		{
			doneLeaf(kw);
		}
	)
;

//Entry rule entryRuleXImportSection
entryRuleXImportSection returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXImportSectionElementType()); }
	iv_ruleXImportSection=ruleXImportSection
	{ $current=$iv_ruleXImportSection.current; }
	EOF;

// Rule XImportSection
ruleXImportSection returns [Boolean current=false]
:
	(
		(
			{
				markComposite(elementTypeProvider.getXImportSection_ImportDeclarationsXImportDeclarationParserRuleCall_0ElementType());
			}
			lv_importDeclarations_0_0=ruleXImportDeclaration
			{
				doneComposite();
				if(!$current) {
					associateWithSemanticElement();
					$current = true;
				}
			}
		)
	)+
;

//Entry rule entryRuleXImportDeclaration
entryRuleXImportDeclaration returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getXImportDeclarationElementType()); }
	iv_ruleXImportDeclaration=ruleXImportDeclaration
	{ $current=$iv_ruleXImportDeclaration.current; }
	EOF;

// Rule XImportDeclaration
ruleXImportDeclaration returns [Boolean current=false]
:
	(
		{
			markLeaf(elementTypeProvider.getXImportDeclaration_ImportKeyword_0ElementType());
		}
		otherlv_0='import'
		{
			doneLeaf(otherlv_0);
		}
		(
			(
				(
					(
						{
							markLeaf(elementTypeProvider.getXImportDeclaration_StaticStaticKeyword_1_0_0_0ElementType());
						}
						lv_static_1_0='static'
						{
							doneLeaf(lv_static_1_0);
						}
						{
							if (!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)
				(
					(
						{
							markLeaf(elementTypeProvider.getXImportDeclaration_ExtensionExtensionKeyword_1_0_1_0ElementType());
						}
						lv_extension_2_0='extension'
						{
							doneLeaf(lv_extension_2_0);
						}
						{
							if (!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
					)
				)?
				(
					(
						{
							if (!$current) {
								associateWithSemanticElement();
								$current = true;
							}
						}
						{
							markComposite(elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0ElementType());
						}
						ruleQualifiedNameInStaticImport
						{
							doneComposite();
						}
					)
				)
				(
					(
						(
							{
								markLeaf(elementTypeProvider.getXImportDeclaration_WildcardAsteriskKeyword_1_0_3_0_0ElementType());
							}
							lv_wildcard_4_0='*'
							{
								doneLeaf(lv_wildcard_4_0);
							}
							{
								if (!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
					    |
					(
						(
							{
								markComposite(elementTypeProvider.getXImportDeclaration_MemberNameValidIDParserRuleCall_1_0_3_1_0ElementType());
							}
							lv_memberName_5_0=ruleValidID
							{
								doneComposite();
								if(!$current) {
									associateWithSemanticElement();
									$current = true;
								}
							}
						)
					)
				)
			)
			    |
			(
				(
					{
						if (!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
					{
						markComposite(elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_1_0ElementType());
					}
					ruleQualifiedName
					{
						doneComposite();
					}
				)
			)
			    |
			(
				(
					{
						markComposite(elementTypeProvider.getXImportDeclaration_ImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0ElementType());
					}
					lv_importedNamespace_7_0=ruleQualifiedNameWithWildcard
					{
						doneComposite();
						if(!$current) {
							associateWithSemanticElement();
							$current = true;
						}
					}
				)
			)
		)
		(
			{
				markLeaf(elementTypeProvider.getXImportDeclaration_SemicolonKeyword_2ElementType());
			}
			otherlv_8=';'
			{
				doneLeaf(otherlv_8);
			}
		)?
	)
;

//Entry rule entryRuleQualifiedNameInStaticImport
entryRuleQualifiedNameInStaticImport returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getQualifiedNameInStaticImportElementType()); }
	iv_ruleQualifiedNameInStaticImport=ruleQualifiedNameInStaticImport
	{ $current=$iv_ruleQualifiedNameInStaticImport.current; }
	EOF;

// Rule QualifiedNameInStaticImport
ruleQualifiedNameInStaticImport returns [Boolean current=false]
:
	(
		{
			markComposite(elementTypeProvider.getQualifiedNameInStaticImport_ValidIDParserRuleCall_0ElementType());
		}
		ruleValidID
		{
			doneComposite();
		}
		{
			markLeaf(elementTypeProvider.getQualifiedNameInStaticImport_FullStopKeyword_1ElementType());
		}
		kw='.'
		{
			doneLeaf(kw);
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
