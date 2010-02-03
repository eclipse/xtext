/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Attribute;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Bug289187TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Operation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.impl.ClassImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.impl.ClassImpl#isTransient <em>Transient</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.impl.ClassImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.impl.ClassImpl#getSuperClass <em>Super Class</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.impl.ClassImpl#getImplementedInterfaces <em>Implemented Interfaces</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.impl.ClassImpl#getClassNumber <em>Class Number</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.impl.ClassImpl#getQuid <em>Quid</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.impl.ClassImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.impl.ClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.impl.ClassImpl#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends MinimalEObjectImpl.Container implements org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Class
{
  /**
   * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected static final boolean ABSTRACT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected boolean abstract_ = ABSTRACT_EDEFAULT;

  /**
   * The default value of the '{@link #isTransient() <em>Transient</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTransient()
   * @generated
   * @ordered
   */
  protected static final boolean TRANSIENT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isTransient() <em>Transient</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTransient()
   * @generated
   * @ordered
   */
  protected boolean transient_ = TRANSIENT_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getSuperClass() <em>Super Class</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperClass()
   * @generated
   * @ordered
   */
  protected org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Class superClass;

  /**
   * The cached value of the '{@link #getImplementedInterfaces() <em>Implemented Interfaces</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImplementedInterfaces()
   * @generated
   * @ordered
   */
  protected EList<org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Class> implementedInterfaces;

  /**
   * The default value of the '{@link #getClassNumber() <em>Class Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassNumber()
   * @generated
   * @ordered
   */
  protected static final int CLASS_NUMBER_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getClassNumber() <em>Class Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassNumber()
   * @generated
   * @ordered
   */
  protected int classNumber = CLASS_NUMBER_EDEFAULT;

  /**
   * The default value of the '{@link #getQuid() <em>Quid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuid()
   * @generated
   * @ordered
   */
  protected static final int QUID_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getQuid() <em>Quid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuid()
   * @generated
   * @ordered
   */
  protected int quid = QUID_EDEFAULT;

  /**
   * The default value of the '{@link #getDocumentation() <em>Documentation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocumentation()
   * @generated
   * @ordered
   */
  protected static final String DOCUMENTATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDocumentation() <em>Documentation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocumentation()
   * @generated
   * @ordered
   */
  protected String documentation = DOCUMENTATION_EDEFAULT;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<Attribute> attributes;

  /**
   * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperations()
   * @generated
   * @ordered
   */
  protected EList<Operation> operations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassImpl()
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
    return Bug289187TestLanguagePackage.Literals.CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAbstract()
  {
    return abstract_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAbstract(boolean newAbstract)
  {
    boolean oldAbstract = abstract_;
    abstract_ = newAbstract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug289187TestLanguagePackage.CLASS__ABSTRACT, oldAbstract, abstract_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isTransient()
  {
    return transient_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransient(boolean newTransient)
  {
    boolean oldTransient = transient_;
    transient_ = newTransient;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug289187TestLanguagePackage.CLASS__TRANSIENT, oldTransient, transient_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug289187TestLanguagePackage.CLASS__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Class getSuperClass()
  {
    if (superClass != null && superClass.eIsProxy())
    {
      InternalEObject oldSuperClass = (InternalEObject)superClass;
      superClass = (org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Class)eResolveProxy(oldSuperClass);
      if (superClass != oldSuperClass)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bug289187TestLanguagePackage.CLASS__SUPER_CLASS, oldSuperClass, superClass));
      }
    }
    return superClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Class basicGetSuperClass()
  {
    return superClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuperClass(org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Class newSuperClass)
  {
    org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Class oldSuperClass = superClass;
    superClass = newSuperClass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug289187TestLanguagePackage.CLASS__SUPER_CLASS, oldSuperClass, superClass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Class> getImplementedInterfaces()
  {
    if (implementedInterfaces == null)
    {
      implementedInterfaces = new EObjectResolvingEList<org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Class>(org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Class.class, this, Bug289187TestLanguagePackage.CLASS__IMPLEMENTED_INTERFACES);
    }
    return implementedInterfaces;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getClassNumber()
  {
    return classNumber;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassNumber(int newClassNumber)
  {
    int oldClassNumber = classNumber;
    classNumber = newClassNumber;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug289187TestLanguagePackage.CLASS__CLASS_NUMBER, oldClassNumber, classNumber));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getQuid()
  {
    return quid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQuid(int newQuid)
  {
    int oldQuid = quid;
    quid = newQuid;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug289187TestLanguagePackage.CLASS__QUID, oldQuid, quid));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDocumentation()
  {
    return documentation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDocumentation(String newDocumentation)
  {
    String oldDocumentation = documentation;
    documentation = newDocumentation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug289187TestLanguagePackage.CLASS__DOCUMENTATION, oldDocumentation, documentation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Attribute> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, Bug289187TestLanguagePackage.CLASS__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Operation> getOperations()
  {
    if (operations == null)
    {
      operations = new EObjectContainmentEList<Operation>(Operation.class, this, Bug289187TestLanguagePackage.CLASS__OPERATIONS);
    }
    return operations;
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
      case Bug289187TestLanguagePackage.CLASS__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
      case Bug289187TestLanguagePackage.CLASS__OPERATIONS:
        return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
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
      case Bug289187TestLanguagePackage.CLASS__ABSTRACT:
        return isAbstract();
      case Bug289187TestLanguagePackage.CLASS__TRANSIENT:
        return isTransient();
      case Bug289187TestLanguagePackage.CLASS__NAME:
        return getName();
      case Bug289187TestLanguagePackage.CLASS__SUPER_CLASS:
        if (resolve) return getSuperClass();
        return basicGetSuperClass();
      case Bug289187TestLanguagePackage.CLASS__IMPLEMENTED_INTERFACES:
        return getImplementedInterfaces();
      case Bug289187TestLanguagePackage.CLASS__CLASS_NUMBER:
        return getClassNumber();
      case Bug289187TestLanguagePackage.CLASS__QUID:
        return getQuid();
      case Bug289187TestLanguagePackage.CLASS__DOCUMENTATION:
        return getDocumentation();
      case Bug289187TestLanguagePackage.CLASS__ATTRIBUTES:
        return getAttributes();
      case Bug289187TestLanguagePackage.CLASS__OPERATIONS:
        return getOperations();
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
      case Bug289187TestLanguagePackage.CLASS__ABSTRACT:
        setAbstract((Boolean)newValue);
        return;
      case Bug289187TestLanguagePackage.CLASS__TRANSIENT:
        setTransient((Boolean)newValue);
        return;
      case Bug289187TestLanguagePackage.CLASS__NAME:
        setName((String)newValue);
        return;
      case Bug289187TestLanguagePackage.CLASS__SUPER_CLASS:
        setSuperClass((org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Class)newValue);
        return;
      case Bug289187TestLanguagePackage.CLASS__IMPLEMENTED_INTERFACES:
        getImplementedInterfaces().clear();
        getImplementedInterfaces().addAll((Collection<? extends org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Class>)newValue);
        return;
      case Bug289187TestLanguagePackage.CLASS__CLASS_NUMBER:
        setClassNumber((Integer)newValue);
        return;
      case Bug289187TestLanguagePackage.CLASS__QUID:
        setQuid((Integer)newValue);
        return;
      case Bug289187TestLanguagePackage.CLASS__DOCUMENTATION:
        setDocumentation((String)newValue);
        return;
      case Bug289187TestLanguagePackage.CLASS__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends Attribute>)newValue);
        return;
      case Bug289187TestLanguagePackage.CLASS__OPERATIONS:
        getOperations().clear();
        getOperations().addAll((Collection<? extends Operation>)newValue);
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
      case Bug289187TestLanguagePackage.CLASS__ABSTRACT:
        setAbstract(ABSTRACT_EDEFAULT);
        return;
      case Bug289187TestLanguagePackage.CLASS__TRANSIENT:
        setTransient(TRANSIENT_EDEFAULT);
        return;
      case Bug289187TestLanguagePackage.CLASS__NAME:
        setName(NAME_EDEFAULT);
        return;
      case Bug289187TestLanguagePackage.CLASS__SUPER_CLASS:
        setSuperClass((org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Class)null);
        return;
      case Bug289187TestLanguagePackage.CLASS__IMPLEMENTED_INTERFACES:
        getImplementedInterfaces().clear();
        return;
      case Bug289187TestLanguagePackage.CLASS__CLASS_NUMBER:
        setClassNumber(CLASS_NUMBER_EDEFAULT);
        return;
      case Bug289187TestLanguagePackage.CLASS__QUID:
        setQuid(QUID_EDEFAULT);
        return;
      case Bug289187TestLanguagePackage.CLASS__DOCUMENTATION:
        setDocumentation(DOCUMENTATION_EDEFAULT);
        return;
      case Bug289187TestLanguagePackage.CLASS__ATTRIBUTES:
        getAttributes().clear();
        return;
      case Bug289187TestLanguagePackage.CLASS__OPERATIONS:
        getOperations().clear();
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
      case Bug289187TestLanguagePackage.CLASS__ABSTRACT:
        return abstract_ != ABSTRACT_EDEFAULT;
      case Bug289187TestLanguagePackage.CLASS__TRANSIENT:
        return transient_ != TRANSIENT_EDEFAULT;
      case Bug289187TestLanguagePackage.CLASS__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case Bug289187TestLanguagePackage.CLASS__SUPER_CLASS:
        return superClass != null;
      case Bug289187TestLanguagePackage.CLASS__IMPLEMENTED_INTERFACES:
        return implementedInterfaces != null && !implementedInterfaces.isEmpty();
      case Bug289187TestLanguagePackage.CLASS__CLASS_NUMBER:
        return classNumber != CLASS_NUMBER_EDEFAULT;
      case Bug289187TestLanguagePackage.CLASS__QUID:
        return quid != QUID_EDEFAULT;
      case Bug289187TestLanguagePackage.CLASS__DOCUMENTATION:
        return DOCUMENTATION_EDEFAULT == null ? documentation != null : !DOCUMENTATION_EDEFAULT.equals(documentation);
      case Bug289187TestLanguagePackage.CLASS__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case Bug289187TestLanguagePackage.CLASS__OPERATIONS:
        return operations != null && !operations.isEmpty();
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
    result.append(" (abstract: ");
    result.append(abstract_);
    result.append(", transient: ");
    result.append(transient_);
    result.append(", name: ");
    result.append(name);
    result.append(", classNumber: ");
    result.append(classNumber);
    result.append(", quid: ");
    result.append(quid);
    result.append(", documentation: ");
    result.append(documentation);
    result.append(')');
    return result.toString();
  }

} //ClassImpl
