package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import java.io.IOException;
import junit.framework.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.LateInitializingLazyLinkingResource;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.resource.JvmModelInferringInitializer;
import org.eclipse.xtext.xbase.tests.jvmmodel.AbstractJvmModelTest;
import org.eclipse.xtext.xbase.tests.jvmmodel.SimpleJvmModelInferrer;

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
  
  public void testStateIsUpdatedOnChange() throws IOException, Exception {
    {
      Resource _newResource = this.newResource("return s.toUpperCase");
      final Resource resource = _newResource;
      XExpression _expression = this.expression("return \'foo\'", false);
      final XReturnExpression expression2 = ((XReturnExpression) _expression);
      JvmModelInferringInitializer _get = this.<JvmModelInferringInitializer>get(org.eclipse.xtext.xbase.resource.JvmModelInferringInitializer.class);
      final JvmModelInferringInitializer initializer = _get;
      SimpleJvmModelInferrer _get_1 = this.<SimpleJvmModelInferrer>get(org.eclipse.xtext.xbase.tests.jvmmodel.SimpleJvmModelInferrer.class);
      initializer.setInferrer(_get_1);
      ((LateInitializingLazyLinkingResource) resource).setLateInitialization(initializer);
      EList<EObject> _contents = resource.getContents();
      int _size = _contents.size();
      Assert.assertEquals(2, _size);
      EList<EObject> _contents_1 = resource.getContents();
      EObject _get_2 = _contents_1.get(1);
      final EObject type = _get_2;
      EList<EObject> _contents_2 = resource.getContents();
      EObject _get_3 = _contents_2.get(0);
      XExpression _expression_1 = expression2.getExpression();
      ((XReturnExpression) _get_3).setExpression(_expression_1);
      EList<EObject> _contents_3 = resource.getContents();
      int _size_1 = _contents_3.size();
      Assert.assertEquals(2, _size_1);
      EList<EObject> _contents_4 = resource.getContents();
      EObject _get_4 = _contents_4.get(1);
      Assert.assertNotSame(type, _get_4);
    }
  }
}