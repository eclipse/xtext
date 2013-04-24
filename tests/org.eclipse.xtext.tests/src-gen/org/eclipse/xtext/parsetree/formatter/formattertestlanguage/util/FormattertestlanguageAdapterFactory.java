/**
 */
package org.eclipse.xtext.parsetree.formatter.formattertestlanguage.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguagePackage
 * @generated
 */
public class FormattertestlanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static FormattertestlanguagePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormattertestlanguageAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = FormattertestlanguagePackage.eINSTANCE;
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
  protected FormattertestlanguageSwitch<Adapter> modelSwitch =
    new FormattertestlanguageSwitch<Adapter>()
    {
      @Override
      public Adapter caseRoot(Root object)
      {
        return createRootAdapter();
      }
      @Override
      public Adapter caseLine(Line object)
      {
        return createLineAdapter();
      }
      @Override
      public Adapter caseDecl(Decl object)
      {
        return createDeclAdapter();
      }
      @Override
      public Adapter caseAssign(Assign object)
      {
        return createAssignAdapter();
      }
      @Override
      public Adapter caseMeth(Meth object)
      {
        return createMethAdapter();
      }
      @Override
      public Adapter caseParam(Param object)
      {
        return createParamAdapter();
      }
      @Override
      public Adapter caseSpace(Space object)
      {
        return createSpaceAdapter();
      }
      @Override
      public Adapter caseTestLinewrap(TestLinewrap object)
      {
        return createTestLinewrapAdapter();
      }
      @Override
      public Adapter caseTestLinewrapMinMax(TestLinewrapMinMax object)
      {
        return createTestLinewrapMinMaxAdapter();
      }
      @Override
      public Adapter caseTestIndentation(TestIndentation object)
      {
        return createTestIndentationAdapter();
      }
      @Override
      public Adapter caseFqnObj(FqnObj object)
      {
        return createFqnObjAdapter();
      }
      @Override
      public Adapter caseFqnRef(FqnRef object)
      {
        return createFqnRefAdapter();
      }
      @Override
      public Adapter caseEnumeration(Enumeration object)
      {
        return createEnumerationAdapter();
      }
      @Override
      public Adapter caseSuppressedHidden(SuppressedHidden object)
      {
        return createSuppressedHiddenAdapter();
      }
      @Override
      public Adapter caseSuppressedHiddenSub(SuppressedHiddenSub object)
      {
        return createSuppressedHiddenSubAdapter();
      }
      @Override
      public Adapter caseSuppressedHiddenSubSub(SuppressedHiddenSubSub object)
      {
        return createSuppressedHiddenSubSubAdapter();
      }
      @Override
      public Adapter caseSuppressedHiddenSubID(SuppressedHiddenSubID object)
      {
        return createSuppressedHiddenSubIDAdapter();
      }
      @Override
      public Adapter caseDatatypes(Datatypes object)
      {
        return createDatatypesAdapter();
      }
      @Override
      public Adapter caseWrappingDataTypeTest(WrappingDataTypeTest object)
      {
        return createWrappingDataTypeTestAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Root <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Root
   * @generated
   */
  public Adapter createRootAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Line <em>Line</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Line
   * @generated
   */
  public Adapter createLineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Decl <em>Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Decl
   * @generated
   */
  public Adapter createDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Assign <em>Assign</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Assign
   * @generated
   */
  public Adapter createAssignAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Meth <em>Meth</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Meth
   * @generated
   */
  public Adapter createMethAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Param <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Param
   * @generated
   */
  public Adapter createParamAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Space <em>Space</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Space
   * @generated
   */
  public Adapter createSpaceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestLinewrap <em>Test Linewrap</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestLinewrap
   * @generated
   */
  public Adapter createTestLinewrapAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestLinewrapMinMax <em>Test Linewrap Min Max</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestLinewrapMinMax
   * @generated
   */
  public Adapter createTestLinewrapMinMaxAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestIndentation <em>Test Indentation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestIndentation
   * @generated
   */
  public Adapter createTestIndentationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FqnObj <em>Fqn Obj</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FqnObj
   * @generated
   */
  public Adapter createFqnObjAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FqnRef <em>Fqn Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FqnRef
   * @generated
   */
  public Adapter createFqnRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Enumeration <em>Enumeration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Enumeration
   * @generated
   */
  public Adapter createEnumerationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHidden <em>Suppressed Hidden</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHidden
   * @generated
   */
  public Adapter createSuppressedHiddenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSub <em>Suppressed Hidden Sub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSub
   * @generated
   */
  public Adapter createSuppressedHiddenSubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSubSub <em>Suppressed Hidden Sub Sub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSubSub
   * @generated
   */
  public Adapter createSuppressedHiddenSubSubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSubID <em>Suppressed Hidden Sub ID</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSubID
   * @generated
   */
  public Adapter createSuppressedHiddenSubIDAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Datatypes <em>Datatypes</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Datatypes
   * @generated
   */
  public Adapter createDatatypesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.WrappingDataTypeTest <em>Wrapping Data Type Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.WrappingDataTypeTest
   * @generated
   */
  public Adapter createWrappingDataTypeTestAdapter()
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

} //FormattertestlanguageAdapterFactory
