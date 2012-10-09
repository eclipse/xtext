package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.tests.typesystem.BatchConstructorCallTypeTest;
import org.eclipse.xtext.xbase.tests.typesystem.RecomputingBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class RecomputingBatchConstructorCallTypeTest extends BatchConstructorCallTypeTest {
  @Inject
  private RecomputingBatchTypeResolver recomputingResolver;
  
  public IBatchTypeResolver getTypeResolver() {
    return this.recomputingResolver;
  }
}
