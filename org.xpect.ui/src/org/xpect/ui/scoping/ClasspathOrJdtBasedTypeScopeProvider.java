package org.xpect.ui.scoping;

import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.IJdtTypeProvider;
import org.eclipse.xtext.common.types.xtext.AbstractConstructorScope;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScope;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.common.types.xtext.ClasspathBasedConstructorScope;
import org.eclipse.xtext.common.types.xtext.ClasspathBasedTypeScope;
import org.eclipse.xtext.common.types.xtext.ui.JdtBasedConstructorScope;
import org.eclipse.xtext.common.types.xtext.ui.JdtBasedSimpleTypeScope;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class ClasspathOrJdtBasedTypeScopeProvider extends AbstractTypeScopeProvider {

	@Inject
	private ClasspathOrJdtBasedTypeScopeProviderFactory typeProviderFactory;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Override
	public AbstractTypeScope createTypeScope(IJvmTypeProvider typeProvider, Predicate<IEObjectDescription> filter) {
		if (typeProvider instanceof ClasspathTypeProvider)
			return new ClasspathBasedTypeScope((ClasspathTypeProvider) typeProvider, qualifiedNameConverter, filter);
		if (typeProvider instanceof IJdtTypeProvider)
			return new JdtBasedSimpleTypeScope((IJdtTypeProvider) typeProvider, qualifiedNameConverter, filter);
		throw new IllegalStateException();
	}

	@Override
	public AbstractConstructorScope createConstructorScope(IJvmTypeProvider typeProvider, Predicate<IEObjectDescription> filter) {
		AbstractTypeScope typeScope = createTypeScope(typeProvider, filter);
		if (typeScope instanceof ClasspathBasedTypeScope)
			return new ClasspathBasedConstructorScope((ClasspathBasedTypeScope) typeScope);
		if (typeScope instanceof JdtBasedSimpleTypeScope)
			return new JdtBasedConstructorScope((JdtBasedSimpleTypeScope) typeScope);
		throw new IllegalStateException();
	}

	@Override
	public IJvmTypeProvider.Factory getTypeProviderFactory() {
		return typeProviderFactory;
	}

}
