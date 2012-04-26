package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
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
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.typesystem.AccessibleReentrantTypeResolver;
import org.eclipse.xtext.xbase.tests.typesystem.MyTypeResolution;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.internal.ChildExpressionTypeComputationState;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionTypeComputationState;
import org.eclipse.xtext.xbase.typesystem.internal.RootExpressionComputationState;
import org.eclipse.xtext.xbase.typesystem.internal.TypeResolution;
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
  private ReflectExtensions _reflectExtensions;
  
  @Test
  public void testChildrenAddEntryForParent() {
    try {
      this.resolver.setTypeComputer(this);
      final XExpression expression = this.expression("{ null }");
      MyTypeResolution _myTypeResolution = new MyTypeResolution(this.resolver);
      final MyTypeResolution resolution = _myTypeResolution;
      TypeReferences _typeReferences = this.resolver.getTypeReferences();
      final JvmAnyTypeReference any = _typeReferences.createAnyTypeReference(expression);
      RootExpressionComputationState _rootExpressionComputationState = new RootExpressionComputationState(resolution, expression, this.resolver, any);
      _rootExpressionComputationState.computeTypes();
      JvmTypeReference _actualType = resolution.getActualType(expression);
      JvmTypeReference _equivalent = ((JvmSpecializedTypeReference) _actualType).getEquivalent();
      Assert.assertSame(any, _equivalent);
      EList<EObject> _eContents = expression.eContents();
      EObject _head = IterableExtensions.<EObject>head(_eContents);
      JvmTypeReference _actualType_1 = resolution.getActualType(((XNullLiteral) _head));
      JvmTypeReference _equivalent_1 = ((JvmSpecializedTypeReference) _actualType_1).getEquivalent();
      Assert.assertSame(any, _equivalent_1);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void computeTypes(final XExpression expression, final ITypeComputationState state) {
    try {
      Assert.assertTrue("state is instanceof ExpressionTypeComputationState", (state instanceof ExpressionTypeComputationState));
      List<ITypeExpectation> _immediateExpectations = state.getImmediateExpectations();
      ITypeExpectation _head = IterableExtensions.<ITypeExpectation>head(_immediateExpectations);
      final JvmTypeReference expectedType = _head.getExpectedType();
      if ((state instanceof ChildExpressionTypeComputationState)) {
        final ChildExpressionTypeComputationState casted = ((ChildExpressionTypeComputationState) state);
        final TypeResolution resolution = this._reflectExtensions.<TypeResolution>get(casted, "typeResolution");
        ExpressionTypeComputationState _get = this._reflectExtensions.<ExpressionTypeComputationState>get(casted, "parent");
        final TypeResolution parentResolution = this._reflectExtensions.<TypeResolution>get(_get, "typeResolution");
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
        JvmTypeReference _equivalent = ((JvmSpecializedTypeReference) _actualType_3).getEquivalent();
        Assert.assertSame(expectedType, _equivalent);
        EObject _eContainer_2 = expression.eContainer();
        JvmTypeReference _actualType_4 = parentResolution.getActualType(((XExpression) _eContainer_2));
        Assert.assertNull(_actualType_4);
      } else {
        Assert.assertTrue((expression instanceof XBlockExpression));
        EList<EObject> _eContents = expression.eContents();
        EObject _head_1 = IterableExtensions.<EObject>head(_eContents);
        final XNullLiteral nullLiteral = ((XNullLiteral) _head_1);
        state.computeTypes(nullLiteral);
        final TypeResolution resolution_1 = this._reflectExtensions.<TypeResolution>get(state, "typeResolution");
        JvmTypeReference _actualType_5 = resolution_1.getActualType(nullLiteral);
        JvmTypeReference _equivalent_1 = ((JvmSpecializedTypeReference) _actualType_5).getEquivalent();
        Assert.assertSame(expectedType, _equivalent_1);
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
