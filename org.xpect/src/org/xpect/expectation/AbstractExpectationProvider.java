package org.xpect.expectation;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.xpect.parameter.IParameterParser.IParsedParameterProvider;
import org.xpect.parameter.IParameterProvider;
import org.xpect.text.IRegion;

import com.google.common.base.Preconditions;

public abstract class AbstractExpectationProvider<E> implements IParsedParameterProvider {
	private final IExpectationRegion region;

	public AbstractExpectationProvider(IExpectationRegion region) {
		super();
		Preconditions.checkPositionIndex(region.getOffset(), region.getDocument().length());
		Preconditions.checkPositionIndex(region.getOffset() + region.getLength(), region.getDocument().length());
		this.region = region;
	}

	public boolean canProvide(Class<?> expectedType) {
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		Class<?> param = (Class<?>) type.getActualTypeArguments()[0];
		return expectedType.isAssignableFrom(param);
	}

	protected abstract E createExpectation(ITargetSyntaxSupport targetSyntax);

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> expectedType, Map<Class<? extends Annotation>, IParameterProvider> context) {
		if (canProvide(expectedType))
			return (T) createExpectation(getTargetSyntax(context));
		return null;
	}

	public IExpectationRegion getClaimedRegion() {
		return region;
	}

	public List<IRegion> getSemanticRegions() {
		return Collections.<IRegion> singletonList(region);
	}

	private ITargetSyntaxSupport getTargetSyntax(Map<Class<? extends Annotation>, IParameterProvider> context) {
		IParameterProvider provider = context.get(ITargetSyntaxSupport.Annotation.class);
		if (provider != null)
			return provider.get(ITargetSyntaxSupport.class, context);
		return null;
	}

}
