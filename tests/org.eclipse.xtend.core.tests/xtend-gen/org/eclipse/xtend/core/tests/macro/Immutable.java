package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.core.tests.macro.ImmutableProcessor;
import org.eclipse.xtend.lib.macro.Active;

@Active(ImmutableProcessor.class)
public @interface Immutable {
}
