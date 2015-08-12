/**
 */
package org.eclipse.xtext.impl;

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

import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grammar</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.impl.GrammarImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.impl.GrammarImpl#getUsedGrammars <em>Used Grammars</em>}</li>
 *   <li>{@link org.eclipse.xtext.impl.GrammarImpl#isDefinesHiddenTokens <em>Defines Hidden Tokens</em>}</li>
 *   <li>{@link org.eclipse.xtext.impl.GrammarImpl#getHiddenTokens <em>Hidden Tokens</em>}</li>
 *   <li>{@link org.eclipse.xtext.impl.GrammarImpl#getMetamodelDeclarations <em>Metamodel Declarations</em>}</li>
 *   <li>{@link org.eclipse.xtext.impl.GrammarImpl#getRules <em>Rules</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GrammarImpl extends MinimalEObjectImpl.Container implements Grammar {
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
	 * The cached value of the '{@link #getUsedGrammars() <em>Used Grammars</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedGrammars()
	 * @generated
	 * @ordered
	 */
	protected EList<Grammar> usedGrammars;

	/**
	 * The default value of the '{@link #isDefinesHiddenTokens() <em>Defines Hidden Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefinesHiddenTokens()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEFINES_HIDDEN_TOKENS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDefinesHiddenTokens() <em>Defines Hidden Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefinesHiddenTokens()
	 * @generated
	 * @ordered
	 */
	protected boolean definesHiddenTokens = DEFINES_HIDDEN_TOKENS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHiddenTokens() <em>Hidden Tokens</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHiddenTokens()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractRule> hiddenTokens;

	/**
	 * The cached value of the '{@link #getMetamodelDeclarations() <em>Metamodel Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodelDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractMetamodelDeclaration> metamodelDeclarations;

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractRule> rules;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GrammarImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XtextPackage.Literals.GRAMMAR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextPackage.GRAMMAR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Grammar> getUsedGrammars() {
		if (usedGrammars == null) {
			usedGrammars = new EObjectResolvingEList<Grammar>(Grammar.class, this, XtextPackage.GRAMMAR__USED_GRAMMARS);
		}
		return usedGrammars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDefinesHiddenTokens() {
		return definesHiddenTokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinesHiddenTokens(boolean newDefinesHiddenTokens) {
		boolean oldDefinesHiddenTokens = definesHiddenTokens;
		definesHiddenTokens = newDefinesHiddenTokens;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextPackage.GRAMMAR__DEFINES_HIDDEN_TOKENS, oldDefinesHiddenTokens, definesHiddenTokens));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractRule> getHiddenTokens() {
		if (hiddenTokens == null) {
			hiddenTokens = new EObjectResolvingEList<AbstractRule>(AbstractRule.class, this, XtextPackage.GRAMMAR__HIDDEN_TOKENS);
		}
		return hiddenTokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractMetamodelDeclaration> getMetamodelDeclarations() {
		if (metamodelDeclarations == null) {
			metamodelDeclarations = new EObjectContainmentEList<AbstractMetamodelDeclaration>(AbstractMetamodelDeclaration.class, this, XtextPackage.GRAMMAR__METAMODEL_DECLARATIONS);
		}
		return metamodelDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractRule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<AbstractRule>(AbstractRule.class, this, XtextPackage.GRAMMAR__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XtextPackage.GRAMMAR__METAMODEL_DECLARATIONS:
				return ((InternalEList<?>)getMetamodelDeclarations()).basicRemove(otherEnd, msgs);
			case XtextPackage.GRAMMAR__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XtextPackage.GRAMMAR__NAME:
				return getName();
			case XtextPackage.GRAMMAR__USED_GRAMMARS:
				return getUsedGrammars();
			case XtextPackage.GRAMMAR__DEFINES_HIDDEN_TOKENS:
				return isDefinesHiddenTokens();
			case XtextPackage.GRAMMAR__HIDDEN_TOKENS:
				return getHiddenTokens();
			case XtextPackage.GRAMMAR__METAMODEL_DECLARATIONS:
				return getMetamodelDeclarations();
			case XtextPackage.GRAMMAR__RULES:
				return getRules();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XtextPackage.GRAMMAR__NAME:
				setName((String)newValue);
				return;
			case XtextPackage.GRAMMAR__USED_GRAMMARS:
				getUsedGrammars().clear();
				getUsedGrammars().addAll((Collection<? extends Grammar>)newValue);
				return;
			case XtextPackage.GRAMMAR__DEFINES_HIDDEN_TOKENS:
				setDefinesHiddenTokens((Boolean)newValue);
				return;
			case XtextPackage.GRAMMAR__HIDDEN_TOKENS:
				getHiddenTokens().clear();
				getHiddenTokens().addAll((Collection<? extends AbstractRule>)newValue);
				return;
			case XtextPackage.GRAMMAR__METAMODEL_DECLARATIONS:
				getMetamodelDeclarations().clear();
				getMetamodelDeclarations().addAll((Collection<? extends AbstractMetamodelDeclaration>)newValue);
				return;
			case XtextPackage.GRAMMAR__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends AbstractRule>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case XtextPackage.GRAMMAR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case XtextPackage.GRAMMAR__USED_GRAMMARS:
				getUsedGrammars().clear();
				return;
			case XtextPackage.GRAMMAR__DEFINES_HIDDEN_TOKENS:
				setDefinesHiddenTokens(DEFINES_HIDDEN_TOKENS_EDEFAULT);
				return;
			case XtextPackage.GRAMMAR__HIDDEN_TOKENS:
				getHiddenTokens().clear();
				return;
			case XtextPackage.GRAMMAR__METAMODEL_DECLARATIONS:
				getMetamodelDeclarations().clear();
				return;
			case XtextPackage.GRAMMAR__RULES:
				getRules().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case XtextPackage.GRAMMAR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case XtextPackage.GRAMMAR__USED_GRAMMARS:
				return usedGrammars != null && !usedGrammars.isEmpty();
			case XtextPackage.GRAMMAR__DEFINES_HIDDEN_TOKENS:
				return definesHiddenTokens != DEFINES_HIDDEN_TOKENS_EDEFAULT;
			case XtextPackage.GRAMMAR__HIDDEN_TOKENS:
				return hiddenTokens != null && !hiddenTokens.isEmpty();
			case XtextPackage.GRAMMAR__METAMODEL_DECLARATIONS:
				return metamodelDeclarations != null && !metamodelDeclarations.isEmpty();
			case XtextPackage.GRAMMAR__RULES:
				return rules != null && !rules.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", definesHiddenTokens: ");
		result.append(definesHiddenTokens);
		result.append(')');
		return result.toString();
	}

} //GrammarImpl
