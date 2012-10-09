package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.tests.typesystem.BatchIdentifiableTypeTest;
import org.eclipse.xtext.xbase.tests.typesystem.RecomputingBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class RecomputingBatchIdentifiableTypeTest extends BatchIdentifiableTypeTest {
  @Inject
  private RecomputingBatchTypeResolver recomputingResolver;
  
  public IBatchTypeResolver getTypeResolver() {
    return this.recomputingResolver;
  }
}
