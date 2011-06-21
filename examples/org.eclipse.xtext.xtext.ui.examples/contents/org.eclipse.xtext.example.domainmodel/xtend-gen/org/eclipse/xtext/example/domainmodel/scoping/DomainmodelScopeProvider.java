package org.eclipse.xtext.example.domainmodel.scoping;

import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.scoping.LocalVariableScopeContext;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;

@SuppressWarnings("all")
public class DomainmodelScopeProvider extends XbaseScopeProvider {
  
  @Inject
  private IJvmModelAssociations associations;
  
  public IScope createLocalVarScope(final IScope parent, final LocalVariableScopeContext scopeContext) {
    {
      EObject _context = scopeContext.getContext();
      final EObject context = _context;
      boolean matched = false;
      if (!matched) {
        if (context instanceof Entity) {
          final Entity context_1 = (Entity) context;
          matched=true;
          {
            JvmType _jvmType = this.getJvmType(context_1);
            final JvmType jvmType = _jvmType;
            boolean _operator_notEquals = ObjectExtensions.operator_notEquals(jvmType, null);
            if (_operator_notEquals) {
              IEObjectDescription _create = EObjectDescription.create(XbaseScopeProvider.THIS, jvmType);
              Set<IEObjectDescription> _singleton = Collections.<IEObjectDescription>singleton(_create);
              SimpleScope _simpleScope = new SimpleScope(parent, _singleton);
              return _simpleScope;
            }
          }
        }
      }
      if (!matched) {
        if (context instanceof Operation) {
          final Operation context_2 = (Operation) context;
          matched=true;
          {
            EList<JvmFormalParameter> _params = context_2.getParams();
            final Function1<JvmFormalParameter,IEObjectDescription> _function = new Function1<JvmFormalParameter,IEObjectDescription>() {
                public IEObjectDescription apply(final JvmFormalParameter e) {
                  IEObjectDescription _createIEObjectDescription = DomainmodelScopeProvider.this.createIEObjectDescription(e);
                  return _createIEObjectDescription;
                }
              };
            List<IEObjectDescription> _map = ListExtensions.<JvmFormalParameter, IEObjectDescription>map(_params, _function);
            final List<IEObjectDescription> descriptions = _map;
            IScope _createLocalVarScope = super.createLocalVarScope(parent, scopeContext);
            IScope _createScope = MapBasedScope.createScope(_createLocalVarScope, descriptions);
            return _createScope;
          }
        }
      }
      IScope _createLocalVarScope_1 = super.createLocalVarScope(parent, scopeContext);
      return _createLocalVarScope_1;
    }
  }
  
  public IEObjectDescription createIEObjectDescription(final JvmFormalParameter jvmFormalParameter) {
    String _name = jvmFormalParameter.getName();
    QualifiedName _create = QualifiedName.create(_name);
    IEObjectDescription _create_1 = EObjectDescription.create(_create, jvmFormalParameter, null);
    return _create_1;
  }
  
  public JvmType getJvmType(final Entity entity) {
    Set<EObject> _jvmElements = this.associations.getJvmElements(entity);
    Iterable<JvmType> _filter = IterableExtensions.<JvmType>filter(_jvmElements, org.eclipse.xtext.common.types.JvmType.class);
    JvmType _head = IterableExtensions.<JvmType>head(_filter);
    return _head;
  }
  
  public JvmDeclaredType getContextType(final EObject call) {
    {
      boolean _operator_equals = ObjectExtensions.operator_equals(call, null);
      if (_operator_equals) {
        return null;
      }
      Entity _containerOfType = EcoreUtil2.<Entity>getContainerOfType(call, org.eclipse.xtext.example.domainmodel.domainmodel.Entity.class);
      final Entity containerClass = _containerOfType;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(containerClass, null);
      if (_operator_notEquals) {
        JvmType _jvmType = this.getJvmType(containerClass);
        return ((JvmDeclaredType) _jvmType);
      } else {
        JvmDeclaredType _contextType = super.getContextType(call);
        return _contextType;
      }
    }
  }
}