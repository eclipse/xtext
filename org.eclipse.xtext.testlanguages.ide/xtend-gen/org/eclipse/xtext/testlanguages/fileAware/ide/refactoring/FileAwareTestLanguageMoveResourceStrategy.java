package org.eclipse.xtext.testlanguages.fileAware.ide.refactoring;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ide.refactoring.MoveResourceContext;
import org.eclipse.xtext.ide.refactoring.ResourceModification;
import org.eclipse.xtext.ide.refactoring.ResourceURIChange;
import org.eclipse.xtext.ide.refactoring.XtextMoveResourceStrategy;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class FileAwareTestLanguageMoveResourceStrategy implements XtextMoveResourceStrategy {
  @Inject
  private IResourceServiceProvider resourceServiceProvider;
  
  @Override
  public void applyMove(final MoveResourceContext context) {
    List<ResourceURIChange> _fileChanges = context.getFileChanges();
    for (final ResourceURIChange change : _fileChanges) {
      boolean _canHandle = this.resourceServiceProvider.canHandle(change.getNewURI());
      if (_canHandle) {
        final ResourceModification _function = (Resource resource) -> {
          resource.setURI(change.getNewURI());
          final EObject rootElement = IterableExtensions.<EObject>head(resource.getContents());
          if ((rootElement instanceof PackageDeclaration)) {
            final String newPackage = IterableExtensions.join(IterableExtensions.<String>drop(change.getNewURI().trimSegments(1).segmentsList(), 2), ".");
            ((PackageDeclaration)rootElement).setName(newPackage);
          }
        };
        context.addModification(change.getOldURI(), _function);
      }
    }
  }
}
