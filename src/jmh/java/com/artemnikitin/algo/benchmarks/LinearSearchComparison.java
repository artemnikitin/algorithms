package com.artemnikitin.algo.benchmarks;

import java.util.concurrent.TimeUnit;

import com.artemnikitin.algo.benchmarks.support.ArrayGeneration;
import com.artemnikitin.algo.search.LinearSearch;
import com.artemnikitin.algo.search.SentinelLinearSearch;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Timeout(time = 10, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1)
public class LinearSearchComparison {

    int[] array;

    @Setup
    public void setup() {
        array = ArrayGeneration.generateArray(100_000);
    }

    @Benchmark
    public void SimpleLinear() {
        LinearSearch.searchFor(array, 4);
    }

    @Benchmark
    public void SentinelLinear() {
        SentinelLinearSearch.search(array, 4);
    }

}
