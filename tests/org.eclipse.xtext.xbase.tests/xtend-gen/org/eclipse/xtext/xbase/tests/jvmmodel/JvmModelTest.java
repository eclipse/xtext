package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage.Literals;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.tests.jvmmodel.AbstractJvmModelTest;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class JvmModelTest extends AbstractJvmModelTest {
  @Inject
  private ValidationTestHelper helper;
  
  @Inject
  private Manager manager;
  
  @Test
  public void testSimple() {
    try {
      final XExpression expression = this.expression("return s.toUpperCase", false);
      Resource _eResource = expression.eResource();
      EList<EObject> _contents = _eResource.getContents();
      String _string = _contents.toString();
      Resource _eResource_1 = expression.eResource();
      EList<EObject> _contents_1 = _eResource_1.getContents();
      int _size = _contents_1.size();
      Assert.assertEquals(_string, 2, _size);
      this.helper.assertNoErrors(expression);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testResourceDescriptionsAreCorrect() {
    try {
      final Resource resource = this.newResource("return s.toUpperCase");
      final Field field = DerivedStateAwareResource.class.getDeclaredField("fullyInitialized");
      field.setAccessible(true);
      Object _get = field.get(resource);
      Assert.assertFalse((((Boolean) _get)).booleanValue());
      final IResourceDescription desc = this.manager.getResourceDescription(resource);
      Iterable<IEObjectDescription> _exportedObjects = desc.getExportedObjects();
      final ArrayList<Iterable<IEObjectDescription>> list = CollectionLiterals.<Iterable<IEObjectDescription>>newArrayList(_exportedObjects);
      int _size = list.size();
      Assert.assertEquals(1, _size);
      Object _get_1 = field.get(resource);
      Assert.assertFalse((((Boolean) _get_1)).booleanValue());
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testReturnTypeConformance() {
    try {
      final XExpression expression = this.expression("return");
      this.helper.assertError(expression, Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
