package org.eclipse.xtext.idea.types;

import org.eclipse.xtext.common.types.xtext.AbstractConstructorScope;
import org.eclipse.xtext.idea.types.StubBasedTypeScope;

@SuppressWarnings("all")
public class StubBasedConstructorScope extends AbstractConstructorScope {
  protected StubBasedConstructorScope(final StubBasedTypeScope typeScope) {
    super(typeScope);
  }
}
