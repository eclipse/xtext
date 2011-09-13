package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.tests.jvmmodel.AbstractJvmModelTest;

@SuppressWarnings("all")
public class JvmModelTest extends AbstractJvmModelTest {
  
  @Inject
  private JvmTypesBuilder builder;
  
  @Inject
  private TypeReferences references;
  
  @Inject
  private ValidationTestHelper helper;
  
  public void testSimple() throws Exception {
    {
      XExpression _expression = this.expression("return s.toUpperCase", false);
      final XExpression expression = _expression;
      Resource _eResource = expression.eResource();
      final Resource resource = _eResource;
      this.helper.assertNoErrors(expression);
    }
  }
}