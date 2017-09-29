package org.eclipse.xtext.testlanguages.fileAware.ide.refactoring;

import com.google.inject.Inject;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ide.refactoring.IResourceRelocationStrategy;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationChange;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationContext;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class FileAwareTestLanguageResourceRelocationStrategy implements IResourceRelocationStrategy {
  @Inject
  private IResourceServiceProvider resourceServiceProvider;
  
  public boolean canHandle(final ResourceRelocationChange change) {
    return this.resourceServiceProvider.canHandle(change.getFromURI());
  }
  
  @Override
  public void applyChange(final ResourceRelocationContext context) {
    final Function1<ResourceRelocationChange, Boolean> _function = (ResourceRelocationChange it) -> {
      return Boolean.valueOf(this.canHandle(it));
    };
    final Consumer<ResourceRelocationChange> _function_1 = (ResourceRelocationChange change) -> {
      final IChangeSerializer.IModification<Resource> _function_2 = (Resource resource) -> {
        final EObject rootElement = IterableExtensions.<EObject>head(resource.getContents());
        if ((rootElement instanceof PackageDeclaration)) {
          final String newPackage = IterableExtensions.join(IterableExtensions.<String>drop(change.getToURI().trimSegments(1).segmentsList(), 2), ".");
          ((PackageDeclaration)rootElement).setName(newPackage);
        }
      };
      context.addModification(change, _function_2);
    };
    IterableExtensions.<ResourceRelocationChange>filter(context.getChanges(), _function).forEach(_function_1);
  }
}
