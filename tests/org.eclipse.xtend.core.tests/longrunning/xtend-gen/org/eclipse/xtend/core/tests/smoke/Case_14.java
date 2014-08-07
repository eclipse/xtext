package org.eclipse.xtend.core.tests.smoke;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
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
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
@SuppressWarnings("all")
public class Case_14 extends AbstractXtendTestCase {
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  private JvmModelAssociator assoc;
  
  @Inject
  private XtextResourceSet resourceSet;
  
  @Inject
  private DerivedStateAwareResource resource;
  
  @Test
  public void testInference() {
    final IJvmModelInferrer _function = new IJvmModelInferrer() {
      public void infer(final EObject obj, final IJvmDeclaredTypeAcceptor acceptor, final boolean preIndexing) {
        final JvmGenericType firstType = Case_14.this._jvmTypesBuilder.toClass(obj, "foo.Bar");
        final JvmGenericType secondType = Case_14.this._jvmTypesBuilder.toClass(obj, "foo.Baz");
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
    Class<? extends Case_14> _class = this.getClass();
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
