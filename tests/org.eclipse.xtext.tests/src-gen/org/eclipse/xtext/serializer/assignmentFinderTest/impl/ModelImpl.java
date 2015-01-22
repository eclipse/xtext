/**
 */
package org.eclipse.xtext.serializer.assignmentFinderTest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.assignmentFinderTest.AssignmentFinderTestPackage;
import org.eclipse.xtext.serializer.assignmentFinderTest.ContainmentRef;
import org.eclipse.xtext.serializer.assignmentFinderTest.CrossRef;
import org.eclipse.xtext.serializer.assignmentFinderTest.EnumBool;
import org.eclipse.xtext.serializer.assignmentFinderTest.EnumVal;
import org.eclipse.xtext.serializer.assignmentFinderTest.KeywordBool;
import org.eclipse.xtext.serializer.assignmentFinderTest.KeywordVal;
import org.eclipse.xtext.serializer.assignmentFinderTest.MixedBool;
import org.eclipse.xtext.serializer.assignmentFinderTest.MixedValue;
import org.eclipse.xtext.serializer.assignmentFinderTest.Model;
import org.eclipse.xtext.serializer.assignmentFinderTest.TerminalBool;
import org.eclipse.xtext.serializer.assignmentFinderTest.TerminalVal;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.ModelImpl#getKeywordVal <em>Keyword Val</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.ModelImpl#getTerminalVal <em>Terminal Val</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.ModelImpl#getEnumVal <em>Enum Val</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.ModelImpl#getKeywordBool <em>Keyword Bool</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.ModelImpl#getTerminalBool <em>Terminal Bool</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.ModelImpl#getEnumBool <em>Enum Bool</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.ModelImpl#getMixedBool <em>Mixed Bool</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.ModelImpl#getMixedValue <em>Mixed Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.ModelImpl#getContainmentRef <em>Containment Ref</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.ModelImpl#getCrossRef <em>Cross Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getKeywordVal() <em>Keyword Val</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKeywordVal()
   * @generated
   * @ordered
   */
  protected KeywordVal keywordVal;

  /**
   * The cached value of the '{@link #getTerminalVal() <em>Terminal Val</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTerminalVal()
   * @generated
   * @ordered
   */
  protected TerminalVal terminalVal;

  /**
   * The cached value of the '{@link #getEnumVal() <em>Enum Val</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumVal()
   * @generated
   * @ordered
   */
  protected EnumVal enumVal;

  /**
   * The cached value of the '{@link #getKeywordBool() <em>Keyword Bool</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKeywordBool()
   * @generated
   * @ordered
   */
  protected KeywordBool keywordBool;

  /**
   * The cached value of the '{@link #getTerminalBool() <em>Terminal Bool</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTerminalBool()
   * @generated
   * @ordered
   */
  protected TerminalBool terminalBool;

  /**
   * The cached value of the '{@link #getEnumBool() <em>Enum Bool</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumBool()
   * @generated
   * @ordered
   */
  protected EnumBool enumBool;

  /**
   * The cached value of the '{@link #getMixedBool() <em>Mixed Bool</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMixedBool()
   * @generated
   * @ordered
   */
  protected MixedBool mixedBool;

  /**
   * The cached value of the '{@link #getMixedValue() <em>Mixed Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMixedValue()
   * @generated
   * @ordered
   */
  protected MixedValue mixedValue;

  /**
   * The cached value of the '{@link #getContainmentRef() <em>Containment Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContainmentRef()
   * @generated
   * @ordered
   */
  protected ContainmentRef containmentRef;

  /**
   * The cached value of the '{@link #getCrossRef() <em>Cross Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCrossRef()
   * @generated
   * @ordered
   */
  protected CrossRef crossRef;

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
    return AssignmentFinderTestPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KeywordVal getKeywordVal()
  {
    return keywordVal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetKeywordVal(KeywordVal newKeywordVal, NotificationChain msgs)
  {
    KeywordVal oldKeywordVal = keywordVal;
    keywordVal = newKeywordVal;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__KEYWORD_VAL, oldKeywordVal, newKeywordVal);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKeywordVal(KeywordVal newKeywordVal)
  {
    if (newKeywordVal != keywordVal)
    {
      NotificationChain msgs = null;
      if (keywordVal != null)
        msgs = ((InternalEObject)keywordVal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__KEYWORD_VAL, null, msgs);
      if (newKeywordVal != null)
        msgs = ((InternalEObject)newKeywordVal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__KEYWORD_VAL, null, msgs);
      msgs = basicSetKeywordVal(newKeywordVal, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__KEYWORD_VAL, newKeywordVal, newKeywordVal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TerminalVal getTerminalVal()
  {
    return terminalVal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTerminalVal(TerminalVal newTerminalVal, NotificationChain msgs)
  {
    TerminalVal oldTerminalVal = terminalVal;
    terminalVal = newTerminalVal;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__TERMINAL_VAL, oldTerminalVal, newTerminalVal);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTerminalVal(TerminalVal newTerminalVal)
  {
    if (newTerminalVal != terminalVal)
    {
      NotificationChain msgs = null;
      if (terminalVal != null)
        msgs = ((InternalEObject)terminalVal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__TERMINAL_VAL, null, msgs);
      if (newTerminalVal != null)
        msgs = ((InternalEObject)newTerminalVal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__TERMINAL_VAL, null, msgs);
      msgs = basicSetTerminalVal(newTerminalVal, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__TERMINAL_VAL, newTerminalVal, newTerminalVal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumVal getEnumVal()
  {
    return enumVal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEnumVal(EnumVal newEnumVal, NotificationChain msgs)
  {
    EnumVal oldEnumVal = enumVal;
    enumVal = newEnumVal;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__ENUM_VAL, oldEnumVal, newEnumVal);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnumVal(EnumVal newEnumVal)
  {
    if (newEnumVal != enumVal)
    {
      NotificationChain msgs = null;
      if (enumVal != null)
        msgs = ((InternalEObject)enumVal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__ENUM_VAL, null, msgs);
      if (newEnumVal != null)
        msgs = ((InternalEObject)newEnumVal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__ENUM_VAL, null, msgs);
      msgs = basicSetEnumVal(newEnumVal, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__ENUM_VAL, newEnumVal, newEnumVal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KeywordBool getKeywordBool()
  {
    return keywordBool;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetKeywordBool(KeywordBool newKeywordBool, NotificationChain msgs)
  {
    KeywordBool oldKeywordBool = keywordBool;
    keywordBool = newKeywordBool;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__KEYWORD_BOOL, oldKeywordBool, newKeywordBool);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKeywordBool(KeywordBool newKeywordBool)
  {
    if (newKeywordBool != keywordBool)
    {
      NotificationChain msgs = null;
      if (keywordBool != null)
        msgs = ((InternalEObject)keywordBool).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__KEYWORD_BOOL, null, msgs);
      if (newKeywordBool != null)
        msgs = ((InternalEObject)newKeywordBool).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__KEYWORD_BOOL, null, msgs);
      msgs = basicSetKeywordBool(newKeywordBool, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__KEYWORD_BOOL, newKeywordBool, newKeywordBool));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TerminalBool getTerminalBool()
  {
    return terminalBool;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTerminalBool(TerminalBool newTerminalBool, NotificationChain msgs)
  {
    TerminalBool oldTerminalBool = terminalBool;
    terminalBool = newTerminalBool;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__TERMINAL_BOOL, oldTerminalBool, newTerminalBool);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTerminalBool(TerminalBool newTerminalBool)
  {
    if (newTerminalBool != terminalBool)
    {
      NotificationChain msgs = null;
      if (terminalBool != null)
        msgs = ((InternalEObject)terminalBool).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__TERMINAL_BOOL, null, msgs);
      if (newTerminalBool != null)
        msgs = ((InternalEObject)newTerminalBool).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__TERMINAL_BOOL, null, msgs);
      msgs = basicSetTerminalBool(newTerminalBool, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__TERMINAL_BOOL, newTerminalBool, newTerminalBool));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumBool getEnumBool()
  {
    return enumBool;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEnumBool(EnumBool newEnumBool, NotificationChain msgs)
  {
    EnumBool oldEnumBool = enumBool;
    enumBool = newEnumBool;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__ENUM_BOOL, oldEnumBool, newEnumBool);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnumBool(EnumBool newEnumBool)
  {
    if (newEnumBool != enumBool)
    {
      NotificationChain msgs = null;
      if (enumBool != null)
        msgs = ((InternalEObject)enumBool).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__ENUM_BOOL, null, msgs);
      if (newEnumBool != null)
        msgs = ((InternalEObject)newEnumBool).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__ENUM_BOOL, null, msgs);
      msgs = basicSetEnumBool(newEnumBool, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__ENUM_BOOL, newEnumBool, newEnumBool));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MixedBool getMixedBool()
  {
    return mixedBool;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMixedBool(MixedBool newMixedBool, NotificationChain msgs)
  {
    MixedBool oldMixedBool = mixedBool;
    mixedBool = newMixedBool;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__MIXED_BOOL, oldMixedBool, newMixedBool);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMixedBool(MixedBool newMixedBool)
  {
    if (newMixedBool != mixedBool)
    {
      NotificationChain msgs = null;
      if (mixedBool != null)
        msgs = ((InternalEObject)mixedBool).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__MIXED_BOOL, null, msgs);
      if (newMixedBool != null)
        msgs = ((InternalEObject)newMixedBool).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__MIXED_BOOL, null, msgs);
      msgs = basicSetMixedBool(newMixedBool, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__MIXED_BOOL, newMixedBool, newMixedBool));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MixedValue getMixedValue()
  {
    return mixedValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMixedValue(MixedValue newMixedValue, NotificationChain msgs)
  {
    MixedValue oldMixedValue = mixedValue;
    mixedValue = newMixedValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__MIXED_VALUE, oldMixedValue, newMixedValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMixedValue(MixedValue newMixedValue)
  {
    if (newMixedValue != mixedValue)
    {
      NotificationChain msgs = null;
      if (mixedValue != null)
        msgs = ((InternalEObject)mixedValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__MIXED_VALUE, null, msgs);
      if (newMixedValue != null)
        msgs = ((InternalEObject)newMixedValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__MIXED_VALUE, null, msgs);
      msgs = basicSetMixedValue(newMixedValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__MIXED_VALUE, newMixedValue, newMixedValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContainmentRef getContainmentRef()
  {
    return containmentRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContainmentRef(ContainmentRef newContainmentRef, NotificationChain msgs)
  {
    ContainmentRef oldContainmentRef = containmentRef;
    containmentRef = newContainmentRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__CONTAINMENT_REF, oldContainmentRef, newContainmentRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContainmentRef(ContainmentRef newContainmentRef)
  {
    if (newContainmentRef != containmentRef)
    {
      NotificationChain msgs = null;
      if (containmentRef != null)
        msgs = ((InternalEObject)containmentRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__CONTAINMENT_REF, null, msgs);
      if (newContainmentRef != null)
        msgs = ((InternalEObject)newContainmentRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__CONTAINMENT_REF, null, msgs);
      msgs = basicSetContainmentRef(newContainmentRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__CONTAINMENT_REF, newContainmentRef, newContainmentRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CrossRef getCrossRef()
  {
    return crossRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCrossRef(CrossRef newCrossRef, NotificationChain msgs)
  {
    CrossRef oldCrossRef = crossRef;
    crossRef = newCrossRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__CROSS_REF, oldCrossRef, newCrossRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCrossRef(CrossRef newCrossRef)
  {
    if (newCrossRef != crossRef)
    {
      NotificationChain msgs = null;
      if (crossRef != null)
        msgs = ((InternalEObject)crossRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__CROSS_REF, null, msgs);
      if (newCrossRef != null)
        msgs = ((InternalEObject)newCrossRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssignmentFinderTestPackage.MODEL__CROSS_REF, null, msgs);
      msgs = basicSetCrossRef(newCrossRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.MODEL__CROSS_REF, newCrossRef, newCrossRef));
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
      case AssignmentFinderTestPackage.MODEL__KEYWORD_VAL:
        return basicSetKeywordVal(null, msgs);
      case AssignmentFinderTestPackage.MODEL__TERMINAL_VAL:
        return basicSetTerminalVal(null, msgs);
      case AssignmentFinderTestPackage.MODEL__ENUM_VAL:
        return basicSetEnumVal(null, msgs);
      case AssignmentFinderTestPackage.MODEL__KEYWORD_BOOL:
        return basicSetKeywordBool(null, msgs);
      case AssignmentFinderTestPackage.MODEL__TERMINAL_BOOL:
        return basicSetTerminalBool(null, msgs);
      case AssignmentFinderTestPackage.MODEL__ENUM_BOOL:
        return basicSetEnumBool(null, msgs);
      case AssignmentFinderTestPackage.MODEL__MIXED_BOOL:
        return basicSetMixedBool(null, msgs);
      case AssignmentFinderTestPackage.MODEL__MIXED_VALUE:
        return basicSetMixedValue(null, msgs);
      case AssignmentFinderTestPackage.MODEL__CONTAINMENT_REF:
        return basicSetContainmentRef(null, msgs);
      case AssignmentFinderTestPackage.MODEL__CROSS_REF:
        return basicSetCrossRef(null, msgs);
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
      case AssignmentFinderTestPackage.MODEL__KEYWORD_VAL:
        return getKeywordVal();
      case AssignmentFinderTestPackage.MODEL__TERMINAL_VAL:
        return getTerminalVal();
      case AssignmentFinderTestPackage.MODEL__ENUM_VAL:
        return getEnumVal();
      case AssignmentFinderTestPackage.MODEL__KEYWORD_BOOL:
        return getKeywordBool();
      case AssignmentFinderTestPackage.MODEL__TERMINAL_BOOL:
        return getTerminalBool();
      case AssignmentFinderTestPackage.MODEL__ENUM_BOOL:
        return getEnumBool();
      case AssignmentFinderTestPackage.MODEL__MIXED_BOOL:
        return getMixedBool();
      case AssignmentFinderTestPackage.MODEL__MIXED_VALUE:
        return getMixedValue();
      case AssignmentFinderTestPackage.MODEL__CONTAINMENT_REF:
        return getContainmentRef();
      case AssignmentFinderTestPackage.MODEL__CROSS_REF:
        return getCrossRef();
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
      case AssignmentFinderTestPackage.MODEL__KEYWORD_VAL:
        setKeywordVal((KeywordVal)newValue);
        return;
      case AssignmentFinderTestPackage.MODEL__TERMINAL_VAL:
        setTerminalVal((TerminalVal)newValue);
        return;
      case AssignmentFinderTestPackage.MODEL__ENUM_VAL:
        setEnumVal((EnumVal)newValue);
        return;
      case AssignmentFinderTestPackage.MODEL__KEYWORD_BOOL:
        setKeywordBool((KeywordBool)newValue);
        return;
      case AssignmentFinderTestPackage.MODEL__TERMINAL_BOOL:
        setTerminalBool((TerminalBool)newValue);
        return;
      case AssignmentFinderTestPackage.MODEL__ENUM_BOOL:
        setEnumBool((EnumBool)newValue);
        return;
      case AssignmentFinderTestPackage.MODEL__MIXED_BOOL:
        setMixedBool((MixedBool)newValue);
        return;
      case AssignmentFinderTestPackage.MODEL__MIXED_VALUE:
        setMixedValue((MixedValue)newValue);
        return;
      case AssignmentFinderTestPackage.MODEL__CONTAINMENT_REF:
        setContainmentRef((ContainmentRef)newValue);
        return;
      case AssignmentFinderTestPackage.MODEL__CROSS_REF:
        setCrossRef((CrossRef)newValue);
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
      case AssignmentFinderTestPackage.MODEL__KEYWORD_VAL:
        setKeywordVal((KeywordVal)null);
        return;
      case AssignmentFinderTestPackage.MODEL__TERMINAL_VAL:
        setTerminalVal((TerminalVal)null);
        return;
      case AssignmentFinderTestPackage.MODEL__ENUM_VAL:
        setEnumVal((EnumVal)null);
        return;
      case AssignmentFinderTestPackage.MODEL__KEYWORD_BOOL:
        setKeywordBool((KeywordBool)null);
        return;
      case AssignmentFinderTestPackage.MODEL__TERMINAL_BOOL:
        setTerminalBool((TerminalBool)null);
        return;
      case AssignmentFinderTestPackage.MODEL__ENUM_BOOL:
        setEnumBool((EnumBool)null);
        return;
      case AssignmentFinderTestPackage.MODEL__MIXED_BOOL:
        setMixedBool((MixedBool)null);
        return;
      case AssignmentFinderTestPackage.MODEL__MIXED_VALUE:
        setMixedValue((MixedValue)null);
        return;
      case AssignmentFinderTestPackage.MODEL__CONTAINMENT_REF:
        setContainmentRef((ContainmentRef)null);
        return;
      case AssignmentFinderTestPackage.MODEL__CROSS_REF:
        setCrossRef((CrossRef)null);
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
      case AssignmentFinderTestPackage.MODEL__KEYWORD_VAL:
        return keywordVal != null;
      case AssignmentFinderTestPackage.MODEL__TERMINAL_VAL:
        return terminalVal != null;
      case AssignmentFinderTestPackage.MODEL__ENUM_VAL:
        return enumVal != null;
      case AssignmentFinderTestPackage.MODEL__KEYWORD_BOOL:
        return keywordBool != null;
      case AssignmentFinderTestPackage.MODEL__TERMINAL_BOOL:
        return terminalBool != null;
      case AssignmentFinderTestPackage.MODEL__ENUM_BOOL:
        return enumBool != null;
      case AssignmentFinderTestPackage.MODEL__MIXED_BOOL:
        return mixedBool != null;
      case AssignmentFinderTestPackage.MODEL__MIXED_VALUE:
        return mixedValue != null;
      case AssignmentFinderTestPackage.MODEL__CONTAINMENT_REF:
        return containmentRef != null;
      case AssignmentFinderTestPackage.MODEL__CROSS_REF:
        return crossRef != null;
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
