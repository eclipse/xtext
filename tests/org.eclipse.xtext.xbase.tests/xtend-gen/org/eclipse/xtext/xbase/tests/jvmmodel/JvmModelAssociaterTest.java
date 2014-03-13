package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.MembersInjector;
import java.util.List;
import java.util.Set;
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
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelInferrerRegistry;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
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
    final IJvmModelInferrer _function = new IJvmModelInferrer() {
      public void infer(final EObject obj, final IJvmDeclaredTypeAcceptor acceptor, final boolean preIndexing) {
        final JvmGenericType firstType = JvmModelAssociaterTest.this._jvmTypesBuilder.toClass(obj, "foo.Bar");
        final JvmGenericType secondType = JvmModelAssociaterTest.this._jvmTypesBuilder.toClass(obj, "foo.Baz");
        Resource _eResource = secondType.eResource();
        Assert.assertNull(_eResource);
        IJvmDeclaredTypeAcceptor.IPostIndexingInitializing<JvmGenericType> _accept = acceptor.<JvmGenericType>accept(firstType);
        final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
          public void apply(final JvmGenericType it) {
            it.setAbstract(true);
            Resource _eResource = firstType.eResource();
            Assert.assertNotNull(_eResource);
            Resource _eResource_1 = secondType.eResource();
            Assert.assertNotNull(_eResource_1);
          }
        };
        _accept.initializeLater(_function);
        IJvmDeclaredTypeAcceptor.IPostIndexingInitializing<JvmGenericType> _accept_1 = acceptor.<JvmGenericType>accept(secondType);
        final Procedure1<JvmGenericType> _function_1 = new Procedure1<JvmGenericType>() {
          public void apply(final JvmGenericType it) {
            it.setAbstract(true);
            Resource _eResource = firstType.eResource();
            Assert.assertNotNull(_eResource);
          }
        };
        _accept_1.initializeLater(_function_1);
      }
    };
    this.assoc.setInferrer(_function);
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
  
  @Test
  public void testInference_2() {
    final IJvmModelInferrer _function = new IJvmModelInferrer() {
      public void infer(final EObject obj, final IJvmDeclaredTypeAcceptor acceptor, final boolean preIndexing) {
        final JvmGenericType firstType = JvmModelAssociaterTest.this._jvmTypesBuilder.toClass(obj, "foo.Bar");
        final JvmGenericType secondType = JvmModelAssociaterTest.this._jvmTypesBuilder.toClass(obj, "foo.Baz");
        Resource _eResource = secondType.eResource();
        Assert.assertNull(_eResource);
        final IJvmDeclaredTypeAcceptor.IPostIndexingInitializing<JvmGenericType> postIndexingInitializing = acceptor.<JvmGenericType>accept(firstType);
        IJvmDeclaredTypeAcceptor.IPostIndexingInitializing<JvmGenericType> _accept = acceptor.<JvmGenericType>accept(secondType);
        final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
          public void apply(final JvmGenericType it) {
            it.setAbstract(true);
            Resource _eResource = firstType.eResource();
            Assert.assertNotNull(_eResource);
          }
        };
        _accept.initializeLater(_function);
        final Procedure1<JvmGenericType> _function_1 = new Procedure1<JvmGenericType>() {
          public void apply(final JvmGenericType it) {
            it.setAbstract(true);
            Resource _eResource = firstType.eResource();
            Assert.assertNotNull(_eResource);
            Resource _eResource_1 = secondType.eResource();
            Assert.assertNotNull(_eResource_1);
          }
        };
        postIndexingInitializing.initializeLater(_function_1);
      }
    };
    this.assoc.setInferrer(_function);
    final IJvmModelInferrer _function_1 = new IJvmModelInferrer() {
      public void infer(final EObject obj, final IJvmDeclaredTypeAcceptor acceptor, final boolean preIndexing) {
        Resource _eResource = obj.eResource();
        EList<EObject> _contents = _eResource.getContents();
        int _size = _contents.size();
        Assert.assertEquals(3, _size);
        final JvmGenericType anotherType = JvmModelAssociaterTest.this._jvmTypesBuilder.toClass(obj, "foo.AnotherOne");
        IJvmDeclaredTypeAcceptor.IPostIndexingInitializing<JvmGenericType> _accept = acceptor.<JvmGenericType>accept(anotherType);
        final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
          public void apply(final JvmGenericType it) {
            it.setAbstract(true);
            Resource _eResource = it.eResource();
            EList<EObject> _contents = _eResource.getContents();
            Iterable<JvmGenericType> _filter = Iterables.<JvmGenericType>filter(_contents, JvmGenericType.class);
            final Function1<JvmGenericType, Boolean> _function = new Function1<JvmGenericType, Boolean>() {
              public Boolean apply(final JvmGenericType it) {
                String _identifier = it.getIdentifier();
                return Boolean.valueOf(Objects.equal(_identifier, "foo.Bar"));
              }
            };
            JvmGenericType _findFirst = IterableExtensions.<JvmGenericType>findFirst(_filter, _function);
            final Procedure1<JvmGenericType> _function_1 = new Procedure1<JvmGenericType>() {
              public void apply(final JvmGenericType bar) {
                EList<JvmTypeReference> _superTypes = bar.getSuperTypes();
                JvmTypeReference _newTypeRef = JvmModelAssociaterTest.this._jvmTypesBuilder.newTypeRef(it);
                JvmModelAssociaterTest.this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _newTypeRef);
              }
            };
            ObjectExtensions.<JvmGenericType>operator_doubleArrow(_findFirst, _function_1);
          }
        };
        _accept.initializeLater(_function);
        Resource _eResource_1 = obj.eResource();
        EList<EObject> _contents_1 = _eResource_1.getContents();
        int _size_1 = _contents_1.size();
        Assert.assertEquals(4, _size_1);
      }
    };
    JvmModelInferrerRegistry.INSTANCE.register("txt", _function_1);
    try {
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
      EObject _get_1 = _contents_2.get(3);
      boolean _isAbstract_1 = ((JvmDeclaredType) _get_1).isAbstract();
      Assert.assertFalse(_isAbstract_1);
      EList<EObject> _contents_3 = this.resource.getContents();
      _contents_3.clear();
      EList<EObject> _contents_4 = this.resource.getContents();
      EClass _createEClass_1 = EcoreFactory.eINSTANCE.createEClass();
      this._jvmTypesBuilder.<EClass>operator_add(_contents_4, _createEClass_1);
      this.assoc.installDerivedState(this.resource, false);
      EList<EObject> _contents_5 = this.resource.getContents();
      EObject _get_2 = _contents_5.get(1);
      final JvmGenericType type = ((JvmGenericType) _get_2);
      EList<EObject> _contents_6 = this.resource.getContents();
      EObject _get_3 = _contents_6.get(3);
      final JvmGenericType anotherType = ((JvmGenericType) _get_3);
      boolean _isAbstract_2 = type.isAbstract();
      Assert.assertTrue(_isAbstract_2);
      boolean _isAbstract_3 = anotherType.isAbstract();
      Assert.assertTrue(_isAbstract_3);
      String _identifier = anotherType.getIdentifier();
      Assert.assertEquals("foo.AnotherOne", _identifier);
      EList<JvmMember> _members = type.getMembers();
      Iterable<JvmConstructor> _filter = Iterables.<JvmConstructor>filter(_members, JvmConstructor.class);
      int _size = IterableExtensions.size(_filter);
      Assert.assertEquals(1, _size);
      EList<JvmTypeReference> _superTypes = type.getSuperTypes();
      int _size_1 = _superTypes.size();
      Assert.assertEquals(1, _size_1);
      EList<JvmTypeReference> _superTypes_1 = type.getSuperTypes();
      JvmTypeReference _head = IterableExtensions.<JvmTypeReference>head(_superTypes_1);
      JvmType _type = _head.getType();
      Assert.assertSame(_type, anotherType);
    } finally {
      List<? extends IJvmModelInferrer> _modelInferrer = JvmModelInferrerRegistry.INSTANCE.getModelInferrer("txt");
      final Set<? extends IJvmModelInferrer> allInferrers = IterableExtensions.toSet(_modelInferrer);
      final Procedure1<IJvmModelInferrer> _function_2 = new Procedure1<IJvmModelInferrer>() {
        public void apply(final IJvmModelInferrer it) {
          JvmModelInferrerRegistry.INSTANCE.deregister("txt", it);
        }
      };
      IterableExtensions.forEach(allInferrers, _function_2);
    }
  }
}
