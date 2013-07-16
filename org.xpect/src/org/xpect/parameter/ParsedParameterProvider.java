package org.xpect.parameter;

import java.util.Collections;
import java.util.List;

import org.xpect.parameter.IParameterParser.IParsedParameterProvider;
import org.xpect.text.IRegion;

public class ParsedParameterProvider extends ParameterProvider implements IParsedParameterProvider {

	protected final IRegion claim;
	protected final IRegion sem;

	public ParsedParameterProvider(Object value, IRegion claim, IRegion sem) {
		super(value);
		this.claim = claim;
		this.sem = sem;
	}

	public IRegion getClaimedRegion() {
		return claim;
	}

	public List<IRegion> getSemanticRegions() {
		return Collections.singletonList(sem);
	}

}
