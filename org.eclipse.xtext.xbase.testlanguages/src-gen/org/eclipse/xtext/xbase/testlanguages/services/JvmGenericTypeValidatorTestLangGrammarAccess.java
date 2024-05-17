/*******************************************************************************
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.testlanguages.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;

@Singleton
public class JvmGenericTypeValidatorTestLangGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {
	
	public class JvmGenericTypeValidatorTestLangModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.testlanguages.JvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangModel");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Keyword cPackageKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cPackageAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cPackageQualifiedNameParserRuleCall_0_1_0 = (RuleCall)cPackageAssignment_0_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final Assignment cImportSectionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cImportSectionXImportSectionParserRuleCall_1_0 = (RuleCall)cImportSectionAssignment_1.eContents().get(0);
		private final Assignment cModelTypesAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cModelTypesMyTypeParserRuleCall_2_0 = (RuleCall)cModelTypesAssignment_2.eContents().get(0);
		
		//JvmGenericTypeValidatorTestLangModel:
		//    ('package' package=QualifiedName ';'?)?
		//    importSection=XImportSection?
		//    (modelTypes+=MyType)*;
		@Override public ParserRule getRule() { return rule; }
		
		//('package' package=QualifiedName ';'?)?
		//importSection=XImportSection?
		//(modelTypes+=MyType)*
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
		
		//(modelTypes+=MyType)*
		public Assignment getModelTypesAssignment_2() { return cModelTypesAssignment_2; }
		
		//MyType
		public RuleCall getModelTypesMyTypeParserRuleCall_2_0() { return cModelTypesMyTypeParserRuleCall_2_0; }
	}
	public class MyTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.testlanguages.JvmGenericTypeValidatorTestLang.MyType");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cMyClassParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cMyInterfaceParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cMyClassWithSuperTypesParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cMyClassWithWrongAdditionalInferredInterfaceParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//MyType:
		//    MyClass | MyInterface | MyClassWithSuperTypes | MyClassWithWrongAdditionalInferredInterface;
		@Override public ParserRule getRule() { return rule; }
		
		//MyClass | MyInterface | MyClassWithSuperTypes | MyClassWithWrongAdditionalInferredInterface
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//MyClass
		public RuleCall getMyClassParserRuleCall_0() { return cMyClassParserRuleCall_0; }
		
		//MyInterface
		public RuleCall getMyInterfaceParserRuleCall_1() { return cMyInterfaceParserRuleCall_1; }
		
		//MyClassWithSuperTypes
		public RuleCall getMyClassWithSuperTypesParserRuleCall_2() { return cMyClassWithSuperTypesParserRuleCall_2; }
		
		//MyClassWithWrongAdditionalInferredInterface
		public RuleCall getMyClassWithWrongAdditionalInferredInterfaceParserRuleCall_3() { return cMyClassWithWrongAdditionalInferredInterfaceParserRuleCall_3; }
	}
	public class MyClassElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.testlanguages.JvmGenericTypeValidatorTestLang.MyClass");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAbstractAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cAbstractAbstractKeyword_0_0 = (Keyword)cAbstractAssignment_0.eContents().get(0);
		private final Keyword cClassKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameValidIDParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cExtendsKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cExtendsAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cExtendsJvmParameterizedTypeReferenceParserRuleCall_3_1_0 = (RuleCall)cExtendsAssignment_3_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cImplementsKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cImplementsAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cImplementsJvmParameterizedTypeReferenceParserRuleCall_4_1_0 = (RuleCall)cImplementsAssignment_4_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cGroup_4.eContents().get(2);
		private final Keyword cCommaKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cImplementsAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cImplementsJvmParameterizedTypeReferenceParserRuleCall_4_2_1_0 = (RuleCall)cImplementsAssignment_4_2_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cMembersAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cMembersMyMemberParserRuleCall_6_0 = (RuleCall)cMembersAssignment_6.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//MyClass:
		//    (abstract ?= 'abstract')? 'class' name=ValidID
		//    ("extends" extends=JvmParameterizedTypeReference)?
		//    ('implements' implements+=JvmParameterizedTypeReference (',' implements+=JvmParameterizedTypeReference)*)? '{'
		//        (members+=MyMember)*
		//    '}';
		@Override public ParserRule getRule() { return rule; }
		
		//(abstract ?= 'abstract')? 'class' name=ValidID
		//("extends" extends=JvmParameterizedTypeReference)?
		//('implements' implements+=JvmParameterizedTypeReference (',' implements+=JvmParameterizedTypeReference)*)? '{'
		//    (members+=MyMember)*
		//'}'
		public Group getGroup() { return cGroup; }
		
		//(abstract ?= 'abstract')?
		public Assignment getAbstractAssignment_0() { return cAbstractAssignment_0; }
		
		//'abstract'
		public Keyword getAbstractAbstractKeyword_0_0() { return cAbstractAbstractKeyword_0_0; }
		
		//'class'
		public Keyword getClassKeyword_1() { return cClassKeyword_1; }
		
		//name=ValidID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_0() { return cNameValidIDParserRuleCall_2_0; }
		
		//("extends" extends=JvmParameterizedTypeReference)?
		public Group getGroup_3() { return cGroup_3; }
		
		//"extends"
		public Keyword getExtendsKeyword_3_0() { return cExtendsKeyword_3_0; }
		
		//extends=JvmParameterizedTypeReference
		public Assignment getExtendsAssignment_3_1() { return cExtendsAssignment_3_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getExtendsJvmParameterizedTypeReferenceParserRuleCall_3_1_0() { return cExtendsJvmParameterizedTypeReferenceParserRuleCall_3_1_0; }
		
		//('implements' implements+=JvmParameterizedTypeReference (',' implements+=JvmParameterizedTypeReference)*)?
		public Group getGroup_4() { return cGroup_4; }
		
		//'implements'
		public Keyword getImplementsKeyword_4_0() { return cImplementsKeyword_4_0; }
		
		//implements+=JvmParameterizedTypeReference
		public Assignment getImplementsAssignment_4_1() { return cImplementsAssignment_4_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getImplementsJvmParameterizedTypeReferenceParserRuleCall_4_1_0() { return cImplementsJvmParameterizedTypeReferenceParserRuleCall_4_1_0; }
		
		//(',' implements+=JvmParameterizedTypeReference)*
		public Group getGroup_4_2() { return cGroup_4_2; }
		
		//','
		public Keyword getCommaKeyword_4_2_0() { return cCommaKeyword_4_2_0; }
		
		//implements+=JvmParameterizedTypeReference
		public Assignment getImplementsAssignment_4_2_1() { return cImplementsAssignment_4_2_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getImplementsJvmParameterizedTypeReferenceParserRuleCall_4_2_1_0() { return cImplementsJvmParameterizedTypeReferenceParserRuleCall_4_2_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_5() { return cLeftCurlyBracketKeyword_5; }
		
		//(members+=MyMember)*
		public Assignment getMembersAssignment_6() { return cMembersAssignment_6; }
		
		//MyMember
		public RuleCall getMembersMyMemberParserRuleCall_6_0() { return cMembersMyMemberParserRuleCall_6_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class MyInterfaceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.testlanguages.JvmGenericTypeValidatorTestLang.MyInterface");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cInterfaceKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameValidIDParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLessThanSignKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_1_0 = (RuleCall)cTypeParametersAssignment_2_1.eContents().get(0);
		private final Group cGroup_2_2 = (Group)cGroup_2.eContents().get(2);
		private final Keyword cCommaKeyword_2_2_0 = (Keyword)cGroup_2_2.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_2_1 = (Assignment)cGroup_2_2.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_2_1_0 = (RuleCall)cTypeParametersAssignment_2_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_2_3 = (Keyword)cGroup_2.eContents().get(3);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cExtendsKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cExtendsAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cExtendsJvmParameterizedTypeReferenceParserRuleCall_3_1_0 = (RuleCall)cExtendsAssignment_3_1.eContents().get(0);
		private final Group cGroup_3_2 = (Group)cGroup_3.eContents().get(2);
		private final Keyword cCommaKeyword_3_2_0 = (Keyword)cGroup_3_2.eContents().get(0);
		private final Assignment cExtendsAssignment_3_2_1 = (Assignment)cGroup_3_2.eContents().get(1);
		private final RuleCall cExtendsJvmParameterizedTypeReferenceParserRuleCall_3_2_1_0 = (RuleCall)cExtendsAssignment_3_2_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//MyInterface:
		//    'interface' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//    ('extends' extends+=JvmParameterizedTypeReference (',' extends+=JvmParameterizedTypeReference)*)? '{'
		//    '}';
		@Override public ParserRule getRule() { return rule; }
		
		//'interface' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//('extends' extends+=JvmParameterizedTypeReference (',' extends+=JvmParameterizedTypeReference)*)? '{'
		//'}'
		public Group getGroup() { return cGroup; }
		
		//'interface'
		public Keyword getInterfaceKeyword_0() { return cInterfaceKeyword_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_1_0() { return cNameValidIDParserRuleCall_1_0; }
		
		//('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		public Group getGroup_2() { return cGroup_2; }
		
		//'<'
		public Keyword getLessThanSignKeyword_2_0() { return cLessThanSignKeyword_2_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_1() { return cTypeParametersAssignment_2_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_1_0; }
		
		//(',' typeParameters+=JvmTypeParameter)*
		public Group getGroup_2_2() { return cGroup_2_2; }
		
		//','
		public Keyword getCommaKeyword_2_2_0() { return cCommaKeyword_2_2_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_2_1() { return cTypeParametersAssignment_2_2_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_2_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_2_3() { return cGreaterThanSignKeyword_2_3; }
		
		//('extends' extends+=JvmParameterizedTypeReference (',' extends+=JvmParameterizedTypeReference)*)?
		public Group getGroup_3() { return cGroup_3; }
		
		//'extends'
		public Keyword getExtendsKeyword_3_0() { return cExtendsKeyword_3_0; }
		
		//extends+=JvmParameterizedTypeReference
		public Assignment getExtendsAssignment_3_1() { return cExtendsAssignment_3_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getExtendsJvmParameterizedTypeReferenceParserRuleCall_3_1_0() { return cExtendsJvmParameterizedTypeReferenceParserRuleCall_3_1_0; }
		
		//(',' extends+=JvmParameterizedTypeReference)*
		public Group getGroup_3_2() { return cGroup_3_2; }
		
		//','
		public Keyword getCommaKeyword_3_2_0() { return cCommaKeyword_3_2_0; }
		
		//extends+=JvmParameterizedTypeReference
		public Assignment getExtendsAssignment_3_2_1() { return cExtendsAssignment_3_2_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getExtendsJvmParameterizedTypeReferenceParserRuleCall_3_2_1_0() { return cExtendsJvmParameterizedTypeReferenceParserRuleCall_3_2_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}
	public class MyClassWithSuperTypesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.testlanguages.JvmGenericTypeValidatorTestLang.MyClassWithSuperTypes");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cClassWithSuperTypesKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameValidIDParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cSuperTypesKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cSuperTypesAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cSuperTypesJvmParameterizedTypeReferenceParserRuleCall_2_1_0 = (RuleCall)cSuperTypesAssignment_2_1.eContents().get(0);
		private final Group cGroup_2_2 = (Group)cGroup_2.eContents().get(2);
		private final Keyword cCommaKeyword_2_2_0 = (Keyword)cGroup_2_2.eContents().get(0);
		private final Assignment cSuperTypesAssignment_2_2_1 = (Assignment)cGroup_2_2.eContents().get(1);
		private final RuleCall cSuperTypesJvmParameterizedTypeReferenceParserRuleCall_2_2_1_0 = (RuleCall)cSuperTypesAssignment_2_2_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		///**
		// * Special class where the first specified super type is expected to be a class
		// * and the following ones interfaces.
		// * Moreover, the class always implicitly implements Serializable.
		// * Just a corner case for testing JvmGenericTypeValidator.
		// */
		//MyClassWithSuperTypes:
		//    'classWithSuperTypes' name=ValidID
		//    ("superTypes" superTypes+=JvmParameterizedTypeReference (',' superTypes+=JvmParameterizedTypeReference)*)? '{'
		//    '}'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'classWithSuperTypes' name=ValidID
		//("superTypes" superTypes+=JvmParameterizedTypeReference (',' superTypes+=JvmParameterizedTypeReference)*)? '{'
		//'}'
		public Group getGroup() { return cGroup; }
		
		//'classWithSuperTypes'
		public Keyword getClassWithSuperTypesKeyword_0() { return cClassWithSuperTypesKeyword_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_1_0() { return cNameValidIDParserRuleCall_1_0; }
		
		//("superTypes" superTypes+=JvmParameterizedTypeReference (',' superTypes+=JvmParameterizedTypeReference)*)?
		public Group getGroup_2() { return cGroup_2; }
		
		//"superTypes"
		public Keyword getSuperTypesKeyword_2_0() { return cSuperTypesKeyword_2_0; }
		
		//superTypes+=JvmParameterizedTypeReference
		public Assignment getSuperTypesAssignment_2_1() { return cSuperTypesAssignment_2_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getSuperTypesJvmParameterizedTypeReferenceParserRuleCall_2_1_0() { return cSuperTypesJvmParameterizedTypeReferenceParserRuleCall_2_1_0; }
		
		//(',' superTypes+=JvmParameterizedTypeReference)*
		public Group getGroup_2_2() { return cGroup_2_2; }
		
		//','
		public Keyword getCommaKeyword_2_2_0() { return cCommaKeyword_2_2_0; }
		
		//superTypes+=JvmParameterizedTypeReference
		public Assignment getSuperTypesAssignment_2_2_1() { return cSuperTypesAssignment_2_2_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getSuperTypesJvmParameterizedTypeReferenceParserRuleCall_2_2_1_0() { return cSuperTypesJvmParameterizedTypeReferenceParserRuleCall_2_2_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}
	public class MyClassWithWrongAdditionalInferredInterfaceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.testlanguages.JvmGenericTypeValidatorTestLang.MyClassWithWrongAdditionalInferredInterface");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cClassWithWrongInferredInterfaceKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameValidIDParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cMembersAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cMembersMyMemberParserRuleCall_3_0 = (RuleCall)cMembersAssignment_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		///**
		// * Besides a Jvm class, the inferrer will also infer an interface with problems
		// * (an abstract method with "void" as a parameter type).
		// * The additional inferred interface WILL NOT be checked by JvmGenericTypeValidator.
		// * See https://github.com/eclipse/xtext/issues/3045
		// */
		//MyClassWithWrongAdditionalInferredInterface:
		//    'classWithWrongInferredInterface' name=ValidID '{'
		//        (members+=MyMember)*
		//    '}'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'classWithWrongInferredInterface' name=ValidID '{'
		//    (members+=MyMember)*
		//'}'
		public Group getGroup() { return cGroup; }
		
		//'classWithWrongInferredInterface'
		public Keyword getClassWithWrongInferredInterfaceKeyword_0() { return cClassWithWrongInferredInterfaceKeyword_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_1_0() { return cNameValidIDParserRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//(members+=MyMember)*
		public Assignment getMembersAssignment_3() { return cMembersAssignment_3; }
		
		//MyMember
		public RuleCall getMembersMyMemberParserRuleCall_3_0() { return cMembersMyMemberParserRuleCall_3_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}
	public class MyMemberElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.testlanguages.JvmGenericTypeValidatorTestLang.MyMember");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cMyConstructorAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Keyword cConstructorKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final Group cGroup_0_3 = (Group)cGroup_0.eContents().get(3);
		private final Assignment cParametersAssignment_0_3_0 = (Assignment)cGroup_0_3.eContents().get(0);
		private final RuleCall cParametersJvmFormalParameterParserRuleCall_0_3_0_0 = (RuleCall)cParametersAssignment_0_3_0.eContents().get(0);
		private final Group cGroup_0_3_1 = (Group)cGroup_0_3.eContents().get(1);
		private final Keyword cCommaKeyword_0_3_1_0 = (Keyword)cGroup_0_3_1.eContents().get(0);
		private final Assignment cParametersAssignment_0_3_1_1 = (Assignment)cGroup_0_3_1.eContents().get(1);
		private final RuleCall cParametersJvmFormalParameterParserRuleCall_0_3_1_1_0 = (RuleCall)cParametersAssignment_0_3_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_0_4 = (Keyword)cGroup_0.eContents().get(4);
		private final Group cGroup_0_5 = (Group)cGroup_0.eContents().get(5);
		private final Keyword cThrowsKeyword_0_5_0 = (Keyword)cGroup_0_5.eContents().get(0);
		private final Assignment cExceptionsAssignment_0_5_1 = (Assignment)cGroup_0_5.eContents().get(1);
		private final RuleCall cExceptionsJvmTypeReferenceParserRuleCall_0_5_1_0 = (RuleCall)cExceptionsAssignment_0_5_1.eContents().get(0);
		private final Group cGroup_0_5_2 = (Group)cGroup_0_5.eContents().get(2);
		private final Keyword cCommaKeyword_0_5_2_0 = (Keyword)cGroup_0_5_2.eContents().get(0);
		private final Assignment cExceptionsAssignment_0_5_2_1 = (Assignment)cGroup_0_5_2.eContents().get(1);
		private final RuleCall cExceptionsJvmTypeReferenceParserRuleCall_0_5_2_1_0 = (RuleCall)cExceptionsAssignment_0_5_2_1.eContents().get(0);
		private final Assignment cExpressionAssignment_0_6 = (Assignment)cGroup_0.eContents().get(6);
		private final RuleCall cExpressionXBlockExpressionParserRuleCall_0_6_0 = (RuleCall)cExpressionAssignment_0_6.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cMyFieldAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cTypeAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cTypeJvmTypeReferenceParserRuleCall_1_1_0 = (RuleCall)cTypeAssignment_1_1.eContents().get(0);
		private final Assignment cNameAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cNameValidIDParserRuleCall_1_2_0 = (RuleCall)cNameAssignment_1_2.eContents().get(0);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Action cMyMethodAction_2_0 = (Action)cGroup_2.eContents().get(0);
		private final Keyword cDefKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		private final Assignment cStaticAssignment_2_2 = (Assignment)cGroup_2.eContents().get(2);
		private final Keyword cStaticStaticKeyword_2_2_0 = (Keyword)cStaticAssignment_2_2.eContents().get(0);
		private final Assignment cPrivateAssignment_2_3 = (Assignment)cGroup_2.eContents().get(3);
		private final Keyword cPrivatePrivateKeyword_2_3_0 = (Keyword)cPrivateAssignment_2_3.eContents().get(0);
		private final Assignment cSynchronizedAssignment_2_4 = (Assignment)cGroup_2.eContents().get(4);
		private final Keyword cSynchronizedSynchronizedKeyword_2_4_0 = (Keyword)cSynchronizedAssignment_2_4.eContents().get(0);
		private final Group cGroup_2_5 = (Group)cGroup_2.eContents().get(5);
		private final Keyword cLessThanSignKeyword_2_5_0 = (Keyword)cGroup_2_5.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_5_1 = (Assignment)cGroup_2_5.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_5_1_0 = (RuleCall)cTypeParametersAssignment_2_5_1.eContents().get(0);
		private final Group cGroup_2_5_2 = (Group)cGroup_2_5.eContents().get(2);
		private final Keyword cCommaKeyword_2_5_2_0 = (Keyword)cGroup_2_5_2.eContents().get(0);
		private final Assignment cTypeParametersAssignment_2_5_2_1 = (Assignment)cGroup_2_5_2.eContents().get(1);
		private final RuleCall cTypeParametersJvmTypeParameterParserRuleCall_2_5_2_1_0 = (RuleCall)cTypeParametersAssignment_2_5_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_2_5_3 = (Keyword)cGroup_2_5.eContents().get(3);
		private final Assignment cTypeAssignment_2_6 = (Assignment)cGroup_2.eContents().get(6);
		private final RuleCall cTypeJvmTypeReferenceParserRuleCall_2_6_0 = (RuleCall)cTypeAssignment_2_6.eContents().get(0);
		private final Assignment cNameAssignment_2_7 = (Assignment)cGroup_2.eContents().get(7);
		private final RuleCall cNameValidIDParserRuleCall_2_7_0 = (RuleCall)cNameAssignment_2_7.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2_8 = (Keyword)cGroup_2.eContents().get(8);
		private final Group cGroup_2_9 = (Group)cGroup_2.eContents().get(9);
		private final Assignment cParametersAssignment_2_9_0 = (Assignment)cGroup_2_9.eContents().get(0);
		private final RuleCall cParametersJvmFormalParameterParserRuleCall_2_9_0_0 = (RuleCall)cParametersAssignment_2_9_0.eContents().get(0);
		private final Group cGroup_2_9_1 = (Group)cGroup_2_9.eContents().get(1);
		private final Keyword cCommaKeyword_2_9_1_0 = (Keyword)cGroup_2_9_1.eContents().get(0);
		private final Assignment cParametersAssignment_2_9_1_1 = (Assignment)cGroup_2_9_1.eContents().get(1);
		private final RuleCall cParametersJvmFormalParameterParserRuleCall_2_9_1_1_0 = (RuleCall)cParametersAssignment_2_9_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2_10 = (Keyword)cGroup_2.eContents().get(10);
		private final Group cGroup_2_11 = (Group)cGroup_2.eContents().get(11);
		private final Keyword cThrowsKeyword_2_11_0 = (Keyword)cGroup_2_11.eContents().get(0);
		private final Assignment cExceptionsAssignment_2_11_1 = (Assignment)cGroup_2_11.eContents().get(1);
		private final RuleCall cExceptionsJvmTypeReferenceParserRuleCall_2_11_1_0 = (RuleCall)cExceptionsAssignment_2_11_1.eContents().get(0);
		private final Group cGroup_2_11_2 = (Group)cGroup_2_11.eContents().get(2);
		private final Keyword cCommaKeyword_2_11_2_0 = (Keyword)cGroup_2_11_2.eContents().get(0);
		private final Assignment cExceptionsAssignment_2_11_2_1 = (Assignment)cGroup_2_11_2.eContents().get(1);
		private final RuleCall cExceptionsJvmTypeReferenceParserRuleCall_2_11_2_1_0 = (RuleCall)cExceptionsAssignment_2_11_2_1.eContents().get(0);
		private final Assignment cExpressionAssignment_2_12 = (Assignment)cGroup_2.eContents().get(12);
		private final RuleCall cExpressionXBlockExpressionParserRuleCall_2_12_0 = (RuleCall)cExpressionAssignment_2_12.eContents().get(0);
		private final RuleCall cMyClassParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//MyMember:
		//    ({MyConstructor} 'constructor'
		//        '(' (parameters+=JvmFormalParameter (',' parameters+=JvmFormalParameter)*)? ')'
		//        ('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
		//        expression=XBlockExpression)
		//    |
		//    ({MyField} type=JvmTypeReference name=ValidID)
		//    |
		//    ({MyMethod} 'def' (static ?= 'static')? (private ?= 'private')? (synchronized ?= 'synchronized')?
		//        ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//        type=JvmTypeReference name=ValidID
		//        '(' (parameters+=JvmFormalParameter (',' parameters+=JvmFormalParameter)*)? ')'
		//        ('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
		//        expression=XBlockExpression)
		//    |
		//    MyClass // nested local class
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//({MyConstructor} 'constructor'
		//    '(' (parameters+=JvmFormalParameter (',' parameters+=JvmFormalParameter)*)? ')'
		//    ('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
		//    expression=XBlockExpression)
		//|
		//({MyField} type=JvmTypeReference name=ValidID)
		//|
		//({MyMethod} 'def' (static ?= 'static')? (private ?= 'private')? (synchronized ?= 'synchronized')?
		//    ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//    type=JvmTypeReference name=ValidID
		//    '(' (parameters+=JvmFormalParameter (',' parameters+=JvmFormalParameter)*)? ')'
		//    ('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
		//    expression=XBlockExpression)
		//|
		//MyClass
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//({MyConstructor} 'constructor'
		//    '(' (parameters+=JvmFormalParameter (',' parameters+=JvmFormalParameter)*)? ')'
		//    ('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
		//    expression=XBlockExpression)
		public Group getGroup_0() { return cGroup_0; }
		
		//{MyConstructor}
		public Action getMyConstructorAction_0_0() { return cMyConstructorAction_0_0; }
		
		//'constructor'
		public Keyword getConstructorKeyword_0_1() { return cConstructorKeyword_0_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_0_2() { return cLeftParenthesisKeyword_0_2; }
		
		//(parameters+=JvmFormalParameter (',' parameters+=JvmFormalParameter)*)?
		public Group getGroup_0_3() { return cGroup_0_3; }
		
		//parameters+=JvmFormalParameter
		public Assignment getParametersAssignment_0_3_0() { return cParametersAssignment_0_3_0; }
		
		//JvmFormalParameter
		public RuleCall getParametersJvmFormalParameterParserRuleCall_0_3_0_0() { return cParametersJvmFormalParameterParserRuleCall_0_3_0_0; }
		
		//(',' parameters+=JvmFormalParameter)*
		public Group getGroup_0_3_1() { return cGroup_0_3_1; }
		
		//','
		public Keyword getCommaKeyword_0_3_1_0() { return cCommaKeyword_0_3_1_0; }
		
		//parameters+=JvmFormalParameter
		public Assignment getParametersAssignment_0_3_1_1() { return cParametersAssignment_0_3_1_1; }
		
		//JvmFormalParameter
		public RuleCall getParametersJvmFormalParameterParserRuleCall_0_3_1_1_0() { return cParametersJvmFormalParameterParserRuleCall_0_3_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_0_4() { return cRightParenthesisKeyword_0_4; }
		
		//('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
		public Group getGroup_0_5() { return cGroup_0_5; }
		
		//'throws'
		public Keyword getThrowsKeyword_0_5_0() { return cThrowsKeyword_0_5_0; }
		
		//exceptions+=JvmTypeReference
		public Assignment getExceptionsAssignment_0_5_1() { return cExceptionsAssignment_0_5_1; }
		
		//JvmTypeReference
		public RuleCall getExceptionsJvmTypeReferenceParserRuleCall_0_5_1_0() { return cExceptionsJvmTypeReferenceParserRuleCall_0_5_1_0; }
		
		//(',' exceptions+=JvmTypeReference)*
		public Group getGroup_0_5_2() { return cGroup_0_5_2; }
		
		//','
		public Keyword getCommaKeyword_0_5_2_0() { return cCommaKeyword_0_5_2_0; }
		
		//exceptions+=JvmTypeReference
		public Assignment getExceptionsAssignment_0_5_2_1() { return cExceptionsAssignment_0_5_2_1; }
		
		//JvmTypeReference
		public RuleCall getExceptionsJvmTypeReferenceParserRuleCall_0_5_2_1_0() { return cExceptionsJvmTypeReferenceParserRuleCall_0_5_2_1_0; }
		
		//expression=XBlockExpression
		public Assignment getExpressionAssignment_0_6() { return cExpressionAssignment_0_6; }
		
		//XBlockExpression
		public RuleCall getExpressionXBlockExpressionParserRuleCall_0_6_0() { return cExpressionXBlockExpressionParserRuleCall_0_6_0; }
		
		//({MyField} type=JvmTypeReference name=ValidID)
		public Group getGroup_1() { return cGroup_1; }
		
		//{MyField}
		public Action getMyFieldAction_1_0() { return cMyFieldAction_1_0; }
		
		//type=JvmTypeReference
		public Assignment getTypeAssignment_1_1() { return cTypeAssignment_1_1; }
		
		//JvmTypeReference
		public RuleCall getTypeJvmTypeReferenceParserRuleCall_1_1_0() { return cTypeJvmTypeReferenceParserRuleCall_1_1_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_1_2() { return cNameAssignment_1_2; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_1_2_0() { return cNameValidIDParserRuleCall_1_2_0; }
		
		//({MyMethod} 'def' (static ?= 'static')? (private ?= 'private')? (synchronized ?= 'synchronized')?
		//    ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		//    type=JvmTypeReference name=ValidID
		//    '(' (parameters+=JvmFormalParameter (',' parameters+=JvmFormalParameter)*)? ')'
		//    ('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
		//    expression=XBlockExpression)
		public Group getGroup_2() { return cGroup_2; }
		
		//{MyMethod}
		public Action getMyMethodAction_2_0() { return cMyMethodAction_2_0; }
		
		//'def'
		public Keyword getDefKeyword_2_1() { return cDefKeyword_2_1; }
		
		//(static ?= 'static')?
		public Assignment getStaticAssignment_2_2() { return cStaticAssignment_2_2; }
		
		//'static'
		public Keyword getStaticStaticKeyword_2_2_0() { return cStaticStaticKeyword_2_2_0; }
		
		//(private ?= 'private')?
		public Assignment getPrivateAssignment_2_3() { return cPrivateAssignment_2_3; }
		
		//'private'
		public Keyword getPrivatePrivateKeyword_2_3_0() { return cPrivatePrivateKeyword_2_3_0; }
		
		//(synchronized ?= 'synchronized')?
		public Assignment getSynchronizedAssignment_2_4() { return cSynchronizedAssignment_2_4; }
		
		//'synchronized'
		public Keyword getSynchronizedSynchronizedKeyword_2_4_0() { return cSynchronizedSynchronizedKeyword_2_4_0; }
		
		//('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
		public Group getGroup_2_5() { return cGroup_2_5; }
		
		//'<'
		public Keyword getLessThanSignKeyword_2_5_0() { return cLessThanSignKeyword_2_5_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_5_1() { return cTypeParametersAssignment_2_5_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_5_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_5_1_0; }
		
		//(',' typeParameters+=JvmTypeParameter)*
		public Group getGroup_2_5_2() { return cGroup_2_5_2; }
		
		//','
		public Keyword getCommaKeyword_2_5_2_0() { return cCommaKeyword_2_5_2_0; }
		
		//typeParameters+=JvmTypeParameter
		public Assignment getTypeParametersAssignment_2_5_2_1() { return cTypeParametersAssignment_2_5_2_1; }
		
		//JvmTypeParameter
		public RuleCall getTypeParametersJvmTypeParameterParserRuleCall_2_5_2_1_0() { return cTypeParametersJvmTypeParameterParserRuleCall_2_5_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_2_5_3() { return cGreaterThanSignKeyword_2_5_3; }
		
		//type=JvmTypeReference
		public Assignment getTypeAssignment_2_6() { return cTypeAssignment_2_6; }
		
		//JvmTypeReference
		public RuleCall getTypeJvmTypeReferenceParserRuleCall_2_6_0() { return cTypeJvmTypeReferenceParserRuleCall_2_6_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_7() { return cNameAssignment_2_7; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_7_0() { return cNameValidIDParserRuleCall_2_7_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2_8() { return cLeftParenthesisKeyword_2_8; }
		
		//(parameters+=JvmFormalParameter (',' parameters+=JvmFormalParameter)*)?
		public Group getGroup_2_9() { return cGroup_2_9; }
		
		//parameters+=JvmFormalParameter
		public Assignment getParametersAssignment_2_9_0() { return cParametersAssignment_2_9_0; }
		
		//JvmFormalParameter
		public RuleCall getParametersJvmFormalParameterParserRuleCall_2_9_0_0() { return cParametersJvmFormalParameterParserRuleCall_2_9_0_0; }
		
		//(',' parameters+=JvmFormalParameter)*
		public Group getGroup_2_9_1() { return cGroup_2_9_1; }
		
		//','
		public Keyword getCommaKeyword_2_9_1_0() { return cCommaKeyword_2_9_1_0; }
		
		//parameters+=JvmFormalParameter
		public Assignment getParametersAssignment_2_9_1_1() { return cParametersAssignment_2_9_1_1; }
		
		//JvmFormalParameter
		public RuleCall getParametersJvmFormalParameterParserRuleCall_2_9_1_1_0() { return cParametersJvmFormalParameterParserRuleCall_2_9_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2_10() { return cRightParenthesisKeyword_2_10; }
		
		//('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
		public Group getGroup_2_11() { return cGroup_2_11; }
		
		//'throws'
		public Keyword getThrowsKeyword_2_11_0() { return cThrowsKeyword_2_11_0; }
		
		//exceptions+=JvmTypeReference
		public Assignment getExceptionsAssignment_2_11_1() { return cExceptionsAssignment_2_11_1; }
		
		//JvmTypeReference
		public RuleCall getExceptionsJvmTypeReferenceParserRuleCall_2_11_1_0() { return cExceptionsJvmTypeReferenceParserRuleCall_2_11_1_0; }
		
		//(',' exceptions+=JvmTypeReference)*
		public Group getGroup_2_11_2() { return cGroup_2_11_2; }
		
		//','
		public Keyword getCommaKeyword_2_11_2_0() { return cCommaKeyword_2_11_2_0; }
		
		//exceptions+=JvmTypeReference
		public Assignment getExceptionsAssignment_2_11_2_1() { return cExceptionsAssignment_2_11_2_1; }
		
		//JvmTypeReference
		public RuleCall getExceptionsJvmTypeReferenceParserRuleCall_2_11_2_1_0() { return cExceptionsJvmTypeReferenceParserRuleCall_2_11_2_1_0; }
		
		//expression=XBlockExpression
		public Assignment getExpressionAssignment_2_12() { return cExpressionAssignment_2_12; }
		
		//XBlockExpression
		public RuleCall getExpressionXBlockExpressionParserRuleCall_2_12_0() { return cExpressionXBlockExpressionParserRuleCall_2_12_0; }
		
		//MyClass
		public RuleCall getMyClassParserRuleCall_3() { return cMyClassParserRuleCall_3; }
	}
	
	
	private final JvmGenericTypeValidatorTestLangModelElements pJvmGenericTypeValidatorTestLangModel;
	private final MyTypeElements pMyType;
	private final MyClassElements pMyClass;
	private final MyInterfaceElements pMyInterface;
	private final MyClassWithSuperTypesElements pMyClassWithSuperTypes;
	private final MyClassWithWrongAdditionalInferredInterfaceElements pMyClassWithWrongAdditionalInferredInterface;
	private final MyMemberElements pMyMember;
	
	private final Grammar grammar;
	
	private final XbaseGrammarAccess gaXbase;
	
	private final XtypeGrammarAccess gaXtype;

	@Inject
	public JvmGenericTypeValidatorTestLangGrammarAccess(GrammarProvider grammarProvider,
			XbaseGrammarAccess gaXbase,
			XtypeGrammarAccess gaXtype) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaXbase = gaXbase;
		this.gaXtype = gaXtype;
		this.pJvmGenericTypeValidatorTestLangModel = new JvmGenericTypeValidatorTestLangModelElements();
		this.pMyType = new MyTypeElements();
		this.pMyClass = new MyClassElements();
		this.pMyInterface = new MyInterfaceElements();
		this.pMyClassWithSuperTypes = new MyClassWithSuperTypesElements();
		this.pMyClassWithWrongAdditionalInferredInterface = new MyClassWithWrongAdditionalInferredInterfaceElements();
		this.pMyMember = new MyMemberElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.xtext.xbase.testlanguages.JvmGenericTypeValidatorTestLang".equals(grammar.getName())) {
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
	
	
	public XbaseGrammarAccess getXbaseGrammarAccess() {
		return gaXbase;
	}
	
	public XtypeGrammarAccess getXtypeGrammarAccess() {
		return gaXtype;
	}

	
	//JvmGenericTypeValidatorTestLangModel:
	//    ('package' package=QualifiedName ';'?)?
	//    importSection=XImportSection?
	//    (modelTypes+=MyType)*;
	public JvmGenericTypeValidatorTestLangModelElements getJvmGenericTypeValidatorTestLangModelAccess() {
		return pJvmGenericTypeValidatorTestLangModel;
	}
	
	public ParserRule getJvmGenericTypeValidatorTestLangModelRule() {
		return getJvmGenericTypeValidatorTestLangModelAccess().getRule();
	}
	
	//MyType:
	//    MyClass | MyInterface | MyClassWithSuperTypes | MyClassWithWrongAdditionalInferredInterface;
	public MyTypeElements getMyTypeAccess() {
		return pMyType;
	}
	
	public ParserRule getMyTypeRule() {
		return getMyTypeAccess().getRule();
	}
	
	//MyClass:
	//    (abstract ?= 'abstract')? 'class' name=ValidID
	//    ("extends" extends=JvmParameterizedTypeReference)?
	//    ('implements' implements+=JvmParameterizedTypeReference (',' implements+=JvmParameterizedTypeReference)*)? '{'
	//        (members+=MyMember)*
	//    '}';
	public MyClassElements getMyClassAccess() {
		return pMyClass;
	}
	
	public ParserRule getMyClassRule() {
		return getMyClassAccess().getRule();
	}
	
	//MyInterface:
	//    'interface' name=ValidID ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
	//    ('extends' extends+=JvmParameterizedTypeReference (',' extends+=JvmParameterizedTypeReference)*)? '{'
	//    '}';
	public MyInterfaceElements getMyInterfaceAccess() {
		return pMyInterface;
	}
	
	public ParserRule getMyInterfaceRule() {
		return getMyInterfaceAccess().getRule();
	}
	
	///**
	// * Special class where the first specified super type is expected to be a class
	// * and the following ones interfaces.
	// * Moreover, the class always implicitly implements Serializable.
	// * Just a corner case for testing JvmGenericTypeValidator.
	// */
	//MyClassWithSuperTypes:
	//    'classWithSuperTypes' name=ValidID
	//    ("superTypes" superTypes+=JvmParameterizedTypeReference (',' superTypes+=JvmParameterizedTypeReference)*)? '{'
	//    '}'
	//;
	public MyClassWithSuperTypesElements getMyClassWithSuperTypesAccess() {
		return pMyClassWithSuperTypes;
	}
	
	public ParserRule getMyClassWithSuperTypesRule() {
		return getMyClassWithSuperTypesAccess().getRule();
	}
	
	///**
	// * Besides a Jvm class, the inferrer will also infer an interface with problems
	// * (an abstract method with "void" as a parameter type).
	// * The additional inferred interface WILL NOT be checked by JvmGenericTypeValidator.
	// * See https://github.com/eclipse/xtext/issues/3045
	// */
	//MyClassWithWrongAdditionalInferredInterface:
	//    'classWithWrongInferredInterface' name=ValidID '{'
	//        (members+=MyMember)*
	//    '}'
	//;
	public MyClassWithWrongAdditionalInferredInterfaceElements getMyClassWithWrongAdditionalInferredInterfaceAccess() {
		return pMyClassWithWrongAdditionalInferredInterface;
	}
	
	public ParserRule getMyClassWithWrongAdditionalInferredInterfaceRule() {
		return getMyClassWithWrongAdditionalInferredInterfaceAccess().getRule();
	}
	
	//MyMember:
	//    ({MyConstructor} 'constructor'
	//        '(' (parameters+=JvmFormalParameter (',' parameters+=JvmFormalParameter)*)? ')'
	//        ('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
	//        expression=XBlockExpression)
	//    |
	//    ({MyField} type=JvmTypeReference name=ValidID)
	//    |
	//    ({MyMethod} 'def' (static ?= 'static')? (private ?= 'private')? (synchronized ?= 'synchronized')?
	//        ('<' typeParameters+=JvmTypeParameter (',' typeParameters+=JvmTypeParameter)* '>')?
	//        type=JvmTypeReference name=ValidID
	//        '(' (parameters+=JvmFormalParameter (',' parameters+=JvmFormalParameter)*)? ')'
	//        ('throws' exceptions+=JvmTypeReference (',' exceptions+=JvmTypeReference)*)?
	//        expression=XBlockExpression)
	//    |
	//    MyClass // nested local class
	//;
	public MyMemberElements getMyMemberAccess() {
		return pMyMember;
	}
	
	public ParserRule getMyMemberRule() {
		return getMyMemberAccess().getRule();
	}
	
	//XExpression returns XExpression :
	//    XAssignment;
	public XbaseGrammarAccess.XExpressionElements getXExpressionAccess() {
		return gaXbase.getXExpressionAccess();
	}
	
	public ParserRule getXExpressionRule() {
		return getXExpressionAccess().getRule();
	}
	
	//XAssignment returns XExpression :
	//    {XAssignment} feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign value=XAssignment |
	//    XOrExpression (
	//        =>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMultiAssign]) rightOperand=XAssignment
	//    )?;
	public XbaseGrammarAccess.XAssignmentElements getXAssignmentAccess() {
		return gaXbase.getXAssignmentAccess();
	}
	
	public ParserRule getXAssignmentRule() {
		return getXAssignmentAccess().getRule();
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
	
	//XSwitchExpression returns XExpression:
	//    {XSwitchExpression}
	//    'switch' (=>('(' declaredParam=JvmFormalParameter ':') switch=XExpression ')'
	//        | =>(declaredParam=JvmFormalParameter ':')? switch=XExpression) '{'
	//    (cases+=XCasePart)*
	//    ('default' ':' default=XExpression )?
	//    '}';
	public XbaseGrammarAccess.XSwitchExpressionElements getXSwitchExpressionAccess() {
		return gaXbase.getXSwitchExpressionAccess();
	}
	
	public ParserRule getXSwitchExpressionRule() {
		return getXSwitchExpressionAccess().getRule();
	}
	
	//XCasePart:
	//    {XCasePart}
	//    typeGuard=JvmTypeReference? ('case' case=XExpression)?
	//        (':' then=XExpression | fallThrough?=',') ;
	public XbaseGrammarAccess.XCasePartElements getXCasePartAccess() {
		return gaXbase.getXCasePartAccess();
	}
	
	public ParserRule getXCasePartRule() {
		return getXCasePartAccess().getRule();
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
	
	//XVariableDeclaration returns XExpression:
	//    {XVariableDeclaration}
	//    (writeable?='var'|'val') (=>(type=JvmTypeReference name=ValidID) | name=ValidID) ('=' right=XExpression)?;
	public XbaseGrammarAccess.XVariableDeclarationElements getXVariableDeclarationAccess() {
		return gaXbase.getXVariableDeclarationAccess();
	}
	
	public ParserRule getXVariableDeclarationRule() {
		return getXVariableDeclarationAccess().getRule();
	}
	
	//JvmFormalParameter returns types::JvmFormalParameter:
	//    (parameterType=JvmTypeReference)? name=ValidID;
	public XbaseGrammarAccess.JvmFormalParameterElements getJvmFormalParameterAccess() {
		return gaXbase.getJvmFormalParameterAccess();
	}
	
	public ParserRule getJvmFormalParameterRule() {
		return getJvmFormalParameterAccess().getRule();
	}
	
	//FullJvmFormalParameter returns types::JvmFormalParameter:
	//    parameterType=JvmTypeReference name=ValidID;
	public XbaseGrammarAccess.FullJvmFormalParameterElements getFullJvmFormalParameterAccess() {
		return gaXbase.getFullJvmFormalParameterAccess();
	}
	
	public ParserRule getFullJvmFormalParameterRule() {
		return getFullJvmFormalParameterAccess().getRule();
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
	
	//FeatureCallID:
	//    ValidID | 'extends' | 'static' | 'import' | 'extension'
	//;
	public XbaseGrammarAccess.FeatureCallIDElements getFeatureCallIDAccess() {
		return gaXbase.getFeatureCallIDAccess();
	}
	
	public ParserRule getFeatureCallIDRule() {
		return getFeatureCallIDAccess().getRule();
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
	
	//XConstructorCall returns XExpression:
	//    {XConstructorCall}
	//    'new' constructor=[types::JvmConstructor|QualifiedName]
	//    (=>'<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
	//    (=>explicitConstructorCall?='('
	//        (
	//            arguments+=XShortClosure
	//          | arguments+=XExpression (',' arguments+=XExpression)*
	//        )?
	//    ')')?
	//    arguments+=XClosure?;
	public XbaseGrammarAccess.XConstructorCallElements getXConstructorCallAccess() {
		return gaXbase.getXConstructorCallAccess();
	}
	
	public ParserRule getXConstructorCallRule() {
		return getXConstructorCallAccess().getRule();
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
	
	//XStringLiteral returns XExpression:
	//    {XStringLiteral} value=STRING;
	public XbaseGrammarAccess.XStringLiteralElements getXStringLiteralAccess() {
		return gaXbase.getXStringLiteralAccess();
	}
	
	public ParserRule getXStringLiteralRule() {
		return getXStringLiteralAccess().getRule();
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
	
	//XTryCatchFinallyExpression returns XExpression:
	//    {XTryCatchFinallyExpression}
	//    'try'
	//        expression=XExpression
	//    (
	//        catchClauses+=XCatchClause+
	//        (=>'finally' finallyExpression=XExpression)?
	//    |    'finally' finallyExpression=XExpression
	//    );
	public XbaseGrammarAccess.XTryCatchFinallyExpressionElements getXTryCatchFinallyExpressionAccess() {
		return gaXbase.getXTryCatchFinallyExpressionAccess();
	}
	
	public ParserRule getXTryCatchFinallyExpressionRule() {
		return getXTryCatchFinallyExpressionAccess().getRule();
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
	
	//ValidID:
	//    ID;
	public XtypeGrammarAccess.ValidIDElements getValidIDAccess() {
		return gaXtype.getValidIDAccess();
	}
	
	public ParserRule getValidIDRule() {
		return getValidIDAccess().getRule();
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
	
	//terminal ID:
	//    '^'? ('a'..'z'|'A'..'Z'|'$'|'_') ('a'..'z'|'A'..'Z'|'$'|'_'|'0'..'9')*;
	public TerminalRule getIDRule() {
		return gaXtype.getIDRule();
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
