/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.css.xcss.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.example.css.xcss.RGB;
import org.eclipse.xtext.example.css.xcss.XcssPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>RGB</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.impl.RGBImpl#isHex <em>Hex</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.impl.RGBImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.impl.RGBImpl#getRed <em>Red</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.impl.RGBImpl#getGreen <em>Green</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.impl.RGBImpl#getBlue <em>Blue</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RGBImpl extends ColorLiteralImpl implements RGB
{
  /**
   * The default value of the '{@link #isHex() <em>Hex</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHex()
   * @generated
   * @ordered
   */
  protected static final boolean HEX_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isHex() <em>Hex</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHex()
   * @generated
   * @ordered
   */
  protected boolean hex = HEX_EDEFAULT;

  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final int VALUE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected int value = VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getRed() <em>Red</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRed()
   * @generated
   * @ordered
   */
  protected static final int RED_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getRed() <em>Red</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRed()
   * @generated
   * @ordered
   */
  protected int red = RED_EDEFAULT;

  /**
   * The default value of the '{@link #getGreen() <em>Green</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGreen()
   * @generated
   * @ordered
   */
  protected static final int GREEN_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getGreen() <em>Green</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGreen()
   * @generated
   * @ordered
   */
  protected int green = GREEN_EDEFAULT;

  /**
   * The default value of the '{@link #getBlue() <em>Blue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBlue()
   * @generated
   * @ordered
   */
  protected static final int BLUE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getBlue() <em>Blue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBlue()
   * @generated
   * @ordered
   */
  protected int blue = BLUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RGBImpl()
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
    return XcssPackage.Literals.RGB;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isHex()
  {
    return hex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHex(boolean newHex)
  {
    boolean oldHex = hex;
    hex = newHex;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XcssPackage.RGB__HEX, oldHex, hex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(int newValue)
  {
    int oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XcssPackage.RGB__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getRed()
  {
    return red;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRed(int newRed)
  {
    int oldRed = red;
    red = newRed;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XcssPackage.RGB__RED, oldRed, red));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getGreen()
  {
    return green;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGreen(int newGreen)
  {
    int oldGreen = green;
    green = newGreen;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XcssPackage.RGB__GREEN, oldGreen, green));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getBlue()
  {
    return blue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBlue(int newBlue)
  {
    int oldBlue = blue;
    blue = newBlue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XcssPackage.RGB__BLUE, oldBlue, blue));
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
      case XcssPackage.RGB__HEX:
        return isHex();
      case XcssPackage.RGB__VALUE:
        return getValue();
      case XcssPackage.RGB__RED:
        return getRed();
      case XcssPackage.RGB__GREEN:
        return getGreen();
      case XcssPackage.RGB__BLUE:
        return getBlue();
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
      case XcssPackage.RGB__HEX:
        setHex((Boolean)newValue);
        return;
      case XcssPackage.RGB__VALUE:
        setValue((Integer)newValue);
        return;
      case XcssPackage.RGB__RED:
        setRed((Integer)newValue);
        return;
      case XcssPackage.RGB__GREEN:
        setGreen((Integer)newValue);
        return;
      case XcssPackage.RGB__BLUE:
        setBlue((Integer)newValue);
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
      case XcssPackage.RGB__HEX:
        setHex(HEX_EDEFAULT);
        return;
      case XcssPackage.RGB__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case XcssPackage.RGB__RED:
        setRed(RED_EDEFAULT);
        return;
      case XcssPackage.RGB__GREEN:
        setGreen(GREEN_EDEFAULT);
        return;
      case XcssPackage.RGB__BLUE:
        setBlue(BLUE_EDEFAULT);
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
      case XcssPackage.RGB__HEX:
        return hex != HEX_EDEFAULT;
      case XcssPackage.RGB__VALUE:
        return value != VALUE_EDEFAULT;
      case XcssPackage.RGB__RED:
        return red != RED_EDEFAULT;
      case XcssPackage.RGB__GREEN:
        return green != GREEN_EDEFAULT;
      case XcssPackage.RGB__BLUE:
        return blue != BLUE_EDEFAULT;
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
    result.append(" (hex: ");
    result.append(hex);
    result.append(", value: ");
    result.append(value);
    result.append(", red: ");
    result.append(red);
    result.append(", green: ");
    result.append(green);
    result.append(", blue: ");
    result.append(blue);
    result.append(')');
    return result.toString();
  }

} //RGBImpl
