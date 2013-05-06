package org.eclipse.xtend.core.resource;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.resource.XtendResourceDescription;
import org.eclipse.xtext.resource.DerivedStateAwareResourceDescriptionManager;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IResourceDescription;

@SuppressWarnings("all")
public class XtendResourceDescriptionManager extends DerivedStateAwareResourceDescriptionManager {
  protected IResourceDescription createResourceDescription(final Resource resource, final IDefaultResourceDescriptionStrategy strategy) {
    XtendResourceDescription _xtendResourceDescription = new XtendResourceDescription(resource, strategy);
    return _xtendResourceDescription;
  }
}
