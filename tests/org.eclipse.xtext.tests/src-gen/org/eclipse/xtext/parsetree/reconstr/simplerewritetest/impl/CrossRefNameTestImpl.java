/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNameTest;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNamed;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cross Ref Name Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.CrossRefNameTestImpl#getNamed <em>Named</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.CrossRefNameTestImpl#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CrossRefNameTestImpl extends ExpressionImpl implements CrossRefNameTest
{
  /**
   * The cached value of the '{@link #getNamed() <em>Named</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamed()
   * @generated
   * @ordered
   */
  protected EList<CrossRefNamed> named;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected EList<CrossRefNamed> ref;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CrossRefNameTestImpl()
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
    return SimplerewritetestPackage.Literals.CROSS_REF_NAME_TEST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CrossRefNamed> getNamed()
  {
    if (named == null)
    {
      named = new EObjectContainmentEList<CrossRefNamed>(CrossRefNamed.class, this, SimplerewritetestPackage.CROSS_REF_NAME_TEST__NAMED);
    }
    return named;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CrossRefNamed> getRef()
  {
    if (ref == null)
    {
      ref = new EObjectResolvingEList<CrossRefNamed>(CrossRefNamed.class, this, SimplerewritetestPackage.CROSS_REF_NAME_TEST__REF);
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SimplerewritetestPackage.CROSS_REF_NAME_TEST__NAMED:
        return ((InternalEList<?>)getNamed()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case SimplerewritetestPackage.CROSS_REF_NAME_TEST__NAMED:
        return getNamed();
      case SimplerewritetestPackage.CROSS_REF_NAME_TEST__REF:
        return getRef();
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
      case SimplerewritetestPackage.CROSS_REF_NAME_TEST__NAMED:
        getNamed().clear();
        getNamed().addAll((Collection<? extends CrossRefNamed>)newValue);
        return;
      case SimplerewritetestPackage.CROSS_REF_NAME_TEST__REF:
        getRef().clear();
        getRef().addAll((Collection<? extends CrossRefNamed>)newValue);
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
      case SimplerewritetestPackage.CROSS_REF_NAME_TEST__NAMED:
        getNamed().clear();
        return;
      case SimplerewritetestPackage.CROSS_REF_NAME_TEST__REF:
        getRef().clear();
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
      case SimplerewritetestPackage.CROSS_REF_NAME_TEST__NAMED:
        return named != null && !named.isEmpty();
      case SimplerewritetestPackage.CROSS_REF_NAME_TEST__REF:
        return ref != null && !ref.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //CrossRefNameTestImpl
