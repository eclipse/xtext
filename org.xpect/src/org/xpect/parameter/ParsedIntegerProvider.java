package org.xpect.parameter;

import java.util.Collections;
import java.util.List;

import org.xpect.parameter.IParameterParser.IParsedParameterProvider;
import org.xpect.util.IRegion;

public class ParsedIntegerProvider extends IntegerProvider implements IParsedParameterProvider {

	protected final IRegion claim;
	protected final IRegion sem;

	public ParsedIntegerProvider(String value, IRegion claim, IRegion sem) {
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
