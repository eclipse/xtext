/**
 */
package org.eclipse.xtext.validation.csvalidationtest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.validation.csvalidationtest.AltList1;
import org.eclipse.xtext.validation.csvalidationtest.AltList2;
import org.eclipse.xtext.validation.csvalidationtest.AlternativeMultiplicities;
import org.eclipse.xtext.validation.csvalidationtest.AssignedAction;
import org.eclipse.xtext.validation.csvalidationtest.Combination1;
import org.eclipse.xtext.validation.csvalidationtest.Combination2;
import org.eclipse.xtext.validation.csvalidationtest.Combination3;
import org.eclipse.xtext.validation.csvalidationtest.Combination4;
import org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage;
import org.eclipse.xtext.validation.csvalidationtest.GroupMultiplicities;
import org.eclipse.xtext.validation.csvalidationtest.Heuristic1;
import org.eclipse.xtext.validation.csvalidationtest.List1;
import org.eclipse.xtext.validation.csvalidationtest.List2;
import org.eclipse.xtext.validation.csvalidationtest.List3;
import org.eclipse.xtext.validation.csvalidationtest.List4;
import org.eclipse.xtext.validation.csvalidationtest.List5;
import org.eclipse.xtext.validation.csvalidationtest.Model;
import org.eclipse.xtext.validation.csvalidationtest.SimpleAlternative;
import org.eclipse.xtext.validation.csvalidationtest.SimpleGroup;
import org.eclipse.xtext.validation.csvalidationtest.SimpleMultiplicities;
import org.eclipse.xtext.validation.csvalidationtest.StaticSimplification;
import org.eclipse.xtext.validation.csvalidationtest.TransientObject;
import org.eclipse.xtext.validation.csvalidationtest.TransientSerializeables1;
import org.eclipse.xtext.validation.csvalidationtest.TwoVersion;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedAction1;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedAction2;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedAction3;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall1;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall2;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX1 <em>X1</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX2 <em>X2</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX3 <em>X3</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX4 <em>X4</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX5 <em>X5</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX6 <em>X6</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX7 <em>X7</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX8 <em>X8</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX9 <em>X9</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX10 <em>X10</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX11 <em>X11</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX12 <em>X12</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX13 <em>X13</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX14 <em>X14</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX15 <em>X15</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX16 <em>X16</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX17 <em>X17</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX18 <em>X18</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX19 <em>X19</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX20 <em>X20</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX21 <em>X21</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX22 <em>X22</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX23 <em>X23</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX24 <em>X24</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX25 <em>X25</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX26 <em>X26</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX27 <em>X27</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.ModelImpl#getX28 <em>X28</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getX1() <em>X1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX1()
   * @generated
   * @ordered
   */
  protected SimpleGroup x1;

  /**
   * The cached value of the '{@link #getX2() <em>X2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX2()
   * @generated
   * @ordered
   */
  protected SimpleAlternative x2;

  /**
   * The cached value of the '{@link #getX3() <em>X3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX3()
   * @generated
   * @ordered
   */
  protected SimpleMultiplicities x3;

  /**
   * The cached value of the '{@link #getX4() <em>X4</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX4()
   * @generated
   * @ordered
   */
  protected GroupMultiplicities x4;

  /**
   * The cached value of the '{@link #getX5() <em>X5</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX5()
   * @generated
   * @ordered
   */
  protected AlternativeMultiplicities x5;

  /**
   * The cached value of the '{@link #getX6() <em>X6</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX6()
   * @generated
   * @ordered
   */
  protected AssignedAction x6;

  /**
   * The cached value of the '{@link #getX7() <em>X7</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX7()
   * @generated
   * @ordered
   */
  protected AssignedAction x7;

  /**
   * The cached value of the '{@link #getX8() <em>X8</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX8()
   * @generated
   * @ordered
   */
  protected UnassignedAction1 x8;

  /**
   * The cached value of the '{@link #getX9() <em>X9</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX9()
   * @generated
   * @ordered
   */
  protected UnassignedAction2 x9;

  /**
   * The cached value of the '{@link #getX10() <em>X10</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX10()
   * @generated
   * @ordered
   */
  protected UnassignedAction3 x10;

  /**
   * The cached value of the '{@link #getX11() <em>X11</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX11()
   * @generated
   * @ordered
   */
  protected UnassignedRuleCall1 x11;

  /**
   * The cached value of the '{@link #getX12() <em>X12</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX12()
   * @generated
   * @ordered
   */
  protected UnassignedRuleCall2 x12;

  /**
   * The cached value of the '{@link #getX13() <em>X13</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX13()
   * @generated
   * @ordered
   */
  protected Combination1 x13;

  /**
   * The cached value of the '{@link #getX14() <em>X14</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX14()
   * @generated
   * @ordered
   */
  protected Combination2 x14;

  /**
   * The cached value of the '{@link #getX15() <em>X15</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX15()
   * @generated
   * @ordered
   */
  protected Combination3 x15;

  /**
   * The cached value of the '{@link #getX16() <em>X16</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX16()
   * @generated
   * @ordered
   */
  protected Combination4 x16;

  /**
   * The cached value of the '{@link #getX17() <em>X17</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX17()
   * @generated
   * @ordered
   */
  protected List1 x17;

  /**
   * The cached value of the '{@link #getX18() <em>X18</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX18()
   * @generated
   * @ordered
   */
  protected List2 x18;

  /**
   * The cached value of the '{@link #getX19() <em>X19</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX19()
   * @generated
   * @ordered
   */
  protected List3 x19;

  /**
   * The cached value of the '{@link #getX20() <em>X20</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX20()
   * @generated
   * @ordered
   */
  protected List4 x20;

  /**
   * The cached value of the '{@link #getX21() <em>X21</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX21()
   * @generated
   * @ordered
   */
  protected List5 x21;

  /**
   * The cached value of the '{@link #getX22() <em>X22</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX22()
   * @generated
   * @ordered
   */
  protected AltList1 x22;

  /**
   * The cached value of the '{@link #getX23() <em>X23</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX23()
   * @generated
   * @ordered
   */
  protected AltList2 x23;

  /**
   * The cached value of the '{@link #getX24() <em>X24</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX24()
   * @generated
   * @ordered
   */
  protected TransientObject x24;

  /**
   * The cached value of the '{@link #getX25() <em>X25</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX25()
   * @generated
   * @ordered
   */
  protected TransientSerializeables1 x25;

  /**
   * The cached value of the '{@link #getX26() <em>X26</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX26()
   * @generated
   * @ordered
   */
  protected StaticSimplification x26;

  /**
   * The cached value of the '{@link #getX27() <em>X27</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX27()
   * @generated
   * @ordered
   */
  protected TwoVersion x27;

  /**
   * The cached value of the '{@link #getX28() <em>X28</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX28()
   * @generated
   * @ordered
   */
  protected Heuristic1 x28;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return CsvalidationtestPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleGroup getX1()
  {
    return x1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX1(SimpleGroup newX1, NotificationChain msgs)
  {
    SimpleGroup oldX1 = x1;
    x1 = newX1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X1, oldX1, newX1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX1(SimpleGroup newX1)
  {
    if (newX1 != x1)
    {
      NotificationChain msgs = null;
      if (x1 != null)
        msgs = ((InternalEObject)x1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X1, null, msgs);
      if (newX1 != null)
        msgs = ((InternalEObject)newX1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X1, null, msgs);
      msgs = basicSetX1(newX1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X1, newX1, newX1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleAlternative getX2()
  {
    return x2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX2(SimpleAlternative newX2, NotificationChain msgs)
  {
    SimpleAlternative oldX2 = x2;
    x2 = newX2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X2, oldX2, newX2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX2(SimpleAlternative newX2)
  {
    if (newX2 != x2)
    {
      NotificationChain msgs = null;
      if (x2 != null)
        msgs = ((InternalEObject)x2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X2, null, msgs);
      if (newX2 != null)
        msgs = ((InternalEObject)newX2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X2, null, msgs);
      msgs = basicSetX2(newX2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X2, newX2, newX2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleMultiplicities getX3()
  {
    return x3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX3(SimpleMultiplicities newX3, NotificationChain msgs)
  {
    SimpleMultiplicities oldX3 = x3;
    x3 = newX3;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X3, oldX3, newX3);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX3(SimpleMultiplicities newX3)
  {
    if (newX3 != x3)
    {
      NotificationChain msgs = null;
      if (x3 != null)
        msgs = ((InternalEObject)x3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X3, null, msgs);
      if (newX3 != null)
        msgs = ((InternalEObject)newX3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X3, null, msgs);
      msgs = basicSetX3(newX3, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X3, newX3, newX3));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GroupMultiplicities getX4()
  {
    return x4;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX4(GroupMultiplicities newX4, NotificationChain msgs)
  {
    GroupMultiplicities oldX4 = x4;
    x4 = newX4;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X4, oldX4, newX4);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX4(GroupMultiplicities newX4)
  {
    if (newX4 != x4)
    {
      NotificationChain msgs = null;
      if (x4 != null)
        msgs = ((InternalEObject)x4).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X4, null, msgs);
      if (newX4 != null)
        msgs = ((InternalEObject)newX4).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X4, null, msgs);
      msgs = basicSetX4(newX4, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X4, newX4, newX4));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlternativeMultiplicities getX5()
  {
    return x5;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX5(AlternativeMultiplicities newX5, NotificationChain msgs)
  {
    AlternativeMultiplicities oldX5 = x5;
    x5 = newX5;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X5, oldX5, newX5);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX5(AlternativeMultiplicities newX5)
  {
    if (newX5 != x5)
    {
      NotificationChain msgs = null;
      if (x5 != null)
        msgs = ((InternalEObject)x5).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X5, null, msgs);
      if (newX5 != null)
        msgs = ((InternalEObject)newX5).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X5, null, msgs);
      msgs = basicSetX5(newX5, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X5, newX5, newX5));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignedAction getX6()
  {
    return x6;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX6(AssignedAction newX6, NotificationChain msgs)
  {
    AssignedAction oldX6 = x6;
    x6 = newX6;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X6, oldX6, newX6);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX6(AssignedAction newX6)
  {
    if (newX6 != x6)
    {
      NotificationChain msgs = null;
      if (x6 != null)
        msgs = ((InternalEObject)x6).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X6, null, msgs);
      if (newX6 != null)
        msgs = ((InternalEObject)newX6).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X6, null, msgs);
      msgs = basicSetX6(newX6, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X6, newX6, newX6));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignedAction getX7()
  {
    return x7;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX7(AssignedAction newX7, NotificationChain msgs)
  {
    AssignedAction oldX7 = x7;
    x7 = newX7;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X7, oldX7, newX7);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX7(AssignedAction newX7)
  {
    if (newX7 != x7)
    {
      NotificationChain msgs = null;
      if (x7 != null)
        msgs = ((InternalEObject)x7).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X7, null, msgs);
      if (newX7 != null)
        msgs = ((InternalEObject)newX7).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X7, null, msgs);
      msgs = basicSetX7(newX7, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X7, newX7, newX7));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedAction1 getX8()
  {
    return x8;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX8(UnassignedAction1 newX8, NotificationChain msgs)
  {
    UnassignedAction1 oldX8 = x8;
    x8 = newX8;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X8, oldX8, newX8);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX8(UnassignedAction1 newX8)
  {
    if (newX8 != x8)
    {
      NotificationChain msgs = null;
      if (x8 != null)
        msgs = ((InternalEObject)x8).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X8, null, msgs);
      if (newX8 != null)
        msgs = ((InternalEObject)newX8).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X8, null, msgs);
      msgs = basicSetX8(newX8, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X8, newX8, newX8));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedAction2 getX9()
  {
    return x9;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX9(UnassignedAction2 newX9, NotificationChain msgs)
  {
    UnassignedAction2 oldX9 = x9;
    x9 = newX9;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X9, oldX9, newX9);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX9(UnassignedAction2 newX9)
  {
    if (newX9 != x9)
    {
      NotificationChain msgs = null;
      if (x9 != null)
        msgs = ((InternalEObject)x9).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X9, null, msgs);
      if (newX9 != null)
        msgs = ((InternalEObject)newX9).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X9, null, msgs);
      msgs = basicSetX9(newX9, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X9, newX9, newX9));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedAction3 getX10()
  {
    return x10;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX10(UnassignedAction3 newX10, NotificationChain msgs)
  {
    UnassignedAction3 oldX10 = x10;
    x10 = newX10;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X10, oldX10, newX10);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX10(UnassignedAction3 newX10)
  {
    if (newX10 != x10)
    {
      NotificationChain msgs = null;
      if (x10 != null)
        msgs = ((InternalEObject)x10).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X10, null, msgs);
      if (newX10 != null)
        msgs = ((InternalEObject)newX10).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X10, null, msgs);
      msgs = basicSetX10(newX10, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X10, newX10, newX10));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedRuleCall1 getX11()
  {
    return x11;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX11(UnassignedRuleCall1 newX11, NotificationChain msgs)
  {
    UnassignedRuleCall1 oldX11 = x11;
    x11 = newX11;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X11, oldX11, newX11);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX11(UnassignedRuleCall1 newX11)
  {
    if (newX11 != x11)
    {
      NotificationChain msgs = null;
      if (x11 != null)
        msgs = ((InternalEObject)x11).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X11, null, msgs);
      if (newX11 != null)
        msgs = ((InternalEObject)newX11).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X11, null, msgs);
      msgs = basicSetX11(newX11, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X11, newX11, newX11));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedRuleCall2 getX12()
  {
    return x12;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX12(UnassignedRuleCall2 newX12, NotificationChain msgs)
  {
    UnassignedRuleCall2 oldX12 = x12;
    x12 = newX12;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X12, oldX12, newX12);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX12(UnassignedRuleCall2 newX12)
  {
    if (newX12 != x12)
    {
      NotificationChain msgs = null;
      if (x12 != null)
        msgs = ((InternalEObject)x12).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X12, null, msgs);
      if (newX12 != null)
        msgs = ((InternalEObject)newX12).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X12, null, msgs);
      msgs = basicSetX12(newX12, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X12, newX12, newX12));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Combination1 getX13()
  {
    return x13;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX13(Combination1 newX13, NotificationChain msgs)
  {
    Combination1 oldX13 = x13;
    x13 = newX13;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X13, oldX13, newX13);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX13(Combination1 newX13)
  {
    if (newX13 != x13)
    {
      NotificationChain msgs = null;
      if (x13 != null)
        msgs = ((InternalEObject)x13).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X13, null, msgs);
      if (newX13 != null)
        msgs = ((InternalEObject)newX13).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X13, null, msgs);
      msgs = basicSetX13(newX13, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X13, newX13, newX13));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Combination2 getX14()
  {
    return x14;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX14(Combination2 newX14, NotificationChain msgs)
  {
    Combination2 oldX14 = x14;
    x14 = newX14;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X14, oldX14, newX14);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX14(Combination2 newX14)
  {
    if (newX14 != x14)
    {
      NotificationChain msgs = null;
      if (x14 != null)
        msgs = ((InternalEObject)x14).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X14, null, msgs);
      if (newX14 != null)
        msgs = ((InternalEObject)newX14).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X14, null, msgs);
      msgs = basicSetX14(newX14, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X14, newX14, newX14));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Combination3 getX15()
  {
    return x15;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX15(Combination3 newX15, NotificationChain msgs)
  {
    Combination3 oldX15 = x15;
    x15 = newX15;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X15, oldX15, newX15);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX15(Combination3 newX15)
  {
    if (newX15 != x15)
    {
      NotificationChain msgs = null;
      if (x15 != null)
        msgs = ((InternalEObject)x15).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X15, null, msgs);
      if (newX15 != null)
        msgs = ((InternalEObject)newX15).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X15, null, msgs);
      msgs = basicSetX15(newX15, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X15, newX15, newX15));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Combination4 getX16()
  {
    return x16;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX16(Combination4 newX16, NotificationChain msgs)
  {
    Combination4 oldX16 = x16;
    x16 = newX16;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X16, oldX16, newX16);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX16(Combination4 newX16)
  {
    if (newX16 != x16)
    {
      NotificationChain msgs = null;
      if (x16 != null)
        msgs = ((InternalEObject)x16).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X16, null, msgs);
      if (newX16 != null)
        msgs = ((InternalEObject)newX16).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X16, null, msgs);
      msgs = basicSetX16(newX16, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X16, newX16, newX16));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List1 getX17()
  {
    return x17;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX17(List1 newX17, NotificationChain msgs)
  {
    List1 oldX17 = x17;
    x17 = newX17;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X17, oldX17, newX17);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX17(List1 newX17)
  {
    if (newX17 != x17)
    {
      NotificationChain msgs = null;
      if (x17 != null)
        msgs = ((InternalEObject)x17).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X17, null, msgs);
      if (newX17 != null)
        msgs = ((InternalEObject)newX17).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X17, null, msgs);
      msgs = basicSetX17(newX17, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X17, newX17, newX17));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List2 getX18()
  {
    return x18;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX18(List2 newX18, NotificationChain msgs)
  {
    List2 oldX18 = x18;
    x18 = newX18;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X18, oldX18, newX18);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX18(List2 newX18)
  {
    if (newX18 != x18)
    {
      NotificationChain msgs = null;
      if (x18 != null)
        msgs = ((InternalEObject)x18).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X18, null, msgs);
      if (newX18 != null)
        msgs = ((InternalEObject)newX18).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X18, null, msgs);
      msgs = basicSetX18(newX18, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X18, newX18, newX18));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List3 getX19()
  {
    return x19;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX19(List3 newX19, NotificationChain msgs)
  {
    List3 oldX19 = x19;
    x19 = newX19;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X19, oldX19, newX19);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX19(List3 newX19)
  {
    if (newX19 != x19)
    {
      NotificationChain msgs = null;
      if (x19 != null)
        msgs = ((InternalEObject)x19).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X19, null, msgs);
      if (newX19 != null)
        msgs = ((InternalEObject)newX19).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X19, null, msgs);
      msgs = basicSetX19(newX19, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X19, newX19, newX19));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List4 getX20()
  {
    return x20;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX20(List4 newX20, NotificationChain msgs)
  {
    List4 oldX20 = x20;
    x20 = newX20;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X20, oldX20, newX20);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX20(List4 newX20)
  {
    if (newX20 != x20)
    {
      NotificationChain msgs = null;
      if (x20 != null)
        msgs = ((InternalEObject)x20).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X20, null, msgs);
      if (newX20 != null)
        msgs = ((InternalEObject)newX20).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X20, null, msgs);
      msgs = basicSetX20(newX20, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X20, newX20, newX20));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List5 getX21()
  {
    return x21;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX21(List5 newX21, NotificationChain msgs)
  {
    List5 oldX21 = x21;
    x21 = newX21;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X21, oldX21, newX21);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX21(List5 newX21)
  {
    if (newX21 != x21)
    {
      NotificationChain msgs = null;
      if (x21 != null)
        msgs = ((InternalEObject)x21).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X21, null, msgs);
      if (newX21 != null)
        msgs = ((InternalEObject)newX21).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X21, null, msgs);
      msgs = basicSetX21(newX21, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X21, newX21, newX21));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AltList1 getX22()
  {
    return x22;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX22(AltList1 newX22, NotificationChain msgs)
  {
    AltList1 oldX22 = x22;
    x22 = newX22;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X22, oldX22, newX22);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX22(AltList1 newX22)
  {
    if (newX22 != x22)
    {
      NotificationChain msgs = null;
      if (x22 != null)
        msgs = ((InternalEObject)x22).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X22, null, msgs);
      if (newX22 != null)
        msgs = ((InternalEObject)newX22).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X22, null, msgs);
      msgs = basicSetX22(newX22, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X22, newX22, newX22));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AltList2 getX23()
  {
    return x23;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX23(AltList2 newX23, NotificationChain msgs)
  {
    AltList2 oldX23 = x23;
    x23 = newX23;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X23, oldX23, newX23);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX23(AltList2 newX23)
  {
    if (newX23 != x23)
    {
      NotificationChain msgs = null;
      if (x23 != null)
        msgs = ((InternalEObject)x23).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X23, null, msgs);
      if (newX23 != null)
        msgs = ((InternalEObject)newX23).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X23, null, msgs);
      msgs = basicSetX23(newX23, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X23, newX23, newX23));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransientObject getX24()
  {
    return x24;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX24(TransientObject newX24, NotificationChain msgs)
  {
    TransientObject oldX24 = x24;
    x24 = newX24;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X24, oldX24, newX24);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX24(TransientObject newX24)
  {
    if (newX24 != x24)
    {
      NotificationChain msgs = null;
      if (x24 != null)
        msgs = ((InternalEObject)x24).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X24, null, msgs);
      if (newX24 != null)
        msgs = ((InternalEObject)newX24).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X24, null, msgs);
      msgs = basicSetX24(newX24, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X24, newX24, newX24));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransientSerializeables1 getX25()
  {
    return x25;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX25(TransientSerializeables1 newX25, NotificationChain msgs)
  {
    TransientSerializeables1 oldX25 = x25;
    x25 = newX25;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X25, oldX25, newX25);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX25(TransientSerializeables1 newX25)
  {
    if (newX25 != x25)
    {
      NotificationChain msgs = null;
      if (x25 != null)
        msgs = ((InternalEObject)x25).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X25, null, msgs);
      if (newX25 != null)
        msgs = ((InternalEObject)newX25).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X25, null, msgs);
      msgs = basicSetX25(newX25, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X25, newX25, newX25));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StaticSimplification getX26()
  {
    return x26;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX26(StaticSimplification newX26, NotificationChain msgs)
  {
    StaticSimplification oldX26 = x26;
    x26 = newX26;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X26, oldX26, newX26);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX26(StaticSimplification newX26)
  {
    if (newX26 != x26)
    {
      NotificationChain msgs = null;
      if (x26 != null)
        msgs = ((InternalEObject)x26).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X26, null, msgs);
      if (newX26 != null)
        msgs = ((InternalEObject)newX26).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X26, null, msgs);
      msgs = basicSetX26(newX26, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X26, newX26, newX26));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TwoVersion getX27()
  {
    return x27;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX27(TwoVersion newX27, NotificationChain msgs)
  {
    TwoVersion oldX27 = x27;
    x27 = newX27;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X27, oldX27, newX27);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX27(TwoVersion newX27)
  {
    if (newX27 != x27)
    {
      NotificationChain msgs = null;
      if (x27 != null)
        msgs = ((InternalEObject)x27).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X27, null, msgs);
      if (newX27 != null)
        msgs = ((InternalEObject)newX27).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X27, null, msgs);
      msgs = basicSetX27(newX27, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X27, newX27, newX27));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Heuristic1 getX28()
  {
    return x28;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX28(Heuristic1 newX28, NotificationChain msgs)
  {
    Heuristic1 oldX28 = x28;
    x28 = newX28;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X28, oldX28, newX28);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX28(Heuristic1 newX28)
  {
    if (newX28 != x28)
    {
      NotificationChain msgs = null;
      if (x28 != null)
        msgs = ((InternalEObject)x28).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X28, null, msgs);
      if (newX28 != null)
        msgs = ((InternalEObject)newX28).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CsvalidationtestPackage.MODEL__X28, null, msgs);
      msgs = basicSetX28(newX28, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CsvalidationtestPackage.MODEL__X28, newX28, newX28));
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
      case CsvalidationtestPackage.MODEL__X1:
        return basicSetX1(null, msgs);
      case CsvalidationtestPackage.MODEL__X2:
        return basicSetX2(null, msgs);
      case CsvalidationtestPackage.MODEL__X3:
        return basicSetX3(null, msgs);
      case CsvalidationtestPackage.MODEL__X4:
        return basicSetX4(null, msgs);
      case CsvalidationtestPackage.MODEL__X5:
        return basicSetX5(null, msgs);
      case CsvalidationtestPackage.MODEL__X6:
        return basicSetX6(null, msgs);
      case CsvalidationtestPackage.MODEL__X7:
        return basicSetX7(null, msgs);
      case CsvalidationtestPackage.MODEL__X8:
        return basicSetX8(null, msgs);
      case CsvalidationtestPackage.MODEL__X9:
        return basicSetX9(null, msgs);
      case CsvalidationtestPackage.MODEL__X10:
        return basicSetX10(null, msgs);
      case CsvalidationtestPackage.MODEL__X11:
        return basicSetX11(null, msgs);
      case CsvalidationtestPackage.MODEL__X12:
        return basicSetX12(null, msgs);
      case CsvalidationtestPackage.MODEL__X13:
        return basicSetX13(null, msgs);
      case CsvalidationtestPackage.MODEL__X14:
        return basicSetX14(null, msgs);
      case CsvalidationtestPackage.MODEL__X15:
        return basicSetX15(null, msgs);
      case CsvalidationtestPackage.MODEL__X16:
        return basicSetX16(null, msgs);
      case CsvalidationtestPackage.MODEL__X17:
        return basicSetX17(null, msgs);
      case CsvalidationtestPackage.MODEL__X18:
        return basicSetX18(null, msgs);
      case CsvalidationtestPackage.MODEL__X19:
        return basicSetX19(null, msgs);
      case CsvalidationtestPackage.MODEL__X20:
        return basicSetX20(null, msgs);
      case CsvalidationtestPackage.MODEL__X21:
        return basicSetX21(null, msgs);
      case CsvalidationtestPackage.MODEL__X22:
        return basicSetX22(null, msgs);
      case CsvalidationtestPackage.MODEL__X23:
        return basicSetX23(null, msgs);
      case CsvalidationtestPackage.MODEL__X24:
        return basicSetX24(null, msgs);
      case CsvalidationtestPackage.MODEL__X25:
        return basicSetX25(null, msgs);
      case CsvalidationtestPackage.MODEL__X26:
        return basicSetX26(null, msgs);
      case CsvalidationtestPackage.MODEL__X27:
        return basicSetX27(null, msgs);
      case CsvalidationtestPackage.MODEL__X28:
        return basicSetX28(null, msgs);
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
      case CsvalidationtestPackage.MODEL__X1:
        return getX1();
      case CsvalidationtestPackage.MODEL__X2:
        return getX2();
      case CsvalidationtestPackage.MODEL__X3:
        return getX3();
      case CsvalidationtestPackage.MODEL__X4:
        return getX4();
      case CsvalidationtestPackage.MODEL__X5:
        return getX5();
      case CsvalidationtestPackage.MODEL__X6:
        return getX6();
      case CsvalidationtestPackage.MODEL__X7:
        return getX7();
      case CsvalidationtestPackage.MODEL__X8:
        return getX8();
      case CsvalidationtestPackage.MODEL__X9:
        return getX9();
      case CsvalidationtestPackage.MODEL__X10:
        return getX10();
      case CsvalidationtestPackage.MODEL__X11:
        return getX11();
      case CsvalidationtestPackage.MODEL__X12:
        return getX12();
      case CsvalidationtestPackage.MODEL__X13:
        return getX13();
      case CsvalidationtestPackage.MODEL__X14:
        return getX14();
      case CsvalidationtestPackage.MODEL__X15:
        return getX15();
      case CsvalidationtestPackage.MODEL__X16:
        return getX16();
      case CsvalidationtestPackage.MODEL__X17:
        return getX17();
      case CsvalidationtestPackage.MODEL__X18:
        return getX18();
      case CsvalidationtestPackage.MODEL__X19:
        return getX19();
      case CsvalidationtestPackage.MODEL__X20:
        return getX20();
      case CsvalidationtestPackage.MODEL__X21:
        return getX21();
      case CsvalidationtestPackage.MODEL__X22:
        return getX22();
      case CsvalidationtestPackage.MODEL__X23:
        return getX23();
      case CsvalidationtestPackage.MODEL__X24:
        return getX24();
      case CsvalidationtestPackage.MODEL__X25:
        return getX25();
      case CsvalidationtestPackage.MODEL__X26:
        return getX26();
      case CsvalidationtestPackage.MODEL__X27:
        return getX27();
      case CsvalidationtestPackage.MODEL__X28:
        return getX28();
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
      case CsvalidationtestPackage.MODEL__X1:
        setX1((SimpleGroup)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X2:
        setX2((SimpleAlternative)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X3:
        setX3((SimpleMultiplicities)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X4:
        setX4((GroupMultiplicities)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X5:
        setX5((AlternativeMultiplicities)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X6:
        setX6((AssignedAction)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X7:
        setX7((AssignedAction)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X8:
        setX8((UnassignedAction1)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X9:
        setX9((UnassignedAction2)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X10:
        setX10((UnassignedAction3)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X11:
        setX11((UnassignedRuleCall1)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X12:
        setX12((UnassignedRuleCall2)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X13:
        setX13((Combination1)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X14:
        setX14((Combination2)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X15:
        setX15((Combination3)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X16:
        setX16((Combination4)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X17:
        setX17((List1)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X18:
        setX18((List2)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X19:
        setX19((List3)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X20:
        setX20((List4)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X21:
        setX21((List5)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X22:
        setX22((AltList1)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X23:
        setX23((AltList2)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X24:
        setX24((TransientObject)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X25:
        setX25((TransientSerializeables1)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X26:
        setX26((StaticSimplification)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X27:
        setX27((TwoVersion)newValue);
        return;
      case CsvalidationtestPackage.MODEL__X28:
        setX28((Heuristic1)newValue);
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
      case CsvalidationtestPackage.MODEL__X1:
        setX1((SimpleGroup)null);
        return;
      case CsvalidationtestPackage.MODEL__X2:
        setX2((SimpleAlternative)null);
        return;
      case CsvalidationtestPackage.MODEL__X3:
        setX3((SimpleMultiplicities)null);
        return;
      case CsvalidationtestPackage.MODEL__X4:
        setX4((GroupMultiplicities)null);
        return;
      case CsvalidationtestPackage.MODEL__X5:
        setX5((AlternativeMultiplicities)null);
        return;
      case CsvalidationtestPackage.MODEL__X6:
        setX6((AssignedAction)null);
        return;
      case CsvalidationtestPackage.MODEL__X7:
        setX7((AssignedAction)null);
        return;
      case CsvalidationtestPackage.MODEL__X8:
        setX8((UnassignedAction1)null);
        return;
      case CsvalidationtestPackage.MODEL__X9:
        setX9((UnassignedAction2)null);
        return;
      case CsvalidationtestPackage.MODEL__X10:
        setX10((UnassignedAction3)null);
        return;
      case CsvalidationtestPackage.MODEL__X11:
        setX11((UnassignedRuleCall1)null);
        return;
      case CsvalidationtestPackage.MODEL__X12:
        setX12((UnassignedRuleCall2)null);
        return;
      case CsvalidationtestPackage.MODEL__X13:
        setX13((Combination1)null);
        return;
      case CsvalidationtestPackage.MODEL__X14:
        setX14((Combination2)null);
        return;
      case CsvalidationtestPackage.MODEL__X15:
        setX15((Combination3)null);
        return;
      case CsvalidationtestPackage.MODEL__X16:
        setX16((Combination4)null);
        return;
      case CsvalidationtestPackage.MODEL__X17:
        setX17((List1)null);
        return;
      case CsvalidationtestPackage.MODEL__X18:
        setX18((List2)null);
        return;
      case CsvalidationtestPackage.MODEL__X19:
        setX19((List3)null);
        return;
      case CsvalidationtestPackage.MODEL__X20:
        setX20((List4)null);
        return;
      case CsvalidationtestPackage.MODEL__X21:
        setX21((List5)null);
        return;
      case CsvalidationtestPackage.MODEL__X22:
        setX22((AltList1)null);
        return;
      case CsvalidationtestPackage.MODEL__X23:
        setX23((AltList2)null);
        return;
      case CsvalidationtestPackage.MODEL__X24:
        setX24((TransientObject)null);
        return;
      case CsvalidationtestPackage.MODEL__X25:
        setX25((TransientSerializeables1)null);
        return;
      case CsvalidationtestPackage.MODEL__X26:
        setX26((StaticSimplification)null);
        return;
      case CsvalidationtestPackage.MODEL__X27:
        setX27((TwoVersion)null);
        return;
      case CsvalidationtestPackage.MODEL__X28:
        setX28((Heuristic1)null);
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
      case CsvalidationtestPackage.MODEL__X1:
        return x1 != null;
      case CsvalidationtestPackage.MODEL__X2:
        return x2 != null;
      case CsvalidationtestPackage.MODEL__X3:
        return x3 != null;
      case CsvalidationtestPackage.MODEL__X4:
        return x4 != null;
      case CsvalidationtestPackage.MODEL__X5:
        return x5 != null;
      case CsvalidationtestPackage.MODEL__X6:
        return x6 != null;
      case CsvalidationtestPackage.MODEL__X7:
        return x7 != null;
      case CsvalidationtestPackage.MODEL__X8:
        return x8 != null;
      case CsvalidationtestPackage.MODEL__X9:
        return x9 != null;
      case CsvalidationtestPackage.MODEL__X10:
        return x10 != null;
      case CsvalidationtestPackage.MODEL__X11:
        return x11 != null;
      case CsvalidationtestPackage.MODEL__X12:
        return x12 != null;
      case CsvalidationtestPackage.MODEL__X13:
        return x13 != null;
      case CsvalidationtestPackage.MODEL__X14:
        return x14 != null;
      case CsvalidationtestPackage.MODEL__X15:
        return x15 != null;
      case CsvalidationtestPackage.MODEL__X16:
        return x16 != null;
      case CsvalidationtestPackage.MODEL__X17:
        return x17 != null;
      case CsvalidationtestPackage.MODEL__X18:
        return x18 != null;
      case CsvalidationtestPackage.MODEL__X19:
        return x19 != null;
      case CsvalidationtestPackage.MODEL__X20:
        return x20 != null;
      case CsvalidationtestPackage.MODEL__X21:
        return x21 != null;
      case CsvalidationtestPackage.MODEL__X22:
        return x22 != null;
      case CsvalidationtestPackage.MODEL__X23:
        return x23 != null;
      case CsvalidationtestPackage.MODEL__X24:
        return x24 != null;
      case CsvalidationtestPackage.MODEL__X25:
        return x25 != null;
      case CsvalidationtestPackage.MODEL__X26:
        return x26 != null;
      case CsvalidationtestPackage.MODEL__X27:
        return x27 != null;
      case CsvalidationtestPackage.MODEL__X28:
        return x28 != null;
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
