package com.gangofdevelopers.recipes.common;

public interface IMapper<T, K> {
    T map(K inputData);
}
