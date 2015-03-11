/*
 * Copyright (C) 2011 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.eclipse.xtext.xbase.junit.typesystem;

import static com.google.common.base.Preconditions.*;
import static com.google.common.primitives.UnsignedBytes.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import com.google.common.annotations.Beta;
import com.google.common.primitives.Ints;

/**
 * A simplified variant of com.google.common.hash.BloomFilter 
 * {@linkplain <a href="http://guava-libraries.googlecode.com/git/guava/src/com/google/common/hash/BloomFilter.java">BloomFilter.java</a>}
 * 
 * It can only work with Strings.
 * 
 * @author Dimitris Andreou
 * @author Kevin Bourrillion
 * @deprecated This trimmed down copy of Guava's real bloom filter will be removed in Xtext 2.8
 */
@Deprecated
@Beta
public final class SimpleBloomFilter {

	/** The bit set of the BloomFilter (not necessarily power of 2!) */
	private final BitArray bits;

	/** Number of hashes per element */
	private final int numHashFunctions;

	/**
	 * Creates a BloomFilter.
	 */
	private SimpleBloomFilter(BitArray bits, int numHashFunctions) {
		checkArgument(numHashFunctions > 0, "numHashFunctions (%s) must be > 0", numHashFunctions);
		checkArgument(numHashFunctions <= 255, "numHashFunctions (%s) must be <= 255", numHashFunctions);
		this.bits = checkNotNull(bits);
		this.numHashFunctions = numHashFunctions;
	}

