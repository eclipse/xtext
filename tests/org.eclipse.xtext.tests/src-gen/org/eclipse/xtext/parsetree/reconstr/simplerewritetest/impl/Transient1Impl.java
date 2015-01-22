/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl;

import java.lang.Boolean;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Transient1;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transient1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Transient1Impl#isPrecStar <em>Prec Star</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Transient1Impl#getPrec <em>Prec</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Transient1Impl#isScaleStar <em>Scale Star</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Transient1Impl#getScale <em>Scale</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Transient1Impl extends ExpressionImpl implements Transient1
{
  /**
   * The default value of the '{@link #isPrecStar() <em>Prec Star</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPrecStar()
   * @generated
   * @ordered
   */
  protected static final boolean PREC_STAR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPrecStar() <em>Prec Star</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPrecStar()
   * @generated
   * @ordered
   */
  protected boolean precStar = PREC_STAR_EDEFAULT;

  /**
   * The default value of the '{@link #getPrec() <em>Prec</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrec()
   * @generated
   * @ordered
   */
  protected static final int PREC_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getPrec() <em>Prec</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrec()
   * @generated
   * @ordered
   */
  protected int prec = PREC_EDEFAULT;

  /**
   * The default value of the '{@link #isScaleStar() <em>Scale Star</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isScaleStar()
   * @generated
   * @ordered
   */
  protected static final boolean SCALE_STAR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isScaleStar() <em>Scale Star</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isScaleStar()
   * @generated
   * @ordered
   */
  protected boolean scaleStar = SCALE_STAR_EDEFAULT;

  /**
   * The default value of the '{@link #getScale() <em>Scale</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScale()
   * @generated
   * @ordered
   */
  protected static final int SCALE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getScale() <em>Scale</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScale()
   * @generated
   * @ordered
   */
  protected int scale = SCALE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Transient1Impl()
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
    return SimplerewritetestPackage.Literals.TRANSIENT1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isPrecStar()
  {
    return precStar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrecStar(boolean newPrecStar)
  {
    boolean oldPrecStar = precStar;
    precStar = newPrecStar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimplerewritetestPackage.TRANSIENT1__PREC_STAR, oldPrecStar, precStar));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getPrec()
  {
    return prec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrec(int newPrec)
  {
    int oldPrec = prec;
    prec = newPrec;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimplerewritetestPackage.TRANSIENT1__PREC, oldPrec, prec));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isScaleStar()
  {
    return scaleStar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScaleStar(boolean newScaleStar)
  {
    boolean oldScaleStar = scaleStar;
    scaleStar = newScaleStar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimplerewritetestPackage.TRANSIENT1__SCALE_STAR, oldScaleStar, scaleStar));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getScale()
  {
    return scale;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScale(int newScale)
  {
    int oldScale = scale;
    scale = newScale;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimplerewritetestPackage.TRANSIENT1__SCALE, oldScale, scale));
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
      case SimplerewritetestPackage.TRANSIENT1__PREC_STAR:
        return isPrecStar();
      case SimplerewritetestPackage.TRANSIENT1__PREC:
        return getPrec();
      case SimplerewritetestPackage.TRANSIENT1__SCALE_STAR:
        return isScaleStar();
      case SimplerewritetestPackage.TRANSIENT1__SCALE:
        return getScale();
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
      case SimplerewritetestPackage.TRANSIENT1__PREC_STAR:
        setPrecStar((Boolean)newValue);
        return;
      case SimplerewritetestPackage.TRANSIENT1__PREC:
        setPrec((Integer)newValue);
        return;
      case SimplerewritetestPackage.TRANSIENT1__SCALE_STAR:
        setScaleStar((Boolean)newValue);
        return;
      case SimplerewritetestPackage.TRANSIENT1__SCALE:
        setScale((Integer)newValue);
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
      case SimplerewritetestPackage.TRANSIENT1__PREC_STAR:
        setPrecStar(PREC_STAR_EDEFAULT);
        return;
      case SimplerewritetestPackage.TRANSIENT1__PREC:
        setPrec(PREC_EDEFAULT);
        return;
      case SimplerewritetestPackage.TRANSIENT1__SCALE_STAR:
        setScaleStar(SCALE_STAR_EDEFAULT);
        return;
      case SimplerewritetestPackage.TRANSIENT1__SCALE:
        setScale(SCALE_EDEFAULT);
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
      case SimplerewritetestPackage.TRANSIENT1__PREC_STAR:
        return precStar != PREC_STAR_EDEFAULT;
      case SimplerewritetestPackage.TRANSIENT1__PREC:
        return prec != PREC_EDEFAULT;
      case SimplerewritetestPackage.TRANSIENT1__SCALE_STAR:
        return scaleStar != SCALE_STAR_EDEFAULT;
      case SimplerewritetestPackage.TRANSIENT1__SCALE:
        return scale != SCALE_EDEFAULT;
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
    result.append(" (precStar: ");
    result.append(precStar);
    result.append(", prec: ");
    result.append(prec);
    result.append(", scaleStar: ");
    result.append(scaleStar);
    result.append(", scale: ");
    result.append(scale);
    result.append(')');
    return result.toString();
  }

} //Transient1Impl
