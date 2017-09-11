package org.eclipse.xtext.testlanguages.fileAware.ide.refactoring;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ide.refactoring.IResourceRelocationStrategy;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationChange;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationContext;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class FileAwareTestLanguageResourceRelocationStrategy extends IResourceRelocationStrategy.AbstractImpl {
  @Override
  public void applySideEffects(final ResourceRelocationChange change, final Resource resource, final ResourceRelocationContext context) {
    final EObject rootElement = IterableExtensions.<EObject>head(resource.getContents());
    if ((rootElement instanceof PackageDeclaration)) {
      final String newPackage = IterableExtensions.join(IterableExtensions.<String>drop(change.getToURI().trimSegments(1).segmentsList(), 2), ".");
      ((PackageDeclaration)rootElement).setName(newPackage);
    }
  }
}