	/**
	 * Returns {@code true} if the element <i>might</i> have been put in this Bloom filter, {@code false} if this is
	 * <i>definitely</i> not the case.
	 */
	public boolean mightContain(String object) {
		long hash64 = hashString(object);
		int hash1 = (int) hash64;
		int hash2 = (int) (hash64 >>> 32);
		for (int i = 1; i <= numHashFunctions; i++) {
			int nextHash = hash1 + i * hash2;
			if (nextHash < 0) {
				nextHash = ~nextHash;
			}
			if (!bits.get(nextHash % bits.size())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Puts an element into this {@code BloomFilter}. Ensures that subsequent invocations of
	 * {@link #mightContain(String)} with the same element will always return {@code true}.
	 * 
	 * @return true if the bloom filter's bits changed as a result of this operation. If the bits changed, this is
	 *         <i>definitely</i> the first time {@code object} has been added to the filter. If the bits haven't
	 *         changed, this <i>might</i> be the first time {@code object} has been added to the filter. Note that
	 *         {@code put(t)} always returns the <i>opposite</i> result to what {@code mightContain(t)} would have
	 *         returned at the time it is called."
	 */
	public boolean put(String object) {
		long hash64 = hashString(object);
		int hash1 = (int) hash64;
		int hash2 = (int) (hash64 >>> 32);
		boolean bitsChanged = false;
		for (int i = 1; i <= numHashFunctions; i++) {
			int nextHash = hash1 + i * hash2;
			if (nextHash < 0) {
				nextHash = ~nextHash;
			}
			bitsChanged |= bits.set(nextHash % bits.size());
		}
		return bitsChanged;
	}

	public static SimpleBloomFilter create(int expectedInsertions, double fpp) {
		if (expectedInsertions == 0) {
			expectedInsertions = 1;
		}
		long numBits = optimalNumOfBits(expectedInsertions, fpp);
		int numHashFunctions = optimalNumOfHashFunctions(expectedInsertions, numBits);
		try {
			return new SimpleBloomFilter(new BitArray(numBits), numHashFunctions);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Could not create BloomFilter of " + numBits + " bits", e);
		}
	}

	/**
	 * Creates a {@code Builder} of a   {@link SimpleBloomFilter}, with the expected number of insertions, and a
	 * default expected false positive probability of 3%.
	 * 
	 * <p>
	 * Note that overflowing a {@code SimpleBloomFilter} with significantly more elements than specified, will result in its
	 * saturation, and a sharp deterioration of its false positive probability.
	 * 
	 * <p>
	 * The constructed {@code SimpleBloomFilter<T>} will be serializable if the provided {@code Funnel<T>} is.
	 * 
	 * @param expectedInsertions
	 *            the number of expected insertions to the constructed {@code SimpleBloomFilter<T>}; must be positive
	 * @return a {@code SimpleBloomFilter}
	 */
	public static SimpleBloomFilter create(int expectedInsertions) {
		return create(expectedInsertions, 0.03); // FYI, for 3%, we always get 5 hash functions
	}

	/*
	 * Cheat sheet:
	 *
	 * m: total bits
	 * n: expected insertions
	 * b: m/n, bits per insertion

	 * p: expected false positive probability
	 *
	 * 1) Optimal k = b * ln2
	 * 2) p = (1 - e ^ (-kn/m))^k
	 * 3) For optimal k: p = 2 ^ (-k) ~= 0.6185^b
	 * 4) For optimal k: m = -nlnp / ((ln2) ^ 2)
	 */

	/**
	 * Computes the optimal k (number of hashes per element inserted in Bloom filter), given the expected insertions and
	 * total number of bits in the Bloom filter.
	 * 
	 * See http://en.wikipedia.org/wiki/File:Bloom_filter_fp_probability.svg for the formula.
	 * 
	 * @param n
	 *            expected insertions (must be positive)
	 * @param m
	 *            total number of bits in Bloom filter (must be positive)
	 */
	static int optimalNumOfHashFunctions(long n, long m) {
		return Math.max(1, (int) Math.round(m / n * Math.log(2)));
	}

	/**
	 * Computes m (total bits of Bloom filter) which is expected to achieve, for the specified expected insertions, the
	 * required false positive probability.
	 * 
	 * See http://en.wikipedia.org/wiki/Bloom_filter#Probability_of_false_positives for the formula.
	 * 
	 * @param n
	 *            expected insertions (must be positive)
	 * @param p
	 *            false positive rate (must be 0 < p < 1)
	 */
	static long optimalNumOfBits(long n, double p) {
		if (p == 0) {
			p = Double.MIN_VALUE;
		}
		return (long) (-n * Math.log(p) / (Math.log(2) * Math.log(2)));
	}

	// Note: We use this instead of java.util.BitSet because we need access to the long[] data field
	static class BitArray {
		final long[] data;
		int bitCount;

		BitArray(long bits) {
			this(new long[Ints.checkedCast(bits / 64)]);
		}

		// Used by serialization
		BitArray(long[] data) {
			checkArgument(data.length > 0, "data length is zero!");
			this.data = data;
			int bitCount = 0;
			for (long value : data) {
				bitCount += Long.bitCount(value);
			}
			this.bitCount = bitCount;
		}

		/** Returns true if the bit changed value. */
		boolean set(int index) {
			if (!get(index)) {
				data[index >> 6] |= (1L << index);
				bitCount++;
				return true;
			}
			return false;
		}

		boolean get(int index) {
			return (data[index >> 6] & (1L << index)) != 0;
		}

		/** Number of bits */
		int size() {
			return data.length * Long.SIZE;
		}

		/** Number of set bits (1s) */
		int bitCount() {
			return bitCount;
		}

		BitArray copy() {
			return new BitArray(data.clone());
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof BitArray) {
				BitArray bitArray = (BitArray) o;
				return Arrays.equals(data, bitArray.data);
			}
			return false;
		}

		@Override
		public int hashCode() {
			return Arrays.hashCode(data);
		}
	}

	public long hashString(CharSequence input) {
		return new Murmur3_128Hasher(16).putString(input).hash();
	}


	private static class Murmur3_128Hasher {
		/** Buffer via which we pass data to the hash algorithm (the implementor) */
		private final ByteBuffer buffer;

		/** Number of bytes processed per process() invocation. */
		private final int chunkSize;

		private static final int CHUNK_SIZE = 16;
		private static final long C1 = 0x87c37b91114253d5L;
		private static final long C2 = 0x4cf5ad432745937fL;
		private long h1;
		private long h2;
		private int length;

		Murmur3_128Hasher(int size) {
			this.buffer = ByteBuffer.allocate(size + 7) // always space for a single primitive
					.order(ByteOrder.LITTLE_ENDIAN);
			this.chunkSize = size;
			this.h1 = CHUNK_SIZE;
			this.h2 = CHUNK_SIZE;
			this.length = 0;
		}

		public final Murmur3_128Hasher putString(CharSequence charSequence) {
			for (int i = 0; i < charSequence.length(); i++) {
				putChar(charSequence.charAt(i));
			}
			return this;
		}

		public final Murmur3_128Hasher putChar(char c) {
			buffer.putChar(c);
			munchIfFull();
			return this;
		}

		public final long hash() {
			munch();
			buffer.flip();
			if (buffer.remaining() > 0) {
				processRemaining(buffer);
			}
			return makeHash();
		}

		// Process pent-up data in chunks
		private void munchIfFull() {
			if (buffer.remaining() < 8) {
				// buffer is full; not enough room for a primitive. We have at least one full chunk.
				munch();
			}
		}

		private void munch() {
			buffer.flip();
			while (buffer.remaining() >= chunkSize) {
				// we could limit the buffer to ensure process() does not read more than
				// chunkSize number of bytes, but we trust the implementations
				process(buffer);
			}
			buffer.compact(); // preserve any remaining data that do not make a full chunk
		}

		protected void process(ByteBuffer bb) {
			long k1 = bb.getLong();
			long k2 = bb.getLong();
			bmix64(k1, k2);
			length += CHUNK_SIZE;
		}

		private void bmix64(long k1, long k2) {
			h1 ^= mixK1(k1);

			h1 = Long.rotateLeft(h1, 27);
			h1 += h2;
			h1 = h1 * 5 + 0x52dce729;

			h2 ^= mixK2(k2);

			h2 = Long.rotateLeft(h2, 31);
			h2 += h1;
			h2 = h2 * 5 + 0x38495ab5;
		}

		protected void processRemaining(ByteBuffer bb) {
			long k1 = 0;
			long k2 = 0;
			length += bb.remaining();
			switch (bb.remaining()) {
				case 15:
					k2 ^= (long) toInt(bb.get(14)) << 48; // fall through
				case 14:
					k2 ^= (long) toInt(bb.get(13)) << 40; // fall through
				case 13:
					k2 ^= (long) toInt(bb.get(12)) << 32; // fall through
				case 12:
					k2 ^= (long) toInt(bb.get(11)) << 24; // fall through
				case 11:
					k2 ^= (long) toInt(bb.get(10)) << 16; // fall through
				case 10:
					k2 ^= (long) toInt(bb.get(9)) << 8; // fall through
				case 9:
					k2 ^= toInt(bb.get(8)); // fall through
				case 8:
					k1 ^= bb.getLong();
					break;
				case 7:
					k1 ^= (long) toInt(bb.get(6)) << 48; // fall through
				case 6:
					k1 ^= (long) toInt(bb.get(5)) << 40; // fall through
				case 5:
					k1 ^= (long) toInt(bb.get(4)) << 32; // fall through
				case 4:
					k1 ^= (long) toInt(bb.get(3)) << 24; // fall through
				case 3:
					k1 ^= (long) toInt(bb.get(2)) << 16; // fall through
				case 2:
					k1 ^= (long) toInt(bb.get(1)) << 8; // fall through
				case 1:
					k1 ^= toInt(bb.get(0));
					break;
				default:
					throw new AssertionError("Should never get here.");
			}
			h1 ^= mixK1(k1);
			h2 ^= mixK2(k2);
		}

		public long makeHash() {
			h1 ^= length;
			h2 ^= length;

			h1 += h2;
			h2 += h1;

			h1 = fmix64(h1);
			h2 = fmix64(h2);

			h1 += h2;
			h2 += h1;

			return fromBytesNoCopy(ByteBuffer
					.wrap(new byte[CHUNK_SIZE])
					.order(ByteOrder.LITTLE_ENDIAN)
					.putLong(h1)
					.putLong(h2)
					.array());
		}

		private static long fmix64(long k) {
			k ^= k >>> 33;
					k *= 0xff51afd7ed558ccdL;
					k ^= k >>> 33;
					k *= 0xc4ceb9fe1a85ec53L;
					k ^= k >>> 33;
					return k;
		}

		private static long mixK1(long k1) {
			k1 *= C1;
			k1 = Long.rotateLeft(k1, 31);
			k1 *= C2;
			return k1;
		}

		private static long mixK2(long k2) {
			k2 *= C2;
			k2 = Long.rotateLeft(k2, 33);
			k2 *= C1;
			return k2;
		}
	}

	private static long fromBytesNoCopy(byte[] bytes) {
		return (bytes[0] & 0xFFL)
				| ((bytes[1] & 0xFFL) << 8)
				| ((bytes[2] & 0xFFL) << 16)
				| ((bytes[3] & 0xFFL) << 24)
				| ((bytes[4] & 0xFFL) << 32)
				| ((bytes[5] & 0xFFL) << 40)
				| ((bytes[6] & 0xFFL) << 48)
				| ((bytes[7] & 0xFFL) << 56);
	}

}

