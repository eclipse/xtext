/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.occurrences;

import java.util.Objects;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.web.server.util.CancelIndicatorProgressMonitor;
import org.eclipse.xtext.web.server.util.ElementAtOffsetUtil;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Service class for finding occurrences.
 */
@Singleton
public class OccurrencesService {
	@Inject
	private ElementAtOffsetUtil elementAtOffsetUtil;

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Inject
	private Provider<TargetURIs> targetURIsProvider;

	@Inject
	private IReferenceFinder referenceFinder;

	/**
	 * Find occurrences of the element at the given offset.
	 */
	public OccurrencesResult findOccurrences(XtextWebDocumentAccess document, int offset) {
		return document.readOnly(new CancelableUnitOfWork<OccurrencesResult, IXtextWebDocument>() {
			@Override
			public OccurrencesResult exec(IXtextWebDocument doc, CancelIndicator cancelIndicator) throws Exception {
				EObject element = elementAtOffsetUtil.getElementAt(doc.getResource(), offset);
				OccurrencesResult occurrencesResult = new OccurrencesResult(doc.getStateId());
				if (element != null && filter(element)) {
					URI elementURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(element);
					TargetURIs targetURIs = targetURIsProvider.get();
					targetURIs.addURI(elementURI);
					IReferenceFinder.Acceptor acceptor = new IReferenceFinder.Acceptor() {
						@Override
						public void accept(EObject source, URI sourceURI, EReference eReference, int index,
								EObject targetOrProxy, URI targetURI) {
							ITextRegion region = locationInFileProvider.getSignificantTextRegion(source, eReference,
									index);
							occurrencesResult.getReadRegions()
									.add(new TextRegion(region.getOffset(), region.getLength()));
						}

						@Override
						public void accept(IReferenceDescription description) {
						}
					};
					referenceFinder.findReferences(targetURIs, doc.getResource(), acceptor,
							new CancelIndicatorProgressMonitor(cancelIndicator));
					if (Objects.equals(element.eResource(), doc.getResource())) {
						ITextRegion definitionRegion = locationInFileProvider.getSignificantTextRegion(element);
						if (definitionRegion != null
								&& definitionRegion != ITextRegionWithLineInformation.EMPTY_REGION) {
							occurrencesResult.getWriteRegions()
									.add(new TextRegion(definitionRegion.getOffset(), definitionRegion.getLength()));
						}
					}
				}
				return occurrencesResult;
			}
		});
	}

	protected boolean filter(EObject element) {
		return element.eContainer() != null;
	}
}
