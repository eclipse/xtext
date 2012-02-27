package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.eclipse.xtext.xbase.tests.jvmmodel.AbstractJvmModelTest;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class JvmModelAssociaterTest extends AbstractJvmModelTest {
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Test
  public void testInference() {
    {
      JvmModelAssociator _jvmModelAssociator = new JvmModelAssociator();
      final JvmModelAssociator assoc = _jvmModelAssociator;
      final Procedure3<EObject,IJvmDeclaredTypeAcceptor,Boolean> _function = new Procedure3<EObject,IJvmDeclaredTypeAcceptor,Boolean>() {
          public void apply(final EObject obj, final IJvmDeclaredTypeAcceptor acceptor, final Boolean preIndexing) {
            {
              JvmGenericType _class = JvmModelAssociaterTest.this._jvmTypesBuilder.toClass(obj, "foo.Bar");
              final JvmGenericType firstType = _class;
              JvmGenericType _class_1 = JvmModelAssociaterTest.this._jvmTypesBuilder.toClass(obj, "foo.Baz");
              final JvmGenericType secondType = _class_1;
              Resource _eResource = secondType.eResource();
              Assert.assertNull(_eResource);
              IPostIndexingInitializing<JvmGenericType> _accept = acceptor.<JvmGenericType>accept(firstType);
              final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
                  public void apply(final JvmGenericType it) {
                    {
                      it.setAbstract(true);
                      Resource _eResource = firstType.eResource();
                      Assert.assertNotNull(_eResource);
                      Resource _eResource_1 = secondType.eResource();
                      Assert.assertNotNull(_eResource_1);
                    }
                  }
                };
              _accept.initializeLater(_function);
              IPostIndexingInitializing<JvmGenericType> _accept_1 = acceptor.<JvmGenericType>accept(secondType);
              final Procedure1<JvmGenericType> _function_1 = new Procedure1<JvmGenericType>() {
                  public void apply(final JvmGenericType it) {
                    {
                      it.setAbstract(true);
                      Resource _eResource = firstType.eResource();
                      Assert.assertNotNull(_eResource);
                    }
                  }
                };
              _accept_1.initializeLater(_function_1);
            }
          }
        };
      assoc.setInferrer(new IJvmModelInferrer() {
          public void infer(EObject e,IJvmDeclaredTypeAcceptor acceptor,boolean preIndexingPhase) {
            _function.apply(e,acceptor,preIndexingPhase);
          }
      });
      DerivedStateAwareResource _derivedStateAwareResource = new DerivedStateAwareResource();
      final DerivedStateAwareResource resource = _derivedStateAwareResource;
      EList<EObject> _contents = resource.getContents();
      EClass _createEClass = EcoreFactory.eINSTANCE.createEClass();
      CollectionExtensions.<EClass>operator_add(_contents, _createEClass);
      assoc.installDerivedState(resource, true);
      EList<EObject> _contents_1 = resource.getContents();
      EObject _get = _contents_1.get(1);
      boolean _isAbstract = ((JvmDeclaredType) _get).isAbstract();
      Assert.assertFalse(_isAbstract);
      EList<EObject> _contents_2 = resource.getContents();
      _contents_2.clear();
      EList<EObject> _contents_3 = resource.getContents();
      EClass _createEClass_1 = EcoreFactory.eINSTANCE.createEClass();
      CollectionExtensions.<EClass>operator_add(_contents_3, _createEClass_1);
      assoc.installDerivedState(resource, false);
      EList<EObject> _contents_4 = resource.getContents();
      EObject _get_1 = _contents_4.get(1);
      boolean _isAbstract_1 = ((JvmDeclaredType) _get_1).isAbstract();
      Assert.assertTrue(_isAbstract_1);
    }
  }
}
