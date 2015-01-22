/**
 */
package org.eclipse.xtext.grammarinheritance.foo.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.grammarinheritance.ametamodel.AType;

import org.eclipse.xtext.grammarinheritance.foo.ConcreteParserRule;
import org.eclipse.xtext.grammarinheritance.foo.FooPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concrete Parser Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.grammarinheritance.foo.impl.ConcreteParserRuleImpl#getMagicNumber <em>Magic Number</em>}</li>
 *   <li>{@link org.eclipse.xtext.grammarinheritance.foo.impl.ConcreteParserRuleImpl#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConcreteParserRuleImpl extends RootRuleImpl implements ConcreteParserRule
{
  /**
   * The default value of the '{@link #getMagicNumber() <em>Magic Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMagicNumber()
   * @generated
   * @ordered
   */
  protected static final double MAGIC_NUMBER_EDEFAULT = 0.0;

  /**
   * The cached value of the '{@link #getMagicNumber() <em>Magic Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMagicNumber()
   * @generated
   * @ordered
   */
  protected double magicNumber = MAGIC_NUMBER_EDEFAULT;

  /**
   * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElements()
   * @generated
   * @ordered
   */
  protected EList<AType> elements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConcreteParserRuleImpl()
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
    return FooPackage.Literals.CONCRETE_PARSER_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public double getMagicNumber()
  {
    return magicNumber;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMagicNumber(double newMagicNumber)
  {
    double oldMagicNumber = magicNumber;
    magicNumber = newMagicNumber;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FooPackage.CONCRETE_PARSER_RULE__MAGIC_NUMBER, oldMagicNumber, magicNumber));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AType> getElements()
  {
    if (elements == null)
    {
      elements = new EObjectContainmentEList<AType>(AType.class, this, FooPackage.CONCRETE_PARSER_RULE__ELEMENTS);
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
      case FooPackage.CONCRETE_PARSER_RULE__ELEMENTS:
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
      case FooPackage.CONCRETE_PARSER_RULE__MAGIC_NUMBER:
        return getMagicNumber();
      case FooPackage.CONCRETE_PARSER_RULE__ELEMENTS:
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
      case FooPackage.CONCRETE_PARSER_RULE__MAGIC_NUMBER:
        setMagicNumber((Double)newValue);
        return;
      case FooPackage.CONCRETE_PARSER_RULE__ELEMENTS:
        getElements().clear();
        getElements().addAll((Collection<? extends AType>)newValue);
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
      case FooPackage.CONCRETE_PARSER_RULE__MAGIC_NUMBER:
        setMagicNumber(MAGIC_NUMBER_EDEFAULT);
        return;
      case FooPackage.CONCRETE_PARSER_RULE__ELEMENTS:
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
      case FooPackage.CONCRETE_PARSER_RULE__MAGIC_NUMBER:
        return magicNumber != MAGIC_NUMBER_EDEFAULT;
      case FooPackage.CONCRETE_PARSER_RULE__ELEMENTS:
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
    result.append(" (magicNumber: ");
    result.append(magicNumber);
    result.append(')');
    return result.toString();
  }

} //ConcreteParserRuleImpl
