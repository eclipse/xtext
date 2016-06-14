/**
 */
package org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.ElementWithCardinality;
import org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleElement;
import org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element With Cardinality</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.ElementWithCardinalityImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.ElementWithCardinalityImpl#getCardinality <em>Cardinality</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElementWithCardinalityImpl extends RuleElementImpl implements ElementWithCardinality
{
  /**
   * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected RuleElement element;

  /**
   * The default value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCardinality()
   * @generated
   * @ordered
   */
  protected static final String CARDINALITY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCardinality()
   * @generated
   * @ordered
   */
  protected String cardinality = CARDINALITY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ElementWithCardinalityImpl()
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
    return SimpleAntlrPackage.Literals.ELEMENT_WITH_CARDINALITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleElement getElement()
  {
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElement(RuleElement newElement, NotificationChain msgs)
  {
    RuleElement oldElement = element;
    element = newElement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimpleAntlrPackage.ELEMENT_WITH_CARDINALITY__ELEMENT, oldElement, newElement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElement(RuleElement newElement)
  {
    if (newElement != element)
    {
      NotificationChain msgs = null;
      if (element != null)
        msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimpleAntlrPackage.ELEMENT_WITH_CARDINALITY__ELEMENT, null, msgs);
      if (newElement != null)
        msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimpleAntlrPackage.ELEMENT_WITH_CARDINALITY__ELEMENT, null, msgs);
      msgs = basicSetElement(newElement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimpleAntlrPackage.ELEMENT_WITH_CARDINALITY__ELEMENT, newElement, newElement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCardinality()
  {
    return cardinality;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCardinality(String newCardinality)
  {
    String oldCardinality = cardinality;
    cardinality = newCardinality;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimpleAntlrPackage.ELEMENT_WITH_CARDINALITY__CARDINALITY, oldCardinality, cardinality));
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
      case SimpleAntlrPackage.ELEMENT_WITH_CARDINALITY__ELEMENT:
        return basicSetElement(null, msgs);
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
      case SimpleAntlrPackage.ELEMENT_WITH_CARDINALITY__ELEMENT:
        return getElement();
      case SimpleAntlrPackage.ELEMENT_WITH_CARDINALITY__CARDINALITY:
        return getCardinality();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SimpleAntlrPackage.ELEMENT_WITH_CARDINALITY__ELEMENT:
        setElement((RuleElement)newValue);
        return;
      case SimpleAntlrPackage.ELEMENT_WITH_CARDINALITY__CARDINALITY:
        setCardinality((String)newValue);
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
      case SimpleAntlrPackage.ELEMENT_WITH_CARDINALITY__ELEMENT:
        setElement((RuleElement)null);
        return;
      case SimpleAntlrPackage.ELEMENT_WITH_CARDINALITY__CARDINALITY:
        setCardinality(CARDINALITY_EDEFAULT);
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
      case SimpleAntlrPackage.ELEMENT_WITH_CARDINALITY__ELEMENT:
        return element != null;
      case SimpleAntlrPackage.ELEMENT_WITH_CARDINALITY__CARDINALITY:
        return CARDINALITY_EDEFAULT == null ? cardinality != null : !CARDINALITY_EDEFAULT.equals(cardinality);
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
    result.append(" (cardinality: ");
    result.append(cardinality);
    result.append(')');
    return result.toString();
  }

} //ElementWithCardinalityImpl
