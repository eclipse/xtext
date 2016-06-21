package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.MembersInjector;
import com.google.inject.Provider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.jvmmodel.AbstractJvmModelTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class JvmModelAssociaterTest extends AbstractJvmModelTest {
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  private MembersInjector<JvmModelAssociator> associatorInjector;
  
  private JvmModelAssociator assoc;
  
  @Inject
  private XtextResourceSet resourceSet;
  
  @Inject
  private DerivedStateAwareResource resource;
  
  @Before
  public void createAssociator() {
    JvmModelAssociator _jvmModelAssociator = new JvmModelAssociator();
    this.assoc = _jvmModelAssociator;
    this.associatorInjector.injectMembers(this.assoc);
  }
  
  @After
  public void discardAssociator() {
    this.assoc = null;
  }
  
  @Test
  public void testInference() {
    final Provider<IJvmModelInferrer> _function = () -> {
      final IJvmModelInferrer _function_1 = (EObject obj, IJvmDeclaredTypeAcceptor acceptor, boolean preIndexing) -> {
        final JvmGenericType firstType = this._jvmTypesBuilder.toClass(obj, "foo.Bar");
        final JvmGenericType secondType = this._jvmTypesBuilder.toClass(obj, "foo.Baz");
        Resource _eResource = secondType.eResource();
        Assert.assertNull(_eResource);
        final Procedure1<JvmGenericType> _function_2 = (JvmGenericType it) -> {
          it.setAbstract(true);
          Resource _eResource_1 = firstType.eResource();
          Assert.assertNotNull(_eResource_1);
          Resource _eResource_2 = secondType.eResource();
          Assert.assertNotNull(_eResource_2);
        };
        acceptor.<JvmGenericType>accept(firstType, _function_2);
        final Procedure1<JvmGenericType> _function_3 = (JvmGenericType it) -> {
          it.setAbstract(true);
          Resource _eResource_1 = firstType.eResource();
          Assert.assertNotNull(_eResource_1);
        };
        acceptor.<JvmGenericType>accept(secondType, _function_3);
      };
      return _function_1;
    };
    this.assoc.setInferrerProvider(_function);
    this.resource.setDerivedStateComputer(null);
    URI _createURI = URI.createURI("foo.txt");
    this.resource.setURI(_createURI);
    Class<? extends JvmModelAssociaterTest> _class = this.getClass();
    this.resourceSet.setClasspathURIContext(_class);
    EList<Resource> _resources = this.resourceSet.getResources();
    this._jvmTypesBuilder.<DerivedStateAwareResource>operator_add(_resources, this.resource);
    EList<EObject> _contents = this.resource.getContents();
    EClass _createEClass = EcoreFactory.eINSTANCE.createEClass();
    this._jvmTypesBuilder.<EClass>operator_add(_contents, _createEClass);
    this.assoc.installDerivedState(this.resource, true);
    EList<EObject> _contents_1 = this.resource.getContents();
    EObject _get = _contents_1.get(1);
    boolean _isAbstract = ((JvmDeclaredType) _get).isAbstract();
    Assert.assertFalse(_isAbstract);
    EList<EObject> _contents_2 = this.resource.getContents();
    _contents_2.clear();
    EList<EObject> _contents_3 = this.resource.getContents();
    EClass _createEClass_1 = EcoreFactory.eINSTANCE.createEClass();
    this._jvmTypesBuilder.<EClass>operator_add(_contents_3, _createEClass_1);
    this.assoc.installDerivedState(this.resource, false);
    EList<EObject> _contents_4 = this.resource.getContents();
    EObject _get_1 = _contents_4.get(1);
    final JvmGenericType type = ((JvmGenericType) _get_1);
    boolean _isAbstract_1 = type.isAbstract();
    Assert.assertTrue(_isAbstract_1);
    EList<JvmMember> _members = type.getMembers();
    Iterable<JvmConstructor> _filter = Iterables.<JvmConstructor>filter(_members, JvmConstructor.class);
    int _size = IterableExtensions.size(_filter);
    Assert.assertEquals(1, _size);
    EList<JvmTypeReference> _superTypes = type.getSuperTypes();
    JvmTypeReference _head = IterableExtensions.<JvmTypeReference>head(_superTypes);
    String _qualifiedName = null;
    if (_head!=null) {
      _qualifiedName=_head.getQualifiedName();
    }
    Assert.assertEquals("java.lang.Object", _qualifiedName);
  }
}
