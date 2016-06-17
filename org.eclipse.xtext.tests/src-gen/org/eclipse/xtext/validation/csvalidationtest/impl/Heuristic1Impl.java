/**
 */
package org.eclipse.xtext.validation.csvalidationtest.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage;
import org.eclipse.xtext.validation.csvalidationtest.Heuristic1;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Heuristic1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.Heuristic1Impl#getA <em>A</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.Heuristic1Impl#getB <em>B</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.Heuristic1Impl#getC <em>C</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Heuristic1Impl extends MinimalEObjectImpl.Container implements Heuristic1
{
  /**
   * The cached value of the '{@link #getA() <em>A</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getA()
   * @generated
   * @ordered
   */
  protected EList<String> a;

  /**
   * The cached value of the '{@link #getB() <em>B</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getB()
   * @generated
   * @ordered
   */
  protected EList<String> b;

  /**
   * The cached value of the '{@link #getC() <em>C</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getC()
   * @generated
   * @ordered
   */
  protected EList<String> c;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Heuristic1Impl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return CsvalidationtestPackage.Literals.HEURISTIC1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getA()
  {
    if (a == null)
    {
      a = new EDataTypeEList<String>(String.class, this, CsvalidationtestPackage.HEURISTIC1__A);
    }
    return a;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getB()
  {
    if (b == null)
    {
      b = new EDataTypeEList<String>(String.class, this, CsvalidationtestPackage.HEURISTIC1__B);
    }
    return b;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getC()
  {
    if (c == null)
    {
      c = new EDataTypeEList<String>(String.class, this, CsvalidationtestPackage.HEURISTIC1__C);
    }
    return c;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case CsvalidationtestPackage.HEURISTIC1__A:
        return getA();
      case CsvalidationtestPackage.HEURISTIC1__B:
        return getB();
      case CsvalidationtestPackage.HEURISTIC1__C:
        return getC();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CsvalidationtestPackage.HEURISTIC1__A:
        getA().clear();
        getA().addAll((Collection<? extends String>)newValue);
        return;
      case CsvalidationtestPackage.HEURISTIC1__B:
        getB().clear();
        getB().addAll((Collection<? extends String>)newValue);
        return;
      case CsvalidationtestPackage.HEURISTIC1__C:
        getC().clear();
        getC().addAll((Collection<? extends String>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case CsvalidationtestPackage.HEURISTIC1__A:
        getA().clear();
        return;
      case CsvalidationtestPackage.HEURISTIC1__B:
        getB().clear();
        return;
      case CsvalidationtestPackage.HEURISTIC1__C:
        getC().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case CsvalidationtestPackage.HEURISTIC1__A:
        return a != null && !a.isEmpty();
      case CsvalidationtestPackage.HEURISTIC1__B:
        return b != null && !b.isEmpty();
      case CsvalidationtestPackage.HEURISTIC1__C:
        return c != null && !c.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (a: ");
    result.append(a);
    result.append(", b: ");
    result.append(b);
    result.append(", c: ");
    result.append(c);
    result.append(')');
    return result.toString();
  }

} //Heuristic1Impl
