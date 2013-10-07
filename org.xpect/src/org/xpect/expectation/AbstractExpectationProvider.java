package org.xpect.expectation;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import org.xpect.parameter.IParameterParser.IParsedParameterProvider;
import org.xpect.state.StateContainer;
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
	public <T> T get(Class<T> expectedType, StateContainer context) {
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

	private ITargetSyntaxSupport getTargetSyntax(StateContainer context) {
		return context.get(ITargetSyntaxSupport.class, ITargetSyntaxSupport.Annotation.class).get();
	}

}
