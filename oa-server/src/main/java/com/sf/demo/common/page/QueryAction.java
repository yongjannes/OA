package com.sf.demo.common.page;

import java.util.List;

@FunctionalInterface
public interface QueryAction<T> {
    List<T> executeQuery() throws Exception;
}
