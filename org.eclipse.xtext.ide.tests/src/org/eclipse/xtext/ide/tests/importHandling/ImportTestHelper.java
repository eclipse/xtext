/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.importHandling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.debug.TextDocumentChangeToString;
import org.eclipse.xtext.ide.serializer.impl.TextDocumentChange;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.testing.util.InMemoryURIHandler;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.CollectionBasedAcceptor;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * TODO: de-duplicate with
 * /xtext-core/org.eclipse.xtext.ide.tests/src/org/eclipse/xtext/ide/tests/serializer/ChangeSerializerTestHelper.xtend
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ImportTestHelper {
	@Inject
	private IResourceDescription.Manager rdManager;

	@Inject
	private ValidationTestHelper validator;

	public void operator_tripleEquals(Collection<IEmfResourceChange> actual, CharSequence expected) {
		String actualString = new TextDocumentChangeToString().add(actual).toString();
		Assert.assertEquals(Strings.toPlatformLineSeparator(expected).trim(),
				Strings.toPlatformLineSeparator(actualString).trim());
	}

	public void operator_tripleEquals(ITextRegionAccess actual, CharSequence expected) {
		String actualString = new TextRegionAccessToString().withRegionAccess(actual).hideColumnExplanation()
				.toString();
		Assert.assertEquals(expected.toString().trim(), actualString.trim());
	}

	public void operator_add(InMemoryURIHandler handler, Pair<String, String> file) {
		InMemoryURIHandler.InMemFile f = handler.getInMemoryFile(URI.createURI(file.getKey()));
		f.setContents(Strings.toUnixLineSeparator(file.getValue()).getBytes());
		f.setExists(true);
	}

	public ResourceSet createResourceSet(InMemoryURIHandler fs) {
		XtextResourceSet idx = new XtextResourceSet();
		idx.getURIConverter().getURIHandlers().add(0, fs);
		for (InMemoryURIHandler.InMemFile f : fs.getFiles().values()) {
			idx.getResource(f.getUri(), true);
		}
		EcoreUtil.resolveAll(idx);
		for (Resource r : idx.getResources()) {
			if (r instanceof XtextResource) {
				validator.assertNoErrors(r);
			}
		}
		List<IResourceDescription> rsd = new ArrayList<>();
		for (Resource r : idx.getResources()) {
			rsd.add(rdManager.getResourceDescription(r));
		}
		ResourceDescriptionsData data = new ResourceDescriptionsData(rsd);
		XtextResourceSet r = new XtextResourceSet();
		r.getLoadOptions().put(ResourceDescriptionsProvider.LIVE_SCOPE, Boolean.TRUE);
		r.getURIConverter().getURIHandlers().add(0, fs);
		ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(r, data);
		Map<String, ResourceDescriptionsData> dataMap = new HashMap<>();
		dataMap.put("egal", data);

		new ChunkedResourceDescriptions(Collections.unmodifiableMap(dataMap), r);
		return r;
	}

	public <T extends Object> T contents(ResourceSet rs, String fileName, Class<T> type) {
		T result = Iterables
				.getFirst(Iterables.filter(rs.getResource(URI.createURI(fileName), true).getContents(), type), null);
		Preconditions.checkNotNull(result);
		return result;
	}

	public ITextRegionAccess endRecordChangesToTextRegions(IChangeSerializer ser) {
		return Iterables
				.getFirst(Iterables.filter(endRecordChangesToTextDocuments(ser), TextDocumentChange.class), null)
				.getTextRegionAccess();
	}

	public Collection<IEmfResourceChange> endRecordChangesToTextDocuments(IChangeSerializer ser) {
		ArrayList<IEmfResourceChange> list = new ArrayList<>();
		ser.applyModifications(CollectionBasedAcceptor.of(list));
		return list;
	}
}
