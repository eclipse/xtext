package org.eclipse.xtext.util;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 * @param <S1>
 * @param <S2>
 * @param <S3>
 */
public final class Triple<S1, S2, S3> extends Pair<S1, S2>{
	
	private final S3 third;
	
	Triple(final S1 first, final S2 second, final S3 third) {
		super(first,second);
		this.third = third;
	}
	
	public S3 getThird() {
		return third;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Triple<?,?,?>) {
			Triple<?,?,?> r = (Triple<?,?,?>) other;
			return super.equals(other) && getThird().equals(r.getThird());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode()+getThird().hashCode();
	}
	
	@Override
	public String toString() {
		return "Triple("+getFirst()+","+getSecond()+","+getThird()+")";
	}
	
}
