package com.modular.CurrentAccountService.factory;

import com.modular.CurrentAccountService.constant.Currency;
import org.springframework.util.ConcurrentReferenceHashMap;

public class MutexFactory {

    private static final ConcurrentReferenceHashMap<String, Object> map = new ConcurrentReferenceHashMap<>();

    public static Object get(Long accountID, Currency currency) {
        String key = accountID + currency.toString();
        return get(key);
    }

    public static Object get(String key) {
        return map.compute(key, (k, v) -> (v == null) ? new Object() : v);
    }

}
