/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalBacktrackingContentAssistTestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.BacktrackingContentAssistTestLanguageGrammarAccess;

public class BacktrackingContentAssistTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(BacktrackingContentAssistTestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, BacktrackingContentAssistTestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getDocumentAccess().getAlternatives(), "rule__Document__Alternatives");
			builder.put(grammarAccess.getClassifierContextDeclAccess().getAlternatives_3(), "rule__ClassifierContextDecl__Alternatives_3");
			builder.put(grammarAccess.getClassifierRefAccess().getAlternatives(), "rule__ClassifierRef__Alternatives");
			builder.put(grammarAccess.getContextDeclAccess().getAlternatives(), "rule__ContextDecl__Alternatives");
			builder.put(grammarAccess.getOperationContextDeclAccess().getAlternatives_7(), "rule__OperationContextDecl__Alternatives_7");
			builder.put(grammarAccess.getOperationRefAccess().getAlternatives(), "rule__OperationRef__Alternatives");
			builder.put(grammarAccess.getPackageRefAccess().getAlternatives(), "rule__PackageRef__Alternatives");
			builder.put(grammarAccess.getPropertyContextDeclAccess().getAlternatives_4(), "rule__PropertyContextDecl__Alternatives_4");
			builder.put(grammarAccess.getPropertyRefAccess().getAlternatives(), "rule__PropertyRef__Alternatives");
			builder.put(grammarAccess.getNavigationExpAccess().getAlternatives_1(), "rule__NavigationExp__Alternatives_1");
			builder.put(grammarAccess.getNavigationExpAccess().getOpAlternatives_1_0_1_0(), "rule__NavigationExp__OpAlternatives_1_0_1_0");
			builder.put(grammarAccess.getNavigationExpAccess().getOpAlternatives_1_1_1_0(), "rule__NavigationExp__OpAlternatives_1_1_1_0");
			builder.put(grammarAccess.getNavigatingExpAccess().getAlternatives_1(), "rule__NavigatingExp__Alternatives_1");
			builder.put(grammarAccess.getNavigatingExpAccess().getOpAlternatives_1_0_1_0(), "rule__NavigatingExp__OpAlternatives_1_0_1_0");
			builder.put(grammarAccess.getNavigatingExpAccess().getOpAlternatives_1_1_1_0(), "rule__NavigatingExp__OpAlternatives_1_1_1_0");
			builder.put(grammarAccess.getOclMessageArgAccess().getAlternatives(), "rule__OclMessageArg__Alternatives");
			builder.put(grammarAccess.getNUMBER_LITERALAccess().getAlternatives_2_0(), "rule__NUMBER_LITERAL__Alternatives_2_0");
			builder.put(grammarAccess.getNUMBER_LITERALAccess().getAlternatives_2_1(), "rule__NUMBER_LITERAL__Alternatives_2_1");
			builder.put(grammarAccess.getEssentialOCLRestrictedKeywordsAccess().getAlternatives(), "rule__EssentialOCLRestrictedKeywords__Alternatives");
			builder.put(grammarAccess.getIdentifierAccess().getAlternatives(), "rule__Identifier__Alternatives");
			builder.put(grammarAccess.getPrimitiveTypeIdentifierAccess().getAlternatives(), "rule__PrimitiveTypeIdentifier__Alternatives");
			builder.put(grammarAccess.getCollectionTypeIdentifierAccess().getAlternatives(), "rule__CollectionTypeIdentifier__Alternatives");
			builder.put(grammarAccess.getTypeExpAccess().getAlternatives(), "rule__TypeExp__Alternatives");
			builder.put(grammarAccess.getPrimitiveLiteralExpAccess().getAlternatives(), "rule__PrimitiveLiteralExp__Alternatives");
			builder.put(grammarAccess.getBooleanLiteralExpAccess().getAlternatives_1(), "rule__BooleanLiteralExp__Alternatives_1");
			builder.put(grammarAccess.getExpressionAccess().getAlternatives(), "rule__Expression__Alternatives");
			builder.put(grammarAccess.getImpliesAccess().getArgumentAlternatives_1_2_0(), "rule__Implies__ArgumentAlternatives_1_2_0");
			builder.put(grammarAccess.getXorAccess().getArgumentAlternatives_1_2_0(), "rule__Xor__ArgumentAlternatives_1_2_0");
			builder.put(grammarAccess.getOrAccess().getArgumentAlternatives_1_2_0(), "rule__Or__ArgumentAlternatives_1_2_0");
			builder.put(grammarAccess.getAndAccess().getArgumentAlternatives_1_2_0(), "rule__And__ArgumentAlternatives_1_2_0");
			builder.put(grammarAccess.getEqualityAccess().getOpAlternatives_1_1_0(), "rule__Equality__OpAlternatives_1_1_0");
			builder.put(grammarAccess.getEqualityAccess().getArgumentAlternatives_1_2_0(), "rule__Equality__ArgumentAlternatives_1_2_0");
			builder.put(grammarAccess.getRelationalAccess().getOpAlternatives_1_1_0(), "rule__Relational__OpAlternatives_1_1_0");
			builder.put(grammarAccess.getRelationalAccess().getArgumentAlternatives_1_2_0(), "rule__Relational__ArgumentAlternatives_1_2_0");
			builder.put(grammarAccess.getAdditiveAccess().getOpAlternatives_1_1_0(), "rule__Additive__OpAlternatives_1_1_0");
			builder.put(grammarAccess.getAdditiveAccess().getArgumentAlternatives_1_2_0(), "rule__Additive__ArgumentAlternatives_1_2_0");
			builder.put(grammarAccess.getMultiplicativeAccess().getOpAlternatives_1_1_0(), "rule__Multiplicative__OpAlternatives_1_1_0");
			builder.put(grammarAccess.getMultiplicativeAccess().getArgumentAlternatives_1_2_0(), "rule__Multiplicative__ArgumentAlternatives_1_2_0");
			builder.put(grammarAccess.getUnaryAccess().getAlternatives(), "rule__Unary__Alternatives");
			builder.put(grammarAccess.getUnaryAccess().getOpAlternatives_1_1_0(), "rule__Unary__OpAlternatives_1_1_0");
			builder.put(grammarAccess.getSubNavigationExpAccess().getAlternatives(), "rule__SubNavigationExp__Alternatives");
			builder.put(grammarAccess.getSubNavigatingExpAccess().getAlternatives(), "rule__SubNavigatingExp__Alternatives");
			builder.put(grammarAccess.getRoundBracketExpAccess().getAlternatives_3_1(), "rule__RoundBracketExp__Alternatives_3_1");
			builder.put(grammarAccess.getNameExpAccess().getAlternatives(), "rule__NameExp__Alternatives");
			builder.put(grammarAccess.getBodyAccess().getGroup(), "rule__Body__Group__0");
			builder.put(grammarAccess.getClassifierContextDeclAccess().getGroup(), "rule__ClassifierContextDecl__Group__0");
			builder.put(grammarAccess.getClassifierContextDeclAccess().getGroup_1(), "rule__ClassifierContextDecl__Group_1__0");
			builder.put(grammarAccess.getDefinitionAccess().getGroup(), "rule__Definition__Group__0");
			builder.put(grammarAccess.getDefinitionAccess().getGroup_5(), "rule__Definition__Group_5__0");
			builder.put(grammarAccess.getDefinitionAccess().getGroup_5_1(), "rule__Definition__Group_5_1__0");
			builder.put(grammarAccess.getDefinitionAccess().getGroup_5_1_1(), "rule__Definition__Group_5_1_1__0");
			builder.put(grammarAccess.getDerAccess().getGroup(), "rule__Der__Group__0");
			builder.put(grammarAccess.getInitAccess().getGroup(), "rule__Init__Group__0");
			builder.put(grammarAccess.getInvariantAccess().getGroup(), "rule__Invariant__Group__0");
			builder.put(grammarAccess.getOperationContextDeclAccess().getGroup(), "rule__OperationContextDecl__Group__0");
			builder.put(grammarAccess.getOperationContextDeclAccess().getGroup_3(), "rule__OperationContextDecl__Group_3__0");
			builder.put(grammarAccess.getOperationContextDeclAccess().getGroup_3_1(), "rule__OperationContextDecl__Group_3_1__0");
			builder.put(grammarAccess.getPackageDeclarationAccess().getGroup(), "rule__PackageDeclaration__Group__0");
			builder.put(grammarAccess.getParameterAccess().getGroup(), "rule__Parameter__Group__0");
			builder.put(grammarAccess.getParameterAccess().getGroup_0(), "rule__Parameter__Group_0__0");
			builder.put(grammarAccess.getPostAccess().getGroup(), "rule__Post__Group__0");
			builder.put(grammarAccess.getPreAccess().getGroup(), "rule__Pre__Group__0");
			builder.put(grammarAccess.getPropertyContextDeclAccess().getGroup(), "rule__PropertyContextDecl__Group__0");
			builder.put(grammarAccess.getPropertyContextDeclAccess().getGroup_4_0(), "rule__PropertyContextDecl__Group_4_0__0");
			builder.put(grammarAccess.getPropertyContextDeclAccess().getGroup_4_1(), "rule__PropertyContextDecl__Group_4_1__0");
			builder.put(grammarAccess.getQualifiedClassifierRefAccess().getGroup(), "rule__QualifiedClassifierRef__Group__0");
			builder.put(grammarAccess.getQualifiedOperationRefAccess().getGroup(), "rule__QualifiedOperationRef__Group__0");
			builder.put(grammarAccess.getQualifiedPropertyRefAccess().getGroup(), "rule__QualifiedPropertyRef__Group__0");
			builder.put(grammarAccess.getQualifiedPackageRefAccess().getGroup(), "rule__QualifiedPackageRef__Group__0");
			builder.put(grammarAccess.getNavigationExpAccess().getGroup(), "rule__NavigationExp__Group__0");
			builder.put(grammarAccess.getNavigationExpAccess().getGroup_1_0(), "rule__NavigationExp__Group_1_0__0");
			builder.put(grammarAccess.getNavigationExpAccess().getGroup_1_1(), "rule__NavigationExp__Group_1_1__0");
			builder.put(grammarAccess.getNavigationExpAccess().getGroup_1_1_4(), "rule__NavigationExp__Group_1_1_4__0");
			builder.put(grammarAccess.getNavigationExpAccess().getGroup_1_1_4_1(), "rule__NavigationExp__Group_1_1_4_1__0");
			builder.put(grammarAccess.getNavigatingExpAccess().getGroup(), "rule__NavigatingExp__Group__0");
			builder.put(grammarAccess.getNavigatingExpAccess().getGroup_1_0(), "rule__NavigatingExp__Group_1_0__0");
			builder.put(grammarAccess.getNavigatingExpAccess().getGroup_1_1(), "rule__NavigatingExp__Group_1_1__0");
			builder.put(grammarAccess.getNavigatingExpAccess().getGroup_1_1_4(), "rule__NavigatingExp__Group_1_1_4__0");
			builder.put(grammarAccess.getNavigatingExpAccess().getGroup_1_1_4_1(), "rule__NavigatingExp__Group_1_1_4_1__0");
			builder.put(grammarAccess.getOclMessageArgAccess().getGroup_0(), "rule__OclMessageArg__Group_0__0");
			builder.put(grammarAccess.getOclMessageArgAccess().getGroup_0_2(), "rule__OclMessageArg__Group_0_2__0");
			builder.put(grammarAccess.getNUMBER_LITERALAccess().getGroup(), "rule__NUMBER_LITERAL__Group__0");
			builder.put(grammarAccess.getNUMBER_LITERALAccess().getGroup_1(), "rule__NUMBER_LITERAL__Group_1__0");
			builder.put(grammarAccess.getNUMBER_LITERALAccess().getGroup_2(), "rule__NUMBER_LITERAL__Group_2__0");
			builder.put(grammarAccess.getCollectionTypeAccess().getGroup(), "rule__CollectionType__Group__0");
			builder.put(grammarAccess.getCollectionTypeAccess().getGroup_1(), "rule__CollectionType__Group_1__0");
			builder.put(grammarAccess.getTupleTypeAccess().getGroup(), "rule__TupleType__Group__0");
			builder.put(grammarAccess.getTupleTypeAccess().getGroup_2(), "rule__TupleType__Group_2__0");
			builder.put(grammarAccess.getTupleTypeAccess().getGroup_2_1(), "rule__TupleType__Group_2_1__0");
			builder.put(grammarAccess.getTuplePartAccess().getGroup(), "rule__TuplePart__Group__0");
			builder.put(grammarAccess.getCollectionLiteralExpAccess().getGroup(), "rule__CollectionLiteralExp__Group__0");
			builder.put(grammarAccess.getCollectionLiteralExpAccess().getGroup_1(), "rule__CollectionLiteralExp__Group_1__0");
			builder.put(grammarAccess.getCollectionLiteralExpAccess().getGroup_1_2(), "rule__CollectionLiteralExp__Group_1_2__0");
			builder.put(grammarAccess.getCollectionLiteralExpAccess().getGroup_1_2_1(), "rule__CollectionLiteralExp__Group_1_2_1__0");
			builder.put(grammarAccess.getCollectionLiteralPartAccess().getGroup(), "rule__CollectionLiteralPart__Group__0");
			builder.put(grammarAccess.getCollectionLiteralPartAccess().getGroup_1(), "rule__CollectionLiteralPart__Group_1__0");
			builder.put(grammarAccess.getTupleLiteralExpAccess().getGroup(), "rule__TupleLiteralExp__Group__0");
			builder.put(grammarAccess.getTupleLiteralExpAccess().getGroup_2(), "rule__TupleLiteralExp__Group_2__0");
			builder.put(grammarAccess.getTupleLiteralExpAccess().getGroup_2_2(), "rule__TupleLiteralExp__Group_2_2__0");
			builder.put(grammarAccess.getTupleLiteralPartAccess().getGroup(), "rule__TupleLiteralPart__Group__0");
			builder.put(grammarAccess.getTupleLiteralPartAccess().getGroup_1(), "rule__TupleLiteralPart__Group_1__0");
			builder.put(grammarAccess.getBooleanLiteralExpAccess().getGroup(), "rule__BooleanLiteralExp__Group__0");
			builder.put(grammarAccess.getInvalidLiteralExpAccess().getGroup(), "rule__InvalidLiteralExp__Group__0");
			builder.put(grammarAccess.getNullLiteralExpAccess().getGroup(), "rule__NullLiteralExp__Group__0");
			builder.put(grammarAccess.getImpliesAccess().getGroup(), "rule__Implies__Group__0");
			builder.put(grammarAccess.getImpliesAccess().getGroup_1(), "rule__Implies__Group_1__0");
			builder.put(grammarAccess.getXorAccess().getGroup(), "rule__Xor__Group__0");
			builder.put(grammarAccess.getXorAccess().getGroup_1(), "rule__Xor__Group_1__0");
			builder.put(grammarAccess.getOrAccess().getGroup(), "rule__Or__Group__0");
			builder.put(grammarAccess.getOrAccess().getGroup_1(), "rule__Or__Group_1__0");
			builder.put(grammarAccess.getAndAccess().getGroup(), "rule__And__Group__0");
			builder.put(grammarAccess.getAndAccess().getGroup_1(), "rule__And__Group_1__0");
			builder.put(grammarAccess.getEqualityAccess().getGroup(), "rule__Equality__Group__0");
			builder.put(grammarAccess.getEqualityAccess().getGroup_1(), "rule__Equality__Group_1__0");
			builder.put(grammarAccess.getRelationalAccess().getGroup(), "rule__Relational__Group__0");
			builder.put(grammarAccess.getRelationalAccess().getGroup_1(), "rule__Relational__Group_1__0");
			builder.put(grammarAccess.getAdditiveAccess().getGroup(), "rule__Additive__Group__0");
			builder.put(grammarAccess.getAdditiveAccess().getGroup_1(), "rule__Additive__Group_1__0");
			builder.put(grammarAccess.getMultiplicativeAccess().getGroup(), "rule__Multiplicative__Group__0");
			builder.put(grammarAccess.getMultiplicativeAccess().getGroup_1(), "rule__Multiplicative__Group_1__0");
			builder.put(grammarAccess.getUnaryAccess().getGroup_1(), "rule__Unary__Group_1__0");
			builder.put(grammarAccess.getSubNavigationExpAccess().getGroup_9(), "rule__SubNavigationExp__Group_9__0");
			builder.put(grammarAccess.getIteratorVariableAccess().getGroup(), "rule__IteratorVariable__Group__0");
			builder.put(grammarAccess.getIteratorVariableAccess().getGroup_1(), "rule__IteratorVariable__Group_1__0");
			builder.put(grammarAccess.getIteratorAccumulatorAccess().getGroup(), "rule__IteratorAccumulator__Group__0");
			builder.put(grammarAccess.getRoundBracketExpAccess().getGroup(), "rule__RoundBracketExp__Group__0");
			builder.put(grammarAccess.getRoundBracketExpAccess().getGroup_1(), "rule__RoundBracketExp__Group_1__0");
			builder.put(grammarAccess.getRoundBracketExpAccess().getGroup_3(), "rule__RoundBracketExp__Group_3__0");
			builder.put(grammarAccess.getRoundBracketExpAccess().getGroup_3_1_0(), "rule__RoundBracketExp__Group_3_1_0__0");
			builder.put(grammarAccess.getRoundBracketExpAccess().getGroup_3_1_1(), "rule__RoundBracketExp__Group_3_1_1__0");
			builder.put(grammarAccess.getRoundBracketExpAccess().getGroup_4(), "rule__RoundBracketExp__Group_4__0");
			builder.put(grammarAccess.getRoundBracketExpAccess().getGroup_4_1(), "rule__RoundBracketExp__Group_4_1__0");
			builder.put(grammarAccess.getSquareBracketExpAccess().getGroup(), "rule__SquareBracketExp__Group__0");
			builder.put(grammarAccess.getSquareBracketExpAccess().getGroup_3(), "rule__SquareBracketExp__Group_3__0");
			builder.put(grammarAccess.getSquareBracketExpAccess().getGroup_5(), "rule__SquareBracketExp__Group_5__0");
			builder.put(grammarAccess.getPreExpAccess().getGroup(), "rule__PreExp__Group__0");
			builder.put(grammarAccess.getSelfExpAccess().getGroup(), "rule__SelfExp__Group__0");
			builder.put(grammarAccess.getPathNameExpAccess().getGroup(), "rule__PathNameExp__Group__0");
			builder.put(grammarAccess.getIfExpAccess().getGroup(), "rule__IfExp__Group__0");
			builder.put(grammarAccess.getLetExpAccess().getGroup(), "rule__LetExp__Group__0");
			builder.put(grammarAccess.getLetExpAccess().getGroup_2(), "rule__LetExp__Group_2__0");
			builder.put(grammarAccess.getLetVariableAccess().getGroup(), "rule__LetVariable__Group__0");
			builder.put(grammarAccess.getDocumentAccess().getPackagesAssignment_0(), "rule__Document__PackagesAssignment_0");
			builder.put(grammarAccess.getDocumentAccess().getContextsAssignment_1(), "rule__Document__ContextsAssignment_1");
			builder.put(grammarAccess.getBodyAccess().getConstraintNameAssignment_1(), "rule__Body__ConstraintNameAssignment_1");
			builder.put(grammarAccess.getBodyAccess().getExpressionAssignment_3(), "rule__Body__ExpressionAssignment_3");
			builder.put(grammarAccess.getClassifierContextDeclAccess().getSelfNameAssignment_1_0(), "rule__ClassifierContextDecl__SelfNameAssignment_1_0");
			builder.put(grammarAccess.getClassifierContextDeclAccess().getClassifierAssignment_2(), "rule__ClassifierContextDecl__ClassifierAssignment_2");
			builder.put(grammarAccess.getClassifierContextDeclAccess().getInvariantsAssignment_3_0(), "rule__ClassifierContextDecl__InvariantsAssignment_3_0");
			builder.put(grammarAccess.getClassifierContextDeclAccess().getDefinitionsAssignment_3_1(), "rule__ClassifierContextDecl__DefinitionsAssignment_3_1");
			builder.put(grammarAccess.getDefinitionAccess().getStaticAssignment_0(), "rule__Definition__StaticAssignment_0");
			builder.put(grammarAccess.getDefinitionAccess().getConstraintNameAssignment_2(), "rule__Definition__ConstraintNameAssignment_2");
			builder.put(grammarAccess.getDefinitionAccess().getConstrainedNameAssignment_4(), "rule__Definition__ConstrainedNameAssignment_4");
			builder.put(grammarAccess.getDefinitionAccess().getParametersAssignment_5_1_0(), "rule__Definition__ParametersAssignment_5_1_0");
			builder.put(grammarAccess.getDefinitionAccess().getParametersAssignment_5_1_1_1(), "rule__Definition__ParametersAssignment_5_1_1_1");
			builder.put(grammarAccess.getDefinitionAccess().getTypeAssignment_7(), "rule__Definition__TypeAssignment_7");
			builder.put(grammarAccess.getDefinitionAccess().getExpressionAssignment_9(), "rule__Definition__ExpressionAssignment_9");
			builder.put(grammarAccess.getDerAccess().getExpressionAssignment_2(), "rule__Der__ExpressionAssignment_2");
			builder.put(grammarAccess.getInitAccess().getExpressionAssignment_2(), "rule__Init__ExpressionAssignment_2");
			builder.put(grammarAccess.getInvariantAccess().getConstraintNameAssignment_1(), "rule__Invariant__ConstraintNameAssignment_1");
			builder.put(grammarAccess.getInvariantAccess().getExpressionAssignment_3(), "rule__Invariant__ExpressionAssignment_3");
			builder.put(grammarAccess.getOperationContextDeclAccess().getOperationAssignment_1(), "rule__OperationContextDecl__OperationAssignment_1");
			builder.put(grammarAccess.getOperationContextDeclAccess().getParametersAssignment_3_0(), "rule__OperationContextDecl__ParametersAssignment_3_0");
			builder.put(grammarAccess.getOperationContextDeclAccess().getParametersAssignment_3_1_1(), "rule__OperationContextDecl__ParametersAssignment_3_1_1");
			builder.put(grammarAccess.getOperationContextDeclAccess().getTypeAssignment_6(), "rule__OperationContextDecl__TypeAssignment_6");
			builder.put(grammarAccess.getOperationContextDeclAccess().getPresAssignment_7_0(), "rule__OperationContextDecl__PresAssignment_7_0");
			builder.put(grammarAccess.getOperationContextDeclAccess().getPostsAssignment_7_1(), "rule__OperationContextDecl__PostsAssignment_7_1");
			builder.put(grammarAccess.getOperationContextDeclAccess().getBodiesAssignment_7_2(), "rule__OperationContextDecl__BodiesAssignment_7_2");
			builder.put(grammarAccess.getPackageDeclarationAccess().getPackageAssignment_1(), "rule__PackageDeclaration__PackageAssignment_1");
			builder.put(grammarAccess.getPackageDeclarationAccess().getContextsAssignment_2(), "rule__PackageDeclaration__ContextsAssignment_2");
			builder.put(grammarAccess.getParameterAccess().getNameAssignment_0_0(), "rule__Parameter__NameAssignment_0_0");
			builder.put(grammarAccess.getParameterAccess().getTypeAssignment_1(), "rule__Parameter__TypeAssignment_1");
			builder.put(grammarAccess.getPostAccess().getConstraintNameAssignment_1(), "rule__Post__ConstraintNameAssignment_1");
			builder.put(grammarAccess.getPostAccess().getExpressionAssignment_3(), "rule__Post__ExpressionAssignment_3");
			builder.put(grammarAccess.getPreAccess().getConstraintNameAssignment_1(), "rule__Pre__ConstraintNameAssignment_1");
			builder.put(grammarAccess.getPreAccess().getExpressionAssignment_3(), "rule__Pre__ExpressionAssignment_3");
			builder.put(grammarAccess.getPropertyContextDeclAccess().getPropertyAssignment_1(), "rule__PropertyContextDecl__PropertyAssignment_1");
			builder.put(grammarAccess.getPropertyContextDeclAccess().getTypeAssignment_3(), "rule__PropertyContextDecl__TypeAssignment_3");
			builder.put(grammarAccess.getPropertyContextDeclAccess().getInitAssignment_4_0_0(), "rule__PropertyContextDecl__InitAssignment_4_0_0");
			builder.put(grammarAccess.getPropertyContextDeclAccess().getDerAssignment_4_0_1(), "rule__PropertyContextDecl__DerAssignment_4_0_1");
			builder.put(grammarAccess.getPropertyContextDeclAccess().getDerAssignment_4_1_0(), "rule__PropertyContextDecl__DerAssignment_4_1_0");
			builder.put(grammarAccess.getPropertyContextDeclAccess().getInitAssignment_4_1_1(), "rule__PropertyContextDecl__InitAssignment_4_1_1");
			builder.put(grammarAccess.getQualifiedClassifierRefAccess().getNamespaceAssignment_0(), "rule__QualifiedClassifierRef__NamespaceAssignment_0");
			builder.put(grammarAccess.getQualifiedClassifierRefAccess().getElementAssignment_2(), "rule__QualifiedClassifierRef__ElementAssignment_2");
			builder.put(grammarAccess.getQualifiedOperationRefAccess().getNamespaceAssignment_0(), "rule__QualifiedOperationRef__NamespaceAssignment_0");
			builder.put(grammarAccess.getQualifiedOperationRefAccess().getElementAssignment_2(), "rule__QualifiedOperationRef__ElementAssignment_2");
			builder.put(grammarAccess.getQualifiedPropertyRefAccess().getNamespaceAssignment_0(), "rule__QualifiedPropertyRef__NamespaceAssignment_0");
			builder.put(grammarAccess.getQualifiedPropertyRefAccess().getElementAssignment_2(), "rule__QualifiedPropertyRef__ElementAssignment_2");
			builder.put(grammarAccess.getQualifiedPackageRefAccess().getNamespaceAssignment_0(), "rule__QualifiedPackageRef__NamespaceAssignment_0");
			builder.put(grammarAccess.getQualifiedPackageRefAccess().getElementAssignment_2(), "rule__QualifiedPackageRef__ElementAssignment_2");
			builder.put(grammarAccess.getSimpleClassifierRefAccess().getClassifierAssignment(), "rule__SimpleClassifierRef__ClassifierAssignment");
			builder.put(grammarAccess.getSimpleOperationRefAccess().getOperationAssignment(), "rule__SimpleOperationRef__OperationAssignment");
			builder.put(grammarAccess.getSimplePackageRefAccess().getPackageAssignment(), "rule__SimplePackageRef__PackageAssignment");
			builder.put(grammarAccess.getSimplePropertyRefAccess().getFeatureAssignment(), "rule__SimplePropertyRef__FeatureAssignment");
			builder.put(grammarAccess.getNavigationExpAccess().getOpAssignment_1_0_1(), "rule__NavigationExp__OpAssignment_1_0_1");
			builder.put(grammarAccess.getNavigationExpAccess().getArgumentAssignment_1_0_2(), "rule__NavigationExp__ArgumentAssignment_1_0_2");
			builder.put(grammarAccess.getNavigationExpAccess().getOpAssignment_1_1_1(), "rule__NavigationExp__OpAssignment_1_1_1");
			builder.put(grammarAccess.getNavigationExpAccess().getMessageNameAssignment_1_1_2(), "rule__NavigationExp__MessageNameAssignment_1_1_2");
			builder.put(grammarAccess.getNavigationExpAccess().getArgumentsAssignment_1_1_4_0(), "rule__NavigationExp__ArgumentsAssignment_1_1_4_0");
			builder.put(grammarAccess.getNavigationExpAccess().getArgumentsAssignment_1_1_4_1_1(), "rule__NavigationExp__ArgumentsAssignment_1_1_4_1_1");
			builder.put(grammarAccess.getNavigatingExpAccess().getOpAssignment_1_0_1(), "rule__NavigatingExp__OpAssignment_1_0_1");
			builder.put(grammarAccess.getNavigatingExpAccess().getArgumentAssignment_1_0_2(), "rule__NavigatingExp__ArgumentAssignment_1_0_2");
			builder.put(grammarAccess.getNavigatingExpAccess().getOpAssignment_1_1_1(), "rule__NavigatingExp__OpAssignment_1_1_1");
			builder.put(grammarAccess.getNavigatingExpAccess().getMessageNameAssignment_1_1_2(), "rule__NavigatingExp__MessageNameAssignment_1_1_2");
			builder.put(grammarAccess.getNavigatingExpAccess().getArgumentsAssignment_1_1_4_0(), "rule__NavigatingExp__ArgumentsAssignment_1_1_4_0");
			builder.put(grammarAccess.getNavigatingExpAccess().getArgumentsAssignment_1_1_4_1_1(), "rule__NavigatingExp__ArgumentsAssignment_1_1_4_1_1");
			builder.put(grammarAccess.getOclMessageArgAccess().getTypeAssignment_0_2_1(), "rule__OclMessageArg__TypeAssignment_0_2_1");
			builder.put(grammarAccess.getPrimitiveTypeAccess().getNameAssignment(), "rule__PrimitiveType__NameAssignment");
			builder.put(grammarAccess.getCollectionTypeAccess().getTypeIdentifierAssignment_0(), "rule__CollectionType__TypeIdentifierAssignment_0");
			builder.put(grammarAccess.getCollectionTypeAccess().getTypeAssignment_1_1(), "rule__CollectionType__TypeAssignment_1_1");
			builder.put(grammarAccess.getTupleTypeAccess().getNameAssignment_0(), "rule__TupleType__NameAssignment_0");
			builder.put(grammarAccess.getTupleTypeAccess().getPartAssignment_2_0(), "rule__TupleType__PartAssignment_2_0");
			builder.put(grammarAccess.getTupleTypeAccess().getPartAssignment_2_1_1(), "rule__TupleType__PartAssignment_2_1_1");
			builder.put(grammarAccess.getTuplePartAccess().getNameAssignment_0(), "rule__TuplePart__NameAssignment_0");
			builder.put(grammarAccess.getTuplePartAccess().getTypeAssignment_2(), "rule__TuplePart__TypeAssignment_2");
			builder.put(grammarAccess.getCollectionLiteralExpAccess().getCollectionLiteralPartsAssignment_1_2_0(), "rule__CollectionLiteralExp__CollectionLiteralPartsAssignment_1_2_0");
			builder.put(grammarAccess.getCollectionLiteralExpAccess().getCollectionLiteralPartsAssignment_1_2_1_1(), "rule__CollectionLiteralExp__CollectionLiteralPartsAssignment_1_2_1_1");
			builder.put(grammarAccess.getCollectionLiteralPartAccess().getExpressionAssignment_0(), "rule__CollectionLiteralPart__ExpressionAssignment_0");
			builder.put(grammarAccess.getCollectionLiteralPartAccess().getLastExpressionAssignment_1_1(), "rule__CollectionLiteralPart__LastExpressionAssignment_1_1");
			builder.put(grammarAccess.getTupleLiteralExpAccess().getPartAssignment_2_1(), "rule__TupleLiteralExp__PartAssignment_2_1");
			builder.put(grammarAccess.getTupleLiteralExpAccess().getPartAssignment_2_2_1(), "rule__TupleLiteralExp__PartAssignment_2_2_1");
			builder.put(grammarAccess.getTupleLiteralPartAccess().getNameAssignment_0(), "rule__TupleLiteralPart__NameAssignment_0");
			builder.put(grammarAccess.getTupleLiteralPartAccess().getTypeAssignment_1_1(), "rule__TupleLiteralPart__TypeAssignment_1_1");
			builder.put(grammarAccess.getTupleLiteralPartAccess().getInitExpressionAssignment_3(), "rule__TupleLiteralPart__InitExpressionAssignment_3");
			builder.put(grammarAccess.getNumberLiteralExpAccess().getNameAssignment(), "rule__NumberLiteralExp__NameAssignment");
			builder.put(grammarAccess.getStringLiteralExpAccess().getValuesAssignment(), "rule__StringLiteralExp__ValuesAssignment");
			builder.put(grammarAccess.getBooleanLiteralExpAccess().getIsTrueAssignment_1_0(), "rule__BooleanLiteralExp__IsTrueAssignment_1_0");
			builder.put(grammarAccess.getImpliesAccess().getOpAssignment_1_1(), "rule__Implies__OpAssignment_1_1");
			builder.put(grammarAccess.getImpliesAccess().getArgumentAssignment_1_2(), "rule__Implies__ArgumentAssignment_1_2");
			builder.put(grammarAccess.getXorAccess().getOpAssignment_1_1(), "rule__Xor__OpAssignment_1_1");
			builder.put(grammarAccess.getXorAccess().getArgumentAssignment_1_2(), "rule__Xor__ArgumentAssignment_1_2");
			builder.put(grammarAccess.getOrAccess().getOpAssignment_1_1(), "rule__Or__OpAssignment_1_1");
			builder.put(grammarAccess.getOrAccess().getArgumentAssignment_1_2(), "rule__Or__ArgumentAssignment_1_2");
			builder.put(grammarAccess.getAndAccess().getOpAssignment_1_1(), "rule__And__OpAssignment_1_1");
			builder.put(grammarAccess.getAndAccess().getArgumentAssignment_1_2(), "rule__And__ArgumentAssignment_1_2");
			builder.put(grammarAccess.getEqualityAccess().getOpAssignment_1_1(), "rule__Equality__OpAssignment_1_1");
			builder.put(grammarAccess.getEqualityAccess().getArgumentAssignment_1_2(), "rule__Equality__ArgumentAssignment_1_2");
			builder.put(grammarAccess.getRelationalAccess().getOpAssignment_1_1(), "rule__Relational__OpAssignment_1_1");
			builder.put(grammarAccess.getRelationalAccess().getArgumentAssignment_1_2(), "rule__Relational__ArgumentAssignment_1_2");
			builder.put(grammarAccess.getAdditiveAccess().getOpAssignment_1_1(), "rule__Additive__OpAssignment_1_1");
			builder.put(grammarAccess.getAdditiveAccess().getArgumentAssignment_1_2(), "rule__Additive__ArgumentAssignment_1_2");
			builder.put(grammarAccess.getMultiplicativeAccess().getOpAssignment_1_1(), "rule__Multiplicative__OpAssignment_1_1");
			builder.put(grammarAccess.getMultiplicativeAccess().getArgumentAssignment_1_2(), "rule__Multiplicative__ArgumentAssignment_1_2");
			builder.put(grammarAccess.getUnaryAccess().getOpAssignment_1_1(), "rule__Unary__OpAssignment_1_1");
			builder.put(grammarAccess.getUnaryAccess().getSourceAssignment_1_2(), "rule__Unary__SourceAssignment_1_2");
			builder.put(grammarAccess.getSubNavigationExpAccess().getSourceAssignment_9_2(), "rule__SubNavigationExp__SourceAssignment_9_2");
			builder.put(grammarAccess.getIteratorVariableAccess().getNameAssignment_0(), "rule__IteratorVariable__NameAssignment_0");
			builder.put(grammarAccess.getIteratorVariableAccess().getTypeAssignment_1_1(), "rule__IteratorVariable__TypeAssignment_1_1");
			builder.put(grammarAccess.getIteratorAccumulatorAccess().getNameAssignment_0(), "rule__IteratorAccumulator__NameAssignment_0");
			builder.put(grammarAccess.getIteratorAccumulatorAccess().getTypeAssignment_2(), "rule__IteratorAccumulator__TypeAssignment_2");
			builder.put(grammarAccess.getIteratorAccumulatorAccess().getInitExpressionAssignment_4(), "rule__IteratorAccumulator__InitExpressionAssignment_4");
			builder.put(grammarAccess.getRoundBracketExpAccess().getNameAssignment_0(), "rule__RoundBracketExp__NameAssignment_0");
			builder.put(grammarAccess.getRoundBracketExpAccess().getPreAssignment_1_1(), "rule__RoundBracketExp__PreAssignment_1_1");
			builder.put(grammarAccess.getRoundBracketExpAccess().getVariable1Assignment_3_0(), "rule__RoundBracketExp__Variable1Assignment_3_0");
			builder.put(grammarAccess.getRoundBracketExpAccess().getVariable2Assignment_3_1_0_1(), "rule__RoundBracketExp__Variable2Assignment_3_1_0_1");
			builder.put(grammarAccess.getRoundBracketExpAccess().getVariable2Assignment_3_1_1_1(), "rule__RoundBracketExp__Variable2Assignment_3_1_1_1");
			builder.put(grammarAccess.getRoundBracketExpAccess().getArgumentsAssignment_4_0(), "rule__RoundBracketExp__ArgumentsAssignment_4_0");
			builder.put(grammarAccess.getRoundBracketExpAccess().getArgumentsAssignment_4_1_1(), "rule__RoundBracketExp__ArgumentsAssignment_4_1_1");
			builder.put(grammarAccess.getSquareBracketExpAccess().getNameAssignment_0(), "rule__SquareBracketExp__NameAssignment_0");
			builder.put(grammarAccess.getSquareBracketExpAccess().getArgumentsAssignment_2(), "rule__SquareBracketExp__ArgumentsAssignment_2");
			builder.put(grammarAccess.getSquareBracketExpAccess().getArgumentsAssignment_3_1(), "rule__SquareBracketExp__ArgumentsAssignment_3_1");
			builder.put(grammarAccess.getSquareBracketExpAccess().getPreAssignment_5_1(), "rule__SquareBracketExp__PreAssignment_5_1");
			builder.put(grammarAccess.getPreExpAccess().getNameAssignment_0(), "rule__PreExp__NameAssignment_0");
			builder.put(grammarAccess.getPathNameExpAccess().getNamespaceAssignment_0(), "rule__PathNameExp__NamespaceAssignment_0");
			builder.put(grammarAccess.getPathNameExpAccess().getElementAssignment_2(), "rule__PathNameExp__ElementAssignment_2");
			builder.put(grammarAccess.getSimpleNameExpAccess().getElementAssignment(), "rule__SimpleNameExp__ElementAssignment");
			builder.put(grammarAccess.getIfExpAccess().getConditionAssignment_1(), "rule__IfExp__ConditionAssignment_1");
			builder.put(grammarAccess.getIfExpAccess().getThenExpressionAssignment_3(), "rule__IfExp__ThenExpressionAssignment_3");
			builder.put(grammarAccess.getIfExpAccess().getElseExpressionAssignment_5(), "rule__IfExp__ElseExpressionAssignment_5");
			builder.put(grammarAccess.getLetExpAccess().getVariableAssignment_1(), "rule__LetExp__VariableAssignment_1");
			builder.put(grammarAccess.getLetExpAccess().getVariableAssignment_2_1(), "rule__LetExp__VariableAssignment_2_1");
			builder.put(grammarAccess.getLetExpAccess().getInAssignment_4(), "rule__LetExp__InAssignment_4");
			builder.put(grammarAccess.getLetVariableAccess().getNameAssignment_0(), "rule__LetVariable__NameAssignment_0");
			builder.put(grammarAccess.getLetVariableAccess().getTypeAssignment_2(), "rule__LetVariable__TypeAssignment_2");
			builder.put(grammarAccess.getLetVariableAccess().getInitExpressionAssignment_4(), "rule__LetVariable__InitExpressionAssignment_4");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private BacktrackingContentAssistTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalBacktrackingContentAssistTestLanguageParser createParser() {
		InternalBacktrackingContentAssistTestLanguageParser result = new InternalBacktrackingContentAssistTestLanguageParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public BacktrackingContentAssistTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(BacktrackingContentAssistTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
