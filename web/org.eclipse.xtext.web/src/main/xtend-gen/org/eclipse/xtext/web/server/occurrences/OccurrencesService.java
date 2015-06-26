package org.eclipse.xtext.web.server.occurrences;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.ArrayList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.web.server.occurrences.OccurrencesResult;
import org.eclipse.xtext.web.server.util.CancelIndicatorProgressMonitor;
import org.eclipse.xtext.web.server.util.ElementAtOffsetUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;

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
  
  public OccurrencesResult findOccurrences(final XtextWebDocumentAccess document, final int offset) {
    final CancelableUnitOfWork<OccurrencesResult, IXtextWebDocument> _function = new CancelableUnitOfWork<OccurrencesResult, IXtextWebDocument>() {
      @Override
      public OccurrencesResult exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        XtextResource _resource = it.getResource();
        final EObject element = OccurrencesService.this._elementAtOffsetUtil.getElementAt(_resource, offset);
        boolean _notEquals = (!Objects.equal(element, null));
        if (_notEquals) {
          final URI elementURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(element);
          final TargetURIs targetURIs = OccurrencesService.this.targetURIsProvider.get();
          targetURIs.addURI(elementURI);
          final ArrayList<ITextRegion> readRegions = CollectionLiterals.<ITextRegion>newArrayList();
          final IReferenceFinder.Acceptor acceptor = new IReferenceFinder.Acceptor() {
            @Override
            public void accept(final EObject source, final URI sourceURI, final EReference eReference, final int index, final EObject targetOrProxy, final URI targetURI) {
              ITextRegion _significantTextRegion = OccurrencesService.this._iLocationInFileProvider.getSignificantTextRegion(source, eReference, index);
              readRegions.add(_significantTextRegion);
            }
            
            @Override
            public void accept(final IReferenceDescription description) {
            }
          };
          XtextResource _resource_1 = it.getResource();
          CancelIndicatorProgressMonitor _cancelIndicatorProgressMonitor = new CancelIndicatorProgressMonitor(cancelIndicator);
          OccurrencesService.this._iReferenceFinder.findReferences(targetURIs, _resource_1, acceptor, _cancelIndicatorProgressMonitor);
          final ITextRegion definitionRegion = OccurrencesService.this._iLocationInFileProvider.getSignificantTextRegion(element);
          final ArrayList<ITextRegion> writeRegions = new ArrayList<ITextRegion>(1);
          if (((definitionRegion != null) && (definitionRegion != ITextRegionWithLineInformation.EMPTY_REGION))) {
            writeRegions.add(definitionRegion);
          }
          String _stateId = it.getStateId();
          final OccurrencesResult occurrencesResult = new OccurrencesResult(_stateId, readRegions, writeRegions);
          return occurrencesResult;
        }
        return null;
      }
    };
    return document.<OccurrencesResult>readOnly(_function);
  }
}
