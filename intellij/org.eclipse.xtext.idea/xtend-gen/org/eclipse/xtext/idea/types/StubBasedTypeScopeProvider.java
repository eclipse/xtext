package org.eclipse.xtext.idea.types;

import com.google.common.base.Predicate;
import com.google.inject.Inject;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.idea.types.StubBasedConstructorScope;
import org.eclipse.xtext.idea.types.StubBasedTypeScope;
import org.eclipse.xtext.idea.types.access.StubJvmTypeProvider;
import org.eclipse.xtext.idea.types.access.StubTypeProviderFactory;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class StubBasedTypeScopeProvider extends AbstractTypeScopeProvider {
  @Inject
  @Accessors
  private StubTypeProviderFactory typeProviderFactory;
  
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  public StubBasedConstructorScope createConstructorScope(final IJvmTypeProvider typeProvider, final Predicate<IEObjectDescription> filter) {
    StubBasedTypeScope _createTypeScope = this.createTypeScope(typeProvider, filter);
    return new StubBasedConstructorScope(_createTypeScope);
  }
  
  public StubBasedTypeScope createTypeScope(final IJvmTypeProvider typeProvider, final Predicate<IEObjectDescription> filter) {
    return new StubBasedTypeScope(((StubJvmTypeProvider) typeProvider), this.qualifiedNameConverter, filter);
  }
  
  @Pure
  public StubTypeProviderFactory getTypeProviderFactory() {
    return this.typeProviderFactory;
  }
  
  public void setTypeProviderFactory(final StubTypeProviderFactory typeProviderFactory) {
    this.typeProviderFactory = typeProviderFactory;
  }
}
