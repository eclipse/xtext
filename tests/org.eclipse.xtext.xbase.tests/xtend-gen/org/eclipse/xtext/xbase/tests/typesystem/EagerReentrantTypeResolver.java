package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.tests.typesystem.EagerArgumentTypeComputer;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class EagerReentrantTypeResolver extends DefaultReentrantTypeResolver {
  @Inject
  private EagerArgumentTypeComputer typeComputer;
  
  protected ITypeComputer getTypeComputer() {
    return this.typeComputer;
  }
}
