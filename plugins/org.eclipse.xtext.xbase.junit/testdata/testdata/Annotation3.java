package testdata;

/**
 * @since 2.5
 */
public @interface Annotation3 {
	boolean booleanValue() default true;
	int intValue() default 1;
	long longValue() default 42;
	String stringValue() default "foo";
	
	boolean[] booleanArrayValue() default {true};
	int[] intArrayValue() default {42};
	long[] longArrayValue() default {99};
	String[] stringArrayValue() default {"foo"};
	
	Class<?> typeValue() default String.class;
	Class<?>[] typeArrayValue() default {String.class};
	
	Annotation2 annotation2Value() default @Annotation2({"foo"});
	Annotation2[] annotation2ArrayValue() default {@Annotation2({"foo"})};
	
	Enum1 enumValue() default Enum1.BLUE; 
	Enum1[] enumArrayValue() default {Enum1.BLUE}; 
}
