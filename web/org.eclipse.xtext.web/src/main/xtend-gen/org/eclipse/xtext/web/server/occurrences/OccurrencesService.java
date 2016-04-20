/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.occurrences;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.web.server.occurrences.OccurrencesResult;
import org.eclipse.xtext.web.server.util.CancelIndicatorProgressMonitor;
import org.eclipse.xtext.web.server.util.ElementAtOffsetUtil;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * Service class for finding occurrences.
 */
@Singleton
@SuppressWarnings("all")
public class OccurrencesService {
  @Inject
  @Extension
  private ElementAtOffsetUtil _elementAtOffsetUtil;
  
  @Inject
  @Extension
  private ILocationInFileProvider _iLocationInFileProvider;
  
  @Inject
  private Provider<TargetURIs> targetURIsProvider;
  
  @Inject
  @Extension
  private IReferenceFinder _iReferenceFinder;
  
  /**
   * Find occurrences of the element at the given offset.
   */
  public OccurrencesResult findOccurrences(final XtextWebDocumentAccess document, final int offset) {
    final CancelableUnitOfWork<OccurrencesResult, IXtextWebDocument> _function = new CancelableUnitOfWork<OccurrencesResult, IXtextWebDocument>() {
      @Override
      public OccurrencesResult exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        XtextResource _resource = it.getResource();
        final EObject element = OccurrencesService.this._elementAtOffsetUtil.getElementAt(_resource, offset);
        String _stateId = it.getStateId();
        final OccurrencesResult occurrencesResult = new OccurrencesResult(_stateId);
        if (((element != null) && OccurrencesService.this.filter(element))) {
          final URI elementURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(element);
          final TargetURIs targetURIs = OccurrencesService.this.targetURIsProvider.get();
          targetURIs.addURI(elementURI);
          final IReferenceFinder.Acceptor acceptor = new IReferenceFinder.Acceptor() {
            @Override
            public void accept(final EObject source, final URI sourceURI, final EReference eReference, final int index, final EObject targetOrProxy, final URI targetURI) {
              final ITextRegion region = OccurrencesService.this._iLocationInFileProvider.getSignificantTextRegion(source, eReference, index);
              List<TextRegion> _readRegions = occurrencesResult.getReadRegions();
              int _offset = region.getOffset();
              int _length = region.getLength();
              TextRegion _textRegion = new TextRegion(_offset, _length);
              _readRegions.add(_textRegion);
            }
            
            @Override
            public void accept(final IReferenceDescription description) {
            }
          };
          XtextResource _resource_1 = it.getResource();
          CancelIndicatorProgressMonitor _cancelIndicatorProgressMonitor = new CancelIndicatorProgressMonitor(cancelIndicator);
          OccurrencesService.this._iReferenceFinder.findReferences(targetURIs, _resource_1, acceptor, _cancelIndicatorProgressMonitor);
          Resource _eResource = element.eResource();
          XtextResource _resource_2 = it.getResource();
          boolean _equals = Objects.equal(_eResource, _resource_2);
          if (_equals) {
            final ITextRegion definitionRegion = OccurrencesService.this._iLocationInFileProvider.getSignificantTextRegion(element);
            if (((definitionRegion != null) && (definitionRegion != ITextRegionWithLineInformation.EMPTY_REGION))) {
              List<TextRegion> _writeRegions = occurrencesResult.getWriteRegions();
              int _offset = definitionRegion.getOffset();
              int _length = definitionRegion.getLength();
              TextRegion _textRegion = new TextRegion(_offset, _length);
              _writeRegions.add(_textRegion);
            }
          }
        }
        return occurrencesResult;
      }
    };
    return document.<OccurrencesResult>readOnly(_function);
  }
  
  protected boolean filter(final EObject element) {
    EObject _eContainer = element.eContainer();
    return (_eContainer != null);
  }
}
