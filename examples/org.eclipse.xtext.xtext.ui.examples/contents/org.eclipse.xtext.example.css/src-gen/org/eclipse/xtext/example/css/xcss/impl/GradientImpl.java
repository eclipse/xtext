/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.css.xcss.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.example.css.xcss.ColorLiteral;
import org.eclipse.xtext.example.css.xcss.Gradient;
import org.eclipse.xtext.example.css.xcss.Percent;
import org.eclipse.xtext.example.css.xcss.XcssPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gradient</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.impl.GradientImpl#getColors <em>Colors</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.impl.GradientImpl#getPercents <em>Percents</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GradientImpl extends ColorLiteralImpl implements Gradient
{
  /**
   * The cached value of the '{@link #getColors() <em>Colors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColors()
   * @generated
   * @ordered
   */
  protected EList<ColorLiteral> colors;

  /**
   * The cached value of the '{@link #getPercents() <em>Percents</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPercents()
   * @generated
   * @ordered
   */
  protected EList<Percent> percents;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GradientImpl()
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
    return XcssPackage.Literals.GRADIENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ColorLiteral> getColors()
  {
    if (colors == null)
    {
      colors = new EObjectContainmentEList<ColorLiteral>(ColorLiteral.class, this, XcssPackage.GRADIENT__COLORS);
    }
    return colors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Percent> getPercents()
  {
    if (percents == null)
    {
      percents = new EObjectContainmentEList<Percent>(Percent.class, this, XcssPackage.GRADIENT__PERCENTS);
    }
    return percents;
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
      case XcssPackage.GRADIENT__COLORS:
        return ((InternalEList<?>)getColors()).basicRemove(otherEnd, msgs);
      case XcssPackage.GRADIENT__PERCENTS:
        return ((InternalEList<?>)getPercents()).basicRemove(otherEnd, msgs);
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
      case XcssPackage.GRADIENT__COLORS:
        return getColors();
      case XcssPackage.GRADIENT__PERCENTS:
        return getPercents();
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
      case XcssPackage.GRADIENT__COLORS:
        getColors().clear();
        getColors().addAll((Collection<? extends ColorLiteral>)newValue);
        return;
      case XcssPackage.GRADIENT__PERCENTS:
        getPercents().clear();
        getPercents().addAll((Collection<? extends Percent>)newValue);
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
      case XcssPackage.GRADIENT__COLORS:
        getColors().clear();
        return;
      case XcssPackage.GRADIENT__PERCENTS:
        getPercents().clear();
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
      case XcssPackage.GRADIENT__COLORS:
        return colors != null && !colors.isEmpty();
      case XcssPackage.GRADIENT__PERCENTS:
        return percents != null && !percents.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //GradientImpl
