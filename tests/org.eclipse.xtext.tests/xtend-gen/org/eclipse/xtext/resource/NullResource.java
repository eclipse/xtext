package org.eclipse.xtext.resource;

import java.io.IOException;
import java.util.Map;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

@SuppressWarnings("all")
public class NullResource extends ResourceImpl {
  public void load(final Map<? extends Object,? extends Object> options) throws IOException {
  }
}
