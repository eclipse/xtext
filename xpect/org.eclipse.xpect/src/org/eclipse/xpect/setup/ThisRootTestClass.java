package org.eclipse.xpect.setup;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.eclipse.xpect.state.XpectStateAnnotation;

@XpectStateAnnotation
@Retention(RetentionPolicy.RUNTIME)
public @interface ThisRootTestClass {

}
