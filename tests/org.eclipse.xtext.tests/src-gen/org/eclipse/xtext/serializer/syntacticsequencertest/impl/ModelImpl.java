/**
 */
package org.eclipse.xtext.serializer.syntacticsequencertest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.syntacticsequencertest.ActionOnly;
import org.eclipse.xtext.serializer.syntacticsequencertest.AlternativeTransition;
import org.eclipse.xtext.serializer.syntacticsequencertest.BooleanAlternative;
import org.eclipse.xtext.serializer.syntacticsequencertest.BooleanValues;
import org.eclipse.xtext.serializer.syntacticsequencertest.Exp0;
import org.eclipse.xtext.serializer.syntacticsequencertest.Exp1;
import org.eclipse.xtext.serializer.syntacticsequencertest.Exp2;
import org.eclipse.xtext.serializer.syntacticsequencertest.FragmentCallerType;
import org.eclipse.xtext.serializer.syntacticsequencertest.LongAlternative;
import org.eclipse.xtext.serializer.syntacticsequencertest.MandatoryKeywords;
import org.eclipse.xtext.serializer.syntacticsequencertest.MandatoryManyTransition;
import org.eclipse.xtext.serializer.syntacticsequencertest.Model;
import org.eclipse.xtext.serializer.syntacticsequencertest.OptionalManyTransition;
import org.eclipse.xtext.serializer.syntacticsequencertest.OptionalSingleTransition;
import org.eclipse.xtext.serializer.syntacticsequencertest.SingleCrossReference;
import org.eclipse.xtext.serializer.syntacticsequencertest.SyntacticsequencertestPackage;
import org.eclipse.xtext.serializer.syntacticsequencertest.UnassignedDatatype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.ModelImpl#getX1 <em>X1</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.ModelImpl#getX2 <em>X2</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.ModelImpl#getX3 <em>X3</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.ModelImpl#getX4 <em>X4</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.ModelImpl#getX5 <em>X5</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.ModelImpl#getX6 <em>X6</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.ModelImpl#getX7 <em>X7</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.ModelImpl#getX8 <em>X8</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.ModelImpl#getX9 <em>X9</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.ModelImpl#getX10 <em>X10</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.ModelImpl#getX11 <em>X11</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.ModelImpl#getX12 <em>X12</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.ModelImpl#getX13 <em>X13</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.ModelImpl#getX14 <em>X14</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.ModelImpl#getX15 <em>X15</em>}</li>
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
  protected MandatoryKeywords x1;

  /**
   * The cached value of the '{@link #getX2() <em>X2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX2()
   * @generated
   * @ordered
   */
  protected Exp0 x2;

  /**
   * The cached value of the '{@link #getX3() <em>X3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX3()
   * @generated
   * @ordered
   */
  protected Exp1 x3;

  /**
   * The cached value of the '{@link #getX4() <em>X4</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX4()
   * @generated
   * @ordered
   */
  protected Exp2 x4;

  /**
   * The cached value of the '{@link #getX5() <em>X5</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX5()
   * @generated
   * @ordered
   */
  protected SingleCrossReference x5;

  /**
   * The cached value of the '{@link #getX6() <em>X6</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX6()
   * @generated
   * @ordered
   */
  protected BooleanAlternative x6;

  /**
   * The cached value of the '{@link #getX7() <em>X7</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX7()
   * @generated
   * @ordered
   */
  protected UnassignedDatatype x7;

  /**
   * The cached value of the '{@link #getX8() <em>X8</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX8()
   * @generated
   * @ordered
   */
  protected OptionalSingleTransition x8;

  /**
   * The cached value of the '{@link #getX9() <em>X9</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX9()
   * @generated
   * @ordered
   */
  protected OptionalManyTransition x9;

  /**
   * The cached value of the '{@link #getX10() <em>X10</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX10()
   * @generated
   * @ordered
   */
  protected MandatoryManyTransition x10;

  /**
   * The cached value of the '{@link #getX11() <em>X11</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX11()
   * @generated
   * @ordered
   */
  protected AlternativeTransition x11;

  /**
   * The cached value of the '{@link #getX12() <em>X12</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX12()
   * @generated
   * @ordered
   */
  protected BooleanValues x12;

  /**
   * The cached value of the '{@link #getX13() <em>X13</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX13()
   * @generated
   * @ordered
   */
  protected LongAlternative x13;

  /**
   * The cached value of the '{@link #getX14() <em>X14</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX14()
   * @generated
   * @ordered
   */
  protected ActionOnly x14;

  /**
   * The cached value of the '{@link #getX15() <em>X15</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX15()
   * @generated
   * @ordered
   */
  protected FragmentCallerType x15;

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
    return SyntacticsequencertestPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MandatoryKeywords getX1()
  {
    return x1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX1(MandatoryKeywords newX1, NotificationChain msgs)
  {
    MandatoryKeywords oldX1 = x1;
    x1 = newX1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X1, oldX1, newX1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX1(MandatoryKeywords newX1)
  {
    if (newX1 != x1)
    {
      NotificationChain msgs = null;
      if (x1 != null)
        msgs = ((InternalEObject)x1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X1, null, msgs);
      if (newX1 != null)
        msgs = ((InternalEObject)newX1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X1, null, msgs);
      msgs = basicSetX1(newX1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X1, newX1, newX1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Exp0 getX2()
  {
    return x2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX2(Exp0 newX2, NotificationChain msgs)
  {
    Exp0 oldX2 = x2;
    x2 = newX2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X2, oldX2, newX2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX2(Exp0 newX2)
  {
    if (newX2 != x2)
    {
      NotificationChain msgs = null;
      if (x2 != null)
        msgs = ((InternalEObject)x2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X2, null, msgs);
      if (newX2 != null)
        msgs = ((InternalEObject)newX2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X2, null, msgs);
      msgs = basicSetX2(newX2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X2, newX2, newX2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Exp1 getX3()
  {
    return x3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX3(Exp1 newX3, NotificationChain msgs)
  {
    Exp1 oldX3 = x3;
    x3 = newX3;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X3, oldX3, newX3);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX3(Exp1 newX3)
  {
    if (newX3 != x3)
    {
      NotificationChain msgs = null;
      if (x3 != null)
        msgs = ((InternalEObject)x3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X3, null, msgs);
      if (newX3 != null)
        msgs = ((InternalEObject)newX3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X3, null, msgs);
      msgs = basicSetX3(newX3, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X3, newX3, newX3));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Exp2 getX4()
  {
    return x4;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX4(Exp2 newX4, NotificationChain msgs)
  {
    Exp2 oldX4 = x4;
    x4 = newX4;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X4, oldX4, newX4);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX4(Exp2 newX4)
  {
    if (newX4 != x4)
    {
      NotificationChain msgs = null;
      if (x4 != null)
        msgs = ((InternalEObject)x4).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X4, null, msgs);
      if (newX4 != null)
        msgs = ((InternalEObject)newX4).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X4, null, msgs);
      msgs = basicSetX4(newX4, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X4, newX4, newX4));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleCrossReference getX5()
  {
    return x5;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX5(SingleCrossReference newX5, NotificationChain msgs)
  {
    SingleCrossReference oldX5 = x5;
    x5 = newX5;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X5, oldX5, newX5);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX5(SingleCrossReference newX5)
  {
    if (newX5 != x5)
    {
      NotificationChain msgs = null;
      if (x5 != null)
        msgs = ((InternalEObject)x5).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X5, null, msgs);
      if (newX5 != null)
        msgs = ((InternalEObject)newX5).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X5, null, msgs);
      msgs = basicSetX5(newX5, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X5, newX5, newX5));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanAlternative getX6()
  {
    return x6;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX6(BooleanAlternative newX6, NotificationChain msgs)
  {
    BooleanAlternative oldX6 = x6;
    x6 = newX6;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X6, oldX6, newX6);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX6(BooleanAlternative newX6)
  {
    if (newX6 != x6)
    {
      NotificationChain msgs = null;
      if (x6 != null)
        msgs = ((InternalEObject)x6).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X6, null, msgs);
      if (newX6 != null)
        msgs = ((InternalEObject)newX6).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X6, null, msgs);
      msgs = basicSetX6(newX6, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X6, newX6, newX6));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedDatatype getX7()
  {
    return x7;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX7(UnassignedDatatype newX7, NotificationChain msgs)
  {
    UnassignedDatatype oldX7 = x7;
    x7 = newX7;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X7, oldX7, newX7);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX7(UnassignedDatatype newX7)
  {
    if (newX7 != x7)
    {
      NotificationChain msgs = null;
      if (x7 != null)
        msgs = ((InternalEObject)x7).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X7, null, msgs);
      if (newX7 != null)
        msgs = ((InternalEObject)newX7).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X7, null, msgs);
      msgs = basicSetX7(newX7, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X7, newX7, newX7));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptionalSingleTransition getX8()
  {
    return x8;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX8(OptionalSingleTransition newX8, NotificationChain msgs)
  {
    OptionalSingleTransition oldX8 = x8;
    x8 = newX8;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X8, oldX8, newX8);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX8(OptionalSingleTransition newX8)
  {
    if (newX8 != x8)
    {
      NotificationChain msgs = null;
      if (x8 != null)
        msgs = ((InternalEObject)x8).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X8, null, msgs);
      if (newX8 != null)
        msgs = ((InternalEObject)newX8).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X8, null, msgs);
      msgs = basicSetX8(newX8, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X8, newX8, newX8));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptionalManyTransition getX9()
  {
    return x9;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX9(OptionalManyTransition newX9, NotificationChain msgs)
  {
    OptionalManyTransition oldX9 = x9;
    x9 = newX9;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X9, oldX9, newX9);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX9(OptionalManyTransition newX9)
  {
    if (newX9 != x9)
    {
      NotificationChain msgs = null;
      if (x9 != null)
        msgs = ((InternalEObject)x9).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X9, null, msgs);
      if (newX9 != null)
        msgs = ((InternalEObject)newX9).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X9, null, msgs);
      msgs = basicSetX9(newX9, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X9, newX9, newX9));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MandatoryManyTransition getX10()
  {
    return x10;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX10(MandatoryManyTransition newX10, NotificationChain msgs)
  {
    MandatoryManyTransition oldX10 = x10;
    x10 = newX10;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X10, oldX10, newX10);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX10(MandatoryManyTransition newX10)
  {
    if (newX10 != x10)
    {
      NotificationChain msgs = null;
      if (x10 != null)
        msgs = ((InternalEObject)x10).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X10, null, msgs);
      if (newX10 != null)
        msgs = ((InternalEObject)newX10).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X10, null, msgs);
      msgs = basicSetX10(newX10, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X10, newX10, newX10));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlternativeTransition getX11()
  {
    return x11;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX11(AlternativeTransition newX11, NotificationChain msgs)
  {
    AlternativeTransition oldX11 = x11;
    x11 = newX11;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X11, oldX11, newX11);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX11(AlternativeTransition newX11)
  {
    if (newX11 != x11)
    {
      NotificationChain msgs = null;
      if (x11 != null)
        msgs = ((InternalEObject)x11).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X11, null, msgs);
      if (newX11 != null)
        msgs = ((InternalEObject)newX11).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X11, null, msgs);
      msgs = basicSetX11(newX11, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X11, newX11, newX11));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanValues getX12()
  {
    return x12;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX12(BooleanValues newX12, NotificationChain msgs)
  {
    BooleanValues oldX12 = x12;
    x12 = newX12;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X12, oldX12, newX12);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX12(BooleanValues newX12)
  {
    if (newX12 != x12)
    {
      NotificationChain msgs = null;
      if (x12 != null)
        msgs = ((InternalEObject)x12).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X12, null, msgs);
      if (newX12 != null)
        msgs = ((InternalEObject)newX12).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X12, null, msgs);
      msgs = basicSetX12(newX12, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X12, newX12, newX12));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LongAlternative getX13()
  {
    return x13;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX13(LongAlternative newX13, NotificationChain msgs)
  {
    LongAlternative oldX13 = x13;
    x13 = newX13;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X13, oldX13, newX13);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX13(LongAlternative newX13)
  {
    if (newX13 != x13)
    {
      NotificationChain msgs = null;
      if (x13 != null)
        msgs = ((InternalEObject)x13).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X13, null, msgs);
      if (newX13 != null)
        msgs = ((InternalEObject)newX13).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X13, null, msgs);
      msgs = basicSetX13(newX13, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X13, newX13, newX13));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActionOnly getX14()
  {
    return x14;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX14(ActionOnly newX14, NotificationChain msgs)
  {
    ActionOnly oldX14 = x14;
    x14 = newX14;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X14, oldX14, newX14);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX14(ActionOnly newX14)
  {
    if (newX14 != x14)
    {
      NotificationChain msgs = null;
      if (x14 != null)
        msgs = ((InternalEObject)x14).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X14, null, msgs);
      if (newX14 != null)
        msgs = ((InternalEObject)newX14).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X14, null, msgs);
      msgs = basicSetX14(newX14, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X14, newX14, newX14));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FragmentCallerType getX15()
  {
    return x15;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX15(FragmentCallerType newX15, NotificationChain msgs)
  {
    FragmentCallerType oldX15 = x15;
    x15 = newX15;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X15, oldX15, newX15);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX15(FragmentCallerType newX15)
  {
    if (newX15 != x15)
    {
      NotificationChain msgs = null;
      if (x15 != null)
        msgs = ((InternalEObject)x15).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X15, null, msgs);
      if (newX15 != null)
        msgs = ((InternalEObject)newX15).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyntacticsequencertestPackage.MODEL__X15, null, msgs);
      msgs = basicSetX15(newX15, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.MODEL__X15, newX15, newX15));
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
      case SyntacticsequencertestPackage.MODEL__X1:
        return basicSetX1(null, msgs);
      case SyntacticsequencertestPackage.MODEL__X2:
        return basicSetX2(null, msgs);
      case SyntacticsequencertestPackage.MODEL__X3:
        return basicSetX3(null, msgs);
      case SyntacticsequencertestPackage.MODEL__X4:
        return basicSetX4(null, msgs);
      case SyntacticsequencertestPackage.MODEL__X5:
        return basicSetX5(null, msgs);
      case SyntacticsequencertestPackage.MODEL__X6:
        return basicSetX6(null, msgs);
      case SyntacticsequencertestPackage.MODEL__X7:
        return basicSetX7(null, msgs);
      case SyntacticsequencertestPackage.MODEL__X8:
        return basicSetX8(null, msgs);
      case SyntacticsequencertestPackage.MODEL__X9:
        return basicSetX9(null, msgs);
      case SyntacticsequencertestPackage.MODEL__X10:
        return basicSetX10(null, msgs);
      case SyntacticsequencertestPackage.MODEL__X11:
        return basicSetX11(null, msgs);
      case SyntacticsequencertestPackage.MODEL__X12:
        return basicSetX12(null, msgs);
      case SyntacticsequencertestPackage.MODEL__X13:
        return basicSetX13(null, msgs);
      case SyntacticsequencertestPackage.MODEL__X14:
        return basicSetX14(null, msgs);
      case SyntacticsequencertestPackage.MODEL__X15:
        return basicSetX15(null, msgs);
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
      case SyntacticsequencertestPackage.MODEL__X1:
        return getX1();
      case SyntacticsequencertestPackage.MODEL__X2:
        return getX2();
      case SyntacticsequencertestPackage.MODEL__X3:
        return getX3();
      case SyntacticsequencertestPackage.MODEL__X4:
        return getX4();
      case SyntacticsequencertestPackage.MODEL__X5:
        return getX5();
      case SyntacticsequencertestPackage.MODEL__X6:
        return getX6();
      case SyntacticsequencertestPackage.MODEL__X7:
        return getX7();
      case SyntacticsequencertestPackage.MODEL__X8:
        return getX8();
      case SyntacticsequencertestPackage.MODEL__X9:
        return getX9();
      case SyntacticsequencertestPackage.MODEL__X10:
        return getX10();
      case SyntacticsequencertestPackage.MODEL__X11:
        return getX11();
      case SyntacticsequencertestPackage.MODEL__X12:
        return getX12();
      case SyntacticsequencertestPackage.MODEL__X13:
        return getX13();
      case SyntacticsequencertestPackage.MODEL__X14:
        return getX14();
      case SyntacticsequencertestPackage.MODEL__X15:
        return getX15();
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
      case SyntacticsequencertestPackage.MODEL__X1:
        setX1((MandatoryKeywords)newValue);
        return;
      case SyntacticsequencertestPackage.MODEL__X2:
        setX2((Exp0)newValue);
        return;
      case SyntacticsequencertestPackage.MODEL__X3:
        setX3((Exp1)newValue);
        return;
      case SyntacticsequencertestPackage.MODEL__X4:
        setX4((Exp2)newValue);
        return;
      case SyntacticsequencertestPackage.MODEL__X5:
        setX5((SingleCrossReference)newValue);
        return;
      case SyntacticsequencertestPackage.MODEL__X6:
        setX6((BooleanAlternative)newValue);
        return;
      case SyntacticsequencertestPackage.MODEL__X7:
        setX7((UnassignedDatatype)newValue);
        return;
      case SyntacticsequencertestPackage.MODEL__X8:
        setX8((OptionalSingleTransition)newValue);
        return;
      case SyntacticsequencertestPackage.MODEL__X9:
        setX9((OptionalManyTransition)newValue);
        return;
      case SyntacticsequencertestPackage.MODEL__X10:
        setX10((MandatoryManyTransition)newValue);
        return;
      case SyntacticsequencertestPackage.MODEL__X11:
        setX11((AlternativeTransition)newValue);
        return;
      case SyntacticsequencertestPackage.MODEL__X12:
        setX12((BooleanValues)newValue);
        return;
      case SyntacticsequencertestPackage.MODEL__X13:
        setX13((LongAlternative)newValue);
        return;
      case SyntacticsequencertestPackage.MODEL__X14:
        setX14((ActionOnly)newValue);
        return;
      case SyntacticsequencertestPackage.MODEL__X15:
        setX15((FragmentCallerType)newValue);
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
      case SyntacticsequencertestPackage.MODEL__X1:
        setX1((MandatoryKeywords)null);
        return;
      case SyntacticsequencertestPackage.MODEL__X2:
        setX2((Exp0)null);
        return;
      case SyntacticsequencertestPackage.MODEL__X3:
        setX3((Exp1)null);
        return;
      case SyntacticsequencertestPackage.MODEL__X4:
        setX4((Exp2)null);
        return;
      case SyntacticsequencertestPackage.MODEL__X5:
        setX5((SingleCrossReference)null);
        return;
      case SyntacticsequencertestPackage.MODEL__X6:
        setX6((BooleanAlternative)null);
        return;
      case SyntacticsequencertestPackage.MODEL__X7:
        setX7((UnassignedDatatype)null);
        return;
      case SyntacticsequencertestPackage.MODEL__X8:
        setX8((OptionalSingleTransition)null);
        return;
      case SyntacticsequencertestPackage.MODEL__X9:
        setX9((OptionalManyTransition)null);
        return;
      case SyntacticsequencertestPackage.MODEL__X10:
        setX10((MandatoryManyTransition)null);
        return;
      case SyntacticsequencertestPackage.MODEL__X11:
        setX11((AlternativeTransition)null);
        return;
      case SyntacticsequencertestPackage.MODEL__X12:
        setX12((BooleanValues)null);
        return;
      case SyntacticsequencertestPackage.MODEL__X13:
        setX13((LongAlternative)null);
        return;
      case SyntacticsequencertestPackage.MODEL__X14:
        setX14((ActionOnly)null);
        return;
      case SyntacticsequencertestPackage.MODEL__X15:
        setX15((FragmentCallerType)null);
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
      case SyntacticsequencertestPackage.MODEL__X1:
        return x1 != null;
      case SyntacticsequencertestPackage.MODEL__X2:
        return x2 != null;
      case SyntacticsequencertestPackage.MODEL__X3:
        return x3 != null;
      case SyntacticsequencertestPackage.MODEL__X4:
        return x4 != null;
      case SyntacticsequencertestPackage.MODEL__X5:
        return x5 != null;
      case SyntacticsequencertestPackage.MODEL__X6:
        return x6 != null;
      case SyntacticsequencertestPackage.MODEL__X7:
        return x7 != null;
      case SyntacticsequencertestPackage.MODEL__X8:
        return x8 != null;
      case SyntacticsequencertestPackage.MODEL__X9:
        return x9 != null;
      case SyntacticsequencertestPackage.MODEL__X10:
        return x10 != null;
      case SyntacticsequencertestPackage.MODEL__X11:
        return x11 != null;
      case SyntacticsequencertestPackage.MODEL__X12:
        return x12 != null;
      case SyntacticsequencertestPackage.MODEL__X13:
        return x13 != null;
      case SyntacticsequencertestPackage.MODEL__X14:
        return x14 != null;
      case SyntacticsequencertestPackage.MODEL__X15:
        return x15 != null;
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
