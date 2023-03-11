/*******************************************************************************
 * Copyright (c) 2010, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;

@Singleton
public class XtendGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {
	
	public class FileElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.File");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Keyword cPackageKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cPackageAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cPackageQualifiedNameParserRuleCall_0_1_0 = (RuleCall)cPackageAssignment_0_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final Assignment cImportSectionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cImportSectionXImportSectionParserRuleCall_1_0 = (RuleCall)cImportSectionAssignment_1.eContents().get(0);
		private final Assignment cXtendTypesAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cXtendTypesTypeParserRuleCall_2_0 = (RuleCall)cXtendTypesAssignment_2.eContents().get(0);
		
		//File returns XtendFile :
		//    ('package' package=QualifiedName ';'?)?
		//    importSection=XImportSection?
		//    (xtendTypes+=Type)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//('package' package=QualifiedName ';'?)?
		//importSection=XImportSection?
		//(xtendTypes+=Type)*
		public Group getGroup() { return cGroup; }
		
		//('package' package=QualifiedName ';'?)?
		public Group getGroup_0() { return cGroup_0; }
		
		//'package'
		public Keyword getPackageKeyword_0_0() { return cPackageKeyword_0_0; }
		
		//package=QualifiedName
		public Assignment getPackageAssignment_0_1() { return cPackageAssignment_0_1; }
		
		//QualifiedName
		public RuleCall getPackageQualifiedNameParserRuleCall_0_1_0() { return cPackageQualifiedNameParserRuleCall_0_1_0; }
		
		//';'?
		public Keyword getSemicolonKeyword_0_2() { return cSemicolonKeyword_0_2; }
		
		//importSection=XImportSection?
		public Assignment getImportSectionAssignment_1() { return cImportSectionAssignment_1; }
		
		//XImportSection
		public RuleCall getImportSectionXImportSectionParserRuleCall_1_0() { return cImportSectionXImportSectionParserRuleCall_1_0; }
		
		//(xtendTypes+=Type)*
		public Assignment getXtendTypesAssignment_2() { return cXtendTypesAssignment_2; }
		
		//Type
		public RuleCall getXtendTypesTypeParserRuleCall_2_0() { return cXtendTypesTypeParserRuleCall_2_0; }
	}
	public class TypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.Type");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXtendTypeDeclarationAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cAnnotationsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cAnnotationsXAnnotationParserRuleCall_1_0 = (RuleCall)cAnnotationsAssignment_1.eContents().get(0);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Action cXtendClassAnnotationInfoAction_2_0_0 = (Action)cGroup_2_0.eContents().get(0);
		private final Assignment cModifiersAssignment_2_0_1 = (Assignment)cGroup_2_0.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_0_1_0 = (RuleCall)cModifiersAssignment_2_0_1.eContents().get(0);
		private final Keyword cClassKeyword_2_0_2 = (Keyword)cGroup_2_0.eContents().get(2);
		private final Assignment cNameAssignment_2_0_3 = (Assignment)cGroup_2_0.eContents().get(3);
		private final RuleCall cNameValidIDParserRuleCall_2_0_3_0 = (RuleCall)cNameAssignment_2_0_3.eContents().get(0);
		private final Group cGroup_2_0_4 = (Group)cGroup_2_0.eContents().get(4);
		private final Keyword cLessThanSignKeyword_2_0_4_0 = (Keyword)cGroup_2_0_4.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_0_4_1 = (Assignment)cGroup_2_0_4.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_0_4_1_0 = (RuleCall)cTypeParametersAssignment_2_0_4_1.eContents().get(0);
		private final Group cGroup_2_0_4_2 = (Group)cGroup_2_0_4.eContents().get(2);
		private final Keyword cCommaKeyword_2_0_4_2_0 = (Keyword)cGroup_2_0_4_2.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_0_4_2_1 = (Assignment)cGroup_2_0_4_2.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_0_4_2_1_0 = (RuleCall)cTypeParametersAssignment_2_0_4_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_2_0_4_3 = (Keyword)cGroup_2_0_4.eContents().get(3);
		private final Group cGroup_2_0_5 = (Group)cGroup_2_0.eContents().get(5);
		private final Keyword cExtendsKeyword_2_0_5_0 = (Keyword)cGroup_2_0_5.eContents().get(0);
		private final Assignment cExtendsAssignment_2_0_5_1 = (Assignment)cGroup_2_0_5.eContents().get(1);
		private final RuleCall cExtendsJvmParameterizedTypeReferenceParserRuleCall_2_0_5_1_0 = (RuleCall)cExtendsAssignment_2_0_5_1.eContents().get(0);
		private final Group cGroup_2_0_6 = (Group)cGroup_2_0.eContents().get(6);
		private final Keyword cImplementsKeyword_2_0_6_0 = (Keyword)cGroup_2_0_6.eContents().get(0);
		private final Assignment cImplementsAssignment_2_0_6_1 = (Assignment)cGroup_2_0_6.eContents().get(1);
		private final RuleCall cImplementsJvmSuperTypeReferenceParserRuleCall_2_0_6_1_0 = (RuleCall)cImplementsAssignment_2_0_6_1.eContents().get(0);
		private final Group cGroup_2_0_6_2 = (Group)cGroup_2_0_6.eContents().get(2);
		private final Keyword cCommaKeyword_2_0_6_2_0 = (Keyword)cGroup_2_0_6_2.eContents().get(0);
		private final Assignment cImplementsAssignment_2_0_6_2_1 = (Assignment)cGroup_2_0_6_2.eContents().get(1);
		private final RuleCall cImplementsJvmSuperTypeReferenceParserRuleCall_2_0_6_2_1_0 = (RuleCall)cImplementsAssignment_2_0_6_2_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2_0_7 = (Keyword)cGroup_2_0.eContents().get(7);
		private final Assignment cMembersAssignment_2_0_8 = (Assignment)cGroup_2_0.eContents().get(8);
		private final RuleCall cMembersMemberParserRuleCall_2_0_8_0 = (RuleCall)cMembersAssignment_2_0_8.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2_0_9 = (Keyword)cGroup_2_0.eContents().get(9);
		private final Group cGroup_2_1 = (Group)cAlternatives_2.eContents().get(1);
		private final Action cXtendInterfaceAnnotationInfoAction_2_1_0 = (Action)cGroup_2_1.eContents().get(0);
		private final Assignment cModifiersAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_1_1_0 = (RuleCall)cModifiersAssignment_2_1_1.eContents().get(0);
		private final Keyword cInterfaceKeyword_2_1_2 = (Keyword)cGroup_2_1.eContents().get(2);
		private final Assignment cNameAssignment_2_1_3 = (Assignment)cGroup_2_1.eContents().get(3);
		private final RuleCall cNameValidIDParserRuleCall_2_1_3_0 = (RuleCall)cNameAssignment_2_1_3.eContents().get(0);
		private final Group cGroup_2_1_4 = (Group)cGroup_2_1.eContents().get(4);
		private final Keyword cLessThanSignKeyword_2_1_4_0 = (Keyword)cGroup_2_1_4.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_1_4_1 = (Assignment)cGroup_2_1_4.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0 = (RuleCall)cTypeParametersAssignment_2_1_4_1.eContents().get(0);
		private final Group cGroup_2_1_4_2 = (Group)cGroup_2_1_4.eContents().get(2);
		private final Keyword cCommaKeyword_2_1_4_2_0 = (Keyword)cGroup_2_1_4_2.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_1_4_2_1 = (Assignment)cGroup_2_1_4_2.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0 = (RuleCall)cTypeParametersAssignment_2_1_4_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_2_1_4_3 = (Keyword)cGroup_2_1_4.eContents().get(3);
		private final Group cGroup_2_1_5 = (Group)cGroup_2_1.eContents().get(5);
		private final Keyword cExtendsKeyword_2_1_5_0 = (Keyword)cGroup_2_1_5.eContents().get(0);
		private final Assignment cExtendsAssignment_2_1_5_1 = (Assignment)cGroup_2_1_5.eContents().get(1);
		private final RuleCall cExtendsJvmSuperTypeReferenceParserRuleCall_2_1_5_1_0 = (RuleCall)cExtendsAssignment_2_1_5_1.eContents().get(0);
		private final Group cGroup_2_1_5_2 = (Group)cGroup_2_1_5.eContents().get(2);
		private final Keyword cCommaKeyword_2_1_5_2_0 = (Keyword)cGroup_2_1_5_2.eContents().get(0);
		private final Assignment cExtendsAssignment_2_1_5_2_1 = (Assignment)cGroup_2_1_5_2.eContents().get(1);
		private final RuleCall cExtendsJvmSuperTypeReferenceParserRuleCall_2_1_5_2_1_0 = (RuleCall)cExtendsAssignment_2_1_5_2_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2_1_6 = (Keyword)cGroup_2_1.eContents().get(6);
		private final Assignment cMembersAssignment_2_1_7 = (Assignment)cGroup_2_1.eContents().get(7);
		private final RuleCall cMembersMemberParserRuleCall_2_1_7_0 = (RuleCall)cMembersAssignment_2_1_7.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2_1_8 = (Keyword)cGroup_2_1.eContents().get(8);
		private final Group cGroup_2_2 = (Group)cAlternatives_2.eContents().get(2);
		private final Action cXtendEnumAnnotationInfoAction_2_2_0 = (Action)cGroup_2_2.eContents().get(0);
		private final Assignment cModifiersAssignment_2_2_1 = (Assignment)cGroup_2_2.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_2_1_0 = (RuleCall)cModifiersAssignment_2_2_1.eContents().get(0);
		private final Keyword cEnumKeyword_2_2_2 = (Keyword)cGroup_2_2.eContents().get(2);
		private final Assignment cNameAssignment_2_2_3 = (Assignment)cGroup_2_2.eContents().get(3);
		private final RuleCall cNameValidIDParserRuleCall_2_2_3_0 = (RuleCall)cNameAssignment_2_2_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2_2_4 = (Keyword)cGroup_2_2.eContents().get(4);
		private final Group cGroup_2_2_5 = (Group)cGroup_2_2.eContents().get(5);
		private final Assignment cMembersAssignment_2_2_5_0 = (Assignment)cGroup_2_2_5.eContents().get(0);
		private final RuleCall cMembersXtendEnumLiteralParserRuleCall_2_2_5_0_0 = (RuleCall)cMembersAssignment_2_2_5_0.eContents().get(0);
		private final Group cGroup_2_2_5_1 = (Group)cGroup_2_2_5.eContents().get(1);
		private final Keyword cCommaKeyword_2_2_5_1_0 = (Keyword)cGroup_2_2_5_1.eContents().get(0);
		private final Assignment cMembersAssignment_2_2_5_1_1 = (Assignment)cGroup_2_2_5_1.eContents().get(1);
		private final RuleCall cMembersXtendEnumLiteralParserRuleCall_2_2_5_1_1_0 = (RuleCall)cMembersAssignment_2_2_5_1_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_2_2_6 = (Keyword)cGroup_2_2.eContents().get(6);
		private final Keyword cRightCurlyBracketKeyword_2_2_7 = (Keyword)cGroup_2_2.eContents().get(7);
		private final Group cGroup_2_3 = (Group)cAlternatives_2.eContents().get(3);
		private final Action cXtendAnnotationTypeAnnotationInfoAction_2_3_0 = (Action)cGroup_2_3.eContents().get(0);
		private final Assignment cModifiersAssignment_2_3_1 = (Assignment)cGroup_2_3.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_3_1_0 = (RuleCall)cModifiersAssignment_2_3_1.eContents().get(0);
		private final Keyword cAnnotationKeyword_2_3_2 = (Keyword)cGroup_2_3.eContents().get(2);
		private final Assignment cNameAssignment_2_3_3 = (Assignment)cGroup_2_3.eContents().get(3);
		private final RuleCall cNameValidIDParserRuleCall_2_3_3_0 = (RuleCall)cNameAssignment_2_3_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2_3_4 = (Keyword)cGroup_2_3.eContents().get(4);
		private final Assignment cMembersAssignment_2_3_5 = (Assignment)cGroup_2_3.eContents().get(5);
		private final RuleCall cMembersAnnotationFieldParserRuleCall_2_3_5_0 = (RuleCall)cMembersAssignment_2_3_5.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2_3_6 = (Keyword)cGroup_2_3.eContents().get(6);
		
		//Type returns XtendTypeDeclaration :
		//    {XtendTypeDeclaration} annotations+=XAnnotation*
		//    (
		//        {XtendClass.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'class' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//        ("extends" extends=JvmParameterizedTypeReference)?
		//        ('implements' implements+=JvmSuperTypeReference (',' implements+=JvmSuperTypeReference)*)?'{'
		//            (members+=Member)*
		//        '}'
		//     |
		//        {XtendInterface.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'interface' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//        ('extends' extends+=JvmSuperTypeReference (',' extends+=JvmSuperTypeReference)*)?'{'
		//            (members+=Member)*
		//        '}'
		//     |
		//        {XtendEnum.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'enum' name=ValidID '{'
		//            (members+=XtendEnumLiteral (',' members+=XtendEnumLiteral)*)? ';'?
		//        '}'
		//     |
		//        {XtendAnnotationType.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'annotation' name=ValidID '{'
		//            (members+=AnnotationField)*
		//        '}'
		//    )
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{XtendTypeDeclaration} annotations+=XAnnotation*
		//(
		//    {XtendClass.annotationInfo = current}
		//    modifiers+=CommonModifier*
		//    'class' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//    ("extends" extends=JvmParameterizedTypeReference)?
		//    ('implements' implements+=JvmSuperTypeReference (',' implements+=JvmSuperTypeReference)*)?'{'
		//        (members+=Member)*
		//    '}'
		// |
		//    {XtendInterface.annotationInfo = current}
		//    modifiers+=CommonModifier*
		//    'interface' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//    ('extends' extends+=JvmSuperTypeReference (',' extends+=JvmSuperTypeReference)*)?'{'
		//        (members+=Member)*
		//    '}'
		// |
		//    {XtendEnum.annotationInfo = current}
		//    modifiers+=CommonModifier*
		//    'enum' name=ValidID '{'
		//        (members+=XtendEnumLiteral (',' members+=XtendEnumLiteral)*)? ';'?
		//    '}'
		// |
		//    {XtendAnnotationType.annotationInfo = current}
		//    modifiers+=CommonModifier*
		//    'annotation' name=ValidID '{'
		//        (members+=AnnotationField)*
		//    '}'
		//)
		public Group getGroup() { return cGroup; }
		
		//{XtendTypeDeclaration}
		public Action getXtendTypeDeclarationAction_0() { return cXtendTypeDeclarationAction_0; }
		
		//annotations+=XAnnotation*
		public Assignment getAnnotationsAssignment_1() { return cAnnotationsAssignment_1; }
		
		//XAnnotation
		public RuleCall getAnnotationsXAnnotationParserRuleCall_1_0() { return cAnnotationsXAnnotationParserRuleCall_1_0; }
		
		//(
		//    {XtendClass.annotationInfo = current}
		//    modifiers+=CommonModifier*
		//    'class' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//    ("extends" extends=JvmParameterizedTypeReference)?
		//    ('implements' implements+=JvmSuperTypeReference (',' implements+=JvmSuperTypeReference)*)?'{'
		//        (members+=Member)*
		//    '}'
		// |
		//    {XtendInterface.annotationInfo = current}
		//    modifiers+=CommonModifier*
		//    'interface' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//    ('extends' extends+=JvmSuperTypeReference (',' extends+=JvmSuperTypeReference)*)?'{'
		//        (members+=Member)*
		//    '}'
		// |
		//    {XtendEnum.annotationInfo = current}
		//    modifiers+=CommonModifier*
		//    'enum' name=ValidID '{'
		//        (members+=XtendEnumLiteral (',' members+=XtendEnumLiteral)*)? ';'?
		//    '}'
		// |
		//    {XtendAnnotationType.annotationInfo = current}
		//    modifiers+=CommonModifier*
		//    'annotation' name=ValidID '{'
		//        (members+=AnnotationField)*
		//    '}'
		//)
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//{XtendClass.annotationInfo = current}
		//modifiers+=CommonModifier*
		//'class' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//("extends" extends=JvmParameterizedTypeReference)?
		//('implements' implements+=JvmSuperTypeReference (',' implements+=JvmSuperTypeReference)*)?'{'
		//    (members+=Member)*
		//'}'
		public Group getGroup_2_0() { return cGroup_2_0; }
		
		//{XtendClass.annotationInfo = current}
		public Action getXtendClassAnnotationInfoAction_2_0_0() { return cXtendClassAnnotationInfoAction_2_0_0; }
		
		//modifiers+=CommonModifier*
		public Assignment getModifiersAssignment_2_0_1() { return cModifiersAssignment_2_0_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_0_1_0() { return cModifiersCommonModifierParserRuleCall_2_0_1_0; }
		
		//'class'
		public Keyword getClassKeyword_2_0_2() { return cClassKeyword_2_0_2; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_0_3() { return cNameAssignment_2_0_3; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_0_3_0() { return cNameValidIDParserRuleCall_2_0_3_0; }
		
		//('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		public Group getGroup_2_0_4() { return cGroup_2_0_4; }
		
		//'<'
		public Keyword getLessThanSignKeyword_2_0_4_0() { return cLessThanSignKeyword_2_0_4_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_0_4_1() { return cTypeParametersAssignment_2_0_4_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_0_4_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_0_4_1_0; }
		
		//(',' typeParameters+=JvmTypeParameter)*
		public Group getGroup_2_0_4_2() { return cGroup_2_0_4_2; }
		
		//','
		public Keyword getCommaKeyword_2_0_4_2_0() { return cCommaKeyword_2_0_4_2_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_0_4_2_1() { return cTypeParametersAssignment_2_0_4_2_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_0_4_2_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_0_4_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_2_0_4_3() { return cGreaterThanSignKeyword_2_0_4_3; }
		
		//("extends" extends=JvmParameterizedTypeReference)?
		public Group getGroup_2_0_5() { return cGroup_2_0_5; }
		
		//"extends"
		public Keyword getExtendsKeyword_2_0_5_0() { return cExtendsKeyword_2_0_5_0; }
		
		//extends=JvmParameterizedTypeReference
		public Assignment getExtendsAssignment_2_0_5_1() { return cExtendsAssignment_2_0_5_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_0_5_1_0() { return cExtendsJvmParameterizedTypeReferenceParserRuleCall_2_0_5_1_0; }
		
		//('implements' implements+=JvmSuperTypeReference (',' implements+=JvmSuperTypeReference)*)?
		public Group getGroup_2_0_6() { return cGroup_2_0_6; }
		
		//'implements'
		public Keyword getImplementsKeyword_2_0_6_0() { return cImplementsKeyword_2_0_6_0; }
		
		//implements+=JvmSuperTypeReference
		public Assignment getImplementsAssignment_2_0_6_1() { return cImplementsAssignment_2_0_6_1; }
		
		//JvmSuperTypeReference
		public RuleCall getImplementsJvmSuperTypeReferenceParserRuleCall_2_0_6_1_0() { return cImplementsJvmSuperTypeReferenceParserRuleCall_2_0_6_1_0; }
		
		//(',' implements+=JvmSuperTypeReference)*
		public Group getGroup_2_0_6_2() { return cGroup_2_0_6_2; }
		
		//','
		public Keyword getCommaKeyword_2_0_6_2_0() { return cCommaKeyword_2_0_6_2_0; }
		
		//implements+=JvmSuperTypeReference
		public Assignment getImplementsAssignment_2_0_6_2_1() { return cImplementsAssignment_2_0_6_2_1; }
		
		//JvmSuperTypeReference
		public RuleCall getImplementsJvmSuperTypeReferenceParserRuleCall_2_0_6_2_1_0() { return cImplementsJvmSuperTypeReferenceParserRuleCall_2_0_6_2_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_0_7() { return cLeftCurlyBracketKeyword_2_0_7; }
		
		//(members+=Member)*
		public Assignment getMembersAssignment_2_0_8() { return cMembersAssignment_2_0_8; }
		
		//Member
		public RuleCall getMembersMemberParserRuleCall_2_0_8_0() { return cMembersMemberParserRuleCall_2_0_8_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_2_0_9() { return cRightCurlyBracketKeyword_2_0_9; }
		
		//{XtendInterface.annotationInfo = current}
		//modifiers+=CommonModifier*
		//'interface' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//('extends' extends+=JvmSuperTypeReference (',' extends+=JvmSuperTypeReference)*)?'{'
		//    (members+=Member)*
		//'}'
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//{XtendInterface.annotationInfo = current}
		public Action getXtendInterfaceAnnotationInfoAction_2_1_0() { return cXtendInterfaceAnnotationInfoAction_2_1_0; }
		
		//modifiers+=CommonModifier*
		public Assignment getModifiersAssignment_2_1_1() { return cModifiersAssignment_2_1_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_1_1_0() { return cModifiersCommonModifierParserRuleCall_2_1_1_0; }
		
		//'interface'
		public Keyword getInterfaceKeyword_2_1_2() { return cInterfaceKeyword_2_1_2; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_1_3() { return cNameAssignment_2_1_3; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_1_3_0() { return cNameValidIDParserRuleCall_2_1_3_0; }
		
		//('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		public Group getGroup_2_1_4() { return cGroup_2_1_4; }
		
		//'<'
		public Keyword getLessThanSignKeyword_2_1_4_0() { return cLessThanSignKeyword_2_1_4_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_1_4_1() { return cTypeParametersAssignment_2_1_4_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0; }
		
		//(',' typeParameters+=JvmTypeParameter)*
		public Group getGroup_2_1_4_2() { return cGroup_2_1_4_2; }
		
		//','
		public Keyword getCommaKeyword_2_1_4_2_0() { return cCommaKeyword_2_1_4_2_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_1_4_2_1() { return cTypeParametersAssignment_2_1_4_2_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_2_1_4_3() { return cGreaterThanSignKeyword_2_1_4_3; }
		
		//('extends' extends+=JvmSuperTypeReference (',' extends+=JvmSuperTypeReference)*)?
		public Group getGroup_2_1_5() { return cGroup_2_1_5; }
		
		//'extends'
		public Keyword getExtendsKeyword_2_1_5_0() { return cExtendsKeyword_2_1_5_0; }
		
		//extends+=JvmSuperTypeReference
		public Assignment getExtendsAssignment_2_1_5_1() { return cExtendsAssignment_2_1_5_1; }
		
		//JvmSuperTypeReference
		public RuleCall getExtendsJvmSuperTypeReferenceParserRuleCall_2_1_5_1_0() { return cExtendsJvmSuperTypeReferenceParserRuleCall_2_1_5_1_0; }
		
		//(',' extends+=JvmSuperTypeReference)*
		public Group getGroup_2_1_5_2() { return cGroup_2_1_5_2; }
		
		//','
		public Keyword getCommaKeyword_2_1_5_2_0() { return cCommaKeyword_2_1_5_2_0; }
		
		//extends+=JvmSuperTypeReference
		public Assignment getExtendsAssignment_2_1_5_2_1() { return cExtendsAssignment_2_1_5_2_1; }
		
		//JvmSuperTypeReference
		public RuleCall getExtendsJvmSuperTypeReferenceParserRuleCall_2_1_5_2_1_0() { return cExtendsJvmSuperTypeReferenceParserRuleCall_2_1_5_2_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_1_6() { return cLeftCurlyBracketKeyword_2_1_6; }
		
		//(members+=Member)*
		public Assignment getMembersAssignment_2_1_7() { return cMembersAssignment_2_1_7; }
		
		//Member
		public RuleCall getMembersMemberParserRuleCall_2_1_7_0() { return cMembersMemberParserRuleCall_2_1_7_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_2_1_8() { return cRightCurlyBracketKeyword_2_1_8; }
		
		//{XtendEnum.annotationInfo = current}
		//modifiers+=CommonModifier*
		//'enum' name=ValidID '{'
		//    (members+=XtendEnumLiteral (',' members+=XtendEnumLiteral)*)? ';'?
		//'}'
		public Group getGroup_2_2() { return cGroup_2_2; }
		
		//{XtendEnum.annotationInfo = current}
		public Action getXtendEnumAnnotationInfoAction_2_2_0() { return cXtendEnumAnnotationInfoAction_2_2_0; }
		
		//modifiers+=CommonModifier*
		public Assignment getModifiersAssignment_2_2_1() { return cModifiersAssignment_2_2_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_2_1_0() { return cModifiersCommonModifierParserRuleCall_2_2_1_0; }
		
		//'enum'
		public Keyword getEnumKeyword_2_2_2() { return cEnumKeyword_2_2_2; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_2_3() { return cNameAssignment_2_2_3; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_2_3_0() { return cNameValidIDParserRuleCall_2_2_3_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_2_4() { return cLeftCurlyBracketKeyword_2_2_4; }
		
		//(members+=XtendEnumLiteral (',' members+=XtendEnumLiteral)*)?
		public Group getGroup_2_2_5() { return cGroup_2_2_5; }
		
		//members+=XtendEnumLiteral
		public Assignment getMembersAssignment_2_2_5_0() { return cMembersAssignment_2_2_5_0; }
		
		//XtendEnumLiteral
		public RuleCall getMembersXtendEnumLiteralParserRuleCall_2_2_5_0_0() { return cMembersXtendEnumLiteralParserRuleCall_2_2_5_0_0; }
		
		//(',' members+=XtendEnumLiteral)*
		public Group getGroup_2_2_5_1() { return cGroup_2_2_5_1; }
		
		//','
		public Keyword getCommaKeyword_2_2_5_1_0() { return cCommaKeyword_2_2_5_1_0; }
		
		//members+=XtendEnumLiteral
		public Assignment getMembersAssignment_2_2_5_1_1() { return cMembersAssignment_2_2_5_1_1; }
		
		//XtendEnumLiteral
		public RuleCall getMembersXtendEnumLiteralParserRuleCall_2_2_5_1_1_0() { return cMembersXtendEnumLiteralParserRuleCall_2_2_5_1_1_0; }
		
		//';'?
		public Keyword getSemicolonKeyword_2_2_6() { return cSemicolonKeyword_2_2_6; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_2_2_7() { return cRightCurlyBracketKeyword_2_2_7; }
		
		//{XtendAnnotationType.annotationInfo = current}
		//modifiers+=CommonModifier*
		//'annotation' name=ValidID '{'
		//    (members+=AnnotationField)*
		//'}'
		public Group getGroup_2_3() { return cGroup_2_3; }
		
		//{XtendAnnotationType.annotationInfo = current}
		public Action getXtendAnnotationTypeAnnotationInfoAction_2_3_0() { return cXtendAnnotationTypeAnnotationInfoAction_2_3_0; }
		
		//modifiers+=CommonModifier*
		public Assignment getModifiersAssignment_2_3_1() { return cModifiersAssignment_2_3_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_3_1_0() { return cModifiersCommonModifierParserRuleCall_2_3_1_0; }
		
		//'annotation'
		public Keyword getAnnotationKeyword_2_3_2() { return cAnnotationKeyword_2_3_2; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_3_3() { return cNameAssignment_2_3_3; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_3_3_0() { return cNameValidIDParserRuleCall_2_3_3_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_3_4() { return cLeftCurlyBracketKeyword_2_3_4; }
		
		//(members+=AnnotationField)*
		public Assignment getMembersAssignment_2_3_5() { return cMembersAssignment_2_3_5; }
		
		//AnnotationField
		public RuleCall getMembersAnnotationFieldParserRuleCall_2_3_5_0() { return cMembersAnnotationFieldParserRuleCall_2_3_5_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_2_3_6() { return cRightCurlyBracketKeyword_2_3_6; }
	}
	public class JvmSuperTypeReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.JvmSuperTypeReference");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cJvmParameterizedTypeReferenceParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cXFunctionSuperTypeRefParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//JvmSuperTypeReference returns types::JvmTypeReference:
		//    JvmParameterizedTypeReference | XFunctionSuperTypeRef
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//JvmParameterizedTypeReference | XFunctionSuperTypeRef
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//JvmParameterizedTypeReference
		public RuleCall getJvmParameterizedTypeReferenceParserRuleCall_0() { return cJvmParameterizedTypeReferenceParserRuleCall_0; }
		
		//XFunctionSuperTypeRef
		public RuleCall getXFunctionSuperTypeRefParserRuleCall_1() { return cXFunctionSuperTypeRefParserRuleCall_1; }
	}
	public class XFunctionSuperTypeRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.XFunctionSuperTypeRef");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Assignment cInstanceContextAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final Keyword cInstanceContextLeftParenthesisKeyword_0_0_0 = (Keyword)cInstanceContextAssignment_0_0.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cGroup_0.eContents().get(1);
		private final Assignment cParamTypesAssignment_0_1_0 = (Assignment)cGroup_0_1.eContents().get(0);
		private final RuleCall cParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0 = (RuleCall)cParamTypesAssignment_0_1_0.eContents().get(0);
		private final Group cGroup_0_1_1 = (Group)cGroup_0_1.eContents().get(1);
		private final Keyword cCommaKeyword_0_1_1_0 = (Keyword)cGroup_0_1_1.eContents().get(0);
		private final Assignment cParamTypesAssignment_0_1_1_1 = (Assignment)cGroup_0_1_1.eContents().get(1);
		private final RuleCall cParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0 = (RuleCall)cParamTypesAssignment_0_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final Keyword cEqualsSignGreaterThanSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cReturnTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cReturnTypeJvmTypeReferenceParserRuleCall_2_0 = (RuleCall)cReturnTypeAssignment_2.eContents().get(0);
		
		//XFunctionSuperTypeRef returns xtype::XFunctionTypeRef:
		//    (instanceContext?='(' (paramTypes+=JvmTypeReference (',' paramTypes+=JvmTypeReference)*)? ')')? '=>' returnType=JvmTypeReference;
		@Override public ParserRule getRule() { return rule; }
		
		//(instanceContext?='(' (paramTypes+=JvmTypeReference (',' paramTypes+=JvmTypeReference)*)? ')')? '=>' returnType=JvmTypeReference
		public Group getGroup() { return cGroup; }
		
		//(instanceContext?='(' (paramTypes+=JvmTypeReference (',' paramTypes+=JvmTypeReference)*)? ')')?
		public Group getGroup_0() { return cGroup_0; }
		
		//instanceContext?='('
		public Assignment getInstanceContextAssignment_0_0() { return cInstanceContextAssignment_0_0; }
		
		//'('
		public Keyword getInstanceContextLeftParenthesisKeyword_0_0_0() { return cInstanceContextLeftParenthesisKeyword_0_0_0; }
		
		//(paramTypes+=JvmTypeReference (',' paramTypes+=JvmTypeReference)*)?
		public Group getGroup_0_1() { return cGroup_0_1; }
		
		//paramTypes+=JvmTypeReference
		public Assignment getParamTypesAssignment_0_1_0() { return cParamTypesAssignment_0_1_0; }
		
		//JvmTypeReference
		public RuleCall getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0() { return cParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0; }
		
		//(',' paramTypes+=JvmTypeReference)*
		public Group getGroup_0_1_1() { return cGroup_0_1_1; }
		
		//','
		public Keyword getCommaKeyword_0_1_1_0() { return cCommaKeyword_0_1_1_0; }
		
		//paramTypes+=JvmTypeReference
		public Assignment getParamTypesAssignment_0_1_1_1() { return cParamTypesAssignment_0_1_1_1; }
		
		//JvmTypeReference
		public RuleCall getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0() { return cParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_0_2() { return cRightParenthesisKeyword_0_2; }
		
		//'=>'
		public Keyword getEqualsSignGreaterThanSignKeyword_1() { return cEqualsSignGreaterThanSignKeyword_1; }
		
		//returnType=JvmTypeReference
		public Assignment getReturnTypeAssignment_2() { return cReturnTypeAssignment_2; }
		
		//JvmTypeReference
		public RuleCall getReturnTypeJvmTypeReferenceParserRuleCall_2_0() { return cReturnTypeJvmTypeReferenceParserRuleCall_2_0; }
	}
	public class AnnotationFieldElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.AnnotationField");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXtendMemberAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cAnnotationsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cAnnotationsXAnnotationParserRuleCall_1_0 = (RuleCall)cAnnotationsAssignment_1.eContents().get(0);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Alternatives cAlternatives_2_0_0 = (Alternatives)cGroup_2_0.eContents().get(0);
		private final Group cGroup_2_0_0_0 = (Group)cAlternatives_2_0_0.eContents().get(0);
		private final Action cXtendFieldAnnotationInfoAction_2_0_0_0_0 = (Action)cGroup_2_0_0_0.eContents().get(0);
		private final Assignment cModifiersAssignment_2_0_0_0_1 = (Assignment)cGroup_2_0_0_0.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_0_0_0_1_0 = (RuleCall)cModifiersAssignment_2_0_0_0_1.eContents().get(0);
		private final Assignment cModifiersAssignment_2_0_0_0_2 = (Assignment)cGroup_2_0_0_0.eContents().get(2);
		private final RuleCall cModifiersFieldModifierParserRuleCall_2_0_0_0_2_0 = (RuleCall)cModifiersAssignment_2_0_0_0_2.eContents().get(0);
		private final Assignment cModifiersAssignment_2_0_0_0_3 = (Assignment)cGroup_2_0_0_0.eContents().get(3);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_0_0_0_3_0 = (RuleCall)cModifiersAssignment_2_0_0_0_3.eContents().get(0);
		private final Assignment cTypeAssignment_2_0_0_0_4 = (Assignment)cGroup_2_0_0_0.eContents().get(4);
		private final RuleCall cTypeJvmTypeReferenceParserRuleCall_2_0_0_0_4_0 = (RuleCall)cTypeAssignment_2_0_0_0_4.eContents().get(0);
		private final Assignment cNameAssignment_2_0_0_0_5 = (Assignment)cGroup_2_0_0_0.eContents().get(5);
		private final RuleCall cNameValidIDParserRuleCall_2_0_0_0_5_0 = (RuleCall)cNameAssignment_2_0_0_0_5.eContents().get(0);
		private final Group cGroup_2_0_0_1 = (Group)cAlternatives_2_0_0.eContents().get(1);
		private final Action cXtendFieldAnnotationInfoAction_2_0_0_1_0 = (Action)cGroup_2_0_0_1.eContents().get(0);
		private final Assignment cModifiersAssignment_2_0_0_1_1 = (Assignment)cGroup_2_0_0_1.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_0_0_1_1_0 = (RuleCall)cModifiersAssignment_2_0_0_1_1.eContents().get(0);
		private final Assignment cTypeAssignment_2_0_0_1_2 = (Assignment)cGroup_2_0_0_1.eContents().get(2);
		private final RuleCall cTypeJvmTypeReferenceParserRuleCall_2_0_0_1_2_0 = (RuleCall)cTypeAssignment_2_0_0_1_2.eContents().get(0);
		private final Assignment cNameAssignment_2_0_0_1_3 = (Assignment)cGroup_2_0_0_1.eContents().get(3);
		private final RuleCall cNameValidIDParserRuleCall_2_0_0_1_3_0 = (RuleCall)cNameAssignment_2_0_0_1_3.eContents().get(0);
		private final Group cGroup_2_0_1 = (Group)cGroup_2_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_2_0_1_0 = (Keyword)cGroup_2_0_1.eContents().get(0);
		private final Assignment cInitialValueAssignment_2_0_1_1 = (Assignment)cGroup_2_0_1.eContents().get(1);
		private final RuleCall cInitialValueXAnnotationElementValueParserRuleCall_2_0_1_1_0 = (RuleCall)cInitialValueAssignment_2_0_1_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_2_0_2 = (Keyword)cGroup_2_0.eContents().get(2);
		private final Group cGroup_2_1 = (Group)cAlternatives_2.eContents().get(1);
		private final Action cXtendClassAnnotationInfoAction_2_1_0 = (Action)cGroup_2_1.eContents().get(0);
		private final Assignment cModifiersAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_1_1_0 = (RuleCall)cModifiersAssignment_2_1_1.eContents().get(0);
		private final Keyword cClassKeyword_2_1_2 = (Keyword)cGroup_2_1.eContents().get(2);
		private final Assignment cNameAssignment_2_1_3 = (Assignment)cGroup_2_1.eContents().get(3);
		private final RuleCall cNameValidIDParserRuleCall_2_1_3_0 = (RuleCall)cNameAssignment_2_1_3.eContents().get(0);
		private final Group cGroup_2_1_4 = (Group)cGroup_2_1.eContents().get(4);
		private final Keyword cLessThanSignKeyword_2_1_4_0 = (Keyword)cGroup_2_1_4.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_1_4_1 = (Assignment)cGroup_2_1_4.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0 = (RuleCall)cTypeParametersAssignment_2_1_4_1.eContents().get(0);
		private final Group cGroup_2_1_4_2 = (Group)cGroup_2_1_4.eContents().get(2);
		private final Keyword cCommaKeyword_2_1_4_2_0 = (Keyword)cGroup_2_1_4_2.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_1_4_2_1 = (Assignment)cGroup_2_1_4_2.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0 = (RuleCall)cTypeParametersAssignment_2_1_4_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_2_1_4_3 = (Keyword)cGroup_2_1_4.eContents().get(3);
		private final Group cGroup_2_1_5 = (Group)cGroup_2_1.eContents().get(5);
		private final Keyword cExtendsKeyword_2_1_5_0 = (Keyword)cGroup_2_1_5.eContents().get(0);
		private final Assignment cExtendsAssignment_2_1_5_1 = (Assignment)cGroup_2_1_5.eContents().get(1);
		private final RuleCall cExtendsJvmParameterizedTypeReferenceParserRuleCall_2_1_5_1_0 = (RuleCall)cExtendsAssignment_2_1_5_1.eContents().get(0);
		private final Group cGroup_2_1_6 = (Group)cGroup_2_1.eContents().get(6);
		private final Keyword cImplementsKeyword_2_1_6_0 = (Keyword)cGroup_2_1_6.eContents().get(0);
		private final Assignment cImplementsAssignment_2_1_6_1 = (Assignment)cGroup_2_1_6.eContents().get(1);
		private final RuleCall cImplementsJvmParameterizedTypeReferenceParserRuleCall_2_1_6_1_0 = (RuleCall)cImplementsAssignment_2_1_6_1.eContents().get(0);
		private final Group cGroup_2_1_6_2 = (Group)cGroup_2_1_6.eContents().get(2);
		private final Keyword cCommaKeyword_2_1_6_2_0 = (Keyword)cGroup_2_1_6_2.eContents().get(0);
		private final Assignment cImplementsAssignment_2_1_6_2_1 = (Assignment)cGroup_2_1_6_2.eContents().get(1);
		private final RuleCall cImplementsJvmParameterizedTypeReferenceParserRuleCall_2_1_6_2_1_0 = (RuleCall)cImplementsAssignment_2_1_6_2_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2_1_7 = (Keyword)cGroup_2_1.eContents().get(7);
		private final Assignment cMembersAssignment_2_1_8 = (Assignment)cGroup_2_1.eContents().get(8);
		private final RuleCall cMembersMemberParserRuleCall_2_1_8_0 = (RuleCall)cMembersAssignment_2_1_8.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2_1_9 = (Keyword)cGroup_2_1.eContents().get(9);
		private final Group cGroup_2_2 = (Group)cAlternatives_2.eContents().get(2);
		private final Action cXtendInterfaceAnnotationInfoAction_2_2_0 = (Action)cGroup_2_2.eContents().get(0);
		private final Assignment cModifiersAssignment_2_2_1 = (Assignment)cGroup_2_2.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_2_1_0 = (RuleCall)cModifiersAssignment_2_2_1.eContents().get(0);
		private final Keyword cInterfaceKeyword_2_2_2 = (Keyword)cGroup_2_2.eContents().get(2);
		private final Assignment cNameAssignment_2_2_3 = (Assignment)cGroup_2_2.eContents().get(3);
		private final RuleCall cNameValidIDParserRuleCall_2_2_3_0 = (RuleCall)cNameAssignment_2_2_3.eContents().get(0);
		private final Group cGroup_2_2_4 = (Group)cGroup_2_2.eContents().get(4);
		private final Keyword cLessThanSignKeyword_2_2_4_0 = (Keyword)cGroup_2_2_4.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_2_4_1 = (Assignment)cGroup_2_2_4.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_2_4_1_0 = (RuleCall)cTypeParametersAssignment_2_2_4_1.eContents().get(0);
		private final Group cGroup_2_2_4_2 = (Group)cGroup_2_2_4.eContents().get(2);
		private final Keyword cCommaKeyword_2_2_4_2_0 = (Keyword)cGroup_2_2_4_2.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_2_4_2_1 = (Assignment)cGroup_2_2_4_2.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_2_4_2_1_0 = (RuleCall)cTypeParametersAssignment_2_2_4_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_2_2_4_3 = (Keyword)cGroup_2_2_4.eContents().get(3);
		private final Group cGroup_2_2_5 = (Group)cGroup_2_2.eContents().get(5);
		private final Keyword cExtendsKeyword_2_2_5_0 = (Keyword)cGroup_2_2_5.eContents().get(0);
		private final Assignment cExtendsAssignment_2_2_5_1 = (Assignment)cGroup_2_2_5.eContents().get(1);
		private final RuleCall cExtendsJvmParameterizedTypeReferenceParserRuleCall_2_2_5_1_0 = (RuleCall)cExtendsAssignment_2_2_5_1.eContents().get(0);
		private final Group cGroup_2_2_5_2 = (Group)cGroup_2_2_5.eContents().get(2);
		private final Keyword cCommaKeyword_2_2_5_2_0 = (Keyword)cGroup_2_2_5_2.eContents().get(0);
		private final Assignment cExtendsAssignment_2_2_5_2_1 = (Assignment)cGroup_2_2_5_2.eContents().get(1);
		private final RuleCall cExtendsJvmParameterizedTypeReferenceParserRuleCall_2_2_5_2_1_0 = (RuleCall)cExtendsAssignment_2_2_5_2_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2_2_6 = (Keyword)cGroup_2_2.eContents().get(6);
		private final Assignment cMembersAssignment_2_2_7 = (Assignment)cGroup_2_2.eContents().get(7);
		private final RuleCall cMembersMemberParserRuleCall_2_2_7_0 = (RuleCall)cMembersAssignment_2_2_7.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2_2_8 = (Keyword)cGroup_2_2.eContents().get(8);
		private final Group cGroup_2_3 = (Group)cAlternatives_2.eContents().get(3);
		private final Action cXtendEnumAnnotationInfoAction_2_3_0 = (Action)cGroup_2_3.eContents().get(0);
		private final Assignment cModifiersAssignment_2_3_1 = (Assignment)cGroup_2_3.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_3_1_0 = (RuleCall)cModifiersAssignment_2_3_1.eContents().get(0);
		private final Keyword cEnumKeyword_2_3_2 = (Keyword)cGroup_2_3.eContents().get(2);
		private final Assignment cNameAssignment_2_3_3 = (Assignment)cGroup_2_3.eContents().get(3);
		private final RuleCall cNameValidIDParserRuleCall_2_3_3_0 = (RuleCall)cNameAssignment_2_3_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2_3_4 = (Keyword)cGroup_2_3.eContents().get(4);
		private final Group cGroup_2_3_5 = (Group)cGroup_2_3.eContents().get(5);
		private final Assignment cMembersAssignment_2_3_5_0 = (Assignment)cGroup_2_3_5.eContents().get(0);
		private final RuleCall cMembersXtendEnumLiteralParserRuleCall_2_3_5_0_0 = (RuleCall)cMembersAssignment_2_3_5_0.eContents().get(0);
		private final Group cGroup_2_3_5_1 = (Group)cGroup_2_3_5.eContents().get(1);
		private final Keyword cCommaKeyword_2_3_5_1_0 = (Keyword)cGroup_2_3_5_1.eContents().get(0);
		private final Assignment cMembersAssignment_2_3_5_1_1 = (Assignment)cGroup_2_3_5_1.eContents().get(1);
		private final RuleCall cMembersXtendEnumLiteralParserRuleCall_2_3_5_1_1_0 = (RuleCall)cMembersAssignment_2_3_5_1_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_2_3_6 = (Keyword)cGroup_2_3.eContents().get(6);
		private final Keyword cRightCurlyBracketKeyword_2_3_7 = (Keyword)cGroup_2_3.eContents().get(7);
		private final Group cGroup_2_4 = (Group)cAlternatives_2.eContents().get(4);
		private final Action cXtendAnnotationTypeAnnotationInfoAction_2_4_0 = (Action)cGroup_2_4.eContents().get(0);
		private final Assignment cModifiersAssignment_2_4_1 = (Assignment)cGroup_2_4.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_4_1_0 = (RuleCall)cModifiersAssignment_2_4_1.eContents().get(0);
		private final Keyword cAnnotationKeyword_2_4_2 = (Keyword)cGroup_2_4.eContents().get(2);
		private final Assignment cNameAssignment_2_4_3 = (Assignment)cGroup_2_4.eContents().get(3);
		private final RuleCall cNameValidIDParserRuleCall_2_4_3_0 = (RuleCall)cNameAssignment_2_4_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2_4_4 = (Keyword)cGroup_2_4.eContents().get(4);
		private final Assignment cMembersAssignment_2_4_5 = (Assignment)cGroup_2_4.eContents().get(5);
		private final RuleCall cMembersAnnotationFieldParserRuleCall_2_4_5_0 = (RuleCall)cMembersAssignment_2_4_5.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2_4_6 = (Keyword)cGroup_2_4.eContents().get(6);
		
		//AnnotationField returns XtendMember :
		//    {XtendMember} annotations+=XAnnotation*
		//    (
		//        (
		//                {XtendField.annotationInfo = current} modifiers+=CommonModifier*
		//                modifiers+=FieldModifier modifiers+=CommonModifier*
		//                type=JvmTypeReference? name=ValidID
		//            |    {XtendField.annotationInfo = current} modifiers+=CommonModifier*
		//                type=JvmTypeReference name=ValidID
		//        ) ('=' initialValue=XAnnotationElementValue)? ';'?
		//        | (
		//            {XtendClass.annotationInfo = current}
		//            modifiers+=CommonModifier*
		//            'class' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//            ("extends" extends=JvmParameterizedTypeReference)?
		//            ('implements' implements+=JvmParameterizedTypeReference (',' implements+=JvmParameterizedTypeReference)*)?'{'
		//                (members+=Member)*
		//            '}'
		//        ) | (
		//            {XtendInterface.annotationInfo = current}
		//            modifiers+=CommonModifier*
		//            'interface' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//            ('extends' extends+=JvmParameterizedTypeReference (',' extends+=JvmParameterizedTypeReference)*)?'{'
		//                (members+=Member)*
		//            '}'
		//        ) | (
		//            {XtendEnum.annotationInfo = current}
		//            modifiers+=CommonModifier*
		//            'enum' name=ValidID '{'
		//                (members+=XtendEnumLiteral (',' members+=XtendEnumLiteral)*)? ';'?
		//            '}'
		//        ) | (
		//            {XtendAnnotationType.annotationInfo = current}
		//            modifiers+=CommonModifier*
		//            'annotation' name=ValidID '{'
		//                (members+=AnnotationField)*
		//            '}'
		//        )
		//    )
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{XtendMember} annotations+=XAnnotation*
		//(
		//    (
		//            {XtendField.annotationInfo = current} modifiers+=CommonModifier*
		//            modifiers+=FieldModifier modifiers+=CommonModifier*
		//            type=JvmTypeReference? name=ValidID
		//        |    {XtendField.annotationInfo = current} modifiers+=CommonModifier*
		//            type=JvmTypeReference name=ValidID
		//    ) ('=' initialValue=XAnnotationElementValue)? ';'?
		//    | (
		//        {XtendClass.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'class' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//        ("extends" extends=JvmParameterizedTypeReference)?
		//        ('implements' implements+=JvmParameterizedTypeReference (',' implements+=JvmParameterizedTypeReference)*)?'{'
		//            (members+=Member)*
		//        '}'
		//    ) | (
		//        {XtendInterface.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'interface' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//        ('extends' extends+=JvmParameterizedTypeReference (',' extends+=JvmParameterizedTypeReference)*)?'{'
		//            (members+=Member)*
		//        '}'
		//    ) | (
		//        {XtendEnum.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'enum' name=ValidID '{'
		//            (members+=XtendEnumLiteral (',' members+=XtendEnumLiteral)*)? ';'?
		//        '}'
		//    ) | (
		//        {XtendAnnotationType.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'annotation' name=ValidID '{'
		//            (members+=AnnotationField)*
		//        '}'
		//    )
		//)
		public Group getGroup() { return cGroup; }
		
		//{XtendMember}
		public Action getXtendMemberAction_0() { return cXtendMemberAction_0; }
		
		//annotations+=XAnnotation*
		public Assignment getAnnotationsAssignment_1() { return cAnnotationsAssignment_1; }
		
		//XAnnotation
		public RuleCall getAnnotationsXAnnotationParserRuleCall_1_0() { return cAnnotationsXAnnotationParserRuleCall_1_0; }
		
		//(
		//    (
		//            {XtendField.annotationInfo = current} modifiers+=CommonModifier*
		//            modifiers+=FieldModifier modifiers+=CommonModifier*
		//            type=JvmTypeReference? name=ValidID
		//        |    {XtendField.annotationInfo = current} modifiers+=CommonModifier*
		//            type=JvmTypeReference name=ValidID
		//    ) ('=' initialValue=XAnnotationElementValue)? ';'?
		//    | (
		//        {XtendClass.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'class' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//        ("extends" extends=JvmParameterizedTypeReference)?
		//        ('implements' implements+=JvmParameterizedTypeReference (',' implements+=JvmParameterizedTypeReference)*)?'{'
		//            (members+=Member)*
		//        '}'
		//    ) | (
		//        {XtendInterface.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'interface' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//        ('extends' extends+=JvmParameterizedTypeReference (',' extends+=JvmParameterizedTypeReference)*)?'{'
		//            (members+=Member)*
		//        '}'
		//    ) | (
		//        {XtendEnum.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'enum' name=ValidID '{'
		//            (members+=XtendEnumLiteral (',' members+=XtendEnumLiteral)*)? ';'?
		//        '}'
		//    ) | (
		//        {XtendAnnotationType.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'annotation' name=ValidID '{'
		//            (members+=AnnotationField)*
		//        '}'
		//    )
		//)
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//(
		//        {XtendField.annotationInfo = current} modifiers+=CommonModifier*
		//        modifiers+=FieldModifier modifiers+=CommonModifier*
		//        type=JvmTypeReference? name=ValidID
		//    |    {XtendField.annotationInfo = current} modifiers+=CommonModifier*
		//        type=JvmTypeReference name=ValidID
		//) ('=' initialValue=XAnnotationElementValue)? ';'?
		public Group getGroup_2_0() { return cGroup_2_0; }
		
		//(
		//        {XtendField.annotationInfo = current} modifiers+=CommonModifier*
		//        modifiers+=FieldModifier modifiers+=CommonModifier*
		//        type=JvmTypeReference? name=ValidID
		//    |    {XtendField.annotationInfo = current} modifiers+=CommonModifier*
		//        type=JvmTypeReference name=ValidID
		//)
		public Alternatives getAlternatives_2_0_0() { return cAlternatives_2_0_0; }
		
		//{XtendField.annotationInfo = current} modifiers+=CommonModifier*
		//modifiers+=FieldModifier modifiers+=CommonModifier*
		//type=JvmTypeReference? name=ValidID
		public Group getGroup_2_0_0_0() { return cGroup_2_0_0_0; }
		
		//{XtendField.annotationInfo = current}
		public Action getXtendFieldAnnotationInfoAction_2_0_0_0_0() { return cXtendFieldAnnotationInfoAction_2_0_0_0_0; }
		
		//modifiers+=CommonModifier*
		public Assignment getModifiersAssignment_2_0_0_0_1() { return cModifiersAssignment_2_0_0_0_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_0_0_0_1_0() { return cModifiersCommonModifierParserRuleCall_2_0_0_0_1_0; }
		
		//modifiers+=FieldModifier
		public Assignment getModifiersAssignment_2_0_0_0_2() { return cModifiersAssignment_2_0_0_0_2; }
		
		//FieldModifier
		public RuleCall getModifiersFieldModifierParserRuleCall_2_0_0_0_2_0() { return cModifiersFieldModifierParserRuleCall_2_0_0_0_2_0; }
		
		//modifiers+=CommonModifier*
		public Assignment getModifiersAssignment_2_0_0_0_3() { return cModifiersAssignment_2_0_0_0_3; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_0_0_0_3_0() { return cModifiersCommonModifierParserRuleCall_2_0_0_0_3_0; }
		
		//type=JvmTypeReference?
		public Assignment getTypeAssignment_2_0_0_0_4() { return cTypeAssignment_2_0_0_0_4; }
		
		//JvmTypeReference
		public RuleCall getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_4_0() { return cTypeJvmTypeReferenceParserRuleCall_2_0_0_0_4_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_0_0_0_5() { return cNameAssignment_2_0_0_0_5; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_0_0_0_5_0() { return cNameValidIDParserRuleCall_2_0_0_0_5_0; }
		
		//{XtendField.annotationInfo = current} modifiers+=CommonModifier*
		//            type=JvmTypeReference name=ValidID
		public Group getGroup_2_0_0_1() { return cGroup_2_0_0_1; }
		
		//{XtendField.annotationInfo = current}
		public Action getXtendFieldAnnotationInfoAction_2_0_0_1_0() { return cXtendFieldAnnotationInfoAction_2_0_0_1_0; }
		
		//modifiers+=CommonModifier*
		public Assignment getModifiersAssignment_2_0_0_1_1() { return cModifiersAssignment_2_0_0_1_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_0_0_1_1_0() { return cModifiersCommonModifierParserRuleCall_2_0_0_1_1_0; }
		
		//type=JvmTypeReference
		public Assignment getTypeAssignment_2_0_0_1_2() { return cTypeAssignment_2_0_0_1_2; }
		
		//JvmTypeReference
		public RuleCall getTypeJvmTypeReferenceParserRuleCall_2_0_0_1_2_0() { return cTypeJvmTypeReferenceParserRuleCall_2_0_0_1_2_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_0_0_1_3() { return cNameAssignment_2_0_0_1_3; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_0_0_1_3_0() { return cNameValidIDParserRuleCall_2_0_0_1_3_0; }
		
		//('=' initialValue=XAnnotationElementValue)?
		public Group getGroup_2_0_1() { return cGroup_2_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_2_0_1_0() { return cEqualsSignKeyword_2_0_1_0; }
		
		//initialValue=XAnnotationElementValue
		public Assignment getInitialValueAssignment_2_0_1_1() { return cInitialValueAssignment_2_0_1_1; }
		
		//XAnnotationElementValue
		public RuleCall getInitialValueXAnnotationElementValueParserRuleCall_2_0_1_1_0() { return cInitialValueXAnnotationElementValueParserRuleCall_2_0_1_1_0; }
		
		//';'?
		public Keyword getSemicolonKeyword_2_0_2() { return cSemicolonKeyword_2_0_2; }
		
		//(
		//           {XtendClass.annotationInfo = current}
		//           modifiers+=CommonModifier*
		//           'class' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//           ("extends" extends=JvmParameterizedTypeReference)?
		//           ('implements' implements+=JvmParameterizedTypeReference (',' implements+=JvmParameterizedTypeReference)*)?'{'
		//               (members+=Member)*
		//           '}'
		//       )
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//{XtendClass.annotationInfo = current}
		public Action getXtendClassAnnotationInfoAction_2_1_0() { return cXtendClassAnnotationInfoAction_2_1_0; }
		
		//modifiers+=CommonModifier*
		public Assignment getModifiersAssignment_2_1_1() { return cModifiersAssignment_2_1_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_1_1_0() { return cModifiersCommonModifierParserRuleCall_2_1_1_0; }
		
		//'class'
		public Keyword getClassKeyword_2_1_2() { return cClassKeyword_2_1_2; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_1_3() { return cNameAssignment_2_1_3; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_1_3_0() { return cNameValidIDParserRuleCall_2_1_3_0; }
		
		//('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		public Group getGroup_2_1_4() { return cGroup_2_1_4; }
		
		//'<'
		public Keyword getLessThanSignKeyword_2_1_4_0() { return cLessThanSignKeyword_2_1_4_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_1_4_1() { return cTypeParametersAssignment_2_1_4_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0; }
		
		//(',' typeParameters+=JvmTypeParameter)*
		public Group getGroup_2_1_4_2() { return cGroup_2_1_4_2; }
		
		//','
		public Keyword getCommaKeyword_2_1_4_2_0() { return cCommaKeyword_2_1_4_2_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_1_4_2_1() { return cTypeParametersAssignment_2_1_4_2_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_2_1_4_3() { return cGreaterThanSignKeyword_2_1_4_3; }
		
		//("extends" extends=JvmParameterizedTypeReference)?
		public Group getGroup_2_1_5() { return cGroup_2_1_5; }
		
		//"extends"
		public Keyword getExtendsKeyword_2_1_5_0() { return cExtendsKeyword_2_1_5_0; }
		
		//extends=JvmParameterizedTypeReference
		public Assignment getExtendsAssignment_2_1_5_1() { return cExtendsAssignment_2_1_5_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_1_5_1_0() { return cExtendsJvmParameterizedTypeReferenceParserRuleCall_2_1_5_1_0; }
		
		//('implements' implements+=JvmParameterizedTypeReference (',' implements+=JvmParameterizedTypeReference)*)?
		public Group getGroup_2_1_6() { return cGroup_2_1_6; }
		
		//'implements'
		public Keyword getImplementsKeyword_2_1_6_0() { return cImplementsKeyword_2_1_6_0; }
		
		//implements+=JvmParameterizedTypeReference
		public Assignment getImplementsAssignment_2_1_6_1() { return cImplementsAssignment_2_1_6_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getImplementsJvmParameterizedTypeReferenceParserRuleCall_2_1_6_1_0() { return cImplementsJvmParameterizedTypeReferenceParserRuleCall_2_1_6_1_0; }
		
		//(',' implements+=JvmParameterizedTypeReference)*
		public Group getGroup_2_1_6_2() { return cGroup_2_1_6_2; }
		
		//','
		public Keyword getCommaKeyword_2_1_6_2_0() { return cCommaKeyword_2_1_6_2_0; }
		
		//implements+=JvmParameterizedTypeReference
		public Assignment getImplementsAssignment_2_1_6_2_1() { return cImplementsAssignment_2_1_6_2_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getImplementsJvmParameterizedTypeReferenceParserRuleCall_2_1_6_2_1_0() { return cImplementsJvmParameterizedTypeReferenceParserRuleCall_2_1_6_2_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_1_7() { return cLeftCurlyBracketKeyword_2_1_7; }
		
		//(members+=Member)*
		public Assignment getMembersAssignment_2_1_8() { return cMembersAssignment_2_1_8; }
		
		//Member
		public RuleCall getMembersMemberParserRuleCall_2_1_8_0() { return cMembersMemberParserRuleCall_2_1_8_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_2_1_9() { return cRightCurlyBracketKeyword_2_1_9; }
		
		//(
		//           {XtendInterface.annotationInfo = current}
		//           modifiers+=CommonModifier*
		//           'interface' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//           ('extends' extends+=JvmParameterizedTypeReference (',' extends+=JvmParameterizedTypeReference)*)?'{'
		//               (members+=Member)*
		//           '}'
		//       )
		public Group getGroup_2_2() { return cGroup_2_2; }
		
		//{XtendInterface.annotationInfo = current}
		public Action getXtendInterfaceAnnotationInfoAction_2_2_0() { return cXtendInterfaceAnnotationInfoAction_2_2_0; }
		
		//modifiers+=CommonModifier*
		public Assignment getModifiersAssignment_2_2_1() { return cModifiersAssignment_2_2_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_2_1_0() { return cModifiersCommonModifierParserRuleCall_2_2_1_0; }
		
		//'interface'
		public Keyword getInterfaceKeyword_2_2_2() { return cInterfaceKeyword_2_2_2; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_2_3() { return cNameAssignment_2_2_3; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_2_3_0() { return cNameValidIDParserRuleCall_2_2_3_0; }
		
		//('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		public Group getGroup_2_2_4() { return cGroup_2_2_4; }
		
		//'<'
		public Keyword getLessThanSignKeyword_2_2_4_0() { return cLessThanSignKeyword_2_2_4_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_2_4_1() { return cTypeParametersAssignment_2_2_4_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_2_4_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_2_4_1_0; }
		
		//(',' typeParameters+=JvmTypeParameter)*
		public Group getGroup_2_2_4_2() { return cGroup_2_2_4_2; }
		
		//','
		public Keyword getCommaKeyword_2_2_4_2_0() { return cCommaKeyword_2_2_4_2_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_2_4_2_1() { return cTypeParametersAssignment_2_2_4_2_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_2_4_2_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_2_4_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_2_2_4_3() { return cGreaterThanSignKeyword_2_2_4_3; }
		
		//('extends' extends+=JvmParameterizedTypeReference (',' extends+=JvmParameterizedTypeReference)*)?
		public Group getGroup_2_2_5() { return cGroup_2_2_5; }
		
		//'extends'
		public Keyword getExtendsKeyword_2_2_5_0() { return cExtendsKeyword_2_2_5_0; }
		
		//extends+=JvmParameterizedTypeReference
		public Assignment getExtendsAssignment_2_2_5_1() { return cExtendsAssignment_2_2_5_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_2_5_1_0() { return cExtendsJvmParameterizedTypeReferenceParserRuleCall_2_2_5_1_0; }
		
		//(',' extends+=JvmParameterizedTypeReference)*
		public Group getGroup_2_2_5_2() { return cGroup_2_2_5_2; }
		
		//','
		public Keyword getCommaKeyword_2_2_5_2_0() { return cCommaKeyword_2_2_5_2_0; }
		
		//extends+=JvmParameterizedTypeReference
		public Assignment getExtendsAssignment_2_2_5_2_1() { return cExtendsAssignment_2_2_5_2_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_2_5_2_1_0() { return cExtendsJvmParameterizedTypeReferenceParserRuleCall_2_2_5_2_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_2_6() { return cLeftCurlyBracketKeyword_2_2_6; }
		
		//(members+=Member)*
		public Assignment getMembersAssignment_2_2_7() { return cMembersAssignment_2_2_7; }
		
		//Member
		public RuleCall getMembersMemberParserRuleCall_2_2_7_0() { return cMembersMemberParserRuleCall_2_2_7_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_2_2_8() { return cRightCurlyBracketKeyword_2_2_8; }
		
		//(
		//           {XtendEnum.annotationInfo = current}
		//           modifiers+=CommonModifier*
		//           'enum' name=ValidID '{'
		//               (members+=XtendEnumLiteral (',' members+=XtendEnumLiteral)*)? ';'?
		//           '}'
		//       )
		public Group getGroup_2_3() { return cGroup_2_3; }
		
		//{XtendEnum.annotationInfo = current}
		public Action getXtendEnumAnnotationInfoAction_2_3_0() { return cXtendEnumAnnotationInfoAction_2_3_0; }
		
		//modifiers+=CommonModifier*
		public Assignment getModifiersAssignment_2_3_1() { return cModifiersAssignment_2_3_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_3_1_0() { return cModifiersCommonModifierParserRuleCall_2_3_1_0; }
		
		//'enum'
		public Keyword getEnumKeyword_2_3_2() { return cEnumKeyword_2_3_2; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_3_3() { return cNameAssignment_2_3_3; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_3_3_0() { return cNameValidIDParserRuleCall_2_3_3_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_3_4() { return cLeftCurlyBracketKeyword_2_3_4; }
		
		//(members+=XtendEnumLiteral (',' members+=XtendEnumLiteral)*)?
		public Group getGroup_2_3_5() { return cGroup_2_3_5; }
		
		//members+=XtendEnumLiteral
		public Assignment getMembersAssignment_2_3_5_0() { return cMembersAssignment_2_3_5_0; }
		
		//XtendEnumLiteral
		public RuleCall getMembersXtendEnumLiteralParserRuleCall_2_3_5_0_0() { return cMembersXtendEnumLiteralParserRuleCall_2_3_5_0_0; }
		
		//(',' members+=XtendEnumLiteral)*
		public Group getGroup_2_3_5_1() { return cGroup_2_3_5_1; }
		
		//','
		public Keyword getCommaKeyword_2_3_5_1_0() { return cCommaKeyword_2_3_5_1_0; }
		
		//members+=XtendEnumLiteral
		public Assignment getMembersAssignment_2_3_5_1_1() { return cMembersAssignment_2_3_5_1_1; }
		
		//XtendEnumLiteral
		public RuleCall getMembersXtendEnumLiteralParserRuleCall_2_3_5_1_1_0() { return cMembersXtendEnumLiteralParserRuleCall_2_3_5_1_1_0; }
		
		//';'?
		public Keyword getSemicolonKeyword_2_3_6() { return cSemicolonKeyword_2_3_6; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_2_3_7() { return cRightCurlyBracketKeyword_2_3_7; }
		
		//(
		//           {XtendAnnotationType.annotationInfo = current}
		//           modifiers+=CommonModifier*
		//           'annotation' name=ValidID '{'
		//               (members+=AnnotationField)*
		//           '}'
		//       )
		public Group getGroup_2_4() { return cGroup_2_4; }
		
		//{XtendAnnotationType.annotationInfo = current}
		public Action getXtendAnnotationTypeAnnotationInfoAction_2_4_0() { return cXtendAnnotationTypeAnnotationInfoAction_2_4_0; }
		
		//modifiers+=CommonModifier*
		public Assignment getModifiersAssignment_2_4_1() { return cModifiersAssignment_2_4_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_4_1_0() { return cModifiersCommonModifierParserRuleCall_2_4_1_0; }
		
		//'annotation'
		public Keyword getAnnotationKeyword_2_4_2() { return cAnnotationKeyword_2_4_2; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_4_3() { return cNameAssignment_2_4_3; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_4_3_0() { return cNameValidIDParserRuleCall_2_4_3_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_4_4() { return cLeftCurlyBracketKeyword_2_4_4; }
		
		//(members+=AnnotationField)*
		public Assignment getMembersAssignment_2_4_5() { return cMembersAssignment_2_4_5; }
		
		//AnnotationField
		public RuleCall getMembersAnnotationFieldParserRuleCall_2_4_5_0() { return cMembersAnnotationFieldParserRuleCall_2_4_5_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_2_4_6() { return cRightCurlyBracketKeyword_2_4_6; }
	}
	public class MemberElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.Member");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXtendMemberAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cAnnotationsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cAnnotationsXAnnotationParserRuleCall_1_0 = (RuleCall)cAnnotationsAssignment_1.eContents().get(0);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Action cXtendFieldAnnotationInfoAction_2_0_0 = (Action)cGroup_2_0.eContents().get(0);
		private final Assignment cModifiersAssignment_2_0_1 = (Assignment)cGroup_2_0.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_0_1_0 = (RuleCall)cModifiersAssignment_2_0_1.eContents().get(0);
		private final Alternatives cAlternatives_2_0_2 = (Alternatives)cGroup_2_0.eContents().get(2);
		private final Group cGroup_2_0_2_0 = (Group)cAlternatives_2_0_2.eContents().get(0);
		private final Assignment cModifiersAssignment_2_0_2_0_0 = (Assignment)cGroup_2_0_2_0.eContents().get(0);
		private final RuleCall cModifiersFieldModifierParserRuleCall_2_0_2_0_0_0 = (RuleCall)cModifiersAssignment_2_0_2_0_0.eContents().get(0);
		private final Assignment cModifiersAssignment_2_0_2_0_1 = (Assignment)cGroup_2_0_2_0.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_0_2_0_1_0 = (RuleCall)cModifiersAssignment_2_0_2_0_1.eContents().get(0);
		private final Assignment cTypeAssignment_2_0_2_0_2 = (Assignment)cGroup_2_0_2_0.eContents().get(2);
		private final RuleCall cTypeJvmTypeReferenceParserRuleCall_2_0_2_0_2_0 = (RuleCall)cTypeAssignment_2_0_2_0_2.eContents().get(0);
		private final Assignment cNameAssignment_2_0_2_0_3 = (Assignment)cGroup_2_0_2_0.eContents().get(3);
		private final RuleCall cNameValidIDParserRuleCall_2_0_2_0_3_0 = (RuleCall)cNameAssignment_2_0_2_0_3.eContents().get(0);
		private final Group cGroup_2_0_2_1 = (Group)cAlternatives_2_0_2.eContents().get(1);
		private final Assignment cModifiersAssignment_2_0_2_1_0 = (Assignment)cGroup_2_0_2_1.eContents().get(0);
		private final Keyword cModifiersExtensionKeyword_2_0_2_1_0_0 = (Keyword)cModifiersAssignment_2_0_2_1_0.eContents().get(0);
		private final Alternatives cAlternatives_2_0_2_1_1 = (Alternatives)cGroup_2_0_2_1.eContents().get(1);
		private final Assignment cModifiersAssignment_2_0_2_1_1_0 = (Assignment)cAlternatives_2_0_2_1_1.eContents().get(0);
		private final RuleCall cModifiersFieldModifierParserRuleCall_2_0_2_1_1_0_0 = (RuleCall)cModifiersAssignment_2_0_2_1_1_0.eContents().get(0);
		private final Assignment cModifiersAssignment_2_0_2_1_1_1 = (Assignment)cAlternatives_2_0_2_1_1.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_0_2_1_1_1_0 = (RuleCall)cModifiersAssignment_2_0_2_1_1_1.eContents().get(0);
		private final Assignment cTypeAssignment_2_0_2_1_2 = (Assignment)cGroup_2_0_2_1.eContents().get(2);
		private final RuleCall cTypeJvmTypeReferenceParserRuleCall_2_0_2_1_2_0 = (RuleCall)cTypeAssignment_2_0_2_1_2.eContents().get(0);
		private final Assignment cNameAssignment_2_0_2_1_3 = (Assignment)cGroup_2_0_2_1.eContents().get(3);
		private final RuleCall cNameValidIDParserRuleCall_2_0_2_1_3_0 = (RuleCall)cNameAssignment_2_0_2_1_3.eContents().get(0);
		private final Group cGroup_2_0_2_2 = (Group)cAlternatives_2_0_2.eContents().get(2);
		private final Assignment cModifiersAssignment_2_0_2_2_0 = (Assignment)cGroup_2_0_2_2.eContents().get(0);
		private final RuleCall cModifiersFieldModifierParserRuleCall_2_0_2_2_0_0 = (RuleCall)cModifiersAssignment_2_0_2_2_0.eContents().get(0);
		private final Assignment cModifiersAssignment_2_0_2_2_1 = (Assignment)cGroup_2_0_2_2.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_0_2_2_1_0 = (RuleCall)cModifiersAssignment_2_0_2_2_1.eContents().get(0);
		private final Assignment cModifiersAssignment_2_0_2_2_2 = (Assignment)cGroup_2_0_2_2.eContents().get(2);
		private final Keyword cModifiersExtensionKeyword_2_0_2_2_2_0 = (Keyword)cModifiersAssignment_2_0_2_2_2.eContents().get(0);
		private final Assignment cModifiersAssignment_2_0_2_2_3 = (Assignment)cGroup_2_0_2_2.eContents().get(3);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_0_2_2_3_0 = (RuleCall)cModifiersAssignment_2_0_2_2_3.eContents().get(0);
		private final Assignment cTypeAssignment_2_0_2_2_4 = (Assignment)cGroup_2_0_2_2.eContents().get(4);
		private final RuleCall cTypeJvmTypeReferenceParserRuleCall_2_0_2_2_4_0 = (RuleCall)cTypeAssignment_2_0_2_2_4.eContents().get(0);
		private final Assignment cNameAssignment_2_0_2_2_5 = (Assignment)cGroup_2_0_2_2.eContents().get(5);
		private final RuleCall cNameValidIDParserRuleCall_2_0_2_2_5_0 = (RuleCall)cNameAssignment_2_0_2_2_5.eContents().get(0);
		private final Group cGroup_2_0_2_3 = (Group)cAlternatives_2_0_2.eContents().get(3);
		private final Assignment cTypeAssignment_2_0_2_3_0 = (Assignment)cGroup_2_0_2_3.eContents().get(0);
		private final RuleCall cTypeJvmTypeReferenceParserRuleCall_2_0_2_3_0_0 = (RuleCall)cTypeAssignment_2_0_2_3_0.eContents().get(0);
		private final Assignment cNameAssignment_2_0_2_3_1 = (Assignment)cGroup_2_0_2_3.eContents().get(1);
		private final RuleCall cNameValidIDParserRuleCall_2_0_2_3_1_0 = (RuleCall)cNameAssignment_2_0_2_3_1.eContents().get(0);
		private final Group cGroup_2_0_3 = (Group)cGroup_2_0.eContents().get(3);
		private final Keyword cEqualsSignKeyword_2_0_3_0 = (Keyword)cGroup_2_0_3.eContents().get(0);
		private final Assignment cInitialValueAssignment_2_0_3_1 = (Assignment)cGroup_2_0_3.eContents().get(1);
		private final RuleCall cInitialValueXExpressionParserRuleCall_2_0_3_1_0 = (RuleCall)cInitialValueAssignment_2_0_3_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_2_0_4 = (Keyword)cGroup_2_0.eContents().get(4);
		private final Group cGroup_2_1 = (Group)cAlternatives_2.eContents().get(1);
		private final Action cXtendFunctionAnnotationInfoAction_2_1_0 = (Action)cGroup_2_1.eContents().get(0);
		private final Assignment cModifiersAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_1_1_0 = (RuleCall)cModifiersAssignment_2_1_1.eContents().get(0);
		private final Assignment cModifiersAssignment_2_1_2 = (Assignment)cGroup_2_1.eContents().get(2);
		private final RuleCall cModifiersMethodModifierParserRuleCall_2_1_2_0 = (RuleCall)cModifiersAssignment_2_1_2.eContents().get(0);
		private final Alternatives cAlternatives_2_1_3 = (Alternatives)cGroup_2_1.eContents().get(3);
		private final Assignment cModifiersAssignment_2_1_3_0 = (Assignment)cAlternatives_2_1_3.eContents().get(0);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_1_3_0_0 = (RuleCall)cModifiersAssignment_2_1_3_0.eContents().get(0);
		private final Assignment cModifiersAssignment_2_1_3_1 = (Assignment)cAlternatives_2_1_3.eContents().get(1);
		private final RuleCall cModifiersMethodModifierParserRuleCall_2_1_3_1_0 = (RuleCall)cModifiersAssignment_2_1_3_1.eContents().get(0);
		private final Group cGroup_2_1_4 = (Group)cGroup_2_1.eContents().get(4);
		private final Keyword cLessThanSignKeyword_2_1_4_0 = (Keyword)cGroup_2_1_4.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_1_4_1 = (Assignment)cGroup_2_1_4.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0 = (RuleCall)cTypeParametersAssignment_2_1_4_1.eContents().get(0);
		private final Group cGroup_2_1_4_2 = (Group)cGroup_2_1_4.eContents().get(2);
		private final Keyword cCommaKeyword_2_1_4_2_0 = (Keyword)cGroup_2_1_4_2.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_1_4_2_1 = (Assignment)cGroup_2_1_4_2.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0 = (RuleCall)cTypeParametersAssignment_2_1_4_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_2_1_4_3 = (Keyword)cGroup_2_1_4.eContents().get(3);
		private final Alternatives cAlternatives_2_1_5 = (Alternatives)cGroup_2_1.eContents().get(5);
		private final Group cGroup_2_1_5_0 = (Group)cAlternatives_2_1_5.eContents().get(0);
		private final Group cGroup_2_1_5_0_0 = (Group)cGroup_2_1_5_0.eContents().get(0);
		private final Assignment cReturnTypeAssignment_2_1_5_0_0_0 = (Assignment)cGroup_2_1_5_0_0.eContents().get(0);
		private final RuleCall cReturnTypeJvmTypeReferenceParserRuleCall_2_1_5_0_0_0_0 = (RuleCall)cReturnTypeAssignment_2_1_5_0_0_0.eContents().get(0);
		private final Assignment cCreateExtensionInfoAssignment_2_1_5_0_0_1 = (Assignment)cGroup_2_1_5_0_0.eContents().get(1);
		private final RuleCall cCreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_0_0_1_0 = (RuleCall)cCreateExtensionInfoAssignment_2_1_5_0_0_1.eContents().get(0);
		private final Assignment cNameAssignment_2_1_5_0_0_2 = (Assignment)cGroup_2_1_5_0_0.eContents().get(2);
		private final RuleCall cNameValidIDParserRuleCall_2_1_5_0_0_2_0 = (RuleCall)cNameAssignment_2_1_5_0_0_2.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2_1_5_0_0_3 = (Keyword)cGroup_2_1_5_0_0.eContents().get(3);
		private final Group cGroup_2_1_5_1 = (Group)cAlternatives_2_1_5.eContents().get(1);
		private final Group cGroup_2_1_5_1_0 = (Group)cGroup_2_1_5_1.eContents().get(0);
		private final Assignment cReturnTypeAssignment_2_1_5_1_0_0 = (Assignment)cGroup_2_1_5_1_0.eContents().get(0);
		private final RuleCall cReturnTypeTypeReferenceWithTypeArgsParserRuleCall_2_1_5_1_0_0_0 = (RuleCall)cReturnTypeAssignment_2_1_5_1_0_0.eContents().get(0);
		private final Assignment cNameAssignment_2_1_5_1_0_1 = (Assignment)cGroup_2_1_5_1_0.eContents().get(1);
		private final RuleCall cNameFunctionIDParserRuleCall_2_1_5_1_0_1_0 = (RuleCall)cNameAssignment_2_1_5_1_0_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2_1_5_1_0_2 = (Keyword)cGroup_2_1_5_1_0.eContents().get(2);
		private final Group cGroup_2_1_5_2 = (Group)cAlternatives_2_1_5.eContents().get(2);
		private final Group cGroup_2_1_5_2_0 = (Group)cGroup_2_1_5_2.eContents().get(0);
		private final Assignment cReturnTypeAssignment_2_1_5_2_0_0 = (Assignment)cGroup_2_1_5_2_0.eContents().get(0);
		private final RuleCall cReturnTypeTypeReferenceNoTypeArgsParserRuleCall_2_1_5_2_0_0_0 = (RuleCall)cReturnTypeAssignment_2_1_5_2_0_0.eContents().get(0);
		private final Assignment cNameAssignment_2_1_5_2_0_1 = (Assignment)cGroup_2_1_5_2_0.eContents().get(1);
		private final RuleCall cNameFunctionIDParserRuleCall_2_1_5_2_0_1_0 = (RuleCall)cNameAssignment_2_1_5_2_0_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2_1_5_2_0_2 = (Keyword)cGroup_2_1_5_2_0.eContents().get(2);
		private final Group cGroup_2_1_5_3 = (Group)cAlternatives_2_1_5.eContents().get(3);
		private final Group cGroup_2_1_5_3_0 = (Group)cGroup_2_1_5_3.eContents().get(0);
		private final Assignment cCreateExtensionInfoAssignment_2_1_5_3_0_0 = (Assignment)cGroup_2_1_5_3_0.eContents().get(0);
		private final RuleCall cCreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_3_0_0_0 = (RuleCall)cCreateExtensionInfoAssignment_2_1_5_3_0_0.eContents().get(0);
		private final Assignment cNameAssignment_2_1_5_3_0_1 = (Assignment)cGroup_2_1_5_3_0.eContents().get(1);
		private final RuleCall cNameValidIDParserRuleCall_2_1_5_3_0_1_0 = (RuleCall)cNameAssignment_2_1_5_3_0_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2_1_5_3_0_2 = (Keyword)cGroup_2_1_5_3_0.eContents().get(2);
		private final Group cGroup_2_1_5_4 = (Group)cAlternatives_2_1_5.eContents().get(4);
		private final Assignment cNameAssignment_2_1_5_4_0 = (Assignment)cGroup_2_1_5_4.eContents().get(0);
		private final RuleCall cNameFunctionIDParserRuleCall_2_1_5_4_0_0 = (RuleCall)cNameAssignment_2_1_5_4_0.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2_1_5_4_1 = (Keyword)cGroup_2_1_5_4.eContents().get(1);
		private final Group cGroup_2_1_6 = (Group)cGroup_2_1.eContents().get(6);
		private final Assignment cParametersAssignment_2_1_6_0 = (Assignment)cGroup_2_1_6.eContents().get(0);
		private final RuleCall cParametersParameterParserRuleCall_2_1_6_0_0 = (RuleCall)cParametersAssignment_2_1_6_0.eContents().get(0);
		private final Group cGroup_2_1_6_1 = (Group)cGroup_2_1_6.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_6_1_0 = (Keyword)cGroup_2_1_6_1.eContents().get(0);
		private final Assignment cParametersAssignment_2_1_6_1_1 = (Assignment)cGroup_2_1_6_1.eContents().get(1);
		private final RuleCall cParametersParameterParserRuleCall_2_1_6_1_1_0 = (RuleCall)cParametersAssignment_2_1_6_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2_1_7 = (Keyword)cGroup_2_1.eContents().get(7);
		private final Group cGroup_2_1_8 = (Group)cGroup_2_1.eContents().get(8);
		private final Keyword cThrowsKeyword_2_1_8_0 = (Keyword)cGroup_2_1_8.eContents().get(0);
		private final Assignment cExceptionsAssignment_2_1_8_1 = (Assignment)cGroup_2_1_8.eContents().get(1);
		private final RuleCall cExceptionsJvmTypeReferenceParserRuleCall_2_1_8_1_0 = (RuleCall)cExceptionsAssignment_2_1_8_1.eContents().get(0);
		private final Group cGroup_2_1_8_2 = (Group)cGroup_2_1_8.eContents().get(2);
		private final Keyword cCommaKeyword_2_1_8_2_0 = (Keyword)cGroup_2_1_8_2.eContents().get(0);
		private final Assignment cExceptionsAssignment_2_1_8_2_1 = (Assignment)cGroup_2_1_8_2.eContents().get(1);
		private final RuleCall cExceptionsJvmTypeReferenceParserRuleCall_2_1_8_2_1_0 = (RuleCall)cExceptionsAssignment_2_1_8_2_1.eContents().get(0);
		private final Alternatives cAlternatives_2_1_9 = (Alternatives)cGroup_2_1.eContents().get(9);
		private final Assignment cExpressionAssignment_2_1_9_0 = (Assignment)cAlternatives_2_1_9.eContents().get(0);
		private final RuleCall cExpressionXBlockExpressionParserRuleCall_2_1_9_0_0 = (RuleCall)cExpressionAssignment_2_1_9_0.eContents().get(0);
		private final Assignment cExpressionAssignment_2_1_9_1 = (Assignment)cAlternatives_2_1_9.eContents().get(1);
		private final RuleCall cExpressionRichStringParserRuleCall_2_1_9_1_0 = (RuleCall)cExpressionAssignment_2_1_9_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_2_1_9_2 = (Keyword)cAlternatives_2_1_9.eContents().get(2);
		private final Group cGroup_2_2 = (Group)cAlternatives_2.eContents().get(2);
		private final Action cXtendConstructorAnnotationInfoAction_2_2_0 = (Action)cGroup_2_2.eContents().get(0);
		private final Assignment cModifiersAssignment_2_2_1 = (Assignment)cGroup_2_2.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_2_1_0 = (RuleCall)cModifiersAssignment_2_2_1.eContents().get(0);
		private final Keyword cNewKeyword_2_2_2 = (Keyword)cGroup_2_2.eContents().get(2);
		private final Group cGroup_2_2_3 = (Group)cGroup_2_2.eContents().get(3);
		private final Keyword cLessThanSignKeyword_2_2_3_0 = (Keyword)cGroup_2_2_3.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_2_3_1 = (Assignment)cGroup_2_2_3.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_2_3_1_0 = (RuleCall)cTypeParametersAssignment_2_2_3_1.eContents().get(0);
		private final Group cGroup_2_2_3_2 = (Group)cGroup_2_2_3.eContents().get(2);
		private final Keyword cCommaKeyword_2_2_3_2_0 = (Keyword)cGroup_2_2_3_2.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_2_3_2_1 = (Assignment)cGroup_2_2_3_2.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_2_3_2_1_0 = (RuleCall)cTypeParametersAssignment_2_2_3_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_2_2_3_3 = (Keyword)cGroup_2_2_3.eContents().get(3);
		private final Keyword cLeftParenthesisKeyword_2_2_4 = (Keyword)cGroup_2_2.eContents().get(4);
		private final Group cGroup_2_2_5 = (Group)cGroup_2_2.eContents().get(5);
		private final Assignment cParametersAssignment_2_2_5_0 = (Assignment)cGroup_2_2_5.eContents().get(0);
		private final RuleCall cParametersParameterParserRuleCall_2_2_5_0_0 = (RuleCall)cParametersAssignment_2_2_5_0.eContents().get(0);
		private final Group cGroup_2_2_5_1 = (Group)cGroup_2_2_5.eContents().get(1);
		private final Keyword cCommaKeyword_2_2_5_1_0 = (Keyword)cGroup_2_2_5_1.eContents().get(0);
		private final Assignment cParametersAssignment_2_2_5_1_1 = (Assignment)cGroup_2_2_5_1.eContents().get(1);
		private final RuleCall cParametersParameterParserRuleCall_2_2_5_1_1_0 = (RuleCall)cParametersAssignment_2_2_5_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2_2_6 = (Keyword)cGroup_2_2.eContents().get(6);
		private final Group cGroup_2_2_7 = (Group)cGroup_2_2.eContents().get(7);
		private final Keyword cThrowsKeyword_2_2_7_0 = (Keyword)cGroup_2_2_7.eContents().get(0);
		private final Assignment cExceptionsAssignment_2_2_7_1 = (Assignment)cGroup_2_2_7.eContents().get(1);
		private final RuleCall cExceptionsJvmTypeReferenceParserRuleCall_2_2_7_1_0 = (RuleCall)cExceptionsAssignment_2_2_7_1.eContents().get(0);
		private final Group cGroup_2_2_7_2 = (Group)cGroup_2_2_7.eContents().get(2);
		private final Keyword cCommaKeyword_2_2_7_2_0 = (Keyword)cGroup_2_2_7_2.eContents().get(0);
		private final Assignment cExceptionsAssignment_2_2_7_2_1 = (Assignment)cGroup_2_2_7_2.eContents().get(1);
		private final RuleCall cExceptionsJvmTypeReferenceParserRuleCall_2_2_7_2_1_0 = (RuleCall)cExceptionsAssignment_2_2_7_2_1.eContents().get(0);
		private final Assignment cExpressionAssignment_2_2_8 = (Assignment)cGroup_2_2.eContents().get(8);
		private final RuleCall cExpressionXBlockExpressionParserRuleCall_2_2_8_0 = (RuleCall)cExpressionAssignment_2_2_8.eContents().get(0);
		private final Group cGroup_2_3 = (Group)cAlternatives_2.eContents().get(3);
		private final Action cXtendClassAnnotationInfoAction_2_3_0 = (Action)cGroup_2_3.eContents().get(0);
		private final Assignment cModifiersAssignment_2_3_1 = (Assignment)cGroup_2_3.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_3_1_0 = (RuleCall)cModifiersAssignment_2_3_1.eContents().get(0);
		private final Keyword cClassKeyword_2_3_2 = (Keyword)cGroup_2_3.eContents().get(2);
		private final Assignment cNameAssignment_2_3_3 = (Assignment)cGroup_2_3.eContents().get(3);
		private final RuleCall cNameValidIDParserRuleCall_2_3_3_0 = (RuleCall)cNameAssignment_2_3_3.eContents().get(0);
		private final Group cGroup_2_3_4 = (Group)cGroup_2_3.eContents().get(4);
		private final Keyword cLessThanSignKeyword_2_3_4_0 = (Keyword)cGroup_2_3_4.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_3_4_1 = (Assignment)cGroup_2_3_4.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_3_4_1_0 = (RuleCall)cTypeParametersAssignment_2_3_4_1.eContents().get(0);
		private final Group cGroup_2_3_4_2 = (Group)cGroup_2_3_4.eContents().get(2);
		private final Keyword cCommaKeyword_2_3_4_2_0 = (Keyword)cGroup_2_3_4_2.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_3_4_2_1 = (Assignment)cGroup_2_3_4_2.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_3_4_2_1_0 = (RuleCall)cTypeParametersAssignment_2_3_4_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_2_3_4_3 = (Keyword)cGroup_2_3_4.eContents().get(3);
		private final Group cGroup_2_3_5 = (Group)cGroup_2_3.eContents().get(5);
		private final Keyword cExtendsKeyword_2_3_5_0 = (Keyword)cGroup_2_3_5.eContents().get(0);
		private final Assignment cExtendsAssignment_2_3_5_1 = (Assignment)cGroup_2_3_5.eContents().get(1);
		private final RuleCall cExtendsJvmParameterizedTypeReferenceParserRuleCall_2_3_5_1_0 = (RuleCall)cExtendsAssignment_2_3_5_1.eContents().get(0);
		private final Group cGroup_2_3_6 = (Group)cGroup_2_3.eContents().get(6);
		private final Keyword cImplementsKeyword_2_3_6_0 = (Keyword)cGroup_2_3_6.eContents().get(0);
		private final Assignment cImplementsAssignment_2_3_6_1 = (Assignment)cGroup_2_3_6.eContents().get(1);
		private final RuleCall cImplementsJvmParameterizedTypeReferenceParserRuleCall_2_3_6_1_0 = (RuleCall)cImplementsAssignment_2_3_6_1.eContents().get(0);
		private final Group cGroup_2_3_6_2 = (Group)cGroup_2_3_6.eContents().get(2);
		private final Keyword cCommaKeyword_2_3_6_2_0 = (Keyword)cGroup_2_3_6_2.eContents().get(0);
		private final Assignment cImplementsAssignment_2_3_6_2_1 = (Assignment)cGroup_2_3_6_2.eContents().get(1);
		private final RuleCall cImplementsJvmParameterizedTypeReferenceParserRuleCall_2_3_6_2_1_0 = (RuleCall)cImplementsAssignment_2_3_6_2_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2_3_7 = (Keyword)cGroup_2_3.eContents().get(7);
		private final Assignment cMembersAssignment_2_3_8 = (Assignment)cGroup_2_3.eContents().get(8);
		private final RuleCall cMembersMemberParserRuleCall_2_3_8_0 = (RuleCall)cMembersAssignment_2_3_8.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2_3_9 = (Keyword)cGroup_2_3.eContents().get(9);
		private final Group cGroup_2_4 = (Group)cAlternatives_2.eContents().get(4);
		private final Action cXtendInterfaceAnnotationInfoAction_2_4_0 = (Action)cGroup_2_4.eContents().get(0);
		private final Assignment cModifiersAssignment_2_4_1 = (Assignment)cGroup_2_4.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_4_1_0 = (RuleCall)cModifiersAssignment_2_4_1.eContents().get(0);
		private final Keyword cInterfaceKeyword_2_4_2 = (Keyword)cGroup_2_4.eContents().get(2);
		private final Assignment cNameAssignment_2_4_3 = (Assignment)cGroup_2_4.eContents().get(3);
		private final RuleCall cNameValidIDParserRuleCall_2_4_3_0 = (RuleCall)cNameAssignment_2_4_3.eContents().get(0);
		private final Group cGroup_2_4_4 = (Group)cGroup_2_4.eContents().get(4);
		private final Keyword cLessThanSignKeyword_2_4_4_0 = (Keyword)cGroup_2_4_4.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_4_4_1 = (Assignment)cGroup_2_4_4.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_4_4_1_0 = (RuleCall)cTypeParametersAssignment_2_4_4_1.eContents().get(0);
		private final Group cGroup_2_4_4_2 = (Group)cGroup_2_4_4.eContents().get(2);
		private final Keyword cCommaKeyword_2_4_4_2_0 = (Keyword)cGroup_2_4_4_2.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_4_4_2_1 = (Assignment)cGroup_2_4_4_2.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_4_4_2_1_0 = (RuleCall)cTypeParametersAssignment_2_4_4_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_2_4_4_3 = (Keyword)cGroup_2_4_4.eContents().get(3);
		private final Group cGroup_2_4_5 = (Group)cGroup_2_4.eContents().get(5);
		private final Keyword cExtendsKeyword_2_4_5_0 = (Keyword)cGroup_2_4_5.eContents().get(0);
		private final Assignment cExtendsAssignment_2_4_5_1 = (Assignment)cGroup_2_4_5.eContents().get(1);
		private final RuleCall cExtendsJvmParameterizedTypeReferenceParserRuleCall_2_4_5_1_0 = (RuleCall)cExtendsAssignment_2_4_5_1.eContents().get(0);
		private final Group cGroup_2_4_5_2 = (Group)cGroup_2_4_5.eContents().get(2);
		private final Keyword cCommaKeyword_2_4_5_2_0 = (Keyword)cGroup_2_4_5_2.eContents().get(0);
		private final Assignment cExtendsAssignment_2_4_5_2_1 = (Assignment)cGroup_2_4_5_2.eContents().get(1);
		private final RuleCall cExtendsJvmParameterizedTypeReferenceParserRuleCall_2_4_5_2_1_0 = (RuleCall)cExtendsAssignment_2_4_5_2_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2_4_6 = (Keyword)cGroup_2_4.eContents().get(6);
		private final Assignment cMembersAssignment_2_4_7 = (Assignment)cGroup_2_4.eContents().get(7);
		private final RuleCall cMembersMemberParserRuleCall_2_4_7_0 = (RuleCall)cMembersAssignment_2_4_7.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2_4_8 = (Keyword)cGroup_2_4.eContents().get(8);
		private final Group cGroup_2_5 = (Group)cAlternatives_2.eContents().get(5);
		private final Action cXtendEnumAnnotationInfoAction_2_5_0 = (Action)cGroup_2_5.eContents().get(0);
		private final Assignment cModifiersAssignment_2_5_1 = (Assignment)cGroup_2_5.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_5_1_0 = (RuleCall)cModifiersAssignment_2_5_1.eContents().get(0);
		private final Keyword cEnumKeyword_2_5_2 = (Keyword)cGroup_2_5.eContents().get(2);
		private final Assignment cNameAssignment_2_5_3 = (Assignment)cGroup_2_5.eContents().get(3);
		private final RuleCall cNameValidIDParserRuleCall_2_5_3_0 = (RuleCall)cNameAssignment_2_5_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2_5_4 = (Keyword)cGroup_2_5.eContents().get(4);
		private final Group cGroup_2_5_5 = (Group)cGroup_2_5.eContents().get(5);
		private final Assignment cMembersAssignment_2_5_5_0 = (Assignment)cGroup_2_5_5.eContents().get(0);
		private final RuleCall cMembersXtendEnumLiteralParserRuleCall_2_5_5_0_0 = (RuleCall)cMembersAssignment_2_5_5_0.eContents().get(0);
		private final Group cGroup_2_5_5_1 = (Group)cGroup_2_5_5.eContents().get(1);
		private final Keyword cCommaKeyword_2_5_5_1_0 = (Keyword)cGroup_2_5_5_1.eContents().get(0);
		private final Assignment cMembersAssignment_2_5_5_1_1 = (Assignment)cGroup_2_5_5_1.eContents().get(1);
		private final RuleCall cMembersXtendEnumLiteralParserRuleCall_2_5_5_1_1_0 = (RuleCall)cMembersAssignment_2_5_5_1_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_2_5_6 = (Keyword)cGroup_2_5.eContents().get(6);
		private final Keyword cRightCurlyBracketKeyword_2_5_7 = (Keyword)cGroup_2_5.eContents().get(7);
		private final Group cGroup_2_6 = (Group)cAlternatives_2.eContents().get(6);
		private final Action cXtendAnnotationTypeAnnotationInfoAction_2_6_0 = (Action)cGroup_2_6.eContents().get(0);
		private final Assignment cModifiersAssignment_2_6_1 = (Assignment)cGroup_2_6.eContents().get(1);
		private final RuleCall cModifiersCommonModifierParserRuleCall_2_6_1_0 = (RuleCall)cModifiersAssignment_2_6_1.eContents().get(0);
		private final Keyword cAnnotationKeyword_2_6_2 = (Keyword)cGroup_2_6.eContents().get(2);
		private final Assignment cNameAssignment_2_6_3 = (Assignment)cGroup_2_6.eContents().get(3);
		private final RuleCall cNameValidIDParserRuleCall_2_6_3_0 = (RuleCall)cNameAssignment_2_6_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2_6_4 = (Keyword)cGroup_2_6.eContents().get(4);
		private final Assignment cMembersAssignment_2_6_5 = (Assignment)cGroup_2_6.eContents().get(5);
		private final RuleCall cMembersAnnotationFieldParserRuleCall_2_6_5_0 = (RuleCall)cMembersAssignment_2_6_5.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2_6_6 = (Keyword)cGroup_2_6.eContents().get(6);
		
		//Member returns XtendMember:
		//    {XtendMember} annotations+=XAnnotation*
		//    (
		//        (
		//            {XtendField.annotationInfo = current} modifiers+=CommonModifier*
		//            (
		//                modifiers+=FieldModifier modifiers+=CommonModifier*
		//                type=JvmTypeReference? name=ValidID
		//            |
		//                modifiers+='extension' (modifiers+=FieldModifier | modifiers+=CommonModifier)*
		//                type=JvmTypeReference name=ValidID?
		//            |
		//                modifiers+=FieldModifier (modifiers+=CommonModifier)* modifiers+='extension' (modifiers+=CommonModifier)*
		//                type=JvmTypeReference name=ValidID?
		//            |
		//                type=JvmTypeReference name=ValidID
		//            ) ('=' initialValue=XExpression)? ';'?
		//        ) | (
		//            {XtendFunction.annotationInfo = current} modifiers+=CommonModifier*
		//            modifiers+=MethodModifier (modifiers+=CommonModifier | modifiers+=MethodModifier)*
		//            ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//            (
		//                =>(returnType=JvmTypeReference createExtensionInfo=CreateExtensionInfo name=ValidID '(')
		//              | =>(returnType=TypeReferenceWithTypeArgs name=FunctionID '(')
		//              | =>(returnType=TypeReferenceNoTypeArgs name=FunctionID '(')
		//              | =>(createExtensionInfo=CreateExtensionInfo name=ValidID '(')
		//              | name=FunctionID '('
		//            )
		//            (parameters+=Parameter (',' parameters+=Parameter)*)? ')'
		//            ('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
		//            (expression=XBlockExpression | expression=RichString | ';')?
		//        ) | (
		//            {XtendConstructor.annotationInfo = current} modifiers+=CommonModifier*
		//            'new'
		//            ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//            '(' (parameters+=Parameter (',' parameters+=Parameter)*)? ')'
		//            ('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
		//            expression=XBlockExpression
		//        ) | (
		//            {XtendClass.annotationInfo = current}
		//            modifiers+=CommonModifier*
		//            'class' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//            ("extends" extends=JvmParameterizedTypeReference)?
		//            ('implements' implements+=JvmParameterizedTypeReference (',' implements+=JvmParameterizedTypeReference)*)?'{'
		//                (members+=Member)*
		//            '}'
		//        ) | (
		//            {XtendInterface.annotationInfo = current}
		//            modifiers+=CommonModifier*
		//            'interface' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//            ('extends' extends+=JvmParameterizedTypeReference (',' extends+=JvmParameterizedTypeReference)*)?'{'
		//                (members+=Member)*
		//            '}'
		//        ) | (
		//            {XtendEnum.annotationInfo = current}
		//            modifiers+=CommonModifier*
		//            'enum' name=ValidID '{'
		//                (members+=XtendEnumLiteral (',' members+=XtendEnumLiteral)*)? ';'?
		//            '}'
		//        ) | (
		//            {XtendAnnotationType.annotationInfo = current}
		//            modifiers+=CommonModifier*
		//            'annotation' name=ValidID '{'
		//                (members+=AnnotationField)*
		//            '}'
		//        )
		//    )
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{XtendMember} annotations+=XAnnotation*
		//(
		//    (
		//        {XtendField.annotationInfo = current} modifiers+=CommonModifier*
		//        (
		//            modifiers+=FieldModifier modifiers+=CommonModifier*
		//            type=JvmTypeReference? name=ValidID
		//        |
		//            modifiers+='extension' (modifiers+=FieldModifier | modifiers+=CommonModifier)*
		//            type=JvmTypeReference name=ValidID?
		//        |
		//            modifiers+=FieldModifier (modifiers+=CommonModifier)* modifiers+='extension' (modifiers+=CommonModifier)*
		//            type=JvmTypeReference name=ValidID?
		//        |
		//            type=JvmTypeReference name=ValidID
		//        ) ('=' initialValue=XExpression)? ';'?
		//    ) | (
		//        {XtendFunction.annotationInfo = current} modifiers+=CommonModifier*
		//        modifiers+=MethodModifier (modifiers+=CommonModifier | modifiers+=MethodModifier)*
		//        ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//        (
		//            =>(returnType=JvmTypeReference createExtensionInfo=CreateExtensionInfo name=ValidID '(')
		//          | =>(returnType=TypeReferenceWithTypeArgs name=FunctionID '(')
		//          | =>(returnType=TypeReferenceNoTypeArgs name=FunctionID '(')
		//          | =>(createExtensionInfo=CreateExtensionInfo name=ValidID '(')
		//          | name=FunctionID '('
		//        )
		//        (parameters+=Parameter (',' parameters+=Parameter)*)? ')'
		//        ('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
		//        (expression=XBlockExpression | expression=RichString | ';')?
		//    ) | (
		//        {XtendConstructor.annotationInfo = current} modifiers+=CommonModifier*
		//        'new'
		//        ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//        '(' (parameters+=Parameter (',' parameters+=Parameter)*)? ')'
		//        ('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
		//        expression=XBlockExpression
		//    ) | (
		//        {XtendClass.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'class' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//        ("extends" extends=JvmParameterizedTypeReference)?
		//        ('implements' implements+=JvmParameterizedTypeReference (',' implements+=JvmParameterizedTypeReference)*)?'{'
		//            (members+=Member)*
		//        '}'
		//    ) | (
		//        {XtendInterface.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'interface' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//        ('extends' extends+=JvmParameterizedTypeReference (',' extends+=JvmParameterizedTypeReference)*)?'{'
		//            (members+=Member)*
		//        '}'
		//    ) | (
		//        {XtendEnum.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'enum' name=ValidID '{'
		//            (members+=XtendEnumLiteral (',' members+=XtendEnumLiteral)*)? ';'?
		//        '}'
		//    ) | (
		//        {XtendAnnotationType.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'annotation' name=ValidID '{'
		//            (members+=AnnotationField)*
		//        '}'
		//    )
		//)
		public Group getGroup() { return cGroup; }
		
		//{XtendMember}
		public Action getXtendMemberAction_0() { return cXtendMemberAction_0; }
		
		//annotations+=XAnnotation*
		public Assignment getAnnotationsAssignment_1() { return cAnnotationsAssignment_1; }
		
		//XAnnotation
		public RuleCall getAnnotationsXAnnotationParserRuleCall_1_0() { return cAnnotationsXAnnotationParserRuleCall_1_0; }
		
		//(
		//    (
		//        {XtendField.annotationInfo = current} modifiers+=CommonModifier*
		//        (
		//            modifiers+=FieldModifier modifiers+=CommonModifier*
		//            type=JvmTypeReference? name=ValidID
		//        |
		//            modifiers+='extension' (modifiers+=FieldModifier | modifiers+=CommonModifier)*
		//            type=JvmTypeReference name=ValidID?
		//        |
		//            modifiers+=FieldModifier (modifiers+=CommonModifier)* modifiers+='extension' (modifiers+=CommonModifier)*
		//            type=JvmTypeReference name=ValidID?
		//        |
		//            type=JvmTypeReference name=ValidID
		//        ) ('=' initialValue=XExpression)? ';'?
		//    ) | (
		//        {XtendFunction.annotationInfo = current} modifiers+=CommonModifier*
		//        modifiers+=MethodModifier (modifiers+=CommonModifier | modifiers+=MethodModifier)*
		//        ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//        (
		//            =>(returnType=JvmTypeReference createExtensionInfo=CreateExtensionInfo name=ValidID '(')
		//          | =>(returnType=TypeReferenceWithTypeArgs name=FunctionID '(')
		//          | =>(returnType=TypeReferenceNoTypeArgs name=FunctionID '(')
		//          | =>(createExtensionInfo=CreateExtensionInfo name=ValidID '(')
		//          | name=FunctionID '('
		//        )
		//        (parameters+=Parameter (',' parameters+=Parameter)*)? ')'
		//        ('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
		//        (expression=XBlockExpression | expression=RichString | ';')?
		//    ) | (
		//        {XtendConstructor.annotationInfo = current} modifiers+=CommonModifier*
		//        'new'
		//        ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//        '(' (parameters+=Parameter (',' parameters+=Parameter)*)? ')'
		//        ('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
		//        expression=XBlockExpression
		//    ) | (
		//        {XtendClass.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'class' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//        ("extends" extends=JvmParameterizedTypeReference)?
		//        ('implements' implements+=JvmParameterizedTypeReference (',' implements+=JvmParameterizedTypeReference)*)?'{'
		//            (members+=Member)*
		//        '}'
		//    ) | (
		//        {XtendInterface.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'interface' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//        ('extends' extends+=JvmParameterizedTypeReference (',' extends+=JvmParameterizedTypeReference)*)?'{'
		//            (members+=Member)*
		//        '}'
		//    ) | (
		//        {XtendEnum.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'enum' name=ValidID '{'
		//            (members+=XtendEnumLiteral (',' members+=XtendEnumLiteral)*)? ';'?
		//        '}'
		//    ) | (
		//        {XtendAnnotationType.annotationInfo = current}
		//        modifiers+=CommonModifier*
		//        'annotation' name=ValidID '{'
		//            (members+=AnnotationField)*
		//        '}'
		//    )
		//)
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//(
		//    {XtendField.annotationInfo = current} modifiers+=CommonModifier*
		//    (
		//        modifiers+=FieldModifier modifiers+=CommonModifier*
		//        type=JvmTypeReference? name=ValidID
		//    |
		//        modifiers+='extension' (modifiers+=FieldModifier | modifiers+=CommonModifier)*
		//        type=JvmTypeReference name=ValidID?
		//    |
		//        modifiers+=FieldModifier (modifiers+=CommonModifier)* modifiers+='extension' (modifiers+=CommonModifier)*
		//        type=JvmTypeReference name=ValidID?
		//    |
		//        type=JvmTypeReference name=ValidID
		//    ) ('=' initialValue=XExpression)? ';'?
		//)
		public Group getGroup_2_0() { return cGroup_2_0; }
		
		//{XtendField.annotationInfo = current}
		public Action getXtendFieldAnnotationInfoAction_2_0_0() { return cXtendFieldAnnotationInfoAction_2_0_0; }
		
		//modifiers+=CommonModifier*
		public Assignment getModifiersAssignment_2_0_1() { return cModifiersAssignment_2_0_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_0_1_0() { return cModifiersCommonModifierParserRuleCall_2_0_1_0; }
		
		//(
		//    modifiers+=FieldModifier modifiers+=CommonModifier*
		//    type=JvmTypeReference? name=ValidID
		//|
		//    modifiers+='extension' (modifiers+=FieldModifier | modifiers+=CommonModifier)*
		//    type=JvmTypeReference name=ValidID?
		//|
		//    modifiers+=FieldModifier (modifiers+=CommonModifier)* modifiers+='extension' (modifiers+=CommonModifier)*
		//    type=JvmTypeReference name=ValidID?
		//|
		//    type=JvmTypeReference name=ValidID
		//)
		public Alternatives getAlternatives_2_0_2() { return cAlternatives_2_0_2; }
		
		//modifiers+=FieldModifier modifiers+=CommonModifier*
		//type=JvmTypeReference? name=ValidID
		public Group getGroup_2_0_2_0() { return cGroup_2_0_2_0; }
		
		//modifiers+=FieldModifier
		public Assignment getModifiersAssignment_2_0_2_0_0() { return cModifiersAssignment_2_0_2_0_0; }
		
		//FieldModifier
		public RuleCall getModifiersFieldModifierParserRuleCall_2_0_2_0_0_0() { return cModifiersFieldModifierParserRuleCall_2_0_2_0_0_0; }
		
		//modifiers+=CommonModifier*
		public Assignment getModifiersAssignment_2_0_2_0_1() { return cModifiersAssignment_2_0_2_0_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_0_2_0_1_0() { return cModifiersCommonModifierParserRuleCall_2_0_2_0_1_0; }
		
		//type=JvmTypeReference?
		public Assignment getTypeAssignment_2_0_2_0_2() { return cTypeAssignment_2_0_2_0_2; }
		
		//JvmTypeReference
		public RuleCall getTypeJvmTypeReferenceParserRuleCall_2_0_2_0_2_0() { return cTypeJvmTypeReferenceParserRuleCall_2_0_2_0_2_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_0_2_0_3() { return cNameAssignment_2_0_2_0_3; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_0_2_0_3_0() { return cNameValidIDParserRuleCall_2_0_2_0_3_0; }
		
		//modifiers+='extension' (modifiers+=FieldModifier | modifiers+=CommonModifier)*
		//type=JvmTypeReference name=ValidID?
		public Group getGroup_2_0_2_1() { return cGroup_2_0_2_1; }
		
		//modifiers+='extension'
		public Assignment getModifiersAssignment_2_0_2_1_0() { return cModifiersAssignment_2_0_2_1_0; }
		
		//'extension'
		public Keyword getModifiersExtensionKeyword_2_0_2_1_0_0() { return cModifiersExtensionKeyword_2_0_2_1_0_0; }
		
		//(modifiers+=FieldModifier | modifiers+=CommonModifier)*
		public Alternatives getAlternatives_2_0_2_1_1() { return cAlternatives_2_0_2_1_1; }
		
		//modifiers+=FieldModifier
		public Assignment getModifiersAssignment_2_0_2_1_1_0() { return cModifiersAssignment_2_0_2_1_1_0; }
		
		//FieldModifier
		public RuleCall getModifiersFieldModifierParserRuleCall_2_0_2_1_1_0_0() { return cModifiersFieldModifierParserRuleCall_2_0_2_1_1_0_0; }
		
		//modifiers+=CommonModifier
		public Assignment getModifiersAssignment_2_0_2_1_1_1() { return cModifiersAssignment_2_0_2_1_1_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_0_2_1_1_1_0() { return cModifiersCommonModifierParserRuleCall_2_0_2_1_1_1_0; }
		
		//type=JvmTypeReference
		public Assignment getTypeAssignment_2_0_2_1_2() { return cTypeAssignment_2_0_2_1_2; }
		
		//JvmTypeReference
		public RuleCall getTypeJvmTypeReferenceParserRuleCall_2_0_2_1_2_0() { return cTypeJvmTypeReferenceParserRuleCall_2_0_2_1_2_0; }
		
		//name=ValidID?
		public Assignment getNameAssignment_2_0_2_1_3() { return cNameAssignment_2_0_2_1_3; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_0_2_1_3_0() { return cNameValidIDParserRuleCall_2_0_2_1_3_0; }
		
		//modifiers+=FieldModifier (modifiers+=CommonModifier)* modifiers+='extension' (modifiers+=CommonModifier)*
		//type=JvmTypeReference name=ValidID?
		public Group getGroup_2_0_2_2() { return cGroup_2_0_2_2; }
		
		//modifiers+=FieldModifier
		public Assignment getModifiersAssignment_2_0_2_2_0() { return cModifiersAssignment_2_0_2_2_0; }
		
		//FieldModifier
		public RuleCall getModifiersFieldModifierParserRuleCall_2_0_2_2_0_0() { return cModifiersFieldModifierParserRuleCall_2_0_2_2_0_0; }
		
		//(modifiers+=CommonModifier)*
		public Assignment getModifiersAssignment_2_0_2_2_1() { return cModifiersAssignment_2_0_2_2_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_0_2_2_1_0() { return cModifiersCommonModifierParserRuleCall_2_0_2_2_1_0; }
		
		//modifiers+='extension'
		public Assignment getModifiersAssignment_2_0_2_2_2() { return cModifiersAssignment_2_0_2_2_2; }
		
		//'extension'
		public Keyword getModifiersExtensionKeyword_2_0_2_2_2_0() { return cModifiersExtensionKeyword_2_0_2_2_2_0; }
		
		//(modifiers+=CommonModifier)*
		public Assignment getModifiersAssignment_2_0_2_2_3() { return cModifiersAssignment_2_0_2_2_3; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_0_2_2_3_0() { return cModifiersCommonModifierParserRuleCall_2_0_2_2_3_0; }
		
		//type=JvmTypeReference
		public Assignment getTypeAssignment_2_0_2_2_4() { return cTypeAssignment_2_0_2_2_4; }
		
		//JvmTypeReference
		public RuleCall getTypeJvmTypeReferenceParserRuleCall_2_0_2_2_4_0() { return cTypeJvmTypeReferenceParserRuleCall_2_0_2_2_4_0; }
		
		//name=ValidID?
		public Assignment getNameAssignment_2_0_2_2_5() { return cNameAssignment_2_0_2_2_5; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_0_2_2_5_0() { return cNameValidIDParserRuleCall_2_0_2_2_5_0; }
		
		//type=JvmTypeReference name=ValidID
		public Group getGroup_2_0_2_3() { return cGroup_2_0_2_3; }
		
		//type=JvmTypeReference
		public Assignment getTypeAssignment_2_0_2_3_0() { return cTypeAssignment_2_0_2_3_0; }
		
		//JvmTypeReference
		public RuleCall getTypeJvmTypeReferenceParserRuleCall_2_0_2_3_0_0() { return cTypeJvmTypeReferenceParserRuleCall_2_0_2_3_0_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_0_2_3_1() { return cNameAssignment_2_0_2_3_1; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_0_2_3_1_0() { return cNameValidIDParserRuleCall_2_0_2_3_1_0; }
		
		//('=' initialValue=XExpression)?
		public Group getGroup_2_0_3() { return cGroup_2_0_3; }
		
		//'='
		public Keyword getEqualsSignKeyword_2_0_3_0() { return cEqualsSignKeyword_2_0_3_0; }
		
		//initialValue=XExpression
		public Assignment getInitialValueAssignment_2_0_3_1() { return cInitialValueAssignment_2_0_3_1; }
		
		//XExpression
		public RuleCall getInitialValueXExpressionParserRuleCall_2_0_3_1_0() { return cInitialValueXExpressionParserRuleCall_2_0_3_1_0; }
		
		//';'?
		public Keyword getSemicolonKeyword_2_0_4() { return cSemicolonKeyword_2_0_4; }
		
		//(
		//           {XtendFunction.annotationInfo = current} modifiers+=CommonModifier*
		//           modifiers+=MethodModifier (modifiers+=CommonModifier | modifiers+=MethodModifier)*
		//           ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//           (
		//               =>(returnType=JvmTypeReference createExtensionInfo=CreateExtensionInfo name=ValidID '(')
		//             | =>(returnType=TypeReferenceWithTypeArgs name=FunctionID '(')
		//             | =>(returnType=TypeReferenceNoTypeArgs name=FunctionID '(')
		//             | =>(createExtensionInfo=CreateExtensionInfo name=ValidID '(')
		//             | name=FunctionID '('
		//           )
		//           (parameters+=Parameter (',' parameters+=Parameter)*)? ')'
		//           ('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
		//           (expression=XBlockExpression | expression=RichString | ';')?
		//       )
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//{XtendFunction.annotationInfo = current}
		public Action getXtendFunctionAnnotationInfoAction_2_1_0() { return cXtendFunctionAnnotationInfoAction_2_1_0; }
		
		//modifiers+=CommonModifier*
		public Assignment getModifiersAssignment_2_1_1() { return cModifiersAssignment_2_1_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_1_1_0() { return cModifiersCommonModifierParserRuleCall_2_1_1_0; }
		
		//modifiers+=MethodModifier
		public Assignment getModifiersAssignment_2_1_2() { return cModifiersAssignment_2_1_2; }
		
		//MethodModifier
		public RuleCall getModifiersMethodModifierParserRuleCall_2_1_2_0() { return cModifiersMethodModifierParserRuleCall_2_1_2_0; }
		
		//(modifiers+=CommonModifier | modifiers+=MethodModifier)*
		public Alternatives getAlternatives_2_1_3() { return cAlternatives_2_1_3; }
		
		//modifiers+=CommonModifier
		public Assignment getModifiersAssignment_2_1_3_0() { return cModifiersAssignment_2_1_3_0; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_1_3_0_0() { return cModifiersCommonModifierParserRuleCall_2_1_3_0_0; }
		
		//modifiers+=MethodModifier
		public Assignment getModifiersAssignment_2_1_3_1() { return cModifiersAssignment_2_1_3_1; }
		
		//MethodModifier
		public RuleCall getModifiersMethodModifierParserRuleCall_2_1_3_1_0() { return cModifiersMethodModifierParserRuleCall_2_1_3_1_0; }
		
		//('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		public Group getGroup_2_1_4() { return cGroup_2_1_4; }
		
		//'<'
		public Keyword getLessThanSignKeyword_2_1_4_0() { return cLessThanSignKeyword_2_1_4_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_1_4_1() { return cTypeParametersAssignment_2_1_4_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0; }
		
		//(',' typeParameters+=JvmTypeParameter)*
		public Group getGroup_2_1_4_2() { return cGroup_2_1_4_2; }
		
		//','
		public Keyword getCommaKeyword_2_1_4_2_0() { return cCommaKeyword_2_1_4_2_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_1_4_2_1() { return cTypeParametersAssignment_2_1_4_2_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_2_1_4_3() { return cGreaterThanSignKeyword_2_1_4_3; }
		
		//(
		//    =>(returnType=JvmTypeReference createExtensionInfo=CreateExtensionInfo name=ValidID '(')
		//  | =>(returnType=TypeReferenceWithTypeArgs name=FunctionID '(')
		//  | =>(returnType=TypeReferenceNoTypeArgs name=FunctionID '(')
		//  | =>(createExtensionInfo=CreateExtensionInfo name=ValidID '(')
		//  | name=FunctionID '('
		//)
		public Alternatives getAlternatives_2_1_5() { return cAlternatives_2_1_5; }
		
		//=>(returnType=JvmTypeReference createExtensionInfo=CreateExtensionInfo name=ValidID '(')
		public Group getGroup_2_1_5_0() { return cGroup_2_1_5_0; }
		
		//returnType=JvmTypeReference createExtensionInfo=CreateExtensionInfo name=ValidID '('
		public Group getGroup_2_1_5_0_0() { return cGroup_2_1_5_0_0; }
		
		//returnType=JvmTypeReference
		public Assignment getReturnTypeAssignment_2_1_5_0_0_0() { return cReturnTypeAssignment_2_1_5_0_0_0; }
		
		//JvmTypeReference
		public RuleCall getReturnTypeJvmTypeReferenceParserRuleCall_2_1_5_0_0_0_0() { return cReturnTypeJvmTypeReferenceParserRuleCall_2_1_5_0_0_0_0; }
		
		//createExtensionInfo=CreateExtensionInfo
		public Assignment getCreateExtensionInfoAssignment_2_1_5_0_0_1() { return cCreateExtensionInfoAssignment_2_1_5_0_0_1; }
		
		//CreateExtensionInfo
		public RuleCall getCreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_0_0_1_0() { return cCreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_0_0_1_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_1_5_0_0_2() { return cNameAssignment_2_1_5_0_0_2; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_1_5_0_0_2_0() { return cNameValidIDParserRuleCall_2_1_5_0_0_2_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2_1_5_0_0_3() { return cLeftParenthesisKeyword_2_1_5_0_0_3; }
		
		//=>(returnType=TypeReferenceWithTypeArgs name=FunctionID '(')
		public Group getGroup_2_1_5_1() { return cGroup_2_1_5_1; }
		
		//returnType=TypeReferenceWithTypeArgs name=FunctionID '('
		public Group getGroup_2_1_5_1_0() { return cGroup_2_1_5_1_0; }
		
		//returnType=TypeReferenceWithTypeArgs
		public Assignment getReturnTypeAssignment_2_1_5_1_0_0() { return cReturnTypeAssignment_2_1_5_1_0_0; }
		
		//TypeReferenceWithTypeArgs
		public RuleCall getReturnTypeTypeReferenceWithTypeArgsParserRuleCall_2_1_5_1_0_0_0() { return cReturnTypeTypeReferenceWithTypeArgsParserRuleCall_2_1_5_1_0_0_0; }
		
		//name=FunctionID
		public Assignment getNameAssignment_2_1_5_1_0_1() { return cNameAssignment_2_1_5_1_0_1; }
		
		//FunctionID
		public RuleCall getNameFunctionIDParserRuleCall_2_1_5_1_0_1_0() { return cNameFunctionIDParserRuleCall_2_1_5_1_0_1_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2_1_5_1_0_2() { return cLeftParenthesisKeyword_2_1_5_1_0_2; }
		
		//=>(returnType=TypeReferenceNoTypeArgs name=FunctionID '(')
		public Group getGroup_2_1_5_2() { return cGroup_2_1_5_2; }
		
		//returnType=TypeReferenceNoTypeArgs name=FunctionID '('
		public Group getGroup_2_1_5_2_0() { return cGroup_2_1_5_2_0; }
		
		//returnType=TypeReferenceNoTypeArgs
		public Assignment getReturnTypeAssignment_2_1_5_2_0_0() { return cReturnTypeAssignment_2_1_5_2_0_0; }
		
		//TypeReferenceNoTypeArgs
		public RuleCall getReturnTypeTypeReferenceNoTypeArgsParserRuleCall_2_1_5_2_0_0_0() { return cReturnTypeTypeReferenceNoTypeArgsParserRuleCall_2_1_5_2_0_0_0; }
		
		//name=FunctionID
		public Assignment getNameAssignment_2_1_5_2_0_1() { return cNameAssignment_2_1_5_2_0_1; }
		
		//FunctionID
		public RuleCall getNameFunctionIDParserRuleCall_2_1_5_2_0_1_0() { return cNameFunctionIDParserRuleCall_2_1_5_2_0_1_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2_1_5_2_0_2() { return cLeftParenthesisKeyword_2_1_5_2_0_2; }
		
		//=>(createExtensionInfo=CreateExtensionInfo name=ValidID '(')
		public Group getGroup_2_1_5_3() { return cGroup_2_1_5_3; }
		
		//createExtensionInfo=CreateExtensionInfo name=ValidID '('
		public Group getGroup_2_1_5_3_0() { return cGroup_2_1_5_3_0; }
		
		//createExtensionInfo=CreateExtensionInfo
		public Assignment getCreateExtensionInfoAssignment_2_1_5_3_0_0() { return cCreateExtensionInfoAssignment_2_1_5_3_0_0; }
		
		//CreateExtensionInfo
		public RuleCall getCreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_3_0_0_0() { return cCreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_3_0_0_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_1_5_3_0_1() { return cNameAssignment_2_1_5_3_0_1; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_1_5_3_0_1_0() { return cNameValidIDParserRuleCall_2_1_5_3_0_1_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2_1_5_3_0_2() { return cLeftParenthesisKeyword_2_1_5_3_0_2; }
		
		//name=FunctionID '('
		public Group getGroup_2_1_5_4() { return cGroup_2_1_5_4; }
		
		//name=FunctionID
		public Assignment getNameAssignment_2_1_5_4_0() { return cNameAssignment_2_1_5_4_0; }
		
		//FunctionID
		public RuleCall getNameFunctionIDParserRuleCall_2_1_5_4_0_0() { return cNameFunctionIDParserRuleCall_2_1_5_4_0_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2_1_5_4_1() { return cLeftParenthesisKeyword_2_1_5_4_1; }
		
		//(parameters+=Parameter (',' parameters+=Parameter)*)?
		public Group getGroup_2_1_6() { return cGroup_2_1_6; }
		
		//parameters+=Parameter
		public Assignment getParametersAssignment_2_1_6_0() { return cParametersAssignment_2_1_6_0; }
		
		//Parameter
		public RuleCall getParametersParameterParserRuleCall_2_1_6_0_0() { return cParametersParameterParserRuleCall_2_1_6_0_0; }
		
		//(',' parameters+=Parameter)*
		public Group getGroup_2_1_6_1() { return cGroup_2_1_6_1; }
		
		//','
		public Keyword getCommaKeyword_2_1_6_1_0() { return cCommaKeyword_2_1_6_1_0; }
		
		//parameters+=Parameter
		public Assignment getParametersAssignment_2_1_6_1_1() { return cParametersAssignment_2_1_6_1_1; }
		
		//Parameter
		public RuleCall getParametersParameterParserRuleCall_2_1_6_1_1_0() { return cParametersParameterParserRuleCall_2_1_6_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2_1_7() { return cRightParenthesisKeyword_2_1_7; }
		
		//('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
		public Group getGroup_2_1_8() { return cGroup_2_1_8; }
		
		//'throws'
		public Keyword getThrowsKeyword_2_1_8_0() { return cThrowsKeyword_2_1_8_0; }
		
		//exceptions+=JvmTypeReference
		public Assignment getExceptionsAssignment_2_1_8_1() { return cExceptionsAssignment_2_1_8_1; }
		
		//JvmTypeReference
		public RuleCall getExceptionsJvmTypeReferenceParserRuleCall_2_1_8_1_0() { return cExceptionsJvmTypeReferenceParserRuleCall_2_1_8_1_0; }
		
		//(',' exceptions+=JvmTypeReference)*
		public Group getGroup_2_1_8_2() { return cGroup_2_1_8_2; }
		
		//','
		public Keyword getCommaKeyword_2_1_8_2_0() { return cCommaKeyword_2_1_8_2_0; }
		
		//exceptions+=JvmTypeReference
		public Assignment getExceptionsAssignment_2_1_8_2_1() { return cExceptionsAssignment_2_1_8_2_1; }
		
		//JvmTypeReference
		public RuleCall getExceptionsJvmTypeReferenceParserRuleCall_2_1_8_2_1_0() { return cExceptionsJvmTypeReferenceParserRuleCall_2_1_8_2_1_0; }
		
		//(expression=XBlockExpression | expression=RichString | ';')?
		public Alternatives getAlternatives_2_1_9() { return cAlternatives_2_1_9; }
		
		//expression=XBlockExpression
		public Assignment getExpressionAssignment_2_1_9_0() { return cExpressionAssignment_2_1_9_0; }
		
		//XBlockExpression
		public RuleCall getExpressionXBlockExpressionParserRuleCall_2_1_9_0_0() { return cExpressionXBlockExpressionParserRuleCall_2_1_9_0_0; }
		
		//expression=RichString
		public Assignment getExpressionAssignment_2_1_9_1() { return cExpressionAssignment_2_1_9_1; }
		
		//RichString
		public RuleCall getExpressionRichStringParserRuleCall_2_1_9_1_0() { return cExpressionRichStringParserRuleCall_2_1_9_1_0; }
		
		//';'
		public Keyword getSemicolonKeyword_2_1_9_2() { return cSemicolonKeyword_2_1_9_2; }
		
		//(
		//           {XtendConstructor.annotationInfo = current} modifiers+=CommonModifier*
		//           'new'
		//           ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//           '(' (parameters+=Parameter (',' parameters+=Parameter)*)? ')'
		//           ('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
		//           expression=XBlockExpression
		//       )
		public Group getGroup_2_2() { return cGroup_2_2; }
		
		//{XtendConstructor.annotationInfo = current}
		public Action getXtendConstructorAnnotationInfoAction_2_2_0() { return cXtendConstructorAnnotationInfoAction_2_2_0; }
		
		//modifiers+=CommonModifier*
		public Assignment getModifiersAssignment_2_2_1() { return cModifiersAssignment_2_2_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_2_1_0() { return cModifiersCommonModifierParserRuleCall_2_2_1_0; }
		
		//'new'
		public Keyword getNewKeyword_2_2_2() { return cNewKeyword_2_2_2; }
		
		//('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		public Group getGroup_2_2_3() { return cGroup_2_2_3; }
		
		//'<'
		public Keyword getLessThanSignKeyword_2_2_3_0() { return cLessThanSignKeyword_2_2_3_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_2_3_1() { return cTypeParametersAssignment_2_2_3_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_2_3_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_2_3_1_0; }
		
		//(',' typeParameters+=JvmTypeParameter)*
		public Group getGroup_2_2_3_2() { return cGroup_2_2_3_2; }
		
		//','
		public Keyword getCommaKeyword_2_2_3_2_0() { return cCommaKeyword_2_2_3_2_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_2_3_2_1() { return cTypeParametersAssignment_2_2_3_2_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_2_3_2_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_2_3_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_2_2_3_3() { return cGreaterThanSignKeyword_2_2_3_3; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2_2_4() { return cLeftParenthesisKeyword_2_2_4; }
		
		//(parameters+=Parameter (',' parameters+=Parameter)*)?
		public Group getGroup_2_2_5() { return cGroup_2_2_5; }
		
		//parameters+=Parameter
		public Assignment getParametersAssignment_2_2_5_0() { return cParametersAssignment_2_2_5_0; }
		
		//Parameter
		public RuleCall getParametersParameterParserRuleCall_2_2_5_0_0() { return cParametersParameterParserRuleCall_2_2_5_0_0; }
		
		//(',' parameters+=Parameter)*
		public Group getGroup_2_2_5_1() { return cGroup_2_2_5_1; }
		
		//','
		public Keyword getCommaKeyword_2_2_5_1_0() { return cCommaKeyword_2_2_5_1_0; }
		
		//parameters+=Parameter
		public Assignment getParametersAssignment_2_2_5_1_1() { return cParametersAssignment_2_2_5_1_1; }
		
		//Parameter
		public RuleCall getParametersParameterParserRuleCall_2_2_5_1_1_0() { return cParametersParameterParserRuleCall_2_2_5_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2_2_6() { return cRightParenthesisKeyword_2_2_6; }
		
		//('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
		public Group getGroup_2_2_7() { return cGroup_2_2_7; }
		
		//'throws'
		public Keyword getThrowsKeyword_2_2_7_0() { return cThrowsKeyword_2_2_7_0; }
		
		//exceptions+=JvmTypeReference
		public Assignment getExceptionsAssignment_2_2_7_1() { return cExceptionsAssignment_2_2_7_1; }
		
		//JvmTypeReference
		public RuleCall getExceptionsJvmTypeReferenceParserRuleCall_2_2_7_1_0() { return cExceptionsJvmTypeReferenceParserRuleCall_2_2_7_1_0; }
		
		//(',' exceptions+=JvmTypeReference)*
		public Group getGroup_2_2_7_2() { return cGroup_2_2_7_2; }
		
		//','
		public Keyword getCommaKeyword_2_2_7_2_0() { return cCommaKeyword_2_2_7_2_0; }
		
		//exceptions+=JvmTypeReference
		public Assignment getExceptionsAssignment_2_2_7_2_1() { return cExceptionsAssignment_2_2_7_2_1; }
		
		//JvmTypeReference
		public RuleCall getExceptionsJvmTypeReferenceParserRuleCall_2_2_7_2_1_0() { return cExceptionsJvmTypeReferenceParserRuleCall_2_2_7_2_1_0; }
		
		//expression=XBlockExpression
		public Assignment getExpressionAssignment_2_2_8() { return cExpressionAssignment_2_2_8; }
		
		//XBlockExpression
		public RuleCall getExpressionXBlockExpressionParserRuleCall_2_2_8_0() { return cExpressionXBlockExpressionParserRuleCall_2_2_8_0; }
		
		//(
		//           {XtendClass.annotationInfo = current}
		//           modifiers+=CommonModifier*
		//           'class' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//           ("extends" extends=JvmParameterizedTypeReference)?
		//           ('implements' implements+=JvmParameterizedTypeReference (',' implements+=JvmParameterizedTypeReference)*)?'{'
		//               (members+=Member)*
		//           '}'
		//       )
		public Group getGroup_2_3() { return cGroup_2_3; }
		
		//{XtendClass.annotationInfo = current}
		public Action getXtendClassAnnotationInfoAction_2_3_0() { return cXtendClassAnnotationInfoAction_2_3_0; }
		
		//modifiers+=CommonModifier*
		public Assignment getModifiersAssignment_2_3_1() { return cModifiersAssignment_2_3_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_3_1_0() { return cModifiersCommonModifierParserRuleCall_2_3_1_0; }
		
		//'class'
		public Keyword getClassKeyword_2_3_2() { return cClassKeyword_2_3_2; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_3_3() { return cNameAssignment_2_3_3; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_3_3_0() { return cNameValidIDParserRuleCall_2_3_3_0; }
		
		//('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		public Group getGroup_2_3_4() { return cGroup_2_3_4; }
		
		//'<'
		public Keyword getLessThanSignKeyword_2_3_4_0() { return cLessThanSignKeyword_2_3_4_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_3_4_1() { return cTypeParametersAssignment_2_3_4_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_3_4_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_3_4_1_0; }
		
		//(',' typeParameters+=JvmTypeParameter)*
		public Group getGroup_2_3_4_2() { return cGroup_2_3_4_2; }
		
		//','
		public Keyword getCommaKeyword_2_3_4_2_0() { return cCommaKeyword_2_3_4_2_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_3_4_2_1() { return cTypeParametersAssignment_2_3_4_2_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_3_4_2_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_3_4_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_2_3_4_3() { return cGreaterThanSignKeyword_2_3_4_3; }
		
		//("extends" extends=JvmParameterizedTypeReference)?
		public Group getGroup_2_3_5() { return cGroup_2_3_5; }
		
		//"extends"
		public Keyword getExtendsKeyword_2_3_5_0() { return cExtendsKeyword_2_3_5_0; }
		
		//extends=JvmParameterizedTypeReference
		public Assignment getExtendsAssignment_2_3_5_1() { return cExtendsAssignment_2_3_5_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_3_5_1_0() { return cExtendsJvmParameterizedTypeReferenceParserRuleCall_2_3_5_1_0; }
		
		//('implements' implements+=JvmParameterizedTypeReference (',' implements+=JvmParameterizedTypeReference)*)?
		public Group getGroup_2_3_6() { return cGroup_2_3_6; }
		
		//'implements'
		public Keyword getImplementsKeyword_2_3_6_0() { return cImplementsKeyword_2_3_6_0; }
		
		//implements+=JvmParameterizedTypeReference
		public Assignment getImplementsAssignment_2_3_6_1() { return cImplementsAssignment_2_3_6_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getImplementsJvmParameterizedTypeReferenceParserRuleCall_2_3_6_1_0() { return cImplementsJvmParameterizedTypeReferenceParserRuleCall_2_3_6_1_0; }
		
		//(',' implements+=JvmParameterizedTypeReference)*
		public Group getGroup_2_3_6_2() { return cGroup_2_3_6_2; }
		
		//','
		public Keyword getCommaKeyword_2_3_6_2_0() { return cCommaKeyword_2_3_6_2_0; }
		
		//implements+=JvmParameterizedTypeReference
		public Assignment getImplementsAssignment_2_3_6_2_1() { return cImplementsAssignment_2_3_6_2_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getImplementsJvmParameterizedTypeReferenceParserRuleCall_2_3_6_2_1_0() { return cImplementsJvmParameterizedTypeReferenceParserRuleCall_2_3_6_2_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_3_7() { return cLeftCurlyBracketKeyword_2_3_7; }
		
		//(members+=Member)*
		public Assignment getMembersAssignment_2_3_8() { return cMembersAssignment_2_3_8; }
		
		//Member
		public RuleCall getMembersMemberParserRuleCall_2_3_8_0() { return cMembersMemberParserRuleCall_2_3_8_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_2_3_9() { return cRightCurlyBracketKeyword_2_3_9; }
		
		//(
		//           {XtendInterface.annotationInfo = current}
		//           modifiers+=CommonModifier*
		//           'interface' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//           ('extends' extends+=JvmParameterizedTypeReference (',' extends+=JvmParameterizedTypeReference)*)?'{'
		//               (members+=Member)*
		//           '}'
		//       )
		public Group getGroup_2_4() { return cGroup_2_4; }
		
		//{XtendInterface.annotationInfo = current}
		public Action getXtendInterfaceAnnotationInfoAction_2_4_0() { return cXtendInterfaceAnnotationInfoAction_2_4_0; }
		
		//modifiers+=CommonModifier*
		public Assignment getModifiersAssignment_2_4_1() { return cModifiersAssignment_2_4_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_4_1_0() { return cModifiersCommonModifierParserRuleCall_2_4_1_0; }
		
		//'interface'
		public Keyword getInterfaceKeyword_2_4_2() { return cInterfaceKeyword_2_4_2; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_4_3() { return cNameAssignment_2_4_3; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_4_3_0() { return cNameValidIDParserRuleCall_2_4_3_0; }
		
		//('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		public Group getGroup_2_4_4() { return cGroup_2_4_4; }
		
		//'<'
		public Keyword getLessThanSignKeyword_2_4_4_0() { return cLessThanSignKeyword_2_4_4_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_4_4_1() { return cTypeParametersAssignment_2_4_4_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_4_4_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_4_4_1_0; }
		
		//(',' typeParameters+=JvmTypeParameter)*
		public Group getGroup_2_4_4_2() { return cGroup_2_4_4_2; }
		
		//','
		public Keyword getCommaKeyword_2_4_4_2_0() { return cCommaKeyword_2_4_4_2_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_4_4_2_1() { return cTypeParametersAssignment_2_4_4_2_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_4_4_2_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_4_4_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_2_4_4_3() { return cGreaterThanSignKeyword_2_4_4_3; }
		
		//('extends' extends+=JvmParameterizedTypeReference (',' extends+=JvmParameterizedTypeReference)*)?
		public Group getGroup_2_4_5() { return cGroup_2_4_5; }
		
		//'extends'
		public Keyword getExtendsKeyword_2_4_5_0() { return cExtendsKeyword_2_4_5_0; }
		
		//extends+=JvmParameterizedTypeReference
		public Assignment getExtendsAssignment_2_4_5_1() { return cExtendsAssignment_2_4_5_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_4_5_1_0() { return cExtendsJvmParameterizedTypeReferenceParserRuleCall_2_4_5_1_0; }
		
		//(',' extends+=JvmParameterizedTypeReference)*
		public Group getGroup_2_4_5_2() { return cGroup_2_4_5_2; }
		
		//','
		public Keyword getCommaKeyword_2_4_5_2_0() { return cCommaKeyword_2_4_5_2_0; }
		
		//extends+=JvmParameterizedTypeReference
		public Assignment getExtendsAssignment_2_4_5_2_1() { return cExtendsAssignment_2_4_5_2_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_4_5_2_1_0() { return cExtendsJvmParameterizedTypeReferenceParserRuleCall_2_4_5_2_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_4_6() { return cLeftCurlyBracketKeyword_2_4_6; }
		
		//(members+=Member)*
		public Assignment getMembersAssignment_2_4_7() { return cMembersAssignment_2_4_7; }
		
		//Member
		public RuleCall getMembersMemberParserRuleCall_2_4_7_0() { return cMembersMemberParserRuleCall_2_4_7_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_2_4_8() { return cRightCurlyBracketKeyword_2_4_8; }
		
		//(
		//           {XtendEnum.annotationInfo = current}
		//           modifiers+=CommonModifier*
		//           'enum' name=ValidID '{'
		//               (members+=XtendEnumLiteral (',' members+=XtendEnumLiteral)*)? ';'?
		//           '}'
		//       )
		public Group getGroup_2_5() { return cGroup_2_5; }
		
		//{XtendEnum.annotationInfo = current}
		public Action getXtendEnumAnnotationInfoAction_2_5_0() { return cXtendEnumAnnotationInfoAction_2_5_0; }
		
		//modifiers+=CommonModifier*
		public Assignment getModifiersAssignment_2_5_1() { return cModifiersAssignment_2_5_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_5_1_0() { return cModifiersCommonModifierParserRuleCall_2_5_1_0; }
		
		//'enum'
		public Keyword getEnumKeyword_2_5_2() { return cEnumKeyword_2_5_2; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_5_3() { return cNameAssignment_2_5_3; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_5_3_0() { return cNameValidIDParserRuleCall_2_5_3_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_5_4() { return cLeftCurlyBracketKeyword_2_5_4; }
		
		//(members+=XtendEnumLiteral (',' members+=XtendEnumLiteral)*)?
		public Group getGroup_2_5_5() { return cGroup_2_5_5; }
		
		//members+=XtendEnumLiteral
		public Assignment getMembersAssignment_2_5_5_0() { return cMembersAssignment_2_5_5_0; }
		
		//XtendEnumLiteral
		public RuleCall getMembersXtendEnumLiteralParserRuleCall_2_5_5_0_0() { return cMembersXtendEnumLiteralParserRuleCall_2_5_5_0_0; }
		
		//(',' members+=XtendEnumLiteral)*
		public Group getGroup_2_5_5_1() { return cGroup_2_5_5_1; }
		
		//','
		public Keyword getCommaKeyword_2_5_5_1_0() { return cCommaKeyword_2_5_5_1_0; }
		
		//members+=XtendEnumLiteral
		public Assignment getMembersAssignment_2_5_5_1_1() { return cMembersAssignment_2_5_5_1_1; }
		
		//XtendEnumLiteral
		public RuleCall getMembersXtendEnumLiteralParserRuleCall_2_5_5_1_1_0() { return cMembersXtendEnumLiteralParserRuleCall_2_5_5_1_1_0; }
		
		//';'?
		public Keyword getSemicolonKeyword_2_5_6() { return cSemicolonKeyword_2_5_6; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_2_5_7() { return cRightCurlyBracketKeyword_2_5_7; }
		
		//(
		//           {XtendAnnotationType.annotationInfo = current}
		//           modifiers+=CommonModifier*
		//           'annotation' name=ValidID '{'
		//               (members+=AnnotationField)*
		//           '}'
		//       )
		public Group getGroup_2_6() { return cGroup_2_6; }
		
		//{XtendAnnotationType.annotationInfo = current}
		public Action getXtendAnnotationTypeAnnotationInfoAction_2_6_0() { return cXtendAnnotationTypeAnnotationInfoAction_2_6_0; }
		
		//modifiers+=CommonModifier*
		public Assignment getModifiersAssignment_2_6_1() { return cModifiersAssignment_2_6_1; }
		
		//CommonModifier
		public RuleCall getModifiersCommonModifierParserRuleCall_2_6_1_0() { return cModifiersCommonModifierParserRuleCall_2_6_1_0; }
		
		//'annotation'
		public Keyword getAnnotationKeyword_2_6_2() { return cAnnotationKeyword_2_6_2; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_6_3() { return cNameAssignment_2_6_3; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_6_3_0() { return cNameValidIDParserRuleCall_2_6_3_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_6_4() { return cLeftCurlyBracketKeyword_2_6_4; }
		
		//(members+=AnnotationField)*
		public Assignment getMembersAssignment_2_6_5() { return cMembersAssignment_2_6_5; }
		
		//AnnotationField
		public RuleCall getMembersAnnotationFieldParserRuleCall_2_6_5_0() { return cMembersAnnotationFieldParserRuleCall_2_6_5_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_2_6_6() { return cRightCurlyBracketKeyword_2_6_6; }
	}
	public class TypeReferenceNoTypeArgsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.TypeReferenceNoTypeArgs");
		private final Assignment cTypeAssignment = (Assignment)rule.eContents().get(1);
		private final CrossReference cTypeJvmTypeCrossReference_0 = (CrossReference)cTypeAssignment.eContents().get(0);
		private final RuleCall cTypeJvmTypeQualifiedNameParserRuleCall_0_1 = (RuleCall)cTypeJvmTypeCrossReference_0.eContents().get(1);
		
		//TypeReferenceNoTypeArgs returns types::JvmParameterizedTypeReference:
		//    type=[types::JvmType|QualifiedName]
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//type=[types::JvmType|QualifiedName]
		public Assignment getTypeAssignment() { return cTypeAssignment; }
		
		//[types::JvmType|QualifiedName]
		public CrossReference getTypeJvmTypeCrossReference_0() { return cTypeJvmTypeCrossReference_0; }
		
		//QualifiedName
		public RuleCall getTypeJvmTypeQualifiedNameParserRuleCall_0_1() { return cTypeJvmTypeQualifiedNameParserRuleCall_0_1; }
	}
	public class TypeReferenceWithTypeArgsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.TypeReferenceWithTypeArgs");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final RuleCall cParameterizedTypeReferenceWithTypeArgsParserRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cGroup_0.eContents().get(1);
		private final Group cGroup_0_1_0 = (Group)cGroup_0_1.eContents().get(0);
		private final Action cJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0 = (Action)cGroup_0_1_0.eContents().get(0);
		private final RuleCall cArrayBracketsParserRuleCall_0_1_0_1 = (RuleCall)cGroup_0_1_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final RuleCall cTypeReferenceNoTypeArgsParserRuleCall_1_0 = (RuleCall)cGroup_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Group cGroup_1_1_0 = (Group)cGroup_1_1.eContents().get(0);
		private final Action cJvmGenericArrayTypeReferenceComponentTypeAction_1_1_0_0 = (Action)cGroup_1_1_0.eContents().get(0);
		private final RuleCall cArrayBracketsParserRuleCall_1_1_0_1 = (RuleCall)cGroup_1_1_0.eContents().get(1);
		private final RuleCall cXFunctionTypeRefParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		///*** The following two rules are a workaround for a limitation in serialization logic
		// *
		// * Apparently we choose the shortest possible path to create the sequence of unassigned
		// * tokens between two assigned values. This doesn't work well with Antlr predicates which
		// * may have lead to another decision path - not necessarily the shortest one in the sense
		// * of the serializer. That's why we make the type arguments mandatory here so that we
		// * do no longer have two equally short path's from method identifier to block expression
		// **************************************************************************************/
		//TypeReferenceWithTypeArgs returns types::JvmTypeReference:
		//    ParameterizedTypeReferenceWithTypeArgs =>({types::JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)*
		//  | TypeReferenceNoTypeArgs =>({types::JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)+
		//  | XFunctionTypeRef
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//  ParameterizedTypeReferenceWithTypeArgs =>({types::JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)*
		//| TypeReferenceNoTypeArgs =>({types::JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)+
		//| XFunctionTypeRef
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ParameterizedTypeReferenceWithTypeArgs =>({types::JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)*
		public Group getGroup_0() { return cGroup_0; }
		
		//ParameterizedTypeReferenceWithTypeArgs
		public RuleCall getParameterizedTypeReferenceWithTypeArgsParserRuleCall_0_0() { return cParameterizedTypeReferenceWithTypeArgsParserRuleCall_0_0; }
		
		//=>({types::JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)*
		public Group getGroup_0_1() { return cGroup_0_1; }
		
		//{types::JvmGenericArrayTypeReference.componentType=current} ArrayBrackets
		public Group getGroup_0_1_0() { return cGroup_0_1_0; }
		
		//{types::JvmGenericArrayTypeReference.componentType=current}
		public Action getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0() { return cJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0; }
		
		//ArrayBrackets
		public RuleCall getArrayBracketsParserRuleCall_0_1_0_1() { return cArrayBracketsParserRuleCall_0_1_0_1; }
		
		//TypeReferenceNoTypeArgs =>({types::JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)+
		public Group getGroup_1() { return cGroup_1; }
		
		//TypeReferenceNoTypeArgs
		public RuleCall getTypeReferenceNoTypeArgsParserRuleCall_1_0() { return cTypeReferenceNoTypeArgsParserRuleCall_1_0; }
		
		//=>({types::JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)+
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//{types::JvmGenericArrayTypeReference.componentType=current} ArrayBrackets
		public Group getGroup_1_1_0() { return cGroup_1_1_0; }
		
		//{types::JvmGenericArrayTypeReference.componentType=current}
		public Action getJvmGenericArrayTypeReferenceComponentTypeAction_1_1_0_0() { return cJvmGenericArrayTypeReferenceComponentTypeAction_1_1_0_0; }
		
		//ArrayBrackets
		public RuleCall getArrayBracketsParserRuleCall_1_1_0_1() { return cArrayBracketsParserRuleCall_1_1_0_1; }
		
		//XFunctionTypeRef
		public RuleCall getXFunctionTypeRefParserRuleCall_2() { return cXFunctionTypeRefParserRuleCall_2; }
	}
	public class ParameterizedTypeReferenceWithTypeArgsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.ParameterizedTypeReferenceWithTypeArgs");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cTypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cTypeJvmTypeCrossReference_0_0 = (CrossReference)cTypeAssignment_0.eContents().get(0);
		private final RuleCall cTypeJvmTypeQualifiedNameParserRuleCall_0_0_1 = (RuleCall)cTypeJvmTypeCrossReference_0_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cLessThanSignKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cArgumentsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0 = (RuleCall)cArgumentsAssignment_1_1.eContents().get(0);
		private final Group cGroup_1_2 = (Group)cGroup_1.eContents().get(2);
		private final Keyword cCommaKeyword_1_2_0 = (Keyword)cGroup_1_2.eContents().get(0);
		private final Assignment cArgumentsAssignment_1_2_1 = (Assignment)cGroup_1_2.eContents().get(1);
		private final RuleCall cArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0 = (RuleCall)cArgumentsAssignment_1_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_1_3 = (Keyword)cGroup_1.eContents().get(3);
		private final Group cGroup_1_4 = (Group)cGroup_1.eContents().get(4);
		private final Group cGroup_1_4_0 = (Group)cGroup_1_4.eContents().get(0);
		private final Group cGroup_1_4_0_0 = (Group)cGroup_1_4_0.eContents().get(0);
		private final Action cJvmInnerTypeReferenceOuterAction_1_4_0_0_0 = (Action)cGroup_1_4_0_0.eContents().get(0);
		private final Keyword cFullStopKeyword_1_4_0_0_1 = (Keyword)cGroup_1_4_0_0.eContents().get(1);
		private final Assignment cTypeAssignment_1_4_1 = (Assignment)cGroup_1_4.eContents().get(1);
		private final CrossReference cTypeJvmTypeCrossReference_1_4_1_0 = (CrossReference)cTypeAssignment_1_4_1.eContents().get(0);
		private final RuleCall cTypeJvmTypeValidIDParserRuleCall_1_4_1_0_1 = (RuleCall)cTypeJvmTypeCrossReference_1_4_1_0.eContents().get(1);
		private final Group cGroup_1_4_2 = (Group)cGroup_1_4.eContents().get(2);
		private final Keyword cLessThanSignKeyword_1_4_2_0 = (Keyword)cGroup_1_4_2.eContents().get(0);
		private final Assignment cArgumentsAssignment_1_4_2_1 = (Assignment)cGroup_1_4_2.eContents().get(1);
		private final RuleCall cArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0 = (RuleCall)cArgumentsAssignment_1_4_2_1.eContents().get(0);
		private final Group cGroup_1_4_2_2 = (Group)cGroup_1_4_2.eContents().get(2);
		private final Keyword cCommaKeyword_1_4_2_2_0 = (Keyword)cGroup_1_4_2_2.eContents().get(0);
		private final Assignment cArgumentsAssignment_1_4_2_2_1 = (Assignment)cGroup_1_4_2_2.eContents().get(1);
		private final RuleCall cArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0 = (RuleCall)cArgumentsAssignment_1_4_2_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_1_4_2_3 = (Keyword)cGroup_1_4_2.eContents().get(3);
		
		//ParameterizedTypeReferenceWithTypeArgs returns types::JvmParameterizedTypeReference:
		//    type=[types::JvmType|QualifiedName] (
		//        '<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>'
		//        (=>({types::JvmInnerTypeReference.outer=current} '.') type=[types::JvmType|ValidID] (=>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>')?)*
		//    )
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//type=[types::JvmType|QualifiedName] (
		//    '<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>'
		//    (=>({types::JvmInnerTypeReference.outer=current} '.') type=[types::JvmType|ValidID] (=>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>')?)*
		//)
		public Group getGroup() { return cGroup; }
		
		//type=[types::JvmType|QualifiedName]
		public Assignment getTypeAssignment_0() { return cTypeAssignment_0; }
		
		//[types::JvmType|QualifiedName]
		public CrossReference getTypeJvmTypeCrossReference_0_0() { return cTypeJvmTypeCrossReference_0_0; }
		
		//QualifiedName
		public RuleCall getTypeJvmTypeQualifiedNameParserRuleCall_0_0_1() { return cTypeJvmTypeQualifiedNameParserRuleCall_0_0_1; }
		
		//(
		//       '<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>'
		//       (=>({types::JvmInnerTypeReference.outer=current} '.') type=[types::JvmType|ValidID] (=>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>')?)*
		//   )
		public Group getGroup_1() { return cGroup_1; }
		
		//'<'
		public Keyword getLessThanSignKeyword_1_0() { return cLessThanSignKeyword_1_0; }
		
		//arguments+=JvmArgumentTypeReference
		public Assignment getArgumentsAssignment_1_1() { return cArgumentsAssignment_1_1; }
		
		//JvmArgumentTypeReference
		public RuleCall getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0() { return cArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0; }
		
		//(',' arguments+=JvmArgumentTypeReference)*
		public Group getGroup_1_2() { return cGroup_1_2; }
		
		//','
		public Keyword getCommaKeyword_1_2_0() { return cCommaKeyword_1_2_0; }
		
		//arguments+=JvmArgumentTypeReference
		public Assignment getArgumentsAssignment_1_2_1() { return cArgumentsAssignment_1_2_1; }
		
		//JvmArgumentTypeReference
		public RuleCall getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0() { return cArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_1_3() { return cGreaterThanSignKeyword_1_3; }
		
		//(=>({types::JvmInnerTypeReference.outer=current} '.') type=[types::JvmType|ValidID] (=>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>')?)*
		public Group getGroup_1_4() { return cGroup_1_4; }
		
		//=>({types::JvmInnerTypeReference.outer=current} '.')
		public Group getGroup_1_4_0() { return cGroup_1_4_0; }
		
		//{types::JvmInnerTypeReference.outer=current} '.'
		public Group getGroup_1_4_0_0() { return cGroup_1_4_0_0; }
		
		//{types::JvmInnerTypeReference.outer=current}
		public Action getJvmInnerTypeReferenceOuterAction_1_4_0_0_0() { return cJvmInnerTypeReferenceOuterAction_1_4_0_0_0; }
		
		//'.'
		public Keyword getFullStopKeyword_1_4_0_0_1() { return cFullStopKeyword_1_4_0_0_1; }
		
		//type=[types::JvmType|ValidID]
		public Assignment getTypeAssignment_1_4_1() { return cTypeAssignment_1_4_1; }
		
		//[types::JvmType|ValidID]
		public CrossReference getTypeJvmTypeCrossReference_1_4_1_0() { return cTypeJvmTypeCrossReference_1_4_1_0; }
		
		//ValidID
		public RuleCall getTypeJvmTypeValidIDParserRuleCall_1_4_1_0_1() { return cTypeJvmTypeValidIDParserRuleCall_1_4_1_0_1; }
		
		//(=>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>')?
		public Group getGroup_1_4_2() { return cGroup_1_4_2; }
		
		//=>'<'
		public Keyword getLessThanSignKeyword_1_4_2_0() { return cLessThanSignKeyword_1_4_2_0; }
		
		//arguments+=JvmArgumentTypeReference
		public Assignment getArgumentsAssignment_1_4_2_1() { return cArgumentsAssignment_1_4_2_1; }
		
		//JvmArgumentTypeReference
		public RuleCall getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0() { return cArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0; }
		
		//(',' arguments+=JvmArgumentTypeReference)*
		public Group getGroup_1_4_2_2() { return cGroup_1_4_2_2; }
		
		//','
		public Keyword getCommaKeyword_1_4_2_2_0() { return cCommaKeyword_1_4_2_2_0; }
		
		//arguments+=JvmArgumentTypeReference
		public Assignment getArgumentsAssignment_1_4_2_2_1() { return cArgumentsAssignment_1_4_2_2_1; }
		
		//JvmArgumentTypeReference
		public RuleCall getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0() { return cArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_1_4_2_3() { return cGreaterThanSignKeyword_1_4_2_3; }
	}
	public class FunctionIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.FunctionID");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cValidIDParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cOperatorsParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		///*** The following two rules are a workaround for a limitation in serialiation logic */
		//FunctionID:
		//    ValidID | Operators
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//ValidID | Operators
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ValidID
		public RuleCall getValidIDParserRuleCall_0() { return cValidIDParserRuleCall_0; }
		
		//Operators
		public RuleCall getOperatorsParserRuleCall_1() { return cOperatorsParserRuleCall_1; }
	}
	public class OperatorsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.Operators");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cOpMultiAssignParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cOpOrParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cOpAndParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cOpEqualityParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cOpCompareParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cOpOtherParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cOpMultiParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cOpUnaryParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		private final RuleCall cOpPostfixParserRuleCall_8 = (RuleCall)cAlternatives.eContents().get(8);
		
		//Operators:
		//      OpMultiAssign
		//    | OpOr
		//    | OpAnd
		//    | OpEquality
		//    | OpCompare
		//    | OpOther
		////    | OpAdd completely contained in OpUnary
		//    | OpMulti
		//    | OpUnary
		//    | OpPostfix
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//      OpMultiAssign
		//    | OpOr
		//    | OpAnd
		//    | OpEquality
		//    | OpCompare
		//    | OpOther
		////    | OpAdd completely contained in OpUnary
		//    | OpMulti
		//    | OpUnary
		//    | OpPostfix
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//OpMultiAssign
		public RuleCall getOpMultiAssignParserRuleCall_0() { return cOpMultiAssignParserRuleCall_0; }
		
		//OpOr
		public RuleCall getOpOrParserRuleCall_1() { return cOpOrParserRuleCall_1; }
		
		//OpAnd
		public RuleCall getOpAndParserRuleCall_2() { return cOpAndParserRuleCall_2; }
		
		//OpEquality
		public RuleCall getOpEqualityParserRuleCall_3() { return cOpEqualityParserRuleCall_3; }
		
		//OpCompare
		public RuleCall getOpCompareParserRuleCall_4() { return cOpCompareParserRuleCall_4; }
		
		//OpOther
		public RuleCall getOpOtherParserRuleCall_5() { return cOpOtherParserRuleCall_5; }
		
		//OpMulti
		public RuleCall getOpMultiParserRuleCall_6() { return cOpMultiParserRuleCall_6; }
		
		//OpUnary
		public RuleCall getOpUnaryParserRuleCall_7() { return cOpUnaryParserRuleCall_7; }
		
		//OpPostfix
		public RuleCall getOpPostfixParserRuleCall_8() { return cOpPostfixParserRuleCall_8; }
	}
	public class XtendEnumLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.XtendEnumLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsXAnnotationParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameValidIDParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//XtendEnumLiteral:
		//    annotations+=XAnnotation*
		//    name=ValidID
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=XAnnotation*
		//name=ValidID
		public Group getGroup() { return cGroup; }
		
		//annotations+=XAnnotation*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//XAnnotation
		public RuleCall getAnnotationsXAnnotationParserRuleCall_0_0() { return cAnnotationsXAnnotationParserRuleCall_0_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_1_0() { return cNameValidIDParserRuleCall_1_0; }
	}
	public class CommonModifierElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.CommonModifier");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cPublicKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cPrivateKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cProtectedKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cPackageKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cAbstractKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cStaticKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cDispatchKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cFinalKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cStrictfpKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		private final Keyword cNativeKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		private final Keyword cVolatileKeyword_10 = (Keyword)cAlternatives.eContents().get(10);
		private final Keyword cSynchronizedKeyword_11 = (Keyword)cAlternatives.eContents().get(11);
		private final Keyword cTransientKeyword_12 = (Keyword)cAlternatives.eContents().get(12);
		
		//CommonModifier:
		//        'public' | 'private' | 'protected' | 'package' | 'abstract' | 'static' | 'dispatch' | 'final'
		//        | 'strictfp' | 'native' |'volatile' | 'synchronized' | 'transient'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'public' | 'private' | 'protected' | 'package' | 'abstract' | 'static' | 'dispatch' | 'final'
		//| 'strictfp' | 'native' |'volatile' | 'synchronized' | 'transient'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'public'
		public Keyword getPublicKeyword_0() { return cPublicKeyword_0; }
		
		//'private'
		public Keyword getPrivateKeyword_1() { return cPrivateKeyword_1; }
		
		//'protected'
		public Keyword getProtectedKeyword_2() { return cProtectedKeyword_2; }
		
		//'package'
		public Keyword getPackageKeyword_3() { return cPackageKeyword_3; }
		
		//'abstract'
		public Keyword getAbstractKeyword_4() { return cAbstractKeyword_4; }
		
		//'static'
		public Keyword getStaticKeyword_5() { return cStaticKeyword_5; }
		
		//'dispatch'
		public Keyword getDispatchKeyword_6() { return cDispatchKeyword_6; }
		
		//'final'
		public Keyword getFinalKeyword_7() { return cFinalKeyword_7; }
		
		//'strictfp'
		public Keyword getStrictfpKeyword_8() { return cStrictfpKeyword_8; }
		
		//'native'
		public Keyword getNativeKeyword_9() { return cNativeKeyword_9; }
		
		//'volatile'
		public Keyword getVolatileKeyword_10() { return cVolatileKeyword_10; }
		
		//'synchronized'
		public Keyword getSynchronizedKeyword_11() { return cSynchronizedKeyword_11; }
		
		//'transient'
		public Keyword getTransientKeyword_12() { return cTransientKeyword_12; }
	}
	public class FieldModifierElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.FieldModifier");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cValKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cVarKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//FieldModifier:
		//        'val' | 'var'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'val' | 'var'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'val'
		public Keyword getValKeyword_0() { return cValKeyword_0; }
		
		//'var'
		public Keyword getVarKeyword_1() { return cVarKeyword_1; }
	}
	public class MethodModifierElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.MethodModifier");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cDefKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cOverrideKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//MethodModifier:
		//        'def' | 'override'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'def' | 'override'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'def'
		public Keyword getDefKeyword_0() { return cDefKeyword_0; }
		
		//'override'
		public Keyword getOverrideKeyword_1() { return cOverrideKeyword_1; }
	}
	public class CreateExtensionInfoElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.CreateExtensionInfo");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cCreateKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cNameValidIDParserRuleCall_1_0_0 = (RuleCall)cNameAssignment_1_0.eContents().get(0);
		private final Keyword cColonKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cCreateExpressionAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cCreateExpressionXExpressionParserRuleCall_2_0 = (RuleCall)cCreateExpressionAssignment_2.eContents().get(0);
		
		//CreateExtensionInfo:
		//    'create' (name=ValidID ':')? createExpression=XExpression
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'create' (name=ValidID ':')? createExpression=XExpression
		public Group getGroup() { return cGroup; }
		
		//'create'
		public Keyword getCreateKeyword_0() { return cCreateKeyword_0; }
		
		//(name=ValidID ':')?
		public Group getGroup_1() { return cGroup_1; }
		
		//name=ValidID
		public Assignment getNameAssignment_1_0() { return cNameAssignment_1_0; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_1_0_0() { return cNameValidIDParserRuleCall_1_0_0; }
		
		//':'
		public Keyword getColonKeyword_1_1() { return cColonKeyword_1_1; }
		
		//createExpression=XExpression
		public Assignment getCreateExpressionAssignment_2() { return cCreateExpressionAssignment_2; }
		
		//XExpression
		public RuleCall getCreateExpressionXExpressionParserRuleCall_2_0() { return cCreateExpressionXExpressionParserRuleCall_2_0; }
	}
	public class ValidIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.ValidID");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Keyword cCreateKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cAnnotationKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cAFTERKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cBEFOREKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cSEPARATORKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		
		//@Override
		//ValidID:
		//    ID | 'create' | 'annotation' | 'AFTER' | 'BEFORE' | 'SEPARATOR'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//ID | 'create' | 'annotation' | 'AFTER' | 'BEFORE' | 'SEPARATOR'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//'create'
		public Keyword getCreateKeyword_1() { return cCreateKeyword_1; }
		
		//'annotation'
		public Keyword getAnnotationKeyword_2() { return cAnnotationKeyword_2; }
		
		//'AFTER'
		public Keyword getAFTERKeyword_3() { return cAFTERKeyword_3; }
		
		//'BEFORE'
		public Keyword getBEFOREKeyword_4() { return cBEFOREKeyword_4; }
		
		//'SEPARATOR'
		public Keyword getSEPARATORKeyword_5() { return cSEPARATORKeyword_5; }
	}
	public class FeatureCallIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.FeatureCallID");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cInnerVarIDParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Keyword cExtensionKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//// For feature calls we add 'extension' since there are method such as 'isExtension' or 'getExtension' out there.
		//@Override
		//FeatureCallID:
		//    InnerVarID | 'extension'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//InnerVarID | 'extension'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//InnerVarID
		public RuleCall getInnerVarIDParserRuleCall_0() { return cInnerVarIDParserRuleCall_0; }
		
		//'extension'
		public Keyword getExtensionKeyword_1() { return cExtensionKeyword_1; }
	}
	public class InnerVarIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.InnerVarID");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Keyword cAbstractKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cAnnotationKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cClassKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cCreateKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cDefKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cDispatchKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cEnumKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cExtendsKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		private final Keyword cFinalKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		private final Keyword cImplementsKeyword_10 = (Keyword)cAlternatives.eContents().get(10);
		private final Keyword cImportKeyword_11 = (Keyword)cAlternatives.eContents().get(11);
		private final Keyword cInterfaceKeyword_12 = (Keyword)cAlternatives.eContents().get(12);
		private final Keyword cOverrideKeyword_13 = (Keyword)cAlternatives.eContents().get(13);
		private final Keyword cPackageKeyword_14 = (Keyword)cAlternatives.eContents().get(14);
		private final Keyword cPublicKeyword_15 = (Keyword)cAlternatives.eContents().get(15);
		private final Keyword cPrivateKeyword_16 = (Keyword)cAlternatives.eContents().get(16);
		private final Keyword cProtectedKeyword_17 = (Keyword)cAlternatives.eContents().get(17);
		private final Keyword cStaticKeyword_18 = (Keyword)cAlternatives.eContents().get(18);
		private final Keyword cThrowsKeyword_19 = (Keyword)cAlternatives.eContents().get(19);
		private final Keyword cStrictfpKeyword_20 = (Keyword)cAlternatives.eContents().get(20);
		private final Keyword cNativeKeyword_21 = (Keyword)cAlternatives.eContents().get(21);
		private final Keyword cVolatileKeyword_22 = (Keyword)cAlternatives.eContents().get(22);
		private final Keyword cSynchronizedKeyword_23 = (Keyword)cAlternatives.eContents().get(23);
		private final Keyword cTransientKeyword_24 = (Keyword)cAlternatives.eContents().get(24);
		private final Keyword cAFTERKeyword_25 = (Keyword)cAlternatives.eContents().get(25);
		private final Keyword cBEFOREKeyword_26 = (Keyword)cAlternatives.eContents().get(26);
		private final Keyword cSEPARATORKeyword_27 = (Keyword)cAlternatives.eContents().get(27);
		
		//InnerVarID:
		//    ID | 'abstract' | 'annotation' | 'class' | 'create' | 'def' | 'dispatch' | 'enum' | 'extends'
		//       | 'final' | 'implements' | 'import' | 'interface' | 'override' | 'package' | 'public' | 'private'
		//       | 'protected' | 'static' | 'throws' | 'strictfp' | 'native' | 'volatile' | 'synchronized' | 'transient'
		//       | 'AFTER' | 'BEFORE' | 'SEPARATOR'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//ID | 'abstract' | 'annotation' | 'class' | 'create' | 'def' | 'dispatch' | 'enum' | 'extends'
		//   | 'final' | 'implements' | 'import' | 'interface' | 'override' | 'package' | 'public' | 'private'
		//   | 'protected' | 'static' | 'throws' | 'strictfp' | 'native' | 'volatile' | 'synchronized' | 'transient'
		//   | 'AFTER' | 'BEFORE' | 'SEPARATOR'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//'abstract'
		public Keyword getAbstractKeyword_1() { return cAbstractKeyword_1; }
		
		//'annotation'
		public Keyword getAnnotationKeyword_2() { return cAnnotationKeyword_2; }
		
		//'class'
		public Keyword getClassKeyword_3() { return cClassKeyword_3; }
		
		//'create'
		public Keyword getCreateKeyword_4() { return cCreateKeyword_4; }
		
		//'def'
		public Keyword getDefKeyword_5() { return cDefKeyword_5; }
		
		//'dispatch'
		public Keyword getDispatchKeyword_6() { return cDispatchKeyword_6; }
		
		//'enum'
		public Keyword getEnumKeyword_7() { return cEnumKeyword_7; }
		
		//'extends'
		public Keyword getExtendsKeyword_8() { return cExtendsKeyword_8; }
		
		//'final'
		public Keyword getFinalKeyword_9() { return cFinalKeyword_9; }
		
		//'implements'
		public Keyword getImplementsKeyword_10() { return cImplementsKeyword_10; }
		
		//'import'
		public Keyword getImportKeyword_11() { return cImportKeyword_11; }
		
		//'interface'
		public Keyword getInterfaceKeyword_12() { return cInterfaceKeyword_12; }
		
		//'override'
		public Keyword getOverrideKeyword_13() { return cOverrideKeyword_13; }
		
		//'package'
		public Keyword getPackageKeyword_14() { return cPackageKeyword_14; }
		
		//'public'
		public Keyword getPublicKeyword_15() { return cPublicKeyword_15; }
		
		//'private'
		public Keyword getPrivateKeyword_16() { return cPrivateKeyword_16; }
		
		//'protected'
		public Keyword getProtectedKeyword_17() { return cProtectedKeyword_17; }
		
		//'static'
		public Keyword getStaticKeyword_18() { return cStaticKeyword_18; }
		
		//'throws'
		public Keyword getThrowsKeyword_19() { return cThrowsKeyword_19; }
		
		//'strictfp'
		public Keyword getStrictfpKeyword_20() { return cStrictfpKeyword_20; }
		
		//'native'
		public Keyword getNativeKeyword_21() { return cNativeKeyword_21; }
		
		//'volatile'
		public Keyword getVolatileKeyword_22() { return cVolatileKeyword_22; }
		
		//'synchronized'
		public Keyword getSynchronizedKeyword_23() { return cSynchronizedKeyword_23; }
		
		//'transient'
		public Keyword getTransientKeyword_24() { return cTransientKeyword_24; }
		
		//'AFTER'
		public Keyword getAFTERKeyword_25() { return cAFTERKeyword_25; }
		
		//'BEFORE'
		public Keyword getBEFOREKeyword_26() { return cBEFOREKeyword_26; }
		
		//'SEPARATOR'
		public Keyword getSEPARATORKeyword_27() { return cSEPARATORKeyword_27; }
	}
	public class ParameterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.Parameter");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsXAnnotationParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cExtensionAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final Keyword cExtensionExtensionKeyword_1_0_0 = (Keyword)cExtensionAssignment_1_0.eContents().get(0);
		private final Assignment cAnnotationsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cAnnotationsXAnnotationParserRuleCall_1_1_0 = (RuleCall)cAnnotationsAssignment_1_1.eContents().get(0);
		private final Assignment cParameterTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cParameterTypeJvmTypeReferenceParserRuleCall_2_0 = (RuleCall)cParameterTypeAssignment_2.eContents().get(0);
		private final Assignment cVarArgAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final Keyword cVarArgFullStopFullStopFullStopKeyword_3_0 = (Keyword)cVarArgAssignment_3.eContents().get(0);
		private final Assignment cNameAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cNameValidIDParserRuleCall_4_0 = (RuleCall)cNameAssignment_4.eContents().get(0);
		
		//Parameter returns XtendParameter:
		//    annotations+=XAnnotation* (extension?='extension' annotations+=XAnnotation*)?
		//    parameterType=JvmTypeReference varArg?='...'? name=ValidID;
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=XAnnotation* (extension?='extension' annotations+=XAnnotation*)?
		//parameterType=JvmTypeReference varArg?='...'? name=ValidID
		public Group getGroup() { return cGroup; }
		
		//annotations+=XAnnotation*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//XAnnotation
		public RuleCall getAnnotationsXAnnotationParserRuleCall_0_0() { return cAnnotationsXAnnotationParserRuleCall_0_0; }
		
		//(extension?='extension' annotations+=XAnnotation*)?
		public Group getGroup_1() { return cGroup_1; }
		
		//extension?='extension'
		public Assignment getExtensionAssignment_1_0() { return cExtensionAssignment_1_0; }
		
		//'extension'
		public Keyword getExtensionExtensionKeyword_1_0_0() { return cExtensionExtensionKeyword_1_0_0; }
		
		//annotations+=XAnnotation*
		public Assignment getAnnotationsAssignment_1_1() { return cAnnotationsAssignment_1_1; }
		
		//XAnnotation
		public RuleCall getAnnotationsXAnnotationParserRuleCall_1_1_0() { return cAnnotationsXAnnotationParserRuleCall_1_1_0; }
		
		//parameterType=JvmTypeReference
		public Assignment getParameterTypeAssignment_2() { return cParameterTypeAssignment_2; }
		
		//JvmTypeReference
		public RuleCall getParameterTypeJvmTypeReferenceParserRuleCall_2_0() { return cParameterTypeJvmTypeReferenceParserRuleCall_2_0; }
		
		//varArg?='...'?
		public Assignment getVarArgAssignment_3() { return cVarArgAssignment_3; }
		
		//'...'
		public Keyword getVarArgFullStopFullStopFullStopKeyword_3_0() { return cVarArgFullStopFullStopFullStopKeyword_3_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_4() { return cNameAssignment_4; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_4_0() { return cNameValidIDParserRuleCall_4_0; }
	}
	public class XAssignmentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.XAssignment");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cXAssignmentAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Assignment cFeatureAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final CrossReference cFeatureJvmIdentifiableElementCrossReference_0_1_0 = (CrossReference)cFeatureAssignment_0_1.eContents().get(0);
		private final RuleCall cFeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_0_1_0_1 = (RuleCall)cFeatureJvmIdentifiableElementCrossReference_0_1_0.eContents().get(1);
		private final RuleCall cOpSingleAssignParserRuleCall_0_2 = (RuleCall)cGroup_0.eContents().get(2);
		private final Assignment cValueAssignment_0_3 = (Assignment)cGroup_0.eContents().get(3);
		private final RuleCall cValueXAssignmentParserRuleCall_0_3_0 = (RuleCall)cValueAssignment_0_3.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final RuleCall cXConditionalExpressionParserRuleCall_1_0 = (RuleCall)cGroup_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Group cGroup_1_1_0 = (Group)cGroup_1_1.eContents().get(0);
		private final Group cGroup_1_1_0_0 = (Group)cGroup_1_1_0.eContents().get(0);
		private final Action cXBinaryOperationLeftOperandAction_1_1_0_0_0 = (Action)cGroup_1_1_0_0.eContents().get(0);
		private final Assignment cFeatureAssignment_1_1_0_0_1 = (Assignment)cGroup_1_1_0_0.eContents().get(1);
		private final CrossReference cFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0 = (CrossReference)cFeatureAssignment_1_1_0_0_1.eContents().get(0);
		private final RuleCall cFeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1 = (RuleCall)cFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0.eContents().get(1);
		private final Assignment cRightOperandAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cRightOperandXAssignmentParserRuleCall_1_1_1_0 = (RuleCall)cRightOperandAssignment_1_1_1.eContents().get(0);
		
		//@Override
		//XAssignment returns xbase::XExpression :
		//    {xbase::XAssignment} feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign value=XAssignment |
		//    XConditionalExpression (
		//        =>({xbase::XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMultiAssign]) rightOperand=XAssignment
		//    )?;
		@Override public ParserRule getRule() { return rule; }
		
		//{xbase::XAssignment} feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign value=XAssignment |
		//XConditionalExpression (
		//    =>({xbase::XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMultiAssign]) rightOperand=XAssignment
		//)?
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//{xbase::XAssignment} feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign value=XAssignment
		public Group getGroup_0() { return cGroup_0; }
		
		//{xbase::XAssignment}
		public Action getXAssignmentAction_0_0() { return cXAssignmentAction_0_0; }
		
		//feature=[types::JvmIdentifiableElement|FeatureCallID]
		public Assignment getFeatureAssignment_0_1() { return cFeatureAssignment_0_1; }
		
		//[types::JvmIdentifiableElement|FeatureCallID]
		public CrossReference getFeatureJvmIdentifiableElementCrossReference_0_1_0() { return cFeatureJvmIdentifiableElementCrossReference_0_1_0; }
		
		//FeatureCallID
		public RuleCall getFeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_0_1_0_1() { return cFeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_0_1_0_1; }
		
		//OpSingleAssign
		public RuleCall getOpSingleAssignParserRuleCall_0_2() { return cOpSingleAssignParserRuleCall_0_2; }
		
		//value=XAssignment
		public Assignment getValueAssignment_0_3() { return cValueAssignment_0_3; }
		
		//XAssignment
		public RuleCall getValueXAssignmentParserRuleCall_0_3_0() { return cValueXAssignmentParserRuleCall_0_3_0; }
		
		//XConditionalExpression (
		//    =>({xbase::XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMultiAssign]) rightOperand=XAssignment
		//)?
		public Group getGroup_1() { return cGroup_1; }
		
		//XConditionalExpression
		public RuleCall getXConditionalExpressionParserRuleCall_1_0() { return cXConditionalExpressionParserRuleCall_1_0; }
		
		//(
		//       =>({xbase::XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMultiAssign]) rightOperand=XAssignment
		//   )?
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//=>({xbase::XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMultiAssign])
		public Group getGroup_1_1_0() { return cGroup_1_1_0; }
		
		//{xbase::XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMultiAssign]
		public Group getGroup_1_1_0_0() { return cGroup_1_1_0_0; }
		
		//{xbase::XBinaryOperation.leftOperand=current}
		public Action getXBinaryOperationLeftOperandAction_1_1_0_0_0() { return cXBinaryOperationLeftOperandAction_1_1_0_0_0; }
		
		//feature=[types::JvmIdentifiableElement|OpMultiAssign]
		public Assignment getFeatureAssignment_1_1_0_0_1() { return cFeatureAssignment_1_1_0_0_1; }
		
		//[types::JvmIdentifiableElement|OpMultiAssign]
		public CrossReference getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0() { return cFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0; }
		
		//OpMultiAssign
		public RuleCall getFeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1() { return cFeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1; }
		
		//rightOperand=XAssignment
		public Assignment getRightOperandAssignment_1_1_1() { return cRightOperandAssignment_1_1_1; }
		
		//XAssignment
		public RuleCall getRightOperandXAssignmentParserRuleCall_1_1_1_0() { return cRightOperandXAssignmentParserRuleCall_1_1_1_0; }
	}
	public class XConditionalExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.XConditionalExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cXOrExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cXIfExpressionIfAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cConditionalExpressionAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final Keyword cConditionalExpressionQuestionMarkKeyword_1_0_0_1_0 = (Keyword)cConditionalExpressionAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cThenAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cThenXExpressionParserRuleCall_1_1_0 = (RuleCall)cThenAssignment_1_1.eContents().get(0);
		private final Group cGroup_1_2 = (Group)cGroup_1.eContents().get(2);
		private final Keyword cColonKeyword_1_2_0 = (Keyword)cGroup_1_2.eContents().get(0);
		private final Assignment cElseAssignment_1_2_1 = (Assignment)cGroup_1_2.eContents().get(1);
		private final RuleCall cElseXExpressionParserRuleCall_1_2_1_0 = (RuleCall)cElseAssignment_1_2_1.eContents().get(0);
		
		//XConditionalExpression returns xbase::XExpression :
		//    XOrExpression (
		//        // The java grammar does only allow other XConditionalExpression after the colon, but we can be more relaxed
		//        ->({xbase::XIfExpression.if=current} conditionalExpression?='?') then=XExpression (->':' else=XExpression)?
		//    )?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//XOrExpression (
		//    // The java grammar does only allow other XConditionalExpression after the colon, but we can be more relaxed
		//    ->({xbase::XIfExpression.if=current} conditionalExpression?='?') then=XExpression (->':' else=XExpression)?
		//)?
		public Group getGroup() { return cGroup; }
		
		//XOrExpression
		public RuleCall getXOrExpressionParserRuleCall_0() { return cXOrExpressionParserRuleCall_0; }
		
		//(
		//       // The java grammar does only allow other XConditionalExpression after the colon, but we can be more relaxed
		//       ->({xbase::XIfExpression.if=current} conditionalExpression?='?') then=XExpression (->':' else=XExpression)?
		//   )?
		public Group getGroup_1() { return cGroup_1; }
		
		//// The java grammar does only allow other XConditionalExpression after the colon, but we can be more relaxed
		//->({xbase::XIfExpression.if=current} conditionalExpression?='?')
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{xbase::XIfExpression.if=current} conditionalExpression?='?'
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{xbase::XIfExpression.if=current}
		public Action getXIfExpressionIfAction_1_0_0_0() { return cXIfExpressionIfAction_1_0_0_0; }
		
		//conditionalExpression?='?'
		public Assignment getConditionalExpressionAssignment_1_0_0_1() { return cConditionalExpressionAssignment_1_0_0_1; }
		
		//'?'
		public Keyword getConditionalExpressionQuestionMarkKeyword_1_0_0_1_0() { return cConditionalExpressionQuestionMarkKeyword_1_0_0_1_0; }
		
		//then=XExpression
		public Assignment getThenAssignment_1_1() { return cThenAssignment_1_1; }
		
		//XExpression
		public RuleCall getThenXExpressionParserRuleCall_1_1_0() { return cThenXExpressionParserRuleCall_1_1_0; }
		
		//(->':' else=XExpression)?
		public Group getGroup_1_2() { return cGroup_1_2; }
		
		//->':'
		public Keyword getColonKeyword_1_2_0() { return cColonKeyword_1_2_0; }
		
		//else=XExpression
		public Assignment getElseAssignment_1_2_1() { return cElseAssignment_1_2_1; }
		
		//XExpression
		public RuleCall getElseXExpressionParserRuleCall_1_2_1_0() { return cElseXExpressionParserRuleCall_1_2_1_0; }
	}
	public class XTryCatchFinallyExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.XTryCatchFinallyExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXTryCatchFinallyExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cTryKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2_0_0 = (Keyword)cGroup_2_0.eContents().get(0);
		private final Assignment cResourcesAssignment_2_0_1 = (Assignment)cGroup_2_0.eContents().get(1);
		private final RuleCall cResourcesInitializedVariableDeclarationParserRuleCall_2_0_1_0 = (RuleCall)cResourcesAssignment_2_0_1.eContents().get(0);
		private final Group cGroup_2_0_2 = (Group)cGroup_2_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_2_0_2_0 = (Keyword)cGroup_2_0_2.eContents().get(0);
		private final Assignment cResourcesAssignment_2_0_2_1 = (Assignment)cGroup_2_0_2.eContents().get(1);
		private final RuleCall cResourcesInitializedVariableDeclarationParserRuleCall_2_0_2_1_0 = (RuleCall)cResourcesAssignment_2_0_2_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_2_0_3 = (Keyword)cGroup_2_0.eContents().get(3);
		private final Keyword cRightParenthesisKeyword_2_0_4 = (Keyword)cGroup_2_0.eContents().get(4);
		private final Assignment cExpressionAssignment_2_0_5 = (Assignment)cGroup_2_0.eContents().get(5);
		private final RuleCall cExpressionXExpressionParserRuleCall_2_0_5_0 = (RuleCall)cExpressionAssignment_2_0_5.eContents().get(0);
		private final Group cGroup_2_0_6 = (Group)cGroup_2_0.eContents().get(6);
		private final Alternatives cAlternatives_2_0_6_0 = (Alternatives)cGroup_2_0_6.eContents().get(0);
		private final Group cGroup_2_0_6_0_0 = (Group)cAlternatives_2_0_6_0.eContents().get(0);
		private final Assignment cCatchClausesAssignment_2_0_6_0_0_0 = (Assignment)cGroup_2_0_6_0_0.eContents().get(0);
		private final RuleCall cCatchClausesXCatchClauseParserRuleCall_2_0_6_0_0_0_0 = (RuleCall)cCatchClausesAssignment_2_0_6_0_0_0.eContents().get(0);
		private final Group cGroup_2_0_6_0_0_1 = (Group)cGroup_2_0_6_0_0.eContents().get(1);
		private final Keyword cFinallyKeyword_2_0_6_0_0_1_0 = (Keyword)cGroup_2_0_6_0_0_1.eContents().get(0);
		private final Assignment cFinallyExpressionAssignment_2_0_6_0_0_1_1 = (Assignment)cGroup_2_0_6_0_0_1.eContents().get(1);
		private final RuleCall cFinallyExpressionXExpressionParserRuleCall_2_0_6_0_0_1_1_0 = (RuleCall)cFinallyExpressionAssignment_2_0_6_0_0_1_1.eContents().get(0);
		private final Group cGroup_2_0_6_0_1 = (Group)cAlternatives_2_0_6_0.eContents().get(1);
		private final Keyword cFinallyKeyword_2_0_6_0_1_0 = (Keyword)cGroup_2_0_6_0_1.eContents().get(0);
		private final Assignment cFinallyExpressionAssignment_2_0_6_0_1_1 = (Assignment)cGroup_2_0_6_0_1.eContents().get(1);
		private final RuleCall cFinallyExpressionXExpressionParserRuleCall_2_0_6_0_1_1_0 = (RuleCall)cFinallyExpressionAssignment_2_0_6_0_1_1.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cAlternatives_2.eContents().get(1);
		private final Assignment cExpressionAssignment_2_1_0 = (Assignment)cGroup_2_1.eContents().get(0);
		private final RuleCall cExpressionXExpressionParserRuleCall_2_1_0_0 = (RuleCall)cExpressionAssignment_2_1_0.eContents().get(0);
		private final Alternatives cAlternatives_2_1_1 = (Alternatives)cGroup_2_1.eContents().get(1);
		private final Group cGroup_2_1_1_0 = (Group)cAlternatives_2_1_1.eContents().get(0);
		private final Assignment cCatchClausesAssignment_2_1_1_0_0 = (Assignment)cGroup_2_1_1_0.eContents().get(0);
		private final RuleCall cCatchClausesXCatchClauseParserRuleCall_2_1_1_0_0_0 = (RuleCall)cCatchClausesAssignment_2_1_1_0_0.eContents().get(0);
		private final Group cGroup_2_1_1_0_1 = (Group)cGroup_2_1_1_0.eContents().get(1);
		private final Keyword cFinallyKeyword_2_1_1_0_1_0 = (Keyword)cGroup_2_1_1_0_1.eContents().get(0);
		private final Assignment cFinallyExpressionAssignment_2_1_1_0_1_1 = (Assignment)cGroup_2_1_1_0_1.eContents().get(1);
		private final RuleCall cFinallyExpressionXExpressionParserRuleCall_2_1_1_0_1_1_0 = (RuleCall)cFinallyExpressionAssignment_2_1_1_0_1_1.eContents().get(0);
		private final Group cGroup_2_1_1_1 = (Group)cAlternatives_2_1_1.eContents().get(1);
		private final Keyword cFinallyKeyword_2_1_1_1_0 = (Keyword)cGroup_2_1_1_1.eContents().get(0);
		private final Assignment cFinallyExpressionAssignment_2_1_1_1_1 = (Assignment)cGroup_2_1_1_1.eContents().get(1);
		private final RuleCall cFinallyExpressionXExpressionParserRuleCall_2_1_1_1_1_0 = (RuleCall)cFinallyExpressionAssignment_2_1_1_1_1.eContents().get(0);
		
		//@Override
		//XTryCatchFinallyExpression returns xbase::XExpression:
		//    {xbase::XTryCatchFinallyExpression}
		//    'try' (
		//        '(' resources+=InitializedVariableDeclaration (';' resources+=InitializedVariableDeclaration)* ';'? ')'
		//        expression=XExpression
		//        ->(
		//            catchClauses+=XCatchClause+
		//            (=>'finally' finallyExpression=XExpression)?
		//        |    'finally' finallyExpression=XExpression
		//        )?
		//    |
		//        expression=XExpression
		//        (
		//            catchClauses+=XCatchClause+
		//            (=>'finally' finallyExpression=XExpression)?
		//        |    'finally' finallyExpression=XExpression
		//        )
		//    )
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{xbase::XTryCatchFinallyExpression}
		//'try' (
		//    '(' resources+=InitializedVariableDeclaration (';' resources+=InitializedVariableDeclaration)* ';'? ')'
		//    expression=XExpression
		//    ->(
		//        catchClauses+=XCatchClause+
		//        (=>'finally' finallyExpression=XExpression)?
		//    |    'finally' finallyExpression=XExpression
		//    )?
		//|
		//    expression=XExpression
		//    (
		//        catchClauses+=XCatchClause+
		//        (=>'finally' finallyExpression=XExpression)?
		//    |    'finally' finallyExpression=XExpression
		//    )
		//)
		public Group getGroup() { return cGroup; }
		
		//{xbase::XTryCatchFinallyExpression}
		public Action getXTryCatchFinallyExpressionAction_0() { return cXTryCatchFinallyExpressionAction_0; }
		
		//'try'
		public Keyword getTryKeyword_1() { return cTryKeyword_1; }
		
		//(
		//       '(' resources+=InitializedVariableDeclaration (';' resources+=InitializedVariableDeclaration)* ';'? ')'
		//       expression=XExpression
		//       ->(
		//           catchClauses+=XCatchClause+
		//           (=>'finally' finallyExpression=XExpression)?
		//       |    'finally' finallyExpression=XExpression
		//       )?
		//   |
		//       expression=XExpression
		//       (
		//           catchClauses+=XCatchClause+
		//           (=>'finally' finallyExpression=XExpression)?
		//       |    'finally' finallyExpression=XExpression
		//       )
		//   )
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//'(' resources+=InitializedVariableDeclaration (';' resources+=InitializedVariableDeclaration)* ';'? ')'
		//expression=XExpression
		//->(
		//    catchClauses+=XCatchClause+
		//    (=>'finally' finallyExpression=XExpression)?
		//|    'finally' finallyExpression=XExpression
		//)?
		public Group getGroup_2_0() { return cGroup_2_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2_0_0() { return cLeftParenthesisKeyword_2_0_0; }
		
		//resources+=InitializedVariableDeclaration
		public Assignment getResourcesAssignment_2_0_1() { return cResourcesAssignment_2_0_1; }
		
		//InitializedVariableDeclaration
		public RuleCall getResourcesInitializedVariableDeclarationParserRuleCall_2_0_1_0() { return cResourcesInitializedVariableDeclarationParserRuleCall_2_0_1_0; }
		
		//(';' resources+=InitializedVariableDeclaration)*
		public Group getGroup_2_0_2() { return cGroup_2_0_2; }
		
		//';'
		public Keyword getSemicolonKeyword_2_0_2_0() { return cSemicolonKeyword_2_0_2_0; }
		
		//resources+=InitializedVariableDeclaration
		public Assignment getResourcesAssignment_2_0_2_1() { return cResourcesAssignment_2_0_2_1; }
		
		//InitializedVariableDeclaration
		public RuleCall getResourcesInitializedVariableDeclarationParserRuleCall_2_0_2_1_0() { return cResourcesInitializedVariableDeclarationParserRuleCall_2_0_2_1_0; }
		
		//';'?
		public Keyword getSemicolonKeyword_2_0_3() { return cSemicolonKeyword_2_0_3; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2_0_4() { return cRightParenthesisKeyword_2_0_4; }
		
		//expression=XExpression
		public Assignment getExpressionAssignment_2_0_5() { return cExpressionAssignment_2_0_5; }
		
		//XExpression
		public RuleCall getExpressionXExpressionParserRuleCall_2_0_5_0() { return cExpressionXExpressionParserRuleCall_2_0_5_0; }
		
		//->(
		//    catchClauses+=XCatchClause+
		//    (=>'finally' finallyExpression=XExpression)?
		//|    'finally' finallyExpression=XExpression
		//)?
		public Group getGroup_2_0_6() { return cGroup_2_0_6; }
		
		//    catchClauses+=XCatchClause+
		//    (=>'finally' finallyExpression=XExpression)?
		//|    'finally' finallyExpression=XExpression
		public Alternatives getAlternatives_2_0_6_0() { return cAlternatives_2_0_6_0; }
		
		//catchClauses+=XCatchClause+
		//(=>'finally' finallyExpression=XExpression)?
		public Group getGroup_2_0_6_0_0() { return cGroup_2_0_6_0_0; }
		
		//catchClauses+=XCatchClause+
		public Assignment getCatchClausesAssignment_2_0_6_0_0_0() { return cCatchClausesAssignment_2_0_6_0_0_0; }
		
		//XCatchClause
		public RuleCall getCatchClausesXCatchClauseParserRuleCall_2_0_6_0_0_0_0() { return cCatchClausesXCatchClauseParserRuleCall_2_0_6_0_0_0_0; }
		
		//(=>'finally' finallyExpression=XExpression)?
		public Group getGroup_2_0_6_0_0_1() { return cGroup_2_0_6_0_0_1; }
		
		//=>'finally'
		public Keyword getFinallyKeyword_2_0_6_0_0_1_0() { return cFinallyKeyword_2_0_6_0_0_1_0; }
		
		//finallyExpression=XExpression
		public Assignment getFinallyExpressionAssignment_2_0_6_0_0_1_1() { return cFinallyExpressionAssignment_2_0_6_0_0_1_1; }
		
		//XExpression
		public RuleCall getFinallyExpressionXExpressionParserRuleCall_2_0_6_0_0_1_1_0() { return cFinallyExpressionXExpressionParserRuleCall_2_0_6_0_0_1_1_0; }
		
		//'finally' finallyExpression=XExpression
		public Group getGroup_2_0_6_0_1() { return cGroup_2_0_6_0_1; }
		
		//'finally'
		public Keyword getFinallyKeyword_2_0_6_0_1_0() { return cFinallyKeyword_2_0_6_0_1_0; }
		
		//finallyExpression=XExpression
		public Assignment getFinallyExpressionAssignment_2_0_6_0_1_1() { return cFinallyExpressionAssignment_2_0_6_0_1_1; }
		
		//XExpression
		public RuleCall getFinallyExpressionXExpressionParserRuleCall_2_0_6_0_1_1_0() { return cFinallyExpressionXExpressionParserRuleCall_2_0_6_0_1_1_0; }
		
		//expression=XExpression
		//(
		//    catchClauses+=XCatchClause+
		//    (=>'finally' finallyExpression=XExpression)?
		//|    'finally' finallyExpression=XExpression
		//)
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//expression=XExpression
		public Assignment getExpressionAssignment_2_1_0() { return cExpressionAssignment_2_1_0; }
		
		//XExpression
		public RuleCall getExpressionXExpressionParserRuleCall_2_1_0_0() { return cExpressionXExpressionParserRuleCall_2_1_0_0; }
		
		//(
		//    catchClauses+=XCatchClause+
		//    (=>'finally' finallyExpression=XExpression)?
		//|    'finally' finallyExpression=XExpression
		//)
		public Alternatives getAlternatives_2_1_1() { return cAlternatives_2_1_1; }
		
		//catchClauses+=XCatchClause+
		//(=>'finally' finallyExpression=XExpression)?
		public Group getGroup_2_1_1_0() { return cGroup_2_1_1_0; }
		
		//catchClauses+=XCatchClause+
		public Assignment getCatchClausesAssignment_2_1_1_0_0() { return cCatchClausesAssignment_2_1_1_0_0; }
		
		//XCatchClause
		public RuleCall getCatchClausesXCatchClauseParserRuleCall_2_1_1_0_0_0() { return cCatchClausesXCatchClauseParserRuleCall_2_1_1_0_0_0; }
		
		//(=>'finally' finallyExpression=XExpression)?
		public Group getGroup_2_1_1_0_1() { return cGroup_2_1_1_0_1; }
		
		//=>'finally'
		public Keyword getFinallyKeyword_2_1_1_0_1_0() { return cFinallyKeyword_2_1_1_0_1_0; }
		
		//finallyExpression=XExpression
		public Assignment getFinallyExpressionAssignment_2_1_1_0_1_1() { return cFinallyExpressionAssignment_2_1_1_0_1_1; }
		
		//XExpression
		public RuleCall getFinallyExpressionXExpressionParserRuleCall_2_1_1_0_1_1_0() { return cFinallyExpressionXExpressionParserRuleCall_2_1_1_0_1_1_0; }
		
		//'finally' finallyExpression=XExpression
		public Group getGroup_2_1_1_1() { return cGroup_2_1_1_1; }
		
		//'finally'
		public Keyword getFinallyKeyword_2_1_1_1_0() { return cFinallyKeyword_2_1_1_1_0; }
		
		//finallyExpression=XExpression
		public Assignment getFinallyExpressionAssignment_2_1_1_1_1() { return cFinallyExpressionAssignment_2_1_1_1_1; }
		
		//XExpression
		public RuleCall getFinallyExpressionXExpressionParserRuleCall_2_1_1_1_1_0() { return cFinallyExpressionXExpressionParserRuleCall_2_1_1_1_1_0; }
	}
	public class XVariableDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.XVariableDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cGroup_0.eContents().get(0);
		private final Action cXtendVariableDeclarationAction_0_0_0 = (Action)cGroup_0_0.eContents().get(0);
		private final RuleCall cVariableModifierParserRuleCall_0_0_1 = (RuleCall)cGroup_0_0.eContents().get(1);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Assignment cTypeAssignment_1_0_0_0 = (Assignment)cGroup_1_0_0.eContents().get(0);
		private final RuleCall cTypeJvmTypeReferenceParserRuleCall_1_0_0_0_0 = (RuleCall)cTypeAssignment_1_0_0_0.eContents().get(0);
		private final Assignment cNameAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cNameInnerVarIDParserRuleCall_1_0_0_1_0 = (RuleCall)cNameAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cNameAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cNameInnerVarIDParserRuleCall_1_1_0 = (RuleCall)cNameAssignment_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cEqualsSignKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cRightAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cRightXExpressionParserRuleCall_2_1_0 = (RuleCall)cRightAssignment_2_1.eContents().get(0);
		
		//@Override
		//XVariableDeclaration returns xbase::XExpression:
		//    =>({XtendVariableDeclaration} VariableModifier)
		//    (=>(type=JvmTypeReference name=InnerVarID) | name=InnerVarID) ('=' right=XExpression)?;
		@Override public ParserRule getRule() { return rule; }
		
		//=>({XtendVariableDeclaration} VariableModifier)
		//(=>(type=JvmTypeReference name=InnerVarID) | name=InnerVarID) ('=' right=XExpression)?
		public Group getGroup() { return cGroup; }
		
		//=>({XtendVariableDeclaration} VariableModifier)
		public Group getGroup_0() { return cGroup_0; }
		
		//{XtendVariableDeclaration} VariableModifier
		public Group getGroup_0_0() { return cGroup_0_0; }
		
		//{XtendVariableDeclaration}
		public Action getXtendVariableDeclarationAction_0_0_0() { return cXtendVariableDeclarationAction_0_0_0; }
		
		//VariableModifier
		public RuleCall getVariableModifierParserRuleCall_0_0_1() { return cVariableModifierParserRuleCall_0_0_1; }
		
		//(=>(type=JvmTypeReference name=InnerVarID) | name=InnerVarID)
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//=>(type=JvmTypeReference name=InnerVarID)
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//type=JvmTypeReference name=InnerVarID
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//type=JvmTypeReference
		public Assignment getTypeAssignment_1_0_0_0() { return cTypeAssignment_1_0_0_0; }
		
		//JvmTypeReference
		public RuleCall getTypeJvmTypeReferenceParserRuleCall_1_0_0_0_0() { return cTypeJvmTypeReferenceParserRuleCall_1_0_0_0_0; }
		
		//name=InnerVarID
		public Assignment getNameAssignment_1_0_0_1() { return cNameAssignment_1_0_0_1; }
		
		//InnerVarID
		public RuleCall getNameInnerVarIDParserRuleCall_1_0_0_1_0() { return cNameInnerVarIDParserRuleCall_1_0_0_1_0; }
		
		//name=InnerVarID
		public Assignment getNameAssignment_1_1() { return cNameAssignment_1_1; }
		
		//InnerVarID
		public RuleCall getNameInnerVarIDParserRuleCall_1_1_0() { return cNameInnerVarIDParserRuleCall_1_1_0; }
		
		//('=' right=XExpression)?
		public Group getGroup_2() { return cGroup_2; }
		
		//'='
		public Keyword getEqualsSignKeyword_2_0() { return cEqualsSignKeyword_2_0; }
		
		//right=XExpression
		public Assignment getRightAssignment_2_1() { return cRightAssignment_2_1; }
		
		//XExpression
		public RuleCall getRightXExpressionParserRuleCall_2_1_0() { return cRightXExpressionParserRuleCall_2_1_0; }
	}
	public class InitializedVariableDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.InitializedVariableDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXtendVariableDeclarationAction_0 = (Action)cGroup.eContents().get(0);
		private final RuleCall cVariableModifierParserRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Group cGroup_2_0_0 = (Group)cGroup_2_0.eContents().get(0);
		private final Assignment cTypeAssignment_2_0_0_0 = (Assignment)cGroup_2_0_0.eContents().get(0);
		private final RuleCall cTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0 = (RuleCall)cTypeAssignment_2_0_0_0.eContents().get(0);
		private final Assignment cNameAssignment_2_0_0_1 = (Assignment)cGroup_2_0_0.eContents().get(1);
		private final RuleCall cNameInnerVarIDParserRuleCall_2_0_0_1_0 = (RuleCall)cNameAssignment_2_0_0_1.eContents().get(0);
		private final Assignment cNameAssignment_2_1 = (Assignment)cAlternatives_2.eContents().get(1);
		private final RuleCall cNameInnerVarIDParserRuleCall_2_1_0 = (RuleCall)cNameAssignment_2_1.eContents().get(0);
		private final Keyword cEqualsSignKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cRightAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cRightXExpressionParserRuleCall_4_0 = (RuleCall)cRightAssignment_4.eContents().get(0);
		
		//InitializedVariableDeclaration returns XtendVariableDeclaration:
		//    {XtendVariableDeclaration}
		//    VariableModifier
		//    (=>(type=JvmTypeReference name=InnerVarID) | name=InnerVarID) '=' right=XExpression
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{XtendVariableDeclaration}
		//VariableModifier
		//(=>(type=JvmTypeReference name=InnerVarID) | name=InnerVarID) '=' right=XExpression
		public Group getGroup() { return cGroup; }
		
		//{XtendVariableDeclaration}
		public Action getXtendVariableDeclarationAction_0() { return cXtendVariableDeclarationAction_0; }
		
		//VariableModifier
		public RuleCall getVariableModifierParserRuleCall_1() { return cVariableModifierParserRuleCall_1; }
		
		//(=>(type=JvmTypeReference name=InnerVarID) | name=InnerVarID)
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//=>(type=JvmTypeReference name=InnerVarID)
		public Group getGroup_2_0() { return cGroup_2_0; }
		
		//type=JvmTypeReference name=InnerVarID
		public Group getGroup_2_0_0() { return cGroup_2_0_0; }
		
		//type=JvmTypeReference
		public Assignment getTypeAssignment_2_0_0_0() { return cTypeAssignment_2_0_0_0; }
		
		//JvmTypeReference
		public RuleCall getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0() { return cTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0; }
		
		//name=InnerVarID
		public Assignment getNameAssignment_2_0_0_1() { return cNameAssignment_2_0_0_1; }
		
		//InnerVarID
		public RuleCall getNameInnerVarIDParserRuleCall_2_0_0_1_0() { return cNameInnerVarIDParserRuleCall_2_0_0_1_0; }
		
		//name=InnerVarID
		public Assignment getNameAssignment_2_1() { return cNameAssignment_2_1; }
		
		//InnerVarID
		public RuleCall getNameInnerVarIDParserRuleCall_2_1_0() { return cNameInnerVarIDParserRuleCall_2_1_0; }
		
		//'='
		public Keyword getEqualsSignKeyword_3() { return cEqualsSignKeyword_3; }
		
		//right=XExpression
		public Assignment getRightAssignment_4() { return cRightAssignment_4; }
		
		//XExpression
		public RuleCall getRightXExpressionParserRuleCall_4_0() { return cRightXExpressionParserRuleCall_4_0; }
	}
	public class VariableModifierElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.VariableModifier");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(0);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Alternatives cAlternatives_0_0 = (Alternatives)cGroup_0.eContents().get(0);
		private final Assignment cWriteableAssignment_0_0_0 = (Assignment)cAlternatives_0_0.eContents().get(0);
		private final Keyword cWriteableVarKeyword_0_0_0_0 = (Keyword)cWriteableAssignment_0_0_0.eContents().get(0);
		private final Keyword cValKeyword_0_0_1 = (Keyword)cAlternatives_0_0.eContents().get(1);
		private final Assignment cExtensionAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final Keyword cExtensionExtensionKeyword_0_1_0 = (Keyword)cExtensionAssignment_0_1.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Assignment cExtensionAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final Keyword cExtensionExtensionKeyword_1_0_0 = (Keyword)cExtensionAssignment_1_0.eContents().get(0);
		private final Alternatives cAlternatives_1_1 = (Alternatives)cGroup_1.eContents().get(1);
		private final Assignment cWriteableAssignment_1_1_0 = (Assignment)cAlternatives_1_1.eContents().get(0);
		private final Keyword cWriteableVarKeyword_1_1_0_0 = (Keyword)cWriteableAssignment_1_1_0.eContents().get(0);
		private final Keyword cValKeyword_1_1_1 = (Keyword)cAlternatives_1_1.eContents().get(1);
		
		//fragment VariableModifier *:
		//      (writeable?='var'|'val') extension?='extension'?
		//    | extension?='extension' (writeable?='var'|'val')
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//  (writeable?='var'|'val') extension?='extension'?
		//| extension?='extension' (writeable?='var'|'val')
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//(writeable?='var'|'val') extension?='extension'?
		public Group getGroup_0() { return cGroup_0; }
		
		//(writeable?='var'|'val')
		public Alternatives getAlternatives_0_0() { return cAlternatives_0_0; }
		
		//writeable?='var'
		public Assignment getWriteableAssignment_0_0_0() { return cWriteableAssignment_0_0_0; }
		
		//'var'
		public Keyword getWriteableVarKeyword_0_0_0_0() { return cWriteableVarKeyword_0_0_0_0; }
		
		//'val'
		public Keyword getValKeyword_0_0_1() { return cValKeyword_0_0_1; }
		
		//extension?='extension'?
		public Assignment getExtensionAssignment_0_1() { return cExtensionAssignment_0_1; }
		
		//'extension'
		public Keyword getExtensionExtensionKeyword_0_1_0() { return cExtensionExtensionKeyword_0_1_0; }
		
		//extension?='extension' (writeable?='var'|'val')
		public Group getGroup_1() { return cGroup_1; }
		
		//extension?='extension'
		public Assignment getExtensionAssignment_1_0() { return cExtensionAssignment_1_0; }
		
		//'extension'
		public Keyword getExtensionExtensionKeyword_1_0_0() { return cExtensionExtensionKeyword_1_0_0; }
		
		//(writeable?='var'|'val')
		public Alternatives getAlternatives_1_1() { return cAlternatives_1_1; }
		
		//writeable?='var'
		public Assignment getWriteableAssignment_1_1_0() { return cWriteableAssignment_1_1_0; }
		
		//'var'
		public Keyword getWriteableVarKeyword_1_1_0_0() { return cWriteableVarKeyword_1_1_0_0; }
		
		//'val'
		public Keyword getValKeyword_1_1_1() { return cValKeyword_1_1_1; }
	}
	public class XConstructorCallElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.XConstructorCall");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cXbaseConstructorCallParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cAnonymousClassConstructorCallAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1_0_0_1 = (Keyword)cGroup_1_0_0.eContents().get(1);
		private final Assignment cMembersAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cMembersMemberParserRuleCall_1_1_0 = (RuleCall)cMembersAssignment_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		
		//@Override
		//XConstructorCall returns xbase::XExpression:
		//    XbaseConstructorCall (=>({AnonymousClass.constructorCall=current} '{') members+=Member* '}')?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//XbaseConstructorCall (=>({AnonymousClass.constructorCall=current} '{') members+=Member* '}')?
		public Group getGroup() { return cGroup; }
		
		//XbaseConstructorCall
		public RuleCall getXbaseConstructorCallParserRuleCall_0() { return cXbaseConstructorCallParserRuleCall_0; }
		
		//(=>({AnonymousClass.constructorCall=current} '{') members+=Member* '}')?
		public Group getGroup_1() { return cGroup_1; }
		
		//=>({AnonymousClass.constructorCall=current} '{')
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{AnonymousClass.constructorCall=current} '{'
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{AnonymousClass.constructorCall=current}
		public Action getAnonymousClassConstructorCallAction_1_0_0_0() { return cAnonymousClassConstructorCallAction_1_0_0_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_1_0_0_1() { return cLeftCurlyBracketKeyword_1_0_0_1; }
		
		//members+=Member*
		public Assignment getMembersAssignment_1_1() { return cMembersAssignment_1_1; }
		
		//Member
		public RuleCall getMembersMemberParserRuleCall_1_1_0() { return cMembersMemberParserRuleCall_1_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_1_2() { return cRightCurlyBracketKeyword_1_2; }
	}
	public class XbaseConstructorCallElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.XbaseConstructorCall");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXConstructorCallAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cNewKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cConstructorAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cConstructorJvmConstructorCrossReference_2_0 = (CrossReference)cConstructorAssignment_2.eContents().get(0);
		private final RuleCall cConstructorJvmConstructorQualifiedNameParserRuleCall_2_0_1 = (RuleCall)cConstructorJvmConstructorCrossReference_2_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cLessThanSignKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cTypeArgumentsAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0 = (RuleCall)cTypeArgumentsAssignment_3_1.eContents().get(0);
		private final Group cGroup_3_2 = (Group)cGroup_3.eContents().get(2);
		private final Keyword cCommaKeyword_3_2_0 = (Keyword)cGroup_3_2.eContents().get(0);
		private final Assignment cTypeArgumentsAssignment_3_2_1 = (Assignment)cGroup_3_2.eContents().get(1);
		private final RuleCall cTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0 = (RuleCall)cTypeArgumentsAssignment_3_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_3_3 = (Keyword)cGroup_3.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Assignment cExplicitConstructorCallAssignment_4_0 = (Assignment)cGroup_4.eContents().get(0);
		private final Keyword cExplicitConstructorCallLeftParenthesisKeyword_4_0_0 = (Keyword)cExplicitConstructorCallAssignment_4_0.eContents().get(0);
		private final Alternatives cAlternatives_4_1 = (Alternatives)cGroup_4.eContents().get(1);
		private final Assignment cArgumentsAssignment_4_1_0 = (Assignment)cAlternatives_4_1.eContents().get(0);
		private final RuleCall cArgumentsXShortClosureParserRuleCall_4_1_0_0 = (RuleCall)cArgumentsAssignment_4_1_0.eContents().get(0);
		private final Group cGroup_4_1_1 = (Group)cAlternatives_4_1.eContents().get(1);
		private final Assignment cArgumentsAssignment_4_1_1_0 = (Assignment)cGroup_4_1_1.eContents().get(0);
		private final RuleCall cArgumentsXExpressionParserRuleCall_4_1_1_0_0 = (RuleCall)cArgumentsAssignment_4_1_1_0.eContents().get(0);
		private final Group cGroup_4_1_1_1 = (Group)cGroup_4_1_1.eContents().get(1);
		private final Keyword cCommaKeyword_4_1_1_1_0 = (Keyword)cGroup_4_1_1_1.eContents().get(0);
		private final Assignment cArgumentsAssignment_4_1_1_1_1 = (Assignment)cGroup_4_1_1_1.eContents().get(1);
		private final RuleCall cArgumentsXExpressionParserRuleCall_4_1_1_1_1_0 = (RuleCall)cArgumentsAssignment_4_1_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4_2 = (Keyword)cGroup_4.eContents().get(2);
		private final Assignment cArgumentsAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cArgumentsXClosureParserRuleCall_5_0 = (RuleCall)cArgumentsAssignment_5.eContents().get(0);
		
		//XbaseConstructorCall returns xbase::XConstructorCall:
		//    {xbase::XConstructorCall}
		//    'new' constructor=[types::JvmConstructor|QualifiedName]
		//    (=>'<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
		//    (=>explicitConstructorCall?='('
		//        (
		//            arguments+=XShortClosure
		//          | arguments+=XExpression (',' arguments+=XExpression)*
		//        )?
		//    ')')?
		//    (arguments+=XClosure)?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{xbase::XConstructorCall}
		//'new' constructor=[types::JvmConstructor|QualifiedName]
		//(=>'<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
		//(=>explicitConstructorCall?='('
		//    (
		//        arguments+=XShortClosure
		//      | arguments+=XExpression (',' arguments+=XExpression)*
		//    )?
		//')')?
		//(arguments+=XClosure)?
		public Group getGroup() { return cGroup; }
		
		//{xbase::XConstructorCall}
		public Action getXConstructorCallAction_0() { return cXConstructorCallAction_0; }
		
		//'new'
		public Keyword getNewKeyword_1() { return cNewKeyword_1; }
		
		//constructor=[types::JvmConstructor|QualifiedName]
		public Assignment getConstructorAssignment_2() { return cConstructorAssignment_2; }
		
		//[types::JvmConstructor|QualifiedName]
		public CrossReference getConstructorJvmConstructorCrossReference_2_0() { return cConstructorJvmConstructorCrossReference_2_0; }
		
		//QualifiedName
		public RuleCall getConstructorJvmConstructorQualifiedNameParserRuleCall_2_0_1() { return cConstructorJvmConstructorQualifiedNameParserRuleCall_2_0_1; }
		
		//(=>'<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
		public Group getGroup_3() { return cGroup_3; }
		
		//=>'<'
		public Keyword getLessThanSignKeyword_3_0() { return cLessThanSignKeyword_3_0; }
		
		//typeArguments+=JvmArgumentTypeReference
		public Assignment getTypeArgumentsAssignment_3_1() { return cTypeArgumentsAssignment_3_1; }
		
		//JvmArgumentTypeReference
		public RuleCall getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0() { return cTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0; }
		
		//(',' typeArguments+=JvmArgumentTypeReference)*
		public Group getGroup_3_2() { return cGroup_3_2; }
		
		//','
		public Keyword getCommaKeyword_3_2_0() { return cCommaKeyword_3_2_0; }
		
		//typeArguments+=JvmArgumentTypeReference
		public Assignment getTypeArgumentsAssignment_3_2_1() { return cTypeArgumentsAssignment_3_2_1; }
		
		//JvmArgumentTypeReference
		public RuleCall getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0() { return cTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_3_3() { return cGreaterThanSignKeyword_3_3; }
		
		//(=>explicitConstructorCall?='('
		//    (
		//        arguments+=XShortClosure
		//      | arguments+=XExpression (',' arguments+=XExpression)*
		//    )?
		//')')?
		public Group getGroup_4() { return cGroup_4; }
		
		//=>explicitConstructorCall?='('
		public Assignment getExplicitConstructorCallAssignment_4_0() { return cExplicitConstructorCallAssignment_4_0; }
		
		//'('
		public Keyword getExplicitConstructorCallLeftParenthesisKeyword_4_0_0() { return cExplicitConstructorCallLeftParenthesisKeyword_4_0_0; }
		
		//(
		//    arguments+=XShortClosure
		//  | arguments+=XExpression (',' arguments+=XExpression)*
		//)?
		public Alternatives getAlternatives_4_1() { return cAlternatives_4_1; }
		
		//arguments+=XShortClosure
		public Assignment getArgumentsAssignment_4_1_0() { return cArgumentsAssignment_4_1_0; }
		
		//XShortClosure
		public RuleCall getArgumentsXShortClosureParserRuleCall_4_1_0_0() { return cArgumentsXShortClosureParserRuleCall_4_1_0_0; }
		
		//arguments+=XExpression (',' arguments+=XExpression)*
		public Group getGroup_4_1_1() { return cGroup_4_1_1; }
		
		//arguments+=XExpression
		public Assignment getArgumentsAssignment_4_1_1_0() { return cArgumentsAssignment_4_1_1_0; }
		
		//XExpression
		public RuleCall getArgumentsXExpressionParserRuleCall_4_1_1_0_0() { return cArgumentsXExpressionParserRuleCall_4_1_1_0_0; }
		
		//(',' arguments+=XExpression)*
		public Group getGroup_4_1_1_1() { return cGroup_4_1_1_1; }
		
		//','
		public Keyword getCommaKeyword_4_1_1_1_0() { return cCommaKeyword_4_1_1_1_0; }
		
		//arguments+=XExpression
		public Assignment getArgumentsAssignment_4_1_1_1_1() { return cArgumentsAssignment_4_1_1_1_1; }
		
		//XExpression
		public RuleCall getArgumentsXExpressionParserRuleCall_4_1_1_1_1_0() { return cArgumentsXExpressionParserRuleCall_4_1_1_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4_2() { return cRightParenthesisKeyword_4_2; }
		
		//(arguments+=XClosure)?
		public Assignment getArgumentsAssignment_5() { return cArgumentsAssignment_5; }
		
		//XClosure
		public RuleCall getArgumentsXClosureParserRuleCall_5_0() { return cArgumentsXClosureParserRuleCall_5_0; }
	}
	public class JvmFormalParameterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.JvmFormalParameter");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cExtensionAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cExtensionExtensionKeyword_0_0 = (Keyword)cExtensionAssignment_0.eContents().get(0);
		private final Assignment cParameterTypeAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cParameterTypeJvmTypeReferenceParserRuleCall_1_0 = (RuleCall)cParameterTypeAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameInnerVarIDParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		
		//@Override
		//JvmFormalParameter returns XtendFormalParameter:
		//    extension?='extension'? (parameterType=JvmTypeReference)? name=InnerVarID;
		@Override public ParserRule getRule() { return rule; }
		
		//extension?='extension'? (parameterType=JvmTypeReference)? name=InnerVarID
		public Group getGroup() { return cGroup; }
		
		//extension?='extension'?
		public Assignment getExtensionAssignment_0() { return cExtensionAssignment_0; }
		
		//'extension'
		public Keyword getExtensionExtensionKeyword_0_0() { return cExtensionExtensionKeyword_0_0; }
		
		//(parameterType=JvmTypeReference)?
		public Assignment getParameterTypeAssignment_1() { return cParameterTypeAssignment_1; }
		
		//JvmTypeReference
		public RuleCall getParameterTypeJvmTypeReferenceParserRuleCall_1_0() { return cParameterTypeJvmTypeReferenceParserRuleCall_1_0; }
		
		//name=InnerVarID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//InnerVarID
		public RuleCall getNameInnerVarIDParserRuleCall_2_0() { return cNameInnerVarIDParserRuleCall_2_0; }
	}
	public class FullJvmFormalParameterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.FullJvmFormalParameter");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cExtensionAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cExtensionExtensionKeyword_0_0 = (Keyword)cExtensionAssignment_0.eContents().get(0);
		private final Assignment cParameterTypeAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cParameterTypeMultiTypeReferenceParserRuleCall_1_0 = (RuleCall)cParameterTypeAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameInnerVarIDParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		
		///*
		// * Since we only use FullJvmFormalParameter for catch variables, it is safe to
		// * use a MultiTypeReference here as the type.
		// */
		//@Override
		//FullJvmFormalParameter returns XtendFormalParameter:
		//    extension?='extension'? parameterType=MultiTypeReference name=InnerVarID
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//extension?='extension'? parameterType=MultiTypeReference name=InnerVarID
		public Group getGroup() { return cGroup; }
		
		//extension?='extension'?
		public Assignment getExtensionAssignment_0() { return cExtensionAssignment_0; }
		
		//'extension'
		public Keyword getExtensionExtensionKeyword_0_0() { return cExtensionExtensionKeyword_0_0; }
		
		//parameterType=MultiTypeReference
		public Assignment getParameterTypeAssignment_1() { return cParameterTypeAssignment_1; }
		
		//MultiTypeReference
		public RuleCall getParameterTypeMultiTypeReferenceParserRuleCall_1_0() { return cParameterTypeMultiTypeReferenceParserRuleCall_1_0; }
		
		//name=InnerVarID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//InnerVarID
		public RuleCall getNameInnerVarIDParserRuleCall_2_0() { return cNameInnerVarIDParserRuleCall_2_0; }
	}
	public class MultiTypeReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.MultiTypeReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cJvmTypeReferenceParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cJvmSynonymTypeReferenceReferencesAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Keyword cVerticalLineKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cReferencesAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cReferencesJvmTypeReferenceParserRuleCall_1_1_1_0 = (RuleCall)cReferencesAssignment_1_1_1.eContents().get(0);
		
		//MultiTypeReference returns types::JvmTypeReference:
		//    JvmTypeReference ({types::JvmSynonymTypeReference.references+=current} ('|' references+=JvmTypeReference)+)?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//JvmTypeReference ({types::JvmSynonymTypeReference.references+=current} ('|' references+=JvmTypeReference)+)?
		public Group getGroup() { return cGroup; }
		
		//JvmTypeReference
		public RuleCall getJvmTypeReferenceParserRuleCall_0() { return cJvmTypeReferenceParserRuleCall_0; }
		
		//({types::JvmSynonymTypeReference.references+=current} ('|' references+=JvmTypeReference)+)?
		public Group getGroup_1() { return cGroup_1; }
		
		//{types::JvmSynonymTypeReference.references+=current}
		public Action getJvmSynonymTypeReferenceReferencesAction_1_0() { return cJvmSynonymTypeReferenceReferencesAction_1_0; }
		
		//('|' references+=JvmTypeReference)+
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//'|'
		public Keyword getVerticalLineKeyword_1_1_0() { return cVerticalLineKeyword_1_1_0; }
		
		//references+=JvmTypeReference
		public Assignment getReferencesAssignment_1_1_1() { return cReferencesAssignment_1_1_1; }
		
		//JvmTypeReference
		public RuleCall getReferencesJvmTypeReferenceParserRuleCall_1_1_1_0() { return cReferencesJvmTypeReferenceParserRuleCall_1_1_1_0; }
	}
	public class XStringLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.XStringLiteral");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSimpleStringLiteralParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cRichStringParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//@Override
		//XStringLiteral returns xbase::XExpression:
		//    SimpleStringLiteral | RichString
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//SimpleStringLiteral | RichString
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//SimpleStringLiteral
		public RuleCall getSimpleStringLiteralParserRuleCall_0() { return cSimpleStringLiteralParserRuleCall_0; }
		
		//RichString
		public RuleCall getRichStringParserRuleCall_1() { return cRichStringParserRuleCall_1; }
	}
	public class XSwitchExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.XSwitchExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXSwitchExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cSwitchKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Group cGroup_2_0_0 = (Group)cGroup_2_0.eContents().get(0);
		private final Group cGroup_2_0_0_0 = (Group)cGroup_2_0_0.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2_0_0_0_0 = (Keyword)cGroup_2_0_0_0.eContents().get(0);
		private final Assignment cDeclaredParamAssignment_2_0_0_0_1 = (Assignment)cGroup_2_0_0_0.eContents().get(1);
		private final RuleCall cDeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0 = (RuleCall)cDeclaredParamAssignment_2_0_0_0_1.eContents().get(0);
		private final Keyword cColonKeyword_2_0_0_0_2 = (Keyword)cGroup_2_0_0_0.eContents().get(2);
		private final Assignment cSwitchAssignment_2_0_1 = (Assignment)cGroup_2_0.eContents().get(1);
		private final RuleCall cSwitchXExpressionParserRuleCall_2_0_1_0 = (RuleCall)cSwitchAssignment_2_0_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2_0_2 = (Keyword)cGroup_2_0.eContents().get(2);
		private final Group cGroup_2_1 = (Group)cAlternatives_2.eContents().get(1);
		private final Group cGroup_2_1_0 = (Group)cGroup_2_1.eContents().get(0);
		private final Group cGroup_2_1_0_0 = (Group)cGroup_2_1_0.eContents().get(0);
		private final Assignment cDeclaredParamAssignment_2_1_0_0_0 = (Assignment)cGroup_2_1_0_0.eContents().get(0);
		private final RuleCall cDeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0 = (RuleCall)cDeclaredParamAssignment_2_1_0_0_0.eContents().get(0);
		private final Keyword cColonKeyword_2_1_0_0_1 = (Keyword)cGroup_2_1_0_0.eContents().get(1);
		private final Assignment cSwitchAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cSwitchXExpressionOrSimpleConstructorCallParserRuleCall_2_1_1_0 = (RuleCall)cSwitchAssignment_2_1_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cCasesAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cCasesXCasePartParserRuleCall_4_0 = (RuleCall)cCasesAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cDefaultKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Keyword cColonKeyword_5_1 = (Keyword)cGroup_5.eContents().get(1);
		private final Assignment cDefaultAssignment_5_2 = (Assignment)cGroup_5.eContents().get(2);
		private final RuleCall cDefaultXExpressionParserRuleCall_5_2_0 = (RuleCall)cDefaultAssignment_5_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//@Override
		//XSwitchExpression returns xbase::XExpression:
		//    {xbase::XSwitchExpression}
		//    'switch' (=>('(' declaredParam=JvmFormalParameter ':') switch=XExpression ')'
		//        | =>(declaredParam=JvmFormalParameter ':')? switch=XExpressionOrSimpleConstructorCall) '{'
		//    (cases+=XCasePart)*
		//    ('default' ':' default=XExpression )?
		//    '}'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{xbase::XSwitchExpression}
		//'switch' (=>('(' declaredParam=JvmFormalParameter ':') switch=XExpression ')'
		//    | =>(declaredParam=JvmFormalParameter ':')? switch=XExpressionOrSimpleConstructorCall) '{'
		//(cases+=XCasePart)*
		//('default' ':' default=XExpression )?
		//'}'
		public Group getGroup() { return cGroup; }
		
		//{xbase::XSwitchExpression}
		public Action getXSwitchExpressionAction_0() { return cXSwitchExpressionAction_0; }
		
		//'switch'
		public Keyword getSwitchKeyword_1() { return cSwitchKeyword_1; }
		
		//(=>('(' declaredParam=JvmFormalParameter ':') switch=XExpression ')'
		//       | =>(declaredParam=JvmFormalParameter ':')? switch=XExpressionOrSimpleConstructorCall)
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//=>('(' declaredParam=JvmFormalParameter ':') switch=XExpression ')'
		public Group getGroup_2_0() { return cGroup_2_0; }
		
		//=>('(' declaredParam=JvmFormalParameter ':')
		public Group getGroup_2_0_0() { return cGroup_2_0_0; }
		
		//'(' declaredParam=JvmFormalParameter ':'
		public Group getGroup_2_0_0_0() { return cGroup_2_0_0_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2_0_0_0_0() { return cLeftParenthesisKeyword_2_0_0_0_0; }
		
		//declaredParam=JvmFormalParameter
		public Assignment getDeclaredParamAssignment_2_0_0_0_1() { return cDeclaredParamAssignment_2_0_0_0_1; }
		
		//JvmFormalParameter
		public RuleCall getDeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0() { return cDeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0; }
		
		//':'
		public Keyword getColonKeyword_2_0_0_0_2() { return cColonKeyword_2_0_0_0_2; }
		
		//switch=XExpression
		public Assignment getSwitchAssignment_2_0_1() { return cSwitchAssignment_2_0_1; }
		
		//XExpression
		public RuleCall getSwitchXExpressionParserRuleCall_2_0_1_0() { return cSwitchXExpressionParserRuleCall_2_0_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2_0_2() { return cRightParenthesisKeyword_2_0_2; }
		
		//=>(declaredParam=JvmFormalParameter ':')? switch=XExpressionOrSimpleConstructorCall
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//=>(declaredParam=JvmFormalParameter ':')?
		public Group getGroup_2_1_0() { return cGroup_2_1_0; }
		
		//declaredParam=JvmFormalParameter ':'
		public Group getGroup_2_1_0_0() { return cGroup_2_1_0_0; }
		
		//declaredParam=JvmFormalParameter
		public Assignment getDeclaredParamAssignment_2_1_0_0_0() { return cDeclaredParamAssignment_2_1_0_0_0; }
		
		//JvmFormalParameter
		public RuleCall getDeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0() { return cDeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0; }
		
		//':'
		public Keyword getColonKeyword_2_1_0_0_1() { return cColonKeyword_2_1_0_0_1; }
		
		//switch=XExpressionOrSimpleConstructorCall
		public Assignment getSwitchAssignment_2_1_1() { return cSwitchAssignment_2_1_1; }
		
		//XExpressionOrSimpleConstructorCall
		public RuleCall getSwitchXExpressionOrSimpleConstructorCallParserRuleCall_2_1_1_0() { return cSwitchXExpressionOrSimpleConstructorCallParserRuleCall_2_1_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//(cases+=XCasePart)*
		public Assignment getCasesAssignment_4() { return cCasesAssignment_4; }
		
		//XCasePart
		public RuleCall getCasesXCasePartParserRuleCall_4_0() { return cCasesXCasePartParserRuleCall_4_0; }
		
		//('default' ':' default=XExpression )?
		public Group getGroup_5() { return cGroup_5; }
		
		//'default'
		public Keyword getDefaultKeyword_5_0() { return cDefaultKeyword_5_0; }
		
		//':'
		public Keyword getColonKeyword_5_1() { return cColonKeyword_5_1; }
		
		//default=XExpression
		public Assignment getDefaultAssignment_5_2() { return cDefaultAssignment_5_2; }
		
		//XExpression
		public RuleCall getDefaultXExpressionParserRuleCall_5_2_0() { return cDefaultXExpressionParserRuleCall_5_2_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}
	public class XCasePartElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.XCasePart");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXCasePartAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cTypeGuardAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTypeGuardMultiTypeReferenceParserRuleCall_1_0 = (RuleCall)cTypeGuardAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cCaseKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cCaseAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cCaseXExpressionParserRuleCall_2_1_0 = (RuleCall)cCaseAssignment_2_1.eContents().get(0);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Group cGroup_3_0 = (Group)cAlternatives_3.eContents().get(0);
		private final Keyword cColonKeyword_3_0_0 = (Keyword)cGroup_3_0.eContents().get(0);
		private final Assignment cThenAssignment_3_0_1 = (Assignment)cGroup_3_0.eContents().get(1);
		private final RuleCall cThenXExpressionParserRuleCall_3_0_1_0 = (RuleCall)cThenAssignment_3_0_1.eContents().get(0);
		private final Assignment cFallThroughAssignment_3_1 = (Assignment)cAlternatives_3.eContents().get(1);
		private final Keyword cFallThroughCommaKeyword_3_1_0 = (Keyword)cFallThroughAssignment_3_1.eContents().get(0);
		
		//@Override
		//XCasePart returns xbase::XCasePart:
		//    {xbase::XCasePart}
		//    typeGuard=MultiTypeReference? ('case' case=XExpression)?
		//        (':' then=XExpression | fallThrough?=',')
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{xbase::XCasePart}
		//typeGuard=MultiTypeReference? ('case' case=XExpression)?
		//    (':' then=XExpression | fallThrough?=',')
		public Group getGroup() { return cGroup; }
		
		//{xbase::XCasePart}
		public Action getXCasePartAction_0() { return cXCasePartAction_0; }
		
		//typeGuard=MultiTypeReference?
		public Assignment getTypeGuardAssignment_1() { return cTypeGuardAssignment_1; }
		
		//MultiTypeReference
		public RuleCall getTypeGuardMultiTypeReferenceParserRuleCall_1_0() { return cTypeGuardMultiTypeReferenceParserRuleCall_1_0; }
		
		//('case' case=XExpression)?
		public Group getGroup_2() { return cGroup_2; }
		
		//'case'
		public Keyword getCaseKeyword_2_0() { return cCaseKeyword_2_0; }
		
		//case=XExpression
		public Assignment getCaseAssignment_2_1() { return cCaseAssignment_2_1; }
		
		//XExpression
		public RuleCall getCaseXExpressionParserRuleCall_2_1_0() { return cCaseXExpressionParserRuleCall_2_1_0; }
		
		//(':' then=XExpression | fallThrough?=',')
		public Alternatives getAlternatives_3() { return cAlternatives_3; }
		
		//':' then=XExpression
		public Group getGroup_3_0() { return cGroup_3_0; }
		
		//':'
		public Keyword getColonKeyword_3_0_0() { return cColonKeyword_3_0_0; }
		
		//then=XExpression
		public Assignment getThenAssignment_3_0_1() { return cThenAssignment_3_0_1; }
		
		//XExpression
		public RuleCall getThenXExpressionParserRuleCall_3_0_1_0() { return cThenXExpressionParserRuleCall_3_0_1_0; }
		
		//fallThrough?=','
		public Assignment getFallThroughAssignment_3_1() { return cFallThroughAssignment_3_1; }
		
		//','
		public Keyword getFallThroughCommaKeyword_3_1_0() { return cFallThroughCommaKeyword_3_1_0; }
	}
	public class XExpressionOrSimpleConstructorCallElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.XExpressionOrSimpleConstructorCall");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cXbaseConstructorCallParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cXExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//XExpressionOrSimpleConstructorCall returns xbase::XExpression:
		//    ->XbaseConstructorCall | XExpression
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//->XbaseConstructorCall | XExpression
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//->XbaseConstructorCall
		public RuleCall getXbaseConstructorCallParserRuleCall_0() { return cXbaseConstructorCallParserRuleCall_0; }
		
		//XExpression
		public RuleCall getXExpressionParserRuleCall_1() { return cXExpressionParserRuleCall_1; }
	}
	public class SimpleStringLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.SimpleStringLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXStringLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//SimpleStringLiteral returns xbase::XExpression:
		//    {xbase::XStringLiteral} value=STRING
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{xbase::XStringLiteral} value=STRING
		public Group getGroup() { return cGroup; }
		
		//{xbase::XStringLiteral}
		public Action getXStringLiteralAction_0() { return cXStringLiteralAction_0; }
		
		//value=STRING
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_1_0() { return cValueSTRINGTerminalRuleCall_1_0; }
	}
	public class RichStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.RichString");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRichStringAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cExpressionsAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cExpressionsRichStringLiteralParserRuleCall_1_0_0 = (RuleCall)cExpressionsAssignment_1_0.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Assignment cExpressionsAssignment_1_1_0 = (Assignment)cGroup_1_1.eContents().get(0);
		private final RuleCall cExpressionsRichStringLiteralStartParserRuleCall_1_1_0_0 = (RuleCall)cExpressionsAssignment_1_1_0.eContents().get(0);
		private final Assignment cExpressionsAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cExpressionsRichStringPartParserRuleCall_1_1_1_0 = (RuleCall)cExpressionsAssignment_1_1_1.eContents().get(0);
		private final Group cGroup_1_1_2 = (Group)cGroup_1_1.eContents().get(2);
		private final Assignment cExpressionsAssignment_1_1_2_0 = (Assignment)cGroup_1_1_2.eContents().get(0);
		private final RuleCall cExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_2_0_0 = (RuleCall)cExpressionsAssignment_1_1_2_0.eContents().get(0);
		private final Assignment cExpressionsAssignment_1_1_2_1 = (Assignment)cGroup_1_1_2.eContents().get(1);
		private final RuleCall cExpressionsRichStringPartParserRuleCall_1_1_2_1_0 = (RuleCall)cExpressionsAssignment_1_1_2_1.eContents().get(0);
		private final Assignment cExpressionsAssignment_1_1_3 = (Assignment)cGroup_1_1.eContents().get(3);
		private final RuleCall cExpressionsRichStringLiteralEndParserRuleCall_1_1_3_0 = (RuleCall)cExpressionsAssignment_1_1_3.eContents().get(0);
		
		//RichString returns xbase::XExpression:
		//    {RichString} (
		//        expressions+=RichStringLiteral |
		//        expressions+=RichStringLiteralStart expressions+=RichStringPart?
		//        (expressions+=RichStringLiteralInbetween expressions+=RichStringPart?)*
		//        expressions+=RichStringLiteralEnd
		//    )
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{RichString} (
		//    expressions+=RichStringLiteral |
		//    expressions+=RichStringLiteralStart expressions+=RichStringPart?
		//    (expressions+=RichStringLiteralInbetween expressions+=RichStringPart?)*
		//    expressions+=RichStringLiteralEnd
		//)
		public Group getGroup() { return cGroup; }
		
		//{RichString}
		public Action getRichStringAction_0() { return cRichStringAction_0; }
		
		//(
		//       expressions+=RichStringLiteral |
		//       expressions+=RichStringLiteralStart expressions+=RichStringPart?
		//       (expressions+=RichStringLiteralInbetween expressions+=RichStringPart?)*
		//       expressions+=RichStringLiteralEnd
		//   )
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//expressions+=RichStringLiteral
		public Assignment getExpressionsAssignment_1_0() { return cExpressionsAssignment_1_0; }
		
		//RichStringLiteral
		public RuleCall getExpressionsRichStringLiteralParserRuleCall_1_0_0() { return cExpressionsRichStringLiteralParserRuleCall_1_0_0; }
		
		//expressions+=RichStringLiteralStart expressions+=RichStringPart?
		//(expressions+=RichStringLiteralInbetween expressions+=RichStringPart?)*
		//expressions+=RichStringLiteralEnd
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//expressions+=RichStringLiteralStart
		public Assignment getExpressionsAssignment_1_1_0() { return cExpressionsAssignment_1_1_0; }
		
		//RichStringLiteralStart
		public RuleCall getExpressionsRichStringLiteralStartParserRuleCall_1_1_0_0() { return cExpressionsRichStringLiteralStartParserRuleCall_1_1_0_0; }
		
		//expressions+=RichStringPart?
		public Assignment getExpressionsAssignment_1_1_1() { return cExpressionsAssignment_1_1_1; }
		
		//RichStringPart
		public RuleCall getExpressionsRichStringPartParserRuleCall_1_1_1_0() { return cExpressionsRichStringPartParserRuleCall_1_1_1_0; }
		
		//(expressions+=RichStringLiteralInbetween expressions+=RichStringPart?)*
		public Group getGroup_1_1_2() { return cGroup_1_1_2; }
		
		//expressions+=RichStringLiteralInbetween
		public Assignment getExpressionsAssignment_1_1_2_0() { return cExpressionsAssignment_1_1_2_0; }
		
		//RichStringLiteralInbetween
		public RuleCall getExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_2_0_0() { return cExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_2_0_0; }
		
		//expressions+=RichStringPart?
		public Assignment getExpressionsAssignment_1_1_2_1() { return cExpressionsAssignment_1_1_2_1; }
		
		//RichStringPart
		public RuleCall getExpressionsRichStringPartParserRuleCall_1_1_2_1_0() { return cExpressionsRichStringPartParserRuleCall_1_1_2_1_0; }
		
		//expressions+=RichStringLiteralEnd
		public Assignment getExpressionsAssignment_1_1_3() { return cExpressionsAssignment_1_1_3; }
		
		//RichStringLiteralEnd
		public RuleCall getExpressionsRichStringLiteralEndParserRuleCall_1_1_3_0() { return cExpressionsRichStringLiteralEndParserRuleCall_1_1_3_0; }
	}
	public class RichStringLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.RichStringLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRichStringLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueRICH_TEXTTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//RichStringLiteral returns xbase::XExpression :
		//    {RichStringLiteral} value=RICH_TEXT
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{RichStringLiteral} value=RICH_TEXT
		public Group getGroup() { return cGroup; }
		
		//{RichStringLiteral}
		public Action getRichStringLiteralAction_0() { return cRichStringLiteralAction_0; }
		
		//value=RICH_TEXT
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//RICH_TEXT
		public RuleCall getValueRICH_TEXTTerminalRuleCall_1_0() { return cValueRICH_TEXTTerminalRuleCall_1_0; }
	}
	public class RichStringLiteralStartElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.RichStringLiteralStart");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRichStringLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueRICH_TEXT_STARTTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//RichStringLiteralStart returns xbase::XExpression :
		//    {RichStringLiteral} value=RICH_TEXT_START
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{RichStringLiteral} value=RICH_TEXT_START
		public Group getGroup() { return cGroup; }
		
		//{RichStringLiteral}
		public Action getRichStringLiteralAction_0() { return cRichStringLiteralAction_0; }
		
		//value=RICH_TEXT_START
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//RICH_TEXT_START
		public RuleCall getValueRICH_TEXT_STARTTerminalRuleCall_1_0() { return cValueRICH_TEXT_STARTTerminalRuleCall_1_0; }
	}
	public class RichStringLiteralInbetweenElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.RichStringLiteralInbetween");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRichStringLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cValueAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cValueRICH_TEXT_INBETWEENTerminalRuleCall_1_0_0 = (RuleCall)cValueAssignment_1_0.eContents().get(0);
		private final Assignment cValueAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cValueCOMMENT_RICH_TEXT_INBETWEENTerminalRuleCall_1_1_0 = (RuleCall)cValueAssignment_1_1.eContents().get(0);
		
		//RichStringLiteralInbetween returns xbase::XExpression :
		//    {RichStringLiteral}
		//    ( value=RICH_TEXT_INBETWEEN | value=COMMENT_RICH_TEXT_INBETWEEN )
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{RichStringLiteral}
		//( value=RICH_TEXT_INBETWEEN | value=COMMENT_RICH_TEXT_INBETWEEN )
		public Group getGroup() { return cGroup; }
		
		//{RichStringLiteral}
		public Action getRichStringLiteralAction_0() { return cRichStringLiteralAction_0; }
		
		//( value=RICH_TEXT_INBETWEEN | value=COMMENT_RICH_TEXT_INBETWEEN )
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//value=RICH_TEXT_INBETWEEN
		public Assignment getValueAssignment_1_0() { return cValueAssignment_1_0; }
		
		//RICH_TEXT_INBETWEEN
		public RuleCall getValueRICH_TEXT_INBETWEENTerminalRuleCall_1_0_0() { return cValueRICH_TEXT_INBETWEENTerminalRuleCall_1_0_0; }
		
		//value=COMMENT_RICH_TEXT_INBETWEEN
		public Assignment getValueAssignment_1_1() { return cValueAssignment_1_1; }
		
		//COMMENT_RICH_TEXT_INBETWEEN
		public RuleCall getValueCOMMENT_RICH_TEXT_INBETWEENTerminalRuleCall_1_1_0() { return cValueCOMMENT_RICH_TEXT_INBETWEENTerminalRuleCall_1_1_0; }
	}
	public class RichStringLiteralEndElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.RichStringLiteralEnd");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRichStringLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cValueAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cValueRICH_TEXT_ENDTerminalRuleCall_1_0_0 = (RuleCall)cValueAssignment_1_0.eContents().get(0);
		private final Assignment cValueAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cValueCOMMENT_RICH_TEXT_ENDTerminalRuleCall_1_1_0 = (RuleCall)cValueAssignment_1_1.eContents().get(0);
		
		//RichStringLiteralEnd returns xbase::XExpression :
		//    {RichStringLiteral}
		//    ( value=RICH_TEXT_END | value=COMMENT_RICH_TEXT_END )
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{RichStringLiteral}
		//( value=RICH_TEXT_END | value=COMMENT_RICH_TEXT_END )
		public Group getGroup() { return cGroup; }
		
		//{RichStringLiteral}
		public Action getRichStringLiteralAction_0() { return cRichStringLiteralAction_0; }
		
		//( value=RICH_TEXT_END | value=COMMENT_RICH_TEXT_END )
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//value=RICH_TEXT_END
		public Assignment getValueAssignment_1_0() { return cValueAssignment_1_0; }
		
		//RICH_TEXT_END
		public RuleCall getValueRICH_TEXT_ENDTerminalRuleCall_1_0_0() { return cValueRICH_TEXT_ENDTerminalRuleCall_1_0_0; }
		
		//value=COMMENT_RICH_TEXT_END
		public Assignment getValueAssignment_1_1() { return cValueAssignment_1_1; }
		
		//COMMENT_RICH_TEXT_END
		public RuleCall getValueCOMMENT_RICH_TEXT_ENDTerminalRuleCall_1_1_0() { return cValueCOMMENT_RICH_TEXT_ENDTerminalRuleCall_1_1_0; }
	}
	public class InternalRichStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.InternalRichString");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRichStringAction_0 = (Action)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cExpressionsAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cExpressionsRichStringLiteralInbetweenParserRuleCall_1_0_0 = (RuleCall)cExpressionsAssignment_1_0.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Assignment cExpressionsAssignment_1_1_0 = (Assignment)cGroup_1_1.eContents().get(0);
		private final RuleCall cExpressionsRichStringPartParserRuleCall_1_1_0_0 = (RuleCall)cExpressionsAssignment_1_1_0.eContents().get(0);
		private final Assignment cExpressionsAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_1_0 = (RuleCall)cExpressionsAssignment_1_1_1.eContents().get(0);
		
		//InternalRichString returns xbase::XExpression:
		//    {RichString} (
		//        expressions+=RichStringLiteralInbetween (expressions+=RichStringPart? expressions+=RichStringLiteralInbetween)*
		//    )
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{RichString} (
		//    expressions+=RichStringLiteralInbetween (expressions+=RichStringPart? expressions+=RichStringLiteralInbetween)*
		//)
		public Group getGroup() { return cGroup; }
		
		//{RichString}
		public Action getRichStringAction_0() { return cRichStringAction_0; }
		
		//(
		//       expressions+=RichStringLiteralInbetween (expressions+=RichStringPart? expressions+=RichStringLiteralInbetween)*
		//   )
		public Group getGroup_1() { return cGroup_1; }
		
		//expressions+=RichStringLiteralInbetween
		public Assignment getExpressionsAssignment_1_0() { return cExpressionsAssignment_1_0; }
		
		//RichStringLiteralInbetween
		public RuleCall getExpressionsRichStringLiteralInbetweenParserRuleCall_1_0_0() { return cExpressionsRichStringLiteralInbetweenParserRuleCall_1_0_0; }
		
		//(expressions+=RichStringPart? expressions+=RichStringLiteralInbetween)*
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//expressions+=RichStringPart?
		public Assignment getExpressionsAssignment_1_1_0() { return cExpressionsAssignment_1_1_0; }
		
		//RichStringPart
		public RuleCall getExpressionsRichStringPartParserRuleCall_1_1_0_0() { return cExpressionsRichStringPartParserRuleCall_1_1_0_0; }
		
		//expressions+=RichStringLiteralInbetween
		public Assignment getExpressionsAssignment_1_1_1() { return cExpressionsAssignment_1_1_1; }
		
		//RichStringLiteralInbetween
		public RuleCall getExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_1_0() { return cExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_1_0; }
	}
	public class RichStringPartElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.RichStringPart");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cXExpressionOrVarDeclarationParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cRichStringForLoopParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cRichStringIfParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//RichStringPart returns xbase::XExpression:
		//    XExpressionOrVarDeclaration |
		//    RichStringForLoop |
		//    RichStringIf
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//XExpressionOrVarDeclaration |
		//RichStringForLoop |
		//RichStringIf
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//XExpressionOrVarDeclaration
		public RuleCall getXExpressionOrVarDeclarationParserRuleCall_0() { return cXExpressionOrVarDeclarationParserRuleCall_0; }
		
		//RichStringForLoop
		public RuleCall getRichStringForLoopParserRuleCall_1() { return cRichStringForLoopParserRuleCall_1; }
		
		//RichStringIf
		public RuleCall getRichStringIfParserRuleCall_2() { return cRichStringIfParserRuleCall_2; }
	}
	public class RichStringForLoopElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.RichStringForLoop");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRichStringForLoopAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cFORKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cDeclaredParamAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cDeclaredParamJvmFormalParameterParserRuleCall_2_0 = (RuleCall)cDeclaredParamAssignment_2.eContents().get(0);
		private final Keyword cColonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cForExpressionAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cForExpressionXExpressionParserRuleCall_4_0 = (RuleCall)cForExpressionAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cBEFOREKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cBeforeAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cBeforeXExpressionParserRuleCall_5_1_0 = (RuleCall)cBeforeAssignment_5_1.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cSEPARATORKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cSeparatorAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cSeparatorXExpressionParserRuleCall_6_1_0 = (RuleCall)cSeparatorAssignment_6_1.eContents().get(0);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cAFTERKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Assignment cAfterAssignment_7_1 = (Assignment)cGroup_7.eContents().get(1);
		private final RuleCall cAfterXExpressionParserRuleCall_7_1_0 = (RuleCall)cAfterAssignment_7_1.eContents().get(0);
		private final Assignment cEachExpressionAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final RuleCall cEachExpressionInternalRichStringParserRuleCall_8_0 = (RuleCall)cEachExpressionAssignment_8.eContents().get(0);
		private final Keyword cENDFORKeyword_9 = (Keyword)cGroup.eContents().get(9);
		
		//RichStringForLoop returns xbase::XExpression:
		//    {RichStringForLoop}
		//    "FOR" declaredParam=JvmFormalParameter ':' forExpression=XExpression
		//        ("BEFORE" before=XExpression)?
		//        ("SEPARATOR" separator=XExpression)?
		//        ("AFTER" after=XExpression)?
		//        eachExpression=InternalRichString
		//    "ENDFOR"
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{RichStringForLoop}
		//"FOR" declaredParam=JvmFormalParameter ':' forExpression=XExpression
		//    ("BEFORE" before=XExpression)?
		//    ("SEPARATOR" separator=XExpression)?
		//    ("AFTER" after=XExpression)?
		//    eachExpression=InternalRichString
		//"ENDFOR"
		public Group getGroup() { return cGroup; }
		
		//{RichStringForLoop}
		public Action getRichStringForLoopAction_0() { return cRichStringForLoopAction_0; }
		
		//"FOR"
		public Keyword getFORKeyword_1() { return cFORKeyword_1; }
		
		//declaredParam=JvmFormalParameter
		public Assignment getDeclaredParamAssignment_2() { return cDeclaredParamAssignment_2; }
		
		//JvmFormalParameter
		public RuleCall getDeclaredParamJvmFormalParameterParserRuleCall_2_0() { return cDeclaredParamJvmFormalParameterParserRuleCall_2_0; }
		
		//':'
		public Keyword getColonKeyword_3() { return cColonKeyword_3; }
		
		//forExpression=XExpression
		public Assignment getForExpressionAssignment_4() { return cForExpressionAssignment_4; }
		
		//XExpression
		public RuleCall getForExpressionXExpressionParserRuleCall_4_0() { return cForExpressionXExpressionParserRuleCall_4_0; }
		
		//("BEFORE" before=XExpression)?
		public Group getGroup_5() { return cGroup_5; }
		
		//"BEFORE"
		public Keyword getBEFOREKeyword_5_0() { return cBEFOREKeyword_5_0; }
		
		//before=XExpression
		public Assignment getBeforeAssignment_5_1() { return cBeforeAssignment_5_1; }
		
		//XExpression
		public RuleCall getBeforeXExpressionParserRuleCall_5_1_0() { return cBeforeXExpressionParserRuleCall_5_1_0; }
		
		//("SEPARATOR" separator=XExpression)?
		public Group getGroup_6() { return cGroup_6; }
		
		//"SEPARATOR"
		public Keyword getSEPARATORKeyword_6_0() { return cSEPARATORKeyword_6_0; }
		
		//separator=XExpression
		public Assignment getSeparatorAssignment_6_1() { return cSeparatorAssignment_6_1; }
		
		//XExpression
		public RuleCall getSeparatorXExpressionParserRuleCall_6_1_0() { return cSeparatorXExpressionParserRuleCall_6_1_0; }
		
		//("AFTER" after=XExpression)?
		public Group getGroup_7() { return cGroup_7; }
		
		//"AFTER"
		public Keyword getAFTERKeyword_7_0() { return cAFTERKeyword_7_0; }
		
		//after=XExpression
		public Assignment getAfterAssignment_7_1() { return cAfterAssignment_7_1; }
		
		//XExpression
		public RuleCall getAfterXExpressionParserRuleCall_7_1_0() { return cAfterXExpressionParserRuleCall_7_1_0; }
		
		//eachExpression=InternalRichString
		public Assignment getEachExpressionAssignment_8() { return cEachExpressionAssignment_8; }
		
		//InternalRichString
		public RuleCall getEachExpressionInternalRichStringParserRuleCall_8_0() { return cEachExpressionInternalRichStringParserRuleCall_8_0; }
		
		//"ENDFOR"
		public Keyword getENDFORKeyword_9() { return cENDFORKeyword_9; }
	}
	public class RichStringIfElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.RichStringIf");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRichStringIfAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cIFKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cIfAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cIfXExpressionParserRuleCall_2_0 = (RuleCall)cIfAssignment_2.eContents().get(0);
		private final Assignment cThenAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cThenInternalRichStringParserRuleCall_3_0 = (RuleCall)cThenAssignment_3.eContents().get(0);
		private final Assignment cElseIfsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cElseIfsRichStringElseIfParserRuleCall_4_0 = (RuleCall)cElseIfsAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cELSEKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cElseAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cElseInternalRichStringParserRuleCall_5_1_0 = (RuleCall)cElseAssignment_5_1.eContents().get(0);
		private final Keyword cENDIFKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//RichStringIf returns xbase::XExpression :
		//    {RichStringIf}
		//    "IF" if=XExpression
		//        then=InternalRichString
		//        elseIfs+=RichStringElseIf*
		//    ("ELSE"
		//        else=InternalRichString)?
		//    "ENDIF"
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{RichStringIf}
		//"IF" if=XExpression
		//    then=InternalRichString
		//    elseIfs+=RichStringElseIf*
		//("ELSE"
		//    else=InternalRichString)?
		//"ENDIF"
		public Group getGroup() { return cGroup; }
		
		//{RichStringIf}
		public Action getRichStringIfAction_0() { return cRichStringIfAction_0; }
		
		//"IF"
		public Keyword getIFKeyword_1() { return cIFKeyword_1; }
		
		//if=XExpression
		public Assignment getIfAssignment_2() { return cIfAssignment_2; }
		
		//XExpression
		public RuleCall getIfXExpressionParserRuleCall_2_0() { return cIfXExpressionParserRuleCall_2_0; }
		
		//then=InternalRichString
		public Assignment getThenAssignment_3() { return cThenAssignment_3; }
		
		//InternalRichString
		public RuleCall getThenInternalRichStringParserRuleCall_3_0() { return cThenInternalRichStringParserRuleCall_3_0; }
		
		//elseIfs+=RichStringElseIf*
		public Assignment getElseIfsAssignment_4() { return cElseIfsAssignment_4; }
		
		//RichStringElseIf
		public RuleCall getElseIfsRichStringElseIfParserRuleCall_4_0() { return cElseIfsRichStringElseIfParserRuleCall_4_0; }
		
		//("ELSE"
		//    else=InternalRichString)?
		public Group getGroup_5() { return cGroup_5; }
		
		//"ELSE"
		public Keyword getELSEKeyword_5_0() { return cELSEKeyword_5_0; }
		
		//else=InternalRichString
		public Assignment getElseAssignment_5_1() { return cElseAssignment_5_1; }
		
		//InternalRichString
		public RuleCall getElseInternalRichStringParserRuleCall_5_1_0() { return cElseInternalRichStringParserRuleCall_5_1_0; }
		
		//"ENDIF"
		public Keyword getENDIFKeyword_6() { return cENDIFKeyword_6; }
	}
	public class RichStringElseIfElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.RichStringElseIf");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cELSEIFKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cIfAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cIfXExpressionParserRuleCall_1_0 = (RuleCall)cIfAssignment_1.eContents().get(0);
		private final Assignment cThenAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cThenInternalRichStringParserRuleCall_2_0 = (RuleCall)cThenAssignment_2.eContents().get(0);
		
		//RichStringElseIf returns RichStringElseIf:
		//    "ELSEIF" if=XExpression then=InternalRichString
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//"ELSEIF" if=XExpression then=InternalRichString
		public Group getGroup() { return cGroup; }
		
		//"ELSEIF"
		public Keyword getELSEIFKeyword_0() { return cELSEIFKeyword_0; }
		
		//if=XExpression
		public Assignment getIfAssignment_1() { return cIfAssignment_1; }
		
		//XExpression
		public RuleCall getIfXExpressionParserRuleCall_1_0() { return cIfXExpressionParserRuleCall_1_0; }
		
		//then=InternalRichString
		public Assignment getThenAssignment_2() { return cThenAssignment_2; }
		
		//InternalRichString
		public RuleCall getThenInternalRichStringParserRuleCall_2_0() { return cThenInternalRichStringParserRuleCall_2_0; }
	}
	
	
	private final FileElements pFile;
	private final TypeElements pType;
	private final JvmSuperTypeReferenceElements pJvmSuperTypeReference;
	private final XFunctionSuperTypeRefElements pXFunctionSuperTypeRef;
	private final AnnotationFieldElements pAnnotationField;
	private final MemberElements pMember;
	private final TypeReferenceNoTypeArgsElements pTypeReferenceNoTypeArgs;
	private final TypeReferenceWithTypeArgsElements pTypeReferenceWithTypeArgs;
	private final ParameterizedTypeReferenceWithTypeArgsElements pParameterizedTypeReferenceWithTypeArgs;
	private final FunctionIDElements pFunctionID;
	private final OperatorsElements pOperators;
	private final XtendEnumLiteralElements pXtendEnumLiteral;
	private final CommonModifierElements pCommonModifier;
	private final FieldModifierElements pFieldModifier;
	private final MethodModifierElements pMethodModifier;
	private final CreateExtensionInfoElements pCreateExtensionInfo;
	private final ValidIDElements pValidID;
	private final FeatureCallIDElements pFeatureCallID;
	private final InnerVarIDElements pInnerVarID;
	private final ParameterElements pParameter;
	private final XAssignmentElements pXAssignment;
	private final XConditionalExpressionElements pXConditionalExpression;
	private final XTryCatchFinallyExpressionElements pXTryCatchFinallyExpression;
	private final XVariableDeclarationElements pXVariableDeclaration;
	private final InitializedVariableDeclarationElements pInitializedVariableDeclaration;
	private final VariableModifierElements pVariableModifier;
	private final XConstructorCallElements pXConstructorCall;
	private final XbaseConstructorCallElements pXbaseConstructorCall;
	private final JvmFormalParameterElements pJvmFormalParameter;
	private final FullJvmFormalParameterElements pFullJvmFormalParameter;
	private final MultiTypeReferenceElements pMultiTypeReference;
	private final XStringLiteralElements pXStringLiteral;
	private final XSwitchExpressionElements pXSwitchExpression;
	private final XCasePartElements pXCasePart;
	private final XExpressionOrSimpleConstructorCallElements pXExpressionOrSimpleConstructorCall;
	private final SimpleStringLiteralElements pSimpleStringLiteral;
	private final RichStringElements pRichString;
	private final RichStringLiteralElements pRichStringLiteral;
	private final RichStringLiteralStartElements pRichStringLiteralStart;
	private final RichStringLiteralInbetweenElements pRichStringLiteralInbetween;
	private final RichStringLiteralEndElements pRichStringLiteralEnd;
	private final InternalRichStringElements pInternalRichString;
	private final RichStringPartElements pRichStringPart;
	private final RichStringForLoopElements pRichStringForLoop;
	private final RichStringIfElements pRichStringIf;
	private final RichStringElseIfElements pRichStringElseIf;
	private final TerminalRule tID;
	private final TerminalRule tHEX_DIGIT;
	private final TerminalRule tUNICODE_ESCAPE;
	private final TerminalRule tRICH_TEXT;
	private final TerminalRule tRICH_TEXT_START;
	private final TerminalRule tRICH_TEXT_END;
	private final TerminalRule tRICH_TEXT_INBETWEEN;
	private final TerminalRule tCOMMENT_RICH_TEXT_INBETWEEN;
	private final TerminalRule tCOMMENT_RICH_TEXT_END;
	private final TerminalRule tIN_RICH_STRING;
	private final TerminalRule tIDENTIFIER_START;
	private final TerminalRule tIDENTIFIER_PART;
	private final TerminalRule tIDENTIFIER_PART_IMPL;
	
	private final Grammar grammar;
	
	private final XbaseWithAnnotationsGrammarAccess gaXbaseWithAnnotations;
	
	private final XbaseGrammarAccess gaXbase;
	
	private final XtypeGrammarAccess gaXtype;

	@Inject
	public XtendGrammarAccess(GrammarProvider grammarProvider,
			XbaseWithAnnotationsGrammarAccess gaXbaseWithAnnotations,
			XbaseGrammarAccess gaXbase,
			XtypeGrammarAccess gaXtype) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaXbaseWithAnnotations = gaXbaseWithAnnotations;
		this.gaXbase = gaXbase;
		this.gaXtype = gaXtype;
		this.pFile = new FileElements();
		this.pType = new TypeElements();
		this.pJvmSuperTypeReference = new JvmSuperTypeReferenceElements();
		this.pXFunctionSuperTypeRef = new XFunctionSuperTypeRefElements();
		this.pAnnotationField = new AnnotationFieldElements();
		this.pMember = new MemberElements();
		this.pTypeReferenceNoTypeArgs = new TypeReferenceNoTypeArgsElements();
		this.pTypeReferenceWithTypeArgs = new TypeReferenceWithTypeArgsElements();
		this.pParameterizedTypeReferenceWithTypeArgs = new ParameterizedTypeReferenceWithTypeArgsElements();
		this.pFunctionID = new FunctionIDElements();
		this.pOperators = new OperatorsElements();
		this.pXtendEnumLiteral = new XtendEnumLiteralElements();
		this.pCommonModifier = new CommonModifierElements();
		this.pFieldModifier = new FieldModifierElements();
		this.pMethodModifier = new MethodModifierElements();
		this.pCreateExtensionInfo = new CreateExtensionInfoElements();
		this.pValidID = new ValidIDElements();
		this.pFeatureCallID = new FeatureCallIDElements();
		this.pInnerVarID = new InnerVarIDElements();
		this.pParameter = new ParameterElements();
		this.pXAssignment = new XAssignmentElements();
		this.pXConditionalExpression = new XConditionalExpressionElements();
		this.pXTryCatchFinallyExpression = new XTryCatchFinallyExpressionElements();
		this.pXVariableDeclaration = new XVariableDeclarationElements();
		this.pInitializedVariableDeclaration = new InitializedVariableDeclarationElements();
		this.pVariableModifier = new VariableModifierElements();
		this.pXConstructorCall = new XConstructorCallElements();
		this.pXbaseConstructorCall = new XbaseConstructorCallElements();
		this.pJvmFormalParameter = new JvmFormalParameterElements();
		this.pFullJvmFormalParameter = new FullJvmFormalParameterElements();
		this.pMultiTypeReference = new MultiTypeReferenceElements();
		this.pXStringLiteral = new XStringLiteralElements();
		this.pXSwitchExpression = new XSwitchExpressionElements();
		this.pXCasePart = new XCasePartElements();
		this.pXExpressionOrSimpleConstructorCall = new XExpressionOrSimpleConstructorCallElements();
		this.pSimpleStringLiteral = new SimpleStringLiteralElements();
		this.pRichString = new RichStringElements();
		this.pRichStringLiteral = new RichStringLiteralElements();
		this.pRichStringLiteralStart = new RichStringLiteralStartElements();
		this.pRichStringLiteralInbetween = new RichStringLiteralInbetweenElements();
		this.pRichStringLiteralEnd = new RichStringLiteralEndElements();
		this.pInternalRichString = new InternalRichStringElements();
		this.pRichStringPart = new RichStringPartElements();
		this.pRichStringForLoop = new RichStringForLoopElements();
		this.pRichStringIf = new RichStringIfElements();
		this.pRichStringElseIf = new RichStringElseIfElements();
		this.tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.ID");
		this.tHEX_DIGIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.HEX_DIGIT");
		this.tUNICODE_ESCAPE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.UNICODE_ESCAPE");
		this.tRICH_TEXT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.RICH_TEXT");
		this.tRICH_TEXT_START = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.RICH_TEXT_START");
		this.tRICH_TEXT_END = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.RICH_TEXT_END");
		this.tRICH_TEXT_INBETWEEN = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.RICH_TEXT_INBETWEEN");
		this.tCOMMENT_RICH_TEXT_INBETWEEN = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.COMMENT_RICH_TEXT_INBETWEEN");
		this.tCOMMENT_RICH_TEXT_END = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.COMMENT_RICH_TEXT_END");
		this.tIN_RICH_STRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.IN_RICH_STRING");
		this.tIDENTIFIER_START = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.IDENTIFIER_START");
		this.tIDENTIFIER_PART = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.IDENTIFIER_PART");
		this.tIDENTIFIER_PART_IMPL = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtend.core.Xtend.IDENTIFIER_PART_IMPL");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.xtend.core.Xtend".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public XbaseWithAnnotationsGrammarAccess getXbaseWithAnnotationsGrammarAccess() {
		return gaXbaseWithAnnotations;
	}
	
	public XbaseGrammarAccess getXbaseGrammarAccess() {
		return gaXbase;
	}
	
	public XtypeGrammarAccess getXtypeGrammarAccess() {
		return gaXtype;
	}

	
	//File returns XtendFile :
	//    ('package' package=QualifiedName ';'?)?
	//    importSection=XImportSection?
	//    (xtendTypes+=Type)*
	//;
	public FileElements getFileAccess() {
		return pFile;
	}
	
	public ParserRule getFileRule() {
		return getFileAccess().getRule();
	}
	
	//Type returns XtendTypeDeclaration :
	//    {XtendTypeDeclaration} annotations+=XAnnotation*
	//    (
	//        {XtendClass.annotationInfo = current}
	//        modifiers+=CommonModifier*
	//        'class' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
	//        ("extends" extends=JvmParameterizedTypeReference)?
	//        ('implements' implements+=JvmSuperTypeReference (',' implements+=JvmSuperTypeReference)*)?'{'
	//            (members+=Member)*
	//        '}'
	//     |
	//        {XtendInterface.annotationInfo = current}
	//        modifiers+=CommonModifier*
	//        'interface' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
	//        ('extends' extends+=JvmSuperTypeReference (',' extends+=JvmSuperTypeReference)*)?'{'
	//            (members+=Member)*
	//        '}'
	//     |
	//        {XtendEnum.annotationInfo = current}
	//        modifiers+=CommonModifier*
	//        'enum' name=ValidID '{'
	//            (members+=XtendEnumLiteral (',' members+=XtendEnumLiteral)*)? ';'?
	//        '}'
	//     |
	//        {XtendAnnotationType.annotationInfo = current}
	//        modifiers+=CommonModifier*
	//        'annotation' name=ValidID '{'
	//            (members+=AnnotationField)*
	//        '}'
	//    )
	//;
	public TypeElements getTypeAccess() {
		return pType;
	}
	
	public ParserRule getTypeRule() {
		return getTypeAccess().getRule();
	}
	
	//JvmSuperTypeReference returns types::JvmTypeReference:
	//    JvmParameterizedTypeReference | XFunctionSuperTypeRef
	//;
	public JvmSuperTypeReferenceElements getJvmSuperTypeReferenceAccess() {
		return pJvmSuperTypeReference;
	}
	
	public ParserRule getJvmSuperTypeReferenceRule() {
		return getJvmSuperTypeReferenceAccess().getRule();
	}
	
	//XFunctionSuperTypeRef returns xtype::XFunctionTypeRef:
	//    (instanceContext?='(' (paramTypes+=JvmTypeReference (',' paramTypes+=JvmTypeReference)*)? ')')? '=>' returnType=JvmTypeReference;
	public XFunctionSuperTypeRefElements getXFunctionSuperTypeRefAccess() {
		return pXFunctionSuperTypeRef;
	}
	
	public ParserRule getXFunctionSuperTypeRefRule() {
		return getXFunctionSuperTypeRefAccess().getRule();
	}
	
	//AnnotationField returns XtendMember :
	//    {XtendMember} annotations+=XAnnotation*
	//    (
	//        (
	//                {XtendField.annotationInfo = current} modifiers+=CommonModifier*
	//                modifiers+=FieldModifier modifiers+=CommonModifier*
	//                type=JvmTypeReference? name=ValidID
	//            |    {XtendField.annotationInfo = current} modifiers+=CommonModifier*
	//                type=JvmTypeReference name=ValidID
	//        ) ('=' initialValue=XAnnotationElementValue)? ';'?
	//        | (
	//            {XtendClass.annotationInfo = current}
	//            modifiers+=CommonModifier*
	//            'class' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
	//            ("extends" extends=JvmParameterizedTypeReference)?
	//            ('implements' implements+=JvmParameterizedTypeReference (',' implements+=JvmParameterizedTypeReference)*)?'{'
	//                (members+=Member)*
	//            '}'
	//        ) | (
	//            {XtendInterface.annotationInfo = current}
	//            modifiers+=CommonModifier*
	//            'interface' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
	//            ('extends' extends+=JvmParameterizedTypeReference (',' extends+=JvmParameterizedTypeReference)*)?'{'
	//                (members+=Member)*
	//            '}'
	//        ) | (
	//            {XtendEnum.annotationInfo = current}
	//            modifiers+=CommonModifier*
	//            'enum' name=ValidID '{'
	//                (members+=XtendEnumLiteral (',' members+=XtendEnumLiteral)*)? ';'?
	//            '}'
	//        ) | (
	//            {XtendAnnotationType.annotationInfo = current}
	//            modifiers+=CommonModifier*
	//            'annotation' name=ValidID '{'
	//                (members+=AnnotationField)*
	//            '}'
	//        )
	//    )
	//;
	public AnnotationFieldElements getAnnotationFieldAccess() {
		return pAnnotationField;
	}
	
	public ParserRule getAnnotationFieldRule() {
		return getAnnotationFieldAccess().getRule();
	}
	
	//Member returns XtendMember:
	//    {XtendMember} annotations+=XAnnotation*
	//    (
	//        (
	//            {XtendField.annotationInfo = current} modifiers+=CommonModifier*
	//            (
	//                modifiers+=FieldModifier modifiers+=CommonModifier*
	//                type=JvmTypeReference? name=ValidID
	//            |
	//                modifiers+='extension' (modifiers+=FieldModifier | modifiers+=CommonModifier)*
	//                type=JvmTypeReference name=ValidID?
	//            |
	//                modifiers+=FieldModifier (modifiers+=CommonModifier)* modifiers+='extension' (modifiers+=CommonModifier)*
	//                type=JvmTypeReference name=ValidID?
	//            |
	//                type=JvmTypeReference name=ValidID
	//            ) ('=' initialValue=XExpression)? ';'?
	//        ) | (
	//            {XtendFunction.annotationInfo = current} modifiers+=CommonModifier*
	//            modifiers+=MethodModifier (modifiers+=CommonModifier | modifiers+=MethodModifier)*
	//            ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
	//            (
	//                =>(returnType=JvmTypeReference createExtensionInfo=CreateExtensionInfo name=ValidID '(')
	//              | =>(returnType=TypeReferenceWithTypeArgs name=FunctionID '(')
	//              | =>(returnType=TypeReferenceNoTypeArgs name=FunctionID '(')
	//              | =>(createExtensionInfo=CreateExtensionInfo name=ValidID '(')
	//              | name=FunctionID '('
	//            )
	//            (parameters+=Parameter (',' parameters+=Parameter)*)? ')'
	//            ('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
	//            (expression=XBlockExpression | expression=RichString | ';')?
	//        ) | (
	//            {XtendConstructor.annotationInfo = current} modifiers+=CommonModifier*
	//            'new'
	//            ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
	//            '(' (parameters+=Parameter (',' parameters+=Parameter)*)? ')'
	//            ('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
	//            expression=XBlockExpression
	//        ) | (
	//            {XtendClass.annotationInfo = current}
	//            modifiers+=CommonModifier*
	//            'class' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
	//            ("extends" extends=JvmParameterizedTypeReference)?
	//            ('implements' implements+=JvmParameterizedTypeReference (',' implements+=JvmParameterizedTypeReference)*)?'{'
	//                (members+=Member)*
	//            '}'
	//        ) | (
	//            {XtendInterface.annotationInfo = current}
	//            modifiers+=CommonModifier*
	//            'interface' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
	//            ('extends' extends+=JvmParameterizedTypeReference (',' extends+=JvmParameterizedTypeReference)*)?'{'
	//                (members+=Member)*
	//            '}'
	//        ) | (
	//            {XtendEnum.annotationInfo = current}
	//            modifiers+=CommonModifier*
	//            'enum' name=ValidID '{'
	//                (members+=XtendEnumLiteral (',' members+=XtendEnumLiteral)*)? ';'?
	//            '}'
	//        ) | (
	//            {XtendAnnotationType.annotationInfo = current}
	//            modifiers+=CommonModifier*
	//            'annotation' name=ValidID '{'
	//                (members+=AnnotationField)*
	//            '}'
	//        )
	//    )
	//;
	public MemberElements getMemberAccess() {
		return pMember;
	}
	
	public ParserRule getMemberRule() {
		return getMemberAccess().getRule();
	}
	
	//TypeReferenceNoTypeArgs returns types::JvmParameterizedTypeReference:
	//    type=[types::JvmType|QualifiedName]
	//;
	public TypeReferenceNoTypeArgsElements getTypeReferenceNoTypeArgsAccess() {
		return pTypeReferenceNoTypeArgs;
	}
	
	public ParserRule getTypeReferenceNoTypeArgsRule() {
		return getTypeReferenceNoTypeArgsAccess().getRule();
	}
	
	///*** The following two rules are a workaround for a limitation in serialization logic
	// *
	// * Apparently we choose the shortest possible path to create the sequence of unassigned
	// * tokens between two assigned values. This doesn't work well with Antlr predicates which
	// * may have lead to another decision path - not necessarily the shortest one in the sense
	// * of the serializer. That's why we make the type arguments mandatory here so that we
	// * do no longer have two equally short path's from method identifier to block expression
	// **************************************************************************************/
	//TypeReferenceWithTypeArgs returns types::JvmTypeReference:
	//    ParameterizedTypeReferenceWithTypeArgs =>({types::JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)*
	//  | TypeReferenceNoTypeArgs =>({types::JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)+
	//  | XFunctionTypeRef
	//;
	public TypeReferenceWithTypeArgsElements getTypeReferenceWithTypeArgsAccess() {
		return pTypeReferenceWithTypeArgs;
	}
	
	public ParserRule getTypeReferenceWithTypeArgsRule() {
		return getTypeReferenceWithTypeArgsAccess().getRule();
	}
	
	//ParameterizedTypeReferenceWithTypeArgs returns types::JvmParameterizedTypeReference:
	//    type=[types::JvmType|QualifiedName] (
	//        '<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>'
	//        (=>({types::JvmInnerTypeReference.outer=current} '.') type=[types::JvmType|ValidID] (=>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>')?)*
	//    )
	//;
	public ParameterizedTypeReferenceWithTypeArgsElements getParameterizedTypeReferenceWithTypeArgsAccess() {
		return pParameterizedTypeReferenceWithTypeArgs;
	}
	
	public ParserRule getParameterizedTypeReferenceWithTypeArgsRule() {
		return getParameterizedTypeReferenceWithTypeArgsAccess().getRule();
	}
	
	///*** The following two rules are a workaround for a limitation in serialiation logic */
	//FunctionID:
	//    ValidID | Operators
	//;
	public FunctionIDElements getFunctionIDAccess() {
		return pFunctionID;
	}
	
	public ParserRule getFunctionIDRule() {
		return getFunctionIDAccess().getRule();
	}
	
	//Operators:
	//      OpMultiAssign
	//    | OpOr
	//    | OpAnd
	//    | OpEquality
	//    | OpCompare
	//    | OpOther
	////    | OpAdd completely contained in OpUnary
	//    | OpMulti
	//    | OpUnary
	//    | OpPostfix
	//;
	public OperatorsElements getOperatorsAccess() {
		return pOperators;
	}
	
	public ParserRule getOperatorsRule() {
		return getOperatorsAccess().getRule();
	}
	
	//XtendEnumLiteral:
	//    annotations+=XAnnotation*
	//    name=ValidID
	//;
	public XtendEnumLiteralElements getXtendEnumLiteralAccess() {
		return pXtendEnumLiteral;
	}
	
	public ParserRule getXtendEnumLiteralRule() {
		return getXtendEnumLiteralAccess().getRule();
	}
	
	//CommonModifier:
	//        'public' | 'private' | 'protected' | 'package' | 'abstract' | 'static' | 'dispatch' | 'final'
	//        | 'strictfp' | 'native' |'volatile' | 'synchronized' | 'transient'
	//;
	public CommonModifierElements getCommonModifierAccess() {
		return pCommonModifier;
	}
	
	public ParserRule getCommonModifierRule() {
		return getCommonModifierAccess().getRule();
	}
	
	//FieldModifier:
	//        'val' | 'var'
	//;
	public FieldModifierElements getFieldModifierAccess() {
		return pFieldModifier;
	}
	
	public ParserRule getFieldModifierRule() {
		return getFieldModifierAccess().getRule();
	}
	
	//MethodModifier:
	//        'def' | 'override'
	//;
	public MethodModifierElements getMethodModifierAccess() {
		return pMethodModifier;
	}
	
	public ParserRule getMethodModifierRule() {
		return getMethodModifierAccess().getRule();
	}
	
	//CreateExtensionInfo:
	//    'create' (name=ValidID ':')? createExpression=XExpression
	//;
	public CreateExtensionInfoElements getCreateExtensionInfoAccess() {
		return pCreateExtensionInfo;
	}
	
	public ParserRule getCreateExtensionInfoRule() {
		return getCreateExtensionInfoAccess().getRule();
	}
	
	//@Override
	//ValidID:
	//    ID | 'create' | 'annotation' | 'AFTER' | 'BEFORE' | 'SEPARATOR'
	//;
	public ValidIDElements getValidIDAccess() {
		return pValidID;
	}
	
	public ParserRule getValidIDRule() {
		return getValidIDAccess().getRule();
	}
	
	//// For feature calls we add 'extension' since there are method such as 'isExtension' or 'getExtension' out there.
	//@Override
	//FeatureCallID:
	//    InnerVarID | 'extension'
	//;
	public FeatureCallIDElements getFeatureCallIDAccess() {
		return pFeatureCallID;
	}
	
	public ParserRule getFeatureCallIDRule() {
		return getFeatureCallIDAccess().getRule();
	}
	
	//InnerVarID:
	//    ID | 'abstract' | 'annotation' | 'class' | 'create' | 'def' | 'dispatch' | 'enum' | 'extends'
	//       | 'final' | 'implements' | 'import' | 'interface' | 'override' | 'package' | 'public' | 'private'
	//       | 'protected' | 'static' | 'throws' | 'strictfp' | 'native' | 'volatile' | 'synchronized' | 'transient'
	//       | 'AFTER' | 'BEFORE' | 'SEPARATOR'
	//;
	public InnerVarIDElements getInnerVarIDAccess() {
		return pInnerVarID;
	}
	
	public ParserRule getInnerVarIDRule() {
		return getInnerVarIDAccess().getRule();
	}
	
	//Parameter returns XtendParameter:
	//    annotations+=XAnnotation* (extension?='extension' annotations+=XAnnotation*)?
	//    parameterType=JvmTypeReference varArg?='...'? name=ValidID;
	public ParameterElements getParameterAccess() {
		return pParameter;
	}
	
	public ParserRule getParameterRule() {
		return getParameterAccess().getRule();
	}
	
	//@Override
	//XAssignment returns xbase::XExpression :
	//    {xbase::XAssignment} feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign value=XAssignment |
	//    XConditionalExpression (
	//        =>({xbase::XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMultiAssign]) rightOperand=XAssignment
	//    )?;
	public XAssignmentElements getXAssignmentAccess() {
		return pXAssignment;
	}
	
	public ParserRule getXAssignmentRule() {
		return getXAssignmentAccess().getRule();
	}
	
	//XConditionalExpression returns xbase::XExpression :
	//    XOrExpression (
	//        // The java grammar does only allow other XConditionalExpression after the colon, but we can be more relaxed
	//        ->({xbase::XIfExpression.if=current} conditionalExpression?='?') then=XExpression (->':' else=XExpression)?
	//    )?
	//;
	public XConditionalExpressionElements getXConditionalExpressionAccess() {
		return pXConditionalExpression;
	}
	
	public ParserRule getXConditionalExpressionRule() {
		return getXConditionalExpressionAccess().getRule();
	}
	
	//@Override
	//XTryCatchFinallyExpression returns xbase::XExpression:
	//    {xbase::XTryCatchFinallyExpression}
	//    'try' (
	//        '(' resources+=InitializedVariableDeclaration (';' resources+=InitializedVariableDeclaration)* ';'? ')'
	//        expression=XExpression
	//        ->(
	//            catchClauses+=XCatchClause+
	//            (=>'finally' finallyExpression=XExpression)?
	//        |    'finally' finallyExpression=XExpression
	//        )?
	//    |
	//        expression=XExpression
	//        (
	//            catchClauses+=XCatchClause+
	//            (=>'finally' finallyExpression=XExpression)?
	//        |    'finally' finallyExpression=XExpression
	//        )
	//    )
	//;
	public XTryCatchFinallyExpressionElements getXTryCatchFinallyExpressionAccess() {
		return pXTryCatchFinallyExpression;
	}
	
	public ParserRule getXTryCatchFinallyExpressionRule() {
		return getXTryCatchFinallyExpressionAccess().getRule();
	}
	
	//@Override
	//XVariableDeclaration returns xbase::XExpression:
	//    =>({XtendVariableDeclaration} VariableModifier)
	//    (=>(type=JvmTypeReference name=InnerVarID) | name=InnerVarID) ('=' right=XExpression)?;
	public XVariableDeclarationElements getXVariableDeclarationAccess() {
		return pXVariableDeclaration;
	}
	
	public ParserRule getXVariableDeclarationRule() {
		return getXVariableDeclarationAccess().getRule();
	}
	
	//InitializedVariableDeclaration returns XtendVariableDeclaration:
	//    {XtendVariableDeclaration}
	//    VariableModifier
	//    (=>(type=JvmTypeReference name=InnerVarID) | name=InnerVarID) '=' right=XExpression
	//;
	public InitializedVariableDeclarationElements getInitializedVariableDeclarationAccess() {
		return pInitializedVariableDeclaration;
	}
	
	public ParserRule getInitializedVariableDeclarationRule() {
		return getInitializedVariableDeclarationAccess().getRule();
	}
	
	//fragment VariableModifier *:
	//      (writeable?='var'|'val') extension?='extension'?
	//    | extension?='extension' (writeable?='var'|'val')
	//;
	public VariableModifierElements getVariableModifierAccess() {
		return pVariableModifier;
	}
	
	public ParserRule getVariableModifierRule() {
		return getVariableModifierAccess().getRule();
	}
	
	//@Override
	//XConstructorCall returns xbase::XExpression:
	//    XbaseConstructorCall (=>({AnonymousClass.constructorCall=current} '{') members+=Member* '}')?
	//;
	public XConstructorCallElements getXConstructorCallAccess() {
		return pXConstructorCall;
	}
	
	public ParserRule getXConstructorCallRule() {
		return getXConstructorCallAccess().getRule();
	}
	
	//XbaseConstructorCall returns xbase::XConstructorCall:
	//    {xbase::XConstructorCall}
	//    'new' constructor=[types::JvmConstructor|QualifiedName]
	//    (=>'<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
	//    (=>explicitConstructorCall?='('
	//        (
	//            arguments+=XShortClosure
	//          | arguments+=XExpression (',' arguments+=XExpression)*
	//        )?
	//    ')')?
	//    (arguments+=XClosure)?
	//;
	public XbaseConstructorCallElements getXbaseConstructorCallAccess() {
		return pXbaseConstructorCall;
	}
	
	public ParserRule getXbaseConstructorCallRule() {
		return getXbaseConstructorCallAccess().getRule();
	}
	
	//@Override
	//JvmFormalParameter returns XtendFormalParameter:
	//    extension?='extension'? (parameterType=JvmTypeReference)? name=InnerVarID;
	public JvmFormalParameterElements getJvmFormalParameterAccess() {
		return pJvmFormalParameter;
	}
	
	public ParserRule getJvmFormalParameterRule() {
		return getJvmFormalParameterAccess().getRule();
	}
	
	///*
	// * Since we only use FullJvmFormalParameter for catch variables, it is safe to
	// * use a MultiTypeReference here as the type.
	// */
	//@Override
	//FullJvmFormalParameter returns XtendFormalParameter:
	//    extension?='extension'? parameterType=MultiTypeReference name=InnerVarID
	//;
	public FullJvmFormalParameterElements getFullJvmFormalParameterAccess() {
		return pFullJvmFormalParameter;
	}
	
	public ParserRule getFullJvmFormalParameterRule() {
		return getFullJvmFormalParameterAccess().getRule();
	}
	
	//MultiTypeReference returns types::JvmTypeReference:
	//    JvmTypeReference ({types::JvmSynonymTypeReference.references+=current} ('|' references+=JvmTypeReference)+)?
	//;
	public MultiTypeReferenceElements getMultiTypeReferenceAccess() {
		return pMultiTypeReference;
	}
	
	public ParserRule getMultiTypeReferenceRule() {
		return getMultiTypeReferenceAccess().getRule();
	}
	
	//@Override
	//XStringLiteral returns xbase::XExpression:
	//    SimpleStringLiteral | RichString
	//;
	public XStringLiteralElements getXStringLiteralAccess() {
		return pXStringLiteral;
	}
	
	public ParserRule getXStringLiteralRule() {
		return getXStringLiteralAccess().getRule();
	}
	
	//@Override
	//XSwitchExpression returns xbase::XExpression:
	//    {xbase::XSwitchExpression}
	//    'switch' (=>('(' declaredParam=JvmFormalParameter ':') switch=XExpression ')'
	//        | =>(declaredParam=JvmFormalParameter ':')? switch=XExpressionOrSimpleConstructorCall) '{'
	//    (cases+=XCasePart)*
	//    ('default' ':' default=XExpression )?
	//    '}'
	//;
	public XSwitchExpressionElements getXSwitchExpressionAccess() {
		return pXSwitchExpression;
	}
	
	public ParserRule getXSwitchExpressionRule() {
		return getXSwitchExpressionAccess().getRule();
	}
	
	//@Override
	//XCasePart returns xbase::XCasePart:
	//    {xbase::XCasePart}
	//    typeGuard=MultiTypeReference? ('case' case=XExpression)?
	//        (':' then=XExpression | fallThrough?=',')
	//;
	public XCasePartElements getXCasePartAccess() {
		return pXCasePart;
	}
	
	public ParserRule getXCasePartRule() {
		return getXCasePartAccess().getRule();
	}
	
	//XExpressionOrSimpleConstructorCall returns xbase::XExpression:
	//    ->XbaseConstructorCall | XExpression
	//;
	public XExpressionOrSimpleConstructorCallElements getXExpressionOrSimpleConstructorCallAccess() {
		return pXExpressionOrSimpleConstructorCall;
	}
	
	public ParserRule getXExpressionOrSimpleConstructorCallRule() {
		return getXExpressionOrSimpleConstructorCallAccess().getRule();
	}
	
	//SimpleStringLiteral returns xbase::XExpression:
	//    {xbase::XStringLiteral} value=STRING
	//;
	public SimpleStringLiteralElements getSimpleStringLiteralAccess() {
		return pSimpleStringLiteral;
	}
	
	public ParserRule getSimpleStringLiteralRule() {
		return getSimpleStringLiteralAccess().getRule();
	}
	
	//RichString returns xbase::XExpression:
	//    {RichString} (
	//        expressions+=RichStringLiteral |
	//        expressions+=RichStringLiteralStart expressions+=RichStringPart?
	//        (expressions+=RichStringLiteralInbetween expressions+=RichStringPart?)*
	//        expressions+=RichStringLiteralEnd
	//    )
	//;
	public RichStringElements getRichStringAccess() {
		return pRichString;
	}
	
	public ParserRule getRichStringRule() {
		return getRichStringAccess().getRule();
	}
	
	//RichStringLiteral returns xbase::XExpression :
	//    {RichStringLiteral} value=RICH_TEXT
	//;
	public RichStringLiteralElements getRichStringLiteralAccess() {
		return pRichStringLiteral;
	}
	
	public ParserRule getRichStringLiteralRule() {
		return getRichStringLiteralAccess().getRule();
	}
	
	//RichStringLiteralStart returns xbase::XExpression :
	//    {RichStringLiteral} value=RICH_TEXT_START
	//;
	public RichStringLiteralStartElements getRichStringLiteralStartAccess() {
		return pRichStringLiteralStart;
	}
	
	public ParserRule getRichStringLiteralStartRule() {
		return getRichStringLiteralStartAccess().getRule();
	}
	
	//RichStringLiteralInbetween returns xbase::XExpression :
	//    {RichStringLiteral}
	//    ( value=RICH_TEXT_INBETWEEN | value=COMMENT_RICH_TEXT_INBETWEEN )
	//;
	public RichStringLiteralInbetweenElements getRichStringLiteralInbetweenAccess() {
		return pRichStringLiteralInbetween;
	}
	
	public ParserRule getRichStringLiteralInbetweenRule() {
		return getRichStringLiteralInbetweenAccess().getRule();
	}
	
	//RichStringLiteralEnd returns xbase::XExpression :
	//    {RichStringLiteral}
	//    ( value=RICH_TEXT_END | value=COMMENT_RICH_TEXT_END )
	//;
	public RichStringLiteralEndElements getRichStringLiteralEndAccess() {
		return pRichStringLiteralEnd;
	}
	
	public ParserRule getRichStringLiteralEndRule() {
		return getRichStringLiteralEndAccess().getRule();
	}
	
	//InternalRichString returns xbase::XExpression:
	//    {RichString} (
	//        expressions+=RichStringLiteralInbetween (expressions+=RichStringPart? expressions+=RichStringLiteralInbetween)*
	//    )
	//;
	public InternalRichStringElements getInternalRichStringAccess() {
		return pInternalRichString;
	}
	
	public ParserRule getInternalRichStringRule() {
		return getInternalRichStringAccess().getRule();
	}
	
	//RichStringPart returns xbase::XExpression:
	//    XExpressionOrVarDeclaration |
	//    RichStringForLoop |
	//    RichStringIf
	//;
	public RichStringPartElements getRichStringPartAccess() {
		return pRichStringPart;
	}
	
	public ParserRule getRichStringPartRule() {
		return getRichStringPartAccess().getRule();
	}
	
	//RichStringForLoop returns xbase::XExpression:
	//    {RichStringForLoop}
	//    "FOR" declaredParam=JvmFormalParameter ':' forExpression=XExpression
	//        ("BEFORE" before=XExpression)?
	//        ("SEPARATOR" separator=XExpression)?
	//        ("AFTER" after=XExpression)?
	//        eachExpression=InternalRichString
	//    "ENDFOR"
	//;
	public RichStringForLoopElements getRichStringForLoopAccess() {
		return pRichStringForLoop;
	}
	
	public ParserRule getRichStringForLoopRule() {
		return getRichStringForLoopAccess().getRule();
	}
	
	//RichStringIf returns xbase::XExpression :
	//    {RichStringIf}
	//    "IF" if=XExpression
	//        then=InternalRichString
	//        elseIfs+=RichStringElseIf*
	//    ("ELSE"
	//        else=InternalRichString)?
	//    "ENDIF"
	//;
	public RichStringIfElements getRichStringIfAccess() {
		return pRichStringIf;
	}
	
	public ParserRule getRichStringIfRule() {
		return getRichStringIfAccess().getRule();
	}
	
	//RichStringElseIf returns RichStringElseIf:
	//    "ELSEIF" if=XExpression then=InternalRichString
	//;
	public RichStringElseIfElements getRichStringElseIfAccess() {
		return pRichStringElseIf;
	}
	
	public ParserRule getRichStringElseIfRule() {
		return getRichStringElseIfAccess().getRule();
	}
	
	//@Override
	//terminal ID:
	//    '^'? (IDENTIFIER_START | UNICODE_ESCAPE) (IDENTIFIER_PART | UNICODE_ESCAPE)*
	//;
	public TerminalRule getIDRule() {
		return tID;
	}
	
	//terminal fragment HEX_DIGIT:
	//    '0'..'9' | 'a'..'f' | 'A'..'F'
	//;
	public TerminalRule getHEX_DIGITRule() {
		return tHEX_DIGIT;
	}
	
	//terminal fragment UNICODE_ESCAPE:
	//    '\\' 'u' ( HEX_DIGIT ( HEX_DIGIT ( HEX_DIGIT HEX_DIGIT? )? )? )?
	//;
	public TerminalRule getUNICODE_ESCAPERule() {
		return tUNICODE_ESCAPE;
	}
	
	//terminal RICH_TEXT : "'''" IN_RICH_STRING* ("'''"| ("'" "'"?)? EOF);
	public TerminalRule getRICH_TEXTRule() {
		return tRICH_TEXT;
	}
	
	//terminal RICH_TEXT_START : "'''" IN_RICH_STRING* ("'" "'"?)? 'л';
	public TerminalRule getRICH_TEXT_STARTRule() {
		return tRICH_TEXT_START;
	}
	
	//terminal RICH_TEXT_END : '╗' IN_RICH_STRING* ("'''"| ("'" "'"?)? EOF) ;
	public TerminalRule getRICH_TEXT_ENDRule() {
		return tRICH_TEXT_END;
	}
	
	//terminal RICH_TEXT_INBETWEEN : '╗' IN_RICH_STRING* ("'" "'"?)? 'л';
	public TerminalRule getRICH_TEXT_INBETWEENRule() {
		return tRICH_TEXT_INBETWEEN;
	}
	
	//terminal COMMENT_RICH_TEXT_INBETWEEN: "лл" !('\n'|'\r')* ('\r'? '\n' IN_RICH_STRING* ("'" "'"?)? 'л')?;
	public TerminalRule getCOMMENT_RICH_TEXT_INBETWEENRule() {
		return tCOMMENT_RICH_TEXT_INBETWEEN;
	}
	
	//terminal COMMENT_RICH_TEXT_END: "лл" !('\n'|'\r')* (('\r'? '\n' IN_RICH_STRING* ("'''"| ("'" "'"?)? EOF)) | EOF);
	public TerminalRule getCOMMENT_RICH_TEXT_ENDRule() {
		return tCOMMENT_RICH_TEXT_END;
	}
	
	//terminal fragment IN_RICH_STRING :
	//      "''" !('л'|"'")
	//    | "'" !('л'|"'")
	//    | !('л'|"'");
	public TerminalRule getIN_RICH_STRINGRule() {
		return tIN_RICH_STRING;
	}
	
	//terminal fragment IDENTIFIER_START:
	//      '\u0024'
	//    | '\u0041'..'\u005A'
	//    | '\u005F'
	//    | '\u0061'..'\u007A'
	//    | '\u00A2'..'\u00A5'
	//    | '\u00AA'
	//    | '\u00B5'
	//    | '\u00BA'
	//    | '\u00C0'..'\u00D6'
	//    | '\u00D8'..'\u00F6'
	//    | '\u00F8'..'\u0236'
	//    | '\u0250'..'\u02C1'
	//    | '\u02C6'..'\u02D1'
	//    | '\u02E0'..'\u02E4'
	//    | '\u02EE'
	//    | '\u037A'
	//    | '\u0386'
	//    | '\u0388'..'\u038A'
	//    | '\u038C'
	//    | '\u038E'..'\u03A1'
	//    | '\u03A3'..'\u03CE'
	//    | '\u03D0'..'\u03F5'
	//    | '\u03F7'..'\u03FB'
	//    | '\u0400'..'\u0481'
	//    | '\u048A'..'\u04CE'
	//    | '\u04D0'..'\u04F5'
	//    | '\u04F8'..'\u04F9'
	//    | '\u0500'..'\u050F'
	//    | '\u0531'..'\u0556'
	//    | '\u0559'
	//    | '\u0561'..'\u0587'
	//    | '\u05D0'..'\u05EA'
	//    | '\u05F0'..'\u05F2'
	//    | '\u0621'..'\u063A'
	//    | '\u0640'..'\u064A'
	//    | '\u066E'..'\u066F'
	//    | '\u0671'..'\u06D3'
	//    | '\u06D5'
	//    | '\u06E5'..'\u06E6'
	//    | '\u06EE'..'\u06EF'
	//    | '\u06FA'..'\u06FC'
	//    | '\u06FF'
	//    | '\u0710'
	//    | '\u0712'..'\u072F'
	//    | '\u074D'..'\u074F'
	//    | '\u0780'..'\u07A5'
	//    | '\u07B1'
	//    | '\u0904'..'\u0939'
	//    | '\u093D'
	//    | '\u0950'
	//    | '\u0958'..'\u0961'
	//    | '\u0985'..'\u098C'
	//    | '\u098F'..'\u0990'
	//    | '\u0993'..'\u09A8'
	//    | '\u09AA'..'\u09B0'
	//    | '\u09B2'
	//    | '\u09B6'..'\u09B9'
	//    | '\u09BD'
	//    | '\u09DC'..'\u09DD'
	//    | '\u09DF'..'\u09E1'
	//    | '\u09F0'..'\u09F3'
	//    | '\u0A05'..'\u0A0A'
	//    | '\u0A0F'..'\u0A10'
	//    | '\u0A13'..'\u0A28'
	//    | '\u0A2A'..'\u0A30'
	//    | '\u0A32'..'\u0A33'
	//    | '\u0A35'..'\u0A36'
	//    | '\u0A38'..'\u0A39'
	//    | '\u0A59'..'\u0A5C'
	//    | '\u0A5E'
	//    | '\u0A72'..'\u0A74'
	//    | '\u0A85'..'\u0A8D'
	//    | '\u0A8F'..'\u0A91'
	//    | '\u0A93'..'\u0AA8'
	//    | '\u0AAA'..'\u0AB0'
	//    | '\u0AB2'..'\u0AB3'
	//    | '\u0AB5'..'\u0AB9'
	//    | '\u0ABD'
	//    | '\u0AD0'
	//    | '\u0AE0'..'\u0AE1'
	//    | '\u0AF1'
	//    | '\u0B05'..'\u0B0C'
	//    | '\u0B0F'..'\u0B10'
	//    | '\u0B13'..'\u0B28'
	//    | '\u0B2A'..'\u0B30'
	//    | '\u0B32'..'\u0B33'
	//    | '\u0B35'..'\u0B39'
	//    | '\u0B3D'
	//    | '\u0B5C'..'\u0B5D'
	//    | '\u0B5F'..'\u0B61'
	//    | '\u0B71'
	//    | '\u0B83'
	//    | '\u0B85'..'\u0B8A'
	//    | '\u0B8E'..'\u0B90'
	//    | '\u0B92'..'\u0B95'
	//    | '\u0B99'..'\u0B9A'
	//    | '\u0B9C'
	//    | '\u0B9E'..'\u0B9F'
	//    | '\u0BA3'..'\u0BA4'
	//    | '\u0BA8'..'\u0BAA'
	//    | '\u0BAE'..'\u0BB5'
	//    | '\u0BB7'..'\u0BB9'
	//    | '\u0BF9'
	//    | '\u0C05'..'\u0C0C'
	//    | '\u0C0E'..'\u0C10'
	//    | '\u0C12'..'\u0C28'
	//    | '\u0C2A'..'\u0C33'
	//    | '\u0C35'..'\u0C39'
	//    | '\u0C60'..'\u0C61'
	//    | '\u0C85'..'\u0C8C'
	//    | '\u0C8E'..'\u0C90'
	//    | '\u0C92'..'\u0CA8'
	//    | '\u0CAA'..'\u0CB3'
	//    | '\u0CB5'..'\u0CB9'
	//    | '\u0CBD'
	//    | '\u0CDE'
	//    | '\u0CE0'..'\u0CE1'
	//    | '\u0D05'..'\u0D0C'
	//    | '\u0D0E'..'\u0D10'
	//    | '\u0D12'..'\u0D28'
	//    | '\u0D2A'..'\u0D39'
	//    | '\u0D60'..'\u0D61'
	//    | '\u0D85'..'\u0D96'
	//    | '\u0D9A'..'\u0DB1'
	//    | '\u0DB3'..'\u0DBB'
	//    | '\u0DBD'
	//    | '\u0DC0'..'\u0DC6'
	//    | '\u0E01'..'\u0E30'
	//    | '\u0E32'..'\u0E33'
	//    | '\u0E3F'..'\u0E46'
	//    | '\u0E81'..'\u0E82'
	//    | '\u0E84'
	//    | '\u0E87'..'\u0E88'
	//    | '\u0E8A'
	//    | '\u0E8D'
	//    | '\u0E94'..'\u0E97'
	//    | '\u0E99'..'\u0E9F'
	//    | '\u0EA1'..'\u0EA3'
	//    | '\u0EA5'
	//    | '\u0EA7'
	//    | '\u0EAA'..'\u0EAB'
	//    | '\u0EAD'..'\u0EB0'
	//    | '\u0EB2'..'\u0EB3'
	//    | '\u0EBD'
	//    | '\u0EC0'..'\u0EC4'
	//    | '\u0EC6'
	//    | '\u0EDC'..'\u0EDD'
	//    | '\u0F00'
	//    | '\u0F40'..'\u0F47'
	//    | '\u0F49'..'\u0F6A'
	//    | '\u0F88'..'\u0F8B'
	//    | '\u1000'..'\u1021'
	//    | '\u1023'..'\u1027'
	//    | '\u1029'..'\u102A'
	//    | '\u1050'..'\u1055'
	//    | '\u10A0'..'\u10C5'
	//    | '\u10D0'..'\u10F8'
	//    | '\u1100'..'\u1159'
	//    | '\u115F'..'\u11A2'
	//    | '\u11A8'..'\u11F9'
	//    | '\u1200'..'\u1206'
	//    | '\u1208'..'\u1246'
	//    | '\u1248'
	//    | '\u124A'..'\u124D'
	//    | '\u1250'..'\u1256'
	//    | '\u1258'
	//    | '\u125A'..'\u125D'
	//    | '\u1260'..'\u1286'
	//    | '\u1288'
	//    | '\u128A'..'\u128D'
	//    | '\u1290'..'\u12AE'
	//    | '\u12B0'
	//    | '\u12B2'..'\u12B5'
	//    | '\u12B8'..'\u12BE'
	//    | '\u12C0'
	//    | '\u12C2'..'\u12C5'
	//    | '\u12C8'..'\u12CE'
	//    | '\u12D0'..'\u12D6'
	//    | '\u12D8'..'\u12EE'
	//    | '\u12F0'..'\u130E'
	//    | '\u1310'
	//    | '\u1312'..'\u1315'
	//    | '\u1318'..'\u131E'
	//    | '\u1320'..'\u1346'
	//    | '\u1348'..'\u135A'
	//    | '\u13A0'..'\u13F4'
	//    | '\u1401'..'\u166C'
	//    | '\u166F'..'\u1676'
	//    | '\u1681'..'\u169A'
	//    | '\u16A0'..'\u16EA'
	//    | '\u16EE'..'\u16F0'
	//    | '\u1700'..'\u170C'
	//    | '\u170E'..'\u1711'
	//    | '\u1720'..'\u1731'
	//    | '\u1740'..'\u1751'
	//    | '\u1760'..'\u176C'
	//    | '\u176E'..'\u1770'
	//    | '\u1780'..'\u17B3'
	//    | '\u17D7'
	//    | '\u17DB'..'\u17DC'
	//    | '\u1820'..'\u1877'
	//    | '\u1880'..'\u18A8'
	//    | '\u1900'..'\u191C'
	//    | '\u1950'..'\u196D'
	//    | '\u1970'..'\u1974'
	//    | '\u1D00'..'\u1D6B'
	//    | '\u1E00'..'\u1E9B'
	//    | '\u1EA0'..'\u1EF9'
	//    | '\u1F00'..'\u1F15'
	//    | '\u1F18'..'\u1F1D'
	//    | '\u1F20'..'\u1F45'
	//    | '\u1F48'..'\u1F4D'
	//    | '\u1F50'..'\u1F57'
	//    | '\u1F59'
	//    | '\u1F5B'
	//    | '\u1F5D'
	//    | '\u1F5F'..'\u1F7D'
	//    | '\u1F80'..'\u1FB4'
	//    | '\u1FB6'..'\u1FBC'
	//    | '\u1FBE'
	//    | '\u1FC2'..'\u1FC4'
	//    | '\u1FC6'..'\u1FCC'
	//    | '\u1FD0'..'\u1FD3'
	//    | '\u1FD6'..'\u1FDB'
	//    | '\u1FE0'..'\u1FEC'
	//    | '\u1FF2'..'\u1FF4'
	//    | '\u1FF6'..'\u1FFC'
	//    | '\u203F'..'\u2040'
	//    | '\u2054'
	//    | '\u2071'
	//    | '\u207F'
	//    | '\u20A0'..'\u20B1'
	//    | '\u2102'
	//    | '\u2107'
	//    | '\u210A'..'\u2113'
	//    | '\u2115'
	//    | '\u2119'..'\u211D'
	//    | '\u2124'
	//    | '\u2126'
	//    | '\u2128'
	//    | '\u212A'..'\u212D'
	//    | '\u212F'..'\u2131'
	//    | '\u2133'..'\u2139'
	//    | '\u213D'..'\u213F'
	//    | '\u2145'..'\u2149'
	//    | '\u2160'..'\u2183'
	//    | '\u3005'..'\u3007'
	//    | '\u3021'..'\u3029'
	//    | '\u3031'..'\u3035'
	//    | '\u3038'..'\u303C'
	//    | '\u3041'..'\u3096'
	//    | '\u309D'..'\u309F'
	//    | '\u30A1'..'\u30FF'
	//    | '\u3105'..'\u312C'
	//    | '\u3131'..'\u318E'
	//    | '\u31A0'..'\u31B7'
	//    | '\u31F0'..'\u31FF'
	//    | '\u3400'..'\u4DB5'
	//    | '\u4E00'..'\u9FA5'
	//    | '\uA000'..'\uA48C'
	//    | '\uAC00'..'\uD7A3'
	//    | '\uF900'..'\uFA2D'
	//    | '\uFA30'..'\uFA6A'
	//    | '\uFB00'..'\uFB06'
	//    | '\uFB13'..'\uFB17'
	//    | '\uFB1D'
	//    | '\uFB1F'..'\uFB28'
	//    | '\uFB2A'..'\uFB36'
	//    | '\uFB38'..'\uFB3C'
	//    | '\uFB3E'
	//    | '\uFB40'..'\uFB41'
	//    | '\uFB43'..'\uFB44'
	//    | '\uFB46'..'\uFBB1'
	//    | '\uFBD3'..'\uFD3D'
	//    | '\uFD50'..'\uFD8F'
	//    | '\uFD92'..'\uFDC7'
	//    | '\uFDF0'..'\uFDFC'
	//    | '\uFE33'..'\uFE34'
	//    | '\uFE4D'..'\uFE4F'
	//    | '\uFE69'
	//    | '\uFE70'..'\uFE74'
	//    | '\uFE76'..'\uFEFC'
	//    | '\uFF04'
	//    | '\uFF21'..'\uFF3A'
	//    | '\uFF3F'
	//    | '\uFF41'..'\uFF5A'
	//    | '\uFF65'..'\uFFBE'
	//    | '\uFFC2'..'\uFFC7'
	//    | '\uFFCA'..'\uFFCF'
	//    | '\uFFD2'..'\uFFD7'
	//    | '\uFFDA'..'\uFFDC'
	//    | '\uFFE0'..'\uFFE1'
	//    | '\uFFE5'..'\uFFE6'
	//;
	public TerminalRule getIDENTIFIER_STARTRule() {
		return tIDENTIFIER_START;
	}
	
	//terminal fragment IDENTIFIER_PART:
	//    IDENTIFIER_START | IDENTIFIER_PART_IMPL
	//;
	public TerminalRule getIDENTIFIER_PARTRule() {
		return tIDENTIFIER_PART;
	}
	
	//terminal fragment IDENTIFIER_PART_IMPL:
	//      '\u0000'..'\u0008'
	//    | '\u000E'..'\u001B'
	//    | '\u0030'..'\u0039'
	//    | '\u007F'..'\u009F'
	//    | '\u00AD'
	//    | '\u0300'..'\u0357'
	//    | '\u035D'..'\u036F'
	//    | '\u0483'..'\u0486'
	//    | '\u0591'..'\u05A1'
	//    | '\u05A3'..'\u05B9'
	//    | '\u05BB'..'\u05BD'
	//    | '\u05BF'
	//    | '\u05C1'..'\u05C2'
	//    | '\u05C4'
	//    | '\u0600'..'\u0603'
	//    | '\u0610'..'\u0615'
	//    | '\u064B'..'\u0658'
	//    | '\u0660'..'\u0669'
	//    | '\u0670'
	//    | '\u06D6'..'\u06DD'
	//    | '\u06DF'..'\u06E4'
	//    | '\u06E7'..'\u06E8'
	//    | '\u06EA'..'\u06ED'
	//    | '\u06F0'..'\u06F9'
	//    | '\u070F'
	//    | '\u0711'
	//    | '\u0730'..'\u074A'
	//    | '\u07A6'..'\u07B0'
	//    | '\u0901'..'\u0903'
	//    | '\u093C'
	//    | '\u093E'..'\u094D'
	//    | '\u0951'..'\u0954'
	//    | '\u0962'..'\u0963'
	//    | '\u0966'..'\u096F'
	//    | '\u0981'..'\u0983'
	//    | '\u09BC'
	//    | '\u09BE'..'\u09C4'
	//    | '\u09C7'..'\u09C8'
	//    | '\u09CB'..'\u09CD'
	//    | '\u09D7'
	//    | '\u09E2'..'\u09E3'
	//    | '\u09E6'..'\u09EF'
	//    | '\u0A01'..'\u0A03'
	//    | '\u0A3C'
	//    | '\u0A3E'..'\u0A42'
	//    | '\u0A47'..'\u0A48'
	//    | '\u0A4B'..'\u0A4D'
	//    | '\u0A66'..'\u0A71'
	//    | '\u0A81'..'\u0A83'
	//    | '\u0ABC'
	//    | '\u0ABE'..'\u0AC5'
	//    | '\u0AC7'..'\u0AC9'
	//    | '\u0ACB'..'\u0ACD'
	//    | '\u0AE2'..'\u0AE3'
	//    | '\u0AE6'..'\u0AEF'
	//    | '\u0B01'..'\u0B03'
	//    | '\u0B3C'
	//    | '\u0B3E'..'\u0B43'
	//    | '\u0B47'..'\u0B48'
	//    | '\u0B4B'..'\u0B4D'
	//    | '\u0B56'..'\u0B57'
	//    | '\u0B66'..'\u0B6F'
	//    | '\u0B82'
	//    | '\u0BBE'..'\u0BC2'
	//    | '\u0BC6'..'\u0BC8'
	//    | '\u0BCA'..'\u0BCD'
	//    | '\u0BD7'
	//    | '\u0BE7'..'\u0BEF'
	//    | '\u0C01'..'\u0C03'
	//    | '\u0C3E'..'\u0C44'
	//    | '\u0C46'..'\u0C48'
	//    | '\u0C4A'..'\u0C4D'
	//    | '\u0C55'..'\u0C56'
	//    | '\u0C66'..'\u0C6F'
	//    | '\u0C82'..'\u0C83'
	//    | '\u0CBC'
	//    | '\u0CBE'..'\u0CC4'
	//    | '\u0CC6'..'\u0CC8'
	//    | '\u0CCA'..'\u0CCD'
	//    | '\u0CD5'..'\u0CD6'
	//    | '\u0CE6'..'\u0CEF'
	//    | '\u0D02'..'\u0D03'
	//    | '\u0D3E'..'\u0D43'
	//    | '\u0D46'..'\u0D48'
	//    | '\u0D4A'..'\u0D4D'
	//    | '\u0D57'
	//    | '\u0D66'..'\u0D6F'
	//    | '\u0D82'..'\u0D83'
	//    | '\u0DCA'
	//    | '\u0DCF'..'\u0DD4'
	//    | '\u0DD6'
	//    | '\u0DD8'..'\u0DDF'
	//    | '\u0DF2'..'\u0DF3'
	//    | '\u0E31'
	//    | '\u0E34'..'\u0E3A'
	//    | '\u0E47'..'\u0E4E'
	//    | '\u0E50'..'\u0E59'
	//    | '\u0EB1'
	//    | '\u0EB4'..'\u0EB9'
	//    | '\u0EBB'..'\u0EBC'
	//    | '\u0EC8'..'\u0ECD'
	//    | '\u0ED0'..'\u0ED9'
	//    | '\u0F18'..'\u0F19'
	//    | '\u0F20'..'\u0F29'
	//    | '\u0F35'
	//    | '\u0F37'
	//    | '\u0F39'
	//    | '\u0F3E'..'\u0F3F'
	//    | '\u0F71'..'\u0F84'
	//    | '\u0F86'..'\u0F87'
	//    | '\u0F90'..'\u0F97'
	//    | '\u0F99'..'\u0FBC'
	//    | '\u0FC6'
	//    | '\u102C'..'\u1032'
	//    | '\u1036'..'\u1039'
	//    | '\u1040'..'\u1049'
	//    | '\u1056'..'\u1059'
	//    | '\u1369'..'\u1371'
	//    | '\u1712'..'\u1714'
	//    | '\u1732'..'\u1734'
	//    | '\u1752'..'\u1753'
	//    | '\u1772'..'\u1773'
	//    | '\u17B4'..'\u17D3'
	//    | '\u17DD'
	//    | '\u17E0'..'\u17E9'
	//    | '\u180B'..'\u180D'
	//    | '\u1810'..'\u1819'
	//    | '\u18A9'
	//    | '\u1920'..'\u192B'
	//    | '\u1930'..'\u193B'
	//    | '\u1946'..'\u194F'
	//    | '\u200C'..'\u200F'
	//    | '\u202A'..'\u202E'
	//    | '\u2060'..'\u2063'
	//    | '\u206A'..'\u206F'
	//    | '\u20D0'..'\u20DC'
	//    | '\u20E1'
	//    | '\u20E5'..'\u20EA'
	//    | '\u302A'..'\u302F'
	//    | '\u3099'..'\u309A'
	//    | '\uFB1E'
	//    | '\uFE00'..'\uFE0F'
	//    | '\uFE20'..'\uFE23'
	//    | '\uFEFF'
	//    | '\uFF10'..'\uFF19'
	//    | '\uFFF9'..'\uFFFB'
	//;
	public TerminalRule getIDENTIFIER_PART_IMPLRule() {
		return tIDENTIFIER_PART_IMPL;
	}
	
	//XAnnotation :
	//    {XAnnotation}
	//    '@' annotationType=[types::JvmAnnotationType | QualifiedName] (=>'('
	//        (
	//            elementValuePairs+=XAnnotationElementValuePair (',' elementValuePairs+=XAnnotationElementValuePair)*
	//        |    value=XAnnotationElementValueOrCommaList
	//        )?
	//    ')')?
	//;
	public XbaseWithAnnotationsGrammarAccess.XAnnotationElements getXAnnotationAccess() {
		return gaXbaseWithAnnotations.getXAnnotationAccess();
	}
	
	public ParserRule getXAnnotationRule() {
		return getXAnnotationAccess().getRule();
	}
	
	//XAnnotationElementValuePair :
	//    =>(element=[types::JvmOperation|ValidID] '=') value=XAnnotationElementValue
	//;
	public XbaseWithAnnotationsGrammarAccess.XAnnotationElementValuePairElements getXAnnotationElementValuePairAccess() {
		return gaXbaseWithAnnotations.getXAnnotationElementValuePairAccess();
	}
	
	public ParserRule getXAnnotationElementValuePairRule() {
		return getXAnnotationElementValuePairAccess().getRule();
	}
	
	//XAnnotationElementValueOrCommaList returns xbase::XExpression:
	//      =>({xbase::XListLiteral} '#' '[') (elements+=XAnnotationOrExpression (',' elements+=XAnnotationOrExpression )*)? ']'
	//    | XAnnotationOrExpression ({xbase::XListLiteral.elements+=current} (',' elements+=XAnnotationOrExpression )+)?
	//;
	public XbaseWithAnnotationsGrammarAccess.XAnnotationElementValueOrCommaListElements getXAnnotationElementValueOrCommaListAccess() {
		return gaXbaseWithAnnotations.getXAnnotationElementValueOrCommaListAccess();
	}
	
	public ParserRule getXAnnotationElementValueOrCommaListRule() {
		return getXAnnotationElementValueOrCommaListAccess().getRule();
	}
	
	//XAnnotationElementValue returns xbase::XExpression :
	//      =>({xbase::XListLiteral} '#' '[') (elements+=XAnnotationOrExpression (',' elements+=XAnnotationOrExpression )*)? ']'
	//    | XAnnotationOrExpression
	//;
	public XbaseWithAnnotationsGrammarAccess.XAnnotationElementValueElements getXAnnotationElementValueAccess() {
		return gaXbaseWithAnnotations.getXAnnotationElementValueAccess();
	}
	
	public ParserRule getXAnnotationElementValueRule() {
		return getXAnnotationElementValueAccess().getRule();
	}
	
	//XAnnotationOrExpression returns xbase::XExpression:
	//    XAnnotation |
	//    XExpression
	//;
	public XbaseWithAnnotationsGrammarAccess.XAnnotationOrExpressionElements getXAnnotationOrExpressionAccess() {
		return gaXbaseWithAnnotations.getXAnnotationOrExpressionAccess();
	}
	
	public ParserRule getXAnnotationOrExpressionRule() {
		return getXAnnotationOrExpressionAccess().getRule();
	}
	
	//XExpression returns XExpression :
	//    XAssignment;
	public XbaseGrammarAccess.XExpressionElements getXExpressionAccess() {
		return gaXbase.getXExpressionAccess();
	}
	
	public ParserRule getXExpressionRule() {
		return getXExpressionAccess().getRule();
	}
	
	//OpSingleAssign:
	//    '='
	//;
	public XbaseGrammarAccess.OpSingleAssignElements getOpSingleAssignAccess() {
		return gaXbase.getOpSingleAssignAccess();
	}
	
	public ParserRule getOpSingleAssignRule() {
		return getOpSingleAssignAccess().getRule();
	}
	
	//OpMultiAssign:
	//    '+=' | '-=' | '*=' | '/=' | '%=' |
	//    '<' '<' '=' |
	//    '>' '>'? '>=';
	public XbaseGrammarAccess.OpMultiAssignElements getOpMultiAssignAccess() {
		return gaXbase.getOpMultiAssignAccess();
	}
	
	public ParserRule getOpMultiAssignRule() {
		return getOpMultiAssignAccess().getRule();
	}
	
	//XOrExpression returns XExpression:
	//    XAndExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpOr]) rightOperand=XAndExpression)*;
	public XbaseGrammarAccess.XOrExpressionElements getXOrExpressionAccess() {
		return gaXbase.getXOrExpressionAccess();
	}
	
	public ParserRule getXOrExpressionRule() {
		return getXOrExpressionAccess().getRule();
	}
	
	//OpOr:
	//    '||';
	public XbaseGrammarAccess.OpOrElements getOpOrAccess() {
		return gaXbase.getOpOrAccess();
	}
	
	public ParserRule getOpOrRule() {
		return getOpOrAccess().getRule();
	}
	
	//XAndExpression returns XExpression:
	//    XEqualityExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpAnd]) rightOperand=XEqualityExpression)*;
	public XbaseGrammarAccess.XAndExpressionElements getXAndExpressionAccess() {
		return gaXbase.getXAndExpressionAccess();
	}
	
	public ParserRule getXAndExpressionRule() {
		return getXAndExpressionAccess().getRule();
	}
	
	//OpAnd:
	//    '&&';
	public XbaseGrammarAccess.OpAndElements getOpAndAccess() {
		return gaXbase.getOpAndAccess();
	}
	
	public ParserRule getOpAndRule() {
		return getOpAndAccess().getRule();
	}
	
	//XEqualityExpression returns XExpression:
	//    XRelationalExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpEquality])
	//    rightOperand=XRelationalExpression)*;
	public XbaseGrammarAccess.XEqualityExpressionElements getXEqualityExpressionAccess() {
		return gaXbase.getXEqualityExpressionAccess();
	}
	
	public ParserRule getXEqualityExpressionRule() {
		return getXEqualityExpressionAccess().getRule();
	}
	
	//OpEquality:
	//    '==' | '!=' | '===' | '!==';
	public XbaseGrammarAccess.OpEqualityElements getOpEqualityAccess() {
		return gaXbase.getOpEqualityAccess();
	}
	
	public ParserRule getOpEqualityRule() {
		return getOpEqualityAccess().getRule();
	}
	
	//XRelationalExpression returns XExpression:
	//    XOtherOperatorExpression
	//    (=>({XInstanceOfExpression.expression=current} 'instanceof') type=JvmTypeReference |
	//     =>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpCompare]) rightOperand=XOtherOperatorExpression)*;
	public XbaseGrammarAccess.XRelationalExpressionElements getXRelationalExpressionAccess() {
		return gaXbase.getXRelationalExpressionAccess();
	}
	
	public ParserRule getXRelationalExpressionRule() {
		return getXRelationalExpressionAccess().getRule();
	}
	
	//OpCompare:
	//    '>=' | '<' '=' | '>' | '<' ;
	public XbaseGrammarAccess.OpCompareElements getOpCompareAccess() {
		return gaXbase.getOpCompareAccess();
	}
	
	public ParserRule getOpCompareRule() {
		return getOpCompareAccess().getRule();
	}
	
	//XOtherOperatorExpression returns XExpression:
	//    XAdditiveExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpOther])
	//    rightOperand=XAdditiveExpression)*;
	public XbaseGrammarAccess.XOtherOperatorExpressionElements getXOtherOperatorExpressionAccess() {
		return gaXbase.getXOtherOperatorExpressionAccess();
	}
	
	public ParserRule getXOtherOperatorExpressionRule() {
		return getXOtherOperatorExpressionAccess().getRule();
	}
	
	//OpOther:
	//      '->'
	//    | '..<'
	//    | '>' '..'
	//    | '..'
	//    | '=>'
	//    | '>' (=>('>' '>') | '>')
	//    | '<' (=>('<' '<') | '<' | '=>')
	//    | '<>'
	//    | '?:';
	public XbaseGrammarAccess.OpOtherElements getOpOtherAccess() {
		return gaXbase.getOpOtherAccess();
	}
	
	public ParserRule getOpOtherRule() {
		return getOpOtherAccess().getRule();
	}
	
	//XAdditiveExpression returns XExpression:
	//    XMultiplicativeExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpAdd])
	//    rightOperand=XMultiplicativeExpression)*;
	public XbaseGrammarAccess.XAdditiveExpressionElements getXAdditiveExpressionAccess() {
		return gaXbase.getXAdditiveExpressionAccess();
	}
	
	public ParserRule getXAdditiveExpressionRule() {
		return getXAdditiveExpressionAccess().getRule();
	}
	
	//OpAdd:
	//    '+' | '-';
	public XbaseGrammarAccess.OpAddElements getOpAddAccess() {
		return gaXbase.getOpAddAccess();
	}
	
	public ParserRule getOpAddRule() {
		return getOpAddAccess().getRule();
	}
	
	//XMultiplicativeExpression returns XExpression:
	//    XUnaryOperation (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMulti]) rightOperand=XUnaryOperation)*;
	public XbaseGrammarAccess.XMultiplicativeExpressionElements getXMultiplicativeExpressionAccess() {
		return gaXbase.getXMultiplicativeExpressionAccess();
	}
	
	public ParserRule getXMultiplicativeExpressionRule() {
		return getXMultiplicativeExpressionAccess().getRule();
	}
	
	//OpMulti:
	//    '*' | '**' | '/' | '%';
	public XbaseGrammarAccess.OpMultiElements getOpMultiAccess() {
		return gaXbase.getOpMultiAccess();
	}
	
	public ParserRule getOpMultiRule() {
		return getOpMultiAccess().getRule();
	}
	
	//XUnaryOperation returns XExpression:
	//    {XUnaryOperation} feature=[types::JvmIdentifiableElement|OpUnary] operand=XUnaryOperation
	//    | XCastedExpression;
	public XbaseGrammarAccess.XUnaryOperationElements getXUnaryOperationAccess() {
		return gaXbase.getXUnaryOperationAccess();
	}
	
	public ParserRule getXUnaryOperationRule() {
		return getXUnaryOperationAccess().getRule();
	}
	
	//OpUnary:
	//    "!" | "-" | "+";
	public XbaseGrammarAccess.OpUnaryElements getOpUnaryAccess() {
		return gaXbase.getOpUnaryAccess();
	}
	
	public ParserRule getOpUnaryRule() {
		return getOpUnaryAccess().getRule();
	}
	
	//XCastedExpression returns XExpression:
	//    XPostfixOperation (=>({XCastedExpression.target=current} 'as') type=JvmTypeReference)*
	//;
	public XbaseGrammarAccess.XCastedExpressionElements getXCastedExpressionAccess() {
		return gaXbase.getXCastedExpressionAccess();
	}
	
	public ParserRule getXCastedExpressionRule() {
		return getXCastedExpressionAccess().getRule();
	}
	
	//XPostfixOperation returns XExpression:
	//    XMemberFeatureCall =>({XPostfixOperation.operand=current} feature=[types::JvmIdentifiableElement|OpPostfix])?
	//;
	public XbaseGrammarAccess.XPostfixOperationElements getXPostfixOperationAccess() {
		return gaXbase.getXPostfixOperationAccess();
	}
	
	public ParserRule getXPostfixOperationRule() {
		return getXPostfixOperationAccess().getRule();
	}
	
	//OpPostfix:
	//    "++" | "--"
	//;
	public XbaseGrammarAccess.OpPostfixElements getOpPostfixAccess() {
		return gaXbase.getOpPostfixAccess();
	}
	
	public ParserRule getOpPostfixRule() {
		return getOpPostfixAccess().getRule();
	}
	
	//XMemberFeatureCall returns XExpression:
	//    XPrimaryExpression
	//    (=>({XAssignment.assignable=current} ('.'|explicitStatic?="::") feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign) value=XAssignment
	//    |=>({XMemberFeatureCall.memberCallTarget=current} ("."|nullSafe?="?."|explicitStatic?="::"))
	//        ('<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
	//        feature=[types::JvmIdentifiableElement|IdOrSuper] (
	//            =>explicitOperationCall?='('
	//                (
	//                    memberCallArguments+=XShortClosure
	//                  | memberCallArguments+=XExpression (',' memberCallArguments+=XExpression)*
	//                )?
	//            ')')?
	//            memberCallArguments+=XClosure?
	//        )*;
	public XbaseGrammarAccess.XMemberFeatureCallElements getXMemberFeatureCallAccess() {
		return gaXbase.getXMemberFeatureCallAccess();
	}
	
	public ParserRule getXMemberFeatureCallRule() {
		return getXMemberFeatureCallAccess().getRule();
	}
	
	//XPrimaryExpression returns XExpression:
	//    XConstructorCall |
	//    XBlockExpression |
	//    XSwitchExpression |
	//    XSynchronizedExpression |
	//    XFeatureCall |
	//    XLiteral |
	//    XIfExpression |
	//    XForLoopExpression |
	//    XBasicForLoopExpression |
	//    XWhileExpression |
	//    XDoWhileExpression |
	//    XThrowExpression |
	//    XReturnExpression |
	//    XTryCatchFinallyExpression |
	//    XParenthesizedExpression;
	public XbaseGrammarAccess.XPrimaryExpressionElements getXPrimaryExpressionAccess() {
		return gaXbase.getXPrimaryExpressionAccess();
	}
	
	public ParserRule getXPrimaryExpressionRule() {
		return getXPrimaryExpressionAccess().getRule();
	}
	
	//XLiteral returns XExpression:
	//    XCollectionLiteral |
	//    XClosure |
	//    XBooleanLiteral |
	//    XNumberLiteral |
	//    XNullLiteral |
	//    XStringLiteral |
	//    XTypeLiteral
	//;
	public XbaseGrammarAccess.XLiteralElements getXLiteralAccess() {
		return gaXbase.getXLiteralAccess();
	}
	
	public ParserRule getXLiteralRule() {
		return getXLiteralAccess().getRule();
	}
	
	//XCollectionLiteral:
	//    XSetLiteral | XListLiteral
	//;
	public XbaseGrammarAccess.XCollectionLiteralElements getXCollectionLiteralAccess() {
		return gaXbase.getXCollectionLiteralAccess();
	}
	
	public ParserRule getXCollectionLiteralRule() {
		return getXCollectionLiteralAccess().getRule();
	}
	
	//XSetLiteral:
	//    {XSetLiteral} '#' '{' (elements+=XExpression (',' elements+=XExpression )*)? '}'
	//;
	public XbaseGrammarAccess.XSetLiteralElements getXSetLiteralAccess() {
		return gaXbase.getXSetLiteralAccess();
	}
	
	public ParserRule getXSetLiteralRule() {
		return getXSetLiteralAccess().getRule();
	}
	
	//XListLiteral:
	//    {XListLiteral} '#' '[' (elements+=XExpression (',' elements+=XExpression )*)? ']'
	//;
	public XbaseGrammarAccess.XListLiteralElements getXListLiteralAccess() {
		return gaXbase.getXListLiteralAccess();
	}
	
	public ParserRule getXListLiteralRule() {
		return getXListLiteralAccess().getRule();
	}
	
	//XClosure returns XExpression:
	//    =>({XClosure}
	//    '[')
	//        =>((declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)? explicitSyntax?='|')?
	//        expression=XExpressionInClosure
	//    ']';
	public XbaseGrammarAccess.XClosureElements getXClosureAccess() {
		return gaXbase.getXClosureAccess();
	}
	
	public ParserRule getXClosureRule() {
		return getXClosureAccess().getRule();
	}
	
	//XExpressionInClosure returns XExpression:
	//    {XBlockExpression}
	//    (expressions+=XExpressionOrVarDeclaration ';'?)*
	//;
	public XbaseGrammarAccess.XExpressionInClosureElements getXExpressionInClosureAccess() {
		return gaXbase.getXExpressionInClosureAccess();
	}
	
	public ParserRule getXExpressionInClosureRule() {
		return getXExpressionInClosureAccess().getRule();
	}
	
	//XShortClosure returns XExpression:
	//    =>({XClosure} (declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)? explicitSyntax?='|') expression=XExpression;
	public XbaseGrammarAccess.XShortClosureElements getXShortClosureAccess() {
		return gaXbase.getXShortClosureAccess();
	}
	
	public ParserRule getXShortClosureRule() {
		return getXShortClosureAccess().getRule();
	}
	
	//XParenthesizedExpression returns XExpression:
	//    '(' XExpression ')';
	public XbaseGrammarAccess.XParenthesizedExpressionElements getXParenthesizedExpressionAccess() {
		return gaXbase.getXParenthesizedExpressionAccess();
	}
	
	public ParserRule getXParenthesizedExpressionRule() {
		return getXParenthesizedExpressionAccess().getRule();
	}
	
	//XIfExpression returns XExpression:
	//    {XIfExpression}
	//    'if' '(' if=XExpression ')'
	//    then=XExpression
	//    (=>'else' else=XExpression)?;
	public XbaseGrammarAccess.XIfExpressionElements getXIfExpressionAccess() {
		return gaXbase.getXIfExpressionAccess();
	}
	
	public ParserRule getXIfExpressionRule() {
		return getXIfExpressionAccess().getRule();
	}
	
	//XForLoopExpression returns XExpression:
	//    =>({XForLoopExpression}
	//    'for' '(' declaredParam=JvmFormalParameter ':') forExpression=XExpression ')'
	//        eachExpression=XExpression;
	public XbaseGrammarAccess.XForLoopExpressionElements getXForLoopExpressionAccess() {
		return gaXbase.getXForLoopExpressionAccess();
	}
	
	public ParserRule getXForLoopExpressionRule() {
		return getXForLoopExpressionAccess().getRule();
	}
	
	//XBasicForLoopExpression returns XExpression:
	//    {XBasicForLoopExpression}
	//    'for' '('(initExpressions+=XExpressionOrVarDeclaration (',' initExpressions+=XExpressionOrVarDeclaration)*)? ';'
	//        expression=XExpression? ';'
	//        (updateExpressions+=XExpression (',' updateExpressions+=XExpression)*)? ')'
	//        eachExpression=XExpression;
	public XbaseGrammarAccess.XBasicForLoopExpressionElements getXBasicForLoopExpressionAccess() {
		return gaXbase.getXBasicForLoopExpressionAccess();
	}
	
	public ParserRule getXBasicForLoopExpressionRule() {
		return getXBasicForLoopExpressionAccess().getRule();
	}
	
	//XWhileExpression returns XExpression:
	//    {XWhileExpression}
	//    'while' '(' predicate=XExpression ')'
	//        body=XExpression;
	public XbaseGrammarAccess.XWhileExpressionElements getXWhileExpressionAccess() {
		return gaXbase.getXWhileExpressionAccess();
	}
	
	public ParserRule getXWhileExpressionRule() {
		return getXWhileExpressionAccess().getRule();
	}
	
	//XDoWhileExpression returns XExpression:
	//    {XDoWhileExpression}
	//    'do'
	//        body=XExpression
	//    'while' '(' predicate=XExpression ')';
	public XbaseGrammarAccess.XDoWhileExpressionElements getXDoWhileExpressionAccess() {
		return gaXbase.getXDoWhileExpressionAccess();
	}
	
	public ParserRule getXDoWhileExpressionRule() {
		return getXDoWhileExpressionAccess().getRule();
	}
	
	//XBlockExpression returns XExpression:
	//    {XBlockExpression}
	//    '{'
	//        (expressions+=XExpressionOrVarDeclaration ';'?)*
	//    '}';
	public XbaseGrammarAccess.XBlockExpressionElements getXBlockExpressionAccess() {
		return gaXbase.getXBlockExpressionAccess();
	}
	
	public ParserRule getXBlockExpressionRule() {
		return getXBlockExpressionAccess().getRule();
	}
	
	//XExpressionOrVarDeclaration returns XExpression:
	//    XVariableDeclaration | XExpression;
	public XbaseGrammarAccess.XExpressionOrVarDeclarationElements getXExpressionOrVarDeclarationAccess() {
		return gaXbase.getXExpressionOrVarDeclarationAccess();
	}
	
	public ParserRule getXExpressionOrVarDeclarationRule() {
		return getXExpressionOrVarDeclarationAccess().getRule();
	}
	
	//XFeatureCall returns XExpression:
	//    {XFeatureCall}
	//    ('<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
	//    feature=[types::JvmIdentifiableElement|IdOrSuper]
	//    (=>explicitOperationCall?='('
	//        (
	//            featureCallArguments+=XShortClosure
	//          | featureCallArguments+=XExpression (',' featureCallArguments+=XExpression)*
	//        )?
	//    ')')?
	//    featureCallArguments+=XClosure?;
	public XbaseGrammarAccess.XFeatureCallElements getXFeatureCallAccess() {
		return gaXbase.getXFeatureCallAccess();
	}
	
	public ParserRule getXFeatureCallRule() {
		return getXFeatureCallAccess().getRule();
	}
	
	//IdOrSuper :
	//    FeatureCallID | 'super'
	//;
	public XbaseGrammarAccess.IdOrSuperElements getIdOrSuperAccess() {
		return gaXbase.getIdOrSuperAccess();
	}
	
	public ParserRule getIdOrSuperRule() {
		return getIdOrSuperAccess().getRule();
	}
	
	//XBooleanLiteral returns XExpression :
	//    {XBooleanLiteral} ('false' | isTrue?='true');
	public XbaseGrammarAccess.XBooleanLiteralElements getXBooleanLiteralAccess() {
		return gaXbase.getXBooleanLiteralAccess();
	}
	
	public ParserRule getXBooleanLiteralRule() {
		return getXBooleanLiteralAccess().getRule();
	}
	
	//XNullLiteral returns XExpression :
	//    {XNullLiteral} 'null';
	public XbaseGrammarAccess.XNullLiteralElements getXNullLiteralAccess() {
		return gaXbase.getXNullLiteralAccess();
	}
	
	public ParserRule getXNullLiteralRule() {
		return getXNullLiteralAccess().getRule();
	}
	
	//XNumberLiteral returns XExpression :
	//    {XNumberLiteral} value=Number;
	public XbaseGrammarAccess.XNumberLiteralElements getXNumberLiteralAccess() {
		return gaXbase.getXNumberLiteralAccess();
	}
	
	public ParserRule getXNumberLiteralRule() {
		return getXNumberLiteralAccess().getRule();
	}
	
	//XTypeLiteral returns XExpression :
	//    {XTypeLiteral} 'typeof' '(' type=[types::JvmType|QualifiedName] (arrayDimensions+=ArrayBrackets)* ')'
	//;
	public XbaseGrammarAccess.XTypeLiteralElements getXTypeLiteralAccess() {
		return gaXbase.getXTypeLiteralAccess();
	}
	
	public ParserRule getXTypeLiteralRule() {
		return getXTypeLiteralAccess().getRule();
	}
	
	//XThrowExpression returns XExpression :
	//    {XThrowExpression} 'throw' expression=XExpression;
	public XbaseGrammarAccess.XThrowExpressionElements getXThrowExpressionAccess() {
		return gaXbase.getXThrowExpressionAccess();
	}
	
	public ParserRule getXThrowExpressionRule() {
		return getXThrowExpressionAccess().getRule();
	}
	
	//XReturnExpression returns XExpression :
	//    {XReturnExpression} 'return' (->expression=XExpression)?;
	public XbaseGrammarAccess.XReturnExpressionElements getXReturnExpressionAccess() {
		return gaXbase.getXReturnExpressionAccess();
	}
	
	public ParserRule getXReturnExpressionRule() {
		return getXReturnExpressionAccess().getRule();
	}
	
	//XSynchronizedExpression returns XExpression:
	//    =>({XSynchronizedExpression}
	//    'synchronized' '(') param=XExpression ')' expression=XExpression;
	public XbaseGrammarAccess.XSynchronizedExpressionElements getXSynchronizedExpressionAccess() {
		return gaXbase.getXSynchronizedExpressionAccess();
	}
	
	public ParserRule getXSynchronizedExpressionRule() {
		return getXSynchronizedExpressionAccess().getRule();
	}
	
	//XCatchClause :
	//    =>'catch' '(' declaredParam=FullJvmFormalParameter ')' expression=XExpression;
	public XbaseGrammarAccess.XCatchClauseElements getXCatchClauseAccess() {
		return gaXbase.getXCatchClauseAccess();
	}
	
	public ParserRule getXCatchClauseRule() {
		return getXCatchClauseAccess().getRule();
	}
	
	//@Override
	//QualifiedName:
	//    ValidID (=>'.' ValidID)*;
	public XbaseGrammarAccess.QualifiedNameElements getQualifiedNameAccess() {
		return gaXbase.getQualifiedNameAccess();
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}
	
	//Number hidden():
	//    HEX | (INT | DECIMAL) ('.' (INT | DECIMAL))?;
	public XbaseGrammarAccess.NumberElements getNumberAccess() {
		return gaXbase.getNumberAccess();
	}
	
	public ParserRule getNumberRule() {
		return getNumberAccess().getRule();
	}
	
	///**
	// * Dummy rule, for "better" downwards compatibility, since GrammarAccess generates non-static inner classes,
	// * which makes downstream grammars break on classloading, when a rule is removed.
	// */
	//StaticQualifier:
	//    (ValidID '::')+
	//;
	public XbaseGrammarAccess.StaticQualifierElements getStaticQualifierAccess() {
		return gaXbase.getStaticQualifierAccess();
	}
	
	public ParserRule getStaticQualifierRule() {
		return getStaticQualifierAccess().getRule();
	}
	
	//terminal HEX:
	//    ('0x'|'0X') ('0'..'9'|'a'..'f'|'A'..'F'|'_')+
	//    ('#' (('b'|'B')('i'|'I') | ('l'|'L')))?;
	public TerminalRule getHEXRule() {
		return gaXbase.getHEXRule();
	}
	
	//terminal INT returns ecore::EInt:
	//    '0'..'9' ('0'..'9'|'_')*;
	public TerminalRule getINTRule() {
		return gaXbase.getINTRule();
	}
	
	//terminal DECIMAL:
	//    INT
	//    (('e'|'E') ('+'|'-')? INT)?
	//    (('b'|'B')('i'|'I'|'d'|'D') | ('l'|'L'|'d'|'D'|'f'|'F'))?;
	public TerminalRule getDECIMALRule() {
		return gaXbase.getDECIMALRule();
	}
	
	//JvmTypeReference:
	//    JvmParameterizedTypeReference =>({JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)*
	//    | XFunctionTypeRef;
	public XtypeGrammarAccess.JvmTypeReferenceElements getJvmTypeReferenceAccess() {
		return gaXtype.getJvmTypeReferenceAccess();
	}
	
	public ParserRule getJvmTypeReferenceRule() {
		return getJvmTypeReferenceAccess().getRule();
	}
	
	//ArrayBrackets :
	//    '[' ']'
	//;
	public XtypeGrammarAccess.ArrayBracketsElements getArrayBracketsAccess() {
		return gaXtype.getArrayBracketsAccess();
	}
	
	public ParserRule getArrayBracketsRule() {
		return getArrayBracketsAccess().getRule();
	}
	
	//XFunctionTypeRef:
	//    ('(' (paramTypes+=JvmTypeReference (',' paramTypes+=JvmTypeReference)*)? ')')? '=>' returnType=JvmTypeReference;
	public XtypeGrammarAccess.XFunctionTypeRefElements getXFunctionTypeRefAccess() {
		return gaXtype.getXFunctionTypeRefAccess();
	}
	
	public ParserRule getXFunctionTypeRefRule() {
		return getXFunctionTypeRefAccess().getRule();
	}
	
	//JvmParameterizedTypeReference:
	//    type=[JvmType|QualifiedName] (
	//        =>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>'
	//        (=>({JvmInnerTypeReference.outer=current} '.') type=[JvmType|ValidID] (=>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>')?)*
	//    )?;
	public XtypeGrammarAccess.JvmParameterizedTypeReferenceElements getJvmParameterizedTypeReferenceAccess() {
		return gaXtype.getJvmParameterizedTypeReferenceAccess();
	}
	
	public ParserRule getJvmParameterizedTypeReferenceRule() {
		return getJvmParameterizedTypeReferenceAccess().getRule();
	}
	
	//JvmArgumentTypeReference returns JvmTypeReference:
	//    JvmTypeReference | JvmWildcardTypeReference;
	public XtypeGrammarAccess.JvmArgumentTypeReferenceElements getJvmArgumentTypeReferenceAccess() {
		return gaXtype.getJvmArgumentTypeReferenceAccess();
	}
	
	public ParserRule getJvmArgumentTypeReferenceRule() {
		return getJvmArgumentTypeReferenceAccess().getRule();
	}
	
	//JvmWildcardTypeReference:
	//    {JvmWildcardTypeReference} '?' (
	//      constraints+=JvmUpperBound (constraints+=JvmUpperBoundAnded)*
	//    | constraints+=JvmLowerBound (constraints+=JvmLowerBoundAnded)*
	//    )?;
	public XtypeGrammarAccess.JvmWildcardTypeReferenceElements getJvmWildcardTypeReferenceAccess() {
		return gaXtype.getJvmWildcardTypeReferenceAccess();
	}
	
	public ParserRule getJvmWildcardTypeReferenceRule() {
		return getJvmWildcardTypeReferenceAccess().getRule();
	}
	
	//JvmUpperBound :
	//    'extends' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmUpperBoundElements getJvmUpperBoundAccess() {
		return gaXtype.getJvmUpperBoundAccess();
	}
	
	public ParserRule getJvmUpperBoundRule() {
		return getJvmUpperBoundAccess().getRule();
	}
	
	//JvmUpperBoundAnded returns JvmUpperBound:
	//    '&' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmUpperBoundAndedElements getJvmUpperBoundAndedAccess() {
		return gaXtype.getJvmUpperBoundAndedAccess();
	}
	
	public ParserRule getJvmUpperBoundAndedRule() {
		return getJvmUpperBoundAndedAccess().getRule();
	}
	
	//JvmLowerBound :
	//    'super' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmLowerBoundElements getJvmLowerBoundAccess() {
		return gaXtype.getJvmLowerBoundAccess();
	}
	
	public ParserRule getJvmLowerBoundRule() {
		return getJvmLowerBoundAccess().getRule();
	}
	
	//JvmLowerBoundAnded returns JvmLowerBound:
	//    '&' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmLowerBoundAndedElements getJvmLowerBoundAndedAccess() {
		return gaXtype.getJvmLowerBoundAndedAccess();
	}
	
	public ParserRule getJvmLowerBoundAndedRule() {
		return getJvmLowerBoundAndedAccess().getRule();
	}
	
	//JvmTypeParameter :
	//    name=ValidID
	//    (constraints+=JvmUpperBound (constraints+=JvmUpperBoundAnded)*)?;
	public XtypeGrammarAccess.JvmTypeParameterElements getJvmTypeParameterAccess() {
		return gaXtype.getJvmTypeParameterAccess();
	}
	
	public ParserRule getJvmTypeParameterRule() {
		return getJvmTypeParameterAccess().getRule();
	}
	
	//QualifiedNameWithWildcard :
	//    QualifiedName  '.' '*';
	public XtypeGrammarAccess.QualifiedNameWithWildcardElements getQualifiedNameWithWildcardAccess() {
		return gaXtype.getQualifiedNameWithWildcardAccess();
	}
	
	public ParserRule getQualifiedNameWithWildcardRule() {
		return getQualifiedNameWithWildcardAccess().getRule();
	}
	
	//XImportSection:
	//    importDeclarations+=XImportDeclaration+;
	public XtypeGrammarAccess.XImportSectionElements getXImportSectionAccess() {
		return gaXtype.getXImportSectionAccess();
	}
	
	public ParserRule getXImportSectionRule() {
		return getXImportSectionAccess().getRule();
	}
	
	//XImportDeclaration:
	//    'import' (
	//        (static?='static' extension?='extension'? importedType=[JvmDeclaredType|QualifiedNameInStaticImport] (wildcard?='*' | memberName=ValidID))
	//        | importedType=[JvmDeclaredType|QualifiedName]
	//        | importedNamespace=QualifiedNameWithWildcard) ';'?
	//;
	public XtypeGrammarAccess.XImportDeclarationElements getXImportDeclarationAccess() {
		return gaXtype.getXImportDeclarationAccess();
	}
	
	public ParserRule getXImportDeclarationRule() {
		return getXImportDeclarationAccess().getRule();
	}
	
	//QualifiedNameInStaticImport:
	//    (ValidID '.')+
	//;
	public XtypeGrammarAccess.QualifiedNameInStaticImportElements getQualifiedNameInStaticImportAccess() {
		return gaXtype.getQualifiedNameInStaticImportAccess();
	}
	
	public ParserRule getQualifiedNameInStaticImportRule() {
		return getQualifiedNameInStaticImportAccess().getRule();
	}
	
	//terminal STRING:
	//            '"' ( '\\' . /* ('b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\') */ | !('\\'|'"') )* '"'? |
	//            "'" ( '\\' . /* ('b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\') */ | !('\\'|"'") )* "'"?;
	public TerminalRule getSTRINGRule() {
		return gaXtype.getSTRINGRule();
	}
	
	//terminal ML_COMMENT: '/*' -> '*/';
	public TerminalRule getML_COMMENTRule() {
		return gaXtype.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT: '//' !('\n'|'\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaXtype.getSL_COMMENTRule();
	}
	
	//terminal WS: (' '|'\t'|'\r'|'\n')+;
	public TerminalRule getWSRule() {
		return gaXtype.getWSRule();
	}
	
	//terminal ANY_OTHER: .;
	public TerminalRule getANY_OTHERRule() {
		return gaXtype.getANY_OTHERRule();
	}
}
