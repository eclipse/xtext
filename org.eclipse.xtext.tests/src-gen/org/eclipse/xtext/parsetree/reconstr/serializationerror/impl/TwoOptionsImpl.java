/**
 */
package org.eclipse.xtext.parsetree.reconstr.serializationerror.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parsetree.reconstr.serializationerror.SerializationerrorPackage;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoOptions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Two Options</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.TwoOptionsImpl#getOne <em>One</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.TwoOptionsImpl#getTwo <em>Two</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TwoOptionsImpl extends TestImpl implements TwoOptions
{
  /**
   * The default value of the '{@link #getOne() <em>One</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOne()
   * @generated
   * @ordered
   */
  protected static final String ONE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOne() <em>One</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOne()
   * @generated
   * @ordered
   */
  protected String one = ONE_EDEFAULT;

  /**
   * The default value of the '{@link #getTwo() <em>Two</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTwo()
   * @generated
   * @ordered
   */
  protected static final String TWO_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTwo() <em>Two</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTwo()
   * @generated
   * @ordered
   */
  protected String two = TWO_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TwoOptionsImpl()
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
    return SerializationerrorPackage.Literals.TWO_OPTIONS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOne()
  {
    return one;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOne(String newOne)
  {
    String oldOne = one;
    one = newOne;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SerializationerrorPackage.TWO_OPTIONS__ONE, oldOne, one));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTwo()
  {
    return two;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTwo(String newTwo)
  {
    String oldTwo = two;
    two = newTwo;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SerializationerrorPackage.TWO_OPTIONS__TWO, oldTwo, two));
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
      case SerializationerrorPackage.TWO_OPTIONS__ONE:
        return getOne();
      case SerializationerrorPackage.TWO_OPTIONS__TWO:
        return getTwo();
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
      case SerializationerrorPackage.TWO_OPTIONS__ONE:
        setOne((String)newValue);
        return;
      case SerializationerrorPackage.TWO_OPTIONS__TWO:
        setTwo((String)newValue);
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
      case SerializationerrorPackage.TWO_OPTIONS__ONE:
        setOne(ONE_EDEFAULT);
        return;
      case SerializationerrorPackage.TWO_OPTIONS__TWO:
        setTwo(TWO_EDEFAULT);
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
      case SerializationerrorPackage.TWO_OPTIONS__ONE:
        return ONE_EDEFAULT == null ? one != null : !ONE_EDEFAULT.equals(one);
      case SerializationerrorPackage.TWO_OPTIONS__TWO:
        return TWO_EDEFAULT == null ? two != null : !TWO_EDEFAULT.equals(two);
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
    result.append(" (one: ");
    result.append(one);
    result.append(", two: ");
    result.append(two);
    result.append(')');
    return result.toString();
  }

} //TwoOptionsImpl
