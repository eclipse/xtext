/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.importHandling

import com.google.common.base.Preconditions
import com.google.inject.Inject
import java.util.Collection
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess
import org.eclipse.xtext.ide.serializer.IChangeSerializer
import org.eclipse.xtext.ide.serializer.IEmfResourceChange
import org.eclipse.xtext.ide.serializer.debug.TextDocumentChangeToString
import org.eclipse.xtext.ide.serializer.impl.TextDocumentChange
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.xtext.testing.util.InMemoryURIHandler
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.util.CollectionBasedAcceptor
import org.junit.Assert

/**
 * TODO: de-duplicate with /xtext-core/org.eclipse.xtext.ide.tests/src/org/eclipse/xtext/ide/tests/serializer/ChangeSerializerTestHelper.xtend
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
class ImportTestHelper {
	@Inject IResourceDescription.Manager rdManager
	@Inject ValidationTestHelper validator

	def void ===(Collection<IEmfResourceChange> actual, CharSequence expected) {
		val actualString = new TextDocumentChangeToString().add(actual).toString
		Assert.assertEquals(expected.toString.trim, actualString.trim)
	}

	def void ===(ITextRegionAccess actual, CharSequence expected) {
		val actualString = new TextRegionAccessToString().withRegionAccess(actual).hideColumnExplanation().toString
		Assert.assertEquals(expected.toString.trim, actualString.trim)
	}

	def void +=(InMemoryURIHandler handler, Pair<String, String> file) {
		val f = handler.getInMemoryFile(URI.createURI(file.key))
		f.contents = file.value.bytes
		f.exists = true
	}

	def ResourceSet createResourceSet(InMemoryURIHandler fs) {
		val idx = new XtextResourceSet
		idx.getURIConverter.getURIHandlers.add(0, fs)
		for (f : fs.files.values) {
			idx.getResource(f.uri, true)
		}
		EcoreUtil.resolveAll(idx)
		idx.resources.filter(XtextResource).forEach[validator.assertNoErrors(it)]
		val rsd = idx.resources.map[rdManager.getResourceDescription(it)]
		val data = new ResourceDescriptionsData(rsd)

		val r = new XtextResourceSet
		r.getLoadOptions().put(ResourceDescriptionsProvider.LIVE_SCOPE, Boolean.TRUE);
		r.getURIConverter.getURIHandlers.add(0, fs)
		ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(r, data)
		return r;
	}

	def <T> T contents(ResourceSet rs, String fileName, Class<T> type) {
		val result = rs.getResource(URI.createURI(fileName), true).contents.filter(type).head
		Preconditions.checkNotNull(result)
		return result
	}

	def ITextRegionAccess endRecordChangesToTextRegions(IChangeSerializer ser) {
		return ser.endRecordChangesToTextDocuments.filter(TextDocumentChange).head.textRegionAccess
	}

	def Collection<IEmfResourceChange> endRecordChangesToTextDocuments(IChangeSerializer ser) {
		val list = newArrayList()
		ser.endRecordChanges(CollectionBasedAcceptor.of(list))
		return list
	}
}
