package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.IOException;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.tests.jvmmodel.AbstractJvmModelTest;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class JvmModelTest extends AbstractJvmModelTest {
  @Inject
  private ValidationTestHelper helper;
  
  @Inject
  private IResourceDescription.Manager manager;
  
  @Inject
  @Extension
  private ReflectExtensions _reflectExtensions;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
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
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testResourceDescriptionsAreCorrect() {
    try {
      final Resource resource = this.newResource("return s.toUpperCase");
      final boolean initialized = (this._reflectExtensions.<Boolean>get(resource, "fullyInitialized")).booleanValue();
      Assert.assertFalse(initialized);
      final IResourceDescription desc = this.manager.getResourceDescription(resource);
      Iterable<IEObjectDescription> _exportedObjects = desc.getExportedObjects();
      final ArrayList<Iterable<IEObjectDescription>> list = CollectionLiterals.<Iterable<IEObjectDescription>>newArrayList(_exportedObjects);
      int _size = list.size();
      Assert.assertEquals(1, _size);
      Boolean _get = this._reflectExtensions.<Boolean>get(resource, "fullyInitialized");
      Assert.assertFalse((_get).booleanValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  protected Resource newResource(final CharSequence input) throws IOException {
    final XtextResourceSet resourceSet = this.resourceSetProvider.get();
    URI _createURI = URI.createURI("Test.___xbase");
    final Resource resource = resourceSet.createResource(_createURI);
    String _string = input.toString();
    StringInputStream _stringInputStream = new StringInputStream(_string);
    resource.load(_stringInputStream, null);
    return resource;
  }
  
  @Test
  public void testReturnTypeConformance() {
    try {
      final XExpression expression = this.expression("return");
      this.helper.assertError(expression, XbasePackage.Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
