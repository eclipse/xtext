package org.eclipse.xtext.statefullexer;

import org.eclipse.xtext.util.formallang.DirectedGraph;
import org.eclipse.xtext.util.formallang.Traverser;

@SuppressWarnings("restriction")
public interface GroupingTraverser<DG extends DirectedGraph<S>, S, R, G> extends Traverser<DG, S, R> {

	G getGroup(R result);

}
