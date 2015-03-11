/**
 */
package org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Loop;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.LoopImpl#getNames <em>Names</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.LoopImpl#getGr <em>Gr</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.LoopImpl#getInts <em>Ints</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.LoopImpl#getStrings <em>Strings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LoopImpl extends ModelImpl implements Loop
{
  /**
   * The cached value of the '{@link #getNames() <em>Names</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNames()
   * @generated
   * @ordered
   */
  protected EList<String> names;

  /**
   * The cached value of the '{@link #getGr() <em>Gr</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGr()
   * @generated
   * @ordered
   */
  protected EList<String> gr;

  /**
   * The cached value of the '{@link #getInts() <em>Ints</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInts()
   * @generated
   * @ordered
   */
  protected EList<Integer> ints;

  /**
   * The cached value of the '{@link #getStrings() <em>Strings</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStrings()
   * @generated
   * @ordered
   */
  protected EList<String> strings;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LoopImpl()
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
    return ElementmatchertestlanguagePackage.Literals.LOOP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getNames()
  {
    if (names == null)
    {
      names = new EDataTypeEList<String>(String.class, this, ElementmatchertestlanguagePackage.LOOP__NAMES);
    }
    return names;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getGr()
  {
    if (gr == null)
    {
      gr = new EDataTypeEList<String>(String.class, this, ElementmatchertestlanguagePackage.LOOP__GR);
    }
    return gr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Integer> getInts()
  {
    if (ints == null)
    {
      ints = new EDataTypeEList<Integer>(Integer.class, this, ElementmatchertestlanguagePackage.LOOP__INTS);
    }
    return ints;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getStrings()
  {
    if (strings == null)
    {
      strings = new EDataTypeEList<String>(String.class, this, ElementmatchertestlanguagePackage.LOOP__STRINGS);
    }
    return strings;
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
      case ElementmatchertestlanguagePackage.LOOP__NAMES:
        return getNames();
      case ElementmatchertestlanguagePackage.LOOP__GR:
        return getGr();
      case ElementmatchertestlanguagePackage.LOOP__INTS:
        return getInts();
      case ElementmatchertestlanguagePackage.LOOP__STRINGS:
        return getStrings();
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
      case ElementmatchertestlanguagePackage.LOOP__NAMES:
        getNames().clear();
        getNames().addAll((Collection<? extends String>)newValue);
        return;
      case ElementmatchertestlanguagePackage.LOOP__GR:
        getGr().clear();
        getGr().addAll((Collection<? extends String>)newValue);
        return;
      case ElementmatchertestlanguagePackage.LOOP__INTS:
        getInts().clear();
        getInts().addAll((Collection<? extends Integer>)newValue);
        return;
      case ElementmatchertestlanguagePackage.LOOP__STRINGS:
        getStrings().clear();
        getStrings().addAll((Collection<? extends String>)newValue);
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
      case ElementmatchertestlanguagePackage.LOOP__NAMES:
        getNames().clear();
        return;
      case ElementmatchertestlanguagePackage.LOOP__GR:
        getGr().clear();
        return;
      case ElementmatchertestlanguagePackage.LOOP__INTS:
        getInts().clear();
        return;
      case ElementmatchertestlanguagePackage.LOOP__STRINGS:
        getStrings().clear();
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
      case ElementmatchertestlanguagePackage.LOOP__NAMES:
        return names != null && !names.isEmpty();
      case ElementmatchertestlanguagePackage.LOOP__GR:
        return gr != null && !gr.isEmpty();
      case ElementmatchertestlanguagePackage.LOOP__INTS:
        return ints != null && !ints.isEmpty();
      case ElementmatchertestlanguagePackage.LOOP__STRINGS:
        return strings != null && !strings.isEmpty();
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
    result.append(" (names: ");
    result.append(names);
    result.append(", gr: ");
    result.append(gr);
    result.append(", ints: ");
    result.append(ints);
    result.append(", strings: ");
    result.append(strings);
    result.append(')');
    return result.toString();
  }

} //LoopImpl
