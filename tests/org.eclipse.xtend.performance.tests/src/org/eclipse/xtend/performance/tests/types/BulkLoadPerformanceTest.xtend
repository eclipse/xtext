/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.performance.tests.types

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.performance.tests.PerformanceTestProjectSetup
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProvider
import org.eclipse.xtext.junit4.internal.StopwatchRule
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedTypes
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import java.util.List
import java.util.Collection
import java.util.Set
import com.google.common.collect.Multimaps
import com.google.common.collect.Iterators
import com.google.common.collect.Lists
import java.util.Collections
import com.google.common.collect.Collections2
import javax.swing.JButton
import javax.swing.JTextField
import org.junit.Ignore
import javax.swing.JFrame
import javax.swing.JSpinner
import javax.swing.JSplitPane
import javax.swing.JPanel
import javax.swing.JCheckBox
import org.eclipse.emf.ecore.util.EcoreUtil

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class BulkLoadPerformanceTest extends AbstractXtendUITestCase {

	@Rule public static val rule = new StopwatchRule(true)

	@Inject protected extension ReflectExtensions

	@BeforeClass
	def static void createTestProject() {
		PerformanceTestProjectSetup::setUp(false)
		waitForAutoBuild();
	}

	@AfterClass
	def static void deleteTestProject() {
		PerformanceTestProjectSetup::tearDown
	}
	
	def protected getTypesToLoad() {
		val List<Class<?>> result = newArrayList
		result += new ImplicitlyImportedTypes().invoke('getExtensionClasses') as List<Class<?>>
		return result
	}
	
	def protected getMoreTypesToLoad() {
		val List<Class<?>> result = newArrayList
		result += new ImplicitlyImportedTypes().invoke('getExtensionClasses') as List<Class<?>>
		result += #[
			typeof(List),
			typeof(Collection),
			typeof(Set),
			typeof(StringBuilder),
			typeof(StringBuffer),
			typeof(CharSequence),
			typeof(String),
			typeof(Class),
			typeof(Multimaps),
			typeof(Iterators),
			typeof(Lists),
			typeof(Collections),
			typeof(Collections2),
			typeof(JButton),
			typeof(JTextField),
			typeof(JFrame),
			typeof(JSpinner),
			typeof(JSplitPane),
			typeof(JPanel),
			typeof(JCheckBox)
		]
		return result
	}

	@Test
	def void testSequentialLoad() throws Exception {
		val resourceSet = new ResourceSetImpl();
		val extension typeProvider = new OldJdtTypeProvider(PerformanceTestProjectSetup::testProject, resourceSet);
		typesToLoad.map[name].forEach [
			assertNotNull(findTypeByName)
		]
	}

	@Ignore("Implementation is obsolete but kept here as a reference")
	@Test
	def void testSequentialLoad300Times() throws Exception {
		for (i : 1 .. 300) {
			testSequentialLoad
		}
	}

	@Ignore("Implementation is obsolete but kept here as a reference")
	@Test
	def void testSequentialLoad300TimesAgain() throws Exception {
		testSequentialLoad300Times
	}

	@Test
	def void testBulkLoad() throws Exception {
		val resourceSet = new ResourceSetImpl();
		val typeProvider = new OldJdtTypeProvider(PerformanceTestProjectSetup::testProject, resourceSet);
		typeProvider.findTypesByName(typesToLoad.map[name])
	}

	@Ignore("Implementation is obsolete but kept here as a reference")
	@Test
	def void testBulkLoad300Times() throws Exception {
		for (i : 1 .. 300) {
			testBulkLoad
		}
	}
	
	@Ignore("Implementation is obsolete but kept here as a reference")
	@Test
	def void testBulkLoad300TimesAgain() throws Exception {
		testBulkLoad300Times
	}
	
	@Test
	def void testSequentialLoadNewImpl() throws Exception {
		val resourceSet = new ResourceSetImpl();
		val extension typeProvider = new JdtTypeProvider(PerformanceTestProjectSetup::testProject, resourceSet);
		typesToLoad.map[name].forEach [
			assertNotNull(findTypeByName)
		]
	}

	@Test
	def void testSequentialLoadNewImpl300Times() throws Exception {
		for (i : 1 .. 300) {
			testSequentialLoadNewImpl
		}
	}

	@Test
	def void testSequentialLoadNewImpl300TimesAgain() throws Exception {
		testSequentialLoadNewImpl300Times
	}

	@Test
	def void testBulkLoadNewImpl() throws Exception {
		val resourceSet = new ResourceSetImpl();
		val typeProvider = new JdtTypeProvider(PerformanceTestProjectSetup::testProject, resourceSet);
		typeProvider.findTypesByName(typesToLoad.map[name])
	}

	@Test
	def void testBulkLoadNewImpl300Times() throws Exception {
		for (i : 1 .. 300) {
			testBulkLoadNewImpl
		}
	}

	@Test
	def void testBulkLoadNewImpl300TimesAgain() throws Exception {
		testBulkLoadNewImpl300Times
	}

	@Ignore("Implementation is obsolete but kept here as a reference")
	@Test
	def void testSequentialLoad300TimesOnceMore() throws Exception {
		testSequentialLoad300Times
	}

	@Ignore("Implementation is obsolete but kept here as a reference")
	@Test
	def void testBulkLoad300TimesOnceMore() throws Exception {
		testBulkLoad300Times
	}
	
	@Test
	def void testSequentialLoadNewImpl300TimesOnceMore() throws Exception {
		testSequentialLoadNewImpl300Times
	}

	@Test
	def void testBulkLoadNewImpl300TimesOnceMore() throws Exception {
		testBulkLoadNewImpl300Times
	}

	@Ignore("Implementation is obsolete but kept here as a reference")
	@Test
	def void testSequentialLoadAgain() throws Exception {
		testSequentialLoad
	}

	@Ignore("Implementation is obsolete but kept here as a reference")
	@Test
	def void testBulkLoadAgain() throws Exception {
		testBulkLoad
	}
	
	@Test
	def void testSequentialLoadNewImplAgain() throws Exception {
		testSequentialLoadNewImpl
	}

	@Test
	def void testBulkLoadNewImplAgain() throws Exception {
		testBulkLoadNewImpl
	}
	
	@Test
	def void testBulkLoadMoreTypesNewImpl() throws Exception {
		val resourceSet = new ResourceSetImpl();
		val typeProvider = new JdtTypeProvider(PerformanceTestProjectSetup::testProject, resourceSet);
		typeProvider.findTypesByName(moreTypesToLoad.map[name])
	}
	
	@Test
	def void testBulkLoadMoreTypesNewImplAgain() throws Exception {
		testBulkLoadMoreTypesNewImpl
	}
	
	@Test
	def void testSequentialLoadMoreTypesNewImpl() throws Exception {
		val resourceSet = new ResourceSetImpl();
		val extension typeProvider = new JdtTypeProvider(PerformanceTestProjectSetup::testProject, resourceSet);
		moreTypesToLoad.map[name].forEach [
			assertNotNull(findTypeByName)
		]
	}
	
	@Test
	def void testBulkLoadMoreTypesNewImplAgain2() throws Exception {
		testBulkLoadMoreTypesNewImpl
	}
	
	@Test
	def void testBulkLoadMoreTypesNewImplWithResolve() throws Exception {
		val resourceSet = new ResourceSetImpl();
		val typeProvider = new JdtTypeProvider(PerformanceTestProjectSetup::testProject, resourceSet);
		typeProvider.findTypesByName(moreTypesToLoad.map[name])
		EcoreUtil::resolveAll(resourceSet)
	}
	
	@Test
	def void testSequentialLoadMoreTypesNewImplResolve() throws Exception {
		val resourceSet = new ResourceSetImpl();
		val extension typeProvider = new JdtTypeProvider(PerformanceTestProjectSetup::testProject, resourceSet);
		moreTypesToLoad.map[name].forEach [
			assertNotNull(findTypeByName)
		]
		EcoreUtil::resolveAll(resourceSet)
	}
	
	@Test
	def void testSequentialLoadMoreTypes() throws Exception {
		val resourceSet = new ResourceSetImpl();
		val extension typeProvider = new OldJdtTypeProvider(PerformanceTestProjectSetup::testProject, resourceSet);
		moreTypesToLoad.map[name].forEach [
			assertNotNull(findTypeByName)
		]
	}
	
	@Test
	def void testBulkLoadMoreTypes() throws Exception {
		val resourceSet = new ResourceSetImpl();
		val typeProvider = new OldJdtTypeProvider(PerformanceTestProjectSetup::testProject, resourceSet);
		typeProvider.findTypesByName(moreTypesToLoad.map[name])
	}
	
	@Test
	def void testBulkLoadMoreTypesWithResolve() throws Exception {
		val resourceSet = new ResourceSetImpl();
		val typeProvider = new OldJdtTypeProvider(PerformanceTestProjectSetup::testProject, resourceSet);
		typeProvider.findTypesByName(moreTypesToLoad.map[name])
		EcoreUtil::resolveAll(resourceSet)
	}
	
	@Test
	def void testSequentialLoadMoreTypesResolve() throws Exception {
		val resourceSet = new ResourceSetImpl();
		val extension typeProvider = new OldJdtTypeProvider(PerformanceTestProjectSetup::testProject, resourceSet);
		moreTypesToLoad.map[name].forEach [
			assertNotNull(findTypeByName)
		]
		EcoreUtil::resolveAll(resourceSet)
	}
	
	@Test
	def void testDummy() throws Exception {
		assertTrue(true)
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class BulkLoadPerformanceTestWithMoreTypes extends BulkLoadPerformanceTest {
	
	override protected getTypesToLoad()	{
		val List<Class<?>> result = newArrayList
		result += #[
			typeof(JButton),
			typeof(JTextField),
			typeof(JFrame),
			typeof(JSpinner),
			typeof(JSplitPane),
			typeof(JPanel),
			typeof(JCheckBox)
		]
		return result
	}

	override protected getMoreTypesToLoad() {
		val List<Class<?>> result = newArrayList
		result += #[
			typeof(com.google.common.annotations.Beta),
			typeof(com.google.common.annotations.GwtCompatible),
			typeof(com.google.common.annotations.GwtIncompatible),
			typeof(com.google.inject.Inject),
			typeof(java.io.Serializable),
			typeof(java.lang.Appendable),
			typeof(java.lang.Boolean),
			typeof(java.lang.Byte),
			typeof(java.lang.CharSequence),
			typeof(java.lang.Character),
			typeof(java.lang.Class),
			typeof(java.lang.Cloneable),
			typeof(java.lang.Comparable),
			typeof(java.lang.Double),
			typeof(java.lang.Exception),
			typeof(java.lang.Float),
			typeof(java.lang.IllegalStateException),
			typeof(java.lang.Integer),
			typeof(java.lang.Iterable),
			typeof(java.lang.Long),
			typeof(java.lang.Math),
			typeof(java.lang.Number),
			typeof(java.lang.Object), 
			typeof(java.lang.Override),
			typeof(java.lang.RuntimeException),
			typeof(java.lang.Short),
			typeof(java.lang.StackTraceElement),
			typeof(java.lang.String),
			typeof(java.lang.StringBuffer),
			typeof(java.lang.StringBuilder),
			typeof(java.lang.SuppressWarnings),
			typeof(java.lang.Throwable),
			typeof(java.lang.Void),
			typeof(java.lang.annotation.Documented),
			typeof(java.lang.annotation.ElementType),
			typeof(java.lang.annotation.Retention),
			typeof(java.lang.annotation.Target),
			typeof(java.lang.reflect.AnnotatedElement),
			typeof(java.lang.reflect.GenericDeclaration),
			typeof(java.lang.reflect.Type),
			typeof(java.math.BigDecimal),
			typeof(java.math.BigInteger),
			typeof(java.util.AbstractCollection),
			typeof(java.util.AbstractList),
			typeof(java.util.AbstractMap),
			typeof(java.util.ArrayList),
			typeof(java.util.Collection),
			typeof(java.util.Comparator),
			typeof(java.util.Iterator),
			typeof(java.util.List),
			typeof(java.util.Map),
			typeof(java.util.NavigableMap),
			typeof(java.util.RandomAccess),
			typeof(java.util.SortedMap),
			typeof(java.util.TreeMap),
			typeof(org.apache.log4j.Category),
			typeof(org.apache.log4j.Logger),
			typeof(org.eclipse.emf.common.notify.Notifier),
			typeof(org.eclipse.emf.common.notify.impl.BasicNotifierImpl),
			typeof(org.eclipse.emf.common.notify.impl.NotifierImpl),
			typeof(org.eclipse.emf.common.util.EList),
			typeof(org.eclipse.emf.common.util.TreeIterator),
			typeof(org.eclipse.emf.ecore.EAttribute),
			typeof(org.eclipse.emf.ecore.EObject),
			typeof(org.eclipse.emf.ecore.EReference),
			typeof(org.eclipse.emf.ecore.EStructuralFeature),
			typeof(org.eclipse.emf.ecore.resource.Resource),
			typeof(org.eclipse.emf.ecore.resource.impl.ResourceImpl),
			typeof(org.eclipse.emf.mwe.core.WorkflowComponent),
			typeof(org.eclipse.emf.mwe.core.WorkflowComponentWithID),
			typeof(org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent),
			typeof(org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2),
			typeof(org.eclipse.emf.mwe.utils.DirectoryCleaner),
			typeof(org.eclipse.emf.mwe.utils.StandaloneSetup),
			typeof(org.eclipse.emf.mwe2.runtime.IFactory),
			typeof(org.eclipse.emf.mwe2.runtime.workflow.AbstractCompositeWorkflowComponent),
			typeof(org.eclipse.emf.mwe2.runtime.workflow.IWorkflow),
			typeof(org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent),
			typeof(org.eclipse.emf.mwe2.runtime.workflow.Workflow),
			typeof(org.eclipse.jdt.annotation.NonNull),
			typeof(org.eclipse.jdt.annotation.Nullable),
			typeof(org.eclipse.xtend.lib.Data),
			typeof(org.eclipse.xtend.lib.Property),
			typeof(org.eclipse.xtext.AbstractElement),
			typeof(org.eclipse.xtext.AbstractRule),
			typeof(org.eclipse.xtext.CrossReference),
			typeof(org.eclipse.xtext.IGrammarAccess),
			typeof(org.eclipse.xtext.Keyword),
			typeof(org.eclipse.xtext.RuleCall),
			typeof(org.eclipse.xtext.common.types.JvmAnnotationTarget),
			typeof(org.eclipse.xtext.common.types.JvmComponentType),
			typeof(org.eclipse.xtext.common.types.JvmConstraintOwner),
			typeof(org.eclipse.xtext.common.types.JvmFormalParameter),
			typeof(org.eclipse.xtext.common.types.JvmGenericArrayTypeReference),
			typeof(org.eclipse.xtext.common.types.JvmIdentifiableElement),
			typeof(org.eclipse.xtext.common.types.JvmParameterizedTypeReference),
			typeof(org.eclipse.xtext.common.types.JvmSpecializedTypeReference),
			typeof(org.eclipse.xtext.common.types.JvmType),
			typeof(org.eclipse.xtext.common.types.JvmTypeConstraint),
			typeof(org.eclipse.xtext.common.types.JvmTypeParameter),
			typeof(org.eclipse.xtext.common.types.JvmTypeReference),
			typeof(org.eclipse.xtext.common.types.JvmWildcardTypeReference),
			typeof(org.eclipse.xtext.common.types.TypesPackage),
			typeof(org.eclipse.xtext.nodemodel.BidiIterable),
			typeof(org.eclipse.xtext.nodemodel.BidiTreeIterable),
			typeof(org.eclipse.xtext.nodemodel.ICompositeNode),
			typeof(org.eclipse.xtext.nodemodel.ILeafNode),
			typeof(org.eclipse.xtext.nodemodel.INode),
			typeof(org.eclipse.xtext.nodemodel.util.NodeModelUtils),
			typeof(org.eclipse.xtext.parser.IParseResult),
			typeof(org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator),
			typeof(org.eclipse.xtext.preferences.PreferenceKey),
			typeof(org.eclipse.xtext.resource.XtextResource),
			typeof(org.eclipse.xtext.resource.XtextResourceSet),
			typeof(org.eclipse.xtext.service.AbstractElementFinder),
			typeof(org.eclipse.xtext.xbase.XAbstractFeatureCall),
			typeof(org.eclipse.xtext.xbase.XAbstractWhileExpression),
			typeof(org.eclipse.xtext.xbase.XAssignment),
			typeof(org.eclipse.xtext.xbase.XBinaryOperation),
			typeof(org.eclipse.xtext.xbase.XBlockExpression),
			typeof(org.eclipse.xtext.xbase.XCasePart),
			typeof(org.eclipse.xtext.xbase.XCatchClause),
			typeof(org.eclipse.xtext.xbase.XClosure),
			typeof(org.eclipse.xtext.xbase.XCollectionLiteral),
			typeof(org.eclipse.xtext.xbase.XConstructorCall),
			typeof(org.eclipse.xtext.xbase.XDoWhileExpression),
			typeof(org.eclipse.xtext.xbase.XExpression),
			typeof(org.eclipse.xtext.xbase.XFeatureCall),
			typeof(org.eclipse.xtext.xbase.XForLoopExpression),
			typeof(org.eclipse.xtext.xbase.XIfExpression),
			typeof(org.eclipse.xtext.xbase.XMemberFeatureCall),
			typeof(org.eclipse.xtext.xbase.XReturnExpression),
			typeof(org.eclipse.xtext.xbase.XSwitchExpression),
			typeof(org.eclipse.xtext.xbase.XThrowExpression),
			typeof(org.eclipse.xtext.xbase.XTryCatchFinallyExpression),
			typeof(org.eclipse.xtext.xbase.XTypeLiteral),
			typeof(org.eclipse.xtext.xbase.XVariableDeclaration),
			typeof(org.eclipse.xtext.xbase.XWhileExpression),
			typeof(org.eclipse.xtext.xbase.XbasePackage),
			typeof(org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation),
			typeof(org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair),
			typeof(org.eclipse.xtext.xbase.formatting.AbstractFormatter),
			typeof(org.eclipse.xtext.xbase.formatting.FormattingPreferenceValues),
			typeof(org.eclipse.xtext.xbase.formatting.IBasicFormatter),
			typeof(org.eclipse.xtext.xbase.lib.ArrayExtensions),
			typeof(org.eclipse.xtext.xbase.lib.ArrayLiterals),
			typeof(org.eclipse.xtext.xbase.lib.BigDecimalExtensions),
			typeof(org.eclipse.xtext.xbase.lib.BigIntegerExtensions),
			typeof(org.eclipse.xtext.xbase.lib.BooleanExtensions),
			typeof(org.eclipse.xtext.xbase.lib.ByteExtensions),
			typeof(org.eclipse.xtext.xbase.lib.CharacterExtensions),
			typeof(org.eclipse.xtext.xbase.lib.CollectionExtensions),
			typeof(org.eclipse.xtext.xbase.lib.CollectionLiterals),
			typeof(org.eclipse.xtext.xbase.lib.ComparableExtensions),
			typeof(org.eclipse.xtext.xbase.lib.DoubleExtensions),
			typeof(org.eclipse.xtext.xbase.lib.Extension),
			typeof(org.eclipse.xtext.xbase.lib.FloatExtensions),
			typeof(org.eclipse.xtext.xbase.lib.FunctionExtensions),
			typeof(org.eclipse.xtext.xbase.lib.Functions),
			typeof(org.eclipse.xtext.xbase.lib.Inline),
			typeof(org.eclipse.xtext.xbase.lib.InputOutput),
			typeof(org.eclipse.xtext.xbase.lib.IntegerExtensions),
			typeof(org.eclipse.xtext.xbase.lib.IntegerRange),
			typeof(org.eclipse.xtext.xbase.lib.IterableExtensions),
			typeof(org.eclipse.xtext.xbase.lib.IteratorExtensions),
			typeof(org.eclipse.xtext.xbase.lib.ListExtensions),
			typeof(org.eclipse.xtext.xbase.lib.LongExtensions),
			typeof(org.eclipse.xtext.xbase.lib.MapExtensions),
			typeof(org.eclipse.xtext.xbase.lib.ObjectExtensions),
			typeof(org.eclipse.xtext.xbase.lib.Pair),
			typeof(org.eclipse.xtext.xbase.lib.ProcedureExtensions),
			typeof(org.eclipse.xtext.xbase.lib.Procedures),
			typeof(org.eclipse.xtext.xbase.lib.Pure),
			typeof(org.eclipse.xtext.xbase.lib.ShortExtensions),
			typeof(org.eclipse.xtext.xbase.lib.StringExtensions),
			typeof(org.eclipse.xtext.xbase.lib.util.ToStringHelper),
			typeof(org.eclipse.xtext.xbase.services.XbaseGrammarAccess),
			typeof(org.eclipse.xtext.xtype.XFunctionTypeRef)
		]
		return result
	}	
}

