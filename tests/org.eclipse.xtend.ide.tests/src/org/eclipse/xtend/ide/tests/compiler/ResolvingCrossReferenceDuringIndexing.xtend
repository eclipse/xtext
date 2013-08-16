/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.compiler

import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Path
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.junit.After
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

import static extension org.eclipse.ui.texteditor.MarkerUtilities.*

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class ResolvingCrossReferenceDuringIndexing extends AbstractXtendUITestCase {

	@After override void tearDown() {
		cleanWorkspace
	}

	@Test def void testResolvingJvmParameterizedTypeReference() {
		val annoProject = WorkbenchTestHelper.createPluginProject("annotation.project", "com.google.inject",
			"org.eclipse.xtend.lib", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.core");
		WorkbenchTestHelper.addExportedPackages(annoProject, "myannotation")

		createFile(new Path('/annotation.project/src/myannotation/MyAnnotation.xtend'),
			'''
				package myannotation
				
				import org.eclipse.xtend.core.macro.declaration.XtendClassDeclarationImpl
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
				import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
				import org.eclipse.xtext.common.types.impl.JvmParameterizedTypeReferenceImpl
				
				@Active(MyAnnotationProcessor)
				annotation MyAnnotation {
				}
				
				class MyAnnotationProcessor extends AbstractClassProcessor {
				
					override doRegisterGlobals(ClassDeclaration annotatedClass, extension RegisterGlobalsContext context) {
						val xtendClass = (annotatedClass as XtendClassDeclarationImpl).delegate
						if (!(xtendClass.extends as JvmParameterizedTypeReferenceImpl).basicGetType.eIsProxy) {
							throw new IllegalStateException("Before: Type should be a proxy.")
						}
						annotatedClass.extendedClass
						if (!(xtendClass.extends as JvmParameterizedTypeReferenceImpl).basicGetType.eIsProxy) {
							throw new IllegalStateException("After: Type should be a proxy.")
						}
					}
				
				}
			''')
		waitForAutoBuild
		assertNoErrorsInWorkspace

		WorkbenchTestHelper.createPluginProject("client.project", "com.google.inject", "org.eclipse.xtend.lib",
			"org.eclipse.xtext.xbase.lib", "annotation.project")

		createFile(new Path('/client.project/src/mypackage/MyClient.xtend'),
			'''
				package mypackage
				
				import myannotation.MyAnnotation
				import java.util.ArrayList
				
				@MyAnnotation
				class MyClient extends ArrayList<Object> {
				}
			''')
		waitForAutoBuild
		assertNoErrorsInWorkspace
	}

	@Test def void testResolvingXFunctionTypeRef() {
		"=>java.util.ArrayList<String>".testResolvingXFunctionTypeRef('''
			Assert.assertNotNull(type)
			Assert.assertEquals(1, type.actualTypeArguments.size)
			Assert.assertEquals("? extends java.util.ArrayList<java.lang.String>", type.actualTypeArguments.head.name)
		''')
	}

	@Test def void testResolvingXFunctionTypeRef_2() {
		"=>void".testResolvingXFunctionTypeRef('''
			Assert.assertNotNull(type)
			Assert.assertEquals(1, type.actualTypeArguments.size)
			Assert.assertEquals("? extends java.lang.Void", type.actualTypeArguments.head.name)
		''')
	}

	@Test def void testResolvingXFunctionTypeRef_3() {
		"(int)=>void".testResolvingXFunctionTypeRef('''
			Assert.assertNotNull(type)
			Assert.assertEquals(2, type.actualTypeArguments.size)
			Assert.assertEquals("? super java.lang.Integer", type.actualTypeArguments.head.name)
			Assert.assertEquals("? extends java.lang.Void", type.actualTypeArguments.tail.head.name)
		''')
	}

	@Test def void testResolvingXFunctionTypeRef_4() {
		"()=>Integer[]".testResolvingXFunctionTypeRef('''
			Assert.assertNotNull(type)
			Assert.assertEquals(1, type.actualTypeArguments.size)
			Assert.assertEquals("? extends java.lang.Integer[]", type.actualTypeArguments.head.name)
		''')
	}

	@Test def void testResolvingXFunctionTypeRef_5() {
		"=>=>java.util.Map<String, Boolean>".testResolvingXFunctionTypeRef('''
			Assert.assertNotNull(type)
			Assert.assertEquals(1, type.actualTypeArguments.size)
			Assert.assertEquals("? extends org.eclipse.xtext.xbase.lib.Functions$Function0<? extends java.util.Map<java.lang.String, java.lang.Boolean>>", type.actualTypeArguments.head.name)
		''')
	}

	def void testResolvingXFunctionTypeRef(String functionType, String expectations) {
		val annoProject = WorkbenchTestHelper.createPluginProject("annotation.project", "com.google.inject",
			"org.eclipse.xtend.lib", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.core", "org.junit");
		WorkbenchTestHelper.addExportedPackages(annoProject, "myannotation")

		createFile(new Path('/annotation.project/src/myannotation/MyAnnotation.xtend'),
			'''
				package myannotation

				import org.eclipse.emf.ecore.EObject
				import org.eclipse.xtend.core.macro.declaration.XtendFieldDeclarationImpl
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
				import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
				import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference
				import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
				import org.eclipse.xtext.common.types.JvmTypeReference
				import org.eclipse.xtext.xtype.XFunctionTypeRef
				import org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl
				import org.junit.Assert
				
				import static org.eclipse.xtext.common.types.TypesPackage.Literals.*
				import static org.eclipse.xtext.xtype.XtypePackage.Literals.*
				
				@Active(MyAnnotationProcessor)
				annotation MyAnnotation {
				}
				
				class MyAnnotationProcessor extends AbstractClassProcessor {
				
					override doRegisterGlobals(ClassDeclaration annotatedClass, extension RegisterGlobalsContext context) {
						val declaredField = annotatedClass.declaredFields.head
						val returnType = ((declaredField as XtendFieldDeclarationImpl).delegate.type as XFunctionTypeRefImpl).returnType
						returnType.assertProxies("Before")
						val type = declaredField.type
						«expectations»
						returnType.assertProxies("After")
					}
				
					def dispatch void assertProxies(JvmParameterizedTypeReference it, String message) {
						val type = eGet(JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, false) as EObject
						Assert.assertTrue(message + ": Type should be a proxy: " + it.class.name + ".", type == null || type.eIsProxy)
					}
				
					def dispatch void assertProxies(XFunctionTypeRef it, String message) {
						val type = eGet(XFUNCTION_TYPE_REF__TYPE, false) as EObject
						Assert.assertTrue(message + ": Type should be a proxy: " + it.class.name + ".", type == null || type.eIsProxy)
					}
				
					def dispatch void assertProxies(JvmGenericArrayTypeReference it, String message) {
						componentType.assertProxies(message)
					}
				
					def dispatch void assertProxies(JvmTypeReference it, String message) {
						throw new UnsupportedOperationException
					}
				
				}
			''')
		waitForAutoBuild
		assertNoErrorsInWorkspace

		WorkbenchTestHelper.createPluginProject("client.project", "com.google.inject", "org.eclipse.xtend.lib",
			"org.eclipse.xtext.xbase.lib", "annotation.project")

		createFile(new Path('/client.project/src/mypackage/MyClient.xtend'),
			'''
				package mypackage
				
				import myannotation.MyAnnotation
				
				@MyAnnotation
				class MyClient {
				
					var «functionType» function
				
				}
			''')
		waitForAutoBuild
		assertNoErrorsInWorkspace
	}

	def void assertNoErrorsInWorkspace() {
		val findMarkers = ResourcesPlugin.workspace.root.findMarkers(IMarker::PROBLEM, true, IResource::DEPTH_INFINITE)
		for (iMarker : findMarkers) {
			assertFalse(iMarker.message, iMarker.severity == IMarker::SEVERITY_ERROR)
		}
	}

}
