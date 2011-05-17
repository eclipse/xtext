/**
 * <copyright>
 * </copyright>
 *
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
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative1;
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative2;
import org.eclipse.xtext.serializer.sequencertest.GroupMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.List1;
import org.eclipse.xtext.serializer.sequencertest.List2;
import org.eclipse.xtext.serializer.sequencertest.Model;
import org.eclipse.xtext.serializer.sequencertest.Optional;
import org.eclipse.xtext.serializer.sequencertest.SequencertestPackage;
import org.eclipse.xtext.serializer.sequencertest.SimpleAlternative;
import org.eclipse.xtext.serializer.sequencertest.SimpleGroup;
import org.eclipse.xtext.serializer.sequencertest.SimpleMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReference;
import org.eclipse.xtext.serializer.sequencertest.SingleCrossReference;
import org.eclipse.xtext.serializer.sequencertest.SingleEnum;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
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
 * </ul>
 * </p>
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
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
