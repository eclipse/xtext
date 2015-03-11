package org.eclipse.xtext.serializer.tokens;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.google.inject.BindingAnnotation;

/**
 * Indicates that a scope provider is requested that is used
 * to serialize existing cross references.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.4
 */
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
public @interface SerializerScopeProviderBinding {}