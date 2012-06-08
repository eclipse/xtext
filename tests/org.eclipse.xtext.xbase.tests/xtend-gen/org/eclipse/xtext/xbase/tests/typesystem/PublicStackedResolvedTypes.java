package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.StackedResolvedTypes;

@SuppressWarnings("all")
public class PublicStackedResolvedTypes extends StackedResolvedTypes {
  public PublicStackedResolvedTypes(final ResolvedTypes parent) {
    super(parent);
  }
}
