/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionLiteral;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ScalarExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CollectionLiteralImpl#getItems <em>Items</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionLiteralImpl extends ExpressionImpl implements CollectionLiteral
{
  /**
   * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getItems()
   * @generated
   * @ordered
   */
  protected EList<ScalarExpression> items;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CollectionLiteralImpl()
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
    return Bug332217TestLanguagePackage.Literals.COLLECTION_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ScalarExpression> getItems()
  {
    if (items == null)
    {
      items = new EObjectContainmentEList<ScalarExpression>(ScalarExpression.class, this, Bug332217TestLanguagePackage.COLLECTION_LITERAL__ITEMS);
    }
    return items;
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
      case Bug332217TestLanguagePackage.COLLECTION_LITERAL__ITEMS:
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
      case Bug332217TestLanguagePackage.COLLECTION_LITERAL__ITEMS:
        return getItems();
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
      case Bug332217TestLanguagePackage.COLLECTION_LITERAL__ITEMS:
        getItems().clear();
        getItems().addAll((Collection<? extends ScalarExpression>)newValue);
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
      case Bug332217TestLanguagePackage.COLLECTION_LITERAL__ITEMS:
        getItems().clear();
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
      case Bug332217TestLanguagePackage.COLLECTION_LITERAL__ITEMS:
        return items != null && !items.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //CollectionLiteralImpl
