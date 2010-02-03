/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug291022TestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug291022TestLanguage.Bug291022TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug291022TestLanguage.ModelAttribute;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug291022TestLanguage.ModelElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug291022TestLanguage.impl.ModelElementImpl#getFirstReference <em>First Reference</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug291022TestLanguage.impl.ModelElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug291022TestLanguage.impl.ModelElementImpl#getSecondReference <em>Second Reference</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug291022TestLanguage.impl.ModelElementImpl#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelElementImpl extends ModelAttributeImpl implements ModelElement
{
  /**
   * The cached value of the '{@link #getFirstReference() <em>First Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstReference()
   * @generated
   * @ordered
   */
  protected ModelElement firstReference;

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
   * The cached value of the '{@link #getSecondReference() <em>Second Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecondReference()
   * @generated
   * @ordered
   */
  protected ModelElement secondReference;

  /**
   * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElements()
   * @generated
   * @ordered
   */
  protected EList<ModelAttribute> elements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelElementImpl()
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
    return Bug291022TestLanguagePackage.Literals.MODEL_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelElement getFirstReference()
  {
    if (firstReference != null && firstReference.eIsProxy())
    {
      InternalEObject oldFirstReference = (InternalEObject)firstReference;
      firstReference = (ModelElement)eResolveProxy(oldFirstReference);
      if (firstReference != oldFirstReference)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bug291022TestLanguagePackage.MODEL_ELEMENT__FIRST_REFERENCE, oldFirstReference, firstReference));
      }
    }
    return firstReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelElement basicGetFirstReference()
  {
    return firstReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFirstReference(ModelElement newFirstReference)
  {
    ModelElement oldFirstReference = firstReference;
    firstReference = newFirstReference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug291022TestLanguagePackage.MODEL_ELEMENT__FIRST_REFERENCE, oldFirstReference, firstReference));
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
      eNotify(new ENotificationImpl(this, Notification.SET, Bug291022TestLanguagePackage.MODEL_ELEMENT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelElement getSecondReference()
  {
    if (secondReference != null && secondReference.eIsProxy())
    {
      InternalEObject oldSecondReference = (InternalEObject)secondReference;
      secondReference = (ModelElement)eResolveProxy(oldSecondReference);
      if (secondReference != oldSecondReference)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bug291022TestLanguagePackage.MODEL_ELEMENT__SECOND_REFERENCE, oldSecondReference, secondReference));
      }
    }
    return secondReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelElement basicGetSecondReference()
  {
    return secondReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSecondReference(ModelElement newSecondReference)
  {
    ModelElement oldSecondReference = secondReference;
    secondReference = newSecondReference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug291022TestLanguagePackage.MODEL_ELEMENT__SECOND_REFERENCE, oldSecondReference, secondReference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ModelAttribute> getElements()
  {
    if (elements == null)
    {
      elements = new EObjectContainmentEList<ModelAttribute>(ModelAttribute.class, this, Bug291022TestLanguagePackage.MODEL_ELEMENT__ELEMENTS);
    }
    return elements;
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
      case Bug291022TestLanguagePackage.MODEL_ELEMENT__ELEMENTS:
        return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
      case Bug291022TestLanguagePackage.MODEL_ELEMENT__FIRST_REFERENCE:
        if (resolve) return getFirstReference();
        return basicGetFirstReference();
      case Bug291022TestLanguagePackage.MODEL_ELEMENT__NAME:
        return getName();
      case Bug291022TestLanguagePackage.MODEL_ELEMENT__SECOND_REFERENCE:
        if (resolve) return getSecondReference();
        return basicGetSecondReference();
      case Bug291022TestLanguagePackage.MODEL_ELEMENT__ELEMENTS:
        return getElements();
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
      case Bug291022TestLanguagePackage.MODEL_ELEMENT__FIRST_REFERENCE:
        setFirstReference((ModelElement)newValue);
        return;
      case Bug291022TestLanguagePackage.MODEL_ELEMENT__NAME:
        setName((String)newValue);
        return;
      case Bug291022TestLanguagePackage.MODEL_ELEMENT__SECOND_REFERENCE:
        setSecondReference((ModelElement)newValue);
        return;
      case Bug291022TestLanguagePackage.MODEL_ELEMENT__ELEMENTS:
        getElements().clear();
        getElements().addAll((Collection<? extends ModelAttribute>)newValue);
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
      case Bug291022TestLanguagePackage.MODEL_ELEMENT__FIRST_REFERENCE:
        setFirstReference((ModelElement)null);
        return;
      case Bug291022TestLanguagePackage.MODEL_ELEMENT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case Bug291022TestLanguagePackage.MODEL_ELEMENT__SECOND_REFERENCE:
        setSecondReference((ModelElement)null);
        return;
      case Bug291022TestLanguagePackage.MODEL_ELEMENT__ELEMENTS:
        getElements().clear();
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
      case Bug291022TestLanguagePackage.MODEL_ELEMENT__FIRST_REFERENCE:
        return firstReference != null;
      case Bug291022TestLanguagePackage.MODEL_ELEMENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case Bug291022TestLanguagePackage.MODEL_ELEMENT__SECOND_REFERENCE:
        return secondReference != null;
      case Bug291022TestLanguagePackage.MODEL_ELEMENT__ELEMENTS:
        return elements != null && !elements.isEmpty();
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
    result.append(')');
    return result.toString();
  }

} //ModelElementImpl
