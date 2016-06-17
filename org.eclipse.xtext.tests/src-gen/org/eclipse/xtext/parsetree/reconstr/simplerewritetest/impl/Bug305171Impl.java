/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug305171;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bug305171</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Bug305171Impl#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Bug305171Impl#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Bug305171Impl#getZ <em>Z</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Bug305171Impl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Bug305171Impl extends ExpressionImpl implements Bug305171
{
  /**
   * The cached value of the '{@link #getX() <em>X</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX()
   * @generated
   * @ordered
   */
  protected EList<String> x;

  /**
   * The cached value of the '{@link #getY() <em>Y</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getY()
   * @generated
   * @ordered
   */
  protected EList<String> y;

  /**
   * The cached value of the '{@link #getZ() <em>Z</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getZ()
   * @generated
   * @ordered
   */
  protected EList<String> z;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Bug305171Impl()
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
    return SimplerewritetestPackage.Literals.BUG305171;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getX()
  {
    if (x == null)
    {
      x = new EDataTypeEList<String>(String.class, this, SimplerewritetestPackage.BUG305171__X);
    }
    return x;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getY()
  {
    if (y == null)
    {
      y = new EDataTypeEList<String>(String.class, this, SimplerewritetestPackage.BUG305171__Y);
    }
    return y;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getZ()
  {
    if (z == null)
    {
      z = new EDataTypeEList<String>(String.class, this, SimplerewritetestPackage.BUG305171__Z);
    }
    return z;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimplerewritetestPackage.BUG305171__NAME, oldName, name));
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
      case SimplerewritetestPackage.BUG305171__X:
        return getX();
      case SimplerewritetestPackage.BUG305171__Y:
        return getY();
      case SimplerewritetestPackage.BUG305171__Z:
        return getZ();
      case SimplerewritetestPackage.BUG305171__NAME:
        return getName();
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
      case SimplerewritetestPackage.BUG305171__X:
        getX().clear();
        getX().addAll((Collection<? extends String>)newValue);
        return;
      case SimplerewritetestPackage.BUG305171__Y:
        getY().clear();
        getY().addAll((Collection<? extends String>)newValue);
        return;
      case SimplerewritetestPackage.BUG305171__Z:
        getZ().clear();
        getZ().addAll((Collection<? extends String>)newValue);
        return;
      case SimplerewritetestPackage.BUG305171__NAME:
        setName((String)newValue);
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
      case SimplerewritetestPackage.BUG305171__X:
        getX().clear();
        return;
      case SimplerewritetestPackage.BUG305171__Y:
        getY().clear();
        return;
      case SimplerewritetestPackage.BUG305171__Z:
        getZ().clear();
        return;
      case SimplerewritetestPackage.BUG305171__NAME:
        setName(NAME_EDEFAULT);
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
      case SimplerewritetestPackage.BUG305171__X:
        return x != null && !x.isEmpty();
      case SimplerewritetestPackage.BUG305171__Y:
        return y != null && !y.isEmpty();
      case SimplerewritetestPackage.BUG305171__Z:
        return z != null && !z.isEmpty();
      case SimplerewritetestPackage.BUG305171__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
    result.append(" (x: ");
    result.append(x);
    result.append(", y: ");
    result.append(y);
    result.append(", z: ");
    result.append(z);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //Bug305171Impl
