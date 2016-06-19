/**
 */
package org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage
 * @generated
 */
public class HiddentokenmergertestAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static HiddentokenmergertestPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HiddentokenmergertestAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = HiddentokenmergertestPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HiddentokenmergertestSwitch<Adapter> modelSwitch =
    new HiddentokenmergertestSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseDatatypeBug286557(DatatypeBug286557 object)
      {
        return createDatatypeBug286557Adapter();
      }
      @Override
      public Adapter caseEnumBug(EnumBug object)
      {
        return createEnumBugAdapter();
      }
      @Override
      public Adapter caseCommentable(Commentable object)
      {
        return createCommentableAdapter();
      }
      @Override
      public Adapter caseCommentableItem(CommentableItem object)
      {
        return createCommentableItemAdapter();
      }
      @Override
      public Adapter caseValueList(ValueList object)
      {
        return createValueListAdapter();
      }
      @Override
      public Adapter caseRefList(RefList object)
      {
        return createRefListAdapter();
      }
      @Override
      public Adapter caseRefObj(RefObj object)
      {
        return createRefObjAdapter();
      }
      @Override
      public Adapter caseSingleRef(SingleRef object)
      {
        return createSingleRefAdapter();
      }
      @Override
      public Adapter caseAppendToFileEnd(AppendToFileEnd object)
      {
        return createAppendToFileEndAdapter();
      }
      @Override
      public Adapter caseAppendToFileEndItem(AppendToFileEndItem object)
      {
        return createAppendToFileEndItemAdapter();
      }
      @Override
      public Adapter caseAction1(Action1 object)
      {
        return createAction1Adapter();
      }
      @Override
      public Adapter caseAction1Sub1(Action1Sub1 object)
      {
        return createAction1Sub1Adapter();
      }
      @Override
      public Adapter caseAction1Sub2(Action1Sub2 object)
      {
        return createAction1Sub2Adapter();
      }
      @Override
      public Adapter caseAction1Sub(Action1Sub object)
      {
        return createAction1SubAdapter();
      }
      @Override
      public Adapter caseAction1SubClass(Action1SubClass object)
      {
        return createAction1SubClassAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.DatatypeBug286557 <em>Datatype Bug286557</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.DatatypeBug286557
   * @generated
   */
  public Adapter createDatatypeBug286557Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBug <em>Enum Bug</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBug
   * @generated
   */
  public Adapter createEnumBugAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Commentable <em>Commentable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Commentable
   * @generated
   */
  public Adapter createCommentableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.CommentableItem <em>Commentable Item</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.CommentableItem
   * @generated
   */
  public Adapter createCommentableItemAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.ValueList <em>Value List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.ValueList
   * @generated
   */
  public Adapter createValueListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefList <em>Ref List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefList
   * @generated
   */
  public Adapter createRefListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefObj <em>Ref Obj</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefObj
   * @generated
   */
  public Adapter createRefObjAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.SingleRef <em>Single Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.SingleRef
   * @generated
   */
  public Adapter createSingleRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.AppendToFileEnd <em>Append To File End</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.AppendToFileEnd
   * @generated
   */
  public Adapter createAppendToFileEndAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.AppendToFileEndItem <em>Append To File End Item</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.AppendToFileEndItem
   * @generated
   */
  public Adapter createAppendToFileEndItemAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Action1 <em>Action1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Action1
   * @generated
   */
  public Adapter createAction1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Action1Sub1 <em>Action1 Sub1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Action1Sub1
   * @generated
   */
  public Adapter createAction1Sub1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Action1Sub2 <em>Action1 Sub2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Action1Sub2
   * @generated
   */
  public Adapter createAction1Sub2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Action1Sub <em>Action1 Sub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Action1Sub
   * @generated
   */
  public Adapter createAction1SubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Action1SubClass <em>Action1 Sub Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Action1SubClass
   * @generated
   */
  public Adapter createAction1SubClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //HiddentokenmergertestAdapterFactory
