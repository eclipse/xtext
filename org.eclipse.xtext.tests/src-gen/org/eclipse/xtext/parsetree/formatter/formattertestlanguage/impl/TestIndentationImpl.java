/**
 */
package org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguagePackage;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestIndentation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Indentation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestIndentationImpl#getItems <em>Items</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestIndentationImpl#isSemi <em>Semi</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestIndentationImpl extends RootImpl implements TestIndentation
{
  /**
   * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getItems()
   * @generated
   * @ordered
   */
  protected EList<EObject> items;

  /**
   * The default value of the '{@link #isSemi() <em>Semi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSemi()
   * @generated
   * @ordered
   */
  protected static final boolean SEMI_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSemi() <em>Semi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSemi()
   * @generated
   * @ordered
   */
  protected boolean semi = SEMI_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TestIndentationImpl()
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
    return FormattertestlanguagePackage.Literals.TEST_INDENTATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getItems()
  {
    if (items == null)
    {
      items = new EObjectContainmentEList<EObject>(EObject.class, this, FormattertestlanguagePackage.TEST_INDENTATION__ITEMS);
    }
    return items;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSemi()
  {
    return semi;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSemi(boolean newSemi)
  {
    boolean oldSemi = semi;
    semi = newSemi;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormattertestlanguagePackage.TEST_INDENTATION__SEMI, oldSemi, semi));
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
      case FormattertestlanguagePackage.TEST_INDENTATION__ITEMS:
        return ((InternalEList<?>)getItems()).basicRemove(otherEnd, msgs);
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
      case FormattertestlanguagePackage.TEST_INDENTATION__ITEMS:
        return getItems();
      case FormattertestlanguagePackage.TEST_INDENTATION__SEMI:
        return isSemi();
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
      case FormattertestlanguagePackage.TEST_INDENTATION__ITEMS:
        getItems().clear();
        getItems().addAll((Collection<? extends EObject>)newValue);
        return;
      case FormattertestlanguagePackage.TEST_INDENTATION__SEMI:
        setSemi((Boolean)newValue);
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
      case FormattertestlanguagePackage.TEST_INDENTATION__ITEMS:
        getItems().clear();
        return;
      case FormattertestlanguagePackage.TEST_INDENTATION__SEMI:
        setSemi(SEMI_EDEFAULT);
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
      case FormattertestlanguagePackage.TEST_INDENTATION__ITEMS:
        return items != null && !items.isEmpty();
      case FormattertestlanguagePackage.TEST_INDENTATION__SEMI:
        return semi != SEMI_EDEFAULT;
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
    result.append(" (semi: ");
    result.append(semi);
    result.append(')');
    return result.toString();
  }

} //TestIndentationImpl
