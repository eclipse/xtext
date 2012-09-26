package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractBatchTypeResolverTest;
import org.eclipse.xtext.xbase.tests.typesystem.RecomputingBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class RecomputingTypeResolverTest extends AbstractBatchTypeResolverTest {
  @Inject
  private RecomputingBatchTypeResolver typeResolver;
  
  public IBatchTypeResolver getTypeResolver() {
    return this.typeResolver;
  }
}
