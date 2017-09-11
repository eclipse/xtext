package org.eclipse.xtext.testlanguages.fileAware.ide.refactoring;

import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ide.refactoring.IResourceRelocationStrategy;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationChange;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationContext;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class FileAwareTestLanguageResourceRelocationStrategy extends IResourceRelocationStrategy.AbstractImpl {
  @Override
  public void applySideEffects(final ResourceRelocationContext context) {
    final Function1<ResourceRelocationChange, Boolean> _function = (ResourceRelocationChange it) -> {
      return Boolean.valueOf((it.isFile() && this.canHandle(it)));
    };
    final Consumer<ResourceRelocationChange> _function_1 = (ResourceRelocationChange change) -> {
      final Resource resource = context.getResourceSet().getResource(change.getToURI(), false);
      final EObject rootElement = IterableExtensions.<EObject>head(resource.getContents());
      if ((rootElement instanceof PackageDeclaration)) {
        final String newPackage = IterableExtensions.join(IterableExtensions.<String>drop(change.getToURI().trimSegments(1).segmentsList(), 2), ".");
        ((PackageDeclaration)rootElement).setName(newPackage);
      }
    };
    IterableExtensions.<ResourceRelocationChange>filter(context.getChanges(), _function).forEach(_function_1);
  }
}
