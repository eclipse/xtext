package org.eclipse.xtext.java.tests

import com.google.common.collect.Iterables
import com.google.common.collect.Lists
import com.google.inject.Inject
import com.google.inject.Provider
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.build.BuildRequest
import org.eclipse.xtext.build.IncrementalBuilder
import org.eclipse.xtext.build.IndexState
import org.eclipse.xtext.build.Source2GeneratedMapping
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.access.IJvmTypeProvider
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions
import org.eclipse.xtext.resource.impl.ProjectDescription
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.common.types.access.impl.AbstractTypeProviderTest
import org.eclipse.xtext.common.types.testSetups.Bug347739ThreeTypeParamsSuperSuper
import org.eclipse.xtext.common.types.testSetups.AbstractMethods
import org.eclipse.xtext.common.types.testSetups.ClassWithVarArgs

@RunWith(XtextRunner)
@InjectWith(JavaInjectorProvider)
class ReusedTypeProviderTest extends AbstractTypeProviderTest {
	
	@Inject IncrementalBuilder builder
	@Inject IResourceServiceProvider.Registry resourceServiceProviderRegistry
	@Inject IJvmTypeProvider.Factory typeProviderFactory
	@Inject Provider<XtextResourceSet> resourceSetProvider
	
	static IJvmTypeProvider typeProvider
	
	def static List<String> readResource(String name) throws Exception {
		val InputStream stream = ReusedTypeProviderTest.getResourceAsStream(name);
		val BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		try {
			var String line = null;
			val List<String> result = Lists.newArrayList();
			while( (line = reader.readLine()) != null) {
				result.add(line);
			}
			return result;
		} finally {
			reader.close();
		}
	}
	
	override setUp() throws Exception {
		super.setUp()
		if (typeProvider == null) {
			val pathToSources = "/org/eclipse/xtext/common/types/testSetups";
			val files = readResource(pathToSources + "/files.list")
			val part = new ResourceDescriptionsData(emptySet)
			val resourceSet = resourceSetProvider.get => [
				val projectDesc = new ProjectDescription => [
					name = "my-test-project"
				]
				projectDesc.attachToEmfObject(it)
				val index = new ChunkedResourceDescriptions(emptyMap, it)
				index.setContainer(projectDesc.name, part)
				classpathURIContext = ReusedTypeProviderTest.getClassLoader
			]
			typeProviderFactory.createTypeProvider(resourceSet)
			val buildRequest = new BuildRequest => [
				for (file : files.filterNull) {
					val fullPath = pathToSources+"/"+file
					val url = ReusedTypeProviderTest.getResource(fullPath)
					dirtyFiles += URI.createURI(url.toExternalForm)
				}
				setResourceSet(resourceSet)
				it.state = new IndexState(part, new Source2GeneratedMapping)
			]
			builder.build(buildRequest, [resourceServiceProviderRegistry.getResourceServiceProvider(it)])
			typeProvider = typeProviderFactory.findTypeProvider(resourceSet)
		}
	}
	
	override protected getTypeProvider() {
		return typeProvider
	}
	
	override protected getCollectionParamName() {
		"arg0"
	}
	
	@Test
	override void testFindTypeByName_AbstractMultimap_02() {
		var String typeName="com.google.common.collect.AbstractMultimap" 
		var JvmGenericType type=getTypeProvider().findTypeByName(typeName) as JvmGenericType 
		var JvmOperation containsValue=Iterables.getOnlyElement(type.findAllFeaturesByName("containsValue")) as JvmOperation 
		assertNotNull(containsValue) var JvmFormalParameter firstParam=containsValue.getParameters().get(0) 
		assertEquals(1, firstParam.getAnnotations().size()) var JvmAnnotationReference annotationReference=firstParam.getAnnotations().get(0) 
		var JvmAnnotationType annotationType=annotationReference.getAnnotation() 
		assertTrue(annotationType.eIsProxy()) assertEquals("java:/Objects/javax.annotation.Nullable", EcoreUtil.getURI(annotationType).trimFragment().toString()) 
	}
	
	@Test
	override void testParameterNames_01() {
		doTestParameterName(Bug347739ThreeTypeParamsSuperSuper, "getToken(A)", "arg0");
	}
	@Test
	override void testParameterNames_02() {
		doTestParameterName(AbstractMethods, "abstractMethodWithParameter(java.lang.String)", "arg0");
	}
	@Test
	override void testParameterNames_03() {
		doTestParameterName(ClassWithVarArgs, "method(java.lang.String[])", "arg0");
	}
	
	@Ignore()
	@Test
	override void testFindTypeByName_NestedTypeQualifiedWithSubType_02() {
		super.testFindTypeByName_NestedTypeQualifiedWithSubType_02();
	}
	
}