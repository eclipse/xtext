/**
 */
package org.eclipse.xtext.serializer.sequencertest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.sequencertest.AltList1;
import org.eclipse.xtext.serializer.sequencertest.AltList2;
import org.eclipse.xtext.serializer.sequencertest.AlternativeMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.Complex1;
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative1;
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative2;
import org.eclipse.xtext.serializer.sequencertest.FragmentCallerType;
import org.eclipse.xtext.serializer.sequencertest.GroupMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.List1;
import org.eclipse.xtext.serializer.sequencertest.List2;
import org.eclipse.xtext.serializer.sequencertest.Model;
import org.eclipse.xtext.serializer.sequencertest.NullCrossRef;
import org.eclipse.xtext.serializer.sequencertest.NullValue;
import org.eclipse.xtext.serializer.sequencertest.Optional;
import org.eclipse.xtext.serializer.sequencertest.OptionalDouble;
import org.eclipse.xtext.serializer.sequencertest.ParameterCaller;
import org.eclipse.xtext.serializer.sequencertest.ParameterDelegation;
import org.eclipse.xtext.serializer.sequencertest.SequencertestPackage;
import org.eclipse.xtext.serializer.sequencertest.SimpleAlternative;
import org.eclipse.xtext.serializer.sequencertest.SimpleGroup;
import org.eclipse.xtext.serializer.sequencertest.SimpleMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReference;
import org.eclipse.xtext.serializer.sequencertest.SingleCrossReference;
import org.eclipse.xtext.serializer.sequencertest.SingleEnum;
import org.eclipse.xtext.serializer.sequencertest.UnorderedAlternative;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroup;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupBoolean;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupOptional;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX1 <em>X1</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX2 <em>X2</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX3 <em>X3</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX4 <em>X4</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX5 <em>X5</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX6 <em>X6</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX7 <em>X7</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX8 <em>X8</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX9 <em>X9</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX10 <em>X10</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX11 <em>X11</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX12 <em>X12</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX13 <em>X13</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX14 <em>X14</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX15 <em>X15</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX19 <em>X19</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX20 <em>X20</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX21 <em>X21</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX22 <em>X22</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX23 <em>X23</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX24 <em>X24</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX25 <em>X25</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX26 <em>X26</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX27 <em>X27</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX28 <em>X28</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX29 <em>X29</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX30 <em>X30</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX31 <em>X31</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX32 <em>X32</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX33 <em>X33</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX34 <em>X34</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.ModelImpl#getX35 <em>X35</em>}</li>
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
  protected List1 x6;

  /**
   * The cached value of the '{@link #getX7() <em>X7</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX7()
   * @generated
   * @ordered
   */
  protected List2 x7;

  /**
   * The cached value of the '{@link #getX8() <em>X8</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX8()
   * @generated
   * @ordered
   */
  protected AltList1 x8;

  /**
   * The cached value of the '{@link #getX9() <em>X9</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX9()
   * @generated
   * @ordered
   */
  protected AltList2 x9;

  /**
   * The cached value of the '{@link #getX10() <em>X10</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX10()
   * @generated
   * @ordered
   */
  protected EObject x10;

  /**
   * The cached value of the '{@link #getX11() <em>X11</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX11()
   * @generated
   * @ordered
   */
  protected EObject x11;

  /**
   * The cached value of the '{@link #getX12() <em>X12</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX12()
   * @generated
   * @ordered
   */
  protected EObject x12;

  /**
   * The cached value of the '{@link #getX13() <em>X13</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX13()
   * @generated
   * @ordered
   */
  protected SingleEnum x13;

  /**
   * The cached value of the '{@link #getX14() <em>X14</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX14()
   * @generated
   * @ordered
   */
  protected SingleCrossReference x14;

  /**
   * The cached value of the '{@link #getX15() <em>X15</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX15()
   * @generated
   * @ordered
   */
  protected SingleContainmentReference x15;

  /**
   * The cached value of the '{@link #getX19() <em>X19</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX19()
   * @generated
   * @ordered
   */
  protected DependentAlternative1 x19;

  /**
   * The cached value of the '{@link #getX20() <em>X20</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX20()
   * @generated
   * @ordered
   */
  protected DependentAlternative2 x20;

  /**
   * The cached value of the '{@link #getX21() <em>X21</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX21()
   * @generated
   * @ordered
   */
  protected Optional x21;

  /**
   * The cached value of the '{@link #getX22() <em>X22</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX22()
   * @generated
   * @ordered
   */
  protected org.eclipse.xtext.serializer.sequencertest.Float x22;

  /**
   * The cached value of the '{@link #getX23() <em>X23</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX23()
   * @generated
   * @ordered
   */
  protected UnorderedAlternative x23;

  /**
   * The cached value of the '{@link #getX24() <em>X24</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX24()
   * @generated
   * @ordered
   */
  protected UnorderedGroup x24;

  /**
   * The cached value of the '{@link #getX25() <em>X25</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX25()
   * @generated
   * @ordered
   */
  protected UnorderedGroupOptional x25;

  /**
   * The cached value of the '{@link #getX26() <em>X26</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX26()
   * @generated
   * @ordered
   */
  protected UnorderedGroupBoolean x26;

  /**
   * The cached value of the '{@link #getX27() <em>X27</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX27()
   * @generated
   * @ordered
   */
  protected Complex1 x27;

  /**
   * The cached value of the '{@link #getX28() <em>X28</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX28()
   * @generated
   * @ordered
   */
  protected OptionalDouble x28;

  /**
   * The cached value of the '{@link #getX29() <em>X29</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX29()
   * @generated
   * @ordered
   */
  protected NullValue x29;

  /**
   * The cached value of the '{@link #getX30() <em>X30</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX30()
   * @generated
   * @ordered
   */
  protected NullValue x30;

  /**
   * The cached value of the '{@link #getX31() <em>X31</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX31()
   * @generated
   * @ordered
   */
  protected NullCrossRef x31;

  /**
   * The cached value of the '{@link #getX32() <em>X32</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX32()
   * @generated
   * @ordered
   */
  protected NullCrossRef x32;

  /**
   * The cached value of the '{@link #getX33() <em>X33</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX33()
   * @generated
   * @ordered
   */
  protected FragmentCallerType x33;

  /**
   * The cached value of the '{@link #getX34() <em>X34</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX34()
   * @generated
   * @ordered
   */
  protected ParameterCaller x34;

  /**
   * The cached value of the '{@link #getX35() <em>X35</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX35()
   * @generated
   * @ordered
   */
  protected ParameterDelegation x35;

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
    return SequencertestPackage.Literals.MODEL;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X1, oldX1, newX1);
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
        msgs = ((InternalEObject)x1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X1, null, msgs);
      if (newX1 != null)
        msgs = ((InternalEObject)newX1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X1, null, msgs);
      msgs = basicSetX1(newX1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X1, newX1, newX1));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X2, oldX2, newX2);
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
        msgs = ((InternalEObject)x2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X2, null, msgs);
      if (newX2 != null)
        msgs = ((InternalEObject)newX2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X2, null, msgs);
      msgs = basicSetX2(newX2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X2, newX2, newX2));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X3, oldX3, newX3);
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
        msgs = ((InternalEObject)x3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X3, null, msgs);
      if (newX3 != null)
        msgs = ((InternalEObject)newX3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X3, null, msgs);
      msgs = basicSetX3(newX3, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X3, newX3, newX3));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X4, oldX4, newX4);
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
        msgs = ((InternalEObject)x4).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X4, null, msgs);
      if (newX4 != null)
        msgs = ((InternalEObject)newX4).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X4, null, msgs);
      msgs = basicSetX4(newX4, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X4, newX4, newX4));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X5, oldX5, newX5);
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
        msgs = ((InternalEObject)x5).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X5, null, msgs);
      if (newX5 != null)
        msgs = ((InternalEObject)newX5).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X5, null, msgs);
      msgs = basicSetX5(newX5, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X5, newX5, newX5));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List1 getX6()
  {
    return x6;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX6(List1 newX6, NotificationChain msgs)
  {
    List1 oldX6 = x6;
    x6 = newX6;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X6, oldX6, newX6);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX6(List1 newX6)
  {
    if (newX6 != x6)
    {
      NotificationChain msgs = null;
      if (x6 != null)
        msgs = ((InternalEObject)x6).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X6, null, msgs);
      if (newX6 != null)
        msgs = ((InternalEObject)newX6).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X6, null, msgs);
      msgs = basicSetX6(newX6, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X6, newX6, newX6));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List2 getX7()
  {
    return x7;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX7(List2 newX7, NotificationChain msgs)
  {
    List2 oldX7 = x7;
    x7 = newX7;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X7, oldX7, newX7);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX7(List2 newX7)
  {
    if (newX7 != x7)
    {
      NotificationChain msgs = null;
      if (x7 != null)
        msgs = ((InternalEObject)x7).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X7, null, msgs);
      if (newX7 != null)
        msgs = ((InternalEObject)newX7).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X7, null, msgs);
      msgs = basicSetX7(newX7, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X7, newX7, newX7));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AltList1 getX8()
  {
    return x8;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX8(AltList1 newX8, NotificationChain msgs)
  {
    AltList1 oldX8 = x8;
    x8 = newX8;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X8, oldX8, newX8);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX8(AltList1 newX8)
  {
    if (newX8 != x8)
    {
      NotificationChain msgs = null;
      if (x8 != null)
        msgs = ((InternalEObject)x8).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X8, null, msgs);
      if (newX8 != null)
        msgs = ((InternalEObject)newX8).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X8, null, msgs);
      msgs = basicSetX8(newX8, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X8, newX8, newX8));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AltList2 getX9()
  {
    return x9;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX9(AltList2 newX9, NotificationChain msgs)
  {
    AltList2 oldX9 = x9;
    x9 = newX9;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X9, oldX9, newX9);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX9(AltList2 newX9)
  {
    if (newX9 != x9)
    {
      NotificationChain msgs = null;
      if (x9 != null)
        msgs = ((InternalEObject)x9).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X9, null, msgs);
      if (newX9 != null)
        msgs = ((InternalEObject)newX9).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X9, null, msgs);
      msgs = basicSetX9(newX9, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X9, newX9, newX9));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getX10()
  {
    return x10;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX10(EObject newX10, NotificationChain msgs)
  {
    EObject oldX10 = x10;
    x10 = newX10;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X10, oldX10, newX10);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX10(EObject newX10)
  {
    if (newX10 != x10)
    {
      NotificationChain msgs = null;
      if (x10 != null)
        msgs = ((InternalEObject)x10).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X10, null, msgs);
      if (newX10 != null)
        msgs = ((InternalEObject)newX10).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X10, null, msgs);
      msgs = basicSetX10(newX10, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X10, newX10, newX10));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getX11()
  {
    return x11;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX11(EObject newX11, NotificationChain msgs)
  {
    EObject oldX11 = x11;
    x11 = newX11;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X11, oldX11, newX11);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX11(EObject newX11)
  {
    if (newX11 != x11)
    {
      NotificationChain msgs = null;
      if (x11 != null)
        msgs = ((InternalEObject)x11).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X11, null, msgs);
      if (newX11 != null)
        msgs = ((InternalEObject)newX11).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X11, null, msgs);
      msgs = basicSetX11(newX11, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X11, newX11, newX11));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getX12()
  {
    return x12;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX12(EObject newX12, NotificationChain msgs)
  {
    EObject oldX12 = x12;
    x12 = newX12;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X12, oldX12, newX12);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX12(EObject newX12)
  {
    if (newX12 != x12)
    {
      NotificationChain msgs = null;
      if (x12 != null)
        msgs = ((InternalEObject)x12).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X12, null, msgs);
      if (newX12 != null)
        msgs = ((InternalEObject)newX12).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X12, null, msgs);
      msgs = basicSetX12(newX12, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X12, newX12, newX12));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleEnum getX13()
  {
    return x13;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX13(SingleEnum newX13, NotificationChain msgs)
  {
    SingleEnum oldX13 = x13;
    x13 = newX13;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X13, oldX13, newX13);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX13(SingleEnum newX13)
  {
    if (newX13 != x13)
    {
      NotificationChain msgs = null;
      if (x13 != null)
        msgs = ((InternalEObject)x13).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X13, null, msgs);
      if (newX13 != null)
        msgs = ((InternalEObject)newX13).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X13, null, msgs);
      msgs = basicSetX13(newX13, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X13, newX13, newX13));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleCrossReference getX14()
  {
    return x14;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX14(SingleCrossReference newX14, NotificationChain msgs)
  {
    SingleCrossReference oldX14 = x14;
    x14 = newX14;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X14, oldX14, newX14);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX14(SingleCrossReference newX14)
  {
    if (newX14 != x14)
    {
      NotificationChain msgs = null;
      if (x14 != null)
        msgs = ((InternalEObject)x14).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X14, null, msgs);
      if (newX14 != null)
        msgs = ((InternalEObject)newX14).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X14, null, msgs);
      msgs = basicSetX14(newX14, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X14, newX14, newX14));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleContainmentReference getX15()
  {
    return x15;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX15(SingleContainmentReference newX15, NotificationChain msgs)
  {
    SingleContainmentReference oldX15 = x15;
    x15 = newX15;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X15, oldX15, newX15);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX15(SingleContainmentReference newX15)
  {
    if (newX15 != x15)
    {
      NotificationChain msgs = null;
      if (x15 != null)
        msgs = ((InternalEObject)x15).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X15, null, msgs);
      if (newX15 != null)
        msgs = ((InternalEObject)newX15).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X15, null, msgs);
      msgs = basicSetX15(newX15, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X15, newX15, newX15));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DependentAlternative1 getX19()
  {
    return x19;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX19(DependentAlternative1 newX19, NotificationChain msgs)
  {
    DependentAlternative1 oldX19 = x19;
    x19 = newX19;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X19, oldX19, newX19);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX19(DependentAlternative1 newX19)
  {
    if (newX19 != x19)
    {
      NotificationChain msgs = null;
      if (x19 != null)
        msgs = ((InternalEObject)x19).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X19, null, msgs);
      if (newX19 != null)
        msgs = ((InternalEObject)newX19).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X19, null, msgs);
      msgs = basicSetX19(newX19, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X19, newX19, newX19));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DependentAlternative2 getX20()
  {
    return x20;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX20(DependentAlternative2 newX20, NotificationChain msgs)
  {
    DependentAlternative2 oldX20 = x20;
    x20 = newX20;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X20, oldX20, newX20);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX20(DependentAlternative2 newX20)
  {
    if (newX20 != x20)
    {
      NotificationChain msgs = null;
      if (x20 != null)
        msgs = ((InternalEObject)x20).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X20, null, msgs);
      if (newX20 != null)
        msgs = ((InternalEObject)newX20).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X20, null, msgs);
      msgs = basicSetX20(newX20, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X20, newX20, newX20));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Optional getX21()
  {
    return x21;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX21(Optional newX21, NotificationChain msgs)
  {
    Optional oldX21 = x21;
    x21 = newX21;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X21, oldX21, newX21);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX21(Optional newX21)
  {
    if (newX21 != x21)
    {
      NotificationChain msgs = null;
      if (x21 != null)
        msgs = ((InternalEObject)x21).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X21, null, msgs);
      if (newX21 != null)
        msgs = ((InternalEObject)newX21).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X21, null, msgs);
      msgs = basicSetX21(newX21, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X21, newX21, newX21));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.xtext.serializer.sequencertest.Float getX22()
  {
    return x22;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX22(org.eclipse.xtext.serializer.sequencertest.Float newX22, NotificationChain msgs)
  {
    org.eclipse.xtext.serializer.sequencertest.Float oldX22 = x22;
    x22 = newX22;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X22, oldX22, newX22);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX22(org.eclipse.xtext.serializer.sequencertest.Float newX22)
  {
    if (newX22 != x22)
    {
      NotificationChain msgs = null;
      if (x22 != null)
        msgs = ((InternalEObject)x22).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X22, null, msgs);
      if (newX22 != null)
        msgs = ((InternalEObject)newX22).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X22, null, msgs);
      msgs = basicSetX22(newX22, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X22, newX22, newX22));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedAlternative getX23()
  {
    return x23;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX23(UnorderedAlternative newX23, NotificationChain msgs)
  {
    UnorderedAlternative oldX23 = x23;
    x23 = newX23;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X23, oldX23, newX23);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX23(UnorderedAlternative newX23)
  {
    if (newX23 != x23)
    {
      NotificationChain msgs = null;
      if (x23 != null)
        msgs = ((InternalEObject)x23).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X23, null, msgs);
      if (newX23 != null)
        msgs = ((InternalEObject)newX23).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X23, null, msgs);
      msgs = basicSetX23(newX23, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X23, newX23, newX23));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedGroup getX24()
  {
    return x24;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX24(UnorderedGroup newX24, NotificationChain msgs)
  {
    UnorderedGroup oldX24 = x24;
    x24 = newX24;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X24, oldX24, newX24);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX24(UnorderedGroup newX24)
  {
    if (newX24 != x24)
    {
      NotificationChain msgs = null;
      if (x24 != null)
        msgs = ((InternalEObject)x24).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X24, null, msgs);
      if (newX24 != null)
        msgs = ((InternalEObject)newX24).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X24, null, msgs);
      msgs = basicSetX24(newX24, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X24, newX24, newX24));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedGroupOptional getX25()
  {
    return x25;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX25(UnorderedGroupOptional newX25, NotificationChain msgs)
  {
    UnorderedGroupOptional oldX25 = x25;
    x25 = newX25;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X25, oldX25, newX25);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX25(UnorderedGroupOptional newX25)
  {
    if (newX25 != x25)
    {
      NotificationChain msgs = null;
      if (x25 != null)
        msgs = ((InternalEObject)x25).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X25, null, msgs);
      if (newX25 != null)
        msgs = ((InternalEObject)newX25).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X25, null, msgs);
      msgs = basicSetX25(newX25, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X25, newX25, newX25));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedGroupBoolean getX26()
  {
    return x26;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX26(UnorderedGroupBoolean newX26, NotificationChain msgs)
  {
    UnorderedGroupBoolean oldX26 = x26;
    x26 = newX26;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X26, oldX26, newX26);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX26(UnorderedGroupBoolean newX26)
  {
    if (newX26 != x26)
    {
      NotificationChain msgs = null;
      if (x26 != null)
        msgs = ((InternalEObject)x26).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X26, null, msgs);
      if (newX26 != null)
        msgs = ((InternalEObject)newX26).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X26, null, msgs);
      msgs = basicSetX26(newX26, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X26, newX26, newX26));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Complex1 getX27()
  {
    return x27;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX27(Complex1 newX27, NotificationChain msgs)
  {
    Complex1 oldX27 = x27;
    x27 = newX27;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X27, oldX27, newX27);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX27(Complex1 newX27)
  {
    if (newX27 != x27)
    {
      NotificationChain msgs = null;
      if (x27 != null)
        msgs = ((InternalEObject)x27).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X27, null, msgs);
      if (newX27 != null)
        msgs = ((InternalEObject)newX27).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X27, null, msgs);
      msgs = basicSetX27(newX27, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X27, newX27, newX27));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptionalDouble getX28()
  {
    return x28;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX28(OptionalDouble newX28, NotificationChain msgs)
  {
    OptionalDouble oldX28 = x28;
    x28 = newX28;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X28, oldX28, newX28);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX28(OptionalDouble newX28)
  {
    if (newX28 != x28)
    {
      NotificationChain msgs = null;
      if (x28 != null)
        msgs = ((InternalEObject)x28).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X28, null, msgs);
      if (newX28 != null)
        msgs = ((InternalEObject)newX28).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X28, null, msgs);
      msgs = basicSetX28(newX28, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X28, newX28, newX28));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NullValue getX29()
  {
    return x29;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX29(NullValue newX29, NotificationChain msgs)
  {
    NullValue oldX29 = x29;
    x29 = newX29;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X29, oldX29, newX29);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX29(NullValue newX29)
  {
    if (newX29 != x29)
    {
      NotificationChain msgs = null;
      if (x29 != null)
        msgs = ((InternalEObject)x29).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X29, null, msgs);
      if (newX29 != null)
        msgs = ((InternalEObject)newX29).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X29, null, msgs);
      msgs = basicSetX29(newX29, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X29, newX29, newX29));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NullValue getX30()
  {
    return x30;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX30(NullValue newX30, NotificationChain msgs)
  {
    NullValue oldX30 = x30;
    x30 = newX30;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X30, oldX30, newX30);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX30(NullValue newX30)
  {
    if (newX30 != x30)
    {
      NotificationChain msgs = null;
      if (x30 != null)
        msgs = ((InternalEObject)x30).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X30, null, msgs);
      if (newX30 != null)
        msgs = ((InternalEObject)newX30).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X30, null, msgs);
      msgs = basicSetX30(newX30, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X30, newX30, newX30));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NullCrossRef getX31()
  {
    return x31;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX31(NullCrossRef newX31, NotificationChain msgs)
  {
    NullCrossRef oldX31 = x31;
    x31 = newX31;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X31, oldX31, newX31);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX31(NullCrossRef newX31)
  {
    if (newX31 != x31)
    {
      NotificationChain msgs = null;
      if (x31 != null)
        msgs = ((InternalEObject)x31).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X31, null, msgs);
      if (newX31 != null)
        msgs = ((InternalEObject)newX31).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X31, null, msgs);
      msgs = basicSetX31(newX31, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X31, newX31, newX31));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NullCrossRef getX32()
  {
    return x32;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX32(NullCrossRef newX32, NotificationChain msgs)
  {
    NullCrossRef oldX32 = x32;
    x32 = newX32;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X32, oldX32, newX32);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX32(NullCrossRef newX32)
  {
    if (newX32 != x32)
    {
      NotificationChain msgs = null;
      if (x32 != null)
        msgs = ((InternalEObject)x32).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X32, null, msgs);
      if (newX32 != null)
        msgs = ((InternalEObject)newX32).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X32, null, msgs);
      msgs = basicSetX32(newX32, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X32, newX32, newX32));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FragmentCallerType getX33()
  {
    return x33;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX33(FragmentCallerType newX33, NotificationChain msgs)
  {
    FragmentCallerType oldX33 = x33;
    x33 = newX33;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X33, oldX33, newX33);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX33(FragmentCallerType newX33)
  {
    if (newX33 != x33)
    {
      NotificationChain msgs = null;
      if (x33 != null)
        msgs = ((InternalEObject)x33).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X33, null, msgs);
      if (newX33 != null)
        msgs = ((InternalEObject)newX33).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X33, null, msgs);
      msgs = basicSetX33(newX33, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X33, newX33, newX33));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterCaller getX34()
  {
    return x34;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX34(ParameterCaller newX34, NotificationChain msgs)
  {
    ParameterCaller oldX34 = x34;
    x34 = newX34;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X34, oldX34, newX34);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX34(ParameterCaller newX34)
  {
    if (newX34 != x34)
    {
      NotificationChain msgs = null;
      if (x34 != null)
        msgs = ((InternalEObject)x34).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X34, null, msgs);
      if (newX34 != null)
        msgs = ((InternalEObject)newX34).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X34, null, msgs);
      msgs = basicSetX34(newX34, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X34, newX34, newX34));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterDelegation getX35()
  {
    return x35;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX35(ParameterDelegation newX35, NotificationChain msgs)
  {
    ParameterDelegation oldX35 = x35;
    x35 = newX35;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X35, oldX35, newX35);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX35(ParameterDelegation newX35)
  {
    if (newX35 != x35)
    {
      NotificationChain msgs = null;
      if (x35 != null)
        msgs = ((InternalEObject)x35).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X35, null, msgs);
      if (newX35 != null)
        msgs = ((InternalEObject)newX35).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.MODEL__X35, null, msgs);
      msgs = basicSetX35(newX35, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.MODEL__X35, newX35, newX35));
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
      case SequencertestPackage.MODEL__X1:
        return basicSetX1(null, msgs);
      case SequencertestPackage.MODEL__X2:
        return basicSetX2(null, msgs);
      case SequencertestPackage.MODEL__X3:
        return basicSetX3(null, msgs);
      case SequencertestPackage.MODEL__X4:
        return basicSetX4(null, msgs);
      case SequencertestPackage.MODEL__X5:
        return basicSetX5(null, msgs);
      case SequencertestPackage.MODEL__X6:
        return basicSetX6(null, msgs);
      case SequencertestPackage.MODEL__X7:
        return basicSetX7(null, msgs);
      case SequencertestPackage.MODEL__X8:
        return basicSetX8(null, msgs);
      case SequencertestPackage.MODEL__X9:
        return basicSetX9(null, msgs);
      case SequencertestPackage.MODEL__X10:
        return basicSetX10(null, msgs);
      case SequencertestPackage.MODEL__X11:
        return basicSetX11(null, msgs);
      case SequencertestPackage.MODEL__X12:
        return basicSetX12(null, msgs);
      case SequencertestPackage.MODEL__X13:
        return basicSetX13(null, msgs);
      case SequencertestPackage.MODEL__X14:
        return basicSetX14(null, msgs);
      case SequencertestPackage.MODEL__X15:
        return basicSetX15(null, msgs);
      case SequencertestPackage.MODEL__X19:
        return basicSetX19(null, msgs);
      case SequencertestPackage.MODEL__X20:
        return basicSetX20(null, msgs);
      case SequencertestPackage.MODEL__X21:
        return basicSetX21(null, msgs);
      case SequencertestPackage.MODEL__X22:
        return basicSetX22(null, msgs);
      case SequencertestPackage.MODEL__X23:
        return basicSetX23(null, msgs);
      case SequencertestPackage.MODEL__X24:
        return basicSetX24(null, msgs);
      case SequencertestPackage.MODEL__X25:
        return basicSetX25(null, msgs);
      case SequencertestPackage.MODEL__X26:
        return basicSetX26(null, msgs);
      case SequencertestPackage.MODEL__X27:
        return basicSetX27(null, msgs);
      case SequencertestPackage.MODEL__X28:
        return basicSetX28(null, msgs);
      case SequencertestPackage.MODEL__X29:
        return basicSetX29(null, msgs);
      case SequencertestPackage.MODEL__X30:
        return basicSetX30(null, msgs);
      case SequencertestPackage.MODEL__X31:
        return basicSetX31(null, msgs);
      case SequencertestPackage.MODEL__X32:
        return basicSetX32(null, msgs);
      case SequencertestPackage.MODEL__X33:
        return basicSetX33(null, msgs);
      case SequencertestPackage.MODEL__X34:
        return basicSetX34(null, msgs);
      case SequencertestPackage.MODEL__X35:
        return basicSetX35(null, msgs);
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
      case SequencertestPackage.MODEL__X1:
        return getX1();
      case SequencertestPackage.MODEL__X2:
        return getX2();
      case SequencertestPackage.MODEL__X3:
        return getX3();
      case SequencertestPackage.MODEL__X4:
        return getX4();
      case SequencertestPackage.MODEL__X5:
        return getX5();
      case SequencertestPackage.MODEL__X6:
        return getX6();
      case SequencertestPackage.MODEL__X7:
        return getX7();
      case SequencertestPackage.MODEL__X8:
        return getX8();
      case SequencertestPackage.MODEL__X9:
        return getX9();
      case SequencertestPackage.MODEL__X10:
        return getX10();
      case SequencertestPackage.MODEL__X11:
        return getX11();
      case SequencertestPackage.MODEL__X12:
        return getX12();
      case SequencertestPackage.MODEL__X13:
        return getX13();
      case SequencertestPackage.MODEL__X14:
        return getX14();
      case SequencertestPackage.MODEL__X15:
        return getX15();
      case SequencertestPackage.MODEL__X19:
        return getX19();
      case SequencertestPackage.MODEL__X20:
        return getX20();
      case SequencertestPackage.MODEL__X21:
        return getX21();
      case SequencertestPackage.MODEL__X22:
        return getX22();
      case SequencertestPackage.MODEL__X23:
        return getX23();
      case SequencertestPackage.MODEL__X24:
        return getX24();
      case SequencertestPackage.MODEL__X25:
        return getX25();
      case SequencertestPackage.MODEL__X26:
        return getX26();
      case SequencertestPackage.MODEL__X27:
        return getX27();
      case SequencertestPackage.MODEL__X28:
        return getX28();
      case SequencertestPackage.MODEL__X29:
        return getX29();
      case SequencertestPackage.MODEL__X30:
        return getX30();
      case SequencertestPackage.MODEL__X31:
        return getX31();
      case SequencertestPackage.MODEL__X32:
        return getX32();
      case SequencertestPackage.MODEL__X33:
        return getX33();
      case SequencertestPackage.MODEL__X34:
        return getX34();
      case SequencertestPackage.MODEL__X35:
        return getX35();
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
      case SequencertestPackage.MODEL__X1:
        setX1((SimpleGroup)newValue);
        return;
      case SequencertestPackage.MODEL__X2:
        setX2((SimpleAlternative)newValue);
        return;
      case SequencertestPackage.MODEL__X3:
        setX3((SimpleMultiplicities)newValue);
        return;
      case SequencertestPackage.MODEL__X4:
        setX4((GroupMultiplicities)newValue);
        return;
      case SequencertestPackage.MODEL__X5:
        setX5((AlternativeMultiplicities)newValue);
        return;
      case SequencertestPackage.MODEL__X6:
        setX6((List1)newValue);
        return;
      case SequencertestPackage.MODEL__X7:
        setX7((List2)newValue);
        return;
      case SequencertestPackage.MODEL__X8:
        setX8((AltList1)newValue);
        return;
      case SequencertestPackage.MODEL__X9:
        setX9((AltList2)newValue);
        return;
      case SequencertestPackage.MODEL__X10:
        setX10((EObject)newValue);
        return;
      case SequencertestPackage.MODEL__X11:
        setX11((EObject)newValue);
        return;
      case SequencertestPackage.MODEL__X12:
        setX12((EObject)newValue);
        return;
      case SequencertestPackage.MODEL__X13:
        setX13((SingleEnum)newValue);
        return;
      case SequencertestPackage.MODEL__X14:
        setX14((SingleCrossReference)newValue);
        return;
      case SequencertestPackage.MODEL__X15:
        setX15((SingleContainmentReference)newValue);
        return;
      case SequencertestPackage.MODEL__X19:
        setX19((DependentAlternative1)newValue);
        return;
      case SequencertestPackage.MODEL__X20:
        setX20((DependentAlternative2)newValue);
        return;
      case SequencertestPackage.MODEL__X21:
        setX21((Optional)newValue);
        return;
      case SequencertestPackage.MODEL__X22:
        setX22((org.eclipse.xtext.serializer.sequencertest.Float)newValue);
        return;
      case SequencertestPackage.MODEL__X23:
        setX23((UnorderedAlternative)newValue);
        return;
      case SequencertestPackage.MODEL__X24:
        setX24((UnorderedGroup)newValue);
        return;
      case SequencertestPackage.MODEL__X25:
        setX25((UnorderedGroupOptional)newValue);
        return;
      case SequencertestPackage.MODEL__X26:
        setX26((UnorderedGroupBoolean)newValue);
        return;
      case SequencertestPackage.MODEL__X27:
        setX27((Complex1)newValue);
        return;
      case SequencertestPackage.MODEL__X28:
        setX28((OptionalDouble)newValue);
        return;
      case SequencertestPackage.MODEL__X29:
        setX29((NullValue)newValue);
        return;
      case SequencertestPackage.MODEL__X30:
        setX30((NullValue)newValue);
        return;
      case SequencertestPackage.MODEL__X31:
        setX31((NullCrossRef)newValue);
        return;
      case SequencertestPackage.MODEL__X32:
        setX32((NullCrossRef)newValue);
        return;
      case SequencertestPackage.MODEL__X33:
        setX33((FragmentCallerType)newValue);
        return;
      case SequencertestPackage.MODEL__X34:
        setX34((ParameterCaller)newValue);
        return;
      case SequencertestPackage.MODEL__X35:
        setX35((ParameterDelegation)newValue);
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
      case SequencertestPackage.MODEL__X1:
        setX1((SimpleGroup)null);
        return;
      case SequencertestPackage.MODEL__X2:
        setX2((SimpleAlternative)null);
        return;
      case SequencertestPackage.MODEL__X3:
        setX3((SimpleMultiplicities)null);
        return;
      case SequencertestPackage.MODEL__X4:
        setX4((GroupMultiplicities)null);
        return;
      case SequencertestPackage.MODEL__X5:
        setX5((AlternativeMultiplicities)null);
        return;
      case SequencertestPackage.MODEL__X6:
        setX6((List1)null);
        return;
      case SequencertestPackage.MODEL__X7:
        setX7((List2)null);
        return;
      case SequencertestPackage.MODEL__X8:
        setX8((AltList1)null);
        return;
      case SequencertestPackage.MODEL__X9:
        setX9((AltList2)null);
        return;
      case SequencertestPackage.MODEL__X10:
        setX10((EObject)null);
        return;
      case SequencertestPackage.MODEL__X11:
        setX11((EObject)null);
        return;
      case SequencertestPackage.MODEL__X12:
        setX12((EObject)null);
        return;
      case SequencertestPackage.MODEL__X13:
        setX13((SingleEnum)null);
        return;
      case SequencertestPackage.MODEL__X14:
        setX14((SingleCrossReference)null);
        return;
      case SequencertestPackage.MODEL__X15:
        setX15((SingleContainmentReference)null);
        return;
      case SequencertestPackage.MODEL__X19:
        setX19((DependentAlternative1)null);
        return;
      case SequencertestPackage.MODEL__X20:
        setX20((DependentAlternative2)null);
        return;
      case SequencertestPackage.MODEL__X21:
        setX21((Optional)null);
        return;
      case SequencertestPackage.MODEL__X22:
        setX22((org.eclipse.xtext.serializer.sequencertest.Float)null);
        return;
      case SequencertestPackage.MODEL__X23:
        setX23((UnorderedAlternative)null);
        return;
      case SequencertestPackage.MODEL__X24:
        setX24((UnorderedGroup)null);
        return;
      case SequencertestPackage.MODEL__X25:
        setX25((UnorderedGroupOptional)null);
        return;
      case SequencertestPackage.MODEL__X26:
        setX26((UnorderedGroupBoolean)null);
        return;
      case SequencertestPackage.MODEL__X27:
        setX27((Complex1)null);
        return;
      case SequencertestPackage.MODEL__X28:
        setX28((OptionalDouble)null);
        return;
      case SequencertestPackage.MODEL__X29:
        setX29((NullValue)null);
        return;
      case SequencertestPackage.MODEL__X30:
        setX30((NullValue)null);
        return;
      case SequencertestPackage.MODEL__X31:
        setX31((NullCrossRef)null);
        return;
      case SequencertestPackage.MODEL__X32:
        setX32((NullCrossRef)null);
        return;
      case SequencertestPackage.MODEL__X33:
        setX33((FragmentCallerType)null);
        return;
      case SequencertestPackage.MODEL__X34:
        setX34((ParameterCaller)null);
        return;
      case SequencertestPackage.MODEL__X35:
        setX35((ParameterDelegation)null);
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
      case SequencertestPackage.MODEL__X1:
        return x1 != null;
      case SequencertestPackage.MODEL__X2:
        return x2 != null;
      case SequencertestPackage.MODEL__X3:
        return x3 != null;
      case SequencertestPackage.MODEL__X4:
        return x4 != null;
      case SequencertestPackage.MODEL__X5:
        return x5 != null;
      case SequencertestPackage.MODEL__X6:
        return x6 != null;
      case SequencertestPackage.MODEL__X7:
        return x7 != null;
      case SequencertestPackage.MODEL__X8:
        return x8 != null;
      case SequencertestPackage.MODEL__X9:
        return x9 != null;
      case SequencertestPackage.MODEL__X10:
        return x10 != null;
      case SequencertestPackage.MODEL__X11:
        return x11 != null;
      case SequencertestPackage.MODEL__X12:
        return x12 != null;
      case SequencertestPackage.MODEL__X13:
        return x13 != null;
      case SequencertestPackage.MODEL__X14:
        return x14 != null;
      case SequencertestPackage.MODEL__X15:
        return x15 != null;
      case SequencertestPackage.MODEL__X19:
        return x19 != null;
      case SequencertestPackage.MODEL__X20:
        return x20 != null;
      case SequencertestPackage.MODEL__X21:
        return x21 != null;
      case SequencertestPackage.MODEL__X22:
        return x22 != null;
      case SequencertestPackage.MODEL__X23:
        return x23 != null;
      case SequencertestPackage.MODEL__X24:
        return x24 != null;
      case SequencertestPackage.MODEL__X25:
        return x25 != null;
      case SequencertestPackage.MODEL__X26:
        return x26 != null;
      case SequencertestPackage.MODEL__X27:
        return x27 != null;
      case SequencertestPackage.MODEL__X28:
        return x28 != null;
      case SequencertestPackage.MODEL__X29:
        return x29 != null;
      case SequencertestPackage.MODEL__X30:
        return x30 != null;
      case SequencertestPackage.MODEL__X31:
        return x31 != null;
      case SequencertestPackage.MODEL__X32:
        return x32 != null;
      case SequencertestPackage.MODEL__X33:
        return x33 != null;
      case SequencertestPackage.MODEL__X34:
        return x34 != null;
      case SequencertestPackage.MODEL__X35:
        return x35 != null;
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
