/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.ide

import com.google.inject.Inject
import java.util.Collection
import javax.inject.Provider
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ide.editor.hierarchy.AbstractHierarchyBuilder
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.IResourceDescriptionsProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.ui.editor.findrefs.SimpleLocalResourceAccess
import org.eclipse.xtext.util.LazyStringInputStream

import static org.junit.Assert.*

import static extension org.eclipse.xtext.EcoreUtil2.*
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNodeReference

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
abstract class AbstractHierarchyBuilderTest {

	@Inject
	extension ValidationTestHelper

	@Inject
	extension EObjectAtOffsetHelper

	@Inject
	Provider<XtextResourceSet> resourceSetProvider

	@Inject
	IResourceDescriptionsProvider resourceDescriptionsProvider

	protected def testBuildHierarchy((HierarchyBuilderTestConfiguration)=>void configurator) {
		val extension configuration = new HierarchyBuilderTestConfiguration
		configurator.apply(configuration)

		val resourceSet = configuration.createResourceSet
		val hierarchyBuilder = hierarchyBuilderProvider.apply(resourceSet)

		val resourceURI = if(resourceURI === null) models.last.key else resourceURI
		val resource = resourceSet.getResource(URI.createURI(resourceURI), false) as XtextResource
		val rootURI = resource.resolveElementAt(index).platformResourceOrNormalizedURI
		val actualHierarchy = rootURI.toExpectation(hierarchyBuilder)
		assertEquals(expectedHierarchy, actualHierarchy)
	}

	protected def ResourceSet createResourceSet(extension HierarchyBuilderTestConfiguration configuration) {
		val resourceSet = resourceSetProvider.get
		for (model : models) {
			val resource = resourceSet.createResource(URI.createURI(model.key))
			resource.load(new LazyStringInputStream(model.value, 'UTF-8'), null)
			resource.assertNoIssues
		}
		return resourceSet
	}

	protected def <T extends AbstractHierarchyBuilder> T configureBuilderWith(
		T hierarchyBuilder,
		ResourceSet resourceSet
	) {
		hierarchyBuilder.resourceAccess = new SimpleLocalResourceAccess(resourceSet)
		hierarchyBuilder.indexData = resourceDescriptionsProvider.getResourceDescriptions(resourceSet)
		return hierarchyBuilder
	}

	protected def String toExpectation(URI rootURI, IHierarchyBuilder builder) '''
		«FOR root : builder.buildRoots(rootURI, null)»
			«root.toExpectation(builder)»
		«ENDFOR»
	'''

	protected def String toExpectation(IHierarchyNode node, IHierarchyBuilder builder) '''
		«node.element» {
			«node.internalToExpectation(builder)»
		}
	'''

	protected def String internalToExpectation(IHierarchyNode node, IHierarchyBuilder builder) '''
		«FOR location : node.references»
			«location.toExpectation»
		«ENDFOR»
		«IF node.mayHaveChildren»
			«FOR childNode : builder.buildChildren(node, null)»
				«childNode.toExpectation(builder)»
			«ENDFOR»
		«ENDIF»
	'''

	protected def String toExpectation(IHierarchyNodeReference location) {
		''''«location.text»' [«location.offset», «location.length»]'''
	}

	@Accessors
	protected static class HierarchyBuilderTestConfiguration {
		(ResourceSet)=>IHierarchyBuilder hierarchyBuilderProvider
		Collection<Pair<String, String>> models = newArrayList
		int index
		String resourceURI
		String expectedHierarchy
	}

}
