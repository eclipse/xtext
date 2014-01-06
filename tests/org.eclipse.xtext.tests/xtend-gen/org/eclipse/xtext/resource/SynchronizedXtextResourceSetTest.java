package org.eclipse.xtext.resource;

import org.eclipse.xtext.resource.AbstractXtextResourceSetTest;
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;

@SuppressWarnings("all")
public class SynchronizedXtextResourceSetTest extends AbstractXtextResourceSetTest {
  protected XtextResourceSet createEmptyResourceSet() {
    return new SynchronizedXtextResourceSet();
  }
}
