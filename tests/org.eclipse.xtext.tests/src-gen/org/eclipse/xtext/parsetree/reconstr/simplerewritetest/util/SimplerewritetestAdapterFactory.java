/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti2;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Atom;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug305171;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Enum;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Val;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ConcreteMulti;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed2;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNameTest;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNamed;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.DuplicateBug284491;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectElement;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectRef;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectBug284850;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItem;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItems;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Expression;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop2;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop3;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop4;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.LoopBug285452;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ManyStrings;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.MultiInheritanceBug280439;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Op;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Ref2;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Spare;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Transient1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Type;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug1A;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug1B;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug2A;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug2B;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug305577_1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug305577_2;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage
 * @generated
 */
public class SimplerewritetestAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static SimplerewritetestPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimplerewritetestAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = SimplerewritetestPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SimplerewritetestSwitch<Adapter> modelSwitch =
    new SimplerewritetestSwitch<Adapter>()
    {
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseAtom(Atom object)
      {
        return createAtomAdapter();
      }
      @Override
      public Adapter caseTwoNumbers(TwoNumbers object)
      {
        return createTwoNumbersAdapter();
      }
      @Override
      public Adapter caseManyStrings(ManyStrings object)
      {
        return createManyStringsAdapter();
      }
      @Override
      public Adapter caseType(Type object)
      {
        return createTypeAdapter();
      }
      @Override
      public Adapter caseRef2(Ref2 object)
      {
        return createRef2Adapter();
      }
      @Override
      public Adapter caseSpare(Spare object)
      {
        return createSpareAdapter();
      }
      @Override
      public Adapter caseBoolean(org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean object)
      {
        return createBooleanAdapter();
      }
      @Override
      public Adapter caseTransient1(Transient1 object)
      {
        return createTransient1Adapter();
      }
      @Override
      public Adapter caseConsumed1(Consumed1 object)
      {
        return createConsumed1Adapter();
      }
      @Override
      public Adapter caseConsumed2(Consumed2 object)
      {
        return createConsumed2Adapter();
      }
      @Override
      public Adapter caseLoop1(Loop1 object)
      {
        return createLoop1Adapter();
      }
      @Override
      public Adapter caseLoop2(Loop2 object)
      {
        return createLoop2Adapter();
      }
      @Override
      public Adapter caseLoop3(Loop3 object)
      {
        return createLoop3Adapter();
      }
      @Override
      public Adapter caseLoop4(Loop4 object)
      {
        return createLoop4Adapter();
      }
      @Override
      public Adapter caseLoopBug285452(LoopBug285452 object)
      {
        return createLoopBug285452Adapter();
      }
      @Override
      public Adapter caseDuplicateBug284491(DuplicateBug284491 object)
      {
        return createDuplicateBug284491Adapter();
      }
      @Override
      public Adapter caseEmptyObjectBug284850(EmptyObjectBug284850 object)
      {
        return createEmptyObjectBug284850Adapter();
      }
      @Override
      public Adapter caseEmptyObjectItems(EmptyObjectItems object)
      {
        return createEmptyObjectItemsAdapter();
      }
      @Override
      public Adapter caseEmptyObjectItem(EmptyObjectItem object)
      {
        return createEmptyObjectItemAdapter();
      }
      @Override
      public Adapter caseMultiInheritanceBug280439(MultiInheritanceBug280439 object)
      {
        return createMultiInheritanceBug280439Adapter();
      }
      @Override
      public Adapter caseAbstractMulti1(AbstractMulti1 object)
      {
        return createAbstractMulti1Adapter();
      }
      @Override
      public Adapter caseAbstractMulti2(AbstractMulti2 object)
      {
        return createAbstractMulti2Adapter();
      }
      @Override
      public Adapter caseConcreteMulti(ConcreteMulti object)
      {
        return createConcreteMultiAdapter();
      }
      @Override
      public Adapter caseEObjectRef(EObjectRef object)
      {
        return createEObjectRefAdapter();
      }
      @Override
      public Adapter caseEObjectElement(EObjectElement object)
      {
        return createEObjectElementAdapter();
      }
      @Override
      public Adapter caseTypeBug305577_1(TypeBug305577_1 object)
      {
        return createTypeBug305577_1Adapter();
      }
      @Override
      public Adapter caseTypeBug305577_2(TypeBug305577_2 object)
      {
        return createTypeBug305577_2Adapter();
      }
      @Override
      public Adapter caseTypeBug1A(TypeBug1A object)
      {
        return createTypeBug1AAdapter();
      }
      @Override
      public Adapter caseTypeBug1B(TypeBug1B object)
      {
        return createTypeBug1BAdapter();
      }
      @Override
      public Adapter caseTypeBug2A(TypeBug2A object)
      {
        return createTypeBug2AAdapter();
      }
      @Override
      public Adapter caseTypeBug2B(TypeBug2B object)
      {
        return createTypeBug2BAdapter();
      }
      @Override
      public Adapter caseBug305171(Bug305171 object)
      {
        return createBug305171Adapter();
      }
      @Override
      public Adapter caseBug310435Enum(Bug310435Enum object)
      {
        return createBug310435EnumAdapter();
      }
      @Override
      public Adapter caseBug310435Val(Bug310435Val object)
      {
        return createBug310435ValAdapter();
      }
      @Override
      public Adapter caseCrossRefNameTest(CrossRefNameTest object)
      {
        return createCrossRefNameTestAdapter();
      }
      @Override
      public Adapter caseCrossRefNamed(CrossRefNamed object)
      {
        return createCrossRefNamedAdapter();
      }
      @Override
      public Adapter caseOp(Op object)
      {
        return createOpAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Atom <em>Atom</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Atom
   * @generated
   */
  public Adapter createAtomAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers <em>Two Numbers</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers
   * @generated
   */
  public Adapter createTwoNumbersAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ManyStrings <em>Many Strings</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ManyStrings
   * @generated
   */
  public Adapter createManyStringsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Type
   * @generated
   */
  public Adapter createTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Ref2 <em>Ref2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Ref2
   * @generated
   */
  public Adapter createRef2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Spare <em>Spare</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Spare
   * @generated
   */
  public Adapter createSpareAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean <em>Boolean</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean
   * @generated
   */
  public Adapter createBooleanAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Transient1 <em>Transient1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Transient1
   * @generated
   */
  public Adapter createTransient1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed1 <em>Consumed1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed1
   * @generated
   */
  public Adapter createConsumed1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed2 <em>Consumed2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed2
   * @generated
   */
  public Adapter createConsumed2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop1 <em>Loop1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop1
   * @generated
   */
  public Adapter createLoop1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop2 <em>Loop2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop2
   * @generated
   */
  public Adapter createLoop2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop3 <em>Loop3</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop3
   * @generated
   */
  public Adapter createLoop3Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop4 <em>Loop4</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop4
   * @generated
   */
  public Adapter createLoop4Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.LoopBug285452 <em>Loop Bug285452</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.LoopBug285452
   * @generated
   */
  public Adapter createLoopBug285452Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.DuplicateBug284491 <em>Duplicate Bug284491</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.DuplicateBug284491
   * @generated
   */
  public Adapter createDuplicateBug284491Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectBug284850 <em>Empty Object Bug284850</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectBug284850
   * @generated
   */
  public Adapter createEmptyObjectBug284850Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItems <em>Empty Object Items</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItems
   * @generated
   */
  public Adapter createEmptyObjectItemsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItem <em>Empty Object Item</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItem
   * @generated
   */
  public Adapter createEmptyObjectItemAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.MultiInheritanceBug280439 <em>Multi Inheritance Bug280439</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.MultiInheritanceBug280439
   * @generated
   */
  public Adapter createMultiInheritanceBug280439Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti1 <em>Abstract Multi1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti1
   * @generated
   */
  public Adapter createAbstractMulti1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti2 <em>Abstract Multi2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti2
   * @generated
   */
  public Adapter createAbstractMulti2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ConcreteMulti <em>Concrete Multi</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ConcreteMulti
   * @generated
   */
  public Adapter createConcreteMultiAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectRef <em>EObject Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectRef
   * @generated
   */
  public Adapter createEObjectRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectElement <em>EObject Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectElement
   * @generated
   */
  public Adapter createEObjectElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug305577_1 <em>Type Bug305577 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug305577_1
   * @generated
   */
  public Adapter createTypeBug305577_1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug305577_2 <em>Type Bug305577 2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug305577_2
   * @generated
   */
  public Adapter createTypeBug305577_2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug1A <em>Type Bug1 A</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug1A
   * @generated
   */
  public Adapter createTypeBug1AAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug1B <em>Type Bug1 B</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug1B
   * @generated
   */
  public Adapter createTypeBug1BAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug2A <em>Type Bug2 A</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug2A
   * @generated
   */
  public Adapter createTypeBug2AAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug2B <em>Type Bug2 B</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug2B
   * @generated
   */
  public Adapter createTypeBug2BAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug305171 <em>Bug305171</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug305171
   * @generated
   */
  public Adapter createBug305171Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Enum <em>Bug310435 Enum</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Enum
   * @generated
   */
  public Adapter createBug310435EnumAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Val <em>Bug310435 Val</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Val
   * @generated
   */
  public Adapter createBug310435ValAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNameTest <em>Cross Ref Name Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNameTest
   * @generated
   */
  public Adapter createCrossRefNameTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNamed <em>Cross Ref Named</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNamed
   * @generated
   */
  public Adapter createCrossRefNamedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Op <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Op
   * @generated
   */
  public Adapter createOpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //SimplerewritetestAdapterFactory
