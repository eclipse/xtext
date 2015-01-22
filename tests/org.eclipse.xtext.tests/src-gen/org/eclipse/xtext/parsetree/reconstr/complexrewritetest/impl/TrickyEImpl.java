/**
 */
package org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tricky E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyEImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyEImpl#getFoo <em>Foo</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyEImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TrickyEImpl extends MinimalEObjectImpl.Container implements TrickyE
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
   * The cached value of the '{@link #getFoo() <em>Foo</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFoo()
   * @generated
   * @ordered
   */
  protected EList<String> foo;

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
  protected TrickyEImpl()
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
    return ComplexrewritetestPackage.Literals.TRICKY_E;
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
      name = new EDataTypeEList<Integer>(Integer.class, this, ComplexrewritetestPackage.TRICKY_E__NAME);
    }
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getFoo()
  {
    if (foo == null)
    {
      foo = new EDataTypeEList<String>(String.class, this, ComplexrewritetestPackage.TRICKY_E__FOO);
    }
    return foo;
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
      type = new EDataTypeEList<String>(String.class, this, ComplexrewritetestPackage.TRICKY_E__TYPE);
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
      case ComplexrewritetestPackage.TRICKY_E__NAME:
        return getName();
      case ComplexrewritetestPackage.TRICKY_E__FOO:
        return getFoo();
      case ComplexrewritetestPackage.TRICKY_E__TYPE:
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
      case ComplexrewritetestPackage.TRICKY_E__NAME:
        getName().clear();
        getName().addAll((Collection<? extends Integer>)newValue);
        return;
      case ComplexrewritetestPackage.TRICKY_E__FOO:
        getFoo().clear();
        getFoo().addAll((Collection<? extends String>)newValue);
        return;
      case ComplexrewritetestPackage.TRICKY_E__TYPE:
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
      case ComplexrewritetestPackage.TRICKY_E__NAME:
        getName().clear();
        return;
      case ComplexrewritetestPackage.TRICKY_E__FOO:
        getFoo().clear();
        return;
      case ComplexrewritetestPackage.TRICKY_E__TYPE:
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
      case ComplexrewritetestPackage.TRICKY_E__NAME:
        return name != null && !name.isEmpty();
      case ComplexrewritetestPackage.TRICKY_E__FOO:
        return foo != null && !foo.isEmpty();
      case ComplexrewritetestPackage.TRICKY_E__TYPE:
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

} //TrickyEImpl
