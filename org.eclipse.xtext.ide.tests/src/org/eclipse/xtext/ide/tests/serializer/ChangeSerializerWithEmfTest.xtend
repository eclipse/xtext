/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.serializer

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.EClassRef
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Model
import org.eclipse.xtext.ide.tests.testlanguage.tests.PartialSerializationTestLanguageInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.InMemoryURIHandler
import org.eclipse.xtext.testlanguages.ecore.EcoreSupport
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.emf.ecore.EPackage

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(PartialSerializationTestLanguageInjectorProviderWithEmf)
class ChangeSerializerWithEmfTest {

	@Inject Provider<ChangeSerializer> serializerProvider
	@Inject extension ChangeSerializerTestHelper

	@Test
	def void testChangeRefToXML() {
		val fs = new InMemoryURIHandler()
		fs += "inmemory:/file1.pstl" -> '''#21 MyPackage.MyClass1'''
		fs += "inmemory:/file2.ecore" -> '''
			<?xml version="1.0" encoding="UTF-8"?>
			<ecore:EPackage xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			    xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore" name="MyPackage">
			  <eClassifiers xsi:type="ecore:EClass" name="MyClass1" eSuperTypes="#//MyClass2"/>
			  <eClassifiers xsi:type="ecore:EClass" name="MyClass2"/>
			</ecore:EPackage>
		'''

		val rs = fs.createResourceSet
		val model = rs.contents("inmemory:/file1.pstl", EClassRef)

		val serializer = serializerProvider.get()
		serializer.addModification(model) [
			model.ref = model.ref.EPackage.EClassifiers.get(1) as EClass
		]
		serializer.endRecordChangesToTextDocuments === '''
			----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------
			#21 <4:18|MyPackage.MyClass2>
			--------------------------------------------------------------------------------
			4 18 "MyPackage.MyClass1" -> "MyPackage.MyClass2"
		'''
	}
	
	@Test
	def void testChangeInXML() {
		val fs = new InMemoryURIHandler()
		fs += "inmemory:/file1.pstl" -> '''#21 MyPackage.MyClass1'''
		fs += "inmemory:/file2.ecore" -> '''
			<?xml version="1.0" encoding="UTF-8"?>
			<ecore:EPackage xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			    xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore" name="MyPackage">
			  <eClassifiers xsi:type="ecore:EClass" name="MyClass1"/>
			</ecore:EPackage>
		'''

		val rs = fs.createResourceSet
		val model = rs.contents("inmemory:/file2.ecore", EPackage)

		val serializer = serializerProvider.get()
		serializer.addModification(model) [
			(model.EClassifiers.head as EClass).name = "NewClass"
		]
		serializer.endRecordChangesToTextDocuments === '''
			---------------------------- inmemory:/file2.ecore -----------------------------
			<?xml version="1.0" encoding="UTF-8"?>
			<ecore:EPackage xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			    xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore" name="MyPackage">
			  <eClassifiers xsi:type="ecore:EClass" name="NewClass"/>
			</ecore:EPackage>
			--------------------------------------------------------------------------------
			----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------
			#21 <4:18|MyPackage.NewClass>
			--------------------------------------------------------------------------------
			4 18 "MyPackage.MyClass1" -> "MyPackage.NewClass"
		'''
	}
	

	@Test
	def void testChangeInDSL() {
		val fs = new InMemoryURIHandler()
		fs += "inmemory:/file1.pstl" -> '''#20 DslEClass'''
		fs += "inmemory:/file2.ecore" -> '''
			<?xml version="1.0" encoding="UTF-8"?>
			<ecore:EPackage xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			    xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore" name="MyPackage">
			  <eClassifiers xsi:type="ecore:EClass" name="MyClass1" eSuperTypes="inmemory:/file1.pstl#//@clazz.0"/>
			</ecore:EPackage>
		'''

		val rs = fs.createResourceSet
		val model = rs.contents("inmemory:/file1.pstl", Model)

		val serializer = serializerProvider.get()
		serializer.addModification(model.eResource) [
			model.clazz.get(0).name = "ChangedName"
			model.clazz.add(0, EcoreFactory.eINSTANCE.createEClass => [name = "NewName"])
			Assert.assertEquals(1, model.eResource.resourceSet.resources.size)
		]
		serializer.endRecordChangesToTextDocuments === '''
			----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------
			#20<3:1| NewName ><4:9| ChangedName>
			--------------------------------------------------------------------------------
			3 1 " " -> " NewName "
			4 9 "DslEClass" -> " ChangedName"
			---------------------------- inmemory:/file2.ecore -----------------------------
			<?xml version="1.0" encoding="UTF-8"?>
			<ecore:EPackage xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			    xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore" name="MyPackage">
			  <eClassifiers xsi:type="ecore:EClass" name="MyClass1" eSuperTypes="file1.pstl#//@clazz.1"/>
			</ecore:EPackage>
			--------------------------------------------------------------------------------
		'''
	}

}

class PartialSerializationTestLanguageInjectorProviderWithEmf extends PartialSerializationTestLanguageInjectorProvider {

	override protected internalCreateInjector() {
		val result = super.internalCreateInjector()
		new EcoreSupport().createInjectorAndDoEMFRegistration()
		return result
	}

}
