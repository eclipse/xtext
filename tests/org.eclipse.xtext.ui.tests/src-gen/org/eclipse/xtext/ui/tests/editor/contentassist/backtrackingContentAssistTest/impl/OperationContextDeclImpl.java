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
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Body;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationContextDecl;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationRef;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Parameter;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Post;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Pre;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TypeExp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Context Decl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OperationContextDeclImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OperationContextDeclImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OperationContextDeclImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OperationContextDeclImpl#getPres <em>Pres</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OperationContextDeclImpl#getPosts <em>Posts</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.OperationContextDeclImpl#getBodies <em>Bodies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationContextDeclImpl extends ContextDeclImpl implements OperationContextDecl
{
  /**
   * The cached value of the '{@link #getOperation() <em>Operation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperation()
   * @generated
   * @ordered
   */
  protected OperationRef operation;

  /**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<Parameter> parameters;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected TypeExp type;

  /**
   * The cached value of the '{@link #getPres() <em>Pres</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPres()
   * @generated
   * @ordered
   */
  protected EList<Pre> pres;

  /**
   * The cached value of the '{@link #getPosts() <em>Posts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPosts()
   * @generated
   * @ordered
   */
  protected EList<Post> posts;

  /**
   * The cached value of the '{@link #getBodies() <em>Bodies</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBodies()
   * @generated
   * @ordered
   */
  protected EList<Body> bodies;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationContextDeclImpl()
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
    return BacktrackingContentAssistTestPackage.Literals.OPERATION_CONTEXT_DECL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationRef getOperation()
  {
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperation(OperationRef newOperation, NotificationChain msgs)
  {
    OperationRef oldOperation = operation;
    operation = newOperation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__OPERATION, oldOperation, newOperation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperation(OperationRef newOperation)
  {
    if (newOperation != operation)
    {
      NotificationChain msgs = null;
      if (operation != null)
        msgs = ((InternalEObject)operation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__OPERATION, null, msgs);
      if (newOperation != null)
        msgs = ((InternalEObject)newOperation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__OPERATION, null, msgs);
      msgs = basicSetOperation(newOperation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__OPERATION, newOperation, newOperation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Parameter> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__PARAMETERS);
    }
    return parameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeExp getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(TypeExp newType, NotificationChain msgs)
  {
    TypeExp oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(TypeExp newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Pre> getPres()
  {
    if (pres == null)
    {
      pres = new EObjectContainmentEList<Pre>(Pre.class, this, BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__PRES);
    }
    return pres;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Post> getPosts()
  {
    if (posts == null)
    {
      posts = new EObjectContainmentEList<Post>(Post.class, this, BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__POSTS);
    }
    return posts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Body> getBodies()
  {
    if (bodies == null)
    {
      bodies = new EObjectContainmentEList<Body>(Body.class, this, BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__BODIES);
    }
    return bodies;
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
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__OPERATION:
        return basicSetOperation(null, msgs);
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__TYPE:
        return basicSetType(null, msgs);
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__PRES:
        return ((InternalEList<?>)getPres()).basicRemove(otherEnd, msgs);
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__POSTS:
        return ((InternalEList<?>)getPosts()).basicRemove(otherEnd, msgs);
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__BODIES:
        return ((InternalEList<?>)getBodies()).basicRemove(otherEnd, msgs);
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
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__OPERATION:
        return getOperation();
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__PARAMETERS:
        return getParameters();
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__TYPE:
        return getType();
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__PRES:
        return getPres();
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__POSTS:
        return getPosts();
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__BODIES:
        return getBodies();
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
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__OPERATION:
        setOperation((OperationRef)newValue);
        return;
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends Parameter>)newValue);
        return;
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__TYPE:
        setType((TypeExp)newValue);
        return;
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__PRES:
        getPres().clear();
        getPres().addAll((Collection<? extends Pre>)newValue);
        return;
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__POSTS:
        getPosts().clear();
        getPosts().addAll((Collection<? extends Post>)newValue);
        return;
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__BODIES:
        getBodies().clear();
        getBodies().addAll((Collection<? extends Body>)newValue);
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
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__OPERATION:
        setOperation((OperationRef)null);
        return;
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__PARAMETERS:
        getParameters().clear();
        return;
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__TYPE:
        setType((TypeExp)null);
        return;
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__PRES:
        getPres().clear();
        return;
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__POSTS:
        getPosts().clear();
        return;
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__BODIES:
        getBodies().clear();
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
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__OPERATION:
        return operation != null;
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__TYPE:
        return type != null;
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__PRES:
        return pres != null && !pres.isEmpty();
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__POSTS:
        return posts != null && !posts.isEmpty();
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL__BODIES:
        return bodies != null && !bodies.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //OperationContextDeclImpl
