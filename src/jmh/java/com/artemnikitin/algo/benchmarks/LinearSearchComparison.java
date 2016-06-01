package com.artemnikitin.algo.benchmarks;

import com.artemnikitin.algo.benchmarks.support.ArrayGeneration;
import com.artemnikitin.algo.search.LinearSearch;
import com.artemnikitin.algo.search.SentinelLinearSearch;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Timeout(time = 10, timeUnit = TimeUnit.SECONDS)
@Fork(value = 2)
public class LinearSearchComparison {

    int[] array;

    @Setup
    public void setup() {
        array = ArrayGeneration.generateArray(100_000);
    }

    @Benchmark
    public void simpleLinear() {
        LinearSearch.searchFor(array, 4);
    }

    @Benchmark
    public void sentinelLinear() {
        SentinelLinearSearch.search(array, 4);
    }

}
