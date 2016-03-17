package com.artemnikitin.algo.benchmarks;

import com.artemnikitin.algo.benchmarks.support.ArrayGeneration;
import com.artemnikitin.algo.search.BinarySearch;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Timeout(time = 10, timeUnit = TimeUnit.SECONDS)
@Fork(value = 2)
public class BinarySearchComparison {

    int[] array;

    @Setup
    public void setup() {
        array = ArrayGeneration.sorted(100_000);
    }

    @Benchmark
    public void recursiveBinarySearch() {
        BinarySearch.recursive(array, 0, array.length - 1, 4);
    }

    @Benchmark
    public void iterativeBinarySearch() {
        BinarySearch.iterative(array, 0, array.length - 1, 4);
    }

}
