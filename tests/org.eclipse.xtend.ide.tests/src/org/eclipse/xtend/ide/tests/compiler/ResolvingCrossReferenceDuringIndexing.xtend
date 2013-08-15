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
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

import static extension org.eclipse.ui.texteditor.MarkerUtilities.*

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class ResolvingCrossReferenceDuringIndexing extends AbstractXtendUITestCase {

	@Test def void testResolvingCrossReference() {
		val annoProject = WorkbenchTestHelper.createPluginProject("annotation.project", "com.google.inject",
			"org.eclipse.xtend.lib", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.core");
		WorkbenchTestHelper.addExportedPackages(annoProject, "myannotation")
		WorkbenchTestHelper.addExportedPackages(annoProject, "mypackage")

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

		createFile(new Path('/annotation.project/src/mypackage/SuperClass.java'),
			'''
				package mypackage;
				
				public class SuperClass {
				
				}
			''')
		waitForAutoBuild
		assertNoErrorsInWorkspace

		WorkbenchTestHelper.createPluginProject("client.project", "com.google.inject", "org.eclipse.xtend.lib",
			"org.eclipse.xtext.xbase.lib", "annotation.project");

		createFile(new Path('/client.project/src/mypackage/SuperClass.java'),
			'''
				package mypackage;
				
				public class SuperClass {
				
				}
			''')

		createFile(new Path('/client.project/src/mypackage/MyClient.xtend'),
			'''
				package mypackage
				
				import myannotation.MyAnnotation
				
				@MyAnnotation
				class MyClient extends SuperClass {
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
