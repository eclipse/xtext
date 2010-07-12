/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.BacktrackingContentAssistTestPackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierContextDecl;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierRef;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Definition;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Invariant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier Context Decl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ClassifierContextDeclImpl#getSelfName <em>Self Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ClassifierContextDeclImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ClassifierContextDeclImpl#getInvariants <em>Invariants</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.ClassifierContextDeclImpl#getDefinitions <em>Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassifierContextDeclImpl extends ContextDeclImpl implements ClassifierContextDecl
{
  /**
   * The default value of the '{@link #getSelfName() <em>Self Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelfName()
   * @generated
   * @ordered
   */
  protected static final String SELF_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSelfName() <em>Self Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelfName()
   * @generated
   * @ordered
   */
  protected String selfName = SELF_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getClassifier() <em>Classifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassifier()
   * @generated
   * @ordered
   */
  protected ClassifierRef classifier;

  /**
   * The cached value of the '{@link #getInvariants() <em>Invariants</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInvariants()
   * @generated
   * @ordered
   */
  protected EList<Invariant> invariants;

  /**
   * The cached value of the '{@link #getDefinitions() <em>Definitions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefinitions()
   * @generated
   * @ordered
   */
  protected EList<Definition> definitions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassifierContextDeclImpl()
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
    return BacktrackingContentAssistTestPackage.Literals.CLASSIFIER_CONTEXT_DECL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSelfName()
  {
    return selfName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSelfName(String newSelfName)
  {
    String oldSelfName = selfName;
    selfName = newSelfName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__SELF_NAME, oldSelfName, selfName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassifierRef getClassifier()
  {
    return classifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClassifier(ClassifierRef newClassifier, NotificationChain msgs)
  {
    ClassifierRef oldClassifier = classifier;
    classifier = newClassifier;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__CLASSIFIER, oldClassifier, newClassifier);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassifier(ClassifierRef newClassifier)
  {
    if (newClassifier != classifier)
    {
      NotificationChain msgs = null;
      if (classifier != null)
        msgs = ((InternalEObject)classifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__CLASSIFIER, null, msgs);
      if (newClassifier != null)
        msgs = ((InternalEObject)newClassifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__CLASSIFIER, null, msgs);
      msgs = basicSetClassifier(newClassifier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__CLASSIFIER, newClassifier, newClassifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Invariant> getInvariants()
  {
    if (invariants == null)
    {
      invariants = new EObjectContainmentEList<Invariant>(Invariant.class, this, BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__INVARIANTS);
    }
    return invariants;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Definition> getDefinitions()
  {
    if (definitions == null)
    {
      definitions = new EObjectContainmentEList<Definition>(Definition.class, this, BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__DEFINITIONS);
    }
    return definitions;
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
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__CLASSIFIER:
        return basicSetClassifier(null, msgs);
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__INVARIANTS:
        return ((InternalEList<?>)getInvariants()).basicRemove(otherEnd, msgs);
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__DEFINITIONS:
        return ((InternalEList<?>)getDefinitions()).basicRemove(otherEnd, msgs);
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
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__SELF_NAME:
        return getSelfName();
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__CLASSIFIER:
        return getClassifier();
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__INVARIANTS:
        return getInvariants();
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__DEFINITIONS:
        return getDefinitions();
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
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__SELF_NAME:
        setSelfName((String)newValue);
        return;
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__CLASSIFIER:
        setClassifier((ClassifierRef)newValue);
        return;
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__INVARIANTS:
        getInvariants().clear();
        getInvariants().addAll((Collection<? extends Invariant>)newValue);
        return;
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__DEFINITIONS:
        getDefinitions().clear();
        getDefinitions().addAll((Collection<? extends Definition>)newValue);
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
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__SELF_NAME:
        setSelfName(SELF_NAME_EDEFAULT);
        return;
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__CLASSIFIER:
        setClassifier((ClassifierRef)null);
        return;
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__INVARIANTS:
        getInvariants().clear();
        return;
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__DEFINITIONS:
        getDefinitions().clear();
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
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__SELF_NAME:
        return SELF_NAME_EDEFAULT == null ? selfName != null : !SELF_NAME_EDEFAULT.equals(selfName);
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__CLASSIFIER:
        return classifier != null;
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__INVARIANTS:
        return invariants != null && !invariants.isEmpty();
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL__DEFINITIONS:
        return definitions != null && !definitions.isEmpty();
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
    result.append(" (selfName: ");
    result.append(selfName);
    result.append(')');
    return result.toString();
  }

} //ClassifierContextDeclImpl
