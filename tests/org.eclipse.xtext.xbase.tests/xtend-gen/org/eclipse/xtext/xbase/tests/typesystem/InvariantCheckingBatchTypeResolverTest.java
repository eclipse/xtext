package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractBatchTypeResolverTest;
import org.eclipse.xtext.xbase.tests.typesystem.InvariantCheckingBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class InvariantCheckingBatchTypeResolverTest extends AbstractBatchTypeResolverTest {
  @Inject
  private InvariantCheckingBatchTypeResolver typeResolver;
  
  public IBatchTypeResolver getTypeResolver() {
    return this.typeResolver;
  }
}
