/**
 * <copyright>
 * </copyright>
 *
 * $Id: GrammarImpl.java,v 1.12 2008/08/07 15:05:35 sefftinge Exp $
 */
package org.eclipse.xtext.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grammar</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.impl.GrammarImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.xtext.impl.GrammarImpl#getIdElements <em>Id Elements</em>}</li>
 *   <li>{@link org.eclipse.xtext.impl.GrammarImpl#getLexerRules <em>Lexer Rules</em>}</li>
 *   <li>{@link org.eclipse.xtext.impl.GrammarImpl#getParserRules <em>Parser Rules</em>}</li>
 *   <li>{@link org.eclipse.xtext.impl.GrammarImpl#getSuperGrammarIdElements <em>Super Grammar Id Elements</em>}</li>
 *   <li>{@link org.eclipse.xtext.impl.GrammarImpl#getMetamodelDeclarations <em>Metamodel Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GrammarImpl extends EObjectImpl implements Grammar
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
	 * The cached value of the '{@link #getIdElements() <em>Id Elements</em>}' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getIdElements()
	 * @generated
	 * @ordered
	 */
  protected EList<String> idElements;

		/**
	 * The cached value of the '{@link #getLexerRules() <em>Lexer Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLexerRules()
	 * @generated
	 * @ordered
	 */
  protected EList<LexerRule> lexerRules;

		/**
	 * The cached value of the '{@link #getParserRules() <em>Parser Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getParserRules()
	 * @generated
	 * @ordered
	 */
  protected EList<ParserRule> parserRules;

		/**
	 * The cached value of the '{@link #getSuperGrammarIdElements() <em>Super Grammar Id Elements</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperGrammarIdElements()
	 * @generated
	 * @ordered
	 */
	protected EList<String> superGrammarIdElements;

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
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected GrammarImpl()
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
		return XtextPackage.Literals.GRAMMAR;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<ParserRule> getParserRules()
  {
		if (parserRules == null) {
			parserRules = new EObjectContainmentEList<ParserRule>(ParserRule.class, this, XtextPackage.GRAMMAR__PARSER_RULES);
		}
		return parserRules;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSuperGrammarIdElements() {
		if (superGrammarIdElements == null) {
			superGrammarIdElements = new EDataTypeUniqueEList<String>(String.class, this, XtextPackage.GRAMMAR__SUPER_GRAMMAR_ID_ELEMENTS);
		}
		return superGrammarIdElements;
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<String> getIdElements()
  {
		if (idElements == null) {
			idElements = new EDataTypeUniqueEList<String>(String.class, this, XtextPackage.GRAMMAR__ID_ELEMENTS);
		}
		return idElements;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<AbstractMetamodelDeclaration> getMetamodelDeclarations()
  {
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
  public EList<LexerRule> getLexerRules()
  {
		if (lexerRules == null) {
			lexerRules = new EObjectContainmentEList<LexerRule>(LexerRule.class, this, XtextPackage.GRAMMAR__LEXER_RULES);
		}
		return lexerRules;
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
			eNotify(new ENotificationImpl(this, Notification.SET, XtextPackage.GRAMMAR__ABSTRACT, oldAbstract, abstract_));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case XtextPackage.GRAMMAR__LEXER_RULES:
				return ((InternalEList<?>)getLexerRules()).basicRemove(otherEnd, msgs);
			case XtextPackage.GRAMMAR__PARSER_RULES:
				return ((InternalEList<?>)getParserRules()).basicRemove(otherEnd, msgs);
			case XtextPackage.GRAMMAR__METAMODEL_DECLARATIONS:
				return ((InternalEList<?>)getMetamodelDeclarations()).basicRemove(otherEnd, msgs);
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
		switch (featureID) {
			case XtextPackage.GRAMMAR__ABSTRACT:
				return isAbstract() ? Boolean.TRUE : Boolean.FALSE;
			case XtextPackage.GRAMMAR__ID_ELEMENTS:
				return getIdElements();
			case XtextPackage.GRAMMAR__LEXER_RULES:
				return getLexerRules();
			case XtextPackage.GRAMMAR__PARSER_RULES:
				return getParserRules();
			case XtextPackage.GRAMMAR__SUPER_GRAMMAR_ID_ELEMENTS:
				return getSuperGrammarIdElements();
			case XtextPackage.GRAMMAR__METAMODEL_DECLARATIONS:
				return getMetamodelDeclarations();
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
		switch (featureID) {
			case XtextPackage.GRAMMAR__ABSTRACT:
				setAbstract(((Boolean)newValue).booleanValue());
				return;
			case XtextPackage.GRAMMAR__ID_ELEMENTS:
				getIdElements().clear();
				getIdElements().addAll((Collection<? extends String>)newValue);
				return;
			case XtextPackage.GRAMMAR__LEXER_RULES:
				getLexerRules().clear();
				getLexerRules().addAll((Collection<? extends LexerRule>)newValue);
				return;
			case XtextPackage.GRAMMAR__PARSER_RULES:
				getParserRules().clear();
				getParserRules().addAll((Collection<? extends ParserRule>)newValue);
				return;
			case XtextPackage.GRAMMAR__SUPER_GRAMMAR_ID_ELEMENTS:
				getSuperGrammarIdElements().clear();
				getSuperGrammarIdElements().addAll((Collection<? extends String>)newValue);
				return;
			case XtextPackage.GRAMMAR__METAMODEL_DECLARATIONS:
				getMetamodelDeclarations().clear();
				getMetamodelDeclarations().addAll((Collection<? extends AbstractMetamodelDeclaration>)newValue);
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
		switch (featureID) {
			case XtextPackage.GRAMMAR__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case XtextPackage.GRAMMAR__ID_ELEMENTS:
				getIdElements().clear();
				return;
			case XtextPackage.GRAMMAR__LEXER_RULES:
				getLexerRules().clear();
				return;
			case XtextPackage.GRAMMAR__PARSER_RULES:
				getParserRules().clear();
				return;
			case XtextPackage.GRAMMAR__SUPER_GRAMMAR_ID_ELEMENTS:
				getSuperGrammarIdElements().clear();
				return;
			case XtextPackage.GRAMMAR__METAMODEL_DECLARATIONS:
				getMetamodelDeclarations().clear();
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
		switch (featureID) {
			case XtextPackage.GRAMMAR__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case XtextPackage.GRAMMAR__ID_ELEMENTS:
				return idElements != null && !idElements.isEmpty();
			case XtextPackage.GRAMMAR__LEXER_RULES:
				return lexerRules != null && !lexerRules.isEmpty();
			case XtextPackage.GRAMMAR__PARSER_RULES:
				return parserRules != null && !parserRules.isEmpty();
			case XtextPackage.GRAMMAR__SUPER_GRAMMAR_ID_ELEMENTS:
				return superGrammarIdElements != null && !superGrammarIdElements.isEmpty();
			case XtextPackage.GRAMMAR__METAMODEL_DECLARATIONS:
				return metamodelDeclarations != null && !metamodelDeclarations.isEmpty();
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
		result.append(", idElements: ");
		result.append(idElements);
		result.append(", superGrammarIdElements: ");
		result.append(superGrammarIdElements);
		result.append(')');
		return result.toString();
	}

} //GrammarImpl
