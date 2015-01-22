/**
 */
package org.eclipse.xtext.serializer.syntacticsequencertest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.serializer.syntacticsequencertest.LongAlternative;
import org.eclipse.xtext.serializer.syntacticsequencertest.SyntacticsequencertestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Long Alternative</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.LongAlternativeImpl#getFoo <em>Foo</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.LongAlternativeImpl#getVal1 <em>Val1</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.LongAlternativeImpl#getVal2 <em>Val2</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.LongAlternativeImpl#getVal3 <em>Val3</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.LongAlternativeImpl#getVal4 <em>Val4</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.LongAlternativeImpl#getVal5 <em>Val5</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.LongAlternativeImpl#getVal6 <em>Val6</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.LongAlternativeImpl#getVal7 <em>Val7</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.LongAlternativeImpl#getVal8 <em>Val8</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LongAlternativeImpl extends MinimalEObjectImpl.Container implements LongAlternative
{
  /**
   * The default value of the '{@link #getFoo() <em>Foo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFoo()
   * @generated
   * @ordered
   */
  protected static final String FOO_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFoo() <em>Foo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFoo()
   * @generated
   * @ordered
   */
  protected String foo = FOO_EDEFAULT;

  /**
   * The cached value of the '{@link #getVal1() <em>Val1</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal1()
   * @generated
   * @ordered
   */
  protected EList<String> val1;

  /**
   * The cached value of the '{@link #getVal2() <em>Val2</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal2()
   * @generated
   * @ordered
   */
  protected EList<String> val2;

  /**
   * The cached value of the '{@link #getVal3() <em>Val3</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal3()
   * @generated
   * @ordered
   */
  protected EList<String> val3;

  /**
   * The cached value of the '{@link #getVal4() <em>Val4</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal4()
   * @generated
   * @ordered
   */
  protected EList<String> val4;

  /**
   * The cached value of the '{@link #getVal5() <em>Val5</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal5()
   * @generated
   * @ordered
   */
  protected EList<String> val5;

  /**
   * The cached value of the '{@link #getVal6() <em>Val6</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal6()
   * @generated
   * @ordered
   */
  protected EList<String> val6;

  /**
   * The cached value of the '{@link #getVal7() <em>Val7</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal7()
   * @generated
   * @ordered
   */
  protected EList<String> val7;

  /**
   * The cached value of the '{@link #getVal8() <em>Val8</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal8()
   * @generated
   * @ordered
   */
  protected EList<String> val8;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LongAlternativeImpl()
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
    return SyntacticsequencertestPackage.Literals.LONG_ALTERNATIVE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFoo()
  {
    return foo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFoo(String newFoo)
  {
    String oldFoo = foo;
    foo = newFoo;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.LONG_ALTERNATIVE__FOO, oldFoo, foo));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getVal1()
  {
    if (val1 == null)
    {
      val1 = new EDataTypeEList<String>(String.class, this, SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL1);
    }
    return val1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getVal2()
  {
    if (val2 == null)
    {
      val2 = new EDataTypeEList<String>(String.class, this, SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL2);
    }
    return val2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getVal3()
  {
    if (val3 == null)
    {
      val3 = new EDataTypeEList<String>(String.class, this, SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL3);
    }
    return val3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getVal4()
  {
    if (val4 == null)
    {
      val4 = new EDataTypeEList<String>(String.class, this, SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL4);
    }
    return val4;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getVal5()
  {
    if (val5 == null)
    {
      val5 = new EDataTypeEList<String>(String.class, this, SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL5);
    }
    return val5;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getVal6()
  {
    if (val6 == null)
    {
      val6 = new EDataTypeEList<String>(String.class, this, SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL6);
    }
    return val6;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getVal7()
  {
    if (val7 == null)
    {
      val7 = new EDataTypeEList<String>(String.class, this, SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL7);
    }
    return val7;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getVal8()
  {
    if (val8 == null)
    {
      val8 = new EDataTypeEList<String>(String.class, this, SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL8);
    }
    return val8;
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
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__FOO:
        return getFoo();
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL1:
        return getVal1();
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL2:
        return getVal2();
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL3:
        return getVal3();
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL4:
        return getVal4();
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL5:
        return getVal5();
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL6:
        return getVal6();
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL7:
        return getVal7();
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL8:
        return getVal8();
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
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__FOO:
        setFoo((String)newValue);
        return;
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL1:
        getVal1().clear();
        getVal1().addAll((Collection<? extends String>)newValue);
        return;
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL2:
        getVal2().clear();
        getVal2().addAll((Collection<? extends String>)newValue);
        return;
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL3:
        getVal3().clear();
        getVal3().addAll((Collection<? extends String>)newValue);
        return;
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL4:
        getVal4().clear();
        getVal4().addAll((Collection<? extends String>)newValue);
        return;
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL5:
        getVal5().clear();
        getVal5().addAll((Collection<? extends String>)newValue);
        return;
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL6:
        getVal6().clear();
        getVal6().addAll((Collection<? extends String>)newValue);
        return;
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL7:
        getVal7().clear();
        getVal7().addAll((Collection<? extends String>)newValue);
        return;
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL8:
        getVal8().clear();
        getVal8().addAll((Collection<? extends String>)newValue);
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
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__FOO:
        setFoo(FOO_EDEFAULT);
        return;
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL1:
        getVal1().clear();
        return;
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL2:
        getVal2().clear();
        return;
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL3:
        getVal3().clear();
        return;
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL4:
        getVal4().clear();
        return;
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL5:
        getVal5().clear();
        return;
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL6:
        getVal6().clear();
        return;
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL7:
        getVal7().clear();
        return;
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL8:
        getVal8().clear();
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
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__FOO:
        return FOO_EDEFAULT == null ? foo != null : !FOO_EDEFAULT.equals(foo);
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL1:
        return val1 != null && !val1.isEmpty();
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL2:
        return val2 != null && !val2.isEmpty();
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL3:
        return val3 != null && !val3.isEmpty();
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL4:
        return val4 != null && !val4.isEmpty();
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL5:
        return val5 != null && !val5.isEmpty();
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL6:
        return val6 != null && !val6.isEmpty();
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL7:
        return val7 != null && !val7.isEmpty();
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE__VAL8:
        return val8 != null && !val8.isEmpty();
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
    result.append(" (foo: ");
    result.append(foo);
    result.append(", val1: ");
    result.append(val1);
    result.append(", val2: ");
    result.append(val2);
    result.append(", val3: ");
    result.append(val3);
    result.append(", val4: ");
    result.append(val4);
    result.append(", val5: ");
    result.append(val5);
    result.append(", val6: ");
    result.append(val6);
    result.append(", val7: ");
    result.append(val7);
    result.append(", val8: ");
    result.append(val8);
    result.append(')');
    return result.toString();
  }

} //LongAlternativeImpl
