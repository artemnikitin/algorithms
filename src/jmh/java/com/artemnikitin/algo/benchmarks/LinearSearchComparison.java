package com.artemnikitin.algo.benchmarks;

import java.util.concurrent.TimeUnit;

import com.artemnikitin.algo.benchmarks.support.ArrayGeneration;
import com.artemnikitin.algo.search.LinearSearch;
import com.artemnikitin.algo.search.SentinelLinearSearch;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
@Timeout(time=25)
public class LinearSearchComparison {

    int[] array1;
    int[] array2;

    @Setup
    public void setup() {
        array1 = ArrayGeneration.generateArray(100_000);
        array2 = array1;
    }

    @Benchmark
    public void SimpleLinear() {
        LinearSearch.searchFor(array1, 4);
    }

    @Benchmark
    public void SentinelLinear() {
        SentinelLinearSearch.search(array2, 4);
    }

}
