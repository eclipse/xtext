/**
 */
package org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyD;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tricky D</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyDImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyDImpl#getFoo <em>Foo</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyDImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TrickyDImpl extends MinimalEObjectImpl.Container implements TrickyD
{
  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected EList<Integer> name;

  /**
   * The default value of the '{@link #getFoo() <em>Foo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFoo()
   * @generated
   * @ordered
   */
  protected static final String FOO_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFoo() <em>Foo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFoo()
   * @generated
   * @ordered
   */
  protected String foo = FOO_EDEFAULT;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected EList<String> type;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TrickyDImpl()
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
    return ComplexrewritetestPackage.Literals.TRICKY_D;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Integer> getName()
  {
    if (name == null)
    {
      name = new EDataTypeEList<Integer>(Integer.class, this, ComplexrewritetestPackage.TRICKY_D__NAME);
    }
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFoo()
  {
    return foo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFoo(String newFoo)
  {
    String oldFoo = foo;
    foo = newFoo;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ComplexrewritetestPackage.TRICKY_D__FOO, oldFoo, foo));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getType()
  {
    if (type == null)
    {
      type = new EDataTypeEList<String>(String.class, this, ComplexrewritetestPackage.TRICKY_D__TYPE);
    }
    return type;
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
      case ComplexrewritetestPackage.TRICKY_D__NAME:
        return getName();
      case ComplexrewritetestPackage.TRICKY_D__FOO:
        return getFoo();
      case ComplexrewritetestPackage.TRICKY_D__TYPE:
        return getType();
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
      case ComplexrewritetestPackage.TRICKY_D__NAME:
        getName().clear();
        getName().addAll((Collection<? extends Integer>)newValue);
        return;
      case ComplexrewritetestPackage.TRICKY_D__FOO:
        setFoo((String)newValue);
        return;
      case ComplexrewritetestPackage.TRICKY_D__TYPE:
        getType().clear();
        getType().addAll((Collection<? extends String>)newValue);
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
      case ComplexrewritetestPackage.TRICKY_D__NAME:
        getName().clear();
        return;
      case ComplexrewritetestPackage.TRICKY_D__FOO:
        setFoo(FOO_EDEFAULT);
        return;
      case ComplexrewritetestPackage.TRICKY_D__TYPE:
        getType().clear();
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
      case ComplexrewritetestPackage.TRICKY_D__NAME:
        return name != null && !name.isEmpty();
      case ComplexrewritetestPackage.TRICKY_D__FOO:
        return FOO_EDEFAULT == null ? foo != null : !FOO_EDEFAULT.equals(foo);
      case ComplexrewritetestPackage.TRICKY_D__TYPE:
        return type != null && !type.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(", foo: ");
    result.append(foo);
    result.append(", type: ");
    result.append(type);
    result.append(')');
    return result.toString();
  }

} //TrickyDImpl
