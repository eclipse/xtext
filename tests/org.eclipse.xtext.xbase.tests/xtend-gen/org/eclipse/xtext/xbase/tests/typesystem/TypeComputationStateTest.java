package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.typesystem.AccessibleReentrantTypeResolver;
import org.eclipse.xtext.xbase.tests.typesystem.MyResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.internal.ChildExpressionTypeComputationState;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionTypeComputationState;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.RootExpressionComputationState;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class TypeComputationStateTest extends AbstractXbaseTestCase implements ITypeComputer {
  @Inject
  private AccessibleReentrantTypeResolver resolver;
  
  @Inject
  private CommonTypeComputationServices services;
  
  @Inject
  private ReflectExtensions _reflectExtensions;
  
  @Test
  public void testChildrenAddEntryForParent() {
    try {
      this.resolver.setTypeComputer(this);
      final XExpression expression = this.expression("{ null }");
      MyResolvedTypes _myResolvedTypes = new MyResolvedTypes(this.resolver);
      final MyResolvedTypes resolution = _myResolvedTypes;
      TypeReferences _typeReferences = this.services.getTypeReferences();
      final JvmAnyTypeReference any = _typeReferences.createAnyTypeReference(expression);
      IBatchScopeProvider _batchScopeProvider = this.resolver.getBatchScopeProvider();
      Resource _eResource = expression.eResource();
      IFeatureScopeSession _newSession = _batchScopeProvider.newSession(_eResource);
      RootExpressionComputationState _rootExpressionComputationState = new RootExpressionComputationState(resolution, _newSession, expression, this.resolver, any);
      _rootExpressionComputationState.computeTypes();
      JvmTypeReference _actualType = resolution.getActualType(expression);
      JvmTypeReference _unpack = this.unpack(_actualType);
      Assert.assertSame(any, _unpack);
      EList<EObject> _eContents = expression.eContents();
      EObject _head = IterableExtensions.<EObject>head(_eContents);
      JvmTypeReference _actualType_1 = resolution.getActualType(((XNullLiteral) _head));
      JvmTypeReference _unpack_1 = this.unpack(_actualType_1);
      Assert.assertSame(any, _unpack_1);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public JvmTypeReference unpack(final JvmTypeReference reference) {
    JvmTypeReference _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (reference instanceof JvmSpecializedTypeReference) {
        final JvmSpecializedTypeReference _jvmSpecializedTypeReference = (JvmSpecializedTypeReference)reference;
        _matched=true;
        JvmTypeReference _equivalent = _jvmSpecializedTypeReference.getEquivalent();
        JvmTypeReference _unpack = this.unpack(_equivalent);
        _switchResult = _unpack;
      }
    }
    if (!_matched) {
      if (reference instanceof JvmDelegateTypeReference) {
        final JvmDelegateTypeReference _jvmDelegateTypeReference = (JvmDelegateTypeReference)reference;
        _matched=true;
        JvmTypeReference _delegate = _jvmDelegateTypeReference.getDelegate();
        JvmTypeReference _unpack = this.unpack(_delegate);
        _switchResult = _unpack;
      }
    }
    if (!_matched) {
      _switchResult = reference;
    }
    return _switchResult;
  }
  
  public void computeTypes(final XExpression expression, final ITypeComputationState state) {
    try {
      Assert.assertTrue("state is instanceof ExpressionTypeComputationState", (state instanceof ExpressionTypeComputationState));
      List<ITypeExpectation> _immediateExpectations = state.getImmediateExpectations();
      ITypeExpectation _head = IterableExtensions.<ITypeExpectation>head(_immediateExpectations);
      final JvmTypeReference expectedType = _head.getExpectedType();
      if ((state instanceof ChildExpressionTypeComputationState)) {
        final ChildExpressionTypeComputationState casted = ((ChildExpressionTypeComputationState) state);
        final ResolvedTypes resolution = this._reflectExtensions.<ResolvedTypes>get(casted, "resolvedTypes");
        ExpressionTypeComputationState _get = this._reflectExtensions.<ExpressionTypeComputationState>get(casted, "parent");
        final ResolvedTypes parentResolution = this._reflectExtensions.<ResolvedTypes>get(_get, "resolvedTypes");
        EObject _eContainer = expression.eContainer();
        JvmTypeReference _actualType = parentResolution.getActualType(((XExpression) _eContainer));
        Assert.assertNull(_actualType);
        EObject _eContainer_1 = expression.eContainer();
        JvmTypeReference _actualType_1 = parentResolution.getActualType(((XExpression) _eContainer_1));
        Assert.assertNull(_actualType_1);
        state.acceptActualType(expectedType);
        JvmTypeReference _actualType_2 = parentResolution.getActualType(expression);
        Assert.assertNull(_actualType_2);
        JvmTypeReference _actualType_3 = resolution.getActualType(expression);
        JvmTypeReference _unpack = this.unpack(_actualType_3);
        Assert.assertSame(expectedType, _unpack);
        EObject _eContainer_2 = expression.eContainer();
        JvmTypeReference _actualType_4 = parentResolution.getActualType(((XExpression) _eContainer_2));
        Assert.assertNull(_actualType_4);
      } else {
        Assert.assertTrue((expression instanceof XBlockExpression));
        EList<EObject> _eContents = expression.eContents();
        EObject _head_1 = IterableExtensions.<EObject>head(_eContents);
        final XNullLiteral nullLiteral = ((XNullLiteral) _head_1);
        state.computeTypes(nullLiteral);
        final ResolvedTypes resolution_1 = this._reflectExtensions.<ResolvedTypes>get(state, "resolvedTypes");
        JvmTypeReference _actualType_5 = resolution_1.getActualType(nullLiteral);
        JvmTypeReference _unpack_1 = this.unpack(_actualType_5);
        Assert.assertSame(expectedType, _unpack_1);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public JvmIdentifiableElement getRefinableCandidate(final XExpression expression, final ITypeComputationState state) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Unexpected!");
    throw _unsupportedOperationException;
  }
}
