package org.eclipse.xtext.xbase.junit.typesystem;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.StackedResolvedTypes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
@SuppressWarnings("all")
public class PublicStackedResolvedTypes extends StackedResolvedTypes {
  public PublicStackedResolvedTypes(final ResolvedTypes parent) {
    super(parent);
  }
}
